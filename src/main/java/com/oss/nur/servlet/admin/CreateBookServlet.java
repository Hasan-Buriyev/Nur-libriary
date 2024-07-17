package com.oss.nur.servlet.admin;

import com.oss.nur.entity.Attachment;
import com.oss.nur.entity.Book;
import com.oss.nur.entity.Genre;
import com.oss.nur.entity.User;
import com.oss.nur.repository.AttachmentRepository;
import com.oss.nur.repository.BookRepository;
import com.oss.nur.repository.GenreRepository;
import com.oss.nur.repository.UserRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

@MultipartConfig
@WebServlet(name = "CreateBook", value = "/admin/create-book")
public class CreateBookServlet extends HttpServlet {
    private static final UserRepository userRepository = UserRepository.getInstance();
    private static final GenreRepository genreRepository = GenreRepository.getInstance();
    private static final BookRepository bookRepository = BookRepository.getInstance();
    private static final AttachmentRepository attachment = AttachmentRepository.getInstance();

    private static final String fileUrl = "D:\\Project in java\\Modullar\\nur\\src\\main\\resources\\book_file\\";
    private static final String imageUrl = "D:\\Project in java\\Modullar\\nur\\src\\main\\resources\\book_img\\";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/admin/create-book.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        String author = req.getParameter("author");
        String description = req.getParameter("description");
        Part fileData = req.getPart("file_data");
        String fileName = fileData.getSubmittedFileName();
//        String contentType = fileData.getContentType();
        String dataType = fileName.substring(fileName.lastIndexOf(".") + 1);
        byte[] dataBytes = fileData.getInputStream().readAllBytes();

        Part fileImg = req.getPart("file_img");
        String imgName = fileImg.getSubmittedFileName();
        String imgType = imgName.substring(imgName.lastIndexOf(".") + 1);
        byte[] imgBytes = fileImg.getInputStream().readAllBytes();
        String[] genres = req.getParameterValues("genres[]");
        List<Genre> genreList = new ArrayList<>();
        for (String genre : genres) {
            Optional<Genre> genreByName = genreRepository.getGenreByName(genre);
            if (genreByName.isPresent()) {
                genreList.add(genreByName.get());
            } else {
                genreRepository.save(new Genre(genre, List.of()));
            }
        }
        HttpSession session = req.getSession();
        String id = session.getAttribute("id").toString();
        System.out.println(id + " ================================");
        Optional<User> user = userRepository.findById(id);

        String generatedName = UUID.randomUUID().toString();

        if (user.isPresent()) {

            Attachment file = Attachment.builder()
                    .contentType(dataType)
                    .generatedName(generatedName)
                    .size((double) fileData.getSize() / (1024 * 1024))
                    .fileUrl(fileUrl + generatedName + "." + dataType)
                    .originalName(fileName)
                    .mimeType("application/octet-stream")
                    .build();

            Path path = Path.of(file.getFileUrl());
            Files.write(path, dataBytes);

            Attachment image = Attachment.builder()
                    .contentType(imgType)
                    .generatedName(generatedName)
                    .size((double) fileImg.getSize() / (1024 * 1024))
                    .fileUrl(imageUrl + generatedName + "." + imgType)
                    .originalName(imgName)
                    .mimeType("application/octet-stream")
                    .build();

            Files.write(Path.of(image.getFileUrl()), imgBytes);

            attachment.save(file);

            attachment.save(image);


            Book book = Book.builder()
                    .title(title)
                    .author(author)
                    .description(description)
                    .admin(user.get())
                    .genres(genreList)
                    .file_data(file)
                    .file_img(image)
                    .build();
            bookRepository.save(book);

        }
        resp.sendRedirect("/admin/book-list");

    }
}

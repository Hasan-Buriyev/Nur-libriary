package com.oss.nur.servlet.book;

import com.oss.nur.entity.Book;
import com.oss.nur.repository.BookRepository;
import com.oss.nur.repository.UserRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet(name = "AdminBook",value = "/admin/book-list")
public class AdminBookServlet extends HttpServlet {
    private static final BookRepository bookRepository = BookRepository.getInstance();

    private static final UserRepository userRepository = UserRepository.getInstance();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Optional<List<Book>> allBooks = bookRepository.getAllBooks();
        if (allBooks.isPresent()) {
            request.setAttribute("books", allBooks.get());
            request.getRequestDispatcher("/admin/book-list.jsp").forward(request, response);
        }else {
            request.getRequestDispatcher("/admin/book-list.jsp").forward(request, response);
        }

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

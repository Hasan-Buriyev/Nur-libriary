package com.oss.nur.servlet.book;

import com.oss.nur.entity.Book;
import com.oss.nur.entity.User;
import com.oss.nur.entity.enums.Status;
import com.oss.nur.repository.BookRepository;
import com.oss.nur.repository.UserRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.NonNull;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@WebServlet(name = "UserBookList", value = "/book/user-book-list")
public class UserBookListServlet extends HttpServlet {

    private static final BookRepository bookRepository = BookRepository.getInstance();


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            Optional<List<Book>> allBooks = bookRepository.getAllBooks();
            allBooks.ifPresent(books -> request.setAttribute("books", books));
            request.getRequestDispatcher("/book/user-book-list.jsp").forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

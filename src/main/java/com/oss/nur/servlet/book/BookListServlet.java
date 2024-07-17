package com.oss.nur.servlet.book;

import com.oss.nur.entity.Book;
import com.oss.nur.repository.BookRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@WebServlet(name = "HomeServlet",value = "/book-list")
public class BookListServlet extends HttpServlet {
    private static final BookRepository bookRepository=BookRepository.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Optional<List<Book>> allBooks = bookRepository.getAllBooks();
        if(allBooks.isPresent())
            req.setAttribute("books", allBooks.get());
        else
            req.setAttribute("books", new ArrayList<Book>());
        req.getRequestDispatcher("/book/book-list.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}

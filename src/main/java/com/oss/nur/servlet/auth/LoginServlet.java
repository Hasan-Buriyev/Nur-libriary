package com.oss.nur.servlet.auth;

import com.oss.nur.entity.User;
import com.oss.nur.entity.enums.Role;
import com.oss.nur.entity.enums.Status;
import com.oss.nur.repository.UserRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "LoginServlet", value = "/auth/login")
public class LoginServlet extends HttpServlet {
    private static final String url="http://localhost:8080";
    private static final UserRepository userRepository = UserRepository.getInstance();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/auth_user/login.jsp")
                .forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("emailOrUsername");
        String password = request.getParameter("password");
        Optional<User> orUsername = userRepository.findByEmailOrUsername(username);
        if (orUsername.isEmpty()) {
            request.setAttribute("error", "Invalid username or password");
            response.sendRedirect("/auth/login");
        }else {
            User user = orUsername.get();
            if (user.getStatus().equals(Status.INACTIVE)){
                request.setAttribute("username", user.getUsername());
                request.setAttribute("isActivate",false);
                response.sendRedirect("/login/error");
                return;
            }

            if (password.equals(user.getPassword())) {
                HttpSession session=request.getSession();
                session.setAttribute("id", user.getId());
                session.setAttribute("username", username);
                session.setAttribute("email", user.getEmail());
                session.setAttribute("role", user.getRole());
                if (user.getRole().equals(Role.ADMIN)){
                    session.setAttribute("isAdmin", true);
                    response.sendRedirect("/admin/book-list");
                }else
                    response.sendRedirect("/book/user-book-list");
            }else {
                request.setAttribute("error", "Invalid username or password");
                response.sendRedirect("/auth/login");
            }
        }
    }
}

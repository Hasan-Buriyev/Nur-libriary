package com.oss.nur.servlet.auth;

import com.oss.nur.entity.User;
import com.oss.nur.entity.enums.Status;
import com.oss.nur.repository.UserRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "activate",urlPatterns = "/auth/activate/*")
public class ActivateServlet extends HttpServlet {
    private static final UserRepository userRepository=UserRepository.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String url = req.getPathInfo();
        if (url != null && url.length() > 1) {
            String id = url.substring(1);
            Optional<User> optional = userRepository.findById(id);
            if (optional.isPresent()) {
                User user = optional.get();
                req.setAttribute("username", user.getUsername());
                if (user.getStatus().equals(Status.ACTIVE)) {
                    req.setAttribute("isActivate",false);
                    req.getRequestDispatcher("/auth_user/activation.jsp").forward(req, resp);
                    return;
                }
                user.setStatus(Status.ACTIVE);
                userRepository.update(user);
                req.setAttribute("isActivate",true);
                req.getRequestDispatcher("/auth_user/activation.jsp").forward(req, resp);
                return;
            }else {
                req.setAttribute("isActivate",null);
                req.getRequestDispatcher("/auth_user/activation.jsp").forward(req, resp);
                System.out.println("Extracted ID: " + id);
                return;
            }
        } else {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Not a valid URL");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}

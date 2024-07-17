package com.oss.nur.servlet.auth;

import com.oss.nur.entity.User;
import com.oss.nur.entity.enums.Gender;
import com.oss.nur.entity.enums.Role;
import com.oss.nur.entity.enums.Status;
import com.oss.nur.repository.UserRepository;
import com.oss.nur.utils.Email;
import com.oss.nur.utils.StringUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@WebServlet(name = "Register", value = "/auth/register")
public class RegisterServlet extends HttpServlet {
    private static final String url = "http://localhost:8080/auth/activate/";
    private static final UserRepository userRepository=UserRepository.getInstance();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/auth_user/register.jsp")
                .forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");
        Map<String,String> errors = new HashMap<>();
        Optional<User> orUsername = userRepository.findByEmailOrUsername(username);
        Optional<User> orEmail = userRepository.findByEmailOrUsername(email);

        if (!StringUtils.isValidEmail(email)){
            errors.put("email_error", "Invalid email");
        }
        if (!StringUtils.checkPassword(password)){
            errors.put("password_error", "Invalid password");
        }
        if (!Objects.equals(password, confirmPassword)){
            errors.put("confirm_password_error", "Passwords do not match");
        }
        if (orUsername.isPresent() || orEmail.isPresent()){
            errors.clear();
        }

        if (orUsername.isPresent()) {
            errors.put("username_error", "Username already exists");
        }
        if (orEmail.isPresent()) {
            errors.put("email_error", "Email already exists");
        }

        if (!errors.isEmpty()) {
            errors.forEach(request::setAttribute);
            request.getRequestDispatcher("/auth_user/register.jsp")
                    .forward(request, response);
            return;
        }
        Gender gender = Gender.valueOf(request.getParameter("gender"));

        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);
        user.setGender(gender);
        user.setRole(Role.USER);
        user.setStatus(Status.INACTIVE);

        userRepository.save(user);

        Email.sendEmail(user.getEmail(),user.getUsername(),url+user.getId());


        HttpSession session=request.getSession();
        session.setAttribute("id", user.getId());
        session.setAttribute("username", username);
        session.setAttribute("email", email);
        session.setAttribute("role", user.getRole());
        response.sendRedirect("/auth/login");

    }
}

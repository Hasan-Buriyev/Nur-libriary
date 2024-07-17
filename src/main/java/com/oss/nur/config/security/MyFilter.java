package com.oss.nur.config.security;

import com.oss.nur.entity.enums.Role;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

@WebFilter(filterName = "myFilter", urlPatterns = "/*")
public class MyFilter implements Filter {

    public static final List<String> WHITE_LIST = List.of(
            "/book/list",
            "/auth/register",
            "/auth/login"
    );

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        /*String requestURI = request.getRequestURI();

        if (!WHITE_LIST.contains(requestURI)) {
            HttpSession session = request.getSession();
            Object id = session.getAttribute("id");
            Object role = session.getAttribute("role");

            if (Objects.isNull(id)) {
                response.sendRedirect("/auth/login");
            } else if (
                    requestURI.startsWith("/admin") &&
                            !Objects.equals(role, Role.ADMIN)
            ) {
                response.sendError(404, "Not Found");
            } else {
                filterChain.doFilter(request, response);
            }

        } else {
            filterChain.doFilter(request, response);
        }*/
        filterChain.doFilter(request, response);


    }
}

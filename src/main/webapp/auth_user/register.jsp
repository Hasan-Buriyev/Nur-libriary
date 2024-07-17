<%@ page import="java.util.Objects" %><%--
  Created by IntelliJ IDEA.
  User: hasan
  Date: 7/10/2024
  Time: 2:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
    <jsp:include page="../fragment/css.jsp"/>
    <style>
        /* Customize body styles if needed */
        body {
            background-color: #f8f9fa; /* Orqa fon rangi */
            margin: 0;
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
        }
        .form-container {
            background-color: #ffffff; /* Forma konteyneri rangi */
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            width: 100%; /* Konteynerning to'liq eni */
            max-width: 400px; /* Konteynerning maksimal eni */
        }
    </style>
</head>

<body>
<div class="container mt-6" style="margin: auto">
    <div class="row justify-content-center">
        <div class="col-md-8">
            <div class="form-container">
                <form method="post" action="/auth/register">
                    <div class="mb-3">
                        <label for="email" class="form-label">Email address</label>
                        <input type="text" class="form-control" id="email" name="email" aria-describedby="emailHelp">
                        <% if (Objects.nonNull(request.getAttribute("email_error"))) { %>
                        <span style="color: red">*${email_error}</span>
                        <% session.removeAttribute("email_error");}%>
                    </div>
                    <div class="mb-3">
                        <label for="username" class="form-label">Username</label>
                        <input type="text" class="form-control" id="username" name="username" aria-describedby="emailHelp">
                        <% if (Objects.nonNull(request.getAttribute("username_error"))) { %>
                        <span style="color: red">*${username_error}</span>
                        <% session.removeAttribute("username_error");}%>
                    </div>
                    <div class="mb-3">
                        <label for="gen" class="form-label">Gender</label>
                        <select class="form-select" id="gen" name="gender" aria-label="Default select example">
                            <option value="MALE">Male</option>
                            <option value="FEMALE">Female</option>
                        </select>
                    </div>
                    <div class="mb-3">
                        <label for="pass_id" class="form-label">Password</label>
                        <input type="password" class="form-control" id="pass_id" name="password">
                        <% if (Objects.nonNull(request.getAttribute("password_error"))) { %>
                        <span style="color: red">*${password_error}</span>
                        <% session.removeAttribute("password_error");}%>
                    </div>
                    <div class="mb-3">
                        <label for="pass_id_con" class="form-label">Confirm password</label>
                        <input type="password" class="form-control" id="pass_id_con" name="confirmPassword">
                        <% if (Objects.nonNull(request.getAttribute("confirm_password_error"))) { %>
                        <span style="color: red">*${confirm_password_error}</span>
                        <% session.removeAttribute("confirm_password_error");}%>
                    </div>
                    <button type="submit" class="btn btn-primary">Register</button>
                    <a class="btn btn-warning" href="/auth/login">Login</a>
                </form>
            </div>
        </div>
    </div>
</div>

<script src="https://stackpath.bootstrapcdn.com/bootstrap/5.1.3/js/bootstrap.bundle.min.js"></script>
</body>

</html>

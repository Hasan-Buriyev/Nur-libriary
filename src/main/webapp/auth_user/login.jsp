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
    <title>Log In</title>
    <jsp:include page="../fragment/css.jsp"/>
    <style>
        body {
            background-color: #f8f9fa; /* Orqa fon rangi */
        }

        .login-container {
            background-color: #ffffff; /* Login konteyneri rangi */
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            margin-top: 50px; /* yuqori qismi yuqoridagi stiliga qo'shiladi */
        }
    </style>
</head>

<body class="bg-light">
<div class="container">
    <div class="row justify-content-center align-items-center vh-100">
        <div class="col-md-6">
            <div class="login-container">
                <form method="post" action="/auth/login">
                    <div class="mb-3">
                        <label for="username" class="form-label">Username</label>
                        <input type="text" class="form-control" id="username" name="emailOrUsername"
                               aria-describedby="emailHelp" placeholder="Enter username or email">
                        <%if (!Objects.nonNull(request.getAttribute("error"))){%>
                        <div id="emailHelp" style="color: red" class="form-text">${error}</div>
                        <%}else {%>
                        <div id="emailHelp" class="form-text">
                            We'll never share your email with anyone else.</div>
                        <%}%>
                    </div>
                    <div class="mb-3">
                        <label for="password" class="form-label">Password</label>
                        <input type="password" class="form-control" name="password" id="password">
                    </div>
                    <!-- Uncomment this block if you need a checkbox
            <div class="mb-3 form-check">
                <input type="checkbox" class="form-check-input" id="exampleCheck1">
                <label class="form-check-label" for="exampleCheck1">Check me out</label>
            </div>
            -->
                    <button type="submit" class="btn btn-primary">Submit</button>
                    <a class="btn btn-success" href="/auth/register">Sign up </a>
                </form>
            </div>
        </div>
    </div>
</div>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/5.1.3/js/bootstrap.bundle.min.js"></script>
</body>

</html>
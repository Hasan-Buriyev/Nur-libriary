<%--
  Created by IntelliJ IDEA.
  User: hasan
  Date: 7/12/2024
  Time: 12:48 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error</title>
    <style>
        body, html {
            height: 100%;
            margin: 0;
            display: flex;
            align-items: center;
            justify-content: center;
            background-color: #f8f9fa;
        }

        .error-container {
            text-align: center;
        }
    </style>
</head>
<body>
<div class="error-container">
    <div class="alert alert-danger" role="alert">
        <h4 class="alert-heading"><%=request.getAttribute("error_menu")%></h4>
        <p><%request.getAttribute("error_data");%></p>
    </div>
    <a href="<%request.getAttribute("back_link");%>" class="btn btn-primary">Bosh sahifaga qaytish</a>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>

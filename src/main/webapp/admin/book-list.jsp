<%--
  Created by IntelliJ IDEA.
  User: hasan
  Date: 7/16/2024
  Time: 2:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="com.oss.nur.entity.Book" %>
<%@ page import="java.util.List" %>
<%@ page import="com.oss.nur.utils.EncodingDecoding" %>
<html>
<head>
    <title>Nur</title>
    <jsp:include page="../fragment/css.jsp"/>
</head>
<body>
<jsp:include page="../fragment/admin-navbar.jsp"/>
<div class="container">

    <h1 class="mt-4 mb-4">Kitoblar Ro'yxati</h1>
    <div class="row">
        <% List<Book> books = (List<Book>)request.getAttribute("books");%>
        <%for (Book book : books) {%>
        <div class="col-md-4">
            <div class="book-info">
                <img src="data:image/png;base64, <%=EncodingDecoding.encoding(book.getFile_img().getFileUrl())%>" alt="<%=book.getTitle()%>" class="img-fluid rounded">
                <div>
                    <p class="font-weight-bold mb-1">Kitob nomi:</p>
                    <p><%=book.getTitle()%></p>
                    <p class="font-weight-bold mb-1">Avtor:</p>
                    <p><%=book.getAuthor()%></p>
                    <p class="font-weight-bold mb-1">Hajmi:</p>
                    <p><%=book.getFile_data().getSize()%> MB</p>
                    <p class="font-weight-bold mb-1">Type:</p>
                    <p><%=book.getFile_data().getContentType()%> MB</p>
                    <a href="#" class="btn btn-primary">Download</a>
                </div>
            </div>
        </div>
        <%}%>
    </div>
</div>

</body>
</html>

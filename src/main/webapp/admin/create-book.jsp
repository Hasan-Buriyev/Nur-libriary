<%@ page import="java.util.Objects" %><%--
  Created by IntelliJ IDEA.
  User: hasan
  Date: 7/10/2024
  Time: 2:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Book From</title>
    <jsp:include page="../fragment/css.jsp"/>
</head>

<body>
<div class="container mt-5">
    <div class="card">
        <div class="card-header text-center">
            <h1>Book Form</h1>
        </div>
        <div class="card-body">
            <form method="post" enctype="multipart/form-data">
                <div class="form-group">
                    <label for="title">Title</label>
                    <input type="text" class="form-control" id="title" name="title" required>
                </div>
                <div class="form-group">
                    <label for="author">Author</label>
                    <input type="text" class="form-control" id="author" name="author">
                </div>
                <div class="form-group">
                    <label for="description">Description</label>
                    <textarea class="form-control" id="description" name="description"></textarea>
                </div>
                <div class="form-group">
                    <label for="file_data">File Data</label>
                    <div class="custom-file">

                        <input type="file" class="custom-file-input btn btn-secondary" id="file_data" name="file_data">

                    </div>

                    <label for="file_img">File Image</label>
                    <div class="custom-file">

                        <input type="file" class="custom-file-input btn btn-secondary" id="file_img" name="file_img">

                    </div>

                </div>

                <div class="form-group">
                    <label>Genres</label><br>
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="checkbox" id="genreFiction" name="genres[]" value="fiction">
                        <label class="form-check-label" for="genreFiction">Fiction</label>
                    </div>
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="checkbox" id="genreNonFiction" name="genres[]" value="non-fiction">
                        <label class="form-check-label" for="genreNonFiction">Non-Fiction</label>
                    </div>
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="checkbox" id="genreFantasy" name="genres[]" value="fantasy">
                        <label class="form-check-label" for="genreFantasy">Fantasy</label>
                    </div>
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="checkbox" id="genreScienceFiction" name="genres[]" value="science-fiction">
                        <label class="form-check-label" for="genreScienceFiction">Science Fiction</label>
                    </div>
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="checkbox" id="genreMystery" name="genres[]" value="mystery">
                        <label class="form-check-label" for="genreMystery">Mystery</label>
                    </div>
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="checkbox" id="genreRomance" name="genres[]" value="romance">
                        <label class="form-check-label" for="genreRomance">Romance</label>
                    </div>
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="checkbox" id="genreHorror" name="genres[]" value="horror">
                        <label class="form-check-label" for="genreHorror">Horror</label>
                    </div>
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="checkbox" id="genreThriller" name="genres[]" value="thriller">
                        <label class="form-check-label" for="genreThriller">Thriller</label>
                    </div>
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="checkbox" id="genreBiography" name="genres[]" value="biography">
                        <label class="form-check-label" for="genreBiography">Biography</label>
                    </div>
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="checkbox" id="genreHistory" name="genres[]" value="history">
                        <label class="form-check-label" for="genreHistory">History</label>
                    </div>
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>

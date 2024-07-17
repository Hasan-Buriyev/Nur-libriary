<%--
  Created by IntelliJ IDEA.
  User: hasan
  Date: 7/15/2024
  Time: 8:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Activity</title>
    <jsp:include page="../fragment/css.jsp"/>
    <style>
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background-color: #f4f4f9;
        }
        .activity-box {
            text-align: center;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            background-color: #fff;
        }
        .active {
            color: green;
        }
        .inactive {
            color: red;
        }
    </style>
</head>
<body>

<div class="activity-box">
    <h1>User Activity Status</h1>
    <% Boolean isActivate = (Boolean) request.getAttribute("isActivate");%>
    <%if (isActivate==null){%>
    <p class="active">User not found. Please register again</p>
    <%} else if (isActivate) {%>
    <p class="active"><%=request.getAttribute("username")%> is active</p>
    <%}else {%>
    <p class="inactive"><%=request.getAttribute("username")%> is al ready active</p>
    <%}%>
</div>

</body>
</html>

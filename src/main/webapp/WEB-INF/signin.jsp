<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 13/06/2024
  Time: 14:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Connexion</title>
    <%@ include file="/WEB-INF/bootstrap.html" %>
</head>
<body>
<br>
<div class="container-sm">
<form method="post" action="${pageContext.request.contextPath}/user">
    <div class="mb-3 row">
        <label for="inputEmail" class="col-sm-2 col-form-label">Email</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" id="inputEmail" placeholder="email@example.com">
        </div>
    </div>
    <div class="mb-3 row">
        <label for="inputPassword" class="col-sm-2 col-form-label">Password</label>
        <div class="col-sm-10">
            <input type="password" class="form-control" id="inputPassword">
        </div>
    </div>
    <div class="mb-3 row">
        <div class="col-sm-10 offset-2">
            <button type="submit" class="btn btn-primary">Connexion</button>
        </div>
    </div>
</form>
</div>
</body>
</html>

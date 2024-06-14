<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Connexion</title>
    <%@ include file="/WEB-INF/bootstrap.html" %>
</head>
<body>
<br>
<div class="container-sm">
<form method="post" action="${pageContext.request.contextPath}/user/signin">
    <div class="mb-3 row">
        <label for="inputEmail" class="col-sm-2 col-form-label">Email</label>
        <div class="col-sm-10">
            <input type="email" class="form-control" id="inputEmail" name="inputEmail" placeholder="email@example.com" required>
        </div>
    </div>
    <div class="mb-3 row">
        <label for="inputPassword" class="col-sm-2 col-form-label">Mot de passe</label>
        <div class="col-sm-10">
            <input type="password" class="form-control" id="inputPassword" name="inputPassword" required>
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

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Inscription</title>
    <%@ include file="/WEB-INF/bootstrap.html" %>
</head>
<body>

<h1>Inscription</h1>
<br>

<div class=" container-sm">
    <form action="${pageContext.request.contextPath}/user/signup" method="post">
        <div class="mb-3 row">
            <label for="inputEmail" class="col-sm-2 col-form-label">Email</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="inputEmail" name="inputEmail" required>
            </div>
        </div>

        <div class="mb-3 row">
            <label for="inputPassword" class="col-sm-2 col-form-label">Mot de passe</label>
            <div class="col-sm-10">
                <input type="password" class="form-control" id="inputPassword" name="inputPassword" required>
            </div>
        </div>

        <div class="mb-3 row">
            <label for="inputName" class="col-sm-2 col-form-label">Nom</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="inputName" name="inputName" required>
            </div>
        </div>
        <button type="submit" class="btn btn-primary">Inscription</button>

    </form>


</div>

</body>
</html>

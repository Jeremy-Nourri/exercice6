<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ajouter un produit</title>
</head>
<body>

<h1>Ajouter un produit</h1>

<div class="container-sm">

<form action="${pageContext.request.contextPath}/product/add" method="post">
    <div class="mb-3">
        <label for="reference" class="form-label">Référence</label>
        <input type="text" class="form-control" id="reference" name="reference" required>
    </div>
    <div class="mb-3">
        <label for="brand" class="form-label">Marque</label>
        <input type="text" class="form-control" id="brand" name="brand" required>
    </div>
    <div class="mb-3">
        <label for="dateOfPurchase" class="form-label">Date d'achat</label>
        <input type="date" class="form-control" id="dateOfPurchase" name="dateOfPurchase" required>
    </div>
    <div class="mb-3">
        <label for="price" class="form-label">Prix</label>
        <input type="number" class="form-control" id="price" name="price" required>
    </div>
    <div class="mb-3">
        <label for="stock" class="form-label">Stock</label>
        <input type="number" class="form-control" id="stock" name="stock" required>
    </div>
    <button type="submit" class="btn btn-primary">Ajouter</button>
</form>
</div>

</body>
</html>

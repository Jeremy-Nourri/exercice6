<%@ page import="org.example.exercice6produitsj2ee.model.Product" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:useBean id="productList" class="java.util.ArrayList" scope="request"/>
<jsp:useBean id="user" class="org.example.exercice6produitsj2ee.model.User" scope="request"/>
    <html>
    <head>
    <title>Liste des produits</title>
    </head>
    <body>
        <p>Bonjour <%= user.getName() %></p>
        <h1>Voici la liste des produits</h1>
        <% if (!productList.isEmpty()) { %>
        <table class="table table-dark align-middle table-striped text-center">
        <thead>
            <tr>
                <th>Référence</th>
                <th>Marque</th>
                 <th>Date d'achat</th>
                <th>Prix</th>
                <th>Stock</th>
            </tr>
    </thead>
    <tbody>
    <% for (Object obj : productList) {
        Product product = (Product) obj;
    %>
        <tr>
            <td><%= product.getReference() %></td>
            <td><%= product.getBrand() %></td>
            <td><%= product.getDateOfPurchase() %></td>
            <td><%= product.getPrice() %></td>
            <td><%= product.getStock() %></td>
        </tr>
    <% } %>
    </tbody>
    </table>
    <% } else { %>
        <p>Aucun produit n'est disponible</p>
    <% } %>
    <hr>
    <div class="text-end">
    <a href="${pageContext.request.contextPath}/product/add" class="btn btn-outline-success"><i
    class="bi bi-plus-circle"></i> Ajouter un produit</a>
    </div>


    </body>
    </html>

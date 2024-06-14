package org.example.exercice6produitsj2ee.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.exercice6produitsj2ee.model.Product;
import org.example.exercice6produitsj2ee.service.ProductService;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet(name = "productServlet", value = "/product/*")
public class ProductServlet extends HttpServlet {

    ProductService productService;

    @Override
    public void init() {
        productService = new ProductService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String path = request.getPathInfo();
        switch (path) {
            case "/list":
                listProduct(request, response);
                break;
           case "/add":
               addProduct(request, response);
//                break;
//            case "/form":
//                formProduct(request, response);
//                break;
            default:
                response.sendRedirect("index.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        doGet(req, resp);
    }

    private void listProduct(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<Product> productList = productService.findAll();
        request.setAttribute("productList", productList);
        request.getRequestDispatcher("/WEB-INF/productlist.jsp").forward(request, response);
    }

    private void addProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String brand = request.getParameter("brand");
        String reference = request.getParameter("reference");
        LocalDate dateOfPurchase = LocalDate.parse(request.getParameter("dateOfPurchase"));
        double price = Double.parseDouble(request.getParameter("price"));
        int stock = Integer.parseInt(request.getParameter("stock"));

        productService.add(brand, reference, dateOfPurchase, price, stock);
        response.sendRedirect("list");
    }


}

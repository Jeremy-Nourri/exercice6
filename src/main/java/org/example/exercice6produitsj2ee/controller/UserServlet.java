package org.example.exercice6produitsj2ee.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.exercice6produitsj2ee.model.User;
import org.example.exercice6produitsj2ee.service.UserService;

import java.io.IOException;

@WebServlet(name = "userServlet", value = "/user/*")
public class UserServlet extends HttpServlet {

    private UserService userService;

    @Override
    public void init() throws ServletException {
        userService = new UserService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getPathInfo();
        switch (path) {
            case "/signup":
                signUp(request, response);
                break;
            case "/pagesignup":
                signUpPage(request, response);
                break;
            case "/pagesignin":
                signInPage(request, response);
                break;
            case "/signin":
                signIn(request, response);
                break;
            default:
                response.sendRedirect("index.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    private void signUpPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/signup.jsp").forward(request, response);
    }

    private void signUp(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String email = request.getParameter("inputEmail");
        String password = request.getParameter("inputPassword");
        String name = request.getParameter("inputName");

        userService.signUp(name, email, password);

        response.sendRedirect("pagesignin");

    }

    private void signInPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/signin.jsp").forward(request, response);
    }

    private void signIn(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String email = request.getParameter("inputEmail");
        String password = request.getParameter("inputPassword");

        User user = userService.signin(email, password);

        if (user != null) {
            request.getSession().setAttribute("user", user);
            HttpSession session = request.getSession();
            session.setAttribute("isLogged",true);
            response.sendRedirect(getServletContext().getContextPath()+"/product/list");

        } else {
            response.sendRedirect("index.jsp");
        }

    }
}


package controller;

import model.Product;
import model.User;
import storage.Products;
import storage.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Optional;

@WebServlet("/user/product")
public class ProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/products.jsp").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String productName = req.getParameter("product");
        Optional<Product> optionalProduct = Products.getProducts().stream().filter(p -> p.getName().equals(productName)).findAny();

        if (optionalProduct.isPresent()) {
            User user = (User) req.getSession().getAttribute("me");
            user.getShoppingCart().addProduct(optionalProduct.get());
        }

        req.getRequestDispatcher("/WEB-INF/products.jsp").forward(req, resp);
    }
}

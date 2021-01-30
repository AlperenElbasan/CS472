package controller;

import model.Product;
import model.User;
import storage.Products;
import storage.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/auth")
public class AuthServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String rememberMe = req.getParameter("rememberMe");

        if (!(name.equals("admin") && password.equals("admin"))) {
            resp.setStatus(401);
            req.getSession().setAttribute("msg", "Wrong password or username!");
            resp.sendRedirect(req.getContextPath() + "/");
            return;
        }

        User user = new User(name, password);
        Users.add(user);

        Cookie cookie = new Cookie("Auth", user.getUuid());

        if (rememberMe != null)
            cookie.setMaxAge(60 * 60 * 24 * 30);

        resp.addCookie(cookie);


        HttpSession session = req.getSession();
        session.setAttribute("me", user);

        for (int i = 0; i < 10; i++) {
            Products.addProduct(new Product("Product" + i, i * 10));
        }

        resp.sendRedirect(req.getContextPath() + "/user/product");
    }
}

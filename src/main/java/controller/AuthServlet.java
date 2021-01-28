package controller;

import dao.UserDao;
import storage.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

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

        UserDao user = new UserDao(name, password);
        Users.add(user);

        Cookie cookie = new Cookie("Auth", user.getUuid());

        if (rememberMe != null)
            cookie.setMaxAge(60 * 60 * 24 * 30);

        resp.addCookie(cookie);

        resp.sendRedirect(req.getContextPath() + "/user/profile");
    }
}

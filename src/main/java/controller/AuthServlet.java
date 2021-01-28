package controller;

import dao.UserDao;
import storage.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;
import java.util.UUID;

@WebServlet("/auth")
public class AuthServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        Optional<UserDao> optionalUserDao = Users.getUsers().stream().filter(u -> u.getName().equals(name)).findAny();
        UserDao user;

        if (optionalUserDao.isPresent()) {
            user = optionalUserDao.get();

            if (!user.getPassword().equals(password)) {
                resp.setStatus(401);
                resp.getWriter().println("Wrong password");
                resp.sendRedirect(req.getContextPath() + "/");
                return;
            }
        } else {
            user = new UserDao(UUID.randomUUID().toString(), name, password);
            Users.addUser(user);
        }

        Cookie cookie = new Cookie("Auth", user.getUuid());
        cookie.setMaxAge(60 * 60 * 24 * 30);
        resp.addCookie(cookie);

        resp.sendRedirect(req.getContextPath() + "/user/profile");
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Optional<Cookie> cookieOptional = Arrays.stream(req.getCookies()).filter(c -> c.getName().equals("Auth")).findFirst();

        if (cookieOptional.isPresent()) {
            Cookie cookie = cookieOptional.get();
            cookie.setMaxAge(0); // delete the cookie
        }
    }
}

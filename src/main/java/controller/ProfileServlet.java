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
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Optional;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Optional<Cookie> cookie = Arrays.stream(req.getCookies())
                .filter(c -> c.getName().equals("Auth")).findFirst();

        PrintWriter respWriter = resp.getWriter();

        if (cookie.isEmpty()) {
            respWriter.println("Hello stranger!");
            return;
        }

        Optional<UserDao> user = Users.getUsers()
                .stream()
                .filter(u -> u.getUuid().equals(cookie.get().getValue()))
                .findAny();
        respWriter.println(
                user.isPresent()
                        ? user.get().toString()
                        : "Wrong cookie!"
        );
    }
}

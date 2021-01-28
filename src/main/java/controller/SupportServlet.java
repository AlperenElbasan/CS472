package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

@WebServlet("/support")
public class SupportServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.println("<html><head><title>Contact Us</title></head>");
        out.println("<body>");
        out.println("<form method='post'>");
        out.println("<label>Name: <input type='text' name='name'></label>");
        out.println("<label>Email: <input type='text' name='email'></label>");
        out.println("<label>Summary: <input type='text' name='summary'></label>");
        out.println("<label>Description: <textarea name='description'></textarea></label>");
        out.println("<input type='submit'>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().printf("Thank you! %s for contacting us. We should receive reply from us with in 24 hrs in\n" +
                        "your email address %s. Let us know in our support email %s if\n" +
                        "you don't receive reply within 24 hrs. Please be sure to attach your reference\n" +
                        "%s in your email.",
                req.getParameter("name"),
                req.getParameter("email"),
                getServletContext().getInitParameter("support-email"),
                UUID.randomUUID().toString()
        );
    }
}

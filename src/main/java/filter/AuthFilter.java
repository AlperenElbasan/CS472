package filter;

import storage.Users;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

public class AuthFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;

        Optional<Cookie> cookie = Arrays.stream(httpServletRequest.getCookies()).filter(c -> c.getName().equals("Auth")).findFirst();

        if (cookie.isPresent())
            if (Users.exists(cookie.get().getValue()))
                chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}

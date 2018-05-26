package filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(urlPatterns = "/*")
public class Authenticator implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //check if the user has a session and authenticated or not.
        //Check the requested service
        //If no service in the URL then select Show Home Service.
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        if("/".equals(httpServletRequest.getRequestURI())){
            httpServletRequest.getRequestDispatcher("/action/showHome").forward(servletRequest,servletResponse);
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
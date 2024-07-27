package controller.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import utils.StringUtils;

public class AuthenticationFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialization code goes here, if needed
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        // Cast request and response objects to HttpServletRequest and HttpServletResponse for type safety
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        // Get the requested URI
        String uri = req.getRequestURI();

        // Allow access to static resources (CSS, images, etc.) without checking login
        if (uri.endsWith(".css") || uri.endsWith(".png") || uri.endsWith(".jpg")) {
            chain.doFilter(request, response);
            return;
        }

        // Separate flags for login, logout servlets, and register page/servlet for better readability
        boolean isLogin = uri.endsWith(StringUtils.PAGE_URL_LOGIN);
        boolean isLoginServlet = uri.endsWith(StringUtils.SERVLET_URL_LOGIN);
        boolean isLogoutServlet = uri.endsWith(StringUtils.SERVLET_URL_LOGOUT);
        boolean isHomeServlet = uri.endsWith(StringUtils.SERVLET_URL_HOME);
        boolean isRegisterPage = uri.endsWith(StringUtils.PAGE_URL_REGISTER);
        boolean isRegisterServlet = uri.endsWith(StringUtils.SERVLET_URL_REGISTER);
        boolean isIndexPage = uri.endsWith(StringUtils.URL_INDEX); // New condition for index page
        boolean isUnloginPlayer = uri.endsWith(StringUtils.PAGE_NOTLOGGEDPLAYER); // New condition for UnloginPlayer.jsp
        boolean isForgetPassword = uri.endsWith("ForgetPassword.jsp"); // New condition for ForgetPassword.jsp
        boolean isForgetPasswordServ = uri.endsWith("/forgetPassword");
        // Check if a session exists and if the username attribute is set to determine login status
        HttpSession session = req.getSession(false); // Don't create a new session if one doesn't exist
        boolean isLoggedIn = session != null && session.getAttribute(StringUtils.USERNAME) != null;

        // Allow access to UnloginPlayer.jsp if user is not logged in
        if (isUnloginPlayer && !isLoggedIn) {
            chain.doFilter(request, response);
            return;
        }

        // Allow access to ForgetPassword.jsp if user is not logged in
        if (isForgetPassword && !isLoggedIn) {
            chain.doFilter(request, response);
            return;
        }

        if (isForgetPasswordServ && !isLoggedIn) {
            chain.doFilter(request, response);
            return;
        }
        
        // Redirect to login page if user is not logged in and trying to access a protected resource
        if (!isLoggedIn && !(isLogin || isLoginServlet || isRegisterPage || isRegisterServlet || isHomeServlet || isIndexPage || isLogoutServlet)) {
            res.sendRedirect(req.getContextPath() + StringUtils.URL_INDEX);
            return; // Return after redirecting to prevent further processing
        }

        // Redirect logged-in users to the index page if trying to access login page again
        if (isLoggedIn && (isLogin || isLoginServlet || isRegisterPage || isRegisterServlet)) {
            res.sendRedirect(req.getContextPath() + StringUtils.PAGE_URL_HOME);
            return; // Return after redirecting to prevent further processing
        }

        // Allow access to the requested resource if user is logged in or accessing unprotected resources
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        // Cleanup code goes here, if needed
    }
}
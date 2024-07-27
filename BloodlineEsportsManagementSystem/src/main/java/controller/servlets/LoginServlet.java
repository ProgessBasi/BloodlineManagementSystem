package controller.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import controller.database.DBController;
import model.LoginModel;
import model.RegisterModel;
import utils.StringUtils;

@WebServlet(urlPatterns = StringUtils.SERVLET_URL_LOGIN, asyncSupported = true)
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final DBController dbController;

    public LoginServlet() {
        this.dbController = new DBController();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String userName = request.getParameter(StringUtils.USERNAME);
        String password = request.getParameter(StringUtils.PASSWORD);

        LoginModel loginModel = new LoginModel(userName, password);

        int loginResult = dbController.getUserLoginInfo(loginModel);

        if (loginResult == 1) {
            HttpSession userSession = request.getSession();
            RegisterModel user = dbController.getUserinfo(userName);

            userSession.setAttribute(StringUtils.USERNAME, user);
            userSession.setMaxInactiveInterval(30 * 60);

            Cookie userCookie = new Cookie(StringUtils.USER, userName);
            userCookie.setMaxAge(30 * 60);
            response.addCookie(userCookie);

            if (user.getRole() != null && user.getRole().equals("admin")) {
                request.setAttribute(StringUtils.MESSAGE_SUCCESS, "Welcome Admin!");
                response.sendRedirect(request.getContextPath() + StringUtils.PAGE_ADMIN);
            } else if (user.getRole() != null && user.getRole().equals("user")) {
                request.setAttribute(StringUtils.MESSAGE_SUCCESS, "Welcome User!");
                response.sendRedirect(request.getContextPath() + StringUtils.PAGE_URL_HOME);
            } else {
                request.setAttribute(StringUtils.MESSAGE_ERROR, "Unknown role!");
                request.getRequestDispatcher(StringUtils.PAGE_URL_LOGIN).forward(request, response);
            }
        } else if (loginResult == 0) {
            request.setAttribute(StringUtils.MESSAGE_ERROR, StringUtils.MESSAGE_ERROR_LOGIN);
            request.getRequestDispatcher(StringUtils.PAGE_URL_LOGIN).forward(request, response);
        } else if (loginResult == -1) {
            request.setAttribute(StringUtils.MESSAGE_ERROR, StringUtils.MESSAGE_ERROR_CREATE_ACCOUNT);
            request.getRequestDispatcher(StringUtils.PAGE_URL_LOGIN).forward(request, response);
        } else {
            request.setAttribute(StringUtils.MESSAGE_ERROR, StringUtils.MESSAGE_ERROR_SERVER);
            request.getRequestDispatcher(StringUtils.PAGE_URL_LOGIN).forward(request, response);
        }
    }
}
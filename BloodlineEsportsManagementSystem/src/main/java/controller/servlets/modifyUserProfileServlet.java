package controller.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

import controller.database.DBController;
import model.RegisterModel;
import utils.StringUtils;

/**
 * Servlet implementation class ModifyServlet
 */
@WebServlet(asyncSupported = true, urlPatterns = StringUtils.SERVLET_URL_MODIFY_USER_PROFILE)
public class modifyUserProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final DBController dbController;

	public modifyUserProfileServlet() {
		this.dbController = new DBController();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String updateId = request.getParameter(StringUtils.UPDATE_ID);
		String deleteId = request.getParameter(StringUtils.DELETE_ID);

		if (updateId != null && !updateId.isEmpty()) {
			doPut(request, response);
		}
		if (deleteId != null && !deleteId.isEmpty()) {
			doDelete(request, response);
		}
		}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("put triggered");
		try {
			String fullName = req.getParameter(StringUtils.UPFULLNAME);
            String email = req.getParameter(StringUtils.UPEMAIL);
            String phonenumber = req.getParameter(StringUtils.UPPHONENUMBER);
            String password = req.getParameter(StringUtils.UPPASSWORD);
            String country = req.getParameter(StringUtils.UPCOUNTRY);
            String username = req.getParameter(StringUtils.UPUSERNAME);
            
            RegisterModel user = new RegisterModel(fullName, username, email, country, phonenumber, password);
            
            System.out.println(user);
            // Call DBController to register the user
            int result = dbController.UpdateUserProfile(user);
       
            if (result == 1) {
                req.setAttribute(StringUtils.MESSAGE_SUCCESS, StringUtils.MESSAGE_SUCCESS_REGISTER);
                resp.sendRedirect(req.getContextPath() + StringUtils.PAGE_PROFILE);

            } else if(result == -1) {
                req.setAttribute(StringUtils.MESSAGE_ERROR, StringUtils.MESSAGE_ERROR_SERVER);
                req.getRequestDispatcher(StringUtils.PAGE_UPDATEPROFILE).forward(req, resp);
            }
            
            else {
            	req.setAttribute(StringUtils.MESSAGE_ERROR, StringUtils.MESSAGE_ERROR_REGISTER);
                req.getRequestDispatcher(StringUtils.PAGE_UPDATEPROFILE).forward(req, resp);
            }
        } catch (Exception e) {
            // Handle exceptions gracefully
            req.setAttribute(StringUtils.MESSAGE_ERROR, StringUtils.MESSAGE_ERROR_SERVER);
            req.getRequestDispatcher(req.getContextPath() + StringUtils.PAGE_UPDATEPROFILE).forward(req, resp);
        }
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("delete triggered");
		if (dbController.deleteUserInfo(req.getParameter(StringUtils.DELETE_ID)) == 1) {
			Cookie[] cookies = req.getCookies();
	        if (cookies != null) {
	            for (Cookie cookie : cookies) {
	                cookie.setMaxAge(0);
	                resp.addCookie(cookie);
	            }
	        }
	        HttpSession session = req.getSession(false);
	        if (session != null) {
	            session.invalidate();
	        }
			
			req.setAttribute(StringUtils.MESSAGE_SUCCESS, StringUtils.MESSAGE_SUCCESS_DELETE);
			resp.sendRedirect(req.getContextPath() + StringUtils.URL_INDEX);
		} else {
			req.setAttribute(StringUtils.MESSAGE_ERROR, StringUtils.MESSAGE_ERROR_DELETE);
			resp.sendRedirect(req.getContextPath() + StringUtils.PAGE_PROFILE);
		}
	}

}
package controller.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.database.DBController;
import model.RegisterModel;
import utils.StringUtils;

/**
 * Servlet implementation class ModifyServlet
 */
@WebServlet(asyncSupported = true, urlPatterns = StringUtils.SERVLET_URL_FORGET_PASSWORD)
public class forgetPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final DBController dbController;

	public forgetPasswordServlet() {
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

		System.out.println(updateId);
		
		if (updateId != null && !updateId.isEmpty()) {
			doPut(request, response);
		}
		if (deleteId != null && !deleteId.isEmpty()) {
			doDelete(request, response);
		}

	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    try {
	        String FPusername = req.getParameter(StringUtils.FUSERNAME);
	        String FPpassword = req.getParameter(StringUtils.FPASSWORD);
	        String FPResetpassword = req.getParameter(StringUtils.FRETYPEPASSWORD);
	        
	        // Check if the username exists in the database
	        if (!dbController.isUserExists(FPusername)) {
	            req.setAttribute(StringUtils.MESSAGE_ERROR, "Username does not exist.");
	            req.getRequestDispatcher(StringUtils.PAGE_FORGETPASSWORD).forward(req, resp);
	            return; // Exit method
	        }
	        
	        if (!FPpassword.equals(FPResetpassword)) {
	            // Passwords don't match, show error message
	            req.setAttribute(StringUtils.MESSAGE_ERROR, "Passwords do not match.");
	            req.getRequestDispatcher(StringUtils.PAGE_FORGETPASSWORD).forward(req, resp);
	            return; // Exit method
	        }

	        RegisterModel user = new RegisterModel(FPusername, FPpassword, FPResetpassword);
	        int result = dbController.ForgetPassword(user);
	        if (result == 1) {
	            req.setAttribute(StringUtils.MESSAGE_SUCCESS, StringUtils.MESSAGE_SUCCESS_REGISTER);
	            resp.sendRedirect(req.getContextPath() + StringUtils.URL_LOGIN);
	        } else if(result == -1) {
	            req.setAttribute(StringUtils.MESSAGE_ERROR, StringUtils.MESSAGE_ERROR_SERVER);
	            req.getRequestDispatcher(StringUtils.PAGE_FORGETPASSWORD).forward(req, resp);
	        } else {
	            req.setAttribute(StringUtils.MESSAGE_ERROR, StringUtils.MESSAGE_ERROR_REGISTER);
	            req.getRequestDispatcher(StringUtils.PAGE_FORGETPASSWORD).forward(req, resp);
	        }
	    } catch (Exception e) {
	        req.setAttribute(StringUtils.MESSAGE_ERROR, StringUtils.MESSAGE_ERROR_SERVER);
	        req.getRequestDispatcher(req.getContextPath() + StringUtils.PAGE_FORGETPASSWORD).forward(req, resp);
	    }
	}

}
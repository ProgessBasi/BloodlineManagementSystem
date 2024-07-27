package controller.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.database.DBController;
import model.AddTeamModel;
import utils.StringUtils;

/**
 * Servlet implementation class ModifyServlet
 */
@WebServlet(asyncSupported = true, urlPatterns = StringUtils.SERVLET_URL_MODIFY_USER)
public class modifyUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final DBController dbController;

	public modifyUserServlet() {
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
			String playerUsername = req.getParameter(StringUtils.PUSERNAME);
			String playerName = req.getParameter(StringUtils.PFULLNAME);
			String playerHS = req.getParameter(StringUtils.PHS);
			String playerRole = req.getParameter(StringUtils.PROLE);
			String playerACS = req.getParameter(StringUtils.PACS);
			String country = req.getParameter(StringUtils.PCOUNTRY);
			String team = req.getParameter(StringUtils.PTEAM);
			
			AddTeamModel player = new AddTeamModel(playerUsername, playerName, playerHS, playerRole,
					playerACS, country, team);
			int result = dbController.UpdatePlayer(player);
			if (result == 1) {
                req.setAttribute(StringUtils.MESSAGE_SUCCESS, StringUtils.MESSAGE_SUCCESS_REGISTER);
                resp.sendRedirect(req.getContextPath() + StringUtils.PAGE_TEAMADMIN);
            } else if(result == -1) {
                req.setAttribute(StringUtils.MESSAGE_ERROR, StringUtils.MESSAGE_ERROR_SERVER);
                req.getRequestDispatcher(StringUtils.PAGE_UPDATEPLAYER).forward(req, resp);
            }
            
            else {
            	req.setAttribute(StringUtils.MESSAGE_ERROR, StringUtils.MESSAGE_ERROR_REGISTER);
                req.getRequestDispatcher(StringUtils.PAGE_UPDATEPLAYER).forward(req, resp);
            }
        } catch (Exception e) {
            // Handle exceptions gracefully
            req.setAttribute(StringUtils.MESSAGE_ERROR, StringUtils.MESSAGE_ERROR_SERVER);
            req.getRequestDispatcher(req.getContextPath() + StringUtils.PAGE_UPDATEPLAYER).forward(req, resp);
        }
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("delete triggered");
		if (dbController.deletePlayerInfo(req.getParameter(StringUtils.DELETE_ID)) == 1) {
			req.setAttribute(StringUtils.MESSAGE_SUCCESS, StringUtils.MESSAGE_SUCCESS_DELETE);
			resp.sendRedirect(req.getContextPath() + StringUtils.PAGE_TEAMADMIN);
		} else {
			req.setAttribute(StringUtils.MESSAGE_ERROR, StringUtils.MESSAGE_ERROR_DELETE);
			resp.sendRedirect(req.getContextPath() + StringUtils.PAGE_TEAMADMIN);
		}
	}

}
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
 * This Servlet class handles student registration requests. It extracts student
 * information from the registration form submission, performs basic data
 * validation (to be implemented), and attempts to register the student in the
 * database using a `DBController`. The user is redirected to the login page
 * upon successful registration.
 *
 * @author 
 */
@WebServlet(asyncSupported = true, urlPatterns = {StringUtils.SERVLET_URL_PLAYER })
public class PlayerServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final DBController dbController;

    public PlayerServlet() {
        this.dbController = new DBController();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String  playerUsername= request.getParameter(StringUtils.PUSERNAME);
            String  playerName= request.getParameter(StringUtils.PFULLNAME);
            String  playerHS= request.getParameter(StringUtils.PROLE);
            String  playerRole= request.getParameter(StringUtils.PHS);
            String  playerACS= request.getParameter(StringUtils.PACS);
            String  acountry = request.getParameter(StringUtils.PCOUNTRY);
            String  ateam = request.getParameter(StringUtils.PTEAM);
            
            AddTeamModel team = new AddTeamModel(playerUsername, playerName, playerHS, playerRole, playerACS, acountry, ateam);
            
            // Call DBController to register the user
            int result = dbController.addPlayer(team);
            System.out.println(result);

            if (result == 1) {
                request.setAttribute(StringUtils.MESSAGE_SUCCESS, StringUtils.MESSAGE_SUCCESS_REGISTER);
                response.sendRedirect(request.getContextPath() + StringUtils.PAGE_TEAMADMIN);
            } else if(result == -1) {
                request.setAttribute(StringUtils.MESSAGE_ERROR, StringUtils.MESSAGE_ERROR_SERVER);
                request.getRequestDispatcher(StringUtils.PAGE_ADDPLAYER).forward(request, response);
            }
            
            else {
            	request.setAttribute(StringUtils.MESSAGE_ERROR, StringUtils.MESSAGE_ERROR_REGISTER);
                request.getRequestDispatcher(StringUtils.PAGE_ADDPLAYER).forward(request, response);
            }
        } catch (Exception e) {
            // Handle exceptions gracefully
            request.setAttribute(StringUtils.MESSAGE_ERROR, StringUtils.MESSAGE_ERROR_SERVER);
            request.getRequestDispatcher(request.getContextPath() + StringUtils.PAGE_ADDPLAYER).forward(request, response);
        }
    }
} 
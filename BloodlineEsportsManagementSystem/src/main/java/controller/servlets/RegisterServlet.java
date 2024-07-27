package controller.servlets;

import java.io.IOException;

import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.database.DBController;
import model.RegisterModel;
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
@WebServlet(asyncSupported = true, urlPatterns = {StringUtils.SERVLET_URL_REGISTER })
public class RegisterServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final DBController dbController;

    public RegisterServlet() {
        this.dbController = new DBController();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            // Extract student information from request parameters
            String fullName = request.getParameter(StringUtils.FULL_NAME);
            LocalDate dob = LocalDate.parse(request.getParameter(StringUtils.BIRTHDAY));
            String gender = request.getParameter(StringUtils.GENDER);
            String email = request.getParameter(StringUtils.EMAIL);
            String phoneNumber = request.getParameter(StringUtils.PHONE_NUMBER);
            String password = request.getParameter(StringUtils.PASSWORD);
            String role = request.getParameter(StringUtils.ROLE);
            String country = request.getParameter(StringUtils.COUNTRY);
            String username = request.getParameter(StringUtils.USERNAME);
            String retypePassword = request.getParameter(StringUtils.RETYPE_PASSWORD);
            
            // Validation checks
            if (dbController.isUserExists(username)) {
                request.setAttribute(StringUtils.MESSAGE_ERROR, "Username already exists.");
                request.getRequestDispatcher(StringUtils.PAGE_URL_REGISTER).forward(request, response);
                return;
            }
            
            if (dbController.isEmailExists(email)) {
                request.setAttribute(StringUtils.MESSAGE_ERROR, "Email already exists.");
                request.getRequestDispatcher(StringUtils.PAGE_URL_REGISTER).forward(request, response);
                return;
            }
            
            if (dbController.isPhoneNumberExists(phoneNumber)) {
                request.setAttribute(StringUtils.MESSAGE_ERROR, "Phone number already exists.");
                request.getRequestDispatcher(StringUtils.PAGE_URL_REGISTER).forward(request, response);
                return;
            }
            
            if (!password.equals(retypePassword)) {
                request.setAttribute(StringUtils.MESSAGE_ERROR, "Passwords do not match.");
                request.getRequestDispatcher(StringUtils.PAGE_URL_REGISTER).forward(request, response);
                return;
            }

            // Additional validations
            if (!fullName.matches("[a-zA-Z ]+")) {
                request.setAttribute(StringUtils.MESSAGE_ERROR, "Full name should contain only alphabets and spaces.");
                request.getRequestDispatcher(StringUtils.PAGE_URL_REGISTER).forward(request, response);
                return;
            }
            
            if (!phoneNumber.matches("[0-9]+")) {
                request.setAttribute(StringUtils.MESSAGE_ERROR, "Phone number should contain only numbers.");
                request.getRequestDispatcher(StringUtils.PAGE_URL_REGISTER).forward(request, response);
                return;
            }

            RegisterModel user = new RegisterModel(fullName, username, email, phoneNumber, country, password, gender, dob, role);
            
            // Call DBController to register the user
            int result = dbController.registerUser(user);

            if (result == 1) {
                request.setAttribute(StringUtils.MESSAGE_SUCCESS, StringUtils.MESSAGE_SUCCESS_REGISTER);
                response.sendRedirect(request.getContextPath() + StringUtils.PAGE_URL_LOGIN);
            } else if(result == -1) {
                request.setAttribute(StringUtils.MESSAGE_ERROR, StringUtils.MESSAGE_ERROR_SERVER);
                request.getRequestDispatcher(StringUtils.PAGE_URL_REGISTER).forward(request, response);
            } else {
                request.setAttribute(StringUtils.MESSAGE_ERROR, StringUtils.MESSAGE_ERROR_REGISTER);
                request.getRequestDispatcher(StringUtils.PAGE_URL_REGISTER).forward(request, response);
            }
        } catch (Exception e) {
            // Handle exceptions gracefully
            e.printStackTrace();
            request.setAttribute(StringUtils.MESSAGE_ERROR, StringUtils.MESSAGE_ERROR_SERVER);
            request.getRequestDispatcher(request.getContextPath() + StringUtils.PAGE_URL_REGISTER).forward(request, response);
        }
    }
} 
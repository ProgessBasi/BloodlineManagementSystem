package utils;

public class StringUtils {

	// Start: DB Connection
	public static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	public static final String LOCALHOST_URL = "jdbc:mysql://localhost:3306/bloodline_managementsystem";
	public static final String LOCALHOST_USERNAME = "root";
	public static final String LOCALHOST_PASSWORD = "";
	// End: DB Connection

	// Start: Queries
		public static final String QUERY_REGISTER_USER = "INSERT INTO user ("
				+ "fullName, userName, email, phoneNumber, country, password, gender, dob, role) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		public static final String QUERY_ADD_PLAYER = "INSERT INTO player ("
				+ "PlayerUsername, PlayerName, PlayerHS, PlayerRole, PlayerACS, Country, Team) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?)";
		
		public static final String QUERY_LOGIN_USER_CHECK = "SELECT * FROM user WHERE userName = ?";
		
		public static final String QUERY_GET_PLAYER_BY_USERNAME = "SELECT * FROM player WHERE PlayerUsername = ?";
		
		public static final String QUERY_GET_ALL_USERS = "SELECT fullName, userName, email, phoneNumber, country, gender, dob FROM user WHERE role = 'user'";
		public static final String QUERY_GET_ALL_PLAYERS = "SELECT * FROM player";
		
		public static final String QUERY_DELETE_PLAYER = "DELETE FROM player WHERE PlayerUsername = ?";
		
	    public static final String QUERY_DELETE_USER = "DELETE FROM user WHERE userName = ?";
		
		public static final String QUERY_UPDATE_TOOLS = "UPDATE player set PlayerUsername=?, PlayerName=?,PlayerHS=?,PlayerRole=?,PlayerACS=?, Country=?, Team=? "
	            + "WHERE PlayerUsername=?";
		
		public static final String QUERY_UPDATE_USER_PROFILE = "UPDATE user set fullName=?, userName=?,email=?,country=?, phoneNumber=?,password=?"
	            + "WHERE userName=?";
		
		public static final String QUERY_FORGET_PASSWORD = "UPDATE user set password = ?" +"WHERE username = ?";
		
		
		// End: Queries

		// Start: Parameter names
		public static final String USERNAME = "username";
		public static final String USER_NAME = "User_Name";
		public static final String FULL_NAME= "fullName";
		public static final String BIRTHDAY = "dob";
		public static final String GENDER = "gender";
		public static final String EMAIL = "email";
		public static final String PHONE_NUMBER = "phoneNumber";
		public static final String PASSWORD = "password";
		public static final String RETYPE_PASSWORD = "retypePassword";
		public static final String ROLE = "Role";
		public static final String VERIFICATION = "verificationCode";
		public static final String COUNTRY = "country";
		
		public static final String PUSERNAME = "Pusername";
		public static final String PFULLNAME = "PfullName";
		public static final String PROLE= "Prole";
		public static final String PHS = "Phsp";
		public static final String PACS = "Pacs";
		public static final String PCOUNTRY = "Pcountry";
		public static final String PTEAM = "Pteam";
		public static final String PPLAYERID = "playerId";

		public static final String FUSERNAME = "FPusername";
		public static final String FPASSWORD = "FPnewPassword";
		public static final String FRETYPEPASSWORD = "FPretypeNewPassword";
		
		public static final String UPUSERNAME = "Uusername";
		public static final String UPFULLNAME = "UfullName";
		public static final String UPEMAIL = "Uemail";
		public static final String UPPHONENUMBER = "UphoneNumber";
		public static final String UPCOUNTRY = "Ucountry";
		public static final String UPPASSWORD = "Upassword";
	// End: Parameter names

		// Start: Validation Messages
		// Register Page Messages
		public static final String MESSAGE_SUCCESS_REGISTER = "Successfully Registered!";
		public static final String MESSAGE_ERROR_REGISTER = "Please correct the form data.";
		public static final String MESSAGE_ERROR_USERNAME = "Username is already registered.";
		public static final String MESSAGE_ERROR_EMAIL = "Email is already registered.";
		public static final String MESSAGE_ERROR_PHONE_NUMBER = "Phone number is already registered.";
		public static final String MESSAGE_ERROR_PASSWORD_UNMATCHED = "Password is not matched.";
		public static final String MESSAGE_ERROR_INCORRECT_DATA = "Please fill the form correctly.";

		// Login Page Messages
		public static final String MESSAGE_SUCCESS_LOGIN = "Successfully LoggedIn!";
		public static final String MESSAGE_ERROR_LOGIN = "Either username or password is not correct!";
		public static final String MESSAGE_ERROR_CREATE_ACCOUNT = "Account for this username is not registered! Please create a new account.";
		
		// Other Messages
		public static final String MESSAGE_ERROR_SERVER = "An unexpected server error occurred.";
		public static final String MESSAGE_SUCCESS_DELETE = "Successfully Deleted!";
		public static final String MESSAGE_ERROR_DELETE = "Cannot delete the user!";
		
		public static final String MESSAGE_SUCCESS = "successMessage";
		public static final String MESSAGE_ERROR = "errorMessage";
		// End: Validation Messages

		// Start: JSP Route
		public static final String PAGE_URL_LOGIN = "/Pages/login.jsp";
		public static final String PAGE_URL_REGISTER = "/Pages/register.jsp";
		public static final String PAGE_URL_HOME = "/Pages/Home.jsp";
		public static final String URL_LOGIN = "/Pages/login.jsp";
		public static final String URL_INDEX = "/Index.jsp";
		public static final String PAGE_ADMIN = "/Pages/AdminHome.jsp";
		public static final String PAGE_USERS = "/Pages/Users.jsp";
		public static final String PAGE_TEAMADMIN = "/Pages/TeamAdmin.jsp";
		public static final String PAGE_ADDPLAYER = "/Pages/AddPlayer.jsp";
		public static final String PAGE_FORGETPASSWORD = "/Pages/ForgetPassword.jsp";
		public static final String PAGE_UPDATEPLAYER = "/Pages/UpdatePlayer.jsp";
		public static final String PAGE_PROFILE = "/Pages/Profile.jsp";
		public static final String PAGE_UPDATEPROFILE = "/Pages/UpdateProfile.jsp";
		public static final String PAGE_NOTLOGGEDPLAYER = "/Pages/UnloginPlayer.jsp";
		// End: JSP Route

		// Start: Servlet Route
		public static final String SERVLET_URL_LOGIN = "/LoginPage";
		public static final String SERVLET_URL_REGISTER = "/RegisterPage";
		public static final String SERVLET_URL_LOGOUT = "/Logout";
		public static final String SERVLET_URL_HOME = "/Home";
		public static final String SERVLET_URL_PLAYER = "/AddPlayer";
		public static final String SERVLET_URL_MODIFY_USER = "/modifyUser";
		public static final String SERVLET_URL_MODIFY_USER_PROFILE = "/modifyUserProfile";
		public static final String SERVLET_URL_FORGET_PASSWORD = "/forgetPassword";
		// End: Servlet Route
		// Start: Normal Text
		public static final String USER = "user";
		public static final String SUCCESS = "success";
		public static final String TRUE = "true";
		public static final String JSESSIONID = "JSESSIONID";
		public static final String LOGIN = "Login";
		public static final String LOGOUT = "Logout";
		public static final String REGISTER_MODEL = "RegisterModel";
		public static final String DELETE_ID = "deleteId";
		public static final String UPDATE_ID = "updateId";
		// End: Normal Text
	}
package controller.database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.LoginModel;
import model.RegisterModel;
import utils.StringUtils;
import model.AddTeamModel;

public class DBController {

	/**
	 * Establishes a connection to the database using pre-defined credentials and
	 * driver information.
	 * 
	 * @return A `Connection` object representing the established connection to the
	 *         database.
	 * @throws SQLException           if a database access error occurs.
	 * @throws ClassNotFoundException if the JDBC driver class is not found.
	 */
	public Connection getConnection() throws SQLException, ClassNotFoundException {

		// Load the JDBC driver class specified by the StringUtils.DRIVER_NAME constant
		Class.forName(StringUtils.DRIVER_NAME);

		// Create a connection to the database using the provided credentials
		return DriverManager.getConnection(StringUtils.LOCALHOST_URL, StringUtils.LOCALHOST_USERNAME,
				StringUtils.LOCALHOST_PASSWORD);
	}

	/**
	 * This method attempts to register a new student in the database.
	 * 
	 * @param student A `StudentModel` object containing the student's information.
	 * @return An integer value indicating the registration status: - 1:
	 *         Registration successful - 0: Registration failed (no rows affected) -
	 *         -1: Internal error (e.g., ClassNotFound or SQLException) - -2:
	 *         Password and retype password mismatch - -3: Invalid verification code
	 *         for admin role
	 * @throws SQLException           if a database access error occurs.
	 * @throws ClassNotFoundException if the JDBC driver class is not found.
	 */
	public int registerUser(RegisterModel user) {

		try {

			// Prepare a statement using the predefined query for user registration
			PreparedStatement stmt = getConnection().prepareStatement(StringUtils.QUERY_REGISTER_USER);

			// Set the user information in the prepared statement
			stmt.setString(1, user.getFullName());
			stmt.setString(2, user.getUserName());
			stmt.setString(3, user.getEmail());
			stmt.setString(4, user.getPhoneNumber());
			stmt.setString(5, user.getCountry());
			stmt.setString(6, user.getPassword());
			stmt.setString(7, user.getGender());
			stmt.setDate(8, Date.valueOf(user.getDOB()));
			stmt.setString(9, user.getRole());

			int result = stmt.executeUpdate();

			// Check if the update was successful (i.e., at least one row affected)
			if (result > 0) {
				return 1; // Registration successful
			} else {
				return 0; // Registration failed (no rows affected)
			}
		} catch (ClassNotFoundException | SQLException ex) {
			// Print the stack trace for debugging purposes
			ex.printStackTrace();
			return -1; // Internal error
		}
	}

	
	public int UpdateUserProfile(RegisterModel user) {

		try {

			// Prepare a statement using the predefined query for user registration
			PreparedStatement stmt = getConnection().prepareStatement(StringUtils.QUERY_UPDATE_USER_PROFILE);

			// Set the user information in the prepared statement
			stmt.setString(1, user.getFullName());
			stmt.setString(2, user.getUserName());
			stmt.setString(3, user.getEmail());
			stmt.setString(5, user.getCountry());
			stmt.setString(4, user.getPhoneNumber());
			stmt.setString(6, user.getPassword());
			stmt.setString(7, user.getUserName());
			int result = stmt.executeUpdate();

			// Check if the update was successful (i.e., at least one row affected)
			if (result > 0) {
				return 1; // Registration successful
			} else {
				return 0; // Registration failed (no rows affected)
			}
		} catch (ClassNotFoundException | SQLException ex) {
			// Print the stack trace for debugging purposes
			ex.printStackTrace();
			return -1; // Internal error
		}
	}
	
	public int addPlayer(AddTeamModel team) {

		try {

			// Prepare a statement using the predefined query for user registration
			PreparedStatement stmt = getConnection().prepareStatement(StringUtils.QUERY_ADD_PLAYER);

			// Set the user information in the prepared statement
			stmt.setString(1, team.getPlayerUsername());
			stmt.setString(2, team.getPlayerName());
			stmt.setString(3, team.getPlayerHS());
			stmt.setString(4, team.getPlayerRole());
			stmt.setString(5, team.getPlayerACS());
			stmt.setString(6, team.getCountry());
			stmt.setString(7, team.getTeam());

			int result = stmt.executeUpdate();

			// Check if the update was successful (i.e., at least one row affected)
			if (result > 0) {
				return 1; // Registration successful
			} else {
				return 0; // Registration failed (no rows affected)
			}
		} catch (ClassNotFoundException | SQLException ex) {
			// Print the stack trace for debugging purposes
			ex.printStackTrace();
			return -1; // Internal error
		}
	}
	
	public int UpdatePlayer(AddTeamModel player) {

		try {

			// Prepare a statement using the predefined query for user registration
			PreparedStatement stmt = getConnection().prepareStatement(StringUtils.QUERY_UPDATE_TOOLS);

			// Set the user information in the prepared statement
			stmt.setString(1, player.getPlayerUsername());
			stmt.setString(2, player.getPlayerName());
			stmt.setString(3, player.getPlayerHS());
			stmt.setString(4, player.getPlayerRole());
			stmt.setString(5, player.getPlayerACS());
			stmt.setString(6, player.getCountry());
			stmt.setString(7, player.getTeam());
			stmt.setString(8, player.getPlayerUsername());

			int result = stmt.executeUpdate();

			// Check if the update was successful (i.e., at least one row affected)
			if (result > 0) {
				return 1; // Registration successful
			} else {
				return 0; // Registration failed (no rows affected)
			}
		} catch (ClassNotFoundException | SQLException ex) {
			// Print the stack trace for debugging purposes
			ex.printStackTrace();
			return -1; // Internal error
		}
	}
	
	public int ForgetPassword(RegisterModel user) {

		try {

			// Prepare a statement using the predefined query for user registration
			PreparedStatement stmt = getConnection().prepareStatement(StringUtils.QUERY_FORGET_PASSWORD);

			// Set the user information in the prepared statement
			stmt.setString(1, user.getPassword());
			stmt.setString(2, user.getUserName());


			int result = stmt.executeUpdate();

			// Check if the update was successful (i.e., at least one row affected)
			if (result > 0) {
				return 1; // Registration successful
			} else {
				return 0; // Registration failed (no rows affected)
			}
		} catch (ClassNotFoundException | SQLException ex) {
			// Print the stack trace for debugging purposes
			ex.printStackTrace();
			return -1; // Internal error
		}
	}
	
	/**
	 * This method attempts to validate a student login by checking the username and
	 * password against a database.
	 * 
	 * @param username The username provided by the user attempting to log in.
	 * @param password The password provided by the user attempting to log in.
	 * @return An integer value indicating the login status: - 1: Login successful -
	 *         0: Username or password mismatch - -1: Username not found in the
	 *         database - -2: Internal error (e.g., SQL or ClassNotFound exceptions)
	 * @throws SQLException           if a database access error occurs.
	 * @throws ClassNotFoundException if the JDBC driver class is not found.
	 */
	public int getUserLoginInfo(LoginModel loginModel) {

		// Try-catch block to handle potential SQL or ClassNotFound exceptions
		try {
			// Prepare a statement using the predefined query for login check
			PreparedStatement st = getConnection().prepareStatement(StringUtils.QUERY_LOGIN_USER_CHECK);
			// Set the username in the first parameter of the prepared statement
			st.setString(1, loginModel.getUsername());
			// Execute the query and store the result set
			ResultSet result = st.executeQuery();
			// Check if there's a record returned from the query
			if (result.next()) {
				// Get the username from the database
				String userDb = result.getString(StringUtils.USERNAME);

				// Get the password from the database
				String passwordDb = result.getString(StringUtils.PASSWORD);

				// Check if the username and password match the credentials from the database
				if (userDb.equals(loginModel.getUsername()) && passwordDb.equals(loginModel.getPassword())) {
					// Login successful, return 1
					return 1;
				} else {
					// Username or password mismatch, return 0
					return 0;
				}
			} else {
				// Username not found in the database, return -1
				return -1;
			}

			// Catch SQLException and ClassNotFoundException if they occur
		} catch (SQLException | ClassNotFoundException ex) {
			// Print the stack trace for debugging purposes
			ex.printStackTrace();
			// Return -2 to indicate an internal error
			return -2;
		}
	}

	public RegisterModel getUserinfo(String username) {
		RegisterModel user = null;
		try {
			PreparedStatement st = getConnection().prepareStatement(StringUtils.QUERY_LOGIN_USER_CHECK);
			st.setString(1, username);
			ResultSet resultset = st.executeQuery();
			if (resultset.next()) {
				user = new RegisterModel();
				user.setUserID(resultset.getInt("UserID"));
				user.setFullName(resultset.getString("fullName"));
				user.setUserName(resultset.getString("userName"));
				user.setRole(resultset.getString("role"));
				user.setEmail(resultset.getString("email"));
				user.setPhoneNumber(resultset.getString("phoneNumber"));
				user.setPassword(resultset.getString("password"));
				user.setCountry(resultset.getString("country"));
				user.setDOB(resultset.getDate("dob").toLocalDate());
				user.setPhoneNumber(resultset.getString("phoneNumber"));
				
			}

		} catch (Exception e) {
			e.printStackTrace();

		}
		return user;
	}
	
	public ArrayList<RegisterModel> getAllUsersInfo() {
	    ArrayList<RegisterModel> users = new ArrayList<>();
	    RegisterModel user = null;
	    try {
	        PreparedStatement stmt = getConnection().prepareStatement(StringUtils.QUERY_GET_ALL_USERS);
	        ResultSet result = stmt.executeQuery();

	        // Logging the SQL query being executed
	        

	        while (result.next()) {
	            user = new RegisterModel();
	            user.setFullName(result.getString("fullName"));
	            user.setUserName(result.getString("userName"));
	            user.setEmail(result.getString("email"));
	            user.setPhoneNumber(result.getString("phoneNumber"));
	            user.setCountry(result.getString("country"));
	            user.setGender(result.getString("gender"));
	            user.setDOB(result.getDate("dob").toLocalDate());
	            users.add(user);
	        }

	        // Logging the ArrayList to console
	        

	    } catch (SQLException | ClassNotFoundException ex) {
	        // Logging any exceptions that occur
	        ex.printStackTrace();
	    }

	    return users;
	}
	
	public AddTeamModel getPlayerByUsername(String username) {
        AddTeamModel player = null;
        try {
            PreparedStatement stmt = getConnection().prepareStatement(StringUtils.QUERY_GET_PLAYER_BY_USERNAME);
            stmt.setString(1, username);
            ResultSet result = stmt.executeQuery();

            if (result.next()) {
                player = new AddTeamModel();
                player.setPlayerUsername(result.getString("PlayerUsername"));
                player.setPlayerName(result.getString("PlayerName"));
                player.setPlayerHS(result.getString("PlayerHS"));
                player.setPlayerRole(result.getString("PlayerRole"));
                player.setPlayerACS(result.getString("PlayerACS"));
                player.setCountry(result.getString("Country"));
                player.setTeam(result.getString("Team"));
            }
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return player;
    }
	
	public ArrayList<AddTeamModel> getAllPlayersInfo() {
	    ArrayList<AddTeamModel> players = new ArrayList<>();
	    AddTeamModel player = null;
	    try {
	        PreparedStatement stmt = getConnection().prepareStatement(StringUtils.QUERY_GET_ALL_PLAYERS);
	        ResultSet result = stmt.executeQuery();


	        while (result.next()) {
	            player = new AddTeamModel();
	            player.setPlayerUsername(result.getString("PlayerUsername"));
	            player.setPlayerName(result.getString("PlayerName"));
	            player.setPlayerHS(result.getString("PlayerHS"));
	            player.setPlayerRole(result.getString("PlayerRole"));
	            player.setPlayerACS(result.getString("PlayerACS"));
	            player.setCountry(result.getString("Country"));
	            player.setTeam(result.getString("Team"));
	            players.add(player);
	        }

	        // Logging the ArrayList to console
	        

	    } catch (SQLException | ClassNotFoundException ex) {
	        // Logging any exceptions that occur
	        ex.printStackTrace();
	    }

	    return players;
	}
	public int deletePlayerInfo(String PlayerUsername) {
		try (Connection con = getConnection()) {
			PreparedStatement st = con.prepareStatement(StringUtils.QUERY_DELETE_PLAYER);
			st.setString(1, PlayerUsername);
			return st.executeUpdate();
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace(); // Log the exception for debugging
			return -1;
		}
	}
	public int deleteUserInfo(String userName) {
		try (Connection con = getConnection()) {
			PreparedStatement st = con.prepareStatement(StringUtils.QUERY_DELETE_USER);
			st.setString(1, userName);
			return st.executeUpdate();
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace(); // Log the exception for debugging
			return -1;
		}
	}
	public boolean isUserExists(String username) {
        String query = "SELECT COUNT(*) AS count FROM user WHERE userName = ?";
        try (Connection con = getConnection()) {
        	PreparedStatement statement = con.prepareStatement(query);
            statement.setString(1, username);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt("count");
                    return count > 0;
                }
            }
        } catch (SQLException  | ClassNotFoundException ex ) {
            ex.printStackTrace();
        }
        return false;
    }

    // Check if an email already exists in the database
    public boolean isEmailExists(String email) {
        String query = "SELECT COUNT(*) AS count FROM user WHERE email = ?";
        try (Connection con = getConnection()) {
        	PreparedStatement statement = con.prepareStatement(query);
            statement.setString(1, email);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt("count");
                    return count > 0;
                }
            }
        } catch (SQLException  | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    // Check if a phone number already exists in the database
    public boolean isPhoneNumberExists(String phoneNumber) {
        String query = "SELECT COUNT(*) AS count FROM user WHERE phoneNumber = ?";
        try (Connection con = getConnection()) {
        	PreparedStatement statement = con.prepareStatement(query);
            statement.setString(1, phoneNumber);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt("count");
                    return count > 0;
                }
            }
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return false;
    }

}
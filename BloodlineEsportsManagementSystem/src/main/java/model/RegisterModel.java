package model;

import java.time.LocalDate;

public class RegisterModel {

	
	private String FullName;
	private String UserName;
	private String Email;
	private String PhoneNumber;
	private String Country;
	private String Role;
	private String Password;
	private String RetypePassword;
	private String VerificationCode;
	private String Gender;
	private LocalDate DOB;
	private int UserID;
	
	public RegisterModel() {
		super();
	}

	public RegisterModel(int userID, String fullName, String username, String email, String phoneNumber, String country,
			String role, String password, String verificationCode, String gender, LocalDate dob) {
		FullName = fullName;
		UserName = username;
		Email = email;
		PhoneNumber = phoneNumber;
		Country = country;
		Role = role;
		Password = password;
		VerificationCode = verificationCode;
		Gender = gender;
		DOB = dob;
		UserID = userID;
	}

	public RegisterModel(String UserName, String Password, String RetypePassword) {
		this.UserName = UserName;
		this.Password = Password;
		this.RetypePassword = RetypePassword;
	}
	
	public RegisterModel(String fullName, String username, String email, String phoneNumber, String country,
			String role, String password, String retypePassword, String verificationCode, String gender, LocalDate dob) {
		FullName = fullName;
		UserName = username;
		Email = email;
		PhoneNumber = phoneNumber;
		Country = country;
		Role = role;
		Password = password;
		RetypePassword = retypePassword;
		VerificationCode = verificationCode;
		Gender = gender;
		DOB = dob;
	}
	
	

	public RegisterModel(String fullName, String username, String email, String phoneNumber, String country,
			String password, String gender, LocalDate dob, String role) {
		this.FullName = fullName;
		this.UserName = username;
		this.Email = email;
		this.PhoneNumber = phoneNumber;
		this.Country = country;
		this.Password = password;
		this.Gender = gender;
		this.DOB = dob;
		this.Role = role;
	}

	public RegisterModel(String fullName, String username, String email, String phoneNumber, String country,
			String password) {
		this.FullName = fullName;
		this.UserName = username;
		this.Email = email;
		this.PhoneNumber = phoneNumber;
		this.Country = country;
		this.Password = password;
	}

	public String getFullName() {
		return FullName;
	}

	public void setFullName(String fullName) {
		FullName = fullName;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPhoneNumber() {
		return PhoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}

	public String getRole() {
		return Role;
	}

	public void setRole(String role) {
		Role = role;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getRetypePassword() {
		return RetypePassword;
	}

	public void setRetypePassword(String retypePassword) {
		RetypePassword = retypePassword;
	}

	public String getVerificationCode() {
		return VerificationCode;
	}

	public void setVerifcationCode(String verificationCode) {
		VerificationCode = verificationCode;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	public LocalDate getDOB() {
		return DOB;
	}

	public void setDOB(LocalDate dOB) {
		DOB = dOB;
	}

	public int getUserID() {
		return UserID;
	}

	public void setUserID(int userID) {
		UserID = userID;
	}
	
}

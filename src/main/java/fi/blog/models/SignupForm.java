package fi.blog.models;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class SignupForm {
	@NotEmpty
	private String firstname = "";
	
	@NotEmpty
	private String lastname = "";
	
	@NotEmpty
	private String phone = "";
	
	@NotEmpty
	private String email = "";
	
	@NotEmpty
	@Size(min = 5, max = 30)
	private String username = "";
	
	@NotEmpty
	@Size(min = 7, max = 30)
	private String password = "";
	
	@NotEmpty
	@Size(min = 7, max = 30)
	private String passwordCheck = "";
	
	@NotEmpty
	private String role = "USER";
	
	
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordCheck() {
		return passwordCheck;
	}

	public void setPasswordCheck(String passwordCheck) {
		this.passwordCheck = passwordCheck;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
}

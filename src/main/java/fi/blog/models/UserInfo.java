package fi.blog.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserInfo {
	 @Id
	 private Long id;	 
	 private String firstname;	 
	 private String lastname;	 
	 private String phone;
	 private String email;	 
	 private String username;	 
	 private String role;
	 
	 public UserInfo(){
		 
	 }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public UserInfo(String firstname, String lastname, String phone, String email, String username, String role) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.phone = phone;
		this.email = email;
		this.username = username;
		this.role = role;
	}
	 
	 
}

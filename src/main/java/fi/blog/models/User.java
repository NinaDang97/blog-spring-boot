package fi.blog.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "id", nullable = false, updatable = false)
	 private Long id;
	 
	 @Column(name = "firstname", nullable = false)
	 private String firstname;
	 
	 @Column(name = "lastname", nullable = false)
	 private String lastname;

	 @Column(name = "phone", nullable = false)
	 private String phone;

	 @Column(name = "email", nullable = false)
	 private String email;
	 
	 @Column(name = "username", nullable = false, unique = true)
	 private String username;
	 
	 @Column(name = "password", nullable = false)
	 private String passwordHash;
	 
	 @Column(name = "role", nullable = false)
	 private String role;
	 
	 public User(){
		 
	 }

	public User(String firstname, String lastname, String phone, String email, String username, String passwordHash,
			String role) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.phone = phone;
		this.email = email;
		this.username = username;
		this.passwordHash = passwordHash;
		this.role = role;
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

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	 
	 
}

package mock.project.backend.request;

import java.util.Date;

import mock.project.backend.entities.Roles;

public class UserDTO {
	
	private String userName;
	private String password;
	private String fullName;
	private String email;
	private String address;
	private String phone;
	private Date dateofBirth;
	private String image;
	private Roles role;
	
	public UserDTO() {
		super();
	}
	
	public UserDTO(String userName, String password, String fullName, String email, String address, String phone,
			Date dateofBirth, String image, Roles role) {
		super();
		this.userName = userName;
		this.password = password;
		this.fullName = fullName;
		this.email = email;
		this.address = address;
		this.phone = phone;
		this.dateofBirth = dateofBirth;
		this.image = image;
		this.role = role;
	}


	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getDateofBirth() {
		return dateofBirth;
	}
	public void setDateofBirth(Date dateofBirth) {
		this.dateofBirth = dateofBirth;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Roles getRole() {
		return role;
	}
	public void setRole(Roles role) {
		this.role = role;
	}
	
	
}


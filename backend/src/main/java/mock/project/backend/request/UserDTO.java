package mock.project.backend.request;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import mock.project.backend.entities.Roles;
import mock.project.backend.validation.ValidatedDuplicateRegister;

public class UserDTO {

	private Integer userId;

	@NotEmpty(message = "Vui lòng nhập UserName", groups = {LoginGroup.class, RegisterGroup.class})
	@Size(min = 2, message = "Cần nhập ít nhất 2 kí tự", groups = {RegisterGroup.class})
	@ValidatedDuplicateRegister(message = "Tên tài khoản đã được sử dụng", groups = {RegisterGroup.class})
	private String userName;

	@NotEmpty(message = "Vui lòng nhập Password", groups = {LoginGroup.class, RegisterGroup.class})
	private String password;

	@NotEmpty(message = "Vui lòng nhập FullName", groups = {RegisterGroup.class})
	private String fullName;

	@NotBlank(message = "Vui lòng nhập Email", groups = {RegisterGroup.class})
	@Email(message = "Email không đúng định dạng", groups = {RegisterGroup.class})
	@ValidatedDuplicateRegister(message = "Email đã được sử dụng", groups = {RegisterGroup.class})
	private String email;

	private String address;

	@NotEmpty(message = "Vui lòng nhập Phone", groups = {RegisterGroup.class})
	@Pattern(regexp = "(0[3|5|7|8|9])+([0-9]{8})\\b", message = "Phone không đúng định dạng", groups = {RegisterGroup.class})
	private String phone;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateofBirth;

	private String image;

	private Roles role;

	public UserDTO() {
		super();
	}

	public String getUserName() {
		return userName;
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

	public LocalDate getDateofBirth() {
		return dateofBirth;
	}

	public void setDateofBirth(LocalDate dateofBirth) {
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

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "UserDTO [userId=" + userId + ", userName=" + userName + ", password=" + password + ", fullName="
				+ fullName + ", email=" + email + ", address=" + address + ", phone=" + phone + ", dateofBirth="
				+ dateofBirth + ", image=" + image + ", role=" + role + "]";
	}
	
	public interface LoginGroup {}
	
	public interface RegisterGroup {}

}

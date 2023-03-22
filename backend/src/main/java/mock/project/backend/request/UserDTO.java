package mock.project.backend.request;

import java.time.LocalDate;
import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import mock.project.backend.entities.Roles;



public class UserDTO {
	
	private Integer userId;

	@NotEmpty(message = "Thiếu username")
	private String userName;
	
    @Min(value = 8, message = "Password phải từ 8 kí tự trở lên")
	private String password;
	
	@NotEmpty(message = "Thiếu fullName")
	private String fullName;
	
	@NotBlank
	@Email(message = "Email không hợp lệ")
	private String email;
	
	@NotEmpty(message = "Thiếu addresss")
	private String address;
	
	@Size(min =10 , max= 10,message = "Đủ 10 số nha")
	private String phone;
	
//	@DateTimeFormat(pattern = "MM/dd/yyyy")
////	@JsonFormat(pattern = "MM/dd/yyyy")
//	private Date dateofBirth;
	
	// A Dong viet
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private LocalDate dateofBirth;
	
	private String image;
	
	private Roles role;
	
	public UserDTO() {
		super();
	}
	
	
	public String getUserName() {
		return userName;
	}
	//A Dong viet
	public UserDTO(@NotEmpty(message = "Thiếu username") String userName,
		@NotEmpty(message = "Thiếu password") @Min(value = 8, message = "Password phải từ 8 kí tự trở lên") String password,
		@NotEmpty(message = "Thiếu fullName") String fullName,
		@NotBlank @Email(message = "Email không hợp lệ") String email,
		@NotEmpty(message = "Thiếu addresss") String address,
		@Size(min = 10, max = 10, message = "Đủ 10 số nha") String phone, LocalDate dateofBirth, String image,
		Roles role) {
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
	
}


package mock.project.backend.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class Users implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	
	@Column(name="user_name", length = 50)
	private String userName;
	
	@Column(name = "encrypted_password", length = 128)
	private String encryptedPassword;
	
	@Column(name="full_name",nullable = false, length = 50)
	private String fullName;
	
	@Column(name="email",nullable = false, length = 255)
	private String email;
	
	@Column(name="address",nullable = false, length = 50)
	private String address;
	
	@Column(name="phone",nullable = false, length = 25)
	private String phone;
	
	@Column(name="date_of_birth",nullable = false)
	private Date dateofBirth;
	
	@Column(name="image",length = 255)
	private String image;
	
	@Column(name = "enabled")
	private Boolean enabled;
	
//	@OneToOne
//	@JoinColumn(name="role_id",referencedColumnName="role_id")
//	private Roles role;
//	
	@OneToMany(cascade = CascadeType.ALL,mappedBy="user")
	private Set<Orders> orders;
	
	public Users() {
		super();
	}
	
public Users(String userName, String encryptedPassword, String fullName, String email, String address, String phone,
			Date dateofBirth, String image, Boolean enabled) {
		super();
		this.userName = userName;
		this.encryptedPassword = encryptedPassword;
		this.fullName = fullName;
		this.email = email;
		this.address = address;
		this.phone = phone;
		this.dateofBirth = dateofBirth;
		this.image = image;
		this.enabled = enabled;
	}

public Users(String userName, String encryptedPassword, String fullName, String email, String address, String phone,
			Date dateofBirth, String image) {
		super();
		this.userName = userName;
		this.encryptedPassword = encryptedPassword;
		this.fullName = fullName;
		this.email = email;
		this.address = address;
		this.phone = phone;
		this.dateofBirth = dateofBirth;
		this.image = image;
	}

//	public Users(String userName, String encryptedPassword, String fullName, String email, String address, String phone,
//			Date dateofBirth, String image, Roles role) {
//		super();
//		this.userName = userName;
//		this.encryptedPassword = encryptedPassword;
//		this.fullName = fullName;
//		this.email = email;
//		this.address = address;
//		this.phone = phone;
//		this.dateofBirth = dateofBirth;
//		this.image = image;
//		this.role = role;
//	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEncryptedPassword() {
		return encryptedPassword;
	}

	public void setEncryptedPassword(String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
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

//	public Roles getRole() {
//		return role;
//	}
//
//	public void setRole(Roles role) {
//		this.role = role;
//	}

	public Set<Orders> getOrders() {
		return orders;
	}

	public void setOrders(Set<Orders> orders) {
		this.orders = orders;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

}

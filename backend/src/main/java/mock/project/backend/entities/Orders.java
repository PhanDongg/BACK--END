package mock.project.backend.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="orders")
public class Orders implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "order_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderId;	
	
	@Column(name="order_date", length = 50)
	private LocalDate orderDate;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "status_id", referencedColumnName = "status_id")
	private Status status;
	
	@ManyToOne
	@JoinColumn(name="user_id", referencedColumnName = "user_id")
	private Users user;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy="order")
	private Set<OrderDetails> orderDetails;

	
	public Orders() {
		super();
	}

	public Orders(Integer orderId, LocalDate orderDate, Status status, Users user) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.status = status;
		this.user = user;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Set<OrderDetails> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(Set<OrderDetails> orderDetails) {
		this.orderDetails = orderDetails;
	}
	
}

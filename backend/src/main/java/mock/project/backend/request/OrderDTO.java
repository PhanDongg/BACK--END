package mock.project.backend.request;

import java.sql.Date;
import java.util.Set;

import mock.project.backend.entities.OrderDetails;
import mock.project.backend.entities.Users;

public class OrderDTO {
	
	private Integer orderId;
	private Date orderDate;
	private Users user;
	private Set<OrderDetails> orderDetails;
	
	
}

package mock.project.backend.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mock.project.backend.request.OrderDTO;
import mock.project.backend.services.OrderService;
import mock.project.backend.services.UserService;

@RestController
@RequestMapping("/api/order")
public class OrderController {
	private Logger logger = Logger.getLogger(OrderController.class);

	@Autowired
	private UserService userService;

	@Autowired
	private OrderService orderService;
	
	//Get list order of user
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<OrderDTO>> findOrderByUserId(@PathVariable("id")Integer userId,@RequestParam(name="page",required = false) Integer pageIndex) {
		return ResponseEntity.ok(orderService.findListOrdersByUserId(userId));
	}

}

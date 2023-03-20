package mock.project.backend.controller;

import java.util.List;

import javax.persistence.criteria.Order;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mock.project.backend.entities.Products;
import mock.project.backend.repository.OrderRepository;
import mock.project.backend.request.OrderDTO;
import mock.project.backend.request.ProductDTO;
import mock.project.backend.request.UserDTO;
import mock.project.backend.response.ResponseTransfer;
import mock.project.backend.services.OrderService;
import mock.project.backend.services.ProductService;
import mock.project.backend.services.UserService;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

	private Logger logger = Logger.getLogger(AdminController.class);

	@Autowired
	private UserService userService;

	@Autowired
	private OrderService orderService;

	@Autowired
	private ProductService productService;

	// list all user
	@GetMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<UserDTO>> finAllUser(
			@RequestParam(name = "page", required = false) Integer pageIndex) {
		if (pageIndex == null || pageIndex == 0) {
			Pageable pageable = PageRequest.of(0, 5);
			return ResponseEntity.ok(userService.findAllUser(pageable));
		}
		Pageable pageable = PageRequest.of(pageIndex, 5);
		return ResponseEntity.ok(userService.findAllUser(pageable));
	}

	@GetMapping(value = "/order", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<OrderDTO>> finAllOrder(
			@RequestParam(name = "page", required = false) Integer pageIndex) {
		if (pageIndex == null || pageIndex == 0) {
			Pageable pageable = PageRequest.of(0, 5);
			return ResponseEntity.ok(orderService.findAllOrder(pageable));
		}
		Pageable pageable = PageRequest.of(pageIndex, 5);
		return ResponseEntity.ok(orderService.findAllOrder(pageable));
	}

	@PutMapping(value = "/order/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseTransfer updateStatusOrder(@PathVariable("id") Integer orderId) {
		logger.info("Searching order by orderId...");
		OrderDTO orderDTO = orderService.findOrderById(orderId);
		orderService.save(orderDTO);
		return new ResponseTransfer("Updated successful!");

	}

	// update product by id
	@PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseTransfer updateProduct(@RequestBody Products product) {
		logger.info("Updating product.....");
		productService.save(product);
		return new ResponseTransfer("Update Successfull!");
	}

	// add new product
	@PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public Products saveProducts(@RequestBody Products product) {
		logger.info("Adding new product.....");
		return productService.save(product);
	}
	
	@GetMapping(value = "/product", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ProductDTO>> finAllProduct(
			@RequestParam(name = "page", required = false) Integer pageIndex) {
		if (pageIndex == null || pageIndex == 0) {
			Pageable pageable = PageRequest.of(0, 5);
			return ResponseEntity.ok(productService.findAllProduct(pageable));
		}
		Pageable pageable = PageRequest.of(pageIndex, 5);
		return ResponseEntity.ok(productService.findAllProduct(pageable));
	}
}

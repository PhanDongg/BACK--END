package mock.project.backend.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mock.project.backend.services.UserService;

@RestController
@RequestMapping("/api/order")
public class OrderController {
private Logger logger = Logger.getLogger(OrderController.class);
	
	@Autowired
	private UserService userService;
	
	
}
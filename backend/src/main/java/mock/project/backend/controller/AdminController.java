package mock.project.backend.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mock.project.backend.request.ProductDTO;
import mock.project.backend.request.UserDTO;
import mock.project.backend.services.UserService;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
	
	private Logger logger = Logger.getLogger(AdminController.class);
	
	@Autowired
	private UserService userService;
	
	//list all user
		@GetMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<List<UserDTO>> finAllProduct(@RequestParam(name="page",required = false) Integer pageIndex) {
			if (pageIndex == null || pageIndex == 0) {
				Pageable pageable = PageRequest.of(0, 5);
				return ResponseEntity.ok(userService.findAllUser(pageable));
			}
			Pageable pageable = PageRequest.of(pageIndex, 5);
			return ResponseEntity.ok(userService.findAllUser(pageable));
		}
		
		
		
		
}

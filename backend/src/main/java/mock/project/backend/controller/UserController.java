package mock.project.backend.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import mock.project.backend.entities.Users;
import mock.project.backend.repository.RoleRepository;
import mock.project.backend.request.OrderDTO;
import mock.project.backend.request.UserDTO;
import mock.project.backend.request.UserDTO.RegisterGroup;
import mock.project.backend.request.UserDTOReponse;
import mock.project.backend.services.OrderService;
import mock.project.backend.services.UserService;
import mock.project.backend.validation.ValidationError;
import mock.project.backend.validation.ValidationUtil;

@RestController
@RequestMapping("/api/user")
public class UserController {

	private Logger logger = Logger.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@Autowired
	private OrderService orderService;

	@Autowired
	private RoleRepository roleRepo;

	@Autowired
	private ModelMapper modelMap;

	// register new user back-end
	@PostMapping(value = "/register", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Map<String, String>> save(@RequestBody @Validated({RegisterGroup.class}) UserDTO userDTO,
			BindingResult bindingResult) throws Exception {
		Gson gson = new Gson();
		Map<String, String> map = new HashMap<String, String>();
		List<ValidationError> errors = new ArrayList<ValidationError>();
		errors = ValidationUtil.convertBindingResultToValidationErrors(bindingResult);

		logger.info(errors);
		
		if (errors.size() == 0) {
			userDTO.setRole(roleRepo.findById(2).get());
			Users newUser = userService.registerUserAccount(userDTO);
			if (newUser == null) {
				return ResponseEntity.badRequest().build();
			}
			return ResponseEntity.ok(convertListToJson(map, errors, gson, "Đăng kí thành công"));
		} else {
			return ResponseEntity.ok(convertListToJson(map, errors, gson, "Đăng kí thất bại"));
		}
	}

	public Map<String, String> convertListToJson(Map<String, String> map, List<ValidationError> errors, Gson gson,
			String msg) {
		map.put(msg, gson.toJson(errors));
		return map;
	}

	// get userInfo
	@GetMapping(value = "/info", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserDTO> getInfoByUserName(
			@RequestParam(value = "username", required = false) String username) throws Exception {
		logger.info("Searching user by username...");
		return ResponseEntity.ok(userService.findByUserName(username));
	}

	// get list order of user
	@GetMapping(value = "/order", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<OrderDTO> getOrderByUserID(@RequestParam(value = "userId", required = false) Integer userId)
			throws Exception {
		logger.info("Searching order by id...");
		return orderService.findListOrdersByUserId(userId);
	}

	// update
	@PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
	public UserDTOReponse updateInfoUser(@RequestParam(value = "username", required = false) String username,
			@RequestBody UserDTO userTDO, BCryptPasswordEncoder bCryptPasswordEncoder) throws Exception {
		logger.info("Updating userInf ..");
		userTDO.setUserId(userService.findByUserName(username).getUserId());
		userTDO.setUserName(username);
		userTDO.setRole(roleRepo.findById(2).get());
		UserDTOReponse userDTO = modelMap.map(userService.updateUserAccount(userTDO), UserDTOReponse.class);
		return userDTO;
	}

}

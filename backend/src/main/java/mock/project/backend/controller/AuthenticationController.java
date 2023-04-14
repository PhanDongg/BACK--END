package mock.project.backend.controller;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import mock.project.backend.config.TokenUtil;
import mock.project.backend.request.User;
import mock.project.backend.request.UserDTO;
import mock.project.backend.request.UserDTO.LoginGroup;
import mock.project.backend.validation.ValidationError;
import mock.project.backend.validation.ValidationUtil;

@RestController
@RequestMapping("/api/authenticate")
public class AuthenticationController {

	private Logger logger = Logger.getLogger(AuthenticationController.class);

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private TokenUtil tokenUtil;

	@Autowired
	private UserDetailsService userDetailsService;

	@GetMapping(value = "/logout", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> logoutPage(HttpServletRequest request, HttpServletResponse response) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication != null) {
			new SecurityContextLogoutHandler().logout(request, response, authentication);
			SecurityContextHolder.getContext().setAuthentication(null);
		}
		System.out.println(authentication);
		return ResponseEntity.ok("Logout successful!");
	}

	@PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Map<String, String>> createAthenticatioToken(
			@RequestBody @Validated({ LoginGroup.class }) UserDTO user, BindingResult bindingResult) throws Exception {
		Gson gson = new Gson();
		Map<String, String> map = new HashMap<String, String>();
		List<ValidationError> errors = ValidationUtil.convertBindingResultToValidationErrors(bindingResult);
		
		if (errors.size() == 0 && (authenticate(user.getUserName(), user.getPassword())).equals("successful")) {
			String token = null;
			UserDetails userDetails = userDetailsService.loadUserByUsername(user.getUserName());
			token = tokenUtil.generateToken(userDetails);
			return ResponseEntity.ok(convertListToJson(map, errors, gson, token));
		} else {
			return ResponseEntity.ok(convertListToJson(map, errors, gson, authenticate(user.getUserName(), user.getPassword())));
		}
	}

	public Map<String, String> convertListToJson(Map<String, String> map, List<ValidationError> errors, Gson gson,
			String msg) {
		map.put(msg, gson.toJson(errors));
		return map;
	}

	private String authenticate(String username, String password) throws Exception {
		try {
			UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
			authenticationManager.authenticate(token);
			return "successful";
		} catch (DisabledException e) {
			logger.error("account is disabled");
			return "disabled";
		} catch (BadCredentialsException e) {
			logger.error("Wrong password or username!");
			return "failure";
		}
	}

}

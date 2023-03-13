package mock.project.backend.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import mock.project.backend.entities.User;
import mock.project.backend.request.ProductDTO;
import mock.project.backend.request.UserDTOReponse;

@Controller
public class HomeController {
	private Logger logger = Logger.getLogger(HomeController.class);

	@Autowired
	private RestTemplate restTemplate;

	@Value("${product.api.url}")
	private String productApi;

	@Value("${user.api.url}")
	private String userApi;

	@GetMapping(value = { "/", "/login" })
	public String init(Model model) {
		logger.info("Loading login form...");
		model.addAttribute("user", new User());
		return "login";
	}

	@GetMapping("/homePage")
	public String initIndex(Principal principal, Model model) {
		logger.info(principal.getName());
		UserDetails loginedUser = (UserDetails) ((Authentication) principal).getPrincipal();
		logger.info(loginedUser);
		String url = productApi;
		ResponseEntity<ProductDTO[]> response = restTemplate.getForEntity(url, ProductDTO[].class);
		ProductDTO[] listProducts = response.getBody();
		model.addAttribute("userName", loginedUser.getUsername());
		model.addAttribute("listproducts", listProducts);
		return "homePage";
	}

	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public String accessDenied(Model model, Principal principal) {

		if (principal != null) {
			UserDetails loginedUser = (UserDetails) ((Authentication) principal).getPrincipal();

			logger.info(loginedUser);
			model.addAttribute("userInfo", loginedUser.getUsername());
			String message = "Hi " + principal.getName() + "<br> You do not have permission to access this page!";
			model.addAttribute("message", message);
		}
		return "403";
	}

	@RequestMapping(value = "/userInfo", method = RequestMethod.GET)
	public String userInfo(Model model, Principal principal) {

		// After user login successfully.
		String userName = principal.getName();
		logger.info("User Name: " + userName);
		UserDetails loginedUser = (UserDetails) ((Authentication) principal).getPrincipal();
		String url = userApi + "?username=" + loginedUser.getUsername();
		UserDTOReponse user = restTemplate.getForObject(url, UserDTOReponse.class);
		model.addAttribute("userInfo", user);
		return "userInfoPage";
	}

	@RequestMapping(value = "/loadAddJob", method = RequestMethod.GET)
	public String loadAddJob() {

		return "loadAddJob";
	}

	@RequestMapping(value = "/username", method = RequestMethod.GET)
	@ResponseBody
	public String currentUserName(Principal principal) {
		return principal.getName();
	}

	@RequestMapping(value = "/username-2", method = RequestMethod.GET)
	@ResponseBody
	public String currentUserName(Authentication authentication) {

		return authentication.getName();

	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication != null) {
			new SecurityContextLogoutHandler().logout(request, response, authentication);
		}
		return "redirect:/login?logout";
	}

}

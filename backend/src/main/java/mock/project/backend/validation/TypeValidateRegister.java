package mock.project.backend.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import mock.project.backend.services.UserService;

public class TypeValidateRegister implements ConstraintValidator<ValidatedDuplicateRegister, String> {
	
	@Autowired
	private UserService userService;
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if(userService.findByEmail(value) != null || userService.findByUserName(value) != null) {
			return false;
		}
		return true;
	}

	
}

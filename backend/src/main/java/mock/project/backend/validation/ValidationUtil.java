package mock.project.backend.validation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.validation.BindingResult;

public class ValidationUtil {

	public static List<ValidationError> convertBindingResultToValidationErrors(BindingResult bindingResult) {
		List<ValidationError> errors = new ArrayList<>();

		if (bindingResult.hasErrors()) {
			bindingResult.getFieldErrors().forEach(violation -> {
				String message = violation.getDefaultMessage();
				String field = violation.getField();
				String code = violation.getCode();

				ValidationError error = new ValidationError();
				error.setDefaultMessage(message);
				error.setField(field);
				error.setCode(code);
				errors.add(error);
			});
		}
		return errors;
	}
}

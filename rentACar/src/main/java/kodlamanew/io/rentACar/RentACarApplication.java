
package kodlamanew.io.rentACar;

import java.util.HashMap;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import kodlamanew.io.rentACar.core.utilities.exception.BusinessException;
import kodlamanew.io.rentACar.core.utilities.exception.ProblemDetails;
import kodlamanew.io.rentACar.core.utilities.exception.ValidationProblemDetails;

@SpringBootApplication
@RestControllerAdvice
public class RentACarApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentACarApplication.class, args);
	}

	 
	@ExceptionHandler
	@ResponseStatus(code=HttpStatus.BAD_REQUEST)
	public ProblemDetails HandleBusinessException(BusinessException businessException) {
		
		ProblemDetails problemDetails = new ProblemDetails();
		problemDetails.setMessage(businessException.getMessage());
		
		return problemDetails;
		
	}
	
	@ExceptionHandler
	@ResponseStatus(code=HttpStatus.BAD_REQUEST)
	public ProblemDetails handleValidationException(MethodArgumentNotValidException methodArgumentNotValidException) {
		
		ValidationProblemDetails validationproblemDetails = new ValidationProblemDetails();
		validationproblemDetails.setMessage("Validation Exception");
		
		for(FieldError fieldError : methodArgumentNotValidException.getBindingResult().getFieldErrors()) {
			
			validationproblemDetails.getValidationErrors().put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		
		validationproblemDetails.setValidationErrors(new HashMap<String, String>());
		
		return validationproblemDetails;
		
	}
	  
	
	
	@Bean
	public ModelMapper getModelMapper() {
		
		return new ModelMapper();
		
		
		//bu modelmapper yapısını dışarıdan aldığım için new'lemem gerekiyor(constructor'da kullandığım için)
		
	}
	
	
}

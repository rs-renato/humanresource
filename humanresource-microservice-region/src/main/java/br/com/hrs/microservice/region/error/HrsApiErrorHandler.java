package br.com.hrs.microservice.region.error;

import br.com.hrs.core.exception.HrsBusinessException;
import com.hrs.microservice.exception.ResourceNotFoundException;
import com.hrs.microservice.support.message.MensagemRetorno;
import com.hrs.microservice.support.message.MensagemRetornoCategoria;
import com.hrs.microservice.support.message.MensagemRetornoResponseEntitySupport;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.json.JsonException;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.sql.SQLSyntaxErrorException;
import java.text.MessageFormat;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestControllerAdvice(annotations=RestController.class)
public class HrsApiErrorHandler{
	
	private static Logger logger = LogManager.getLogger(HrsApiErrorHandler.class);

	private MessageSource messageSource;

	public HrsApiErrorHandler(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<MensagemRetorno> handleNotFound(ResourceNotFoundException ex){
		logger.warn("Could not find controller: {}", ex.getMessage());
		return MensagemRetornoResponseEntitySupport.createResponseEntity(MensagemRetornoCategoria.ALERTA, HttpStatus.NOT_FOUND, ex.getMessage());
	}

	@ExceptionHandler(HrsBusinessException.class)
	public ResponseEntity<MensagemRetorno> handleBadRequest(HrsBusinessException ex){
		logger.warn("An business exception has occurred: {}", ex.getMessage());
		return MensagemRetornoResponseEntitySupport.createResponseEntity(MensagemRetornoCategoria.ALERTA, HttpStatus.BAD_REQUEST, ex.getMessage());
	}
	
	@ExceptionHandler({IllegalArgumentException.class,
						NumberFormatException.class,
						HttpMessageNotReadableException.class,
						HttpRequestMethodNotSupportedException.class,
						JsonException.class})
	public ResponseEntity<MensagemRetorno> handleBadRequest(Exception ex){
		logger.error("An error has ocurred on request processs: {}", ex);
		return MensagemRetornoResponseEntitySupport.createResponseEntity(MensagemRetornoCategoria.ALERTA, HttpStatus.BAD_REQUEST, ex.getMessage());
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MensagemRetorno> handleBadRequest(MethodArgumentNotValidException ex){
		logger.error("An error has occurred on validation proccess (bean validation): {}", ex.getMessage());
		BindingResult bindingResult = ex.getBindingResult();
		List<String> errorMessages = bindingResult.getFieldErrors().stream()
			.map(fieldError -> messageSource.getMessage(fieldError, LocaleContextHolder.getLocale()))
			.collect(Collectors.toList());	
		return MensagemRetornoResponseEntitySupport.createResponseEntity(MensagemRetornoCategoria.ALERTA, HttpStatus.BAD_REQUEST, errorMessages);
	}

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<MensagemRetorno> handleBadRequest(ConstraintViolationException ex){
		logger.error("An error has occurred on validation proccess (bean validation): {}", ex.getMessage());
		Set<ConstraintViolation<?>> violations = ex.getConstraintViolations();
		List<String> errorMessages = violations.stream()
				.map(violation -> MessageFormat.format(violation.getMessage(), violation.getPropertyPath()))
				.collect(Collectors.toList());
		return MensagemRetornoResponseEntitySupport.createResponseEntity(MensagemRetornoCategoria.ALERTA, HttpStatus.BAD_REQUEST, errorMessages);
	}

	@ExceptionHandler(SQLSyntaxErrorException.class)
	public ResponseEntity<MensagemRetorno> handleInternalServerError(SQLSyntaxErrorException ex){
		logger.error("An internal error has occurred to query some data", ex);
		return MensagemRetornoResponseEntitySupport.createResponseEntity(MensagemRetornoCategoria.ERRO, HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
	}
	
	@ExceptionHandler(Throwable.class)
	public ResponseEntity<MensagemRetorno> handleInternalServerError(Throwable ex){
		logger.error("An internal error has occurred", ex);
		return MensagemRetornoResponseEntitySupport.createResponseEntity(MensagemRetornoCategoria.ERRO, HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
	}
}

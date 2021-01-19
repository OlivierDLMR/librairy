package Exposition.exception;

import Domain.exception.LibraryNotFoundException;
import Domain.exception.ValidationException;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import org.slf4j.Logger;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice(basePackages = "fr.training.spring.library")
public class LibraryResourceExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(LibraryResourceExceptionHandler.class);

    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(LibraryNotFoundException.class)
    public String libraryNotFound(final LibraryNotFoundException exception) {
        final String codeErreur = exception.getErrorCode();
        LOGGER.info("Error {} : {}", codeErreur, exception.getMessage());
        return codeErreur;
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ValidationException.class)
    public String validationFailed(final ValidationException exception) {
        final String codeErreur = exception.getErrorCode();
        LOGGER.info("Error {} : {}", codeErreur, exception.getMessage());
        return codeErreur;
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(final MethodArgumentNotValidException ex) {
        final Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            final String fieldName = ((FieldError) error).getField();
            final String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }


}

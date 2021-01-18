package Exposition.exception;

import Domain.exception.LibraryNotFoundException;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import org.slf4j.Logger;

@ControllerAdvice//(basePackages = "fr.training.spring.library")
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


}

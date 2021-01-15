package Domain.exception;

import Domain.exception.ErrorCodes;

public class LibraryNotFoundException extends RuntimeException{

    private static final long serialVersionUID =1L;

    private final String errorCode;

    public LibraryNotFoundException(final String message, String errorCode) {

        super(message);
        this.errorCode = errorCode;
    }

    public String getErrorCode(){
        return errorCode;
    }
}

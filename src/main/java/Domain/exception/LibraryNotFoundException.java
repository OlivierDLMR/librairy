package Domain.exception;

import Domain.exception.ErrorCodes;

public class LibraryNotFoundException extends BusinessException{

    private static final long serialVersionUID = 1L;

    public LibraryNotFoundException(final String message, final String errorCode) {
        super(message, errorCode);
    }
}

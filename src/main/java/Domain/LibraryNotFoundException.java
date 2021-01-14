package Domain;

public class LibraryNotFoundException {

    private static final long serialVersionUID =1L;

    private static final String ERROR_CODE = ErrorCodes.LIBRARY_NOT_FOUND;

    public LibraryNotFoundException(final String message) {
        super(message);
    }

    public String getErrorCode(){
        return ERROR_CODE;
    }
}

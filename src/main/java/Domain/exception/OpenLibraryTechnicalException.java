package Domain.exception;

import org.springframework.web.client.HttpStatusCodeException;

public class OpenLibraryTechnicalException extends  TechnicalException{

    private static final long serialVersionIUD = 1L;

    public OpenLibraryTechnicalException(final HttpStatusCodeException e) {
        super(e);
    }

}

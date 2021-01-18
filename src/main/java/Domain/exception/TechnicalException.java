package Domain.exception;

import org.springframework.web.client.HttpStatusCodeException;

public class TechnicalException extends  RuntimeException{

    private static final long serialVersionUID = 1L;

    public TechnicalException(final HttpStatusCodeException e) {
        super(e);
    }
}

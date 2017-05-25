package agreement.rest.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Radek on 18.05.2017.
 */
@ResponseStatus(value = HttpStatus.FOUND, reason = "found")
public class FoundException extends RuntimeException {

    public FoundException() {
    }

    public FoundException(String message) {
        super(message);
    }
}

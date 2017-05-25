package agreement.rest.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Radek on 30.03.2017.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "not found")
public class NotFoudException extends RuntimeException{

    public NotFoudException(String message){
        super(message);
    }
}

package agreement.core.exceptions;

import io.swagger.annotations.ResponseHeader;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.annotation.ResponseStatusExceptionResolver;

import java.util.Objects;

//import org.springframework.validation.FieldError;

/**
 * Created by Radek on 23.05.2017.
 */
@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(EmptyResultDataAccessException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handle(EmptyResultDataAccessException ex){
        System.out.println("Wyjątek" + ex);
    }

    @ExceptionHandler(UserRegistrationException.class)
//    @ResponseStatus(value = HttpStatus.FOUND, reason = "User already exists")
    public ResponseEntity<Object> handleUserRegistration(UserRegistrationException ex){

        String body;
        HttpStatus status = null;

        switch (ex.getFailReason()){
            case USER_ALREADY_EXISTS:   {
                body = "User already exists";
                status = HttpStatus.FOUND;
                break; }
            case USER_NOT_EXISTS:       {
                body = "User not exists";
                status = HttpStatus.NOT_FOUND;
                break;}
            default: { body = "Brak wiadomosci"; }
        }

        return new ResponseEntity<>(body, new HttpHeaders(), status);
    }

//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ResponseBody
//    private String validation(MethodArgumentNotValidException ex){
//        return "Wyjatek validation: " + ex;
//    }
}

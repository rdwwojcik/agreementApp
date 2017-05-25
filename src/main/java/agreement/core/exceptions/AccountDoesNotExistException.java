package agreement.core.exceptions;

/**
 * Created by Radek on 30.03.2017.
 */
public class AccountDoesNotExistException extends RuntimeException {

    public AccountDoesNotExistException(){}

    public AccountDoesNotExistException(String message){
        super(message);
    }
}

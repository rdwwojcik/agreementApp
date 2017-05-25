package agreement.core.exceptions;

/**
 * Created by Radek on 18.05.2017.
 */
public class UserRegistrationException extends RuntimeException {

    private FailReason failReason;

    public enum FailReason{
        USER_ALREADY_EXISTS,
        USER_NOT_EXISTS
    }

    public UserRegistrationException(FailReason failReason) {
        this.failReason = failReason;
    }

    public FailReason getFailReason(){
        return failReason;
    }
}

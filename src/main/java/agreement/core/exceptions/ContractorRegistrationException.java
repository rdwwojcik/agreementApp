package agreement.core.exceptions;

/**
 * Created by Radek on 13.06.2017.
 */
public class ContractorRegistrationException extends RuntimeException{

    private FailReason failReason;

    public enum FailReason{
        CONTRACTOR_NOT_FOUND,
        CONTRACTOR_ALREADY_EXIST
    }

    public ContractorRegistrationException(FailReason failReason) {
        this.failReason = failReason;
    }

    public FailReason getFailReason(){
        return failReason;
    }
}

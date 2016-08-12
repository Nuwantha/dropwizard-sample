package hms.techtalks.dropwizard.error;

/**
 * Created by sandarenu on 8/10/16.
 */
public class UserApiException  extends  Exception{
    public enum ErrorType{NotFound, ServerError};

    private ErrorType errorType;
    private String message;

    public UserApiException(ErrorType errorType, String message) {
        this.errorType = errorType;
        this.message = message;
    }

    public ErrorType getErrorType() {
        return errorType;
    }

    @Override
    public String getMessage() {
        return message;
    }
}

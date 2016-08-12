package hms.techtalks.dropwizard.msgs;

/**
 * Created by sandarenu on 12/16/15.
 */
public class ErrorResponse {
    private String code;
    private String message;
    private int httpStatusCode;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getHttpStatusCode() {
        return httpStatusCode;
    }

    public void setHttpStatusCode(int httpStatusCode) {
        this.httpStatusCode = httpStatusCode;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ErrorResponse{");
        sb.append("code='").append(code).append('\'');
        sb.append(", message='").append(message).append('\'');
        sb.append(", httpStatusCode='").append(httpStatusCode).append('\'');
        sb.append('}');
        return sb.toString();
    }
}

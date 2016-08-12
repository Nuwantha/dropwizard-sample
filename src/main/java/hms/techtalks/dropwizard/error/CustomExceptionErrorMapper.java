package hms.techtalks.dropwizard.error;

import hms.techtalks.dropwizard.msgs.ErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

/**
 * Created by sandarenu on 12/16/15.
 */
public class CustomExceptionErrorMapper implements ExceptionMapper<UserApiException> {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomExceptionErrorMapper.class);

    @Override
    public Response toResponse(UserApiException e) {
        if (e.getErrorType() == UserApiException.ErrorType.ServerError) {
            LOGGER.error(String.format("Error while request processing [%s]", e), e);
        } else {
            LOGGER.error(String.format("Error while request processing [%s]", e));
        }

        int httpCode = 500;
        if (e.getErrorType() == UserApiException.ErrorType.ServerError) {
            httpCode = 500;
        } else if (e.getErrorType() == UserApiException.ErrorType.NotFound) {
            httpCode = 404;
        }
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage(e.getMessage());
        errorResponse.setHttpStatusCode(httpCode);
        return Response.status(httpCode).entity(errorResponse).build();
    }
}

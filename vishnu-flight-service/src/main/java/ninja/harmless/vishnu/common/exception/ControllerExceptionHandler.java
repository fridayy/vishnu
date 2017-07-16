package ninja.harmless.vishnu.common.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author bnjm@harmless.ninja - 7/16/17.
 */
@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(MalformedUUIDException.class)
    public ResponseEntity<String> malformedUUIDexceptionHandler() {
        return new ResponseEntity<>("{ error : \"resource not found\"}", getJsonContentTypeHeaders(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RequestParameterNotFoundException.class)
    public ResponseEntity<String> requestParameterNotFoundHandler() {
        return new ResponseEntity<>("{ error : \"invalid request parameter.\"}", getJsonContentTypeHeaders(), HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> resourceNotFoundHandler() {
        return new ResponseEntity<>("{ error : \"resource could not be found.\"}", getJsonContentTypeHeaders(), HttpStatus.BAD_REQUEST);
    }

    private HttpHeaders getJsonContentTypeHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        return headers;
    }
}

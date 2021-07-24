package sgm.test.exception;

import lombok.extern.slf4j.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import javax.validation.*;
import java.util.*;
import java.util.stream.*;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<Object> unknownException(Exception ex) {
        log.error(ex.getMessage(), ex);
        if (ex.getMessage() != null && !ex.getMessage().equals("")) {
            return new ResponseEntity<>(Collections.singletonMap("errors",
                    Collections.singletonList(String.format("Error: %s, Message: %s", ex.getClass().getName(), ex.getMessage()))), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(Collections.singletonMap("errors",
                Collections.singletonList("Что то пошло не так")), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = {ConstraintViolationException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> violationException(ConstraintViolationException ex) {
        log.error(ex.getMessage(), ex);
        if (ex.getMessage() != null && !ex.getMessage().equals("")) {
            return new ResponseEntity<>(Collections.singletonMap("errors",
                    ex.getConstraintViolations().stream().map(
                            (cv) -> cv == null ? "null" : String.format("Message: %s", cv.getPropertyPath() + ": " + cv.getMessage())
                    ).collect(Collectors.toList())), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(Collections.singletonMap("errors",
                Collections.singletonList("Что то пошло не так")), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = {NotFoundException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<Object> notFoundException(NotFoundException ex) {
        log.error(ex.getMessage(), ex);
        if (ex.getMessage() != null && !ex.getMessage().equals("")) {
            return new ResponseEntity<>(Collections.singletonMap("errors",
                    Collections.singletonList(String.format("Message: %s", ex.getMessage()))), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(Collections.singletonMap("errors",
                Collections.singletonList("Что то пошло не так")), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}

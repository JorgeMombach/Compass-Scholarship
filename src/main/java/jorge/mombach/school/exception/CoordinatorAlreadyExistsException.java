package jorge.mombach.school.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CoordinatorAlreadyExistsException extends RuntimeException {

    public CoordinatorAlreadyExistsException(String msg) {
        super(msg);
    }
}

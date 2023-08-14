package jorge.mombach.school.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ScrumMasterAlreadyExistsException extends RuntimeException {

    public ScrumMasterAlreadyExistsException(String msg) {
        super(msg);
    }
}
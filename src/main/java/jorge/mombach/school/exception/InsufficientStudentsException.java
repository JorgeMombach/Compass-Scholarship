package jorge.mombach.school.exception;

public class InsufficientStudentsException extends RuntimeException {

    public InsufficientStudentsException(String message) {
        super(message);
    }
}

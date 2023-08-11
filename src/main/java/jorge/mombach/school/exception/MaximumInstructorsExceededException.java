package jorge.mombach.school.exception;

public class MaximumInstructorsExceededException extends RuntimeException {
    public MaximumInstructorsExceededException(String msg) {
        super(msg);
    }
}

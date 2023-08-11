package jorge.mombach.school.exception;

public class MaximumStudentsExceededException extends RuntimeException {
    public MaximumStudentsExceededException(String msg) {
        super(msg);
    }
}

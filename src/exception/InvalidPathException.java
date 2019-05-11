package exception;

public class InvalidPathException extends ApplicationException {
    final static String MESSAGE = "INVALID PATH";

    public InvalidPathException() {
        super(MESSAGE);
    }

    public InvalidPathException(Throwable cause) {
        super(MESSAGE, cause);
    }
}

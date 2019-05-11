package exception;

public class InvalidInputException extends ApplicationException {
    final static String MESSAGE = "CANNOT RECOGNIZE INPUT";

    public InvalidInputException() {
        super(MESSAGE);
    }

    public InvalidInputException(Throwable cause) {
        super(MESSAGE, cause);
    }
}

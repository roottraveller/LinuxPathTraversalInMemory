package exception;

public class DirectoryAlreadyExistsException extends ApplicationException {
    final static String MESSAGE = "DIRECTORY ALREADY EXISTS";

    public DirectoryAlreadyExistsException() {
        super(MESSAGE);
    }

    public DirectoryAlreadyExistsException(Throwable cause) {
        super(MESSAGE, cause);
    }
}

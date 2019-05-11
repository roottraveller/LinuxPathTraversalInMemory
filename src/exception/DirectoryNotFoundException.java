package exception;

public class DirectoryNotFoundException extends ApplicationException {
    final static String MESSAGE = "DIRECTORY DOES NOT EXIST";

    public DirectoryNotFoundException() {
        super(MESSAGE);
    }

    public DirectoryNotFoundException(Throwable cause) {
        super(MESSAGE, cause);
    }

}

package homeworks.medicalcenter.exception;

public class PersonNotFoundException extends Exception {
    public PersonNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public PersonNotFoundException() {
    }

    public PersonNotFoundException(String message) {
        super(message);
    }

    public PersonNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public PersonNotFoundException(Throwable cause) {
        super(cause);
    }
}

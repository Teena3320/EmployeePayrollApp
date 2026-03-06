package exceptions;

public class EmailValidationException extends ValidationException {
    public EmailValidationException(String msg) {
        super(msg);
    }
}
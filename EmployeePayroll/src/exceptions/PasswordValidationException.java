package exceptions;

public class PasswordValidationException extends ValidationException {
    public PasswordValidationException(String msg) {
        super(msg);
    }
}
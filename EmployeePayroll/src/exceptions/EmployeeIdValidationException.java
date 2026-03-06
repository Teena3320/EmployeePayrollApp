package exceptions;

public class EmployeeIdValidationException extends ValidationException {
    public EmployeeIdValidationException(String msg) {
        super(msg);
    }
}
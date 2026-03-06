package validation;

import exceptions.ValidationException;

import java.util.regex.Pattern;

public final class Validator {

    private static final Pattern EMAIL    = Pattern.compile("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
    private static final Pattern IN_PHONE = Pattern.compile("^[6-9]\\d{9}$");
    private static final Pattern EMP_ID   = Pattern.compile("^EMP-\\d{4}$");

    public static void validateEmail(String email) throws ValidationException {
        if (email == null || email.isBlank() || !EMAIL.matcher(email).matches()) {
            throw new ValidationException("Invalid email format.");
        }
    }

    public static void validatePhone(String phone) throws ValidationException {
        if (phone == null || phone.isBlank() || !IN_PHONE.matcher(phone).matches()) {
            throw new ValidationException("Invalid Indian phone number. Expected 10 digits starting with 6-9.");
        }
    }

    public static void validateEmpId(String empId) throws ValidationException {
        if (empId == null || empId.isBlank() || !EMP_ID.matcher(empId).matches()) {
            throw new ValidationException("Invalid Employee ID. Expected format: EMP-XXXX (X = digit).");
        }
    }

    public static void validateName(String name) throws ValidationException {
        if (name == null || name.trim().length() < 2) {
            throw new ValidationException("Name must be at least 2 characters.");
        }
    }

    public static void validateUsername(String username) throws ValidationException {
        if (username == null || username.trim().length() < 3) {
            throw new ValidationException("Username must be at least 3 characters.");
        }
    }

    public static void validatePassword(String password) throws ValidationException {
        if (password == null || password.length() < 6) {
            throw new ValidationException("Password must be at least 6 characters.");
        }
    }

    private Validator() {}
}
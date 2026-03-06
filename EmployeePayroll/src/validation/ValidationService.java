package validation;

import exceptions.*;

public class ValidationService {

    private static String sanitize(String input) {
        return (input == null) ? "" : input.trim();
    }

    /** EMAIL **/
    public static void validateEmail(String email) throws EmailValidationException {
        email = sanitize(email);
        if (!email.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
            throw new EmailValidationException("Invalid Email Format!");
        }
    }

    /** PHONE **/
    public static void validatePhone(String phone) throws PhoneValidationException {
        phone = sanitize(phone);
        if (!phone.matches("^[6-9][0-9]{9}$")) {
            throw new PhoneValidationException("Phone must be 10 digits starting 6-9");
        }
    }

    /** PASSWORD **/
    public static void validatePassword(String password) throws PasswordValidationException {
        password = sanitize(password);
        if (!password.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$%]).{6,}$")) {
            throw new PasswordValidationException(
                "Password must contain upper, lower, digit & special char (@#$%) and be 6+ chars"
            );
        }
    }

    /** EMPLOYEE ID **/
    public static void validateEmployeeId(String empId) throws EmployeeIdValidationException {
        empId = sanitize(empId);
        if (!empId.matches("^EMP-[0-9]{4}$")) {
            throw new EmployeeIdValidationException("Employee ID must follow EMP-0000 format");
        }
    }
}
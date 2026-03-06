package app;

import validation.ValidationService;
import exceptions.*;

import java.util.Scanner;

public class EmployeeInputValidation {

	/**
	 * ------------------ Main Class ------------------------
	 *
	 * Entry point for Use Case 6.
	 *
	 * Execution Flow:
     *
     * 1. Read user inputs
     * 2. Validate each input
     * 3. Stop immediately if validation fails
     * 4. Proceed only when all inputs are valid
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=== USE CASE 6: INPUT VALIDATION ===");

        try {

            System.out.print("Enter Employee ID (EMP-XXXX): ");
            String empId = sc.nextLine();

            System.out.print("Enter Email: ");
            String email = sc.nextLine();

            System.out.print("Enter Phone Number: ");
            String phone = sc.nextLine();

            System.out.print("Create Password: ");
            String pwd = sc.nextLine();

            ValidationService.validateEmployeeId(empId);
            ValidationService.validateEmail(email);
            ValidationService.validatePhone(phone);
            ValidationService.validatePassword(pwd);

            System.out.println("\n✔ All inputs are VALID. Registration/Login can proceed.");

        } catch (ValidationException ex) {

            System.out.println("\n❌ Validation Failed:");
            System.out.println(ex.getMessage());
        }
    }
}
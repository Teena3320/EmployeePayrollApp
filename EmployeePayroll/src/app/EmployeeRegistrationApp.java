package app;

import exceptions.ValidationException;
import domain.Employee;
import service.RegistrationService;

import java.io.IOException;
import java.util.Scanner;

public class EmployeeRegistrationApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RegistrationService service = new RegistrationService();

        System.out.println("=== USE CASE 1: EMPLOYEE REGISTRATION ===");

        try {
            System.out.print("Enter Employee ID (EMP-XXXX): ");
            String empId = sc.nextLine();

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Email: ");
            String email = sc.nextLine();

            System.out.print("Enter Phone (10 digits starting 6-9): ");
            String phone = sc.nextLine();

            System.out.print("Create Username: ");
            String username = sc.nextLine();

            System.out.print("Create Password: ");
            String password = sc.nextLine();

            Employee employee = service.register(empId, name, email, phone, username, password);

            System.out.println();
            System.out.println("----------------------------------------");
            System.out.println();
            System.out.println("Employee Registered Successfully:");
            System.out.println("Employee ID : " + empId);
            System.out.println("Name        : " + name);
            System.out.println("Email       : " + email);
            System.out.println("Phone       : " + phone);
            System.out.println("Username    : " + username);
            System.out.println();
            System.out.println("Data persisted in file: employee_data.txt");
            System.out.println("----------------------------------------");

        } catch (ValidationException e) {
            System.out.println("\nValidation Failed: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("\nError saving employee data!");
        } finally {
            sc.close();
        }
    }

    private static String emphasize(String s) {
        return s; 
    }
}
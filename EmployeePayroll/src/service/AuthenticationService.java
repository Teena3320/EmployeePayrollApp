package service;

import domain.Manager;
import domain.RegularEmployee;
import domain.Session;
import domain.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AuthenticationService {

    private Map<String, User> users = new HashMap<>();
    private int maxAttempts = 3;

    public AuthenticationService() {

        users.put("emp1", new RegularEmployee("emp1", "Emp@1234"));
        users.put("manager1", new Manager("manager1", "Mng@1234"));
    }

    public Session login() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Username: ");
        String username = sc.nextLine();

        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        User user = users.get(username);

        int attempts = 1;
        while (attempts <= maxAttempts) {
            if (user != null && user.authenticate(username, password)) {
                System.out.println();
                System.out.println("Login Successful!");
                System.out.println("Role: " + user.getRole());
                System.out.println();
                showDashboard(user.getRole());
                return new Session(user.getUsername());
            }

            if (attempts == maxAttempts) {
                System.out.println("\nToo many failed attempts. Access denied.");
                return null;
            }

            System.out.println("\nInvalid credentials. Try again (" + (maxAttempts - attempts) + " attempt(s) left).");
            System.out.print("Enter Username: ");
            username = sc.nextLine();

            System.out.print("Enter Password: ");
            password = sc.nextLine();

            user = users.get(username);
            attempts++;
        }
        return null;
    }

    private void showDashboard(String role) {
        System.out.println("======= DASHBOARD =======");
        if ("EMPLOYEE".equals(role)) {
            System.out.println("Employee Dashboard");
            System.out.println("View Payslip | Update Profile");
        } else if ("MANAGER".equals(role)) {
            System.out.println("Manager Dashboard");
            System.out.println("Approve Timesheets | View Team | Reports");
        } else {
            System.out.println("General Dashboard");
        }
        System.out.println();
    }
}

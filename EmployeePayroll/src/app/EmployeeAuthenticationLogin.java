package app;

/*
 * ------------------ Main Class ------------------------
 *
 * Entry point of Use Case 2.
 * 
 * Execution Flow:
 * - Trigger login
 * - Receive session
 * - Validate session state
 *
 * @author Developer
 * @version 2.0
 */
import domain.Session;
import service.AuthenticationService;

public class EmployeeAuthenticationLogin {

    public static void main(String[] args) {
        System.out.println("=== USE CASE 2: EMPLOYEE AUTHENTICATION & LOGIN ===");
        System.out.println();

        AuthenticationService auth = new AuthenticationService();
        Session session = auth.login();

        if (session != null) {
            System.out.println(session.toString());
            if (!session.isExpired()) {
                System.out.println("Session active and valid.");
            } else {
                System.out.println("Session expired.");
            }
        }
    }
}
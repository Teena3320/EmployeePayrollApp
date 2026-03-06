package app;

/**
 * ------------------ Main Class ------------------------
 *
 * Entry point for Use Case 3.
 *
 * Execution Flow:
 * 1. Capture employee details
 * 2. Capture salary components
 * 3. Generate payslip via service
 * 4. Display formatted payslip
 *
 * @author Developer
 * @version 3.0
 */


import domain.Employee;
import domain.Payslip;
import service.PayrollService;

import java.util.Scanner;

public class EmployeePayslipGeneration {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PayrollService payroll = new PayrollService();

        System.out.println("=== USE CASE 3: PAYSLIP GENERATION ===");

        System.out.print("Enter Employee ID (EMP-XXXX): ");
        String empId = sc.nextLine();

        System.out.print("Enter Employee Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Month (e.g., January 2026): ");
        String month = sc.nextLine();

        System.out.print("Enter Basic Salary: ");
        double basic = Double.parseDouble(sc.nextLine());

        System.out.print("Enter HRA: ");
        double hra = Double.parseDouble(sc.nextLine());

        System.out.print("Enter DA: ");
        double da = Double.parseDouble(sc.nextLine());

        System.out.print("Enter Allowances: ");
        double allowances = Double.parseDouble(sc.nextLine());

        Employee employee = new Employee(empId, name, null, null);

        Payslip payslip = payroll.generatePayslip(employee, month, basic, hra, da, allowances);

        System.out.println(payslip);

        sc.close();
    }
}
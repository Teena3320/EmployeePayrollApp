package app;

import domain.Employee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;

public class EmployeeDashboardDisplay {

	/**
	 * ------------------ Main Class ------------------------
	 *
	 * Entry point of Use Case 5.
	 * 
	 * Execution Flow:
	 * 1. Capture employee details
	 * 2. Prepare payslip data
	 * 3. Select dashboard at runtime
	 * 4. Display dashboard output
	 * 
	 * @author Developer
	 * @version 5.0
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("=== USE CASE 5: DASHBOARD DISPLAY ===");

		System.out.print("Enter Employee ID: ");
		String empId = sc.nextLine();                      
		System.out.print("Enter Employee Name: ");
		String name = sc.nextLine();                       
		System.out.print("Enter Role (EMPLOYEE/MANAGER): ");
		String role = sc.nextLine().trim().toUpperCase();  

		ArrayList<Payslip> payslips = new ArrayList<>();
		payslips.add(new Payslip("Jan", 30000.0));
		payslips.add(new Payslip("Feb", 32000.0));
		payslips.add(new Payslip("Mar", 31000.0));
		payslips.add(new Payslip("Apr", 33000.0));
		payslips.add(new Payslip("May", 34000.0));

		Employee employee = new Employee(empId, name, role);

		Dashboard dashboard = DashboardFactory.getDashboard(role);
		if (dashboard == null) {
			System.out.println("Invalid role. Please enter EMPLOYEE or MANAGER.");
			return;
		}

		dashboard.display(payslips, employee);
	}
	private static class Payslip {
		private final String month;
		private final double netPay;

		Payslip(String month, double netPay) {
			this.month = month;
			this.netPay = netPay;
		}

		public String getMonth()  { return month; }
		public double getNetPay() { return netPay; }

		@Override
		public String toString() { return month + " : " + netPay; }
	}

	private interface Dashboard {
		void display(ArrayList<Payslip> payslips, Employee employee);
	}

	private static class EmployeeDashboard implements Dashboard {

		@Override
		public void display(ArrayList<Payslip> payslips, Employee employee) {

			System.out.println("\n=== EMPLOYEE DASHBOARD ===");
			System.out.println("Welcome, " + employee.getName());

			System.out.println("Dashboard Type: session.EmployeeDashboard");

			Collections.sort(payslips, new Comparator<Payslip>() {
				@Override
				public int compare(Payslip p1, Payslip p2) {
					return Double.compare(p2.getNetPay(), p1.getNetPay());
				}
			});

			System.out.println("\nRecent Payslips (Top 3):");
			int count = 0;
			Iterator<Payslip> it = payslips.iterator();
			while (it.hasNext() && count < 3) {
				Payslip p = it.next();
				System.out.println(p);
				count++;
			}

			double total = 0;
			Iterator<Payslip> it2 = payslips.iterator();
			while (it2.hasNext()) {
				Payslip p = it2.next();
				total += p.getNetPay();
			}

			System.out.println("\nYear-To-Date Earnings: " + total);
		}
	}

	private static class ManagerDashboard implements Dashboard {

		@Override
		public void display(ArrayList<Payslip> payslips, Employee employee) {
			System.out.println("\n=== MANAGER DASHBOARD ===");
			System.out.println("Manager: " + employee.getName());
			System.out.println("Dashboard Type: com.bl.employeepayrollapp.session.ManagerDashboard");

			double total = 0;
			Iterator<Payslip> it = payslips.iterator();
			while (it.hasNext()) {
				Payslip p = it.next();
				total += p.getNetPay();
			}

			System.out.println("\nTeam Total YTD Earnings: " + total);
		}
	}

	private static class DashboardFactory {
		static Dashboard getDashboard(String role) {
			if ("EMPLOYEE".equalsIgnoreCase(role)) {
				return new EmployeeDashboard();
			} else if ("MANAGER".equalsIgnoreCase(role)) {
				return new ManagerDashboard();
			}
			return null;
		}
	}
}

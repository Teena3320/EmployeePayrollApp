package session;

import domain.Employee;
import domain.SimplePayslip;

import java.util.ArrayList;
import java.util.Iterator;

public class ManagerDashboard implements Dashboard {

	@Override
	public void display(ArrayList<SimplePayslip> payslips, Employee employee) {
		System.out.println("\n=== MANAGER DASHBOARD ===");
		System.out.println("Manager: " + employee.getName());
		System.out.println("Dashboard Type: " + this.getClass().getName());

		double total = 0;
		Iterator<SimplePayslip> it = payslips.iterator();
		while (it.hasNext()) {
			SimplePayslip p = it.next();
			total += p.getNetPay();
		}

		System.out.println("\nTeam Total YTD Earnings: " + total);
	}
}
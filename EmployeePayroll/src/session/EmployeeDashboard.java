package session;

import domain.Employee;
import domain.SimplePayslip;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class EmployeeDashboard implements Dashboard {

    @Override
    public void display(ArrayList<SimplePayslip> payslips, Employee employee) {

        System.out.println("\n=== EMPLOYEE DASHBOARD ===");
        System.out.println("Welcome, " + employee.getName());

        System.out.println("Dashboard Type: " + this.getClass().getName());

        Collections.sort(payslips, new Comparator<SimplePayslip>() {
            @Override
            public int compare(SimplePayslip p1, SimplePayslip p2) {
                return Double.compare(p2.getNetPay(), p1.getNetPay());
            }
        });

        System.out.println("\nRecent Payslips (Top 3):");
        int count = 0;
        Iterator<SimplePayslip> it = payslips.iterator();
        while (it.hasNext() && count < 3) {
            SimplePayslip p = it.next();
            System.out.println(p);
            count++;
        }

        double total = 0;
        Iterator<SimplePayslip> it2 = payslips.iterator();
        while (it2.hasNext()) {
            SimplePayslip p = it2.next();
            total += p.getNetPay();
        }

        System.out.println("\nYear-To-Date Earnings: " + total);
    }
}
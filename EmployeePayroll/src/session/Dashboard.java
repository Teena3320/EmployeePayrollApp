package session;

import domain.Employee;
import domain.SimplePayslip;

import java.util.ArrayList;

public interface Dashboard {
    void display(ArrayList<SimplePayslip> payslips, Employee employee);
}

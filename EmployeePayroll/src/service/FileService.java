package service;

import domain.Payslip;
import java.io.FileWriter;
import java.io.IOException;

public class FileService {

 public String savePayslipAsText(Payslip payslip) throws IOException {
     String name = "Payslip_" + payslip.getEmpId() + "_" + System.currentTimeMillis() + ".txt";
     try (FileWriter fw = new FileWriter(name)) { fw.write(payslip.toString()); }
     return name;
 }

 public String savePayslipAsPdf(Payslip payslip) throws IOException {
     String name = "Payslip_" + payslip.getEmpId() + "_" + System.currentTimeMillis() + ".pdf";
     try (FileWriter fw = new FileWriter(name)) { fw.write(payslip.toString()); }
     return name;
 }
}
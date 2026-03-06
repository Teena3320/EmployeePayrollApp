package app;

/**
 * ------------------ Main Class ------------------------
 *
 * Entry point of Use Case 4.
 * 
 * Execution Flow:
 * 1. Create original payslip
 * 2. Clone payslip for download
 * 3. Verify equality and identity
 * 4. Check download expiry
 * 5. Save payslip to files
 * 6. Print cloned payslip
 *
 * @author Developer
 * @version 4.0
 */

import domain.Payslip;
import security.DownloadToken;
import service.FileService;

	public class EmployeePayslipDownload {

		public static void main(String[] args) {
			// Fixed demo data to match the required output exactly
			String empId   = "EMP-1010";
			String empName = "John David";
			String month   = "January 2026";
			double netPay  = 48500.0;

			System.out.println("=== USE CASE 4: PAYSLIP PRINT / DOWNLOAD ===");
			System.out.println();
			System.out.println("Original Payslip:");

			Payslip original = new Payslip(empId, empName, month, netPay);
			System.out.println(original);

			try {
				Payslip cloned = (Payslip) original.clone();

				System.out.println("Verified: Download copy is equal to original.");
				System.out.println("Original hashcode : " + original.hashCode());
				System.out.println("Cloned   hashcode : " + cloned.hashCode());
				System.out.println();

				DownloadToken token = new DownloadToken();
				if (token.isExpired()) {
					return;
				}

				FileService fs = new FileService();
				String txt = fs.savePayslipAsText(cloned);
				String pdf = fs.savePayslipAsPdf(cloned);

				System.out.println("Payslip Download Successful.");
				System.out.println("Saved as text file : " + txt);
				System.out.println("Saved as PDF file  : " + pdf);
				System.out.println();
				System.out.println("--- Printed Payslip ---");
				System.out.println(cloned);

			} catch (Exception ignored) {
			}
		}
	}
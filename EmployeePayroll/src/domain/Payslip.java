package domain;

	public final class Payslip implements Cloneable {
	    private static final int LABEL_WIDTH = 14;

	    private final String empId;
	    private final String empName;
	    private final String month;
	    private final double netPay;

	    public Payslip(String empId, String empName, String month, double netPay) {
	        this.empId = empId;
	        this.empName = empName;
	        this.month = month;
	        this.netPay = netPay;
	    }

	    public String getEmpId()   { return empId; }
	    public String getEmpName() { return empName; }
	    public String getMonth()   { return month; }
	    public double getNetPay()  { return netPay; }

	    @Override
	    public Object clone() { return new Payslip(empId, empName, month, netPay); }

	    @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (!(o instanceof Payslip)) return false;
	        Payslip other = (Payslip) o;
	        return empId.equals(other.empId) && month.equals(other.month);
	    }

	    @Override
	    public int hashCode() {
	        int r = 17;
	        r = 31 * r + empId.hashCode();
	        r = 31 * r + month.hashCode();
	        return r;
	    }

	    @Override
	    public String toString() {
	        StringBuilder sb = new StringBuilder();
	        sb.append("PAYSLIP\n");
	        sb.append(String.format("%-" + LABEL_WIDTH + "s : %s%n", "Employee ID",   empId));
	        sb.append(String.format("%-" + LABEL_WIDTH + "s : %s%n", "Employee Name", empName));
	        sb.append(String.format("%-" + LABEL_WIDTH + "s : %s%n", "Month",         month));
	        sb.append(String.format("%-" + LABEL_WIDTH + "s : %s%n", "Net Pay",       String.valueOf(netPay)));
	        return sb.toString();
	    }
	}
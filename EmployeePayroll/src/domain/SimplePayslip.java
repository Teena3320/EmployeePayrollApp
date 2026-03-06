package domain;

public class SimplePayslip {
    private final String month;
    private final double netPay;

    public SimplePayslip(String month, double netPay) {
        this.month = month;
        this.netPay = netPay;
    }

    public String getMonth()  { return month; }
    public double getNetPay() { return netPay; }

    @Override
    public String toString() {
        return month + " : " + netPay;
    }
}
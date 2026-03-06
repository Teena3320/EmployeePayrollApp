package domain;

public class Employee {
    private String empId;
    private String name;
    private String email;
    private String phone;

    private UserAccount account;

    public Employee(String empId, String name, String email, String phone, UserAccount account) {
        this.empId = empId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.account = account;
    }

    public String getEmpId() { return empId; }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("Employee {").append('\n')
                .append("  empId: ").append(empId).append('\n')
                .append("  name : ").append(name).append('\n')
                .append("  email: ").append(email).append('\n')
                .append("  phone: ").append(phone).append('\n')
                .append("  ").append(account).append('\n')
                .append('}')
                .toString();
    }
}
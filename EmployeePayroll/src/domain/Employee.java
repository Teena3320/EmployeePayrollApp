package domain;

public class Employee {
    private final String empId;
    private final String name;
    private final String email;
    private final String phone;

    public Employee(String empId, String name, String email, String phone) {
        this.empId = empId;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public Employee(String empId, String name, String email, String phone, Object ignored) {
        this(empId, name, email, phone);
    }

    public String getEmpId() { return empId; }
    public String getName()  { return name; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("Employee {").append('\n')
                .append("  empId: ").append(empId).append('\n')
                .append("  name : ").append(name).append('\n')
                .append("  email: ").append(email).append('\n')
                .append("  phone: ").append(phone).append('\n')
                .append('}')
                .toString();
    }
}
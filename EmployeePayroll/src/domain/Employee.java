package domain;

public class Employee {
    private final String empId;
    private final String name;
    private final String role; 
    
    public Employee(String empId, String name, String role) {
        this.empId = empId;
        this.name = name;
        this.role = role;
    }

    public String getEmpId() { return empId; }
    public String getName()  { return name; }
    public String getRole()  { return role; }
}
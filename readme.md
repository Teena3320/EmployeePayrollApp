# Use Case 5 — Dashboard Display

## Goal
Show role-based dashboards, recent payslips, and year-to-date totals.

## Key OOP Concepts
- **Interface**: `Dashboard`
- **Factory**: `DashboardFactory` returns `EmployeeDashboard` or `ManagerDashboard`
- **Collections**: sort, iterate, top-3

## Flow
1. Enter Employee ID, Name, Role (EMPLOYEE/MANAGER)
2. Build sample payslip list (month, netPay)
3. Factory returns dashboard by role
4. Dashboard prints top-3 payslips and YTD total

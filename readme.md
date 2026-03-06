# Use Case 1 — Employee Registration

## Goal
Register a new employee with validated identity and login details, and persist the record.

## Key OOP Concepts
- **Encapsulation**: private fields in `Employee`, `UserAccount`
- **Constructor overloading** (if used)
- **Composition**: `Employee` HAS-A `UserAccount`
- **toString()** override for pretty print

## Flow
1. Collect input (ID, name, email, phone, username, password)
2. Validate input (regex rules)
3. Create `Employee` + `UserAccount`
4. Persist using repository (file)
5. Print confirmation summary

# Use Case 2 — Employee Authentication & Login

## Goal
Securely authenticate a user and show a role-based dashboard landing.

## Key OOP Concepts
- **Inheritance & Polymorphism**: `User` (abstract) → `RegularEmployee`, `Manager`
- **Method overriding**: `authenticate()`
- **Password hashing** (demo utility)
- **Session** management (timeout-ready)

## Flow
1. Enter username & password
2. `AuthenticationService` verifies using `User.authenticate()`
3. Create `Session` on success and show dashboard prompt

# Use Case 3 — Payslip Generation

## Goal
Generate a monthly payslip based on input salary components with clear earnings/deductions and net pay.

## Key OOP Concepts
- **Composition**: `Payslip` HAS-A `SalaryComponents`
- **Aggregation**: `Payslip` references `Employee`
- **Service** layer for calculations (separation of concerns)

## Flow
1. Collect employee basics + month
2. Collect salary inputs: `basic`, `hra`, `da`, `allowances`
3. `PayrollService` computes: gross, PF, tax, net pay
4. Print formatted payslip

# Use Case 4 — Payslip Print / Download

## Goal
Demonstrate immutability of a finalized payslip and safe cloning for print/download, with unique filenames and simple expiry token.

## Key OOP Concepts
- **Immutability**: `final` fields, no setters
- **Cloning**: safe copy for download/print
- **equals()/hashCode()** contract
- **File I/O** service abstraction

## Flow
1. Create an original `Payslip` (immutable)
2. Clone for download
3. Compare `equals()` and `hashCode()`
4. Check `DownloadToken` expiry
5. Save text/PDF (demo text) via `FileService`
6. Print the cloned payslip

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

# Use Case 6 — Input Validation (Exception Hierarchy)

## Goal
Centralize validation with a base exception and specific child exceptions, and handle all validation failures in one catch.

## Key OOP Concepts
- **Exception hierarchy**: `ValidationException` base + specific child exceptions
- **Validation service**: one place for all regex rules
- **Fail-fast**: stop on first invalid input

## Flow
1. Enter: Employee ID, Email, Phone, Password
2. `ValidationService` validates each input
3. Throw specific exceptions; catch base `ValidationException` in `main`
4. Print either “All inputs are VALID…” or “Validation Failed: …”

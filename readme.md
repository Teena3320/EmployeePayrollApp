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

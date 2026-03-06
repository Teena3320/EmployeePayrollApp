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

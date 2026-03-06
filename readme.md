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

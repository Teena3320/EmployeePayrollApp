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
4. 4. Persist using repository (file)
5. Print confirmation summary

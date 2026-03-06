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

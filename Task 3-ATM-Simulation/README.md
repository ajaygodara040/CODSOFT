# ATM Simulation

A console-based Java program that simulates basic ATM operations — withdraw, deposit, and balance check — using simple object-oriented design.

## How It Works

The program models two classes:

- **BankAccount** – Stores the account balance and provides methods to withdraw and deposit money, with basic validation (amount must be positive, withdrawal can't exceed balance).
- **ATM** – Handles user interaction for withdraw, deposit, and balance check operations, using a `BankAccount` object.

The `main` method starts the account with an initial balance and shows a menu-driven interface where the user can repeatedly choose an operation until they exit.

## Features

- **Withdraw** money (fails if amount is invalid or exceeds available balance)
- **Deposit** money (fails if amount is invalid, e.g. zero or negative)
- **Check Balance** at any time
- **Exit** the ATM with a goodbye message
- Menu keeps showing until the user selects Exit

## Requirements

- Java JDK 8 or above installed on your system.

## How to Run

1. Save the file as `ATMSimulation.java`.
2. Open a terminal in the folder containing the file.
3. Compile the program:
   ```
   javac ATMSimulation.java
   ```
4. Run the program:
   ```
   java ATMSimulation
   ```

## Sample Run

```
===== Welcome to the ATM =====

===== ATM Menu =====
1. Withdraw
2. Deposit
3. Check Balance
4. Exit
Choose an option: 3
Your current balance is: 4293.0

===== ATM Menu =====
1. Withdraw
2. Deposit
3. Check Balance
4. Exit
Choose an option: 1
Enter amount to withdraw: 500
Withdrawal successful. Amount withdrawn: 500.0
Remaining balance: 3793.0

===== ATM Menu =====
1. Withdraw
2. Deposit
3. Check Balance
4. Exit
Choose an option: 4
Thank you for using the ATM.Have a nice day. Goodbye!
```

## Class Overview

| Class       | Responsibility                                  |
|-------------|--------------------------------------------------|
| BankAccount | Holds balance, validates and processes withdraw/deposit |
| ATM         | Handles menu input/output and calls BankAccount methods |

## Possible Improvements

- Add PIN-based authentication before allowing transactions.
- Support multiple accounts/users with unique account numbers.
- Add a transaction history log (mini statement).
- Persist balance to a file or database so it's saved between runs.
- Add proper currency formatting (e.g., ₹4,293.00) instead of raw doubles.
- Add input validation for non-numeric menu choices.

## Author
AJAY KUMAR
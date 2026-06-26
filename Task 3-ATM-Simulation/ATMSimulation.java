import java.util.Scanner;

// Represents the user's bank account and stores the balance
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public boolean withdraw(double amount) {
        if (amount <= 0) {
            return false;
        }
        if (amount > balance) {
            return false;
        }
        balance -= amount;
        return true;
    }

    public boolean deposit(double amount) {
        if (amount <= 0) {
            return false;
        }
        balance += amount;
        return true;
    }
}

// Represents the ATM machine and its operations
class ATM {
    private BankAccount account;
    private Scanner sc;

    public ATM(BankAccount account, Scanner sc) {
        this.account = account;
        this.sc = sc;
    }

    public void withdraw() {
        System.out.print("Enter amount to withdraw: ");
        double amount = sc.nextDouble();

        if (amount <= 0) {
            System.out.println("Invalid amount. Please enter a positive value.");
        } else if (account.withdraw(amount)) {
            System.out.println("Withdrawal successful. Amount withdrawn: " + amount);
            System.out.println("Remaining balance: " + account.getBalance());
        } else {
            System.out.println("Withdrawal failed. Insufficient balance.");
            System.out.println("Current balance: " + account.getBalance());
        }
    }

    public void deposit() {
        System.out.print("Enter amount to deposit: ");
        double amount = sc.nextDouble();

        if (amount <= 0) {
            System.out.println("Invalid amount. Please enter a positive value.");
        } else if (account.deposit(amount)) {
            System.out.println("Deposit successful. Amount deposited: " + amount);
            System.out.println("Updated balance: " + account.getBalance());
        } else {
            System.out.println("Deposit failed. Please try again.");
        }
    }

    public void checkCurrentBalance() {
        System.out.println("Your current balance is: " + account.getBalance());
    }
}

public class ATMSimulation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        BankAccount myAccount = new BankAccount(4293.0); // starting balance
        ATM atm = new ATM(myAccount, sc);

       System.out.println("===== Welcome to the ATM =====");
        int menuOption;

        do {
            System.out.println("\n===== ATM Menu =====");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            menuOption = sc.nextInt();

            switch (menuOption) {
                case 1:
                    atm.withdraw();
                    break;
                case 2:
                    atm.deposit();
                    break;
                case 3:
                    atm.checkCurrentBalance();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM.Have a nice day. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please choose between 1 and 4.");
            }

        } while (menuOption != 4);

        sc.close();
    }
}

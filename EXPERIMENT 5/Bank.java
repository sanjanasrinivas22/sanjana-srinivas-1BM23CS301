import java.util.Scanner;

class Account {
    String customerName;
    int accountNumber;
    double balance;

    Account(String name, int accNumber) {
        customerName = name;
        accountNumber = accNumber;
        balance = 0.0;
    }

    void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount + "\nUpdated Balance: " + balance);
    }

    void displayBalance() {
        System.out.println("Account Balance: " + balance);
    }

    void withdraw(double amount) {
        System.out.println("Withdrawal is specific to account type.");
    }

    void computeInterest() {
        System.out.println("Interest computation not applicable for this account type.");
    }
}

class SavingsAccount extends Account {
    double interestRate = 0.04;

    SavingsAccount(String name, int accNumber) {
        super(name, accNumber);
    }

    void computeInterest() {
        double interest = balance * interestRate;
        balance += interest;
        System.out.println("Interest added: " + interest + "\nUpdated Balance: " + balance);
    }

    void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount + "\nUpdated Balance: " + balance);
        } else {
            System.out.println("Insufficient balance.");
        }
    }
}

class CurrentAccount extends Account {
    double minimumBalance = 500.0;
    double serviceCharge = 50.0;

    CurrentAccount(String name, int accNumber) {
        super(name, accNumber);
    }

    void checkMinimumBalance() {
        if (balance < minimumBalance) {
            System.out.println("Balance is below minimum. Service charge imposed.");
            balance -= serviceCharge;
            System.out.println("Service Charge: " + serviceCharge + "\nUpdated Balance: " + balance);
        }
    }

    void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount + "\nUpdated Balance: " + balance);
            checkMinimumBalance();
        } else {
            System.out.println("Insufficient balance.");
        }
    }
}

public class Bank{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter customer name: ");
        String name = sc.nextLine();
        System.out.print("Enter account number: ");
        int accNumber = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter account type (Savings/Current): ");
        String accType = sc.nextLine();

        Account account;
        if (accType.equalsIgnoreCase("Savings")) {
            account = new SavingsAccount(name, accNumber);
        } else if (accType.equalsIgnoreCase("Current")) {
            account = new CurrentAccount(name, accNumber);
        } else {
            System.out.println("Invalid account type.");
            sc.close();
            return;
        }

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Display Balance");
            System.out.println("4. Compute Interest");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the deposit amount: ");
                    double depositAmount = sc.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter the withdrawal amount: ");
                    double withdrawAmount = sc.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 3:
                    account.displayBalance();
                    break;
                case 4:
                    account.computeInterest();
                    break;
                case 5:
                    System.out.println("Exiting.");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
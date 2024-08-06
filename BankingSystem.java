import java.util.HashMap;
import java.util.Scanner;

// Customer class to store customer details
class Customer {
    private String name;
    private String accountNumber;
    private double balance;

    public Customer(String name, String accountNumber, double initialDeposit) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = initialDeposit;
    }

    public String getName() {
        return name;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. New balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: " + balance);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient funds.");
        }
    }
}

// Bank class to manage customer accounts
class Bank {
    private HashMap<String, Customer> accounts;

    public Bank() {
        accounts = new HashMap<>();
    }

    public void createAccount(String name, String accountNumber, double initialDeposit) {
        if (!accounts.containsKey(accountNumber)) {
            Customer customer = new Customer(name, accountNumber, initialDeposit);
            accounts.put(accountNumber, customer);
            System.out.println("Account created successfully.");
        } else {
            System.out.println("Account number already exists.");
        }
    }

    public void depositToAccount(String accountNumber, double amount) {
        Customer customer = accounts.get(accountNumber);
        if (customer != null) {
            customer.deposit(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    public void withdrawFromAccount(String accountNumber, double amount) {
        Customer customer = accounts.get(accountNumber);
        if (customer != null) {
            customer.withdraw(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    public void displayAccountDetails(String accountNumber) {
        Customer customer = accounts.get(accountNumber);
        if (customer != null) {
            System.out.println("Account Number: " + customer.getAccountNumber());
            System.out.println("Account Holder: " + customer.getName());
            System.out.println("Balance: " + customer.getBalance());
        } else {
            System.out.println("Account not found.");
        }
    }
}

// Main class to run the banking application
public class BankingSystem {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nWelcome to the Banking System");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Display Account Details");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Enter name: ");
                    scanner.nextLine(); // Consume newline
                    String name = scanner.nextLine();
                    System.out.print("Enter account number: ");
                    String accountNumber = scanner.nextLine();
                    System.out.print("Enter initial deposit: ");
                    double initialDeposit = scanner.nextDouble();
                    bank.createAccount(name, accountNumber, initialDeposit);
                    break;
                case 2:
                    System.out.print("Enter account number: ");
                    scanner.nextLine(); // Consume newline
                    accountNumber = scanner.nextLine();
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    bank.depositToAccount(accountNumber, depositAmount);
                    break;
                case 3:
                    System.out.print("Enter account number: ");
                    scanner.nextLine(); // Consume newline
                    accountNumber = scanner.nextLine();
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawalAmount = scanner.nextDouble();
                    bank.withdrawFromAccount(accountNumber, withdrawalAmount);
                    break;
                case 4:
                    System.out.print("Enter account number: ");
                    scanner.nextLine(); // Consume newline
                    accountNumber = scanner.nextLine();
                    bank.displayAccountDetails(accountNumber);
                    break;
                case 5:
                    System.out.println("Exiting the system. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}

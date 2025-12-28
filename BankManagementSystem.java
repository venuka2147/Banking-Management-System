import java.util.ArrayList;
import java.util.Scanner;

public class BankManagementSystem {
    static class BankAccount {
        int accountNumber;
        String accountHolderName;
        double balance;

        BankAccount(int accNo, String name, double bal) {
            accountNumber = accNo;
            accountHolderName = name;
            balance = bal;
        }

        void deposit(double amount) {
            balance += amount;
            System.out.println("Deposit successful!");
        }

        void withdraw(double amount) {
            if (amount > balance) {
                System.out.println("Insufficient balance!");
            } else {
                balance -= amount;
                System.out.println("Withdrawal successful!");
            }
        }

        void display() {
            System.out.println("Account Number : " + accountNumber);
            System.out.println("Account Holder : " + accountHolderName);
            System.out.println("Balance        : " + balance);
        }
    }

    static ArrayList<BankAccount> accounts = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    static BankAccount findAccount(int accNo) {
        for (BankAccount acc : accounts) {
            if (acc.accountNumber == accNo) {
                return acc;
            }
        }
        return null;
    }

    static void createAccount() {
        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Account Holder Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Initial Balance: ");
        double bal = sc.nextDouble();

        accounts.add(new BankAccount(accNo, name, bal));
        System.out.println("Account created successfully!");
    }

    static void depositMoney() {
        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();

        BankAccount acc = findAccount(accNo);
        if (acc != null) {
            System.out.print("Enter amount to deposit: ");
            acc.deposit(sc.nextDouble());
        } else {
            System.out.println("Account not found!");
        }
    }

    static void withdrawMoney() {
        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();

        BankAccount acc = findAccount(accNo);
        if (acc != null) {
            System.out.print("Enter amount to withdraw: ");
            acc.withdraw(sc.nextDouble());
        } else {
            System.out.println("Account not found!");
        }
    }

    static void checkBalance() {
        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();

        BankAccount acc = findAccount(accNo);
        if (acc != null) {
            acc.display();
        } else {
            System.out.println("Account not found!");
        }
    }

    
    public static void main(String[] args) {

        int choice;
        do {
            System.out.println("\n===== Banking Management System =====");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1 -> createAccount();
                case 2 -> depositMoney();
                case 3 -> withdrawMoney();
                case 4 -> checkBalance();
                case 5 -> System.out.println("Thank you for using Banking System!");
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 5);
    }
}

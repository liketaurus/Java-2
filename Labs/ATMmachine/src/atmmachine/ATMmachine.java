package atmmachine;

import java.util.Scanner;

public class ATMmachine {

    private final String bankName;
    private double accountBalance;

    public ATMmachine(String bankName, double accountBalance) {
        this.bankName = bankName;
        this.accountBalance = accountBalance;
    }

    public void withdrawMoney(double amount) {
        if (amount > 0 && amount <= accountBalance) {
            accountBalance -= amount;
            System.out.println("Withdrawal successfull! Remaining balance: $" + accountBalance);
        } else {
            System.out.println("ERROR! Invalid withdrawal amount or insuffisient funds!");
        }
    }

    public void topUpMobile(double amount) {
        if (amount > 0 && amount <= accountBalance) {
            accountBalance -= amount;
            System.out.println("Mobile top up successfull! Remaining balance: $" + accountBalance);
        } else {
            System.out.println("ERROR! Invalid withdrawal amount or insuffisient funds!");
        }
    }

    public void payBill(double amount) {
        if (amount > 0 && amount <= accountBalance) {
            accountBalance -= amount;
            System.out.println("Bill payment successfull! Remaining balance: $" + accountBalance);
        } else {
            System.out.println("ERROR! Invalid withdrawal amount or insuffisient funds!");
        }
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public static void main(String[] args) {

        if (args.length != 2) {
            System.out.println("ERROR! Arguments not provided!\nUsage: java ATMmachine <bankName> <initialBalance>!");
            System.exit(0);
        }
        // initial balance and bank name
        String bankName = args[0];
        double initialBalance = Double.parseDouble(args[1]);

        ATMmachine atm = new ATMmachine(bankName, initialBalance);

        System.out.println("Welcome to " + bankName + "!\nYou have $" + initialBalance + " amount");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Withdraw money\n2. Top up mobile\n3. Pay bill\n4. Check balance\n5. Exit\n");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("\nEnter withdrawal amount: ");
                    double withdrawalAmount = scanner.nextDouble();
                    atm.withdrawMoney(withdrawalAmount);
                    break;
                case 2:
                    System.out.print("\nEnter top up amount for mobile: ");
                    double topUpAmount = scanner.nextDouble();
                    atm.topUpMobile(topUpAmount);
                    break;
                case 3:
                    System.out.print("\nEnter bill payment amount: ");
                    double billAmount = scanner.nextDouble();
                    atm.payBill(billAmount);
                    break;
                case 4:
                    System.out.println("Current balance: $"+atm.getAccountBalance());
                    break;
                case 5:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Try again!");

            }
        }

    }

}

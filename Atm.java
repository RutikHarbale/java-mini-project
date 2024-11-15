import java.util.Scanner;

public class Atm{
    // Array to hold user data: [0] = balance, [1] = PIN
    static int[] account = {1000, 4444}; // Initial balance and PIN

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the ATM");

        // Authenticate the user
        if (authenticate(scanner)) {
            boolean exit = false;

            while (!exit) {
                // Display options
                System.out.println("\nPlease choose an option:");
                System.out.println("1. Check Balance");
                System.out.println("2. Withdraw Money");
                System.out.println("3. Deposit Money");
                System.out.println("4. Exit");

                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        checkBalance();
                        break;
                    case 2:
                        withdrawMoney(scanner);
                        break;
                    case 3:
                        depositMoney(scanner);
                        break;
                    case 4:
                        exit = true;
                        System.out.println("Thank you for using the ATM. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            }
        } else {
            System.out.println("Authentication failed. Exiting.");
        }
        scanner.close();
    }

    // Method to authenticate the user
    public static boolean authenticate(Scanner scanner) {
        System.out.print("Please enter your PIN: ");
        int enteredPin = scanner.nextInt();
        return enteredPin == account[1];
    }

    // Method to check the balance
    public static void checkBalance() {
        System.out.println("Your current balance is: $" + account[0]);
    }

    // Method to withdraw money
    public static void withdrawMoney(Scanner scanner) {
        System.out.print("Enter amount to withdraw: ");
        int amount = scanner.nextInt();

        if (amount > account[0]) {
            System.out.println("Insufficient funds.");
        } else if (amount <= 0) {
            System.out.println("Invalid amount.");
        } else {
            account[0] -= amount;
            System.out.println("Please take your cash. Your new balance is: $" + account[0]);
        }
    }

    // Method to deposit money
    public static void depositMoney(Scanner scanner) {
        System.out.print("Enter amount to deposit: ");
        int amount = scanner.nextInt();

        if (amount <= 0) {
            System.out.println("Invalid amount.");
        } else {
            account[0] =   amount+amount;
            System.out.println("Deposit successful. Your new balance is: $" + account[0]);
        }
    }
}

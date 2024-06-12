import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ATMInterface atmInterface = new ATMInterface();

        System.out.print("Enter User ID: ");
        String userId = scanner.nextLine();
        System.out.print("Enter PIN: ");
        String pin = scanner.nextLine();

        if (atmInterface.validateUser(userId, pin)) {
            int choice;
            do {
                System.out.println("\nATM Menu:");
                System.out.println("1. Transaction History");
                System.out.println("2. Withdraw");
                System.out.println("3. Deposit");
                System.out.println("4. Transfer");
                System.out.println("5. Quit");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        atmInterface.showTransactionHistory();
                        break;
                    case 2:
                        System.out.print("Enter amount to withdraw: ");
                        double withdrawAmount = scanner.nextDouble();
                        atmInterface.withdraw(withdrawAmount);
                        break;
                    case 3:
                        System.out.print("Enter amount to deposit: ");
                        double depositAmount = scanner.nextDouble();
                        atmInterface.deposit(depositAmount);
                        break;
                    case 4:
                        System.out.print("Enter amount to transfer: ");
                        double transferAmount = scanner.nextDouble();
                        System.out.print("Enter recipient User ID: ");
                        scanner.nextLine(); // consume newline
                        String recipientId = scanner.nextLine();
                        atmInterface.transfer(transferAmount, recipientId);
                        break;
                    case 5:
                        System.out.println("Thank you for using our ATM. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } while (choice != 5);
        } else {
            System.out.println("Invalid User ID or PIN. Please try again.");
        }

        scanner.close();
    }
}

import java.util.HashMap;
import java.util.Map;

public class ATMInterface {
    private Map<String, User> users;
    private User currentUser;

    public ATMInterface() {
        users = new HashMap<>();
        // Example users
        users.put("user1", new User("user1", "1234"));
        users.put("user2", new User("user2", "5678"));
    }

    public boolean validateUser(String userId, String pin) {
        User user = users.get(userId);
        if (user != null && user.getPin().equals(pin)) {
            currentUser = user;
            return true;
        }
        return false;
    }

    public void showTransactionHistory() {
        System.out.println("\nTransaction History:");
        for (Transaction transaction : currentUser.getAccount().getTransactionHistory()) {
            System.out.println(transaction);
        }
    }

    public void withdraw(double amount) {
        if (currentUser.getAccount().withdraw(amount)) {
            System.out.println("Withdrawal successful.");
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    public void deposit(double amount) {
        currentUser.getAccount().deposit(amount);
        System.out.println("Deposit successful.");
    }

    public void transfer(double amount, String recipientUserId) {
        User recipient = users.get(recipientUserId);
        if (recipient != null && currentUser.getAccount().withdraw(amount)) {
            recipient.getAccount().deposit(amount);
            currentUser.getAccount().addTransaction(new Transaction("Transfer to " + recipientUserId, amount));
            recipient.getAccount().addTransaction(new Transaction("Transfer from " + currentUser.getUserId(), amount));
            System.out.println("Transfer successful.");
        } else {
            System.out.println("Transfer failed. Please check the recipient User ID and your balance.");
        }
    }
}

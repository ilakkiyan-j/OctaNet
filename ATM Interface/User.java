public class User {
    private String userId;
    private String pin;
    private Account account;

    public User(String userId, String pin) {
        this.userId = userId;
        this.pin = pin;
        this.account = new Account();
    }

    public String getUserId() {
        return userId;
    }

    public String getPin() {
        return pin;
    }

    public Account getAccount() {
        return account;
    }
}


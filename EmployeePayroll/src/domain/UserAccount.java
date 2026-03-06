package domain;

public class UserAccount {
    private final String username;
    private final String password; // demo only

    public UserAccount(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String username() { return username; }

    @Override
    public String toString() {
        String masked = (username == null || username.isEmpty()) ? "N/A" : username.charAt(0) + "***";
        return "UserAccount { username='" + masked + "' }";
    }
}

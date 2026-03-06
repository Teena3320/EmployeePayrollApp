package domain;

public class Session {

    private String username;
    private long loginTime;
    private long timeoutMillis;

    public Session(String username) {
        this.username = username;
        this.loginTime = System.currentTimeMillis();
        this.timeoutMillis = 15 * 60 * 1000L; 
    }

    public boolean isExpired() {
        return (System.currentTimeMillis() - loginTime) > timeoutMillis;
    }

    public String toString() { return "Session active for user: " + username; }
}
package validation;

public final class PasswordUtil {

    public static String hash(String password) {
        
    	if (password == null) return "0";
        int h = password.hashCode();
        return "H" + Integer.toHexString(h);
    }

    private PasswordUtil() {}
}

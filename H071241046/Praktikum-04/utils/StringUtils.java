package login_app.utils;

public class StringUtils {
    public static String getNickName(String fullName) {
        String[] parts = fullName.trim().split(" ");
        if (parts.length == 1) {
            return parts[0];
        } else {
            return parts[1];
        }
    }
}

package login_app.utils;

public class StringUtils {
    // todo 5
    public static String generateNickName(String fullName) {
        String[] names = fullName.trim().split(" ");
        if (names.length == 1) {
            return names[0];
        } else {
            return names[1];
        }
    }
}
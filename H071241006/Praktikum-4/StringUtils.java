public class StringUtils {

    public static String generateNickName(String fullName) {
        String[] parts = fullName.trim().split("\\s+"); 
        if (parts.length == 1) {
            return parts[0];
        } else {
            return parts[1]; 
        }
    }
}

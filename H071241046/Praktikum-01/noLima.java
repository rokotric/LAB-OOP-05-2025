import java.util.Scanner;

public class noLima {
    public static void main(String[] args) {

        var sc = new Scanner(System.in);

        String password = sc.nextLine();

        if(passChecker(password)) {
            System.out.println("Valid");
        } else{
            System.out.println("Invalid");
        }

    }

    static boolean passChecker(String password){

        boolean adaAngka = false;
        boolean adaUpper = false;
        boolean adaLower = false;

        for (char ele : password.toCharArray()) {
//            if (Character.isDigit(ele)) {
//                adaAngka = true;
//            } else if (Character.isUpperCase(ele)) {
//                adaUpper = true;
//            } else if (Character.isLowerCase(ele)) {
//                adaLower = true;
//            }
            adaAngka |= Character.isDigit(ele);
            adaUpper |= Character.isUpperCase(ele);
            adaLower |= Character.isLowerCase(ele);

            if(adaAngka && adaUpper && adaLower){
                return true;
            }
        }

        return false;
    }
}

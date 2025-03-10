import java.util.InputMismatchException;
import java.util.Scanner;

public class noDua {
    public static void main(String[] args) {
        var sc = new Scanner(System.in);

        int[][] array2D = {
            {1,2,3,10},
            {4,5,6,20},
            {7,8,9,30}
        };



        try{
            System.out.print("Input number : \n> ");
            int numIn = sc.nextInt();

            boolean result = false;
            for(int i = 0; i < array2D.length; i++){
                for(int j = 0 ; j < array2D[i].length; j++ ){
                    if (numIn == array2D[i][j]){
                        result = true;
                        System.out.println("Found " + numIn + " at [" + (i + 1) + "][" + (j + 1) +"]");
                    }
                }
            }
            if (!result){
                System.out.println(numIn + " not found");
            }
        } catch (InputMismatchException e){
            System.out.println("input invalid : " + e.getMessage());
        } catch (Exception e){
            System.out.println("error : " + e.getMessage());
        }


    }

}

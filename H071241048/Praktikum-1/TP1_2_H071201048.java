import java.util.Scanner;

public class TP1_2_H071201048 {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        
        try {
            System.out.print("input berupa satu bilangan bulat: ");
            int input = x.nextInt();
    
            int[][] nums = {{1,2,3}, {4,5,6}, {7,4,9}};
            
            boolean flag = false;

            for (int baris = 0 ; baris < nums.length; baris++){
                for (int kolom= 0 ; kolom < nums[baris].length; kolom++){
                    if ( nums[baris][kolom] == input){
                        System.out.println("Founds "+ input + " at " + "["+baris+"]" + "["+kolom+"]");
                        flag = true;
                    }
                }
            }
            
            if(!flag){
                System.out.println("gadaa broo ");
            }
            
        } catch (Exception e) {
            System.out.println("Inputan harus angka boss ga valid nihh ");
            
        } finally{
            x.close();
        }

    }
}

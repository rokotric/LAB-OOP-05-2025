import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class noSatu {

    public static void main(String[] args) {

        var sc = new Scanner(System.in);


        System.out.print("Masukkan Judul : \n> ");
        String judul = sc.nextLine();

        String judulOut = titleTool(judul);
        System.out.println(judulOut);
    }





    static String titleTool(String kalimat){
        String[] kataArray = kalimat.split(" ");
        String result = "";

        for(String kata : kataArray){
            if(kata.length() > 0){
                result += Character.toUpperCase(kata.charAt(0)) + kata.substring(1).toLowerCase() + " ";
            }
        }
        return  result;
    }

}
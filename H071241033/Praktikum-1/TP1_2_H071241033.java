import java.util.Scanner;

public class TP1_2_H071241033 {
    static void cari_bilangan() {
        int[][] numsArr = {
            {1,2,3},
            {4,5,6},
            {7,8,9}
        };
        System.out.println("Matriks 3*3: ");
        for (int i=0; i<3; i++){      //looping utk menampilkan matriks
            for (int j=0; j<3; j++) {
                System.out.print(numsArr[i][j] + " ");
            }
            System.out.println();
        }
        
        int num;
        Scanner scanner = new Scanner (System.in);
        while (true) {  //looping sampai input benar adalah angka
            try {
                System.out.print("Masukkan angka yang ingin dicari: ");
                num = scanner.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("Input tidak valid\n");
                scanner.next();  // membersihkan input yang salah
            }
        }
        
        boolean found = false;
        int x=-1, y=-1;
        for (int i=0; i<3; i++) {    //utk mengecek apakah input ada dalam matriks atau tdk
            for (int j=0; j<3; j++) {
                if (numsArr[i][j] == num) {
                    found = true;
                    x = i;
                    y = j;
                    break;
                }
            }
            if (found) break;
        }
        
        if (found == false) {
            System.out.println("Angka " + num +  " tidak ditemukan");
        } else {
            System.out.println("Angka " + num + " ditemukan di [" + x + "][" + y + "]" );
        }
        scanner.close();
    }


    public static void main(String[] args) {
        cari_bilangan();
    }
}
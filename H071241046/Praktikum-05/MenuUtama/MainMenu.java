package MenuUtama;

import java.util.Scanner;
import Character.*;

public class MainMenu {

    Scanner input = new Scanner(System.in);

    public void mainMenu(Hero archer, Hero witcher, Hero fighter) {
        while (true) {
            System.out.println("Pilih Karakter");
            System.out.println("1. Archer");
            System.out.println("2. Witcher");
            System.out.println("3. Fighter");
            System.out.println("4. Keluar");

            String pilihan = input.nextLine();

            if (pilihan.equals("1")) {
                menuHero(archer);
            } else if (pilihan.equals("2")) {
                menuHero(witcher);
            } else if (pilihan.equals("3")) {
                menuHero(fighter);
            } else if (pilihan.equals("4")) {
                break;
            } else {
                System.out.println("Input tidak valid!");
            }
        }
    }

    void menuHero(Hero hero){
        while(true){
            System.out.println("Menu " + hero.getClass().getSimpleName() + " :");
            System.out.println("1. Serang");
            System.out.println("2. Keluar");
            System.out.print("--> ");
            String pilihan = input.nextLine();
            if (pilihan.equals("1")) {
                hero.serang();
            } else if (pilihan.equals("2")) {
                break;
            } else{
                System.out.println("Input tidak valid!");
            }
        }
    }

//    void menuArcher(Archer archer){
//        while(true){
//            System.out.println("Pilih :");
//            System.out.println("1. Serang");
//            System.out.println("2. Keluar");
//            System.out.print("--> ");
//            String pilihan  = input.nextLine();
//            if(pilihan.equals("1")){
//                archer.serang();
//            } else if(pilihan.equals("2")){
//                break;
//            } else{
//                System.out.println("Input tidak valid!");
//            }
//        }
//    }
//
//    void menuWitcher(Witcher witcher){
//        while(true){
//            System.out.println("Pilih :");
//            System.out.println("1. Serang");
//            System.out.println("2. Keluar");
//            System.out.print("--> ");
//            String pilihan  = input.nextLine();
//            if(pilihan.equals("1")){
//                witcher.serang();
//            } else if(pilihan.equals("2")){
//                break;
//            } else{
//                System.out.println("Input tidak valid!");
//            }
//        }
//    }
//
//    void menuFighter(Fighter fighter){
//        while(true){
//            System.out.println("Pilih :");
//            System.out.println("1. Serang");
//            System.out.println("2. Keluar");
//            System.out.print("--> ");
//            String pilihan  = input.nextLine();
//            if(pilihan.equals("1")){
//                fighter.serang();
//            } else if(pilihan.equals("2")){
//                break;
//            } else{
//                System.out.println("Input tidak valid!");
//            }
//        }
//    }
}

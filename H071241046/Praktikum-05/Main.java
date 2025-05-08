import Character.*;
import MenuUtama.MainMenu;

import java.awt.*;

public class Main {
    public static void main(String[] args) {

        Hero archer = new Archer("Miya", 100, 15);
        Hero witcher = new Witcher("Pharsa", 100, 18);
        Hero fighter = new Fighter("Lukas", 100, 20);

        MainMenu mainMenu = new MainMenu();

        mainMenu.mainMenu(archer, witcher, fighter);
    }
}

import java.util.Scanner;
public class TP2_2_H071241033 {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProductInformation product1 = new ProductInformation(10048, "JKT48 Photo Card", 10, 50000);
        ProductInformation product2 = new ProductInformation(10066, "Supersemar Document", 0, 0);
        ProductInformation product3 = new ProductInformation(10025, "Kartu", 1, 193700000);

        System.out.println("=== Product Information ===\n");
        product2.showInfo();
        System.out.println("\n*Want to check product availability? (yes/no)");
        String answer = scanner.nextLine();

        if (answer.equalsIgnoreCase("yes")) {
            System.out.println(product2.getAvailability() ? "*Product is available" : "*Product is not available (Pake nanya)");
        } else {
            System.out.println("\n*OK, have a nice day!");
        }
        scanner.close();
    }
}

class ProductInformation {
    int ID;
    String name;
    int stock;
    int price;

    ProductInformation(int ID, String name, int stock, int price) {
        this.ID = ID;
        this.name = name;
        this.stock = stock;
        this.price = price;
    }
    void showInfo() {
        System.out.println("ID: " + ID + "\nName: " + name + "\nStock: " + stock + "\nPrice: Rp" + price);
    }
    boolean getAvailability() {
        return stock > 0;
    } 

}
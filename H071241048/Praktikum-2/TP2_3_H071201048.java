class Cuboid{
    double height;
    double width;
    double length;

    double getVolume(){
         //Lengkapi
        return length * width * height;
    }
}

public class TP2_3_H071201048 {
    public static void main(String[] args) {
        Cuboid cuboid = new Cuboid();
         //Lengkapi
        cuboid.height = 15;
        cuboid.width = 10;
        cuboid.length = 30;

        System.out.println(String.format("Volume = %.2f", cuboid.getVolume()));
    }
}

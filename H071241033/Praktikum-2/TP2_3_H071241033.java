public class TP2_3_H071241033 {
    public static void main(String[] args) {
        Cuboid cuboid = new Cuboid();
        cuboid.height = 10;
        cuboid.width = 15;
        cuboid.length = 30;

        System.out.printf("volume = %.2f", cuboid.getVolume());
    }
}

class Cuboid {
    double height;
    double width;
    double length;
    
    double getVolume() {
        return height * width * length; 
    }
}
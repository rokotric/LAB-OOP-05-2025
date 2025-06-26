class Cuboid {
    double height;
    double width;
    double length;

    double getVolume() {
        return height * width * length;
    }
}

public class Nomor3 {
    public static void main(String[] args) {
        Cuboid cuboid = new Cuboid();
        cuboid.height = 30;
        cuboid.width = 15;
        cuboid.length = 10;

        System.out.printf("Volume = %.2f", cuboid.getVolume());
    }
}

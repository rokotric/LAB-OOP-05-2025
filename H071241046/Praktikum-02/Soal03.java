public class Soal03 {
    double height;
    double weight;
    double length;

    double getVolume(){
        return height * weight * length;
    }

    public static void main(String[] args) {
        var cuboid = new Soal03();
        cuboid.height = 15;
        cuboid.weight = 30;
        cuboid.length = 10;

        System.out.println("Volume = " + String.format("%.2f", cuboid.getVolume()));
    }

}

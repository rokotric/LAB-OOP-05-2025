class Cuboid{
    double height;
    double width;
    double length;
    
    double getVolume(){
        return height * width * length;
    }
}
    
public class TP2_3_H071241080 {
    public static void main(String[] args) {
        Cuboid cuboid = new Cuboid();
        cuboid.height = 10;
        cuboid.width = 15;
        cuboid.length = 30;
        System.out.println(String.format("Volume = %.2f", cuboid.getVolume()));
    }
}


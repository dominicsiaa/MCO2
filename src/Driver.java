import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
public class Driver {

    public static final List<Tool> toolList = new ArrayList<Tool>(Arrays.asList(
            new Tool("Plow",
                    "Converts an unplowed tile to a plowed tile. Can only be performed on an unplowed tile.",
                    0, 0.5),
            new Tool("Watering Can",
                    "Adds to the total number of tiles a tile/crop has been watered. Can only be performed on a plowed tile with a crop.",
                    0, 0.5),
            new Tool("Fertilizer",
                    "Adds to the total number of tiles a tile/crop has been applied with fertilizer. Can only be performed on a plowed tile with a crop.",
                    10, 4),
            new Tool("Pickaxe",
                    "Removes a rock from a tile. Can only be applied to tiles with a rock.",
                    50, 15),
            new Tool("Shovel",
                    "Removes a withered plant from a tile. Can be used on any tile/crop with varying effects, as described above.",
                    7, 2)
    ));
    public static void main(String[] args) throws Exception {
        MyFarm farm = new MyFarm();
        farm.run();
    }


}

public class Driver {
    public static void main(String[] args) throws Exception {
        Lot lot = new Lot();
        Crop turnip = new Crop("turnip", "rootcrop", 2, 1, 0, 1, 2, 5, 6, 5);

        Tile tile = lot.getTile(0, 0);
        System.out.println(tile.getStatus());

        tile.plow();
        System.out.println(tile.getStatus());
        tile.plant(turnip);
        System.out.println(tile.getStatus());
        tile.water();
        tile.advanceDay();
        tile.advanceDay();
        System.out.println(tile.getStatus());

        double reward = tile.harvest();
        System.out.println(tile.getStatus());

        tile.advanceDay();
    }
}

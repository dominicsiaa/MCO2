public class Driver {
    public static void main(String[] args) throws Exception {
        Lot lot = new Lot();
        Crop turnip = new Crop("turnip", 2, 1, 0);

        Tile tile = lot.getTile(0, 0);
        tile.plow();
        tile.plant(turnip);
        tile.water();
        tile.advanceDay();
        tile.advanceDay();
    }
}

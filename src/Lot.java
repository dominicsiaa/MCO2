public class Lot {
    private Tile[][] tiles;

    //TODO: There should be constructor for Lot with rocks next time

    public Lot() {
        this.tiles = new Tile[1][1];
        for (int i = 0; i < this.tiles.length; i++) {
            for (int j = 0; j < this.tiles[i].length; j++) {
                this.tiles[i][j] = new Tile();
            }
        }
    }

    public Lot(int rows, int cols) {
        this.tiles = new Tile[rows][cols];
        for (int i = 0; i < this.tiles.length; i++) {
            for (int j = 0; j < this.tiles[i].length; j++) {
                this.tiles[i][j] = new Tile();
            }
        }
    }

    public Tile getTile(int i, int j) {
        return this.tiles[i][j];
    }

    public void advanceDay() {
        for (Tile[] tileRow : this.tiles) {
            for (Tile tile : tileRow) {
                tile.advanceDay();
            }
        }
    }

    public boolean isFruitTreePlantable() {
        //TODO: Implement for MCO2

        return false;
    }

    public void displayTiles() {
        //TODO: Implement for MCO2, one tile only for MCO1

        System.out.print("\nTile 1: ");
        System.out.println(tiles[0][0]);
    }
}

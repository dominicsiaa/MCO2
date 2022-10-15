public class Lot {
    private Tile[][] tiles;

    public Lot() {
        this.tiles = new Tile[1][1];
        for (int i = 0; i < this.tiles.length; i++) {
            for (int j = 0; j < this.tiles[i].length; j++) {
                this.tiles[i][j] = new Tile();
            }
        }
    }

    public Tile[][] getTiles() {
        return this.tiles;
    }

    public Tile getTile(int i, int j) {
        return this.tiles[i][j];
    }

    public boolean isFruitTreePlantable() {
        //TODO: Implement
        return true;
    }
}

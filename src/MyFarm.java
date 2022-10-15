public class MyFarm {
    private Farmer farmer = new Farmer();
    private Lot lot = new Lot();
    private int day = 1;

    public MyFarm() {
        // Default constructor
    }

    public void displayScreen() {
        // Which is text-based for now until GUI
        //TODO: Implement
    }

    public void advanceDay() {
        this.day++;
        for (int i = 0; i < this.lot.getTiles().length; i++) {
            for (int j = 0; j < this.lot.getTiles()[i].length; j++) {
                this.lot.getTile(i, j).advanceDay();
            }
        }
    }
}

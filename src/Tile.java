public class Tile {

    public static final int HASROCK = 0;
    public static final int ISUNPLOWED = 1;
    public static final int ISPLOWED = 2;
    public static final int ISPLANTED = 3;
    public static final int ISHARVESTABLE = 4;
    public static final int HASWITHERED = 5;

    private boolean hasRock = false;
    private boolean hasWitheredCrop = false;

    private boolean isPlowed = false;
    private Crop cropPlanted = null;
    private int timesWatered = 0;
    private int timesFertilized = 0;

    private boolean isHarvestable = false;
    private int daysPast = 0;

    public Tile() {
        // Default constructor
    }

    public Tile(boolean hasRock) {
        this.hasRock = hasRock;
    }

    public boolean plow() {
        if (!this.hasRock) {
            this.isPlowed = true;
            return true;
        } else {
            return false;
        }
    }

    public boolean plant(Crop crop) {
        if (this.isPlowed) {
            this.cropPlanted = crop;
            return true;
        } else {
            return false;
        }
    }

    public boolean water() {
        if (this.cropPlanted != null) {
            timesWatered++;
            return true;
        } else {
            return false;
        }
    }

    public boolean fertilize() {
        if (this.cropPlanted != null) {
            timesFertilized++;
            return true;
        } else {
            return false;
        }
    }

    public void removeRock() {
        this.hasRock = false;
    }

    /* kinda useless now?

    public void removeWitheredCrop() {
        this.hasWitheredCrop = false;
    }
     */

    public void clearTile() {
        this.isHarvestable = false;
        this.cropPlanted = null;
        this.isPlowed = false;
        this.daysPast = 0;
        this.timesFertilized = 0;
        this.timesWatered = 0;
        this.hasWitheredCrop = false;
    }

    public void advanceDay() {
        if (this.cropPlanted != null) {
            this.daysPast++;

            // Check if crop is harvestable
            if (this.daysPast == this.cropPlanted.getHarvestTime()) {
                if(this.timesWatered >= this.cropPlanted.getWaterNeeds() && this.timesFertilized >= this.cropPlanted.getFertilizerNeeds()) {
                    this.isHarvestable = true;
                } else {
                    this.hasWitheredCrop = true;
                    this.clearTile();
                }
            } 
            else if (this.daysPast > this.cropPlanted.getHarvestTime()) {
                this.hasWitheredCrop = true;
                this.clearTile();
            }
        }
    }

    public boolean harvest() {
        if (this.isHarvestable) {
            this.clearTile();
            return true;

        } else {
            return false;
        }
    }

    public int getTimesWatered() {
        return this.timesWatered;
    }

    public int getTimesFertilized() {
        return this.timesFertilized;
    }

    public Crop getCropPlanted() {
        return this.cropPlanted;
    }

    public int getStatus() {
        if (this.hasRock) {
            return HASROCK;
        } else if (this.hasWitheredCrop) {
            return HASWITHERED;
        } else if (!this.isPlowed) {
            return ISUNPLOWED;
        } else if (this.isHarvestable) {
            return ISHARVESTABLE;
        } else if (this.cropPlanted != null) {
            return ISPLANTED;
        } else {
            return ISPLOWED;
        }
    }

    @Override
    public String toString() {
        String status = "Error";
        switch(this.getStatus()) {
            case HASROCK:
                status = "Has Rock";
                break;
            case ISUNPLOWED:
                status = "Unplowed";
                break;
            case ISPLOWED:
                status = "Plowed";
                break;
            case ISPLANTED:
                status = "Planted\nPlant: " + this.cropPlanted.getName() + " | Days Past: " + this.daysPast + " | Watered: " + this.timesWatered + " | Fertilized: " + this.timesFertilized;
                break;
            case ISHARVESTABLE:
                status = "Harvestable\nPlant: " + this.cropPlanted.getName() + " | Days Past: " + this.daysPast + " | Watered: " + this.timesWatered + " | Fertilized: " + this.timesFertilized;
                break;
            case HASWITHERED:
                status = "Has Withered Crop";
                break;

        }
        return "\n _____ \n" + "|     |\n" + "|  " + this.getStatus() + "  |\n" + "|_____|\n Status: (" + this.getStatus() + ") " + status;
    }
}

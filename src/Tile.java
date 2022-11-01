public class Tile {

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

    public Crop harvest() {
        if (this.isHarvestable) {
            Crop crop = this.cropPlanted;
            this.clearTile();
            return crop;

        } else {
            return null;
        }
    }

    public int getStatus() {
        if (this.hasRock) {
            return 0;
        } else if (this.hasWitheredCrop) {
            return 5;
        } else if (!this.isPlowed) {
            return 1;
        } else if (this.isHarvestable) {
            return 4;
        } else if (this.cropPlanted != null) {
            return 3;
        } else {
            return 2;
        }
    }

    @Override
    public String toString() {
        String status = "Error";
        switch(this.getStatus()) {
            case 0:
                status = "Has Rock";
                break;
            case 1:
                status = "Unplowed";
                break;
            case 2:
                status = "Plowed";
                break;
            case 3:
                status = "Planted\nPlant: " + this.cropPlanted.getName() + " | Days Past: " + this.daysPast + " | Watered: " + this.timesWatered + " | Fertilized: " + this.timesFertilized;
                break;
            case 4:
                status = "Harvestable\nPlant: " + this.cropPlanted.getName() + " | Days Past: " + this.daysPast + " | Watered: " + this.timesWatered + " | Fertilized: " + this.timesFertilized;
                break;
            case 5:
                status = "Has Withered Crop";
                break;

        }
        return "\n _____ \n" + "|     |\n" + "|  " + this.getStatus() + "  |\n" + "|_____|\n Status: (" + this.getStatus() + ") " + status;
    }
}

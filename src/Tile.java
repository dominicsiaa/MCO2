public class Tile {
    private boolean hasRock = false;
    private boolean isPlowed = false;
    private boolean isWithered = false;

    private int timesWatered = 0;
    private int timesFertilized = 0;

    private Crop cropPlanted = null;
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

    public void advanceDay() {
        if (this.cropPlanted != null) {
            this.daysPast++;

            // Check if crop is harvestable
            if (this.daysPast == this.cropPlanted.getHarvestTime()) {
                if(this.timesWatered >= this.cropPlanted.getWaterNeeds() && this.timesFertilized >= this.cropPlanted.getFertilizerNeeds()) {
                    this.isHarvestable = true;
                } else {
                    this.isWithered = true;
                }
            } 
            else if (this.daysPast > this.cropPlanted.getHarvestTime()) {
                this.isWithered = true;
                this.isHarvestable = false;
            }
        }
    }

    public int harvest() {
        if (this.isHarvestable) {
            this.isHarvestable = false;
            this.isPlowed = false;
            this.isWithered = false;
            this.timesWatered = 0;
            this.timesFertilized = 0;
            this.cropPlanted = null;
            this.daysPast = 0;

            //TODO: compute and return the harvest value
            return 100;
        } else {
            return 0;
        }
    }

    public void removeRock() {
        this.hasRock = false;
    }

    public void removeWitheredCrop() {
        this.isWithered = false;
    }

    public Crop getCropPlanted() {
        return this.cropPlanted;
    }

    public boolean hasRock() {
        return this.hasRock;
    }

    public boolean isWithered() {
        return this.isWithered;
    }
}

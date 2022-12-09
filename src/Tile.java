/**
 * Represents a tile in the game.
 * Contains statuses of the tile, (has rock,
 * has withered crop, is plowed, what crop is planted,
 * times watered, times fertilized, if plant is harvestable,
 * and days past.
 */
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

    /**
     * This constructor initializes a tile object
     */
    public Tile() {
        // Default constructor
    }

    /**
     * This constructor initializes a tile object
     * @param hasRock
     */
    public Tile(boolean hasRock) {
        this.hasRock = hasRock;
    }

    /**
     * This method plows a tile
     * @return true if successfully plowed, false otherwise
     */
    public boolean plow() {
        if (!this.hasRock && !this.isPlowed && this.cropPlanted == null && !this.isHarvestable && !this.hasWitheredCrop) {
            this.isPlowed = true;
            return true;
        }
        return false;
    }

    /**
     * This method plants a crop on a tile
     * @param crop
     * @return true if successfully planted, false otherwise
     */
    public boolean plant(Crop crop) {
        if (this.isPlowed && this.cropPlanted == null) {
            this.cropPlanted = crop;
            return true;
        }
        return false;
    }

    /**
     * This method waters a crop on a tile
     * @return true if successfully watered, false otherwise
     */
    public boolean water() {
        if (this.cropPlanted != null) {
            timesWatered++;
            return true;
        }
        return false;
    }

    /**
     * This method fertilizes a crop on a tile
     * @return true if successfully fertilized, false otherwise
     */
    public boolean fertilize() {
        if (this.cropPlanted != null) {
            timesFertilized++;
            return true;
        }
        return false;
    }

    /**
     * This method removes a rock on a tile
     * @return true if successfully removed, false otherwise
     */
    public boolean removeRock() {
        if (this.hasRock) {
            this.hasRock = false;
            return true;
        }
        return false;
    }

    /**
     * This method harvests a crop
     * @return true if successfully harvested, false otherwise
     */
    public boolean harvest() {
        if (this.isHarvestable) {
            this.clearTile();
            return true;

        } else {
            return false;
        }
    }

    /**
     * This method clears a tile
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

    /**
     * This method advances the day
     * @return true if the crop has withered, false otherwise
     */
    public boolean advanceDay() {
        if (this.cropPlanted != null) {
            this.daysPast++;

            if (this.daysPast == this.cropPlanted.getHarvestTime()) {
                if(this.timesWatered >= this.cropPlanted.getWaterNeeds() && this.timesFertilized >= this.cropPlanted.getFertilizerNeeds()) {
                    this.isHarvestable = true;
                } else {
                    this.clearTile();
                    this.hasWitheredCrop = true;
                    return true;
                }
            } 
            else if (this.daysPast > this.cropPlanted.getHarvestTime()) {
                this.clearTile();
                this.hasWitheredCrop = true;
                return true;
            }
        }
        return false;
    }

    /**
     * This method returns the times a crop has been watered
     * @return timesWatered
     */
    public int getTimesWatered() {
        return this.timesWatered;
    }

    /**
     * This method returns the times a crop has been fertilized
     * @return timesFertilized
     */
    public int getTimesFertilized() {
        return this.timesFertilized;
    }

    /**
     * This method returns the crop planted on a tile
     * @return cropPlanted
     */
    public Crop getCropPlanted() {
        return this.cropPlanted;
    }

    /**
     * This method returns the days past
     * @return daysPast
     */
    public int getDaysPast() {
        return this.daysPast;
    }

    /**
     * This method returns the status of the tile
     * @return status
     */
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
                status = "P:" + this.cropPlanted.getName();
                break;
            case ISHARVESTABLE:
                status = "H:" + this.cropPlanted.getName();
                break;
            case HASWITHERED:
                status = "Withered";
                break;

        }
        return status;
    }
}

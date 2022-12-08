/**
 * Represents a crop that can be planted in the farm.
 * Contains the crop's name, type, harvest time, water needs (and bonus),
 * fertilizer needs (and bonus), minimum and maximum products produced,
 * seed cost, selling price, and exp gain
 */
public class Crop {
    private String name;
    private int harvestTime;

    //add inheritance stuff next time
    private int waterNeeds;
    private int waterNeedsBonusLimit;
    private int fertilizerNeeds;
    private int fertilizerNeedsBonusLimit;
    private int minProductsProduced;
    private int maxProductsProduced;

    private int seedCost;
    private int sellingPrice;
    private double expGain;

    /**
     * This constructor initializes a crop object
     * @param name
     * @param harvestTime
     * @param waterNeeds
     * @param fertilizerNeeds
     * @param minProductsProduced
     * @param maxProductsProduced
     * @param seedCost
     * @param sellingPrice
     * @param expGain
     */
    public Crop(String name,
                int harvestTime, 
                int waterNeeds, 
                int waterNeedsBonusLimit,
                int fertilizerNeeds, 
                int fertilizerNeedsBonusLimit,
                int minProductsProduced, 
                int maxProductsProduced, 
                int seedCost, 
                int sellingPrice, 
                double expGain) 
    {
        this.name = name;
        this.harvestTime = harvestTime;

        this.waterNeeds = waterNeeds;
        this.waterNeedsBonusLimit = waterNeedsBonusLimit;
        this.fertilizerNeeds = fertilizerNeeds;
        this.fertilizerNeedsBonusLimit = fertilizerNeedsBonusLimit;

        this.minProductsProduced = minProductsProduced;
        this.maxProductsProduced = maxProductsProduced;

        this.seedCost = seedCost;
        this.sellingPrice = sellingPrice;
        this.expGain = expGain;
    }

    /**
     * This method generates a random number of products produced
     * @return name
     */
    public int generateProductAmount() {
        if(this.minProductsProduced == this.maxProductsProduced) {
            return this.minProductsProduced;
        } else {
            return (int)(Math.random() * (this.maxProductsProduced - this.minProductsProduced + 1) + this.minProductsProduced);
        }
    }

    /**
     * This method returns the name of the crop
     * @return name
     */
    public String getName() {
        return this.name;
    }

    /**
     * This method returns the harvest time of the crop
     * @return harvestTime
     */
    public int getHarvestTime() {
        return this.harvestTime;
    }

    /**
     * This method returns the water needs of the crop
     * @return waterNeeds
     */
    public int getWaterNeeds() {
        return this.waterNeeds;
    }

    /**
     * This method returns the water needs bonus limit of the crop
     * @return waterNeedsBonusLimit
     */
    public int getWaterNeedsBonusLimit() {
        return this.waterNeedsBonusLimit;
    }

    /**
     * This method returns the fertilizer needs of the crop
     * @return fertilizerNeeds
     */
    public int getFertilizerNeeds() {
        return this.fertilizerNeeds;
    }

    /**
     * This method returns the fertilizer needs bonus limit of the crop
     * @return fertilizerNeedsBonusLimit
     */
    public int getFertilizerNeedsBonusLimit() {
        return this.fertilizerNeedsBonusLimit;
    }

    /**
     * This method returns the minimum products produced of the crop
     * @return minProductsProduced
     */
    public int getMinProductsProduced() {
        return this.minProductsProduced;
    }

    /**
     * This method returns the maximum products produced of the crop
     * @return maxProductsProduced
     */
    public int getMaxProductsProduced() {
        return this.maxProductsProduced;
    }

    /**
     * This method returns the seed cost of the crop
     * @return seedCost
     */
    public int getSeedCost() {
        return this.seedCost;
    }

    /**
     * This method returns the selling price of the crop
     * @return sellingPrice
     */
    public int getSellingPrice() {
        return this.sellingPrice;
    }

    /**
     * This method returns the exp gain of the crop
     * @return expGain
     */
    public double getExpGain() {
        return this.expGain;
    }

    /**
     * This method returns the name of the crop
     * @return name
     */
    @Override
    public String toString(){
        return this.name;
    }

}

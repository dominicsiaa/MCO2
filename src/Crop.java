/**
 * Represents a crop that can be planted in the farm.
 * Contains the crop's name, type, harvest time, water needs (and bonus),
 * fertilizer needs (and bonus), minimum and maximum products produced,
 * seed cost, selling price, and exp gain
 */
public abstract class Crop {
    private String name;
    private int harvestTime;
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
     * @param name                  name of the crop
     * @param harvestTime           harvest time of the crop
     * @param waterNeeds            water needs of the crop
     * @param waterNeedsBonusLimit  water needs bonus limit of the crop
     * @param fertilizerNeeds       fertilizer needs of the crop
     * @param fertilizerNeedsBonusLimit fertilizer needs bonus limit of the crop
     * @param minProductsProduced   minimum products produced of the crop
     * @param maxProductsProduced   maximum products produced of the crop
     * @param seedCost              seed cost of the crop
     * @param sellingPrice          selling price of the crop
     * @param expGain               experience gained from harvesting the crop
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
     * This method returns the name of the crop
     * @return random number of products produced
     */
    public String getName() {
        return this.name;
    }

    /**
     * This method returns the harvest time of the crop
     * @return harvest time of the crop
     */
    public int getHarvestTime() {
        return this.harvestTime;
    }

    /**
     * This method returns the water needs of the crop
     * @return water needs of the crop
     */
    public int getWaterNeeds() {
        return this.waterNeeds;
    }

    /**
     * This method returns the water needs bonus limit of the crop
     * @return water needs bonus limit of the crop
     */
    public int getWaterNeedsBonusLimit() {
        return this.waterNeedsBonusLimit;
    }

    /**
     * This method returns the fertilizer needs of the crop
     * @return fertilizer needs of the crop
     */
    public int getFertilizerNeeds() {
        return this.fertilizerNeeds;
    }

    /**
     * This method returns the fertilizer needs bonus limit of the crop
     * @return fertilizer needs bonus limit of the crop
     */
    public int getFertilizerNeedsBonusLimit() {
        return this.fertilizerNeedsBonusLimit;
    }

    /**
     * This method returns the minimum products produced of the crop
     * @return mininimum number of possible products produced
     */
    public int getMinProductsProduced() {
        return this.minProductsProduced;
    }

    /**
     * This method returns the maximum products produced of the crop
     * @return maximum number of possible products produced
     */
    public int getMaxProductsProduced() {
        return this.maxProductsProduced;
    }

    /**
     * This method returns the seed cost of the crop
     * @return seed cost of the crop
     */
    public int getSeedCost() {
        return this.seedCost;
    }

    /**
     * This method returns the selling price of the crop
     * @return selling price of the crop
     */
    public int getSellingPrice() {
        return this.sellingPrice;
    }

    /**
     * This method returns the exp gain of the crop
     * @return exp gain of the crop
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

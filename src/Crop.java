public class Crop {
    private String name;
    private String type;
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
    private float experienceYield;

    public Crop(String name, 
                String type, 
                int harvestTime, 
                int waterNeeds, 
                int fertilizerNeeds, 
                int minProductsProduced, 
                int maxProductsProduced, 
                int seedCost, 
                int sellingPrice, 
                float experienceYield) 
    {
        this.name = name;
        this.type = type;
        this.harvestTime = harvestTime;

        this.waterNeeds = waterNeeds;
        this.fertilizerNeeds = fertilizerNeeds;

        //extra feature of rootcrop and flower
        if(type.equals("rootcrop") || type.equals("flower")) {
            this.waterNeedsBonusLimit = waterNeeds + 1;
            this.fertilizerNeedsBonusLimit = fertilizerNeeds + 1;
        } else {
            this.waterNeedsBonusLimit = waterNeeds;
            this.fertilizerNeedsBonusLimit = fertilizerNeeds;
        }

        //rootcrop 1-x, flowers 1 only, trees x-y
        this.minProductsProduced = minProductsProduced;
        this.maxProductsProduced = maxProductsProduced;

        this.seedCost = seedCost;
        this.sellingPrice = sellingPrice;
        this.experienceYield = experienceYield;
    }

    public int generateProductAmount() {
        if(this.minProductsProduced == this.maxProductsProduced) {
            return this.minProductsProduced;
        } else {
            return (int)(Math.random() * (this.maxProductsProduced - this.minProductsProduced + 1) + this.minProductsProduced);
        }
    }

    public String getName() {
        return this.name;
    }

    public String getType() {
        return this.type;
    }

    public int getHarvestTime() {
        return this.harvestTime;
    }

    public int getWaterNeeds() {
        return this.waterNeeds;
    }

    public int getWaterNeedsBonusLimit() {
        return this.waterNeedsBonusLimit;
    }

    public int getFertilizerNeeds() {
        return this.fertilizerNeeds;
    }

    public int getFertilizerNeedsBonusLimit() {
        return this.fertilizerNeedsBonusLimit;
    }

    public int getMinProductsProduced() {
        return this.minProductsProduced;
    }

    public int getMaxProductsProduced() {
        return this.maxProductsProduced;
    }

    public int getSeedCost() {
        return this.seedCost;
    }

    public int getSellingPrice() {
        return this.sellingPrice;
    }

    public float getExperienceYield() {
        return this.experienceYield;
    }

}

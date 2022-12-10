/**
 * Represents a Root Crop.
 * Contains the crop's name, harvest time, water needs (and bonus),
 * fertilizer needs (and bonus), minimum and maximum products produced,
 * seed cost, selling price, and exp gain
 */
public class RootCrop extends Crop{
    /**
     * This constructor initializes a root crop object
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
    public RootCrop(String name,
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
        super(name, harvestTime, waterNeeds, waterNeedsBonusLimit, fertilizerNeeds, fertilizerNeedsBonusLimit, minProductsProduced, maxProductsProduced, seedCost, sellingPrice, expGain);
    }

}

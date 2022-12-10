/**
 * Represents a Tree Crop.
 * Contains the crop's name, harvest time, water needs (and bonus),
 * fertilizer needs (and bonus), minimum and maximum products produced,
 * seed cost, selling price, and exp gain
 */
public class TreeCrop extends Crop{
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
    public TreeCrop(String name,
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

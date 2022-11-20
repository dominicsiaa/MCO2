public class FlowerCrop extends Crop{

    public FlowerCrop(String name,
                    String type,
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
        super(name, type, harvestTime, waterNeeds, waterNeedsBonusLimit, fertilizerNeeds, fertilizerNeedsBonusLimit, minProductsProduced, maxProductsProduced, seedCost, sellingPrice, expGain);
    }

}

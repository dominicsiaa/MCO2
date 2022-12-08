public class Sunflower extends FlowerCrop{
    public Sunflower(String name,
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
        super("Sunflower", 3,
                2, 3, 1, 2,
                1,1, 20, 19, 7.5);
    }

}

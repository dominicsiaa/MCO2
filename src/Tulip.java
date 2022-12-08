public class Tulip extends FlowerCrop{
    public Tulip(String name,
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
        super("Tulips", 2,
                2, 3, 0, 1,
                1, 1, 10, 9, 5.0);
    }

}

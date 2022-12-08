public class Turnip extends RootCrop{
    public Turnip(String name,
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
        super("Turnip",2,
                1, 2, 0, 1,
                1, 2, 5, 6, 5);
    }

}
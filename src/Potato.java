public class Potato extends RootCrop{
    public Potato(String name,
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
        super("Potato", 5,
                3, 4, 1, 2,
                1, 10, 20, 3, 12.5);
    }

}
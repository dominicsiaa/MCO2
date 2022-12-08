public class Carrot extends RootCrop{
    public Carrot(String name,
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
        super("Carrot", 3,
                1, 2, 0, 1,
                1, 2, 10, 9, 7.5);
    }

}
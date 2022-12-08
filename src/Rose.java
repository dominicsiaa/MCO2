public class Rose extends FlowerCrop{
    public Rose(String name,
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
        super("Rose", 1,
                1, 2, 0, 1,
                1, 1, 5, 5, 2.5);
    }

}

public class Mango extends TreeCrop{
    public Mango(String name,
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
        super("Mango", 10,
                7, 7, 4, 4,
                5, 15, 100, 8, 25);
    }

}

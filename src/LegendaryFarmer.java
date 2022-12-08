public class LegendaryFarmer extends FarmerType{
    public LegendaryFarmer(String name, int levelRequirement, int bonusEarningsPerProduce,
                               int seedCostReduction, int waterBonusLimitIncrease,
                               int fertilizerBonusLimitIncrease, int registrationFee) {
        super("Legendary Farmer", 15, 4, -3, 2, 1, 400);
    }
}

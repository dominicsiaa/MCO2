public class DistinguishedFarmer extends FarmerType{
    public DistinguishedFarmer(String name, int levelRequirement, int bonusEarningsPerProduce,
                               int seedCostReduction, int waterBonusLimitIncrease,
                               int fertilizerBonusLimitIncrease, int registrationFee) {
        super("Distinguished Farmer", 10, 2, -2, 1, 0, 300);
    }
}

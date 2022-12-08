public class RegisteredFarmer extends FarmerType{
    public RegisteredFarmer(String name, int levelRequirement, int bonusEarningsPerProduce,
                            int seedCostReduction, int waterBonusLimitIncrease,
                            int fertilizerBonusLimitIncrease, int registrationFee) {
        super("Registered Farmer",5, 1, -1, 0, 0, 200);
    }
}

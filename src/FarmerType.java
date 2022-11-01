public class FarmerType {
    private String type;
    private int levelRequirement;
    private int bonusEarningsPerProduce;
    private int seedCostReduction;
    private int waterBonusLimitIncrease;
    private int fertilizerBonusLimitIncrease;
    private int registrationFee;

    public FarmerType(String type, int levelRequirement, int bonusEarningsPerProduce, int seedCostReduction, int waterBonusLimitIncrease, int fertilizerBonusLimitIncrease, int registrationFee) {
        this.type = type;
        this.levelRequirement = levelRequirement;
        this.bonusEarningsPerProduce = bonusEarningsPerProduce;
        this.seedCostReduction = seedCostReduction;
        this.waterBonusLimitIncrease = waterBonusLimitIncrease;
        this.fertilizerBonusLimitIncrease = fertilizerBonusLimitIncrease;
        this.registrationFee = registrationFee;
    }

    public String getType() {
        return this.type;
    }

    public int getBonusEarningsPerProduce() {
        return this.bonusEarningsPerProduce;
    }

    public int getSeedCostReduction() {
        return this.seedCostReduction;
    }

    public int getWaterBonusLimitIncrease() {
        return this.waterBonusLimitIncrease;
    }

    public int getFertilizerBonusLimitIncrease() {
        return this.fertilizerBonusLimitIncrease;
    }
}
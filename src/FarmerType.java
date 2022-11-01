public class FarmerType {
    private String name;
    private int levelRequirement;
    private int bonusEarningsPerProduce;
    private int seedCostReduction;
    private int waterBonusLimitIncrease;
    private int fertilizerBonusLimitIncrease;
    private int registrationFee;

    public FarmerType(String name, int levelRequirement, int bonusEarningsPerProduce, int seedCostReduction, int waterBonusLimitIncrease, int fertilizerBonusLimitIncrease, int registrationFee) {
        this.name = name;
        this.levelRequirement = levelRequirement;
        this.bonusEarningsPerProduce = bonusEarningsPerProduce;
        this.seedCostReduction = seedCostReduction;
        this.waterBonusLimitIncrease = waterBonusLimitIncrease;
        this.fertilizerBonusLimitIncrease = fertilizerBonusLimitIncrease;
        this.registrationFee = registrationFee;
    }

    public String getName() {
        return this.name;
    }

    public int getLevelRequirement() {
        return this.levelRequirement;
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

    public int getRegistrationFee() {
        return this.registrationFee;
    }

    @Override
    public String toString(){
        return this.name;
    }
}
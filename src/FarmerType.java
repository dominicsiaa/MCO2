public class FarmerType {
    private String type;
    private int bonusEarningsPerProduce;
    private int seedCostReduction;
    private int waterBonusLimitIncrease;
    private int fertilizerBonusLimitIncrease;

    public FarmerType(String type, int bonusEarningsPerProduce, int seedCostReduction, int waterBonusLimitIncrease, int fertilizerBonusLimitIncrease) {
        this.type = type;
        this.bonusEarningsPerProduce = bonusEarningsPerProduce;
        this.seedCostReduction = seedCostReduction;
        this.waterBonusLimitIncrease = waterBonusLimitIncrease;
        this.fertilizerBonusLimitIncrease = fertilizerBonusLimitIncrease;
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
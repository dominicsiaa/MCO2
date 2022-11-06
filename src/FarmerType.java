/**
 * Represents the types of farmers.
 * Contains the farmer type name,
 * the level requirement to reach the rank,
 * bonus earnings per produce, seed cost reduction,
 * water bonus limit increase, fertilizer bonus limit increase,
 * and registration fee needed to register as the farmer type
 */
public class FarmerType {
    private String name;
    private int levelRequirement;
    private int bonusEarningsPerProduce;
    private int seedCostReduction;
    private int waterBonusLimitIncrease;
    private int fertilizerBonusLimitIncrease;
    private int registrationFee;

    /**
     * This constructor initializes a farmer type object
     * @param name
     * @param levelRequirement
     * @param bonusEarningsPerProduce
     * @param seedCostReduction
     * @param waterBonusLimitIncrease
     * @param fertilizerBonusLimitIncrease
     * @param registrationFee
     */
    public FarmerType(String name, int levelRequirement, int bonusEarningsPerProduce, int seedCostReduction, int waterBonusLimitIncrease, int fertilizerBonusLimitIncrease, int registrationFee) {
        this.name = name;
        this.levelRequirement = levelRequirement;
        this.bonusEarningsPerProduce = bonusEarningsPerProduce;
        this.seedCostReduction = seedCostReduction;
        this.waterBonusLimitIncrease = waterBonusLimitIncrease;
        this.fertilizerBonusLimitIncrease = fertilizerBonusLimitIncrease;
        this.registrationFee = registrationFee;
    }

    /**
     * This method returns the farmer type name
     * @return name
     */
    public String getName() {
        return this.name;
    }

    /**
     * This method returns the level requirement to reach the rank
     * @return levelRequirement
     */
    public int getLevelRequirement() {
        return this.levelRequirement;
    }

    /**
     * This method returns the bonus earnings per produce
     * @return bonusEarningsPerProduce
     */
    public int getBonusEarningsPerProduce() {
        return this.bonusEarningsPerProduce;
    }

    /**
     * This method returns the seed cost reduction
     * @return seedCostReduction
     */
    public int getSeedCostReduction() {
        return this.seedCostReduction;
    }

    /**
     * This method returns the water bonus limit increase
     * @return waterBonusLimitIncrease
     */
    public int getWaterBonusLimitIncrease() {
        return this.waterBonusLimitIncrease;
    }

    /**
     * This method returns the fertilizer bonus limit increase
     * @return fertilizerBonusLimitIncrease
     */
    public int getFertilizerBonusLimitIncrease() {
        return this.fertilizerBonusLimitIncrease;
    }

    /**
     * This method returns the registration fee needed to register as the farmer type
     * @return registrationFee
     */
    public int getRegistrationFee() {
        return this.registrationFee;
    }

    /**
     * This method returns the farmer type name
     * @return name
     */
    @Override
    public String toString(){
        return this.name;
    }
}
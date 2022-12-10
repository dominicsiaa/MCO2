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
     * @param name                          name of the farmer type
     * @param levelRequirement              level requirement to reach the rank
     * @param bonusEarningsPerProduce       bonus earnings per produce
     * @param seedCostReduction             seed cost reduction
     * @param waterBonusLimitIncrease       water bonus limit increase
     * @param fertilizerBonusLimitIncrease  fertilizer bonus limit increase
     * @param registrationFee               registration fee needed to register as the farmer type
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
     * @return name of the farmer type
     */
    public String getName() {
        return this.name;
    }

    /**
     * This method returns the level requirement to reach the rank
     * @return level requirement of the farmer type
     */
    public int getLevelRequirement() {
        return this.levelRequirement;
    }

    /**
     * This method returns the bonus earnings per produce
     * @return bonus earnings per produce of the farmer type
     */
    public int getBonusEarningsPerProduce() {
        return this.bonusEarningsPerProduce;
    }

    /**
     * This method returns the seed cost reduction
     * @return seed cost reduction of the farmer type
     */
    public int getSeedCostReduction() {
        return this.seedCostReduction;
    }

    /**
     * This method returns the water bonus limit increase
     * @return water bonus limit increase of the farmer type
     */
    public int getWaterBonusLimitIncrease() {
        return this.waterBonusLimitIncrease;
    }

    /**
     * This method returns the fertilizer bonus limit increase
     * @return fertilizer bonus limit increase of the farmer type
     */
    public int getFertilizerBonusLimitIncrease() {
        return this.fertilizerBonusLimitIncrease;
    }

    /**
     * This method returns the registration fee needed to register as the farmer type
     * @return registration fee of the farmer type
     */
    public int getRegistrationFee() {
        return this.registrationFee;
    }

    /**
     * This method returns the farmer type name
     * @return name of the farmer type
     */
    @Override
    public String toString(){
        return this.name;
    }
}
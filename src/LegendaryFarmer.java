/**
 * Represents Legendary Farmer type of farmer.
 * Contains the farmer type name,
 * the level requirement to reach the rank,
 * bonus earnings per produce, seed cost reduction,
 * water bonus limit increase, fertilizer bonus limit increase,
 * and registration fee needed to register as the farmer type
 */
public class LegendaryFarmer extends FarmerType{
    /**
     * This constructor initializes a legendary farmer type object
     */
    public LegendaryFarmer() {
        super("Legendary Farmer", 15, 4, -3, 2, 1, 400);
    }
}

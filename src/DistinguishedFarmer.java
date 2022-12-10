/**
 * Represents Distinguished Farmer type of farmer.
 * Contains the farmer type name,
 * the level requirement to reach the rank,
 * bonus earnings per produce, seed cost reduction,
 * water bonus limit increase, fertilizer bonus limit increase,
 * and registration fee needed to register as the farmer type
 */
public class DistinguishedFarmer extends FarmerType{
    /**
     * This constructor initializes a distinguished farmer type object
     */
    public DistinguishedFarmer() {
        super("Distinguished Farmer", 10, 2, -2, 1, 0, 300);
    }
}

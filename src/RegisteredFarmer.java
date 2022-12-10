/**
 * Represents the Registered Farmer type of farmer.
 * Contains the farmer type name,
 * the level requirement to reach the rank,
 * bonus earnings per produce, seed cost reduction,
 * water bonus limit increase, fertilizer bonus limit increase,
 * and registration fee needed to register as the farmer type
 */
public class RegisteredFarmer extends FarmerType{
    /**
     * This constructor initializes a registered farmer type object
     */
    public RegisteredFarmer() {
        super("Registered Farmer",5, 1, -1, 0, 0, 200);
    }
}

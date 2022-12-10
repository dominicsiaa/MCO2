/**
 * Represents Default Farmer type of farmer.
 * Contains the farmer type name,
 * the level requirement to reach the rank,
 * bonus earnings per produce, seed cost reduction,
 * water bonus limit increase, fertilizer bonus limit increase,
 * and registration fee needed to register as the farmer type
 */
public class FarmerDefault extends FarmerType{
    /**
     * This constructor initializes a default farmer type object
     */
    public FarmerDefault() {
        super("Farmer",0, 0, 0, 0, 0, 0);
    }
}

/**
 * Represents a turnip root crop.
 * Contains the crop's name, harvest time, water needs (and bonus),
 * fertilizer needs (and bonus), minimum and maximum products produced,
 * seed cost, selling price, and exp gain
 */
public class Turnip extends RootCrop{
    /**
     * This constructor initializes a turnip root crop object
     */
    public Turnip()
    {
        super("Turnip",2,
                1, 2, 0, 1,
                1, 2, 5, 6, 5);
    }

}
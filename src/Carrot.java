/**
 * Represents a Carrot root crop.
 * Contains the crop's name, harvest time, water needs (and bonus),
 * fertilizer needs (and bonus), minimum and maximum products produced,
 * seed cost, selling price, and exp gain
 */
public class Carrot extends RootCrop{
    /**
     * This constructor initializes a carrot root crop object
     */
    public Carrot()
    {
        super("Carrot", 3,
                1, 2, 0, 1,
                1, 2, 10, 9, 7.5);
    }

}
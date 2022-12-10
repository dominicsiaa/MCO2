/**
 * Represents a Carrot root crop.
 * Contains the crop's name, harvest time, water needs (and bonus),
 * fertilizer needs (and bonus), minimum and maximum products produced,
 * seed cost, selling price, and exp gain
 */
public class Potato extends RootCrop{
    /**
     * This constructor initializes a potato root crop object
     */
    public Potato()
    {
        super("Potato", 5,
                3, 4, 1, 2,
                1, 10, 20, 3, 12.5);
    }

}
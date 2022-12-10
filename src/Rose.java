/**
 * Represents a rose flower crop.
 * Contains the crop's name, harvest time, water needs (and bonus),
 * fertilizer needs (and bonus), minimum and maximum products produced,
 * seed cost, selling price, and exp gain
 */
public class Rose extends FlowerCrop{
    /**
     * This constructor initializes a rose flower crop object
     */
    public Rose()
    {
        super("Rose", 1,
                1, 2, 0, 1,
                1, 1, 5, 5, 2.5);
    }

}

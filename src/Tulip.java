/**
 * Represents a tulip flower crop.
 * Contains the crop's name, harvest time, water needs (and bonus),
 * fertilizer needs (and bonus), minimum and maximum products produced,
 * seed cost, selling price, and exp gain
 */
public class Tulip extends FlowerCrop{
    /**
     * This constructor initializes a tulip flower crop object
     */
    public Tulip()
    {
        super("Tulip", 2,
                2, 3, 0, 1,
                1, 1, 10, 9, 5.0);
    }

}

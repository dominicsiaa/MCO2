/**
 * Represents a Sunflower flower crop.
 * Contains the crop's name, harvest time, water needs (and bonus),
 * fertilizer needs (and bonus), minimum and maximum products produced,
 * seed cost, selling price, and exp gain
 */
public class Sunflower extends FlowerCrop{
    /**
     * This constructor initializes a sunflower flower crop object
     */
    public Sunflower()
    {
        super("Sunflower", 3,
                2, 3, 1, 2,
                1,1, 20, 19, 7.5);
    }

}

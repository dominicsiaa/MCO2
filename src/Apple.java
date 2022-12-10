/**
 * Represents an Apple tree crop.
 * Contains the crop's name, harvest time, water needs (and bonus),
 * fertilizer needs (and bonus), minimum and maximum products produced,
 * seed cost, selling price, and exp gain
 */
public class Apple extends TreeCrop{
    /**
     * This constructor initializes an Apple tree crop object
     */
    public Apple()
    {
        super("Apple", 10,
                7, 7, 5, 5,
                10, 15, 200, 5, 25);
    }

}

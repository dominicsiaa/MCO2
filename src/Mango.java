/**
 * Represents a mango tree crop.
 * Contains the crop's name, harvest time, water needs (and bonus),
 * fertilizer needs (and bonus), minimum and maximum products produced,
 * seed cost, selling price, and exp gain
 */
public class Mango extends TreeCrop{
    /**
     * This constructor initializes a Mango tree crop object
     */
    public Mango()
    {
        super("Mango", 10,
                7, 7, 4, 4,
                5, 15, 100, 8, 25);
    }

}

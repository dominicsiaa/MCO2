/**
 * Represents a tool in the game.
 * Contains the tool name, function,
 * cost, and exp gained from using the tool
 */
public class Tool {
    private String name;
    private String function;
    private int cost;
    private double expGain;

    /**
     * This constructor initializes a tool object
     * @param name
     * @param function
     * @param cost
     * @param expGain
     */
    public Tool(String name, String function, int cost, double expGain) {
        this.name = name;
        this.function = function;
        this.cost = cost;
        this.expGain = expGain;
    }

    /**
     * This method returns the tool name
     * @return name
     */
    public String getName() {
        return this.name;
    }

    /**
     * This method returns the tool function
     * @return function
     */
    public String getFunction() {
        return this.function;
    }

    /**
     * This method returns the tool cost
     * @return cost
     */
    public int getCost() {
        return this.cost;
    }

    /**
     * This method returns the experience gained from using the tool
     * @return expGain
     */
    public double getExpGain() {
        return this.expGain;
    }

    @Override
    public String toString(){
        return this.name;
    }

}

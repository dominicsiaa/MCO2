/**
 * Represents a tool in the game.
 * Contains the tool name, cost,
 * and exp gained from using the tool
 */
public class Tool {
    private String name;
    private int cost;
    private double expGain;

    /**
     * This constructor initializes a tool object
     * @param name      name of the tool
     * @param cost      cost of the tool
     * @param expGain   experience gained from using the tool
     */
    public Tool(String name, int cost, double expGain) {
        this.name = name;
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

    /**
     * This method returns the name of the tool
     * @return name
     */
    @Override
    public String toString(){
        return this.name;
    }

}

public class Tool {
    private String name;
    private String function;
    private int cost;
    private double expGain;

    public Tool(String name, String function, int cost, double expGain) {
        this.name = name;
        this.function = function;
        this.cost = cost;
        this.expGain = expGain;
    }

    public String getName() {
        return this.name;
    }

    public String getFunction() {
        return this.function;
    }

    public int getCost() {
        return this.cost;
    }

    public double getExpGain() {
        return this.expGain;
    }

    @Override
    public String toString(){
        return this.name;
    }

}

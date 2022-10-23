public class Tool {
    private String name;
    private String function;
    private int cost;
    private int expGain;

    public Tool(String name, String function, int cost, int expGain) {
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

    public int getExpGain() {
        return this.expGain;
    }

}

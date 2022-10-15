public class Crop {
    private String name;
    private int harvestTime;
    private int waterNeeds;
    private int fertilizerNeeds;

    public Crop(String name, int harvestTime, int waterNeeds, int fertilizerNeeds) {
        this.name = name;
        this.harvestTime = harvestTime;
        this.waterNeeds = waterNeeds;
        this.fertilizerNeeds = fertilizerNeeds;
    }

    public String getName() {
        return this.name;
    }

    public int getHarvestTime() {
        return this.harvestTime;
    }

    public int getWaterNeeds() {
        return this.waterNeeds;
    }

    public int getFertilizerNeeds() {
        return this.fertilizerNeeds;
    }
}

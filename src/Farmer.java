public class Farmer {
    private String name = null;
    private int objectcoins = 100;      //TODO: Change back to original value is 100
    private int level = 0;              //TODO: Change back to original value is 0
    private double exp = 0;
    private FarmerType type = null;

    public Farmer(String name) {
        this.name = name;
        this.type = new FarmerType("Farmer", 0, 0, 0, 0, 0, 0);
    }

    public void gainCoins(int amount){
        this.objectcoins += amount;

        //TODO: Temporary here before GUI in MCO2
        if(amount > 0) {
            System.out.println("You have earned " + amount + " objectcoins");
        }
    }

    public void loseCoins(int amount){
        this.objectcoins -= amount;

        //TODO: Temporary here before GUI in MCO2
        if(amount > 0) {
            System.out.println("You have lost " + amount + " objectcoins");
        }
    }

    public void gainExp(double amount){
        this.exp += amount;

        //TODO: Temporary here before GUI in MCO2
        if(amount > 0) {
            System.out.println("You have gained " + amount + " exp");
        }

        if (this.exp >=100) {
            if ((int) (this.exp / 100) > level) {
                this.level = (int) (this.exp / 100);
                System.out.println("You have leveled up! You are now level " + this.level);
            }
        }
    }

    public boolean register(FarmerType farmerType) {
        
        if( (farmerType.getLevelRequirement() == this.type.getLevelRequirement() + 5) && //order of type
            (this.level >= farmerType.getLevelRequirement()) && //meets level req
            (this.objectcoins >= farmerType.getRegistrationFee()) //has enough coins
        ){
                this.type = farmerType;
                this.loseCoins(farmerType.getRegistrationFee());
                return true;
        }
        return false;
    }

    public boolean useTool (Tool tool, Tile tile)
    {
        //Check if user has enough coins
        boolean success = false;
        if(tool.getCost() <= this.objectcoins) {
            String toolName = tool.getName();

            switch(toolName) {
                case "Plow":
                    success = tile.plow();
                    break;

                case "Watering Can":
                    success = tile.water();
                    break;

                case "Fertilizer":
                    success = tile.fertilize();
                    break;

                case "Pickaxe":
                    success = tile.removeRock();
                    break;

                case "Shovel":
                    tile.clearTile();
                    success = true;
                    break;
            }

            if(success) {
                this.gainExp(tool.getExpGain());
                this.loseCoins(tool.getCost());
            }
        }
        return success;
    }

    //TODO: Implementation for fruit tree conditions for MCO2
    public boolean plantCrop(Crop crop, Tile tile) {
        if(tile.plant(crop)) {
            this.loseCoins(crop.getSeedCost() - this.type.getSeedCostReduction());
            return true;
        }
        return false;
    }

    //TODO: Implementation for flower seeds for MCO2
    public Crop harvestTile(Tile tile) {
        if(tile.getStatus() == Tile.ISHARVESTABLE) {
            Crop harvest = tile.getCropPlanted();
            int productAmount = harvest.generateProductAmount();

            double harvestTotal = productAmount * (harvest.getSellingPrice() + this.type.getBonusEarningsPerProduce());
            double waterBonus = harvestTotal * 0.2 * (Math.min(tile.getTimesWatered(), harvest.getWaterNeedsBonusLimit() + this.getType().getWaterBonusLimitIncrease()) - 1);
            double fertilzierBonus = harvestTotal * 0.5 * Math.min(tile.getTimesFertilized(), harvest.getFertilizerNeedsBonusLimit() + this.getType().getFertilizerBonusLimitIncrease());

            //not sure if this is int or double
            int total = (int) (harvestTotal + waterBonus + fertilzierBonus);

            //TODO: Temporary here before GUI in MCO2
            System.out.println("You have harvested " + productAmount + " " + harvest.getName() + "/s");

            this.gainCoins(total);
            this.gainExp(harvest.getExpGain());
            tile.harvest();
            return harvest;
        }
        return null;
    }

    public String getName() {
        return this.name;
    }

    public int getObjectcoins() {
        return this.objectcoins;
    }

    public int getLevel() {
        return this.level;
    }

    public double getExp() {
        return this.exp;
    }

    public FarmerType getType() {
        return this.type;
    }

    //override tostring
    @Override
    public String toString(){
        return "Farmer: " + this.name + " | Type: " + this.type.getName() + " | Coins: " + this.objectcoins + " | Level: " + this.level + " | Exp: " + this.exp;
    }

}


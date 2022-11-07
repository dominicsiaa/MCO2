/**
 * Represents a farmer in the game.
 * Contains the farmer name, amount of objectcoins,
 * level, experience points, and farmer type
 */
public class Farmer {
    private String name = null;
    private double objectcoins = 100;
    private int level = 0;
    private double exp = 0;
    private FarmerType type = MyFarm.FARMERTYPELIST.get(0);

    /**
     * This constructor initializes a farmer object
     * @param name
     */
    public Farmer(String name) {
        this.name = name;
    }

    /**
     * This method adds objectcoins to the farmer's objectcoins
     * @param amount
     */
    public void gainCoins(double amount){
        this.objectcoins += amount;

        //TODO: Temporary here before GUI in MCO2
        if(amount > 0) {
            System.out.println("You have earned " + amount + " objectcoins");
        }
    }

    /**
     * This method subtracts objectcoins from the farmer's objectcoins
     * @param amount
     */
    public void loseCoins(double amount){
        this.objectcoins -= amount;

        //TODO: Temporary here before GUI in MCO2
        if(amount > 0) {
            System.out.println("You have lost " + amount + " objectcoins");
        }
    }

    /**
     * This method adds experience points to the farmer's experience points
     * @param amount
     */
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

    /**
     * This method allows a farmer to register if they meet the minimum requirements
     * @param farmerType
     * @return true if the farmer meets the minimum requirements
     */
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

    /**
     * This method allows a farmer to use a tool
     * @param tool
     * @return true if the farmer has enough objectcoins to use the tool
     */
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
    /**
     * This method allows a farmer to plant a crop
     * @param crop
     * @param tile
     * @return true if the farmer successfully plants the crop
     */
    public boolean plantCrop(Crop crop, Tile tile) {
        if(tile.plant(crop)) {
            this.loseCoins(crop.getSeedCost() - this.type.getSeedCostReduction());
            return true;
        }
        return false;
    }

    //TODO: Implementation for flower seeds for MCO2
    /**
     * This method allows a farmer to harvest a crop
     * @param tile
     * @return crop harvested
     */
    public Crop harvestTile(Tile tile) {
        if(tile.getStatus() == Tile.ISHARVESTABLE) {
            Crop harvest = tile.getCropPlanted();
            int productAmount = harvest.generateProductAmount();

            double harvestTotal = productAmount * (harvest.getSellingPrice() + this.type.getBonusEarningsPerProduce());
            double waterBonus = harvestTotal * 0.2 * (Math.min(tile.getTimesWatered(), harvest.getWaterNeedsBonusLimit() + this.getType().getWaterBonusLimitIncrease()) - 1);
            double fertilzierBonus = harvestTotal * 0.5 * Math.min(tile.getTimesFertilized(), harvest.getFertilizerNeedsBonusLimit() + this.getType().getFertilizerBonusLimitIncrease());

            //not sure if this is int or double
            double total = harvestTotal + waterBonus + fertilzierBonus;

            //TODO: Temporary here before GUI in MCO2
            System.out.println("You have harvested " + productAmount + " " + harvest.getName() + "/s");

            this.gainCoins(total);
            this.gainExp(harvest.getExpGain());
            tile.harvest();
            return harvest;
        }
        return null;
    }

    /**
     * This method gets the farmer's name
     * @return name
     */
    public String getName() {
        return this.name;
    }

    /**
     * This method gets the farmer's objectcoins
     * @return objectcoins
     */
    public double getObjectcoins() {
        return this.objectcoins;
    }

    /**
     * This method gets the farmer's level
     * @return level
     */
    public int getLevel() {
        return this.level;
    }

    /**
     * This method gets the farmer's experience points
     * @return exp
     */
    public double getExp() {
        return this.exp;
    }

    /**
     * This method gets the farmer's type
     * @return type
     */
    public FarmerType getType() {
        return this.type;
    }


    //override tostring
    /**
     * This method returns a string representation of the farmer
     * @return string representation of the farmer
     */
    @Override
    public String toString(){
        return "Farmer: " + this.name + " | Type: " + this.type.getName() + " | Coins: " + this.objectcoins + " | Level: " + this.level + " | Exp: " + this.exp;
    }

}


/**
 * Represents a farmer in the game.
 * Contains the farmer name, amount of objectcoins,
 * level, experience points, and farmer type
 */
public class Farmer {
    private String name = "Farmer";
    private double objectcoins = 100;
    private int level = 0;
    private double exp = 0;
    private FarmerType type = MyFarmModel.FARMERTYPELIST.get(0);

    /**
     * This constructor initializes a farmer object
     * @param name name of the farmer
     */
    public Farmer(String name) {
        if(name.equals("")) {
            this.name = "Farmer";
        } else {
            this.name = name;
        }
    }

    /**
     * This method adds objectcoins to the farmer's objectcoins
     * @param amount amount of objectcoins to add
     */
    public void gainCoins(double amount){
        this.objectcoins += amount;
    }

    /**
     * This method subtracts objectcoins from the farmer's objectcoins
     * @param amount amount of objectcoins to subtract
     */
    public void loseCoins(double amount){
        this.objectcoins -= amount;
    }

    /**
     * This method adds experience points to the farmer's experience points
     * @param amount amount of experience points to add
     */
    public void gainExp(double amount){
        this.exp += amount;
        if (this.exp >= 100) {
            this.level++;
            this.exp -= 100;
        }
    }

    /**
     * This method allows a farmer to register if they meet the minimum requirements
     * @param farmerType type of farmer to register as
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
     * @param tool tool to use
     * @param tile tile to use the tool on
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

    /**
     * This method allows a farmer to plant a crop
     * @param crop crop to plant
     * @param tile tile to plant the crop on
     * @return true if the farmer successfully plants the crop
     */
    public boolean plantCrop(Crop crop, Tile tile) {
        if(this.objectcoins >= crop.getSeedCost() + this.type.getSeedCostReduction()) {
            if(tile.plant(crop)) {
                this.loseCoins(crop.getSeedCost() + this.type.getSeedCostReduction());
                return true;
            }
        }
        return false;
    }

    /**
     * This method allows a farmer to harvest a crop
     * @param tile tile to harvest
     * @return the number of crops produced
     */
    public int harvestTile(Tile tile) {
        if(tile.getStatus() == Tile.ISHARVESTABLE) {
            Crop harvest = tile.getCropPlanted();
            int productAmount;

            if(harvest.getMinProductsProduced() == harvest.getMaxProductsProduced()) {
                productAmount = harvest.getMinProductsProduced();
            } else {
                productAmount = (int)(Math.random() * (harvest.getMaxProductsProduced() - harvest.getMinProductsProduced() + 1) + harvest.getMinProductsProduced());
            }

            double harvestTotal = productAmount * (harvest.getSellingPrice() + this.type.getBonusEarningsPerProduce());
            double waterBonus = harvestTotal * 0.2 * (Math.min(tile.getTimesWatered(), harvest.getWaterNeedsBonusLimit() + this.getType().getWaterBonusLimitIncrease()) - 1);
            double fertilizerBonus = harvestTotal * 0.5 * Math.min(tile.getTimesFertilized(), harvest.getFertilizerNeedsBonusLimit() + this.getType().getFertilizerBonusLimitIncrease());
            double total = harvestTotal + waterBonus + fertilizerBonus;

            if(harvest instanceof FlowerCrop) {
                total *= 1.1;
            }

            this.gainCoins(total);
            this.gainExp(harvest.getExpGain());
            tile.harvest();
            return productAmount;
        }
        return -1;
    }

    /**
     * This method gets the farmer's name
     * @return name of the farmer
     */
    public String getName() {
        return this.name;
    }

    /**
     * This method gets the farmer's objectcoins
     * @return objectcoins of the farmer
     */
    public double getObjectcoins() {
        return this.objectcoins;
    }

    /**
     * This method gets the farmer's level
     * @return level of the farmer
     */
    public int getLevel() {
        return this.level;
    }

    /**
     * This method gets the farmer's experience points
     * @return exp of the farmer
     */
    public double getExp() {
        return this.exp;
    }

    /**
     * This method gets the farmer's type
     * @return farmer type of the farmer
     */
    public FarmerType getType() {
        return this.type;
    }
}


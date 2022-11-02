public class Farmer {
    private String name = null;
    private int objectcoins = 10000;    //TODO: Change back to original value is 100
    private int level = 100;            //TODO: Change back to original value is 0
    private double exp = 0;
    private FarmerType type = new FarmerType("Farmer", 0, 0, 0, 0, 0, 0);

    public Farmer(String name) {
        this.name = name;
    }

    public Farmer() {
        // Default constructor
    }

    public void gainCoins(int amount){
        this.objectcoins += amount;
    }

    public void loseCoins(int amount){
        this.objectcoins -= amount;
    }

    //TODO: add levelup function
    public void gainExp(double amount){
        this.exp += amount;
    }

    public void levelUp () {
        if (this.exp / 100 > level) {
            this.level = (int) (this.exp / 100);
            System.out.println("You have leveled up! You are now level " + this.level);
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
            int tileStatus = tile.getStatus();

            switch(toolName) {
                case "Plow":
                    if(tileStatus == Tile.ISUNPLOWED) {
                        tile.plow();
                        success = true;
                    }
                    break;

                case "Watering Can":
                    if(tileStatus == Tile.ISPLANTED) {
                        tile.water();
                        success = true;
                    }
                    break;

                case "Fertilizer":
                    if(tileStatus == Tile.ISPLANTED) {
                        tile.fertilize();
                        success = true;
                    }
                    break;

                case "Pickaxe":
                    if(tileStatus == Tile.HASROCK) {
                        tile.removeRock();
                        success = true;
                    }
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

    //TODO: Not sure if int or double ung objectcoins
    public Crop harvestTile(Tile tile) {
        if(tile.getStatus() == Tile.ISHARVESTABLE) {
            Crop harvest = tile.getCropPlanted();

            double harvestTotal = harvest.generateProductAmount() * (harvest.getSellingPrice() + this.type.getBonusEarningsPerProduce());
            double waterBonus = harvestTotal * 0.2 * (Math.min(tile.getTimesWatered(), harvest.getWaterNeedsBonusLimit() + this.getType().getWaterBonusLimitIncrease()) - 1);
            double fertilzierBonus = harvestTotal * 0.5 * Math.min(tile.getTimesFertilized(), harvest.getFertilizerNeedsBonusLimit() + this.getType().getFertilizerBonusLimitIncrease());

            this.gainCoins((int) (harvestTotal + waterBonus + fertilzierBonus));
            tile.harvest();
            return harvest;
        }
        return null;
    }

    //TODO: implement plant crop function
    public boolean plantCrop(Crop crop, Tile tile) {
        return false;
    }

    /*
    public boolean usePlow(Tile tile){
        return false;
    }

    public boolean useWateringCan(Tile tile){
        return false;
    }

    public boolean useFertilizer(Tile tile){
        return false;
    }

    public boolean usePickaxe(Tile tile){
        return false;
    }

    public boolean useShovel(Tile tile){
        return false;
    }

    public void plantSeed(Crop crop, Tile tile){
        return;
    }

    public void harvestCrop(Tile tile){
        return;
    }
    */


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


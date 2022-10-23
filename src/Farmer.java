public class Farmer {
    private String name = null;
    private int objectcoins = 100;
    private int level = 0;
    private double exp = 0;
    private String type = "Farmer";
    private int bonusEarningsPerProduce = 0;
    private int seedCostReduction = 0;
    private int waterBonusLimitIncrease = 0;
    private int fertilizerBonusLimitIncrease = 0;

    public Farmer(String name) {
        this.name = name;
    }

    public Farmer() {
        // Default constructor
    }

    public void gainCoins(int amount){
        this.objectcoins += amount;
    }

    public boolean loseCoins(int amount){
        if (this.objectcoins <= 0){
            return false;
        }
        else{
            this.objectcoins -= amount;
            return true;
        }
    }

    //TODO: add levelup function
    public void gainExp(double amount){
        this.exp += amount;
    }

    public boolean register() {
        if (this.type == "Distinguished Farmer" && this.level >= 15 && this.objectcoins >= 400){
            this.type = "Legendary Farmer";
            this.bonusEarningsPerProduce = 4;
            this.seedCostReduction = 3;
            this.waterBonusLimitIncrease = 2;
            this.fertilizerBonusLimitIncrease = 1;
            return true;
        }

        else if (this.type == "Registered Farmer" && this.level >= 10 && this.objectcoins >= 300){
            this.type = "Distiguished Farmer";
            this.bonusEarningsPerProduce = 2;
            this.seedCostReduction = 2;
            this.waterBonusLimitIncrease = 1;
            this.fertilizerBonusLimitIncrease = 0;
            return true;
        }

        else if (this.level >= 5 && this.objectcoins >= 200){
            this.type = "Registered Farmer";
            this.bonusEarningsPerProduce = 1;
            this.seedCostReduction = 1;
            this.waterBonusLimitIncrease = 0;
            this.fertilizerBonusLimitIncrease = 0;
            return true;
        }

        else{
            return false;
        }

    }

    public boolean useTool (Tool tool, Tile tile)
    {
        if(tool.getCost() <= this.objectcoins) {
            String toolName = tool.getName();
            int tileStatus = tile.getStatus();

            if(toolName.equals("Plow") && tileStatus == 1) {
                this.gainExp(tool.getExpGain());
                this.loseCoins(tool.getCost());

                tile.plow();
                return true;

            } else if(toolName.equals("Watering Can") && tileStatus == 3) {
                this.gainExp(tool.getExpGain());
                this.loseCoins(tool.getCost());

                tile.water();
                return true;

            } else if(toolName.equals("Fertilizer") && tileStatus == 3) {
                this.gainExp(tool.getExpGain());
                this.loseCoins(tool.getCost());

                tile.fertilize();
                return true;

            } else if(toolName.equals("Pickaxe") && tileStatus == 0) {
                this.gainExp(tool.getExpGain());
                this.loseCoins(tool.getCost());

                tile.removeRock();
                return true;

            } else if(toolName.equals("Shovel")) {
                this.gainExp(tool.getExpGain());
                this.loseCoins(tool.getCost());

                tile.clearTile();
                return true;

            }
        }

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

    //override tostring
    @Override
    public String toString(){
        return "Farmer: " + this.name + " | Coins: " + this.objectcoins + " | Level: " + this.level + " | Exp: " + this.exp + " | Type: " + this.type;
    }






}


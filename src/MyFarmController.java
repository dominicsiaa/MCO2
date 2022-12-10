import java.awt.event.*;
import java.text.DecimalFormat;

/**
 * Represents the controller of the application
 */
public class MyFarmController implements ActionListener {
    private MyFarmModel farm;
    private MyFarmView gui;

    private int selectedTile = 0;


    /**
     * This constructor initializes the controller
     * @param farm  the model
     * @param gui   the view
     */
    public MyFarmController(MyFarmModel farm, MyFarmView gui) {
        this.farm = farm;
        this.gui = gui;

        this.gui.setActionListener(this);
    }

    /**
     * Helper function for the update tile events
     * @param tileNumber  the tile number of the tile to update
     * @param tile        the tile object to update the gui from
     */
    private void updateTileInfo(int tileNumber, Tile tile) {
        if(tile.getStatus() == Tile.ISHARVESTABLE) {
            this.gui.updateTileInfoHarvestable(tileNumber, tile);
        } else if(tile.getStatus() == Tile.ISPLANTED) {
            this.gui.updateTileInfoPlanted(tileNumber, tile);
        } else {
            this.gui.updateTileInfoDefault(tileNumber, tile);
        }

        if(tile.getStatus() == Tile.ISPLOWED) {
            this.gui.setBtnSeedListEnabled(true);
        } else {
            this.gui.setBtnSeedListEnabled(false);
        }

    }

    /**
     * Helper function for starting the game
     */
    private void startGame() {
        this.farm.run(gui.getTfName());
        Farmer farmer = this.farm.getFarmer();
        this.gui.loadGameScreen(farmer.getName(), farmer.getObjectcoins(), farmer.getLevel(), farmer.getExp(), this.farm.getLot());
        this.gui.setActionListener(this);

        this.gui.setTileSelected(0);
        this.gui.updateTileInfoDefault(0, this.farm.getTile(0));
        this.gui.sendConsoleMessage("Tile (1,1) selected");
    }

    /**
     * This method handles the action events
     * @param e     the action event
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        System.out.println("Command: " + command);

        //GAME START
        if (command.equals("Start")) {
            this.startGame();

        //EXIT GAME
        } else if (command.equals("Exit Game")) {
            this.gui.closeWindow();

        //RESTART GAME
        } else if (command.equals("Restart Game")) {
            this.farm = new MyFarmModel();
            this.gui.setTileUnselected(this.selectedTile);
            this.selectedTile = 0;

            this.gui.closeWindow();
            this.gui = new MyFarmView();

            this.startGame();

        //ADVANCE DAY
        } else if (command.equals("Advance Day")) {
            if(this.farm.advanceDay()) {
                this.gui.sendConsoleMessage("Day advanced - A crop has withered!");
            } else {
                this.gui.sendConsoleMessage("Day advanced");
            }
            this.gui.updatePlot(this.farm.getLot());
            this.updateTileInfo(this.selectedTile, this.farm.getTile(this.selectedTile));
            this.gui.updateDay(this.farm.getDay());

            //GAME END
            if(!this.farm.getIsRunning()) {
                this.gui.loadEndScreen();
                this.gui.setActionListener(this);
            }

        //HARVEST
        } else if (command.equals("Harvest")) {
            Farmer farmer = this.farm.getFarmer();
            double initialCoins = farmer.getObjectcoins();
            Tile tile = this.farm.getTile(this.selectedTile);
            Crop crop = tile.getCropPlanted();
            
            int nCropsProduced = farmer.harvestTile(tile);

            if(nCropsProduced != -1) {
                this.gui.sendConsoleMessage("You have successfully harvested " + nCropsProduced + " " + crop + "/s from tile (" + Integer.toString(this.selectedTile/10+1) + "," + Integer.toString(this.selectedTile%10+1) + ") -> You have earned " + (new DecimalFormat("0.00")).format(farmer.getObjectcoins() - initialCoins) + " coins");
                this.updateTileInfo(this.selectedTile, this.farm.getTile(this.selectedTile));
                this.gui.updateFarmerInfo(farmer.getObjectcoins(), farmer.getLevel(), farmer.getExp());
                this.gui.updatePlot(this.farm.getLot());
            } else {
                this.gui.sendConsoleMessage("Invalid use of Harvest Crop");   
            }

        } else if (command.equals("?")) {
            this.gui.showInfoPopup();

        } else {
            String[] args = command.split(":");
            String action = args[0];

            try {
                int parameter = Integer.parseInt(args[1]);

                //SELECT TILE
                if(action.equals("TILE")) {
                    this.updateTileInfo(parameter, this.farm.getTile(parameter));

                    this.gui.setTileUnselected(this.selectedTile);
                    this.selectedTile = parameter;
                    this.gui.setTileSelected(this.selectedTile);

                    this.gui.sendConsoleMessage("Tile (" + Integer.toString(parameter/10+1) + "," + Integer.toString(parameter%10+1) + ") selected");

                //USE TOOL
                } else if(action.equals("TOOL")) {
                    Tool tool = MyFarmModel.TOOLLIST.get(parameter);
                    Farmer farmer = this.farm.getFarmer();
                    if(farmer.useTool(tool, this.farm.getTile(this.selectedTile))) {
                        this.gui.sendConsoleMessage("\nYou have successfully used " + tool + " on tile (" + Integer.toString(this.selectedTile/10+1) + "," + Integer.toString(this.selectedTile%10+1) + ")");
                        this.updateTileInfo(this.selectedTile, this.farm.getTile(this.selectedTile));
                        this.gui.updateFarmerInfo(farmer.getObjectcoins(), farmer.getLevel(), farmer.getExp());
                        this.gui.updatePlot(this.farm.getLot());
                    } else {
                        this.gui.sendConsoleMessage("\nInvalid use of " + tool);
                    }

                //PLANT CROP
                } else if(action.equals("SEED")) {
                    Crop crop = MyFarmModel.CROPLIST.get(parameter);
                    Farmer farmer = this.farm.getFarmer();
                    boolean allowed = true;

                    if(crop instanceof TreeCrop) {
                        for(int i = 0; i < 3; i++) {
                            for(int j = 0; j < 3; j++) {
                                if(allowed) {
                                    try {
                                        Tile tileCheck = this.farm.getTile((this.selectedTile/10 - 1 + i),(this.selectedTile%10 - 1 + j));
                                        System.out.println("Cur Tile: " + this.selectedTile + " Tile:" + (this.selectedTile/10 - 1 + i) + (this.selectedTile%10 - 1 + j) + " Status:" + tileCheck.getStatus());
                                        if(!(tileCheck.getStatus() == Tile.ISPLOWED || tileCheck.getStatus() == Tile.ISUNPLOWED)) {
                                            allowed = false;
                                            this.gui.sendConsoleMessage("The space around the fruit tree is not empty");
                                        }
                                    } catch(IndexOutOfBoundsException ex) {
                                        allowed = false;
                                        this.gui.sendConsoleMessage("Cannot plant fruit trees at the edge of the lot");
                                    }
                                }
                            }
                        }
                    }

                    if(allowed) {
                        if(farmer.plantCrop(crop, this.farm.getTile(this.selectedTile))) {
                            this.gui.sendConsoleMessage("You have successfully planted a " + crop + " on tile (" + Integer.toString(parameter/10+1) + "," + Integer.toString(parameter%10+1) + ")");
                            this.updateTileInfo(this.selectedTile, this.farm.getTile(this.selectedTile));
                            this.gui.updateFarmerInfo(farmer.getObjectcoins(), farmer.getLevel(), farmer.getExp());
                            this.gui.updatePlot(this.farm.getLot());
                        } else {
                            this.gui.sendConsoleMessage("Invalid use of Plant " + crop);   
                        }
                    }

                //REGISTER FARMER
                } else if(action.equals("RANKUP")) {
                    FarmerType type = MyFarmModel.FARMERTYPELIST.get(parameter);
                    Farmer farmer = this.farm.getFarmer();

                    if(farmer.register(type)) {
                        this.gui.sendConsoleMessage("You have successfully registered as a " + type);
                        this.gui.updateFarmerInfo(farmer.getObjectcoins(), farmer.getLevel(), farmer.getExp());
                        

                        if(type.toString().equals(MyFarmModel.FARMERTYPELIST.get(MyFarmModel.FARMERTYPELIST.size()-1).toString())) {
                            this.gui.setBtnRankUpText("Max rank!");
                            this.gui.setBtnRankUpEnabled(false);
                        } else {
                            FarmerType newType = MyFarmModel.FARMERTYPELIST.get(parameter+1);
                            this.gui.setBtnRankUpText("Rank Up! (Level " + newType.getLevelRequirement() + ", " + newType.getRegistrationFee() + " coins)");
                            this.gui.setBtnRankUpActionCommand("RANKUP:" + Integer.toString(parameter+1));
                        }
                        this.gui.updateFarmerRank(type);
                        
                    } else {
                        this.gui.sendConsoleMessage("Invalid use of Register as " + type);
                    }

                }

            } catch (NumberFormatException ex) {
            
            }
            
        }
    }
}

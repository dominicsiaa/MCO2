import java.awt.*;
import java.awt.event.*;
import java.io.Console;

import javax.swing.event.*;

public class MyFarmController implements ActionListener {
    private MyFarmModel farm;
    private MyFarmView gui;

    private int selectedTile = 0;

    public MyFarmController(MyFarmModel farm, MyFarmView gui) {
        this.farm = farm;
        this.gui = gui;

        this.gui.setActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        System.out.println("Command: " + command);

        if(command.equals("Start")) {
            this.farm.run(gui.getTfName());
            Farmer farmer = this.farm.getFarmer();
            this.gui.loadGameScreen(farmer.getName(), farmer.getObjectcoins(), farmer.getLevel(), farmer.getExp(), this.farm.getLot());
            this.gui.setActionListener(this);

            this.gui.setTileSelected(0);
            this.gui.updateTileInfo(0, this.farm.getTile(0));
        } else {
            String[] args = command.split(":");
            String action = args[0];

            try {
                int parameter = Integer.parseInt(args[1]);

                if(action.equals("TILE")) {
                    this.gui.updateTileInfo(parameter, this.farm.getTile(parameter));

                    this.gui.setTileUnselected(this.selectedTile);
                    this.selectedTile = parameter;
                    this.gui.setTileSelected(this.selectedTile);

                    this.gui.sendConsoleMessage("Tile (" + Integer.toString(parameter/10+1) + "," + Integer.toString(parameter%10+1) + ") clicked");

                } else if(action.equals("TOOL")) {
                    Tool tool = MyFarmModel.TOOLLIST.get(parameter);
                    Farmer farmer = this.farm.getFarmer();
                    if(farmer.useTool(tool, this.farm.getTile(this.selectedTile))) {
                        this.gui.sendConsoleMessage("\nYou have successfully used " + tool + " on tile (" + Integer.toString(parameter/10+1) + "," + Integer.toString(parameter%10+1) + ")");
                        this.gui.updateTileInfo(this.selectedTile, this.farm.getTile(this.selectedTile));
                        this.gui.updateFarmerInfo(farmer.getObjectcoins(), farmer.getLevel(), farmer.getExp());
                        this.gui.updatePlot(this.farm.getLot());
                    } else {
                        this.gui.sendConsoleMessage("\nInvalid use of " + tool);
                    }
                } else if(action.equals("SEED")) {
                    Crop crop = MyFarmModel.CROPLIST.get(parameter);
                    Farmer farmer = this.farm.getFarmer();
                    if(farmer.plantCrop(crop, this.farm.getTile(this.selectedTile))) {
                        this.gui.sendConsoleMessage("You have successfully planted a " + crop + " on tile (" + Integer.toString(parameter/10+1) + "," + Integer.toString(parameter%10+1) + ")");
                        this.gui.updateTileInfo(this.selectedTile, this.farm.getTile(this.selectedTile));
                        this.gui.updateFarmerInfo(farmer.getObjectcoins(), farmer.getLevel(), farmer.getExp());
                        this.gui.updatePlot(this.farm.getLot());
                    } else {
                        this.gui.sendConsoleMessage("Invalid use of Plant " + crop);   
                    }
                }

            } catch (NumberFormatException ex) {
            
            }
            
        }
    }
}

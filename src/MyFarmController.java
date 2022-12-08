import java.awt.*;
import java.awt.event.*;
import java.io.Console;

import javax.swing.event.*;

public class MyFarmController implements ActionListener {
    private MyFarmModel farm;
    private MyFarmView gui;

    private int selectedTile = 0;
    private String selectedAction = "";

    public MyFarmController(MyFarmModel farm, MyFarmView gui) {
        this.farm = farm;
        this.gui = gui;

        this.gui.setActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        System.out.println("Command: " + command);

        switch(command) {
            case "Start":
                this.farm.run(gui.getTfName());
                this.gui.loadGameScreen(this.farm.getFarmerName(), this.farm.getFarmerObjectcoins(), this.farm.getFarmerLevel(), this.farm.getFarmerExp(), this.farm.getLot());
                this.gui.setActionListener(this);
                break;
            case "Plow":
                this.selectedAction = "Plow";
                break;
            case "Watering Can":
                this.selectedAction = "Watering Can";
                break;
            case "Fertilizer":
                this.selectedAction = "Fertilizer";
                break;
            case "Pickaxe":
                this.selectedAction = "Pickaxe";
                break;
            case "Shovel":
                this.selectedAction = "Shovel";
                break;
            default:
                try {
                    int n = Integer.parseInt(command);
                    System.out.println("Tile " + n + " clicked");
                    this.selectedTile = n;
                    gui.updateTileInfo(n, this.farm.getTile(n));
                } catch (NumberFormatException ex) {
                    
                }
                break;
        }
    }
}

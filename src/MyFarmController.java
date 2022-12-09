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

        if(command.equals("Start")) {
            this.farm.run(gui.getTfName());
            this.gui.loadGameScreen(this.farm.getFarmerName(), this.farm.getFarmerObjectcoins(), this.farm.getFarmerLevel(), this.farm.getFarmerExp(), this.farm.getLot());
            this.gui.setActionListener(this);
        } else {
            String[] args = command.split(":");
            String action = args[0];

            try {
                int parameter = Integer.parseInt(args[1]);
                if(action.equals("TILE")) {
                    System.out.println("Tile " + parameter + " clicked");
                    this.selectedTile = parameter;
                    gui.updateTileInfo(parameter, this.farm.getTile(parameter));
                    
                } else if(action.equals("TOOL")) {
                    System.out.println("Tool " + parameter + " clicked, " + MyFarmModel.TOOLLIST.get(parameter).getName());
                }

            } catch (NumberFormatException ex) {
            
            }
            
        }
    }
}

import java.awt.*;
import java.awt.event.*;
import java.io.Console;

import javax.swing.event.*;

public class MyFarmController implements ActionListener {
    private MyFarmModel farm;
    private MyFarmView gui;

    public MyFarmController(MyFarmModel farm, MyFarmView gui) {
        this.farm = farm;
        this.gui = gui;

        this.gui.setActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Start")) {
            this.farm.run(gui.getTfName());

            this.gui.loadGameScreen(this.farm.getFarmerName(), this.farm.getFarmerObjectcoins());
        }
    }
}

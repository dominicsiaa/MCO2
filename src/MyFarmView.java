import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;

import java.util.ArrayList;
import java.text.DecimalFormat;

public class MyFarmView extends JFrame {

    private JFrame mainFrame;
    private JButton btnRun;
    private JTextField tfName;

    //misc
    private JLabel lblConsole;
    private JButton btnRankUp = new JButton();
    private JButton btnAdvanceDay = new JButton();

    //farmer info
    private JLabel lblName = new JLabel();
    private JLabel lblCoins = new JLabel();
    private JLabel lblExp = new JLabel();
    private JLabel lblLevel = new JLabel();
    private JLabel lblRank = new JLabel();
    private JLabel lblDay = new JLabel();
    private JButton btnHarvest = new JButton();

    //tools
    private ArrayList<JButton> btnlistTools = new ArrayList<JButton>();

    //plot
    private ArrayList<JButton> btnlistPlot = new ArrayList<JButton>();

    //seeds
    private ArrayList<JButton> btnlistSeeds = new ArrayList<JButton>();

    //tile-info
    private JLabel lblTileNumber = new JLabel();
    private JLabel lblTileDisplay = new JLabel();
    private JLabel lblTileCropName = new JLabel();
    private JLabel lblTileTimesWatered = new JLabel();
    private JLabel lblTileTimesFertilized = new JLabel();
    private JLabel lblTileDaysPast = new JLabel();

    public MyFarmView() {
        this.mainFrame = new JFrame("MyFarm");

        this.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.mainFrame.setLayout(new BorderLayout());
        
        /*
        Toolkit tk=Toolkit.getDefaultToolkit();
        Dimension screenSize = tk.getScreenSize();
        this.mainFrame.setSize(screenSize.width-50,screenSize.height-50);
        */
        this.initializeIntroScreen();
        this.mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        //this.mainFrame.setSize(1920, 1080);
        //this.mainFrame.setResizable(false);
        this.mainFrame.setVisible(true);
    }


    private void initializeIntroScreen() {

        //Intro panel to ask for name
        JPanel introPanel = new JPanel();

        introPanel.setLayout(new GridBagLayout());

        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.CENTER;
        c.insets = new Insets(5,5,5,5);
        c.gridx = 0;
        c.gridy = 0;
        
        introPanel.add(new JLabel("Welcome to MyFarm!"), c);

        c.gridy = 1;
        introPanel.add(new JLabel("Please enter your name:"), c);
        
        c.gridy = 2;
        this.tfName = new JTextField(20);
        introPanel.add(tfName, c);

        c.gridy = 3;
        this.btnRun = new JButton("Start");
        introPanel.add(this.btnRun, c);

        this.mainFrame.add(introPanel, BorderLayout.CENTER);
    }


    private void initializeGameScreen(String name) {

        //North - farmer info
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        topPanel.setBackground(Color.ORANGE);
        topPanel.setBorder(new EmptyBorder(5,5,5,5));
        topPanel.setPreferredSize(new Dimension(0, 200));

        //North-West - farmer info
        JPanel farmerInfoPanel = new JPanel();
        farmerInfoPanel.setLayout(new GridLayout(2,2));
        farmerInfoPanel.setBackground(new Color(0,0,0,0));

        lblName.setText("Farmer: " + name);
        lblName.setFont(new Font("Verdana", Font.BOLD, 25));
        lblCoins.setFont(new Font("Verdana", Font.BOLD, 25));
        lblLevel.setFont(new Font("Verdana", Font.BOLD, 25));
        lblExp.setFont(new Font("Verdana", Font.BOLD, 25));

        farmerInfoPanel.add(this.lblName);
        farmerInfoPanel.add(this.lblCoins);
        farmerInfoPanel.add(this.lblLevel);
        farmerInfoPanel.add(this.lblExp);

        //North-East - actions
        JPanel actionsPanel = new JPanel();
        actionsPanel.setLayout(new GridLayout(2,1));
        actionsPanel.setBackground(new Color(0,0,0,0));

        lblRank.setFont(new Font("Verdana", Font.BOLD, 25));
        lblDay.setFont(new Font("Verdana", Font.BOLD, 25));
        
        actionsPanel.add(this.lblRank);
        this.btnRankUp = new JButton("Rank Up! (200 Coins)");
        this.btnRankUp.setActionCommand("RANKUP:1");
        actionsPanel.add(this.btnRankUp);

        actionsPanel.add(this.lblDay);
        this.btnAdvanceDay = new JButton("Advance Day");
        this.btnAdvanceDay.setActionCommand("Advance Day");
        actionsPanel.add(this.btnAdvanceDay);

        topPanel.add(farmerInfoPanel, BorderLayout.WEST);
        topPanel.add(actionsPanel, BorderLayout.EAST);
        this.mainFrame.add(topPanel, BorderLayout.NORTH);

        //West - tool stuff
        JPanel toolPanel = new JPanel();
        toolPanel.setLayout(new GridLayout(6,1));
        toolPanel.setPreferredSize(new Dimension(150, 60));
        toolPanel.setBorder(new EmptyBorder(0,15,80,15));
        toolPanel.setBackground(Color.BLUE);

        JLabel lblTool = new JLabel("Tools");
        lblTool.setFont(new Font("Verdana", Font.BOLD, 35));
        lblTool.setHorizontalAlignment(JLabel.CENTER);
        toolPanel.add(lblTool);

        for(int i = 0; i < MyFarmModel.TOOLLIST.size(); i++) {
            JButton btn = new JButton(MyFarmModel.TOOLLIST.get(i).getName());
            
            btn.setActionCommand("TOOL:" + Integer.toString(i));
            this.btnlistTools.add(btn);
            toolPanel.add(this.btnlistTools.get(i));
        }

        this.mainFrame.add(toolPanel, BorderLayout.WEST);

        //Center - lot
        JPanel farmPanel = new JPanel();
        farmPanel.setLayout(new BorderLayout());
        farmPanel.setBackground(Color.GREEN);

        this.lblConsole = new JLabel("");
        this.lblConsole.setForeground(Color.RED);
        farmPanel.add(lblConsole, BorderLayout.NORTH);
        
        JPanel lotPanel = new JPanel();
        lotPanel.setLayout(new GridLayout(5,10));
        lotPanel.setBorder(new EmptyBorder(40,15,40,15));
        lotPanel.setBackground(Color.GREEN);

        for(int i = 0; i < 50; i++) {
            JButton btn = new JButton(Integer.toString(i));
            btn.setBackground(Color.LIGHT_GRAY);

            btn.setActionCommand("TILE:" + Integer.toString(i));
            this.btnlistPlot.add(btn);
            lotPanel.add(btnlistPlot.get(i));
        }

        farmPanel.add(lotPanel, BorderLayout.CENTER);
        this.mainFrame.add(farmPanel, BorderLayout.CENTER);

        //East - info
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BorderLayout());
        infoPanel.setBorder(new EmptyBorder(5,5,5,5));
        infoPanel.setBackground(Color.YELLOW);
        infoPanel.setPreferredSize(new Dimension(350, 0));

        JLabel lbInfo = new JLabel("Info");
        lbInfo.setFont(new Font("Verdana", Font.BOLD, 35));
        lbInfo.setHorizontalAlignment(JLabel.CENTER);
        infoPanel.add(lbInfo, BorderLayout.NORTH);

        //East-North - tile info
        JPanel tileInfoPanel = new JPanel();
        tileInfoPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.CENTER;
        c.insets = new Insets(5,5,5,5);
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        tileInfoPanel.add(this.lblTileNumber, c);

        c.gridy = 1;
        tileInfoPanel.add(this.lblTileDisplay, c);

        c.gridwidth = 1;
        c.gridy = 2;
        tileInfoPanel.add(this.lblTileCropName, c);

        c.gridx = 1;
        tileInfoPanel.add(this.lblTileDaysPast, c);

        c.gridx = 0;
        c.gridy = 3;
        tileInfoPanel.add(this.lblTileTimesWatered, c);

        c.gridx = 1;
        tileInfoPanel.add(this.lblTileTimesFertilized, c);

        c.gridx = 0;
        c.gridy = 4;
        c.gridwidth = 2;
        this.btnHarvest = new JButton("Harvest");
        this.btnHarvest.setActionCommand("Harvest");
        this.btnHarvest.setVisible(false);
        tileInfoPanel.add(this.btnHarvest, c);

        infoPanel.add(tileInfoPanel, BorderLayout.CENTER);

        //East-South - seed info
        JPanel seedPanel = new JPanel();
        seedPanel.setLayout(new GridLayout(3,3));
        seedPanel.setBackground(Color.decode("#964B00"));
        seedPanel.setPreferredSize(new Dimension(300, 300));
        seedPanel.setBorder(new EmptyBorder(50,60,50,60));

        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(i*3+j >= MyFarmModel.CROPLIST.size()) {
                    break;
                }
                JButton btn = new JButton(MyFarmModel.CROPLIST.get(i*3+j).getName());

                btn.setActionCommand("SEED:" + Integer.toString(i*3+j));
                this.btnlistSeeds.add(btn);
                seedPanel.add(btn);
            }
        }

        infoPanel.add(seedPanel, BorderLayout.SOUTH);
        this.mainFrame.add(infoPanel, BorderLayout.EAST);
    }

    public void initializeEndScreen() {
        JPanel outroPanel = new JPanel();

        outroPanel.setLayout(new GridBagLayout());

        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.CENTER;
        c.insets = new Insets(5,5,5,5);
        c.gridx = 0;
        c.gridy = 0;
        
        outroPanel.add(new JLabel("Unfortunately, you no longer have the means to continue"), c);

        c.gridy = 1;
        outroPanel.add(new JLabel("Thank you for playing our game!"), c);

        this.mainFrame.add(outroPanel, BorderLayout.CENTER);
    }

    /*
     * LOAD SCREEN FUNCTIONS
     */

    public void loadGameScreen(String name, double objectcoins, int level, double exp, Tile[][] lot) {
        this.mainFrame.getContentPane().removeAll();
        this.mainFrame.repaint();

        this.initializeGameScreen(name);
        this.updateFarmerInfo(objectcoins, level, exp);
        this.updateFarmerRank("Farmer");
        this.updateDay(1);
        this.updatePlot(lot);

        this.mainFrame.revalidate();
    }

    public void loadEndScreen() {
        this.mainFrame.getContentPane().removeAll();
        this.mainFrame.repaint();

        this.initializeEndScreen();

        this.mainFrame.revalidate();
    }

    /*
     * UPDATE INFO FUNCTIONS
     */
    public void updateFarmerInfo(double objectcoins, int level, double exp) {
        this.mainFrame.repaint();
        this.lblCoins.setText("Objectcoins: " + (new DecimalFormat("0.00")).format(objectcoins));
        this.lblLevel.setText("Level: " + Integer.toString(level));
        this.lblExp.setText("Exp: "+ (new DecimalFormat("0.00")).format(exp) + " / 100");
    }

    public void updateFarmerRank(String type) {
        this.mainFrame.repaint();
        this.lblRank.setText("Rank: " + type);
    }

    public void updateDay(int day) {
        this.mainFrame.repaint();
        this.lblDay.setText("Day " + Integer.toString(day));
    }

    public void updateTile(int n, Tile tile) {
        this.btnlistPlot.get(n).setText(tile.toString());
    }

    public void updatePlot(Tile[][] lot) {
        for(int i = 0; i < 50; i++) {
            this.updateTile(i, lot[i/10][i%10]);
        }
    }

    public void updateTileInfoDefault(int tileNumber, Tile tile) {
        this.lblTileNumber.setText("Tile (" + Integer.toString(tileNumber/10+1) + "," + Integer.toString(tileNumber%10+1) + ")");
        this.lblTileDisplay.setText(tile.toString());

        this.lblTileCropName.setText("");
        this.lblTileDaysPast.setText("");
        this.lblTileTimesWatered.setText("");
        this.lblTileTimesFertilized.setText("");
        this.btnHarvest.setVisible(false);
    }

    public void updateTileInfoPlanted(int tileNumber, Tile tile) {
        this.updateTileInfoDefault(tileNumber, tile);
        this.lblTileCropName.setText("Crop: " + tile.getCropPlanted().getName());
        this.lblTileDaysPast.setText("Days Past: " + Integer.toString(tile.getDaysPast()));
        this.lblTileTimesWatered.setText("Times Watered: " + Integer.toString(tile.getTimesWatered()));
        this.lblTileTimesFertilized.setText("Times Fertilized: " + Integer.toString(tile.getTimesFertilized()));
    }

    public void updateTileInfoHarvestable(int tileNumber, Tile tile) {
        this.updateTileInfoPlanted(tileNumber, tile);
        this.btnHarvest.setVisible(true);
    }

    /*
     * ACTIONLISTENER/UPDATE STUFF
     */

    public void setActionListener(ActionListener listener) {
        this.btnRun.addActionListener(listener);
        this.btnRankUp.addActionListener(listener);
        this.btnAdvanceDay.addActionListener(listener);
        this.btnHarvest.addActionListener(listener);

        for(JButton btn : this.btnlistPlot) {
            btn.addActionListener(listener);
        }

        for(JButton btn : this.btnlistTools) {
            btn.addActionListener(listener);
        }

        for(JButton btn : this.btnlistSeeds) {
            btn.addActionListener(listener);
        }
    }

    /*
     * GETTERS
     */

    public String getTfName() {
        return this.tfName.getText();
    }

    /*
     * SETTERS
     */

    public void setTileSelected(int n) {
        this.btnlistPlot.get(n).setBackground(Color.GRAY);
        System.out.println("Tile " + n + " selected");
    }

    public void setTileUnselected(int n) {
        this.btnlistPlot.get(n).setBackground(Color.LIGHT_GRAY);
        System.out.println("Tile " + n + " unselected");
    }

    public void setBtnRankUpText(String text) {
        this.btnRankUp.setText(text);
    }

    public void setBtnRankUpActionCommand(String text) {
        this.btnRankUp.setActionCommand(text);
    }

    public void setBtnRankUpEnabled(boolean enabled) {
        this.btnRankUp.setEnabled(enabled);
    }

    public void sendConsoleMessage(String message) {
        this.lblConsole.setText(message);
    }
}

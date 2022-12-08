import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;

import java.util.ArrayList;

public class MyFarmView extends JFrame {

    private JFrame mainFrame;
    private JButton btnRun;
    private JTextField tfName;

    //farmer info
    private JLabel lblCoins = new JLabel();
    private JLabel lblExp = new JLabel();
    private JLabel lblLevel = new JLabel();
    private JLabel lblRank = new JLabel();
    private JLabel lblDay = new JLabel();

    //tools
    private ArrayList<JButton> btnlistTools = new ArrayList<JButton>();

    //plot
    private ArrayList<JButton> btnlistPlot = new ArrayList<JButton>();

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
        //this.mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.mainFrame.setSize(1920, 1080);
        this.mainFrame.setResizable(false);
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
        topPanel.setBackground(Color.GREEN);
        topPanel.setBorder(new EmptyBorder(5,5,5,5));
        topPanel.setPreferredSize(new Dimension(0, 180));

        //North-West - farmer info
        JPanel farmerInfoPanel = new JPanel();
        farmerInfoPanel.setLayout(new FlowLayout());

        farmerInfoPanel.add(new JLabel("Farmer " + name));
        farmerInfoPanel.add(this.lblCoins);
        farmerInfoPanel.add(this.lblLevel);
        farmerInfoPanel.add(this.lblExp);

        //North-East - actions
        JPanel actionsPanel = new JPanel();
        actionsPanel.setLayout(new FlowLayout());

        actionsPanel.add(this.lblRank);
        actionsPanel.add(new JButton("Rank Up!"));
        actionsPanel.add(this.lblDay);
        actionsPanel.add(new JButton(">>"));

        topPanel.add(farmerInfoPanel, BorderLayout.WEST);
        topPanel.add(actionsPanel, BorderLayout.EAST);
        this.mainFrame.add(topPanel, BorderLayout.NORTH);

        //West - tool stuff
        JPanel toolPanel = new JPanel();
        toolPanel.setLayout(new GridLayout(6,1));
        toolPanel.setBackground(Color.BLUE);

        JLabel lblTool = new JLabel("Tools");
        lblTool.setFont(new Font("Verdana", Font.BOLD, 35));
        toolPanel.add(lblTool);

        for(int i = 0; i < MyFarmModel.TOOLLIST.size(); i++) {
            JButton btn = new JButton(MyFarmModel.TOOLLIST.get(i).getName());
            
            btn.setActionCommand(MyFarmModel.TOOLLIST.get(i).getName());
            this.btnlistTools.add(btn);
            toolPanel.add(this.btnlistTools.get(i));
        }

        this.mainFrame.add(toolPanel, BorderLayout.WEST);

        //Center - lot
        JPanel lotPanel = new JPanel();
        lotPanel.setLayout(new GridLayout(5,10));
        lotPanel.setBackground(Color.RED);

        for(int i = 0; i < 50; i++) {
            this.btnlistPlot.add(new JButton(Integer.toString(i)));
            this.btnlistPlot.get(i).setActionCommand(Integer.toString(i));
            lotPanel.add(btnlistPlot.get(i));
        }

        this.mainFrame.add(lotPanel, BorderLayout.CENTER);

        //East - info
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BorderLayout());
        infoPanel.setBorder(new EmptyBorder(5,5,5,5));
        infoPanel.setBackground(Color.YELLOW);
        infoPanel.setPreferredSize(new Dimension(348, 0));

        JLabel lbInfo = new JLabel("Info");
        lbInfo.setFont(new Font("Verdana", Font.BOLD, 35));
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

        infoPanel.add(tileInfoPanel, BorderLayout.CENTER);

        //East-South - seed info
        JPanel seedPanel = new JPanel();
        seedPanel.setLayout(new GridLayout(3,3));
        seedPanel.setBackground(Color.decode("#964B00"));
        seedPanel.setPreferredSize(new Dimension(300, 300));
        seedPanel.setBorder(new EmptyBorder(50,50,50,50));

        for(int i = 0; i < 9; i++) {
            seedPanel.add(new JButton(Integer.toString(i)));
        }


        infoPanel.add(seedPanel, BorderLayout.SOUTH);
        this.mainFrame.add(infoPanel, BorderLayout.EAST);
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

    /*
     * UPDATE INFO FUNCTIONS
     */
    public void updateFarmerInfo(double objectcoins, int level, double exp) {
        this.lblCoins.setText("Objectcoins: " + Double.toString(objectcoins));
        this.lblLevel.setText("Level: " + Integer.toString(level));
        this.lblExp.setText("Exp: "+ Double.toString(exp) + " / 100");
    }

    public void updateFarmerRank(String type) {
        this.lblRank.setText("Rank: " + type);
    }

    public void updateDay(int day) {
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

    public void updateTileInfo(int tileNumber, Tile tile) {
        this.lblTileNumber.setText("Tile (" + Integer.toString(tileNumber/10) + "," + Integer.toString(tileNumber%10) + ")");
        this.lblTileDisplay.setText(tile.toString());

        if(tile.getStatus() == Tile.ISPLANTED || tile.getStatus() == Tile.ISHARVESTABLE) {
            this.lblTileCropName.setText("Crop: " + tile.getCropPlanted().getName());
            this.lblTileDaysPast.setText("Days Past: " + Integer.toString(tile.getDaysPast()));
            this.lblTileTimesWatered.setText("Times Watered: " + Integer.toString(tile.getTimesWatered()));
            this.lblTileTimesFertilized.setText("Times Fertilized: " + Integer.toString(tile.getTimesFertilized()));
        } else {
            this.lblTileCropName.setText("");
            this.lblTileDaysPast.setText("");
            this.lblTileTimesWatered.setText("");
            this.lblTileTimesFertilized.setText("");
        }
    }

    /*
     * ACTIONLISTENER/UPDATE STUFF
     */

    public void setActionListener(ActionListener listener) {
        btnRun.addActionListener(listener);

        for(JButton btn : this.btnlistPlot) {
            btn.addActionListener(listener);
        }

        for(JButton btn : this.btnlistTools) {
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
}

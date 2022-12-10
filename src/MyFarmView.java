import javax.swing.*;
import javax.swing.ImageIcon;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.*;

import java.util.ArrayList;
import java.text.DecimalFormat;

/**
 * Represents the view/gui of the application
 */
public class MyFarmView extends JFrame {

    private JFrame mainFrame;
    private JButton btnRun;
    private JTextField tfName;

    private JButton btnExitGame = new JButton();
    private JButton btnRestartGame = new JButton();

    //misc
    private JLabel lblConsole;
    private JButton btnRankUp = new JButton();
    private JButton btnAdvanceDay = new JButton();
    private JButton btnInfo = new JButton();

    //farmer info
    private JLabel lblName = new JLabel();
    private JLabel lblCoins = new JLabel();
    private JLabel lblExp = new JLabel();
    private JLabel lblLevel = new JLabel();
    private JLabel lblRank = new JLabel();
    private JLabel lblDay = new JLabel();
    private JButton btnHarvest = new JButton();

    //farmer rank info
    private JLabel lblBonusEarningsPerProduce = new JLabel();
    private JLabel lblseedCostReduction = new JLabel();
    private JLabel lblWaterBonusLimitIncrease = new JLabel();
    private JLabel lblFertilizerBonusLimitIncrease = new JLabel();

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

    /**
     * Constructor for MyFarmView
     * Initializes and sets up the mainFrame
     */
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


    /**
     * Initializes the intro screen
     */
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

    /**
     * Initializes the game screen
     * @param name the name of the farmer
     */
    private void initializeGameScreen(String name) {

        //North - farmer info
        ImageIcon TopTexture = new ImageIcon(getClass().getResource("resources/TopTexture.png"));

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        topPanel.setBackground((Color.decode("#c16b1b")));
        topPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createMatteBorder(10, 10, 10, 10, Color.decode("#813b00")),
                (BorderFactory.createCompoundBorder(
                        BorderFactory.createMatteBorder(20, 20, 20, 20, TopTexture),
                        BorderFactory.createMatteBorder(10, 10, 10, 10, Color.decode("#813b00"))))));
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
        actionsPanel.setLayout(new GridLayout(3,3));
        actionsPanel.setBackground(new Color(0,0,0,0));

        actionsPanel.add(this.lblRank);

        this.btnRankUp = new JButton("Rank Up! (Level 5, 200 Coins)");
        this.btnRankUp.setActionCommand("RANKUP:1");
        actionsPanel.add(this.btnRankUp);

        this.btnAdvanceDay = new JButton("Advance Day");
        this.btnAdvanceDay.setActionCommand("Advance Day");
        actionsPanel.add(this.btnAdvanceDay);

        actionsPanel.add(this.lblBonusEarningsPerProduce);
        actionsPanel.add(this.lblWaterBonusLimitIncrease);

        actionsPanel.add(this.lblDay);

        actionsPanel.add(this.lblseedCostReduction);
        actionsPanel.add(this.lblFertilizerBonusLimitIncrease);

        topPanel.add(farmerInfoPanel, BorderLayout.WEST);
        topPanel.add(actionsPanel, BorderLayout.EAST);
        this.mainFrame.add(topPanel, BorderLayout.NORTH);

        //West - tool stuff
        JPanel toolPanel = new JPanel();
        toolPanel.setLayout(new GridLayout(MyFarmModel.TOOLLIST.size()+1 ,1));
        toolPanel.setPreferredSize(new Dimension(150, 60));
        toolPanel.setBackground(Color.decode("#813b00"));
        toolPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(0, 10, 10, 10, Color.decode("#813b00")),
                BorderFactory.createMatteBorder(0, 15, 90, 15, Color.decode("#813b00"))));

        JLabel lblTool = new JLabel("Tools");
        lblTool.setFont(new Font("Verdana", Font.BOLD, 30));
        lblTool.setHorizontalAlignment(JLabel.CENTER);
        toolPanel.add(lblTool);

        for(int i = 0; i < MyFarmModel.TOOLLIST.size(); i++) {
            //JButton btn = new JButton(MyFarmModel.TOOLLIST.get(i).getName());
            JButton btn;
            try {
                btn = new JButton(new ImageIcon(getClass().getResource("resources/" + MyFarmModel.TOOLLIST.get(i).getName() + ".png")));
            } catch (Exception e) {
                btn = new JButton(MyFarmModel.TOOLLIST.get(i).getName());
            }

            btn.setBackground(Color.decode("#EEEEEE"));
            btn.setActionCommand("TOOL:" + Integer.toString(i));
            this.btnlistTools.add(btn);
            toolPanel.add(this.btnlistTools.get(i));
        }

        this.mainFrame.add(toolPanel, BorderLayout.WEST);

        //Center - lot
        JPanel farmPanel = new JPanel();
        farmPanel.setLayout(new BorderLayout());
        farmPanel.setBackground(Color.decode("#3c8419"));

        this.lblConsole = new JLabel("");
        this.lblConsole.setForeground(Color.WHITE);
        farmPanel.add(lblConsole, BorderLayout.NORTH);

        ImageIcon PlotTexture = new ImageIcon(getClass().getResource("resources/PlotTexture.png"));

        JPanel lotPanel = new JPanel();
        lotPanel.setLayout(new GridLayout(5,10));
        lotPanel.setBackground(Color.decode("#44a318"));
        lotPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(0, 0, 10, 0, Color.decode("#813b00")),
                BorderFactory.createMatteBorder(20, 20, 20, 20, PlotTexture)));

        for(int i = 0; i < 50; i++) {
            JButton btn = new JButton(Integer.toString(i));
            btn.setBackground(Color.LIGHT_GRAY);
            btn.setBorder(BorderFactory.createLineBorder(Color.gray, 1));

            btn.setActionCommand("TILE:" + Integer.toString(i));
            this.btnlistPlot.add(btn);
            lotPanel.add(btnlistPlot.get(i));
        }

        farmPanel.add(lotPanel, BorderLayout.CENTER);
        this.mainFrame.add(farmPanel, BorderLayout.CENTER);

        //East - info
        Icon InfoTexture = new ImageIcon(getClass().getResource("resources/InfoTexture.png"));
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BorderLayout());
        infoPanel.setBorder(new EmptyBorder(5,5,5,5));
        infoPanel.setBackground(Color.decode("#735c57"));
        infoPanel.setPreferredSize(new Dimension(350, 0));
        infoPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createMatteBorder(0, 10, 10, 10, Color.decode("#813b00")),
                (BorderFactory.createCompoundBorder(
                        BorderFactory.createMatteBorder(20, 20, 20, 20, InfoTexture),
                        BorderFactory.createMatteBorder(10, 10, 10, 10, Color.decode("#735c57"))))));

        JPanel infoPanelText = new JPanel();
        infoPanelText.setLayout(new FlowLayout());
        infoPanelText.setBackground(Color.decode("#735c57"));

        JLabel lbInfo = new JLabel("Info");
        lbInfo.setFont(new Font("Verdana", Font.BOLD, 35));
        lbInfo.setForeground(Color.WHITE);
        lbInfo.setHorizontalAlignment(JLabel.CENTER);
        infoPanelText.add(lbInfo);

        this.btnInfo = new JButton("?");
        infoPanelText.add(this.btnInfo);

        infoPanel.add(infoPanelText, BorderLayout.NORTH);

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

        Icon SeedTexture = new ImageIcon(getClass().getResource("resources/SeedTexture.png"));
        JPanel seedPanel = new JPanel();
        seedPanel.setLayout(new GridLayout(3,3));
        seedPanel.setBackground(Color.decode("#964B00"));
        seedPanel.setPreferredSize(new Dimension(300, 300));
        seedPanel.setBorder(BorderFactory.createMatteBorder(30, 30, 30, 30, SeedTexture));

        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(i*3+j >= MyFarmModel.CROPLIST.size()) {
                    break;
                }

                JButton btn;
                try {
                    btn = new JButton(new ImageIcon(getClass().getResource("resources/" + MyFarmModel.CROPLIST.get(i*3+j).getName() + "Icon.png")));
                } catch (Exception e) {
                    btn = new JButton(MyFarmModel.CROPLIST.get(i*3+j).getName());
                }
                btn.setBackground(Color.decode("#EEEEEE"));

                btn.setActionCommand("SEED:" + Integer.toString(i*3+j));
                this.btnlistSeeds.add(btn);
                seedPanel.add(btn);
            }
        }

        infoPanel.add(seedPanel, BorderLayout.SOUTH);
        this.mainFrame.add(infoPanel, BorderLayout.EAST);
    }

    /**
     * Initializes the end screen
     */
    public void initializeEndScreen() {
        JPanel outroPanel = new JPanel();

        outroPanel.setLayout(new GridBagLayout());

        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.CENTER;
        c.insets = new Insets(5,5,5,5);
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        outroPanel.add(new JLabel("Unfortunately, you no longer have the means to continue"), c);

        c.gridy = 1;
        outroPanel.add(new JLabel("Thank you for playing our game!"), c);

        c.gridy = 2;
        c.gridwidth = 1;
        this.btnExitGame = new JButton("Exit Game");
        outroPanel.add(btnExitGame, c);

        c.gridx = 1;
        this.btnRestartGame = new JButton("Restart Game");
        outroPanel.add(btnRestartGame, c);

        this.mainFrame.add(outroPanel, BorderLayout.CENTER);
    }

    /*
     * LOAD SCREEN FUNCTIONS
     */

    /**
     * Loads in the main menu screen
     * @param name          the name of the farmer
     * @param objectcoins   the amount of coins the farmer has
     * @param level         the level of the farmer
     * @param exp           the amount of experience the farmer has
     * @param lot           the plot of land the farmer has
     */
    public void loadGameScreen(String name, double objectcoins, int level, double exp, Tile[][] lot) {
        this.mainFrame.getContentPane().removeAll();
        this.mainFrame.repaint();

        this.initializeGameScreen(name);
        this.updateFarmerInfo(objectcoins, level, exp);
        this.updateFarmerRank(new FarmerDefault());
        this.updateDay(1);
        this.updatePlot(lot);

        this.mainFrame.revalidate();
    }

    /**
     * Loads in the end screen
     */
    public void loadEndScreen() {
        this.mainFrame.getContentPane().removeAll();
        this.mainFrame.repaint();

        this.initializeEndScreen();

        this.mainFrame.revalidate();
    }

    /*
     * UPDATE INFO FUNCTIONS
     */

    /**
     * Updates the farmer info in the GUI north panel
     * @param objectcoins   the amount of coins the farmer has
     * @param level         the level of the farmer
     * @param exp           the amount of experience the farmer has
     */
    public void updateFarmerInfo(double objectcoins, int level, double exp) {
        this.mainFrame.repaint();
        this.lblCoins.setText("Objectcoins: " + (new DecimalFormat("0.00")).format(objectcoins));
        this.lblLevel.setText("Level: " + Integer.toString(level));
        this.lblExp.setText("Exp: "+ (new DecimalFormat("0.00")).format(exp) + " / 100");
    }

    /**
     * Updates the farmer rank in the GUI north panel
     * @param type the type of farmer
     */
    public void updateFarmerRank(FarmerType type) {
        this.mainFrame.repaint();
        this.lblRank.setText("Rank: " + type);
        this.lblBonusEarningsPerProduce.setText("Bonus Earnings: +" + type.getBonusEarningsPerProduce());
        this.lblseedCostReduction.setText("Seed Cost: " + type.getSeedCostReduction());
        this.lblWaterBonusLimitIncrease.setText("Water Bonus Limit: +" + type.getWaterBonusLimitIncrease());
        this.lblFertilizerBonusLimitIncrease.setText("Fert. Bonus Limit: +" + type.getFertilizerBonusLimitIncrease());

    }

    /**
     * Updates the day in the GUI north panel
     * @param day the day
     */
    public void updateDay(int day) {
        this.mainFrame.repaint();
        this.lblDay.setText("Day " + Integer.toString(day));
    }

    /**
     * Updates the plot in the GUI center panel
     * @param lot the plot of land
     */
    public void updateTile(int n, Tile tile) {
        String strStatus = tile.toString();
        int intStatus = tile.getStatus();

        try {
            if(intStatus == Tile.ISHARVESTABLE) {
                this.btnlistPlot.get(n).setIcon(new ImageIcon(getClass().getResource("resources/" + strStatus.substring(2) + ".png")));
            } else if(intStatus == Tile.ISPLANTED) {
                this.btnlistPlot.get(n).setIcon(new ImageIcon(getClass().getResource("resources/Seed.png")));
            } else {
                this.btnlistPlot.get(n).setIcon(new ImageIcon(getClass().getResource("resources/" + strStatus + ".png")));
            }
            this.btnlistPlot.get(n).setText("");
        } catch (Exception e) {
            this.btnlistPlot.get(n).setText(strStatus);
        }
    }

    /**
     * Updates the plot in the GUI center panel
     * @param lot the plot of land
     */
    public void updatePlot(Tile[][] lot) {
        for(int i = 0; i < 50; i++) {
            this.updateTile(i, lot[i/10][i%10]);
        }
    }

    /**
     * Updates the tile info in the GUI east panel
     * @param tileNumber    the tile number
     * @param tile          the tile
     */
    public void updateTileInfoDefault(int tileNumber, Tile tile) {
        this.lblTileNumber.setText("Tile (" + Integer.toString(tileNumber/10+1) + "," + Integer.toString(tileNumber%10+1) + ")");
        this.lblTileDisplay.setText(tile.toString());

        this.lblTileCropName.setText("");
        this.lblTileDaysPast.setText("");
        this.lblTileTimesWatered.setText("");
        this.lblTileTimesFertilized.setText("");

        this.btnHarvest.setVisible(false);
    }

    /**
     * Updates the tile info in the GUI east panel for a planted tile
     * @param tileNumber    the tile number
     * @param tile          the tile
     */
    public void updateTileInfoPlanted(int tileNumber, Tile tile) {
        this.updateTileInfoDefault(tileNumber, tile);
        this.lblTileCropName.setText("Crop: " + tile.getCropPlanted().getName());
        this.lblTileDaysPast.setText("Days Past: " + Integer.toString(tile.getDaysPast()));
        this.lblTileTimesWatered.setText("Times Watered: " + Integer.toString(tile.getTimesWatered()));
        this.lblTileTimesFertilized.setText("Times Fertilized: " + Integer.toString(tile.getTimesFertilized()));
    }

    /**
     * Updates the tile info in the GUI east panel for a harvestable tile
     * @param tileNumber    the tile number
     * @param tile          the tile
     */
    public void updateTileInfoHarvestable(int tileNumber, Tile tile) {
        this.updateTileInfoPlanted(tileNumber, tile);
        this.btnHarvest.setVisible(true);
    }

    /*
     * ACTIONLISTENER/UPDATE STUFF
     */

    /**
     * Sets action listener for all relevant buttons
     * @param listener      the action listener
     */
    public void setActionListener(ActionListener listener) {
        this.btnRun.addActionListener(listener);
        this.btnExitGame.addActionListener(listener);
        this.btnRestartGame.addActionListener(listener);

        this.btnRankUp.addActionListener(listener);
        this.btnAdvanceDay.addActionListener(listener);
        this.btnHarvest.addActionListener(listener);
        this.btnInfo.addActionListener(listener);

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

    /**
     * Closes the main window
     */
    public void closeWindow() {
        this.mainFrame.dispose();
    }

    /**
     * Shows the info popup from the info button
     */
    public void showInfoPopup() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        
        panel.add(new JLabel("Game Info"), BorderLayout.NORTH);

        String[] infoColumns = {"Tool", "Cost", "EXP Gain"};
        String[][] infoData = new String[MyFarmModel.TOOLLIST.size()][3];
        for(int i = 0; i < MyFarmModel.TOOLLIST.size(); i++) {
            infoData[i][0] = MyFarmModel.TOOLLIST.get(i).getName();
            infoData[i][1] = Integer.toString(MyFarmModel.TOOLLIST.get(i).getCost());
            infoData[i][2] = Double.toString(MyFarmModel.TOOLLIST.get(i).getExpGain());
        }
        JTable toolInfo = new JTable(infoData, infoColumns);
        JScrollPane toolPane = new JScrollPane(toolInfo);
        toolPane.setPreferredSize(new Dimension(700, 140));

        panel.add(toolPane, BorderLayout.CENTER);

        String[] seedColumns = {"Seed", "Cost", "EXP Gain", "Min Produce", "Max Produce", "Sell Price", "Days to Grow", "Water Needs", "Fertilizer Needs"};
        String[][]seedData = new String[MyFarmModel.CROPLIST.size()][9];
        for(int i = 0; i < MyFarmModel.CROPLIST.size(); i++) {
            seedData[i][0] = MyFarmModel.CROPLIST.get(i).getName();
            seedData[i][1] = Integer.toString(MyFarmModel.CROPLIST.get(i).getSeedCost());
            seedData[i][2] = Double.toString(MyFarmModel.CROPLIST.get(i).getExpGain());
            seedData[i][3] = Integer.toString(MyFarmModel.CROPLIST.get(i).getMinProductsProduced());
            seedData[i][4] = Integer.toString(MyFarmModel.CROPLIST.get(i).getMaxProductsProduced());
            seedData[i][5] = Integer.toString(MyFarmModel.CROPLIST.get(i).getSellingPrice());
            seedData[i][6] = Integer.toString(MyFarmModel.CROPLIST.get(i).getHarvestTime());
            seedData[i][7] = Integer.toString(MyFarmModel.CROPLIST.get(i).getWaterNeeds());
            seedData[i][8] = Integer.toString(MyFarmModel.CROPLIST.get(i).getFertilizerNeeds());
        }
        JTable seedInfo = new JTable(seedData, seedColumns);
        JScrollPane seedPane = new JScrollPane(seedInfo);
        seedPane.setPreferredSize(new Dimension(700, 200));

        panel.add(seedPane, BorderLayout.SOUTH);

        JOptionPane.showMessageDialog(null, panel, "Game Info", JOptionPane.INFORMATION_MESSAGE);
    }

    /*
     * GETTERS
     */

    /**
     * Gets the name from the name text field
     * @return     the name
     */
    public String getTfName() {
        return this.tfName.getText();
    }

    /*
     * SETTERS
     */

    /**
     * Sets the ui to reflect the tile currently selected by the user
     * @param n    the tile number
     */
    public void setTileSelected(int n) {
        this.btnlistPlot.get(n).setBackground(Color.GRAY);
        this.btnlistPlot.get(n).setBorder(BorderFactory.createLineBorder(Color.yellow, 5));;
        System.out.println("Tile " + n + " selected");
    }

    /**
     * Sets the ui to reflect the tile currently unselected by the user
     * @param n    the tile number
     */
    public void setTileUnselected(int n) {
        this.btnlistPlot.get(n).setBackground(Color.LIGHT_GRAY);
        this.btnlistPlot.get(n).setBorder(BorderFactory.createLineBorder(Color.gray, 1));
        System.out.println("Tile " + n + " unselected");
    }

    /**
     * Sets the rank up button text to show coins and level requirement
     * @param text   the text to set the button to
     */
    public void setBtnRankUpText(String text) {
        this.btnRankUp.setText(text);
    }

    /**
     * Sets the action command for the rank up button
     * @param text   the text to set the button to
     */
    public void setBtnRankUpActionCommand(String text) {
        this.btnRankUp.setActionCommand(text);
    }

    /**
     * Sets the rank up button enabled or disabled
     * @param enabled   true if enabled, false if disabled
     */
    public void setBtnRankUpEnabled(boolean enabled) {
        this.btnRankUp.setEnabled(enabled);
    }

    /**
     * Sets the console message
     * @param text   the text to set the console message label to
     */
    public void sendConsoleMessage(String message) {
        this.lblConsole.setText("   >   [  " + message + "  ]");
    }

    /**
     * Enable or disable the seed buttons
     * @param enabled   true if enabled, false if disabled
     */
    public void setBtnSeedListEnabled(boolean enabled) {
        for(JButton btn : this.btnlistSeeds) {
            btn.setEnabled(enabled);
        }
    }
}
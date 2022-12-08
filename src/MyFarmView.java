import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;

public class MyFarmView extends JFrame {

    private JFrame mainFrame;
    private JButton btnRun;
    private JTextField tfName;

    //tools
    private JLabel lblTool;
    private JButton btnPlow;
    private JButton btnWateringCan;
    private JButton btnFertilizer;
    private JButton btnPickaxe;
    private JButton btnShovel;
    private JLabel lbPlant;

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


    private void initializeGameScreen(String name, double objectcoins) {

        //North - farmer info
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        topPanel.setBackground(Color.GREEN);
        topPanel.setBorder(new EmptyBorder(5,5,5,5));
        topPanel.setPreferredSize(new Dimension(0, 180));

        JPanel farmerInfoPanel = new JPanel();
        farmerInfoPanel.setLayout(new FlowLayout());
        farmerInfoPanel.setBackground(Color.GREEN);

        farmerInfoPanel.add(new JLabel("Farmer " + name));
        farmerInfoPanel.add(new JLabel("Objectcoins: " + Double.toString(objectcoins)));
        farmerInfoPanel.add(new JLabel("EXP: TODO"));

        JPanel actionsPanel = new JPanel();
        actionsPanel.setLayout(new FlowLayout());
        actionsPanel.setBackground(Color.GREEN);

        actionsPanel.add(new JLabel("Rank: TODO"));
        actionsPanel.add(new JButton("Rank Up!"));
        actionsPanel.add(new JLabel("Day TODO"));
        actionsPanel.add(new JButton(">>"));

        topPanel.add(farmerInfoPanel, BorderLayout.WEST);
        topPanel.add(actionsPanel, BorderLayout.EAST);
        this.mainFrame.add(topPanel, BorderLayout.NORTH);

        //West - tool stuff
        JPanel toolPanel = new JPanel();
        toolPanel.setLayout(new GridLayout(6,1));
        toolPanel.setBackground(Color.BLUE);

        lblTool = new JLabel("Tools");
        lblTool.setFont(new Font("Verdana", Font.BOLD, 35));
        toolPanel.add(lblTool);

        btnPlow = new JButton("Plow");
        toolPanel.add(btnPlow);

        btnWateringCan = new JButton("Watering Can");
        toolPanel.add(btnWateringCan);

        btnFertilizer = new JButton("Fertilizer");
        toolPanel.add(btnFertilizer);

        btnPickaxe = new JButton("Pickaxe");
        toolPanel.add(btnPickaxe);

        btnShovel = new JButton("Shovel");
        toolPanel.add(btnShovel);

        /*
        toolPanel.add(new JLabel("Tools"));
        toolPanel.add(new JButton("Plow"));
        toolPanel.add(new JButton("Watering Can"));
        toolPanel.add(new JButton("Fertilizer"));
        toolPanel.add(new JButton("Pickaxe"));
        toolPanel.add(new JButton("Shovel"));
        */

        this.mainFrame.add(toolPanel, BorderLayout.WEST);

        //Center - lot
        JPanel lotPanel = new JPanel();
        lotPanel.setLayout(new GridLayout(5,10));
        lotPanel.setBackground(Color.RED);

        for(int i = 0; i < 50; i++) {
            lotPanel.add(new JButton(Integer.toString(i)));
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

        //TODO: add info
        lbPlant = new JLabel("[Plot]");
        infoPanel.add(lbPlant, BorderLayout.CENTER);

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

    public void loadGameScreen(String name, double objectcoins) {
        this.mainFrame.getContentPane().removeAll();
        this.mainFrame.repaint();

        this.initializeGameScreen(name, objectcoins);
        this.mainFrame.revalidate();
    }

    /*
     * ACTIONLISTENER/UPDATE STUFF
     */

    public void setActionListener(ActionListener listener) {
        btnRun.addActionListener(listener);
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

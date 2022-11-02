import java.util.Scanner;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class MyFarm {

    // Declare global variables
    public static final List<Tool> toolList = new ArrayList<Tool>(Arrays.asList(
        new Tool("Plow",
                "Converts an unplowed tile to a plowed tile. Can only be performed on an unplowed tile.",
                0, 0.5),
        new Tool("Watering Can",
                "Adds to the total number of tiles a tile/crop has been watered. Can only be performed on a plowed tile with a crop.",
                0, 0.5),
        new Tool("Fertilizer",
                "Adds to the total number of tiles a tile/crop has been applied with fertilizer. Can only be performed on a plowed tile with a crop.",
                10, 4),
        new Tool("Pickaxe",
                "Removes a rock from a tile. Can only be applied to tiles with a rock.",
                50, 15),
        new Tool("Shovel",
                "Removes a withered plant from a tile. Can be used on any tile/crop with varying effects, as described above.",
                7, 2)
    ));

    public static final List<FarmerType> farmerTypeList = new ArrayList<FarmerType>(Arrays.asList(
        new FarmerType("Farmer", 0, 0, 0, 0, 0, 0),
        new FarmerType("Registered Farmer",5, 1, -1, 0, 0, 200),
        new FarmerType("Distinguished Farmer", 10, 2, -2, 1, 0, 300),
        new FarmerType("Legendary Farmer", 15, 4, -3, 2, 1, 400)
    ));

    public static final List<Crop> cropList = new ArrayList<Crop>(Arrays.asList(
        new Crop("Turnip", "rootcrop", 2, 
        1, 0, 
        1, 2, 5, 6, 5)
    ));

    // Declare variables
    private Farmer farmer = null;
    private Tile[][] lot = null;
    private int day = 1;
    private boolean isRunning = false;

    public MyFarm() {
        // Default constructor
    }

    private void showChoices() {
        System.out.println("What would you like to do?");
        System.out.println("1. View farmer");
        System.out.println("2. View lot");
        System.out.println("3. Use Tools");
        System.out.println("4. Plant Seed");
        System.out.println("5. Harvest Crop");
        System.out.println("6. Register Farmer");
        System.out.println("7. Advance Day");
        System.out.println("8. Exit game");
        System.out.println("Please enter your choice: ");
    }

    public void advanceDay() {
        this.day++;
        for(Tile lotRow[] : this.lot) {
            for(Tile tile : lotRow) {
                tile.advanceDay();
            }
        }
    }

    public void run() {
        this.isRunning = true;
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to MyFarm!");
        System.out.println("Please enter your name: ");
        String name = sc.nextLine();
        System.out.println();

        // Create farmer
        this.farmer = new Farmer(name);
        // Create lot - TODO: 1 tile for MCO1
        this.lot = new Tile[1][1];
        for(int i = 0; i < 1; i++) {
            for(int j = 0; j < 1; j++) {
                this.lot[i][j] = new Tile();
            }
        }

        System.out.println("<< Day " + this.day + " >>");
        while(true) {
            //Variable setup
            Tile tile;
            Tool tool;
            Crop crop;
            FarmerType farmerType;

            /*
            TODO: GUI implementation for MCO2
            */
            this.showChoices();
            switch(sc.nextInt()) {
                //CHOICE: VIEW FARMER
                case 1:
                    System.out.println("\n[SELECTED CHOICE] View farmer");    
                    System.out.println(farmer);

                    break;

                //CHOICE: VIEW LOT
                case 2:
                    System.out.println("\n[SELECTED CHOICE] View lot");

                    //Display Tiles - TODO: 1 tile for MCO1
                    System.out.print("\nTile 1: ");
                    System.out.println(lot[0][0]);

                    break;

                //CHOICE: USE TOOLS
                case 3:
                    System.out.println("\n[SELECTED CHOICE] Use Tools");
                    System.out.println("Please select a tool: ");
                    for (int i = 0; i < toolList.size(); i++) {
                        System.out.println((i + 1) + ". " + toolList.get(i).getName());
                    }
                    System.out.println("Please enter your choice: ");
                    int toolChoice = sc.nextInt();
                    tool = toolList.get(toolChoice - 1);

                    //TODO: 1 tile for MCO1
                    System.out.println("Please select a tile: ");
                    System.out.println("For MCO1, defaulted to (0,0)");

                    tile = lot[0][0];

                    if(farmer.useTool(tool, tile)) {
                        System.out.println("\nYou have successfully used " + tool + " on tile (0,0)");
                        System.out.println(tile);
                        System.out.println("New balance: " + farmer.getObjectcoins());
                    } else {
                        System.out.println("\nInvalid use of " + tool);
                    }
                    break;

                //CHOICE: PLANT SEED
                case 4:
                    System.out.println("\n[SELECTED CHOICE] Plant Seed");
                
                    //TODO: Selecting crop - use Farmer plant function
                    //TODO: 1 tile for MCO1
                    System.out.println("Crop defaulted to TURNIP, Tile defaulted to (0,0)");
                    crop = cropList.get(0);
                    tile = lot[0][0];

                    if(tile.plant(crop)) {
                        System.out.println("You have successfully planted a turnip in tile (0,0)");
                        System.out.println(tile);
                    } else {
                        System.out.println("Invalid use of Plant Seed");   
                    }

                    break;

                //CHOICE: HARVEST CROP
                case 5:
                    //TODO: Use Farmer harvest function
                    //TODO: 1 tile for MCO1
                    System.out.println("\n[SELECTED CHOICE] Harvest Crop");
                    System.out.println("Tile defaulted to (0,0)");
                    tile = lot[0][0];

                    Crop harvest = farmer.harvestTile(tile);
                    if(harvest != null) {
                        System.out.println("You have successfully harvested the tile");
                        System.out.println(tile);
                        System.out.println("You gained X gold and X exp");
                    } else {
                        System.out.println("Invalid use of Harvest Crop");   
                    }

                    break;

                //CHOICE: REGISTER FARMER
                case 6:
                    System.out.println("\n[SELECTED CHOICE] Register Farmer");

                    //Display farmer types
                    System.out.println("Please select a farmer type: ");
                    for (int i = 0; i < farmerTypeList.size(); i++) {
                        FarmerType selectedFT = farmerTypeList.get(i);
                        if(farmer.getType().getName().equals(selectedFT.getName())) {
                            System.out.println((i + 1) + ". " + selectedFT.getName() + " (Current)");
                        }
                        else {
                            System.out.println((i + 1) + ". " + selectedFT.getName() + " (" + farmerTypeList.get(i).getRegistrationFee() + " coins)");
                        }
                    }
                    System.out.println("Please enter your choice: ");
                    int farmerTypeChoice = sc.nextInt();
                    farmerType = farmerTypeList.get(farmerTypeChoice - 1);

                    //Register
                    if(farmer.register(farmerType)) {
                        System.out.println("\nYou have successfully registered as a " + farmerType);
                        System.out.println(farmer);
                    } else {
                        System.out.println("\nUnable to register for farmer type " + farmerType);
                    }

                    break;

                //CHOICE: ADVANCE DAY
                case 7:
                    System.out.println("\n[SELECTED CHOICE] Advance day");
                    this.advanceDay();
                    System.out.println("\n--------------------------------------\n\n");
                    System.out.println("<< Day " + this.day + " >>");

                    //Display Tiles - TODO: 1 tile for MCO1, GUI for MCO2
                    System.out.print("\nTile 1: ");
                    System.out.println(lot[0][0]);

                    break;

                //CHOICE: EXIT GAME
                case 8:
                    System.out.println("\n[SELECTED CHOICE] Exit game");
                    this.isRunning = false;

                    break;

                default:
                    System.out.println("\nInvalid choice, please try again");
            }
            farmer.levelUp();
            System.out.println();

            if(!this.isRunning) {
                break;
            }
        }

        System.out.println("Game ended!");

        sc.close();
    }
}
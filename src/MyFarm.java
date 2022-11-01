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
            new FarmerType("Farmer", 0, 0, 0, 0),
            new FarmerType("Registered Farmer", 1, -1, 0, 0),
            new FarmerType("Distinguished Farmer", 2, -2, 1, 0),
            new FarmerType("Legendary Farmer", 4, -3, 2, 1)
    ));

    public static final List<Crop> cropList = new ArrayList<Crop>(Arrays.asList(
        new Crop("Turnip", "rootcrop", 2, 
        1, 0, 
        1, 2, 5, 6, 5)
    ));

    // Declare variables
    private Farmer farmer = null;
    private Lot lot = null;
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
        System.out.println("5. Advance day");
        System.out.println("6. Exit game");
        System.out.println("Please enter your choice: ");
    }

    public void run() {
        this.isRunning = true;
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to MyFarm!");
        System.out.println("Please enter your name: ");
        String name = sc.nextLine();
        System.out.println();

        this.farmer = new Farmer(name);
        this.lot = new Lot();

        while(true) {
            System.out.println("<< Day " + this.day + " >>");

            this.showChoices();
            switch(sc.nextInt()) {
                case 1:
                    System.out.println("\n[SELECTED CHOICE] View farmer");    
                    System.out.println(farmer);
                    break;

                case 2:
                    System.out.println("\n[SELECTED CHOICE] View lot");
                    this.lot.displayTiles();
                    break;

                case 3:
                    System.out.println("\n[SELECTED CHOICE] Use Tools");
                    System.out.println("Please select a tool: ");
                    for (int i = 0; i < toolList.size(); i++) {
                        System.out.println((i + 1) + ". " + toolList.get(i).getName());
                    }
                    System.out.println("Please enter your choice: ");
                    int toolChoice = sc.nextInt();
                    System.out.println("Please select a tile: ");
                    System.out.println("For MCO1, defaulted to (0,0)");

                    Tool tool = toolList.get(toolChoice - 1);
                    Tile tile = this.lot.getTile(0, 0);

                    if(farmer.useTool(tool, tile)) {
                        System.out.println("\nYou have successfully used " + tool.getName() + " on tile (0,0)");
                        System.out.println(tile);
                        System.out.println("New balance: " + farmer.getObjectcoins());
                    } else {
                        System.out.println("\nImproper use of " + tool.getName());
                    }
                    break;

                case 4:
                    System.out.println("\n[SELECTED CHOICE] Plant Seed");
                    //temporary plant turnip in tile00 for MCO1
                    this.lot.getTile(0,0).plant(cropList.get(0));
                    break;

                case 5:
                    System.out.println("\n[SELECTED CHOICE] Advance day");
                    this.day++;
                    lot.advanceDay();
                    this.lot.displayTiles();
                    break;

                case 6:
                    System.out.println("\n[SELECTED CHOICE] Exit game");
                    this.isRunning = false;
                    break;

                default:
                    System.out.println("\nInvalid choice, please try again");
            }
            System.out.println();

            if(this.isRunning == false) {
                break;
            }
        }

        sc.close();
    }
}
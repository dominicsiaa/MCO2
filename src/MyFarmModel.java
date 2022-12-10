import java.util.Scanner;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

import java.io.File; 
import java.io.FileNotFoundException;  

/**
 * Represents the farm in the game.
 */
public class MyFarmModel {

    // Declare global variables
    /**
     * The list of tools in the game.
     */
    public static final List<Tool> TOOLLIST = new ArrayList<Tool>(Arrays.asList(
        new Plow(),
        new WateringCan(),
        new Fertilizer(),
        new Pickaxe(),
        new Shovel()
    ));

    /**
     * The list of farmer types in the game.
     */
    public static final List<FarmerType> FARMERTYPELIST = new ArrayList<FarmerType>(Arrays.asList(
        new FarmerDefault(),
        new RegisteredFarmer(),
        new DistinguishedFarmer(),
        new LegendaryFarmer()
    ));

    /**
     * The list of crops in the game.
     */
    public static final List<Crop> CROPLIST = new ArrayList<Crop>(Arrays.asList(
        new Turnip(),
        new Carrot(),
        new Potato(),
        new Rose(),
        new Tulip(),
        new Sunflower(),
        new Mango(),
        new Apple()
    ));

    // Declare variables
    private Farmer farmer = null;
    private Tile[][] lot = null;
    private int day = 1;
    private boolean isRunning = false;

    /**
     * Constructor for MyFarm.
     */
    public MyFarmModel() {
        // Default constructor
    }

    /*
     * 
     * ----------------RUN FUNCTION---------------------
     * 
     */

    /**
     * This method runs the game.
     * @param name  The name of the farmer
     */
    public void run(String name) {
        this.isRunning = true;

        //Create farmer
        this.farmer = new Farmer(name);

        //Create lot
        int ROWS = 5;
        int COLS = 10;
        this.lot = new Tile[ROWS][COLS];

        //Create rock from file input
        boolean[][] rockInput = new boolean[ROWS][COLS];

        //Rock creating from file input
        try {

            //Read rock input from file
            File rocks = new File("rockinput/RockInput.txt");
            Scanner rockReader = new Scanner(rocks);
            while (rockReader.hasNextLine()) {
                for (int i = 0; i < ROWS; i++) {
                    String[] line = rockReader.nextLine().trim().split(" ");
                    for (int j = 0; j < COLS; j++) {
                        if(Integer.parseInt(line[j]) == 1) {
                            rockInput[i][j] = true;
                        }
                        else {
                            rockInput[i][j] = false;
                        }
                    }
                }
            }
            rockReader.close();

        } catch (FileNotFoundException e) {

            //Default rock input, no rocks
            for(int i = 0; i < ROWS; i++) {
                for(int j = 0; j < COLS; j++) {
                    rockInput[i][j] = false;
                }
            }
        }
        
        //Setting rocks
        for(int i = 0; i < ROWS; i++) {
            for(int j = 0; j < COLS; j++) {
                this.lot[i][j] = new Tile(rockInput[i][j]);
            }
        }
    }

    /**
     * This method advances the day and checks if the game is over.
     * @return true if a crop has withered, false otherwise
     */
    public boolean advanceDay() {
        this.day++;
        boolean withered = false;

        //Advances day for each tile
        boolean lotHasCrops = false;
        for(Tile lotRow[] : this.lot) {
            for(Tile tile : lotRow) {
                if(!withered) {
                    withered = tile.advanceDay();
                } else {
                    tile.advanceDay();
                }

                //Checks if at least one tile has crop
                if(tile.getStatus() == Tile.ISPLANTED || tile.getStatus() == Tile.ISHARVESTABLE) {
                    lotHasCrops = true;
                }
            }
        }

        //Determine cheapest seed available
        int cheapestCropPrice = CROPLIST.get(0).getSeedCost();
        for(Crop crop : CROPLIST) {
            cheapestCropPrice = Math.min(cheapestCropPrice, crop.getSeedCost());
        }

        //check if rock/withered crops fill the field
        int nRocks = 0;
        int nWithered = 0;
        for(Tile[] tileRow : lot) {
            for(Tile tile : tileRow) {
                if(tile.getStatus() == Tile.HASROCK) {
                    nRocks++;
                } else if(tile.getStatus() == Tile.HASWITHERED) {
                    nWithered++;
                }
            }
        }

        boolean lotCheck = true;
        if(nRocks + nWithered == 50) {
            if(nRocks == 50 && this.farmer.getObjectcoins() < 50) {
                lotCheck = false;
            } else if(this.farmer.getObjectcoins() < 7) {
                lotCheck = false;
            }
        }

        //Checks if game is over
        if(!lotCheck || (!lotHasCrops && (this.farmer.getObjectcoins() < cheapestCropPrice + this.farmer.getType().getSeedCostReduction()))) {
            this.isRunning = false;
        } else {
            this.isRunning = true;
        }

        return withered;
    }

    /*
     * GETTERS AND SETTERS
     */

    /**
     * This method returns the farmer.
     * @return      The farmer
     */
    public Farmer getFarmer() {
        return this.farmer;
    }

    /**
     * This method returns the indicated tile.
     * @param n     The number of the tile
     * @return      The tile
     */
    public Tile getTile(int n) {
        return this.lot[n/10][n%10];
    }

    /**
     * This method returns the indicated tile.
     * @param r     The row of the tile
     * @param c     The column of the tile
     * @return      The tile
     */
    public Tile getTile(int r, int c) {
        return this.lot[r][c];
    }

    /**
     * This method returns the lot.
     * @return      The lot
     */
    public Tile[][] getLot() {
        return this.lot;
    }

    /**
     * This method returns the day.
     * @return      The day
     */
    public int getDay() {
        return this.day;
    }

    /**
     * This method returns the isRunning variable which tracks if the game should be ended.
     * @return      The isRunning variable - true if the game should still continue, false otherwise
     */
    public boolean getIsRunning() {
        return this.isRunning;
    }
}
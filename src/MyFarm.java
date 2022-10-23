import java.util.Scanner;

public class MyFarm {
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
                    break;
                case 4:
                    System.out.println("\n[SELECTED CHOICE] Plant Seed");
                    //temporary plant turnip in tile00
                    this.lot.getTile(0,0).plant(new Crop("Turnip", "rootcrop", 2, 1, 0, 1, 2, 5, 6, 5));
                    break;
                case 5:
                    System.out.println("\n[SELECTED CHOICE] Advance day");
                    this.day++;
                    lot.advanceDay();
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
    }
}
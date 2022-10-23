import java.util.Scanner;

public class MyFarm {
    private Farmer farmer = null;
    private Lot lot = null;
    private int day = 1;

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
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to MyFarm!");
        System.out.println("Please enter your name: ");
        String name = sc.nextLine();

        this.farmer = new Farmer(name);
        this.lot = new Lot();

        while(true) {
            System.out.println("Day " + this.day);

            this.showChoices();
            switch(sc.nextInt()) {
                case 1:
                    System.out.println("[SELECTED CHOICE] View farmer");    
                    System.out.println(farmer);
                    break;
                case 2:
                    System.out.println("[SELECTED CHOICE] View lot");
                    this.lot.displayTiles();
                    break;
                case 3:
                    System.out.println("[SELECTED CHOICE] Use Tools");
                    break;
                case 4:
                    System.out.println("[SELECTED CHOICE] Plant Seed");
                    break;
                case 5:
                    System.out.println("[SELECTED CHOICE] Advance day");
                    this.day++;
                    lot.advanceDay();
                    break;
                case 6:
                    System.out.println("[SELECTED CHOICE] Exit game");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
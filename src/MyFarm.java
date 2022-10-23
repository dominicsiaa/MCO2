import java.util.Scanner;

public class MyFarm {
    private Farmer farmer = null;
    private Lot lot = null;
    private int day = 1;

    public MyFarm() {
        // Default constructor
    }

    private void displayTiles() {
        // Which is text-based for now until GUI
        //TODO: Implement
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
                    System.out.println(farmer);
                    break;
                case 2:
                    System.out.println("show lot");
                    break;
                case 3:
                    System.out.println("use tools");
                    break;
                case 4:
                    System.out.println("plant seed");
                    break;
                case 5:
                    this.day++;
                    lot.advanceDay();
                    break;
                case 6:
                    System.out.println("Exiting game...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
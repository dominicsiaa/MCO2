/**
 * Driver class for MyFarm
 */
public class Main {

    /**
     * This method is the driver for MyFarm
     * @param args command line arguments
     * @throws Exception if error occurs
     */
    public static void main(String[] args) throws Exception {

        // Create the MVC architecture for MyFarm
        MyFarmView farmView = new MyFarmView();
        MyFarmModel farmModel = new MyFarmModel();
        
        new MyFarmController(farmModel, farmView);
    }
}

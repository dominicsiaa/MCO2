public class Main {
    public static void main(String[] args) throws Exception {

        // Create the MVC architecture for MyFarm
        MyFarmView farmView = new MyFarmView();
        MyFarmModel farmModel = new MyFarmModel();
        
        new MyFarmController(farmModel, farmView);
    }
}

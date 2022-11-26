public class Main {
    public static void main(String[] args) throws Exception {
        // Create a new Farm
        MyFarmView farmView = new MyFarmView();
        MyFarmModel farmModel = new MyFarmModel();
        
        MyFarmController farmController = new MyFarmController(farmModel, farmView);
    }
}

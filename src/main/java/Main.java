import controllers.BankController;
import controllers.FileHandler;
import views.BankView;

public class Main {

    public static void main(String[] args) {
        BankView bankView = new BankView();
        FileHandler fileHandler = new FileHandler();
        BankController controller = new BankController(bankView, fileHandler);

        controller.init();
    }
}

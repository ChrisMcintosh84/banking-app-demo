import controllers.BankController;
import controllers.FileHandler;
import models.Transaction;
import views.BankView;

public class Main {

    public static void main(String[] args) {
        BankView bankView = new BankView();
        Transaction transaction = new Transaction();
        FileHandler fileHandler = new FileHandler();
        BankController controller = new BankController(transaction, bankView, fileHandler);

        controller.init();
    }
}

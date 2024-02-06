import controllers.BankController;
import models.Transaction;
import views.BankView;

public class Main {

    public static void main(String[] args) {
        BankView bankView = new BankView();
        Transaction transaction = new Transaction();
        BankController controller = new BankController(transaction, bankView);

        controller.init();
    }
}

package com.example.breachbank.Views;

import com.example.breachbank.Controllers.Client.TransactionLogController;
import com.example.breachbank.Models.Transaction;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;

public class TransactionLogsFactory extends ListCell<Transaction> {
    @Override
    protected void updateItem(Transaction transaction, boolean empty) {
        super.updateItem(transaction, empty);
        if (empty){
            setText(null);
        } else {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Fxml/Client/TransactionLogs.fxml"));
            TransactionLogController controller = new TransactionLogController(transaction);
            loader.setController(controller);
            setText(null);
            try {
                setGraphic(loader.load());
            } catch (Exception e){
                e.printStackTrace();
            }
        }

    }
}

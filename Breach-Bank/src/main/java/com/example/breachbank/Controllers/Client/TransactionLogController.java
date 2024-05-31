package com.example.breachbank.Controllers.Client;

import com.example.breachbank.Models.Transaction;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class TransactionLogController implements Initializable{
    public FontAwesomeIconView up_symbol;
    public FontAwesomeIconView down_symbol;
    public Label sender_label;
    public Label reciver_log;
    public Label money_transfered;

    private final Transaction transaction;

    public TransactionLogController(Transaction transaction){
        this.transaction = transaction;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}

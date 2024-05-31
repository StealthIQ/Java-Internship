package com.example.breachbank.Controllers.Client;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {
    public Text greet_username;
    public Text whose_account;
    public Text real_total_bal;
    public TextField fund_transfer_recivers_adress;
    public TextField fund_transfer_amount;
    public Button fund_transfer_send_button;
    public Text account_summary_label;
    public Text summary_fname;
    public Text summary_banking_no;
    public Text summary_mobile;
    public Text summary_tax;
    public Text summary_date;
    public ImageView user_avatar;
    public Button logout_button;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }
}

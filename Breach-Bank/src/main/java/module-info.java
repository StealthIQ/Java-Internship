module com.example.breachbank {
    requires javafx.controls;
    requires javafx.fxml;
    requires de.jensd.fx.glyphs.fontawesome;
    requires java.sql;
    requires org.xerial.sqlitejdbc; 

    opens com.example.breachbank to javafx.fxml;
    exports com.example.breachbank;
    exports com.example.breachbank.Controllers;
    exports com.example.breachbank.Controllers.Client;
    exports com.example.breachbank.Models;
    exports com.example.breachbank.Views;

}
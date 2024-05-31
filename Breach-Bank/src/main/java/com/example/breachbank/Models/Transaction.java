package com.example.breachbank.Models;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.time.LocalDate;

public class Transaction {
    private final StringProperty sender;
    private final StringProperty receiver;
    private final DoubleProperty money;
    private final ObjectProperty<LocalDate> date;

    public Transaction(String sender, String receiver, double money, LocalDate date, String message) {
        this.sender = new SimpleStringProperty(sender);
        this.receiver = new SimpleStringProperty(receiver);
        this.money = new SimpleDoubleProperty(money);
        this.date = new SimpleObjectProperty<>(date);
    }

    public String getSender() {
        return sender.get();
    }

    public void setSender(String sender) {
        this.sender.set(sender);
    }

    public StringProperty senderProperty() {
        return sender;
    }

    public String getReceiver() {
        return receiver.get();
    }

    public void setReceiver(String receiver) {
        this.receiver.set(receiver);
    }

    public StringProperty receiverProperty() {
        return receiver;
    }

    public double getmoney() {
        return money.get();
    }

    public void setmoney(double money) {
        this.money.set(money);
    }

    public DoubleProperty moneyProperty() {
        return money;
    }

    public LocalDate getDate() {
        return date.get();
    }

    public void setDate(LocalDate date) {
        this.date.set(date);
    }

    public ObjectProperty<LocalDate> dateProperty() {
        return date;
    }
}

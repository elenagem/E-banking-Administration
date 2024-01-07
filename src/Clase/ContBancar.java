package Clase;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ContBancar {
    private String iban;
    private double sold;

    // Constructor
    public ContBancar(String iban, double sold) {
        this.iban = iban;
        this.sold = sold;
    }

    // Getteri și Setteri
    public String getIban() {
        return iban;
    }
    public void setIban(String iban) {
        this.iban = iban;
    }

    public double getSold() {
        return sold;
    }
    public void setSold(double sold) {
        this.sold = sold;
    }

    @Override
    public String toString() {
        return "Cont bancar{" +
                "Iban='" + iban + '\'' +
                ", Sold='" + sold + '\'' +
                '}';
    }
}

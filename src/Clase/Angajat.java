package Clase;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Angajat {
    private String nume;
    private String prenume;
    private double salariu;
    private String numarTelefon;

    public Angajat(String nume, String prenume, double salariu, String numarTelefon) {
        this.nume = nume;
        this.prenume = prenume;
        this.salariu = salariu;
        this.numarTelefon = numarTelefon;
    }

    // Getteri și Setteri
    public String getNume() {
        return nume;
    }
    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }
    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public double getSalariu() {
        return salariu;
    }
    public void setSalariu(double salariu) {
        this.salariu = salariu;
    }

    public String getNumarTelefon() {
        return numarTelefon;
    }
    public void setNumarTelefon(String numarTelefon) {
        this.numarTelefon = numarTelefon;
    }

    // Metodă pentru afișarea informațiilor despre angajat
    @Override
    public String toString() {
        return "Angajat{" +
                "Nume='" + nume + '\'' +
                ", Prenume='" + prenume + '\'' +
                ", Salariu=" + salariu +
                ", Numar de telefon=" + numarTelefon +
                '}';
    }

    public static List<Angajat> citesteAngajatiDinFisier() {
        List<Angajat> listaAngajati = new ArrayList<>();
        String caleFisierAng = "C:\\Users\\AndreeaG\\Desktop\\ASE MASTER\\PPOO\\proiect\\ebanking\\src\\FisiereTXT\\Angajat.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(caleFisierAng))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] detaliiAngajat = line.split(",");
                if (detaliiAngajat.length == 4) {
                    String nume = detaliiAngajat[0].trim();
                    String prenume = detaliiAngajat[1].trim();
                    double salariu = Double.parseDouble(detaliiAngajat[2].trim());
                    String numarTelefon = detaliiAngajat[3].trim();

                    Angajat angajat = new Angajat(nume, prenume, salariu, numarTelefon);
                    listaAngajati.add(angajat);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return listaAngajati;
    }

    public static void citireDateAngajatNou(Scanner scanner) {
        // citire date angajat nou
        System.out.println("Adauga informatiile despre noul angajat");
        System.out.println("Nume: ");
        String nume = scanner.next();
        System.out.println("Prenume: ");
        String prenume = scanner.next();
        System.out.println("Salariu: ");
        String salariu = scanner.next();
        System.out.println("Telefon: ");
        String telefon = scanner.next();

        // adaugare detalii angajat nou in fisierul txt
        String caleFisierAng = "C:\\Users\\AndreeaG\\Desktop\\ASE MASTER\\PPOO\\proiect\\ebanking\\src\\FisiereTXT\\Angajat.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(caleFisierAng, true))) {
            String detaliiAngajatNou = '\n' + nume + ',' + prenume + ',' + salariu + ',' + telefon;
            writer.write(detaliiAngajatNou);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

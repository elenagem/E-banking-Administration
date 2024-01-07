package Clase;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import Clase.ContBancar;
public class Client {
    private String nume;
    private String prenume;
    private String numarTelefon;
    private String adresaEmail;
    private ContBancar contBancar;

    // Constructor
    public Client(String nume, String prenume, String numarTelefon, String adresaEmail, ContBancar contBancar) {
        this.nume = nume;
        this.prenume = prenume;
        this.numarTelefon = numarTelefon;
        this.adresaEmail = adresaEmail;
        this.contBancar = contBancar;
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

    public String getNumarTelefon() {
        return numarTelefon;
    }
    public void setNumarTelefon(String numarTelefon) {
        this.numarTelefon = numarTelefon;
    }

    public String getAdresaEmail() {
        return adresaEmail;
    }
    public void setAdresaEmail(String adresaEmail) {
        this.adresaEmail = adresaEmail;
    }

    public ContBancar getContBancar() {
        return contBancar;
    }
    public void setContBancar(ContBancar contBancar) {
        this.contBancar = contBancar;
    }

    // Metodă pentru afișarea informațiilor despre client

    @Override
    public String toString() {
        return "Client{" +
                "Nume='" + nume + '\'' +
                ", Prenume='" + prenume + '\'' +
                ", Numar de telefon=" + numarTelefon +
                ", Adresa de email=" + adresaEmail +
                ", Cont Bancar=" + contBancar.toString() +
                '}';
    }
    public static List<Client> citesteClientiDinFisier() {
        List<Client> listaClienti = new ArrayList<>();
        String caleFisierClient = "C:\\Users\\AndreeaG\\Desktop\\ASE MASTER\\PPOO\\proiect\\ebanking\\src\\FisiereTXT\\Client.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(caleFisierClient))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] detaliiClient = line.split(",");
                if (detaliiClient.length == 6) {
                    String nume = detaliiClient[0].trim();
                    String prenume = detaliiClient[1].trim();
                    String numarTelefon = detaliiClient[2].trim();
                    String adresaEmail = detaliiClient[3].trim();
                    String iban = detaliiClient[4].trim();
                    String sold = detaliiClient[5].trim();
                    double dSold = Double.parseDouble(sold);

                    ContBancar contBancar = new ContBancar(iban,dSold);
                    Client client = new Client(nume, prenume, numarTelefon, adresaEmail, contBancar);
                    listaClienti.add(client);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return listaClienti;
    }
}

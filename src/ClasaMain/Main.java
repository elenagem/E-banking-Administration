package ClasaMain;

import Clase.Client;

import Clase.Angajat;
import Clase.ContBancar;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;

import java.util.Scanner;

import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

        public class Main {
            public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);
                int com;

                while (true) {
                    System.out.println("Apasa 1 pentru MANAGER");
                    System.out.println("Apasa 2 pentru CLIENT");
                    System.out.println("Apasa 10 pentru EXIT");

                    com = scanner.nextInt();

                    switch (com) {
                        case 1:
                            handleManager();
                            break;
                        case 2:
                            handleClient();
                            break;
                        case 10:
                            System.out.println("V-ați deconectat cu succes. Vă mulțumim pentru utilizare!");
                            System.exit(0);
                        default:
                            System.out.println("COMANDA INCORECTA");
                    }
                }
            }

            private static void handleManager() {
                Scanner scanner = new Scanner(System.in);
                int com1;

                while (true) {
                    System.out.println("Apasa 1 pentru VIZUALIZARE ANGAJATI");
                    System.out.println("Apasa 2 pentru ADAUGARE ANGAJAT");
                    System.out.println("Apasa 3 pentru VIZUALIZARE DETALII CLIENTI");
                    System.out.println("Apasa 10 pentru LOG OUT MANAGER");

                    com1 = scanner.nextInt();

                    switch (com1) {
                        case 1:
                            List<Angajat> angajati = Angajat.citesteAngajatiDinFisier();

                            // Afișarea detaliilor despre angajați
                            for (Angajat angajat : angajati) {
                                System.out.println(angajat.toString());
                            }
                            break;
                        case 2:
                            // Implementați logica pentru ADAUGARE ANGAJAT
                            Angajat.citireDateAngajatNou(scanner);
                            break;
                        case 3:
                            List<Client> clienti = Client.citesteClientiDinFisier();

                            // Afișarea detaliilor despre clienti
                            for (Client client : clienti) {
                                System.out.println(client.toString());
                            }
                            System.out.println("VIZUALIZARE ANGAJATI");
                            break;
                        case 10:
                            System.out.println("LOG OUT ADMINISTRATOR");
                            return; // Închide bucla managerului și revine la meniul principal
                        default:
                            System.out.println("COMANDA INCORECTA");
                    }
                }
            }

            private static void handleClient() {
                Scanner scanner = new Scanner(System.in);
                int com2;

                while (true) {
                    System.out.println("Apasa 1 pentru VIZUALIZARE SOLD");
                    System.out.println("Apasa 2 pentru TRANZACTIE");
                    System.out.println("Apasa 10 pentru LOG OUT CLIENT");

                    com2 = scanner.nextInt();

                    switch (com2) {
                        case 1:
                            List<Client> listaClienti = Client.citesteClientiDinFisier();
                            System.out.println("Introduceti ibanul: ");
                            String iban = scanner.next();
                            for (Client client : listaClienti) {
                                if (iban.equals(client.getContBancar().getIban())) {
                                    System.out.println("Soldul dumneavoastra este: " + client.getContBancar().getSold());
                                }
                            }
                            break;
                        case 2:
                            List<Client> listaClienti2 = Client.citesteClientiDinFisier();
                            System.out.println("Introduceti ibanul dumneavoastra: ");
                            String iban1 = scanner.next();
                            System.out.println("Introduceti ibanul catre care vreti sa faceti tranzactia: ");
                            String iban2 = scanner.next();
                            System.out.println("Introduceti suma dorita: ");
                            double suma = scanner.nextDouble();
                            for (Client client : listaClienti2) {
                                if (iban1.equals(client.getContBancar().getIban())) {
                                   double sold1 = client.getContBancar().getSold();
                                   if (suma > sold1) {
                                       System.out.println("Fonduri insuficiente.");
                                       break;}
                                   else {
                                       sold1 = sold1 - suma;
                                       client.getContBancar().setSold(sold1);
                                   }
                                }
                                if (iban2.equals(client.getContBancar().getIban())) {
                                    double sold2 = client.getContBancar().getSold();
                                    sold2 = sold2 + suma;
                                    client.getContBancar().setSold(sold2);
                                }
                            }
                            String caleFisierClient = "C:\\Users\\AndreeaG\\Desktop\\ASE MASTER\\PPOO\\proiect\\ebanking\\src\\FisiereTXT\\Client.txt";

                            for (int idx=0; idx<listaClienti2.size(); idx++) {
                                if (idx==0){
                                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(caleFisierClient))) {
                                        String detaliiClient = listaClienti2.get(idx).getNume() + ',' + listaClienti2.get(idx).getPrenume() + ',' + listaClienti2.get(idx).getNumarTelefon() + ',' + listaClienti2.get(idx).getAdresaEmail() + listaClienti2.get(idx).getContBancar().getIban() + listaClienti2.get(idx).getContBancar().getSold();
                                        writer.write(detaliiClient);
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                }
                                else {
                                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(caleFisierClient, true))) {
                                        String detaliiClient = "\n" + listaClienti2.get(idx).getNume() + ',' + listaClienti2.get(idx).getPrenume() + ',' + listaClienti2.get(idx).getNumarTelefon() + ',' + listaClienti2.get(idx).getAdresaEmail() + listaClienti2.get(idx).getContBancar().getIban() + listaClienti2.get(idx).getContBancar().getSold();
                                        writer.write(detaliiClient);
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                            break;
                        case 10:
                            System.out.println("LOG OUT CLIENT");
                            return;
                        default:
                            System.out.println("COMANDA INCORECTA");
                    }
                }
            }
        }
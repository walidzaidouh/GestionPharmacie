package ma.gestion.pharmacie.services.impl;

import ma.gestion.pharmacie.dto.ClientDTO;
import ma.gestion.pharmacie.dto.MedicamentDTO;
import ma.gestion.pharmacie.dto.Pharmacie;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * The Application Main.
 */
public class ApplicationMain {


    public static Scanner scanner = new Scanner(System.in);

    public static void main(String ... args) {

        GestionPharmacieImpl gestionPharmacie = new GestionPharmacieImpl();

        List<ClientDTO> clients = new ArrayList<>();
        List<MedicamentDTO> medicaments = new ArrayList<>();

        ClientDTO clientDTO1 = new ClientDTO("JONH", "DEEP", 1000.0);
        ClientDTO clientDTO2 = new ClientDTO("MARY", "NILSON", 2000.0);

        clients.add(clientDTO1);
        clients.add(clientDTO2);

        MedicamentDTO medicamentDTO = new MedicamentDTO("ASPRO", 50.0, 200);
        MedicamentDTO medicamentDTO1 = new MedicamentDTO("Rhino", 19.15, 100);

        medicaments.add(medicamentDTO);
        medicaments.add(medicamentDTO1);

        Pharmacie p = new Pharmacie(clients, medicaments);

        int choix;
        do {
            choix = menu();

            switch (choix) {
                case 1:
                    gestionPharmacie.afficher(p);
                    break;
                case 2:
                    gestionPharmacie.achat(p);
                    break;
                case 3:
                    gestionPharmacie.lireClient(p);
                    break;
                case 4 :
                    gestionPharmacie.lireMedicament(p);
                    break;
                case 5 :
                    gestionPharmacie.approvisionnement(p);
                case 6:
                    quitter();
                    break;
            }
        } while (choix < 5);
    }
    // Les méthodes utilitaires

    static int menu() {
        int choix = 0;
        System.out.println();
        System.out.println();
        System.out.println("1 : Consutation du stock");
        System.out.println("2 : Achat du médicament");
        System.out.println("3 : Rechercher un client");
        System.out.println("4 : Rechercher un médicament");
        System.out.println("4 : Approvisionner le sotck");
        System.out.println("5 : Quitter");
        while ((choix != 1) && (choix != 2) && (choix != 3) && (choix != 4) && (choix != 5) && (choix != 6)) {
            choix = scanner.nextInt();
        }
        return choix;
    }

    static void quitter() {
        System.out.println("Programme termin�!");
    }
}

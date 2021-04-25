package ma.gestion.pharmacie.services.impl;

import ma.gestion.pharmacie.dto.ClientDTO;
import ma.gestion.pharmacie.dto.MedicamentDTO;
import ma.gestion.pharmacie.dto.Pharmacie;
import ma.gestion.pharmacie.services.IGestionPharmacie;

public class GestionPharmacieImpl implements IGestionPharmacie {

    /**
     * This method allows to display the stock data.
     *
     * @param pharmacie
     */
    public void afficher(Pharmacie pharmacie) {

        if (pharmacie == null) {
            System.out.println("La pharmacie n'est pas trouvée.");
        }

        System.out.println("Affichage des stocks");

        for (MedicamentDTO medicamentDTO : pharmacie.getMedicamentDTOList()) {
            System.out.println("Le stock du médicament " + medicamentDTO.getName() + " est : " + medicamentDTO.getStock());
        }

        System.out.println("Affichage des crédits");
        for (ClientDTO clientDTO : pharmacie.getClientDTOList()) {

            System.out.println("Crédit du client " + clientDTO.getFirstName()
                    .concat(" ")
                    .concat(clientDTO.getLastName()) + " est : " + clientDTO.getCredit());
        }

    }

    public ClientDTO lireClient(Pharmacie pharmacie) {

        String prenom, nom;
        boolean clientTrouve = false;
        ClientDTO clientResult = null;

        do {
            System.out.println("Prénom du client?:");
            prenom = ApplicationMain.scanner.next();
            System.out.println("Nom du client?:");
            nom = ApplicationMain.scanner.next();

            for (ClientDTO clientDTO : pharmacie.getClientDTOList()) {
                if (clientDTO.getFirstName().equals(prenom) && clientDTO.getLastName().equals(nom)) {
                    clientTrouve = true;
                    clientResult = clientDTO;
                    break;
                }
            }
            if (!clientTrouve) {
                System.out.println("Client inconnu. Veuilliez recommencer");
            }
        } while (!clientTrouve);

        return clientResult;

    }


    public MedicamentDTO lireMedicament(Pharmacie pharmacie) {

        String name;
        boolean medicamentTrouve = false;
        MedicamentDTO medicamentDTO = null;

        do {
            System.out.println("Nom du médicament ?:");
            name = ApplicationMain.scanner.next();

            for (MedicamentDTO medicamentDTO1 : pharmacie.getMedicamentDTOList()) {
                if (medicamentDTO1.getName().equals(name)) {
                    medicamentTrouve = true;
                    medicamentDTO = medicamentDTO1;
                    break;
                }
            }
            if (!medicamentTrouve) {
                System.out.println("Médicament inconnu. Veuilliez recommencer");
            }
        } while (!medicamentTrouve);

        return medicamentDTO;

    }


    public void achat(Pharmacie pharmacie) {

        ClientDTO clientDTO = this.lireClient(pharmacie);
        MedicamentDTO medicamentDTO = this.lireMedicament(pharmacie);

        System.out.println("quel est le montant du paiement ?");
        double amount = ApplicationMain.scanner.nextDouble();

        System.out.println("quelle est la quantité du médicament ?");
        int quantity = ApplicationMain.scanner.nextInt();

        if (quantity <= medicamentDTO.getStock()) {
            medicamentDTO.diminuerStock(quantity);
            clientDTO.augmenterCredit((medicamentDTO.getPrice() * quantity) - amount);
        } else {
            System.out.println("Achat Impossible. Quantité insuffisante");
        }

    }

    public void approvisionnement(Pharmacie pharmacie) {
        MedicamentDTO medicament = this.lireMedicament(pharmacie);
        System.out.println("Donner la Quantité : ");
        int quantite = ApplicationMain.scanner.nextInt();
        medicament.augmenterStock(quantite);
    }

    public void quitter() {

    }

}

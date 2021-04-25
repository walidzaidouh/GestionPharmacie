package ma.gestion.pharmacie.services;

import ma.gestion.pharmacie.dto.ClientDTO;
import ma.gestion.pharmacie.dto.MedicamentDTO;
import ma.gestion.pharmacie.dto.Pharmacie;

public interface IGestionPharmacie {

    void afficher(Pharmacie pharmacie);

    ClientDTO lireClient(Pharmacie pharmacie);

    MedicamentDTO lireMedicament(Pharmacie pharmacie);

    void achat(Pharmacie pharmacie);

    void approvisionnement(Pharmacie pharmacie);

    void quitter();
}

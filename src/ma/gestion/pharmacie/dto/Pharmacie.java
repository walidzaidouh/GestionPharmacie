package ma.gestion.pharmacie.dto;

import java.util.List;

/**
 * The class Pharmacie.
 */
public class Pharmacie {

    private List<ClientDTO> clientDTOList;

    private List<MedicamentDTO> medicamentDTOList;

    public Pharmacie(List<ClientDTO> clientDTOList, List<MedicamentDTO> medicamentDTOList) {
        this.clientDTOList = clientDTOList;
        this.medicamentDTOList = medicamentDTOList;
    }

    public List<ClientDTO> getClientDTOList() {
        return clientDTOList;
    }

    public void setClientDTOList(List<ClientDTO> clientDTOList) {
        this.clientDTOList = clientDTOList;
    }

    public List<MedicamentDTO> getMedicamentDTOList() {
        return medicamentDTOList;
    }

    public void setMedicamentDTOList(List<MedicamentDTO> medicamentDTOList) {
        this.medicamentDTOList = medicamentDTOList;
    }

    @Override
    public String toString() {
        return "Pharmacie{" +
                "clientDTOList=" + clientDTOList +
                ", medicamentDTOList=" + medicamentDTOList +
                '}';
    }
}

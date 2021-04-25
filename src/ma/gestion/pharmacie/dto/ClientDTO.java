package ma.gestion.pharmacie.dto;

/**
 * The class ClientDTO.
 */
public class ClientDTO {

    private String firstName;

    private String lastName;

    private double credit = 0.0;

    public ClientDTO(String firstName, String lastName, double credit) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.credit = credit;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public void augmenterCredit(double credit){
        this.setCredit(this.getCredit() + credit);
    }

    @Override
    public String toString() {
        return "ClientDTO{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", credit=" + credit +
                '}';
    }
}

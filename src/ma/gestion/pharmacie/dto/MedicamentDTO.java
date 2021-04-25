package ma.gestion.pharmacie.dto;

/**
 * The classe MedicamentDTO.
 */
public class MedicamentDTO {

    private String name;

    private double price;

    private int stock;

    public MedicamentDTO(String name, double price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void diminuerStock(int quantity) {
        this.setStock(this.getStock() - quantity);
    }

    public void augmenterStock(int qte){
        stock+=qte;
    }


    @Override
    public String toString() {
        return "MedicamentDTO{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                '}';
    }
}

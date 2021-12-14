package hibernate.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "PRODUCT")
public class Product {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "PRICE")
    private int price;


    @ManyToMany(mappedBy = "productList", fetch = FetchType.EAGER)
    private List<Client> clientList;

    public Product() {

    }
    public Product(String title, int price) {
        this.id = null;
        this.title = title;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getPrice() {
        return price;
    }

    public List<Client> getClientList() {
        return clientList;
    }

    public String showClientList() {
        StringBuilder str = new StringBuilder();
        str.append('{');
        for (Client client : clientList) {
            str.append('[' + client.getName() + ']');
        }
        str.append('}');
        return str.toString();
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", clientList=" + showClientList() +
                '}';
    }
}

package hibernate.dto;

import javax.persistence.*;
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

    public Product(Long id, String title, int price) {
        this.id = id;
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

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setClientList(List<Client> clientList) {
        this.clientList = clientList;
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

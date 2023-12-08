package Robin.TechItEasy.model;
import jakarta.persistence.*;

@Entity
@Table(name = "CI_module")
public class CiModule {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String type;
    private Double price;
    @Column(name = "original_stock")
    private Integer originalStock;
    private Integer sold;

    public CiModule(Long id, String name, String type, Double price, Integer originalStock, Integer sold) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
        this.originalStock = originalStock;
        this.sold = sold;
    }

    public CiModule() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getOriginalStock() {
        return originalStock;
    }

    public void setOriginalStock(Integer originalStock) {
        this.originalStock = originalStock;
    }

    public Integer getSold() {
        return sold;
    }

    public void setSold(Integer sold) {
        this.sold = sold;
    }
}

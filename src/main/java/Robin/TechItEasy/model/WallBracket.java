package Robin.TechItEasy.model;
import jakarta.persistence.*;

@Entity
@Table(name = "Wall_bracket")
public class WallBracket {

    @Id
    @GeneratedValue
    private Long id;
    private String size;
    private Boolean adjustable;
    private String name;
    private Double price;
    @Column(name = "original_stock")
    private Integer originalStock;
    private Integer sold;

    public WallBracket(Long id, String size, Boolean adjustable, String name, Double price, Integer originalStock, Integer sold) {
        this.id = id;
        this.size = size;
        this.adjustable = adjustable;
        this.name = name;
        this.price = price;
        this.originalStock = originalStock;
        this.sold = sold;
    }

    public WallBracket() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Boolean getAdjustable() {
        return adjustable;
    }

    public void setAdjustable(Boolean adjustable) {
        this.adjustable = adjustable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

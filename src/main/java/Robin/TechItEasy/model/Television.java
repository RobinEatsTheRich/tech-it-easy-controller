package Robin.TechItEasy.model;
import jakarta.persistence.*;

@Entity
@Table(name = "Televisions")
public class Television {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="serial_number")
    private int serialNumber;

    @Column(name="price")
    private double price;
}

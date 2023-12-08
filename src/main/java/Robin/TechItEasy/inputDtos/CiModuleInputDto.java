package Robin.TechItEasy.inputDtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

public class CiModuleInputDto {

    private Long id;
    @NotNull
    @Size(min=1, max=128)
    private String name;
    @NotNull
    @Size(min=1, max=128)
    private String type;
    @Positive
    private Double price;
    @PositiveOrZero
    private Integer originalStock;
    @PositiveOrZero
    private Integer sold;

    public CiModuleInputDto(Long id, String name, String type, Double price, Integer originalStock, Integer sold) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
        this.originalStock = originalStock;
        this.sold = sold;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getOriginalStock() {
        return originalStock;
    }

    public Integer getSold() {
        return sold;
    }
}

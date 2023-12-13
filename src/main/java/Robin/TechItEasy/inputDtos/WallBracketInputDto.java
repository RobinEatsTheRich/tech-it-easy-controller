package Robin.TechItEasy.inputDtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

public class WallBracketInputDto {

    private Long id;
    @NotNull
    @Size(min=1, max=128)
    private String size;
    private Boolean adjustable;
    @NotNull
    @Size(min=1, max=128)
    private String name;
    @Positive
    private Double price;
    @PositiveOrZero
    private Integer originalStock;
    @PositiveOrZero
    private Integer sold;

    public WallBracketInputDto(Long id, String size, Boolean adjustable, String name, Double price, Integer originalStock, Integer sold) {
        this.id = id;
        this.size = size;
        this.adjustable = adjustable;
        this.name = name;
        this.price = price;
        this.originalStock = originalStock;
        this.sold = sold;
    }

    public Long getId() {
        return id;
    }

    public String getSize() {
        return size;
    }

    public Boolean getAdjustable() {
        return adjustable;
    }

    public String getName() {
        return name;
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

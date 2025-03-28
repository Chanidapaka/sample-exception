package sit.int204.sampleexception.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

@Getter
@Setter
public class ProductDtoA {
    @NotNull
    @Size(min = 2, max = 10)
    private String productCode;
    @NotNull
    @Size(min = 10, max = 100)
    private String productName;
    @JsonIgnore
    private BigDecimal msrp;

    @Min(5)
    @Max(1200)
    public Double getPrice() {
        return msrp.doubleValue();
    }

}

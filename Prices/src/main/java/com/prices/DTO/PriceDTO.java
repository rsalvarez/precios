package com.prices.DTO;

import com.prices.shared.Curr;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class PriceDTO {
    private Long id;
    private BrandDTO brand;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private PriceListDTO priceList;
    private ProductDTO product;
    private Integer priority;
    private Double price;
    private Curr curr;

}

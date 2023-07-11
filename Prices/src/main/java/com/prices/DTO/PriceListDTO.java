package com.prices.DTO;

import lombok.Data;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
public class PriceListDTO {
    private Long id;
    private String name;
}

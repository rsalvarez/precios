package com.prices.model;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity(name="BRANDS")
public class Brand {
    @Id
    private Long id;
    private String name;
}

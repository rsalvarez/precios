package com.prices.model;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity(name="PRODUCTS")
public class Product {
    @Id
    private Long id;
    private String name;

}

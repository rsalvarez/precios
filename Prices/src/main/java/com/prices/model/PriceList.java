package com.prices.model;

import lombok.Data;
import javax.persistence.Entity;

import javax.persistence.Id;

@Data
@Entity(name="PRICE_LISTS")
public class PriceList {
    @Id
    private Long id;
    private String name;
}

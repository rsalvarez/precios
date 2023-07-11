package com.prices.model;

import com.prices.shared.Curr;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.time.LocalDateTime;

@Data
@Entity(name = "PRICES")
public class Price {
    @Id
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    private Brand brand;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    @OneToOne(cascade = CascadeType.ALL)
    private PriceList priceList;
    @OneToOne(cascade = CascadeType.ALL)
    private Product product;
    private Integer priority;
    private Double price;
    @Enumerated(EnumType.STRING)
    private Curr curr;

}

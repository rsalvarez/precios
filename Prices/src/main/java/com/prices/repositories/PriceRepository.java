package com.prices.repositories;

import com.prices.model.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {

    @Query("SELECT P FROM PRICES P WHERE product_id = :productId AND brand_id = :brandId AND :data between start_date AND IFNULL(end_date,:data) ORDER BY priority DESC")
    public Optional<List<Price>> findPrice(
            Integer productId,
            Integer brandId,
            LocalDateTime data
    );

}

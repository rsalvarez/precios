package com.prices.services;
import com.prices.DTO.PriceDTO;
import com.prices.DTO.ResponseDTO;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public interface PriceService {
    public Optional<ResponseDTO> getPrice(Integer brand, LocalDateTime date, Integer product);
}

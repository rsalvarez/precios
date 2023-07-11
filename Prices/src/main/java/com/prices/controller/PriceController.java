package com.prices.controller;


import com.prices.DTO.ResponseDTO;
import com.prices.exception.ExResponse;
import com.prices.services.PriceService;
import com.prices.DTO.PriceDTO;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@RestController
@RequestMapping("/prices")
public class PriceController {

    private final PriceService priceService;

    public PriceController(PriceService priceService) {
        this.priceService = priceService;
    }
    @Operation(summary = "retorna precio segun parametros", description = "getPrice")
    @GetMapping("/price/")
    public ResponseDTO getPrice(@RequestParam Integer brand,
                                @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime date,
                                @RequestParam Integer product) {
       Optional<ResponseDTO> response = priceService.getPrice(brand,date,product);
        if (response.isPresent()) {
            return response.get();
        }
        throw new ExResponse("Price Not found",400,null);
    }

}

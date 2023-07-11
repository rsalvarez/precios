package com.prices.services;


import com.prices.DTO.ResponseDTO;
import com.prices.model.Price;
import com.prices.repositories.PriceRepository;
import com.prices.DTO.PriceDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PriceServicesImpl implements PriceService {

    private final PriceRepository priceRepository;

    private final ModelMapper modelMapper;
    @Autowired
    public PriceServicesImpl(PriceRepository priceRepository, ModelMapper modelMapper) {
        this.priceRepository = priceRepository;
        this.modelMapper = modelMapper;
    }
    @Override
    public Optional<ResponseDTO> getPrice(Integer brand, LocalDateTime date, Integer product) {
        Optional<List<Price>> list = priceRepository.findPrice(product,brand,date);
        if (list.isPresent() && list.get().size() > 0 ) {
            ResponseDTO response = new ResponseDTO();
            // obtenemos el de mayor prioridad por estar odrdenados de forma descendente.
            PriceDTO priceDTO = modelMapper.map(list.get().get(0), PriceDTO.class);
            response.setCurr(priceDTO.getCurr());
            response.setPrice(priceDTO.getPrice());
            response.setPriceListId (priceDTO.getPriceList().getId());
            response.setBrandId(priceDTO.getBrand().getId());
            response.setProductId(priceDTO.getProduct().getId());
            response.setStartDate(priceDTO.getStartDate());
            response.setEndDate(priceDTO.getEndDate());
            return Optional.of(response);
        }
       return Optional.empty();
    }
}

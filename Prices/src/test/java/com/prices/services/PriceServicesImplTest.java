package com.prices.services;

import com.prices.DTO.ResponseDTO;
import com.prices.repositories.PriceRepository;
import com.prices.shared.Curr;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
@DataJpaTest
@Transactional(propagation = Propagation.NOT_SUPPORTED)
class PriceServicesImplTest {

    private PriceServicesImpl priceServicesImplUnderTest;
    @Autowired
    private PriceRepository priceRepository;

    @BeforeEach
    void setUp() {
        priceServicesImplUnderTest = new PriceServicesImpl(priceRepository, new ModelMapper());
    }

    /*se moquea el resistro que deberia retornar el servide, para compararlo. esto para los 5 casos.*/

    @Test
    void testGetPrice() {
        // Setup
        final ResponseDTO responseDTO1 = new ResponseDTO();
        responseDTO1.setProductId(35455L);
        responseDTO1.setBrandId(1L);
        responseDTO1.setPriceListId(1L);
        responseDTO1.setStartDate(LocalDateTime.of(2020, 6, 14, 0, 0, 0));
        responseDTO1.setEndDate(LocalDateTime.of(2020, 12, 31, 23, 59, 59));
        responseDTO1.setPrice(35.50);
        responseDTO1.setPriority(0);
        responseDTO1.setCurr(Curr.EUR);
        final Optional<ResponseDTO> expectedResult = Optional.of(responseDTO1);

        // Run the test
        //2020-06-14-10.00.00
        final Optional<ResponseDTO> result = priceServicesImplUnderTest.getPrice(1,
                LocalDateTime.of(2020, 06, 14, 10, 0, 0), 35455);

        // Verify the results
        assertEquals(expectedResult.get().getPrice(), result.get().getPrice());
        assertEquals(0, result.get().getPriority());
    }

    @Test
    void testGetPrice2() {
        // Setup
        final ResponseDTO responseDTO1 = new ResponseDTO();
        responseDTO1.setProductId(35455L);
        responseDTO1.setBrandId(1L);
        responseDTO1.setPriceListId(2L);
        responseDTO1.setPriority(1);
        responseDTO1.setStartDate(LocalDateTime.of(2020, 6, 14, 15, 0, 0));
        responseDTO1.setEndDate(LocalDateTime.of(2020, 6, 14, 18, 30, 0));
        responseDTO1.setPrice(25.45);
        responseDTO1.setCurr(Curr.EUR);
        final Optional<ResponseDTO> expectedResult = Optional.of(responseDTO1);

        // Run the test
        //2020-06-14-10.00.00
        final Optional<ResponseDTO> result = priceServicesImplUnderTest.getPrice(1,
                LocalDateTime.of(2020, 06, 14, 16, 0, 0), 35455);

        // Verify the results
        assertEquals(expectedResult.get().getPrice(), result.get().getPrice());
        assertEquals(1, result.get().getPriority());
    }

    @Test
    void testGetPrice3() {
        // Setup
        final ResponseDTO responseDTO1 = new ResponseDTO();
        responseDTO1.setProductId(35455L);
        responseDTO1.setBrandId(1L);
        responseDTO1.setPriceListId(1L);
        responseDTO1.setStartDate(LocalDateTime.of(2020, 6, 14, 0, 0, 0));
        responseDTO1.setEndDate(LocalDateTime.of(2020, 12, 31, 23, 59, 59));
        responseDTO1.setPrice(35.50);
        responseDTO1.setPriority(0);
        responseDTO1.setCurr(Curr.EUR);
        final Optional<ResponseDTO> expectedResult = Optional.of(responseDTO1);

        // Run the test
        //2020-06-14-10.00.00
        final Optional<ResponseDTO> result = priceServicesImplUnderTest.getPrice(1,
                LocalDateTime.of(2020, 06, 14, 21, 0, 0), 35455);

        // Verify the results
        assertEquals(expectedResult.get().getPrice(), result.get().getPrice());
        assertEquals(0, result.get().getPriority());
    }

    @Test
    void testGetPrice4() {
        // Setup
        final ResponseDTO responseDTO1 = new ResponseDTO();
        responseDTO1.setProductId(35455L);
        responseDTO1.setBrandId(1L);
        responseDTO1.setPriceListId(3L);
        responseDTO1.setStartDate(LocalDateTime.of(2020, 6, 15, 0, 0, 0));
        responseDTO1.setEndDate(LocalDateTime.of(2020, 12, 15, 11, 0, 0));
        responseDTO1.setPrice(30.50);
        responseDTO1.setPriority(1);
        responseDTO1.setCurr(Curr.EUR);
        final Optional<ResponseDTO> expectedResult = Optional.of(responseDTO1);

        // Run the test
        //2020-06-14-10.00.00
        final Optional<ResponseDTO> result = priceServicesImplUnderTest.getPrice(1,
                LocalDateTime.of(2020, 6, 15, 10, 0, 0), 35455);

        // Verify the results
        assertEquals(expectedResult.get().getPrice(), result.get().getPrice());
        assertEquals(1, result.get().getPriority());
    }

    @Test
    void testGetPrice5() {
        // Setup
        final ResponseDTO responseDTO1 = new ResponseDTO();
        responseDTO1.setProductId(35455L);
        responseDTO1.setBrandId(1L);
        responseDTO1.setPriceListId(4L);
        responseDTO1.setStartDate(LocalDateTime.of(2020, 6, 15, 16, 0, 0));
        responseDTO1.setEndDate(LocalDateTime.of(2020, 12, 31, 23, 59, 59));
        responseDTO1.setPrice(38.95);
        responseDTO1.setPriority(1);
        responseDTO1.setCurr(Curr.EUR);
        final Optional<ResponseDTO> expectedResult = Optional.of(responseDTO1);

        // Run the test
        //2020-06-14-10.00.00
        final Optional<ResponseDTO> result = priceServicesImplUnderTest.getPrice(1,
                LocalDateTime.of(2020, 6, 16 , 21, 0, 0), 35455);

        // Verify the results
        assertEquals(expectedResult.get().getPrice(), result.get().getPrice());
        assertEquals(1, result.get().getPriority());
    }

}

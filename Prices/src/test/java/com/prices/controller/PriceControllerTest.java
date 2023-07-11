package com.prices.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.prices.DTO.ResponseDTO;
import com.prices.repositories.PriceRepository;
import com.prices.services.PriceService;
import com.prices.shared.Curr;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@ExtendWith(SpringExtension.class)
@WebMvcTest(PriceController.class)
class PriceControllerTest {

    @Autowired
    WebApplicationContext context;

    MockMvc mockMvc;
    @Autowired
    ObjectMapper maper;


//    @MockBean

    private final PriceService priceService;
    private final PriceController priceController;

    private final PriceRepository priceRepository;

    PriceControllerTest(PriceService priceService, PriceController priceController, PriceRepository priceRepository) {
        this.priceService = priceService;
        this.priceController = priceController;

        this.priceRepository = priceRepository;
    }

    @BeforeEach
    public void setUp() {

        this.mockMvc = MockMvcBuilders
                .webAppContextSetup(context)
                .build();
    }

    @Test
    void testPrice1() throws Exception {
        // Setup
        // Configure PriceService.getPrice(...).
        final ResponseDTO responseDTO1 = new ResponseDTO();
        /*responseDTO1.setProductId(35455L);
        responseDTO1.setBrandId(1L);
        responseDTO1.setPriceListId(1L);
        responseDTO1.setStartDate(LocalDateTime.of(2020, 6, 14, 0, 0, 0));
        responseDTO1.setEndDate(LocalDateTime.of(2020, 12, 31, 23, 59, 59));
        responseDTO1.setPrice(35.50);
        responseDTO1.setCurr(Curr.EUR);
        final Optional<ResponseDTO> responseDTO = Optional.of(responseDTO1);
        when(mockPriceService.getPrice(Mockito.anyInt(), Mockito.any(), Mockito.anyInt())).thenReturn(responseDTO);
        */
        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(get("/prices/price/")
                        .param("brand", "1")
                        .param("date", "2020-06-14 10:00:00")
                        .param("product", "35455")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();


        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        ResponseDTO rta = maper.readValue(response.getContentAsString(), ResponseDTO.class);
        assertThat(rta.getPrice()).isEqualTo(responseDTO1.getPrice());
    }
}
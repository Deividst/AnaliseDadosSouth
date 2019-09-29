package com.southsystem.analisedados.service;

import com.southsystem.analisedados.dto.ReportDto;
import com.southsystem.analisedados.model.Client;
import com.southsystem.analisedados.model.Sale;
import com.southsystem.analisedados.model.Salesman;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * @author Deivid
 */
public class AnalyzeDataServiceTests {

    private ReportDto dto = new ReportDto();
    private AnalyzeDataService service = new AnalyzeDataService();

    @Test
    public void shouldGetQuantityClient(){
        dto.getClientList().add(new Client());
        service.setDto(dto);
        int result = service.getQuantityClient();

        Assert.assertTrue(result > 0);
    }

    @Test
    public void shouldGetQuantitySalesman(){
        dto.getSalesmanList().add(new Salesman());
        service.setDto(dto);
        int result = service.getQuantitySalesman();

        Assert.assertTrue(result > 0);
    }

    @Test
    public void shouldGetMostExpensiveSaleId(){
        Sale sale = new Sale();
        sale.setAmount(new BigDecimal(1000));
        sale.setIdSale(1L);
        dto.getSaleList().add(sale);
        service.setDto(dto);
        Long result = service.getMostExpensiveSaleId();

        Assert.assertNotNull(result);
    }

    @Test
    public void shouldWorstSeller(){
        Sale sale = new Sale();
        sale.setAmount(new BigDecimal(100.01));
        sale.setSalesmanName("Pedro");
        dto.getSaleList().add(sale);
        service.setDto(dto);
        String result = service.getWorstSeller();

        Assert.assertTrue(result.equalsIgnoreCase("Pedro"));
    }

}

package com.southsystem.analisedados.service;

import com.southsystem.analisedados.dto.ReportDto;
import com.southsystem.analisedados.model.Sale;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@Getter
@Setter
public class AnalyzeDataService {

    private ReportDto dto;

    public int getQuantityClient() {
        if (dto.getClientList() != null) {
            return dto.getClientList().size();
        }
        return 0;
    }

    public int getQuantitySalesman() {
        if (dto.getSalesmanList() != null) {
            return dto.getSalesmanList().size();
        }
        return 0;
    }

    public Long getMostExpensiveSaleId() {
        if (dto.getSaleList() != null) {
            Sale sale = dto.getSaleList()
                    .stream()
                    .max(Comparator.comparing(Sale::getAmount))
                    .orElse(null);

            if (sale != null) {
                return sale.getIdSale();
            }
        }

        return null;
    }

    public String getWorstSeller() {

        if (dto.getSaleList() != null && !dto.getSaleList().isEmpty()) {

            Map<String, BigDecimal> salesmanSaleMap = dto.getSaleList()
                    .stream()
                    .collect(Collectors.groupingBy(Sale::getSalesmanName,
                            Collectors.reducing(BigDecimal.ZERO, Sale::getAmount, BigDecimal::add)));

            Map.Entry<String, BigDecimal> salesmanSmallestSale = Collections.min(salesmanSaleMap.entrySet(),
                    Comparator.comparing(Map.Entry::getValue));

            if (salesmanSmallestSale != null && salesmanSmallestSale.getKey() != null) {
                return salesmanSmallestSale.getKey();
            }
        }

        return "";
    }
}

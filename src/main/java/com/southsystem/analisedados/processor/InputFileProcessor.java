package com.southsystem.analisedados.processor;

import com.southsystem.analisedados.dto.ReportDto;
import com.southsystem.analisedados.model.Enum.DataTypeEnum;
import com.southsystem.analisedados.model.Item;
import com.southsystem.analisedados.model.Sale;
import com.southsystem.analisedados.converter.ClientConverter;
import com.southsystem.analisedados.converter.SaleConverter;
import com.southsystem.analisedados.converter.SalesmanConverter;
import com.southsystem.analisedados.util.FileUtil;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.nio.file.Path;
import java.util.List;

/**
 * Classe que vai realizar o processamento do arquivo de entrada.
 */
@Component
public class InputFileProcessor {

    private final String SPLIT_LINE = "ç";

    public ReportDto process(Path path) {

        List<String> linhas = FileUtil.readFile(path);
        ReportDto dto = new ReportDto();

        linhas.forEach(linha -> {
            String[] atributos = linha.split(SPLIT_LINE);
            switch (DataTypeEnum.getValue(atributos[0])) {
                case CLIENT:
                    dto.getClientList().add(ClientConverter.converter(atributos));
                    break;
                case SALESMAN:
                    dto.getSalesmanList().add(SalesmanConverter.converter(atributos));
                    break;
                case SALE:
                    Sale sale = SaleConverter.converter(atributos);
                    sale.setAmount(sale.getItems().stream()
                            .map(Item::getPrice)
                            .reduce(BigDecimal.ZERO, BigDecimal::add));
                    dto.getSaleList().add(sale);
                    break;
            }

        });

        return dto;
    }
}

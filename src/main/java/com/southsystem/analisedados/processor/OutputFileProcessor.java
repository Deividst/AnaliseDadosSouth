package com.southsystem.analisedados.processor;

import com.southsystem.analisedados.config.PathConfig;
import com.southsystem.analisedados.dto.ReportDto;
import com.southsystem.analisedados.service.AnalyzeDataService;
import com.southsystem.analisedados.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OutputFileProcessor {

    private final AnalyzeDataService service;

    @Autowired
    public OutputFileProcessor(AnalyzeDataService service) {
        this.service = service;
    }

    public void process(ReportDto dto){
        List<String> linhas = new ArrayList<>();
        service.setDto(dto);

        linhas.add("Quantidade de clientes no arquivo de entrada: " + service.getQuantityClient());
        linhas.add("Quantidade de vendedores no arquivo de entrada: " + service.getQuantitySalesman());
        linhas.add("ID da venda mais cara: " + service.getMostExpensiveSaleId());
        linhas.add("O pior vendedor: " + service.getWorstSeller());

        FileUtil.writeFile(PathConfig.PATH_OUT, linhas);
    }

}

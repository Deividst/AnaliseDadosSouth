package com.southsystem.analisedados.dto;


import com.southsystem.analisedados.model.Client;
import com.southsystem.analisedados.model.Sale;
import com.southsystem.analisedados.model.Salesman;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ReportDto {

    private List<Client> clientList;
    private List<Salesman> salesmanList;
    private List<Sale> saleList;

    public ReportDto() {
        this.clientList = new ArrayList<>();
        this.salesmanList = new ArrayList<>();
        this.saleList = new ArrayList<>();
    }
}

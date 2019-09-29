package com.southsystem.analisedados.model;

import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class Sale {

    private Long idSale;
    private String salesmanName;
    private List<Item> items;
    private BigDecimal amount;


}

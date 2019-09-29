package com.southsystem.analisedados.model;


import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class Item {

    private Long id;
    private Integer quantity;
    private BigDecimal price;

}

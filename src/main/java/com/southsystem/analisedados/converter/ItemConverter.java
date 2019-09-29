package com.southsystem.analisedados.converter;


import com.southsystem.analisedados.model.Item;

import java.math.BigDecimal;
/**
 * Converte uma string em um {@link Item}.
 *
 * @author Deivid
 */
public class ItemConverter {

    private static final String SPLIT_LINE = "-";

    public static Item converter(String linha){
        String[] atributos = linha.split(SPLIT_LINE);
        return Item.builder()
                .id(Long.parseLong(atributos[0]))
                .quantity(Integer.parseInt(atributos[1]))
                .price(new BigDecimal(atributos[2])).build();
    }

}

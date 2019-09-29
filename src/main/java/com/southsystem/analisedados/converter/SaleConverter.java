package com.southsystem.analisedados.converter;


import com.southsystem.analisedados.model.Item;
import com.southsystem.analisedados.model.Sale;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Converte o array de atributos em um {@link Sale}.
 *
 * @author Deivid
 */
public class SaleConverter {

    public static Sale converter(String[] atributos) {
        return Sale.builder()
                .idSale(Long.parseLong(atributos[1]))
                .items(converterItems(atributos[2]))
                .salesmanName(atributos[3]).build();
    }

    private static List<Item> converterItems(String linha) {
        List<String> itens = Arrays.asList(linha.replaceAll("\\[|]", "").split(","));
        return itens.stream()
                .map(ItemConverter::converter)
                .collect(Collectors.toList());
    }

}

package com.southsystem.analisedados.converter;


import com.southsystem.analisedados.model.Salesman;

/**
 * Converte o array de atributos em um {@link Salesman}.
 *
 * @author Deivid
 */
public class SalesmanConverter {

    public static Salesman converter(String[] atributos){
        return Salesman.builder()
                .cpf(atributos[1])
                .name(atributos[2])
                .salary(atributos[3]).build();
    }
}

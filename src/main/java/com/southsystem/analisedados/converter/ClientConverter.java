package com.southsystem.analisedados.converter;


import com.southsystem.analisedados.model.Client;

/**
 * Converte o array de atributos em um {@link Client}.
 *
 * @author Deivid
 */
public class ClientConverter {

    public static Client converter(String[] atributos){
        return Client.builder()
                .cnpj(atributos[1])
                .name(atributos[2])
                .businessArea(atributos[3]).build();
    }

}

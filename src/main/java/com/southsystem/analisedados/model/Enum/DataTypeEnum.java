package com.southsystem.analisedados.model.Enum;

import com.southsystem.analisedados.util.MessagesUtil;

import java.util.Arrays;

/**
 * Enum para identificar o tipo de Entidade.
 */
public enum DataTypeEnum {

    SALESMAN("001"), CLIENT("002"), SALE("003");

    private final String code;

    DataTypeEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    /**
     * Busca o valor do enum conforme o código passado como parâmetro.
     * @param code String
     * @return {@link DataTypeEnum}
     */
    public static DataTypeEnum getValue(String code) {
        return Arrays.stream(DataTypeEnum.values())
                .filter(tipo -> tipo.code.equalsIgnoreCase(code))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(
                        MessagesUtil.getMessage("erro.argumento.invalido.tipo.dado", code)));
    }
}

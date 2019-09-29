package com.southsystem.analisedados.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class Client {

    private String cnpj;
    private String name;
    private String businessArea;

}

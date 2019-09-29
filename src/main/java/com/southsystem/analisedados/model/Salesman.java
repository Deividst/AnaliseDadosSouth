package com.southsystem.analisedados.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class Salesman {

    private String cpf;
    private String name;
    private String salary;

}

package com.boaentrega.servicocliente.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Endereco {

    @Id
    private Long id;

    private String logradouro;

    private Long numero;

    private Long cep;

    private String complemento;

    private Double latitude;

    private Double longitude;
}

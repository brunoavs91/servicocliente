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

    private String cidade;

    private String estado;

    public String getEnderecoCompleto() {
        StringBuilder builder = new StringBuilder()
                                    .append(logradouro)
                                    .append(" ")
                                    .append(numero)
                                    .append(" ");
        if (complemento != null && !complemento.isEmpty()) {
            builder.append(complemento)
                    .append(" ");
        }
                    
        return builder
                .append(cidade)
                .append(" ")
                .append(estado)
                .append(" ")
                .append(cep)
                .toString();
    }
}

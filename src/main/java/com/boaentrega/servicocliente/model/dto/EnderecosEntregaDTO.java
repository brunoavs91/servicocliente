package com.boaentrega.servicocliente.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EnderecosEntregaDTO {
    private String origem;

    private String destino;
}

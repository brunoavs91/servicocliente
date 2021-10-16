package com.boaentrega.servicocliente.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.boaentrega.servicocliente.model.PedidoStatus;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PedidoStatusDTO {

    private Long numeroPedido;

    private String status;

    private String localizacao;

    private String destino;

    public PedidoStatusDTO(PedidoStatus entity) {
        this.setNumeroPedido(entity.getNumeroPedido());
        this.setLocalizacao(entity.getLocalizacao());
        this.setStatus(entity.getStatus());
        this.setDestino(entity.getDestino() != null ? entity.getDestino().getEnderecoCompleto() : null);
    }

}

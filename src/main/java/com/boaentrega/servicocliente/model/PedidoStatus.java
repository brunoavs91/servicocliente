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
public class PedidoStatus {

    @Id
    private Long numeroPedido;

    private String status;

    private String localizacao;
}

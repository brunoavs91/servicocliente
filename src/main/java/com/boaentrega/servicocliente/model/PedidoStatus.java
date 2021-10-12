package com.boaentrega.servicocliente.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Calendar;

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

    @Temporal(TemporalType.TIMESTAMP)
    private Calendar dataInicio;

    @Temporal(TemporalType.TIMESTAMP)
    private Calendar dataFim;

    @OneToOne
    @JoinColumn(name = "destino")
    private Endereco destino;
}

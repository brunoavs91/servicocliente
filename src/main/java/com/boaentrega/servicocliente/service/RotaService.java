package com.boaentrega.servicocliente.service;

import com.boaentrega.servicocliente.model.dto.EnderecosEntregaDTO;

public interface RotaService {

    EnderecosEntregaDTO buscarEnderecosEntrega(Long numeroPedido) throws Exception;

}

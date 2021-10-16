package com.boaentrega.servicocliente.service;

import java.io.IOException;

import com.boaentrega.servicocliente.model.dto.EnderecosEntregaDTO;
import com.google.maps.errors.ApiException;
import com.google.maps.model.DirectionsResult;

public interface RotaService {

    DirectionsResult buscarRotaEntrega(Long numeroPedido) throws IOException, ApiException, InterruptedException;

    EnderecosEntregaDTO buscarEnderecosEntrega(Long numeroPedido) throws Exception;

}

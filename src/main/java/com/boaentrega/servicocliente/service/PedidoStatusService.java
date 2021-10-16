package com.boaentrega.servicocliente.service;

import java.io.IOException;
import java.util.List;

import com.boaentrega.servicocliente.model.PedidoStatus;

public interface PedidoStatusService {

    void criarPedidoStatus(String mensagem) throws IOException;

    void atualizarPedidoStatus(String mensagem) throws Exception;

    List<PedidoStatus> buscarPedidosNaoEntregues();
}

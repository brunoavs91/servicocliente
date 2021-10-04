package com.boaentrega.servicocliente.service;

import java.io.IOException;

public interface PedidoStatusService {

    void criarPedidoStatus(String mensagem) throws IOException;

    void atualizarPedidoStatus(String mensagem) throws Exception;
}

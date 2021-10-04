package com.boaentrega.servicocliente.listener;

import com.boaentrega.servicocliente.service.PedidoStatusService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.stereotype.Component;

@Component
public class PedidoListener {

    Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PedidoStatusService pedidoStatusService;

    @SqsListener("criar_pedido_status")
    public void receberMensagem(String mensagem) {
        log.info("Recebendo mensagem da fila:{} ", mensagem);
        try {
            pedidoStatusService.criarPedidoStatus(mensagem);
        } catch (Exception ex) {
            log.error(ex.getMessage());
        }
    }
}

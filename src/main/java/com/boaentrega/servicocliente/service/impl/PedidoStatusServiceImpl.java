package com.boaentrega.servicocliente.service.impl;

import com.boaentrega.servicocliente.model.PedidoStatus;
import com.boaentrega.servicocliente.model.dto.PedidoStatusDTO;
import com.boaentrega.servicocliente.repository.PedidoStatusRepository;
import com.boaentrega.servicocliente.service.PedidoStatusService;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Calendar;

@Service
public class PedidoStatusServiceImpl implements PedidoStatusService {

    @Autowired
    private PedidoStatusRepository repository;

    private ObjectMapper mapper = new ObjectMapper();

    Logger log = LoggerFactory.getLogger(this.getClass());


    @Override
    public void criarPedidoStatus(String mensagem) throws IOException {
        PedidoStatusDTO dto = mapper.readValue(mensagem, PedidoStatusDTO.class);
        log.info("Pedido : {}", dto.toString());
        PedidoStatus pedidoStatus = repository.save(PedidoStatus.builder().numeroPedido(dto.getNumeroPedido())
                .status(dto.getStatus()).localizacao(dto.getLocalizacao())
                .dataInicio(Calendar.getInstance()).build());
        log.info("Pedido Salvo : {}", pedidoStatus.getNumeroPedido());

    }

    @Override
    public void atualizarPedidoStatus(String mensagem) throws Exception {
        PedidoStatusDTO dto = mapper.readValue(mensagem, PedidoStatusDTO.class);
        log.info("Pedido : {}", dto.toString());
        PedidoStatus pedidoStatus = repository.findById(dto.getNumeroPedido())
                .orElseThrow(() -> new Exception("Pedido nao encontrado"));
        pedidoStatus.setStatus(dto.getStatus());
        pedidoStatus.setLocalizacao(dto.getLocalizacao());
        if(pedidoStatus.getStatus().equalsIgnoreCase("ENTREGUE")){
            pedidoStatus.setDataFim(Calendar.getInstance());
        }
        repository.save(pedidoStatus);
        log.info("Pedido Salvo : {}", pedidoStatus.toString());

    }
}

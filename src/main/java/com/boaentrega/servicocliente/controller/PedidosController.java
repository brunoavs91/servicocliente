package com.boaentrega.servicocliente.controller;


import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.boaentrega.servicocliente.model.PedidoStatus;
import com.boaentrega.servicocliente.model.dto.EnderecosEntregaDTO;
import com.boaentrega.servicocliente.model.dto.PedidoStatusDTO;
import com.boaentrega.servicocliente.service.PedidoStatusService;
import com.boaentrega.servicocliente.service.RotaService;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pedidos")
public class PedidosController {

    private ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private PedidoStatusService pedidoService;

    @GetMapping("nao-entregues")
    public ResponseEntity<String> getNaoEntregues() {
        try{
            List<PedidoStatus> pedidos = pedidoService.buscarPedidosNaoEntregues();
            List<PedidoStatusDTO> result = new ArrayList<>();
            pedidos.forEach((pedido) -> result.add(new PedidoStatusDTO(pedido)));
            return ResponseEntity.ok().body(mapper.writeValueAsString(result));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).build();
        }
    }
}

package com.boaentrega.servicocliente.service.impl;

import com.boaentrega.servicocliente.model.PedidoStatus;
import com.boaentrega.servicocliente.model.dto.EnderecosEntregaDTO;
import com.boaentrega.servicocliente.model.dto.PedidoStatusDTO;
import com.boaentrega.servicocliente.repository.PedidoStatusRepository;
import com.boaentrega.servicocliente.service.PedidoStatusService;
import com.boaentrega.servicocliente.service.RotaService;
import com.google.maps.DirectionsApi;
import com.google.maps.GeoApiContext;
import com.google.maps.errors.ApiException;
import com.google.maps.model.DirectionsResult;
import com.google.maps.model.LatLng;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class RotaServiceImpl implements RotaService {

    @Autowired
    private PedidoStatusRepository repository;

    Logger log = LoggerFactory.getLogger(this.getClass());


    @Override
    public DirectionsResult buscarRotaEntrega(Long numeroPedido) throws IOException, ApiException, InterruptedException {
    
        // PedidoStatus pedido = repository.findById(numeroPedido).orElseThrow();

        GeoApiContext sc = new GeoApiContext.Builder().apiKey("AIzaSyANLfJ9O8NBmnTjLlfwblSek5kY52og24c").build();

        DirectionsResult result = DirectionsApi.newRequest(sc).
            origin("Belo Horizonte")
            //.destination(new LatLng(pedido.getDestino().getLatitude(), pedido.getDestino().getLongitude()))
            .destination("São Paulo")
            .await();

        
        return result;
    }

    @Override
    public EnderecosEntregaDTO buscarEnderecosEntrega(Long numeroPedido) throws Exception {
    
        PedidoStatus pedido = repository.findById(numeroPedido).
            orElseThrow(() -> new Exception(String.format("Pedido %d não encontrado", numeroPedido)));

        EnderecosEntregaDTO result = new EnderecosEntregaDTO();
        result.setOrigem(pedido.getLocalizacao());
        result.setDestino(pedido.getDestino());
        
        return result;
    }

    
}

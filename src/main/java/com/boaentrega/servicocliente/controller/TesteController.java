package com.boaentrega.servicocliente.controller;


import com.boaentrega.servicocliente.service.RotaService;
import com.google.maps.model.DirectionsResult;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teste2")
public class TesteController {

    private ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private RotaService rotaService;

    @GetMapping
    public String getTeste(){
        return "testando API CLIENTE";
    }

    @GetMapping("/directions")
    @CrossOrigin
    public String getDirections() {
        try{
        DirectionsResult rota = rotaService.buscarRotaEntrega(1L);
        return mapper.writeValueAsString(rota);
        } catch (Exception ex) {

        }
        return "ok";
    }
}

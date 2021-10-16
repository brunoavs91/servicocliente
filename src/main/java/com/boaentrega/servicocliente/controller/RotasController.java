package com.boaentrega.servicocliente.controller;

import javax.ws.rs.PathParam;

import com.boaentrega.servicocliente.model.dto.EnderecosEntregaDTO;
import com.boaentrega.servicocliente.service.RotaService;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rotas")
public class RotasController {

    private ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private RotaService rotaService;

    @GetMapping("/{id}")
    public ResponseEntity<String> getDirections(@PathVariable("id") Long id) {
        try{
            EnderecosEntregaDTO rota = rotaService.buscarEnderecosEntrega(id);
            return ResponseEntity.ok().body(mapper.writeValueAsString(rota));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).build();
        }
    }
}

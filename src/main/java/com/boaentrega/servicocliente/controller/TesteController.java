package com.boaentrega.servicocliente.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teste2")
public class TesteController {



    @GetMapping
    public String getTeste(){
        return "testando API CLIENTE";
    }
}

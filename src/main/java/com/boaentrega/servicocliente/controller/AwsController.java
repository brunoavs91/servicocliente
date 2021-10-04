package com.boaentrega.servicocliente.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aws")
public class AwsController {

    Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private QueueMessagingTemplate queueMessagingTemplate;

    @Value("${cloud.aws.end-point.uri}")
    private String endPoint;

    @GetMapping("/{mensagem}")
    public void enviarMensagemParaFila(@PathVariable String mensagem) {
        queueMessagingTemplate.send(endPoint, MessageBuilder.withPayload(mensagem).build());
    }

}

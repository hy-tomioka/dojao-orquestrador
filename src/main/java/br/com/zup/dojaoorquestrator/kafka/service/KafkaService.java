package br.com.zup.dojaoorquestrator.kafka.service;

import br.com.zup.dojaoorquestrator.kafka.message.TransacaoMessage;

public interface KafkaService {

    void postaEvento(TransacaoMessage value);
}

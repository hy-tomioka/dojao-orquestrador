package br.com.zup.dojaoorquestrator.kafka.service.impl;

import br.com.zup.dojaoorquestrator.kafka.KafkaProducerConfig;
import br.com.zup.dojaoorquestrator.kafka.message.TransacaoMessage;
import br.com.zup.dojaoorquestrator.kafka.service.KafkaService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class CriacaoEventoKafkaService implements KafkaService {

    private final KafkaTemplate<String, TransacaoMessage> producer;

    @Value("${spring.kafka.topic.transactions}")
    private String topic;

    public CriacaoEventoKafkaService(KafkaProducerConfig kafkaProducerConfig) {
        this.producer = kafkaProducerConfig.kafkaTemplate();
    }


    @Override
    public void postaEvento(TransacaoMessage value) {
        producer.send(topic,value);

    }
}

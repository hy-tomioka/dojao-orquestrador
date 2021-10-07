package br.com.zup.dojaoorquestrator.contadigital;

import br.com.zup.dojaoorquestrator.contadigital.request.OperacaoContaRequest;
import br.com.zup.dojaoorquestrator.contadigital.response.OperacaoContaResponse;
import br.com.zup.dojaoorquestrator.contadigital.service.ContaDigitalService;
import br.com.zup.dojaoorquestrator.kafka.service.KafkaService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/orquestrador")
@Validated
public class ContaDigitalController {

    private final ContaDigitalService service;
    private final KafkaService kafkaService;


    public ContaDigitalController(ContaDigitalService service, KafkaService kafkaService) {
        this.service = service;
        this.kafkaService = kafkaService;
    }

    @PostMapping("/contaDigital")
    public ResponseEntity<OperacaoContaResponse> depositoContaDigital(
            @Valid @RequestBody OperacaoContaRequest operacaoContaRequest) {

        var response = service.executaTransacao(operacaoContaRequest);
        kafkaService.postaEvento(response.clientResponseToMessage());


        return ResponseEntity.ok().build();

    }

}

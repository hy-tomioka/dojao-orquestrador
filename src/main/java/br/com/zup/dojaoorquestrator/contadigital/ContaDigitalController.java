package br.com.zup.dojaoorquestrator.contadigital;

import br.com.zup.dojaoorquestrator.contadigital.request.OperacaoContaRequest;
import br.com.zup.dojaoorquestrator.contadigital.response.OperacaoContaResponse;
import br.com.zup.dojaoorquestrator.contadigital.service.ContaDigitalService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/orquestrador")
@Validated
public class ContaDigitalController {

    private final ContaDigitalService service;

    public ContaDigitalController(ContaDigitalService service) {
        this.service = service;
    }

    @PostMapping("/contaDigital")
    public ResponseEntity<OperacaoContaResponse> depositoContaDigital(
            @Valid @RequestBody OperacaoContaRequest operacaoContaRequest) {

        service.executaTransacao(operacaoContaRequest);


        return ResponseEntity.ok().build();
//        git config --get remote.origin.url = Pega a url da branch
//        git reset HEAD~ = volta o commit deixando tudo vermelhinho como modified.
//        git checkout -b feature/conta-digital
    }

}

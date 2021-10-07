package br.com.zup.dojaoorquestrator.contadigital.client;

import br.com.zup.dojaoorquestrator.contadigital.client.request.TransacaoClientRequest;
import br.com.zup.dojaoorquestrator.contadigital.client.response.TransacaoClientResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "contas", url = "${api.conta-digital.url}")
public interface ContaDigitalClient {

    @PostMapping("/contas/{numeroConta}")
    ResponseEntity<TransacaoClientResponse> realizarOperacao(@PathVariable("numeroConta") String numeroConta, @RequestBody TransacaoClientRequest request);

}

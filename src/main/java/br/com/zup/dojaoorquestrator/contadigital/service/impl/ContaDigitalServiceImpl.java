package br.com.zup.dojaoorquestrator.contadigital.service.impl;

import br.com.zup.dojaoorquestrator.contadigital.client.ContaDigitalClient;
import br.com.zup.dojaoorquestrator.contadigital.request.OperacaoContaRequest;
import br.com.zup.dojaoorquestrator.contadigital.response.OperacaoContaResponse;
import br.com.zup.dojaoorquestrator.contadigital.service.ContaDigitalService;
import br.com.zup.dojaoorquestrator.handler.EntityException;
import feign.FeignException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ContaDigitalServiceImpl implements ContaDigitalService {

    private final ContaDigitalClient contaDigitalClient;

    public final Logger LOGGER = LoggerFactory.getLogger(ContaDigitalServiceImpl.class);

    public ContaDigitalServiceImpl(ContaDigitalClient contaDigitalClient) {
        this.contaDigitalClient = contaDigitalClient;
    }

    @Override
    public OperacaoContaResponse executaTransacao(OperacaoContaRequest request) {

        try {
            var response = contaDigitalClient.realizarOperacao(request.getNumeroConta(), request.requestToClientRequest());
            if (response.getBody() != null)
                return response.getBody().clientResponseToOperacaoResponse();
            else
                throw new EntityException(request.getNumeroConta(), "Erro com a conta.");
        } catch (FeignException e) {
            LOGGER.error("Erro com o cliente Feign");
            LOGGER.error("A operacao não pode ser concluída.\n"+e.getMessage());
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, e.getMessage());
        }
    }
}

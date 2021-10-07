package br.com.zup.dojaoorquestrator.contadigital.service;

import br.com.zup.dojaoorquestrator.contadigital.request.OperacaoContaRequest;
import br.com.zup.dojaoorquestrator.contadigital.response.OperacaoContaResponse;

public interface ContaDigitalService {

    OperacaoContaResponse executaTransacao(OperacaoContaRequest request);
}

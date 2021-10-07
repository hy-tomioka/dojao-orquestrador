package br.com.zup.dojaoorquestrator.contadigital.response;

import br.com.zup.dojaoorquestrator.enums.TipoOperacao;
import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.math.BigDecimal;
import java.util.UUID;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class OperacaoContaResponse {
    private String idCliente;

    private String numeroConta;

    private UUID uuidTransacao;

    private BigDecimal valor;

    private TipoOperacao tipoOperacao;

    public OperacaoContaResponse(){}

    public OperacaoContaResponse(String idCliente, String numeroConta, UUID uuidTransacao, BigDecimal valor, TipoOperacao tipoOperacao) {
        this.idCliente = idCliente;
        this.numeroConta = numeroConta;
        this.uuidTransacao = uuidTransacao;
        this.valor = valor;
        this.tipoOperacao = tipoOperacao;
    }


}

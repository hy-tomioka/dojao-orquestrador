package br.com.zup.dojaoorquestrator.contadigital.request;

import br.com.zup.dojaoorquestrator.contadigital.client.request.TransacaoClientRequest;
import br.com.zup.dojaoorquestrator.enums.TipoOperacao;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

public class OperacaoContaRequest {

    @NotBlank
    private String idCliente;
    @NotNull
    private String numeroConta;
    @NotNull @Positive
    private BigDecimal valor;
    @NotNull
    private TipoOperacao tipoOperacao;

    public OperacaoContaRequest(String idCliente, String numeroConta, BigDecimal valor, TipoOperacao tipoOperacao) {
        this.idCliente = idCliente;
        this.numeroConta = numeroConta;
        this.valor = valor;
        this.tipoOperacao = tipoOperacao;
    }

    public TransacaoClientRequest requestToClientRequest(){
        return new TransacaoClientRequest(this.idCliente, this.valor, this.tipoOperacao);
    }

    public String getNumeroConta() {
        return numeroConta;
    }
}

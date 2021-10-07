package br.com.zup.dojaoorquestrator.contadigital.client.response;

import br.com.zup.dojaoorquestrator.contadigital.response.OperacaoContaResponse;
import br.com.zup.dojaoorquestrator.enums.TipoOperacao;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.util.UUID;

public class TransacaoClientResponse {

    private String numeroConta;
    private String idCliente;
    private UUID idTransacao;
    private BigDecimal valor;
    private TipoOperacao tipoTransacao;

    public TransacaoClientResponse(){}

    public TransacaoClientResponse(@NotBlank String numeroConta, @NotBlank String idCliente, @NotNull UUID idTransacao,
                                   @NotNull @Positive BigDecimal valor, @NotNull TipoOperacao tipoTransacao) {
        this.numeroConta = numeroConta;
        this.idCliente = idCliente;
        this.idTransacao = idTransacao;
        this.valor = valor;
        this.tipoTransacao = tipoTransacao;
    }

    public OperacaoContaResponse clientResponseToOperacaoResponse(){
        return new OperacaoContaResponse(this.idCliente, this.numeroConta, this.idTransacao, this.valor, this.tipoTransacao);
    }

    public String getIdConta() {
        return numeroConta;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public void setIdTransacao(UUID idTransacao) {
        this.idTransacao = idTransacao;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public void setTipoTransacao(TipoOperacao tipoTransacao) {
        this.tipoTransacao = tipoTransacao;
    }
}

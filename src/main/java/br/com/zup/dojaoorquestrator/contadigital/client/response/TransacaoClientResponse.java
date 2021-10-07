package br.com.zup.dojaoorquestrator.contadigital.client.response;

import br.com.zup.dojaoorquestrator.contadigital.response.OperacaoContaResponse;
import br.com.zup.dojaoorquestrator.enums.TipoOperacao;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class TransacaoClientResponse {

    private String numeroConta;
    private String idCliente;
    private UUID idTransacao;
    private LocalDateTime dataTransacao;
    private BigDecimal valor;
    private TipoOperacao tipoTransacao;


    public TransacaoClientResponse(@NotBlank String numeroConta, @NotBlank String idCliente, @NotNull UUID idTransacao,
                                   @NotNull LocalDateTime dataTransacao, @NotNull @Positive BigDecimal valor,
                                   @NotNull TipoOperacao tipoTransacao) {
        this.numeroConta = numeroConta;
        this.idCliente = idCliente;
        this.idTransacao = idTransacao;
        this.dataTransacao = dataTransacao;
        this.valor = valor;
        this.tipoTransacao = tipoTransacao;
    }

    public OperacaoContaResponse clientResponseToOperacaoResponse() {
        return new OperacaoContaResponse(this.idCliente, this.numeroConta, this.idTransacao, this.dataTransacao, this.valor,
                this.tipoTransacao);
    }

}

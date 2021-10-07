package br.com.zup.dojaoorquestrator.contadigital.response;

import br.com.zup.dojaoorquestrator.enums.TipoOperacao;
import br.com.zup.dojaoorquestrator.kafka.message.TransacaoMessage;
import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class OperacaoContaResponse {
    private String idCliente;

    private String numeroConta;

    private UUID uuidTransacao;

    private LocalDateTime dataTransacao;

    private BigDecimal valor;

    private TipoOperacao tipoOperacao;

    public OperacaoContaResponse(){}

    public OperacaoContaResponse(String idCliente, String numeroConta, UUID uuidTransacao, LocalDateTime dataTransacao,
                                 BigDecimal valor, TipoOperacao tipoOperacao) {
        this.idCliente = idCliente;
        this.numeroConta = numeroConta;
        this.uuidTransacao = uuidTransacao;
        this.dataTransacao = dataTransacao;
        this.valor = valor;
        this.tipoOperacao = tipoOperacao;
    }

    public TransacaoMessage clientResponseToMessage() {
        return new TransacaoMessage(this.tipoOperacao, this.valor, this.dataTransacao, this.idCliente, this.numeroConta);
    }

}

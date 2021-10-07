package br.com.zup.dojaoorquestrator.kafka.message;

import br.com.zup.dojaoorquestrator.enums.TipoOperacao;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransacaoMessage {
    private TipoOperacao operacao;

    private BigDecimal valor;

    private LocalDateTime data;

    private String idCliente;

    private String numeroConta;

    public TransacaoMessage(){}

    public TransacaoMessage(TipoOperacao operacao, BigDecimal valor, LocalDateTime data, String idCliente, String numeroConta) {
        this.operacao = operacao;
        this.valor = valor;
        this.data = data;
        this.idCliente = idCliente;
        this.numeroConta = numeroConta;
    }

    public void setOperacao(TipoOperacao operacao) {
        this.operacao = operacao;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }
}

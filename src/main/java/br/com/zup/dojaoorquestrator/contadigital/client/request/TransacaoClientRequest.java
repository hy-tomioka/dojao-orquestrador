package br.com.zup.dojaoorquestrator.contadigital.client.request;

import br.com.zup.dojaoorquestrator.enums.TipoOperacao;

import java.math.BigDecimal;

public class TransacaoClientRequest {
    private String idCliente;
    private BigDecimal valor;
    private TipoOperacao tipoTransacao;

    public TransacaoClientRequest(String idCliente, BigDecimal saldo, TipoOperacao tipoOperacao) {
        this.idCliente = idCliente;
        this.valor = saldo;
        this.tipoTransacao = tipoOperacao;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public TipoOperacao getTipoTransacao() {
        return tipoTransacao;
    }
}

package br.com.zup.dojaoorquestrator.handler;

public class EntityException extends RuntimeException {

    private String attribute;

    private String erro;

    public EntityException(String attribute, String erro) {
        this.attribute = attribute;
        this.erro = erro;
    }

    public String getAttribute() {
        return attribute;
    }

    public String getErro() {
        return erro;
    }
}

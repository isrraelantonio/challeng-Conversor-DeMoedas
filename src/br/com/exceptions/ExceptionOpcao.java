package br.com.exceptions;

public class ExceptionOpcao extends RuntimeException {
    String mensagem;
    public ExceptionOpcao(String message) {
        this.mensagem =  message;

    }

    @Override
    public String getMessage() {
        return this.mensagem;
    }
}

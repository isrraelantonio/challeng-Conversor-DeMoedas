package br.com.exceptions;

public class ExceptionConversor extends RuntimeException {
     private String mensagem = "Verifique a conexão da internet";
    public ExceptionConversor(String messagem) {
        this.mensagem = messagem;

    }

  @Override
  public String getMessage() {
    return this.mensagem;
  }
}

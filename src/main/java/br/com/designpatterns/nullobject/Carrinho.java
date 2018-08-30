package br.com.designpatterns.nullobject;

public class Carrinho {
    private String nomeUsuario;
    private double valor;
    private double tamanho;

    public Carrinho(){}

    public Carrinho(String nomeUSuario, double valor, double tamanho) {
        this.nomeUsuario = nomeUSuario;
        this.valor = valor;
        this.tamanho = tamanho;
    }

    public String getNomeUSuario() {
        return nomeUsuario;
    }

    public void setNomeUSuario(String nomeUSuario) {
        this.nomeUsuario = nomeUSuario;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getTamanho() {
        return tamanho;
    }

    public void setTamanho(double tamanho) {
        this.tamanho = tamanho;
    }
}

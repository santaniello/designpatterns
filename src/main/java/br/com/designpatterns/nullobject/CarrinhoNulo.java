package br.com.designpatterns.nullobject;

public class CarrinhoNulo extends Carrinho{

    public String getNomeUSuario() {
        return "Usuario_Default";
    }

    public double getValor() {
        return 0.0;
    }

    public double getTamanho() {
        return 0;
    }
}

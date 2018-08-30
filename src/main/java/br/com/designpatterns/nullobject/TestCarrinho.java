package br.com.designpatterns.nullobject;

public class TestCarrinho {
    public static void main(String[] args) {
        Carrinho carrinho = CarrinhoFactory.buildCarrinho(null);
        System.out.println(carrinho.getNomeUSuario());
    }
}

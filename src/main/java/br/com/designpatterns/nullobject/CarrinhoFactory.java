package br.com.designpatterns.nullobject;

public class CarrinhoFactory {

    public static Carrinho buildCarrinho (String nomeUsuario){
        if (nomeUsuario == null) {
            return new CarrinhoNulo();
        }
        return new Carrinho(nomeUsuario,2,3);
    }
}

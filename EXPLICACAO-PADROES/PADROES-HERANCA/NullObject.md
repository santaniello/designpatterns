# Null Object

O padrão Null Object propõe a criação de uma classe para representar
objetos nulos em uma aplicação. Essa classe deve estender a classe original e imple-
mentar seus métodos de forma a executar o comportamento esperado da aplicação
quando um valor nulo for recebido. Dessa forma, em vez de se retornar um valor
nulo, retorna-se uma instância dessa nova classe.

Abaixo, segue o exemplo de uma bean:

```java
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
```
A classe abaixo implementa o padrão Null Object:

```java
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
```
Abaixo, segue uma classe Factory responsável pela criacação de um Carrinho ***(repare que ela devolve a instância de um CarrinhoNulo e não null na criação).***

```java
public class CarrinhoFactory {
    public static Carrinho buildCarrinho (String nomeUsuario){
        if (nomeUsuario == null) {
         // No lugar de devolver nulo, devolvemos uma intância da classe CarrinhoNulo
            return new CarrinhoNulo(); 
        }
        return new Carrinho(nomeUsuario,2,3);
    }
}
```
```java 
public class TestCarrinho {
    public static void main(String[] args) {
        Carrinho carrinho = CarrinhoFactory.buildCarrinho(null);
        System.out.println(carrinho.getNomeUSuario());
    }
}
```

O padrão NullObject exemplifica bem o Principio de Substituição de Liskov, que defende que se 
uma classe é um subtipo de outra, então os objetos dessa classe podem ser substituidos pelos objetos 
do subtipo sem que seja necessário alterar propriedades do programa. 



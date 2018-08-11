# Padrão Strategy

***Problema:*** Considere o sistema de um estacionamento que precisa utilizar diversos critérios 
para calcular o valor que deve ser cobrado de seus clientes. Para um veículo
de passeio, o valor deve ser calculado como R$2,00 por hora, porém, caso o tempo
seja maior do que 12 horas, será cobrada uma taxa diária, e caso o número de dias
for maior que 15 dias, será cobrada uma mensalidade. Existem também regras diferentes
para caminhões, que dependem do número de eixos e do valor da carga
carregada, e para veículos para muitos passageiros, como ônibus e vans. O código a
seguir apresenta um exemplo de como isto estava desenvolvido.

```java
public class ContaEstacionamento {
    private Veiculo veiculo;
    private long inicio, fim;
    public double valorConta() {
        long atual = (fim==0) ? System.currentTimeMillis() : fim;
        long periodo = inicio - atual;
        if (veiculo instanceof Passeio) {
            if (periodo < 12 * HORA) {
                return 2.0 * Math.ceil(periodo / HORA);
            } else if (periodo > 12 * HORA && periodo < 15 * DIA) {
                return 26.0 * Math.ceil(periodo / DIA);
            } else {
                return 300.0 * Math.ceil(periodo / MES);
            }
        } else if (veiculo instanceof Carga) {
            // outras regras para veículos de carga
        }
}
```


***Definição do Strategy:*** O Strategy é um padrão que deve ser utilizado quando uma classe possuir
diversos algoritmos que possam ser utilizados de forma intercambiável. ***A solução
proposta pelo padrão consiste em delegar a execução do algoritmo para uma instância que compõe a classe principal.
Dessa forma, quando a funcionalidade for invocada, no momento de execução do algoritmo, será invocado um 
método da instância que a compõe.*** 

***Estrutura Básica do Strategy:***

![Strategy-Basic](../IMAGES/strategy2.png)


### Exemplo de uso do Strategy:

![Teste](../IMAGES/strategy.png)

```java
public class ContaEstacionamento {
    private CalculoValor calculo; // Classe que compõe a classe ContaEstacionamento
    private Veiculo veiculo;
    private long inicio;
    private long fim;
    
    public double valorConta() {
       return calculo.calcular(fim-inicio, veiculo);
    }

    public void setCalculo(CalculoValor calculo){
        this.calculo = calculo;
    }
}
```
```java
public interface CalculoValor{
    double calcular();
}
```
A seguir, a classe CalculoDiaria mostra um exemplo de uma classe que faz
o cálculo da tarifa por dia. Observe que essa classe possui um atributo que pode ser
utilizado para parametrizar partes do algoritmo. Dessa forma, quando a estratégia
for alterada para o calculo do valor por dia, basta inserir a instância dessa classe em ContaEstacionamento . Vale também ressaltar que essa mesma classe pode ser
reaproveitada para diferentes empresas em diferentes momentos, evitando assim a
duplicação de código. Essa classe compõe a classe ***ContaEstacionamento.***

```java
public class CalculoDiaria implements CalculoValor {
    private double valorDiaria;
    public CalculoDiaria(double valorDiaria){
        this.valorDiaria = valorDiaria;
    }
    public double calcular() {
        return valorDiaria * Math.ceil(periodo / HORA);
    }
}
```

### Consequências da utilização do padrão:

- No caso do Strategy , a principal consequência positiva é
justamente o fato de o algoritmo poder ser alterado sem a modificação da classe. A
partir dessa estrutura, novas implementações dele podem ser criadas e introduzidas
posteriormente.
- Outro ponto positivo do padrão está no fato da lógica condicional na classe principal
ser reduzida. Como a escolha do algoritmo está na implementação do objeto
que está compondo a classe, isso elimina a necessidade de ter condicionais para selecionar
a lógica a ser executada. Outra consequência positiva está no fato de a implementação
poder ser trocada em tempo de execução, fazendo que o comportamento da classe possa ser trocado dinamicamente.
- Um ponto negativo no caso do Strategy , é que acontece um aumento da complexidade na criação do objeto,
pois a instância da dependência precisa ser criada e configurada. Caso o atributo seja nulo, a classe pode
apresentar um comportamento inesperado. Outro problema
dessa solução está no aumento do número de classes: há uma para cada algoritmo,
criando uma maior dificuldade em seu gerenciamento.


### O que é composição?

***Definição:*** Uma classe  delega uma determinada lógica para a instância de uma
classe que a compõe. Dessa forma, para trocar um determinado comportamento, 
basta trocar a classe que a está compondo.
           
### O resultado de usar composição

- Em vez de codificar um comportamento estaticamente, definimos pequenos comportamentos padrão e usamos composição para definir comportamentos mais complexos
- De forma geral, a composição é melhor do que herança normalmente, pois:
  - Permite mudar a associação entre classes em tempo de execução;
  - Permite que um objeto assuma mais de um comportamento (ex. papel);
  - Herança acopla as classes demais e engessa o programa;

Links: 

- http://www.inf.pucrs.br/~flash/programming/aula_compostos_java.html#(1)
           


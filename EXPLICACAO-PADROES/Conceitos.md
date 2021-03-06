# Conceitos de Orientação a Objetos

***Interface ou classe abstrata?***

Quando devo utilizar uma classe abstrata e quando devo utilizar uma interface?
R: Tanto as classes abstratas quanto as interfaces podem definir métodos abstratos que pre-
cisam ser implementados pelas classes que respectivamente a estende ou
implementa. Porém apenas as classes abstratas podem possuir métodos
concretos e atributos. Apesar dessa diferença, a resposta para pergunta é
mais conceitual do que relacionada com questões de linguagem.
Quando a abstração que precisar ser criada for um conceito, ou seja,
algo que possa ser refinado e espacializado, deve-se utilizar uma classe
abstrata. Quando a abstração é um comportamento, ou seja, algo que
uma classe deve saber fazer, então a melhor solução é a criação de uma
interface. Imagine um jogo no qual existem naves que se movem. Se
sua abstração representa uma nave, então você está representando um
conceito e deve utilizar uma classe abstrata. Por outro lado, se sua abs-
tração representa algo que se move, então o que está sendo abstraído é
um comportamento e a melhor solução é usar uma interface.

***A importância do Reuso da Herança***

O potencial do reuso através de herança pode estar sim no reúso de código da superclasse, 
porém não é com a subclasse chamando métodos da superclasse, mas com a superclasse chamando 
código da subclasse. Quando um método da superclasse chama um método que pode ou deve ser 
implementado na subclasse, isso permite que um mesmo algoritmo possa ser reutilizado com pas-
sos alterados. Essa flexibilidade aumenta o potencial de reutilização pois permite a
sua adaptação para necessidades mais específicas.

***Revisitando Modificadores de acesso***

- abstract : Um método abstrato precisa obrigatoriamente ser implementado
em uma subclasse concreta. Isso significa que esse é um hook method que foi
definido na superclasse e obrigatoriamente precisa ser definido.

- final : De forma contrária, um método do tipo final não pode ser sobrescrito
pelas subclasses e por isso nunca irá representar um hook method. Esses mé-
todos representam funcionalidades da classe que precisam ser imutáveis para
seu bom funcionamento. Costumam ser os métodos que invocam os hook
methods.

- private : Os métodos privados só podem ser invocados dentro da classe que
são definidos. Dessa forma, eles representam métodos de apoio internos da
classe e nunca poderão ser substituídos pela subclasse como um hook method.

- protected e public : Todos os métodos públicos e protegidos, desde que
não sejam final , são candidatos a hook method. É isso mesmo! Qualquer
método que pode ser sobrescrito na subclasse pode ser utilizado para a in-
serção de comportamento. Algumas classes possuem implementações vazias
para esses métodos, o que faz com que sejam hook methods com implementa-
ção opcional pelas subclasses.



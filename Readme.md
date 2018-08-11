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
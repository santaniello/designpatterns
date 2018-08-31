# Template Method

um Template Method é um modelo de algoritmo que possui algumas partes fixas e algumas
partes variáveis. As partes variáveis são lacunas que precisam ser completadas para que
o algoritmo faça realmente sentido. As lacunas são representadas como hook methods que 
podem ser implementados nas subclasses. Caso seja uma lacuna obrigatória, o método deve 
ser definido como abstrato e caso a implementação seja opcional, o método pode ser concreto
e normalmente possui uma implementação vazia. O algoritmo é representado através de um método
na superclasse que coordena a execução dos hook methods.

A Figura a seguir apresenta a estrutura do padrão Template Method . A
ClasseAbstrata representa a superclasse que implementa o TemplateMethod
e que define quais são os hook methods. A ClasseConcreta representa a classe
que herda o Template Method da ClasseAbstrata e define uma implemen-
tação concreta dos hook methods. A classe representada como Cliente invoca o
metodoTemplate() . Observe que apesar do tipo da variável ser do tipo da classe
abstrata, o tipo instanciado é o da subclasse que implementa os passos concretos do
algoritmo.

![Template-Methods](../../IMAGES/templatemethod.png)

***Exemplo de TemplateMethod em Java***

```java

/* Classe abstrata que implementa o padrão TemplateMethod*/

public abstract class GeradorArquivo {
    // Método Template
    public final void gerarArquivo(String nome, Map<String, Object> propriedades) throws IOException {
        String conteudo = gerarConteudo(propriedades);
        byte[] bytes = conteudo.getBytes();
        bytes = processar(bytes);
        FileOutputStream fileout = new FileOutputStream(nome);
        fileout.write(bytes);
        fileout.close();
    }

    /*
    * Nesse caso, a implementação do método opcional pelas subclasses...
    * */
    protected byte[] processar(byte[] bytes) throws IOException {
        return bytes;
    }

    /*
     * Nesse caso, a implementação do método é obrigatória pelas subclasses pois ele é abstrato...
     * */
    protected abstract String gerarConteudo(Map<String, Object> propriedades);

}

```

```java

public class GeradorPropriedadesCriptografado extends GeradorArquivo {
    private int delay;

    public GeradorPropriedadesCriptografado(int delay) {
        this.delay = delay;
    }

    protected byte[] processar(byte[] bytes) throws IOException {
        byte[] newBytes = new byte[bytes.length];
        for(int i=0;i<bytes.length;i++){
            newBytes[i]= (byte) ((bytes[i]+delay) % Byte.MAX_VALUE);
        }
        return newBytes;
    }

    protected String gerarConteudo(Map<String, Object> props) {
        StringBuilder propFileBuilder = new StringBuilder();
        for(String prop : props.keySet()){
            propFileBuilder.append(prop+"="+props.get(prop)+"\n");
        }
        return propFileBuilder.toString();
    }
}

```

```java 

public class GeradorXMLCompactado extends GeradorArquivo {
    protected byte[] processar(byte[] bytes) throws IOException {
        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
        ZipOutputStream out = new ZipOutputStream(byteOut);
        out.putNextEntry(new ZipEntry("internal"));
        out.write(bytes);
        out.closeEntry();
        out.close();
        return byteOut.toByteArray();
    }

    protected String gerarConteudo(Map<String, Object> props) {
        StringBuilder propFileBuilder = new StringBuilder();
        propFileBuilder.append("<properties>");
        for(String prop : props.keySet()){
            propFileBuilder.
            append("<"+prop+">"+props.get(prop)+"</"+prop+">");
        }
        propFileBuilder.append("</properties>");
        return propFileBuilder.toString();
    }
}

```

```java

public class TestTemplateMethod {
    public static void main(String[] args) {
        GeradorArquivo gerador = new GeradorXMLCompactado();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("teste", "teste");
        try {
            gerador.gerarArquivo("teste",map);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

```

### Consequências do Uso do Template Method

O uso da herança nesse padrão também traz algumas limitações. A primeira é que a herança
"é uma carta que só pode ser jogada uma vez”, isso significa que uma classe que precise de
comportamentos de duas outras classes só poderá fazer o uso da herança para uma delas.
Outra questão é que depois que uma implementação for instanciada não será mais possível
alterar os passos do algoritmo.
Ao utilizar um padrão, é preciso avaliar para os requisitos de sua aplicação quais
consequências pesam mais ou menos. A partir dessas informações é possível decidir
se seu uso será ou não adequado. Ressalto que o maior problema de uma solução
que possui limitações é quando elas são desconhecidas pelo desenvolvedores, pois
quando se tem consciência de sua existência é possível gerenciar o risco ou tratá-las,
muitas vezes a partir de outros padrões.
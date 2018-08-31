package br.com.designpatterns.templatemethod;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

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
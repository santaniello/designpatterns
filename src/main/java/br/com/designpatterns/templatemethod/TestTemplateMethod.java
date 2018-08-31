package br.com.designpatterns.templatemethod;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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

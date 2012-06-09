package br.com.javaframeworks.freemarker;

import java.io.*;
import java.util.*;

import br.com.javaframeworks.freemarker.model.Animal;
import freemarker.template.*;

public class Init {

    public static void main(String[] args) throws Exception {

    	/* ----------------------------------------------------------------------------- */    
        /* Você deve fazer isso apenas UMA VEZ para todo ciclo de vida da aplicação:     */    
        /* Cria e ajusta as configurações */
        Configuration cfg = new Configuration();
        cfg.setDirectoryForTemplateLoading(new File("src/main/resources/templates"));
        cfg.setObjectWrapper(new DefaultObjectWrapper());

        /* ----------------------------------------------------------------------------- */    
        /* Geralmente você fará isso muitas vezes durante o ciclo de vida da aplicação:  */    
                
        /* Recupera ou cria um template */
        Template temp = cfg.getTemplate("exemplo.ftl");

        /* Cria um modelo de dados. Lembrando que o freemaker pego o objeto "root" como início do parser */
        Map<Object,Object> root = new HashMap<Object,Object>();
        root.put("usuario", "Andre Castro");
        
        List<Animal> animais = new ArrayList<Animal>();
        animais.add(new Animal("pastor alemão", 1200.0));
        animais.add(new Animal("pardal", 30.0));
        root.put("animais", animais);
        
        /* Executa merge do modelo de dados com o template */
        Writer out = new OutputStreamWriter(System.out);
        temp.process(root, out);
        out.flush();
        
    }
}

package br.com.modelos;

import br.com.cabecalhos.CabecalhoMoedaEJson;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.stream.Collectors;

public class MoedaEJson {
     private String  moeda;
     private Object  moedasConvertidas;


    public MoedaEJson(CabecalhoMoedaEJson conversoes) {
        this.moedasConvertidas = conversoes.conversion_rates();
        this.moeda = conversoes.base_code();
    }

    public Object getMoedasConvertidas() {
        return moedasConvertidas;
    }

    public String getMoeda() {
        return moeda;
    }

    public  void criararStringJson(Object conversoes) throws IOException {
        FileWriter novoArquivo = new FileWriter("moedasConvertidas.json");
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        novoArquivo.write(gson.toJson(conversoes));
        novoArquivo.close();

    }

    public String  criararquivo() throws FileNotFoundException {
        BufferedReader arquivo = new BufferedReader(new FileReader("C:\\Users\\Israel\\IdeaProjects\\challengConversorDeMoedas\\moedasConvertidas.json"));
        String arquivoJs = arquivo.lines().collect(Collectors.joining());
        return  arquivoJs;
    }


}

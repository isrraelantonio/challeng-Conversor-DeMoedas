package br.com.modelos;

import br.com.cabecalhos.CabecalhoconversoesDaMoeda;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.stream.Collectors;

public class ConversoesDaMoeda {
    private double moedaBrasileira;
    private double dolar;
    private double pesoArgentino;
    private double pesoColombiano;

    public ConversoesDaMoeda(CabecalhoconversoesDaMoeda moedaconvertida) {
        this.moedaBrasileira = Double.parseDouble(moedaconvertida.BRL())  ;
        this.dolar = Double.parseDouble(moedaconvertida.USD());
        this.pesoArgentino = Double.parseDouble(moedaconvertida.ARS());
        this.pesoColombiano = Double.parseDouble(moedaconvertida.COP());

    }

    public double getMoedaBrasileira() {
        return moedaBrasileira;
    }

    public double getDolar() {
        return dolar;
    }

    public double getPesoArgentino() {
        return pesoArgentino;
    }

    public double getPesoColombiano() {
        return pesoColombiano;
    }

    public double calculoDeMoedas(double valorinserido, double moeda){
          double resultado =  valorinserido * moeda;
          return  resultado;
    }

    public void respostaConvertida(double valorinserido, String moedaconversao, String moedaconvertida, double resultado){
         System.out.println("O valor de " + valorinserido + moedaconversao + "convertido para a " + moedaconvertida + " é de  " + resultado);
    }

}

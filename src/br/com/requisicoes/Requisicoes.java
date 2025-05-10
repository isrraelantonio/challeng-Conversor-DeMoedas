package br.com.requisicoes;

import br.com.exceptions.ExceptionConversor;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.InputMismatchException;

public class Requisicoes {

   public  String ConsultarMoeda(String busca) throws IOException, InterruptedException {

       HttpClient client = HttpClient.newHttpClient();
       HttpRequest request = HttpRequest.newBuilder()
               .uri( URI.create("https://v6.exchangerate-api.com/v6/49741fec92fc2ecb233e551a/latest/" + busca))
               .build();

                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

                String json = response.body();
                if(response.statusCode() == 404){
                       System.out.println("Verifique a conexão com a internet");
                }
                return json;


   }

}

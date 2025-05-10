import br.com.cabecalhos.CabecalhoMoedaEJson;
import br.com.cabecalhos.CabecalhoconversoesDaMoeda;
import br.com.exceptions.ExceptionOpcao;
import br.com.modelos.ConversoesDaMoeda;
import br.com.modelos.MenuUsuario;
import br.com.requisicoes.Requisicoes;
import br.com.modelos.MoedaEJson;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;


public class PrincipalExecuta {
    public static void main(String[] args) throws IOException, InterruptedException {

String sair = "";

        while (!sair.equals("sair") ) {

            MenuUsuario menu = new MenuUsuario();
            menu.menu();

            Scanner leitura = new Scanner(System.in);
            Gson gson = new GsonBuilder().setPrettyPrinting().create();


            int opcao = 0;



            try {
                System.out.println("digite uma opção");
                opcao = leitura.nextInt();


            } catch (InputMismatchException e) {
                System.out.println("digite uma opção válida");
            }

                String busca = "br";
                String moedaconversao = "";

                double resultado = 0;


                if (opcao >= 1 & opcao <= 7) {


                    if (opcao == 1 || opcao == 3 || opcao == 5) {
                        busca = "USD";
                        moedaconversao = " (USD) da moeda amreicana ";
                    } else if (opcao == 2) {
                        busca = "ARS";
                        moedaconversao = " (ARS) da moeda argentina ";
                    } else if (opcao == 4) {
                        busca = "BRL";
                        moedaconversao = " (BRL) da moeda brasileira ";
                    } else if (opcao == 6) {
                        busca = "COP";
                        moedaconversao = " (COP) da moeda colombiana ";
                    } else if (opcao == 7) {
                        sair = "sair";
                    }


                    while (!sair.equals("sair")) {

                        double valorInserido = 0;

                    try {
                        System.out.println("Insira um valor.");
                        valorInserido = leitura.nextDouble();


                        Requisicoes novaRequisicao = new Requisicoes();
                        String json = novaRequisicao.ConsultarMoeda(busca.toLowerCase());


                        CabecalhoMoedaEJson objetoJson = gson.fromJson(json, CabecalhoMoedaEJson.class);
                        MoedaEJson objetoMoeda = new MoedaEJson(objetoJson);


                        objetoMoeda.criararStringJson(objetoMoeda.getMoedasConvertidas());

                        CabecalhoconversoesDaMoeda moedasConvertidas = gson.fromJson(objetoMoeda.criararquivo(), CabecalhoconversoesDaMoeda.class);
                        ConversoesDaMoeda moedasValores = new ConversoesDaMoeda(moedasConvertidas);

                        String moedaConveritda = "";

                        switch (opcao) {

                            case 2, 4, 6:
                                moedaConveritda = "moeda americana (USD)";
                                resultado = moedasValores.calculoDeMoedas(valorInserido, moedasValores.getDolar());
                                break;
                            case 1:
                                moedaConveritda = "moeda argentina (ARS)";
                                resultado = moedasValores.calculoDeMoedas(valorInserido, moedasValores.getPesoArgentino());
                                break;
                            case 3:
                                moedaConveritda = "moeda brasileira (BRL)";
                                resultado = moedasValores.calculoDeMoedas(valorInserido, moedasValores.getMoedaBrasileira());
                                break;
                            case 5:
                                moedaConveritda = "moeda colombiana (COP)";
                                resultado = moedasValores.calculoDeMoedas(valorInserido, moedasValores.getPesoColombiano());
                                break;

                        }

                        moedasValores.respostaConvertida(valorInserido, moedaconversao, moedaConveritda, resultado);


                    } catch (InputMismatchException e) {
                        System.out.println("digite um valor válido");
                    }
                    }
                }else{
                        System.out.println("Digite uma opção válida");
                    }


        }
        System.out.println("Fim do programa.");


    }
}
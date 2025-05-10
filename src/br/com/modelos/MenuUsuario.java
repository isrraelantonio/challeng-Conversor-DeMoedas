package br.com.modelos;

public class MenuUsuario {

    public void menu(){
        System.out.println("*********************************************************");
        System.out.println(
                """
                        SEJA BEM VINDO(A) AO CONVERSOR DE MOEDAS   :)              
                        
                        Escolha a opção para a conversão:
                            1 -- Dólar --> Peso argentino;
                            2 -- Peso argentino --> Dólar;
                            3 -- Dólar --> Real brasileiro;
                            4 -- Real brasileiro --> Dólar;
                            5 -- Dólar --> Peso colombiano;
                            6 -- Peso colombiano --> Dólar;
                            7 -- Sair
                        
                            OBS: Escolha uma opção válida.         
                        
                        """
        );
    }
}

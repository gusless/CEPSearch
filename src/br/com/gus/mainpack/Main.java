package br.com.gus.mainpack;

import br.com.gus.functions.ConvertToJson;
import br.com.gus.functions.SearchAddress;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scan = new Scanner(System.in);
        String cep = "";
        SearchAddress searchAddress = new SearchAddress();

        while (true) {
            System.out.println("Digite um CEP ou digite \"close\" para encerrar a busca:");
            cep = scan.nextLine();
            if (cep.equalsIgnoreCase("close") || cep.equalsIgnoreCase("sair")){
                System.out.println("Encerrando processo, digite o nome do arquivo a ser criado:");
                String filename = scan.nextLine();
                ConvertToJson toJson = new ConvertToJson(searchAddress.getAddressList(), filename);
                break;
            }
            searchAddress.search(cep);
            System.out.println("----------------------------------------------------------------------\n");
        }
    }
}

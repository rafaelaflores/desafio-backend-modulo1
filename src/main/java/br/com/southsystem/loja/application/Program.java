package br.com.southsystem.loja.application;
import java.io.IOException;
import java.util.Scanner;

import br.com.southsystem.loja.entities.*;

public class Program {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        ItemMenu[] menu = new ItemMenu[] {
                new InserirProduto(),
                new ListarProduto(),
                new EditarProduto(),
                new RemoverProduto(),
                new ImportarProdutos(),
                new Sair()  //criar exceção para opção digitada errado
        };
        boolean sair = false; //quando retornar verdadeiro ele sai do laço
        do {
            System.out.println("\n+------------------------------------------+");
            System.out.println("|          Sistema de Loja +PraTI          |");
            System.out.println("+------------------------------------------+");
            for (int i = 0; i < menu.length; i++) { //uso do length porque nao temos um tamanho exato para o vetor
                System.out.println("| [" + i + "] " + menu[i].getOpcao() + "               |");
            }
            System.out.println("+------------------------------------------+");
            System.out.print("\nEscolha uma opção: ");
            int opcao = Integer.parseInt(entrada.nextLine());
            System.out.print("Você deseja continuar (Sim/Não)? ");
            String continuar = entrada.nextLine();
            if(continuar.equals("Sim")) {
                try {
                    sair = menu[opcao].executar();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } while(!sair);
    }
}

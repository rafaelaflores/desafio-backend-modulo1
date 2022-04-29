package br.com.southsystem.loja.application;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import br.com.southsystem.loja.controller.ProdutoController;
import br.com.southsystem.loja.controller.dao.ProdutoDao;
import br.com.southsystem.loja.view.*;

public class Program {
    public static void main(String[] args) throws IOException {
        Scanner entrada = new Scanner(System.in);
        MainMenuView mainMenuView = new MainMenuView();
        ProdutoDao dao = new ProdutoDao();
        ProdutoView produtoView = new ProdutoView();
        ProdutoController produtoController = new ProdutoController(dao, mainMenuView, produtoView);
        while(true) {
            System.out.println(mainMenuView.cabecalho());

            Map<Integer, String> menus = new HashMap<>();
            menus.put(1, "Adicionar produto");
            menus.put(2, "Editar produto");
            menus.put(3, "Remover produto");
            menus.put(4, "Importar mostruário");
            menus.put(0, "Sair do programa");

            mainMenuView.menu(menus);
            int opcao = Integer.parseInt(entrada.nextLine());

            switch (opcao) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    produtoController.adicionarProduto();
                    break;
                case 2:
                    produtoController.editarProduto();
                    break;
                case 3:
                    produtoController.removerProduto();
                    break;
                case 4:
                    produtoController.importarProduto();
                    break;
                default:
                    System.out.println("\nOpção Inválida\n");
            }
        }
    }
}

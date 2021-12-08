package br.com.southsystem.loja.entities;
import br.com.southsystem.loja.model.Produto;
import java.io.IOException;
import java.util.Scanner;
import java.io.*;

public class InserirProduto extends ItemMenu {
    @Override
    public String getOpcao() { //mostra a opcao escolhida
        return "Adicionar produto\t\t";
    }
    @Override
    public boolean executar() throws IOException {
        Scanner entrada = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new FileWriter("produtos.csv",true));
        //exceção: e se o produto já existir na lista?

        ListarProduto listar = new ListarProduto();
        listar.executar();
        System.out.println("\nADICIONAR NOVO PRODUTO");
            System.out.print("Digite o código do produto: ");
            String codigo = entrada.nextLine();
            System.out.print("\nDigite o nome do produto: ");
            String nome = entrada.nextLine();
            System.out.print("\nDigite a categoria do produto: ");
            String categoria = entrada.nextLine();
            System.out.print("\nDigite o preço do produto: ");
            double preco = Double.parseDouble(entrada.nextLine());
            System.out.print("\nDigite a quantidade do produto em estoque: ");
            int qntEstoque = Integer.parseInt(entrada.nextLine());

            bw.write(codigo +","+ nome +","+ categoria.toUpperCase() +","+ preco +","+ qntEstoque);
            bw.flush();
            bw.newLine();
            bw.close();

            Produto produto = new Produto(codigo, nome, categoria, preco, qntEstoque); //cria o objeto produto com os dados acima
            dao.inserir(produto);

            System.out.println("\nProduto cadastrado!\n");


        return false; //retornar falso para o programa não encerrar, retornar verdadeiro para sair
    }
}

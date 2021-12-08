package br.com.southsystem.loja.entities;
import br.com.southsystem.loja.dao.Dao;
import br.com.southsystem.loja.dao.ProdutosDao;
import br.com.southsystem.loja.model.Produto;
import java.util.*;
import java.io.IOException;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ListarProduto extends ItemMenu{
    @Override
    public String getOpcao() {
        return "Listar produtos\t\t";
    }
    @Override
    public boolean executar() throws IOException {
        Scanner entrada = new Scanner(System.in);
        Dao dao = new ProdutosDao();
        ArrayList<Produto> produto = dao.listar();
        BufferedReader br = new BufferedReader(new FileReader("produtos.csv"));
        String registro;

            System.out.print("LISTA DE PRODUTOS\n");
            while ((registro = br.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(registro, ",");
                    System.out.println("Código do Produto: " + st.nextToken()
                            + "\nProduto: " + st.nextToken()
                            + "\nCategoria: " + st.nextToken()
                            + "\nPreço: R$" + st.nextToken()
                            + "\nQuantidade em estoque: " + st.nextToken()
                            + "\n");
            }
            br.close();
            return false;
        }
}


package br.com.southsystem.loja.entities;
import br.com.southsystem.loja.model.Produto;

import java.io.*;
import java.io.IOException;
import java.util.Scanner;

public class RemoverProduto extends ItemMenu{
    @Override
    public String getOpcao() {
        return "Remover produto\t\t";
    }

    @Override
    public boolean executar() throws IOException {
        Scanner entrada = new Scanner(System.in);
        ListarProduto listar = new ListarProduto();
        listar.executar();
        String record;

        File tempDB = new File("produtostemp.csv");
        File db = new File("produtos.csv");

        BufferedReader br = new BufferedReader(new FileReader(db));
        BufferedWriter bw = new BufferedWriter(new FileWriter(tempDB));

        System.out.println("REMOVER PRODUTO");
        System.out.print("Digite o código do produto que você deseja remover: ");
        String codigo = entrada.nextLine();
        Produto produto = dao.pesquisar(codigo);

        if (produto != null) {
            dao.remover(produto);
        }

        while((record = br.readLine()) != null ) {
            if(record.contains(codigo)) {
                continue;
            }
            bw.write(record);
            bw.flush();
            bw.newLine();
        }
        br.close();
        bw.close();
        db.delete();

        boolean successo = tempDB.renameTo(db);
        if (successo) {
            System.out.print("\nProduto Removido!\n");
        }

        return false;
    }
}

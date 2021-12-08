package br.com.southsystem.loja.entities;
import java.io.*;
import java.util.Scanner;

public class ImportarProdutos extends ItemMenu {
    @Override
    public String getOpcao() {
        return "Importar mostruário\t";
    }

    @Override
    public boolean executar() throws IOException {
        ListarProduto listar = new ListarProduto();
        listar.executar();
        File db = new File("produtos.csv");
        BufferedWriter bw = new BufferedWriter(new FileWriter(db));

        Scanner entrada = new Scanner(System.in);

        System.out.print("\nInforme o nome do arquivo a ser importado: ");
        String nome = entrada.nextLine();
        File tempDB = new File(nome);
        BufferedReader br = new BufferedReader(new FileReader(tempDB));

        System.out.print("\nConteúdo do arquivo:\n");
        String registro;
        while ((registro = br.readLine()) != null) {
                System.out.println(registro);
                bw.write(registro);
                bw.flush();
                bw.newLine();
        }
        bw.close();
        br.close();
        return false;
    }
}

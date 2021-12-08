package br.com.southsystem.loja.entities;
import br.com.southsystem.loja.model.Produto;
import org.apache.commons.text.StringTokenizer;
import java.io.*;
import java.io.IOException;
import java.util.Scanner;

public class EditarProduto extends ItemMenu {
    @Override
    public String getOpcao() {
        return "Editar produtos\t\t";
    }
    //tratar exceções!!!
    @Override
    public boolean executar() throws IOException {
        Scanner entrada = new Scanner(System.in);
        String registro, registro2;

        File db = new File("produtos.csv");
        File tempDB = new File("produtostemp.csv");

        BufferedReader br = new BufferedReader(new FileReader(db));
        BufferedWriter bw = new BufferedWriter(new FileWriter(tempDB));

        //listar dados atuais
        ListarProduto listar = new ListarProduto();
        listar.executar(); //listando dados presentes na aplicação

        System.out.print("\nEDIÇÃO DE PRODUTOS\n");
        System.out.print("--> ESCOLHA O PRODUTO");
        //pedir codigo do produto
        System.out.print("\nDigite o código do produto que você deseja alterar: ");
        String codigo = entrada.nextLine();
        Produto produto = dao.pesquisar(codigo); //pesquisando o código no arraylist

        while((registro = br.readLine()) != null ) { //a partir da lista contida no arquivo, são mostrados os dados
            StringTokenizer st = new StringTokenizer(registro,",");
            if(registro.contains(codigo)) {
                System.out.println("\nDADOS ATUAIS: ");
                System.out.println("Código do Produto: " + st.nextToken()
                        + "\nProduto: " + st.nextToken()
                        + "\nCategoria: " + st.nextToken()
                        + "\nPreço: R$" + st.nextToken()
                        + "\nQuantidade em estoque: " + st.nextToken()
                        + "\n");
                break;
            }
            else {
                System.out.println("\nProduto não encontrado!");
                return false;
            }
        }
        br.close();

            System.out.println("ATUALIZAR OS DADOS");
            System.out.print("Digite o novo nome do produto: ");
            String NovoNome = entrada.nextLine();
            System.out.print("\nDigite a nova categoria do produto: ");
            String NovaCategoria = entrada.nextLine();
            System.out.print("\nDigite o novo preço do produto: ");
            double NovoPreco = Double.parseDouble(entrada.nextLine());
            System.out.print("\nDigite a nova quantidade do produto em estoque: ");
            int NovaQntEstoque = Integer.parseInt(entrada.nextLine());

            if (produto != null) {
                produto.setNome(NovoNome);
                produto.setCategoria(NovaCategoria);
                produto.setPreco(NovoPreco);
                produto.setQntEstoque(NovaQntEstoque);
                dao.atualizar(produto); //aqui foram atualizados os dados no arraylist
            }

            BufferedReader br2 = new BufferedReader(new FileReader(db));
            while ((registro2 = br2.readLine()) != null) {
                if (registro2.contains(codigo)) {
                    bw.write(codigo + "," + NovoNome + "," + NovaCategoria.toUpperCase() + "," + NovoPreco + "," + NovaQntEstoque);
                } else {
                    bw.write(registro2);
                }
                bw.flush();
                bw.newLine();
            }
            bw.close();
            br2.close();
            db.delete();

            boolean successo = tempDB.renameTo(db);
            if (successo) {
                System.out.println("\nProduto Atualizado!");
            }

        return false;
    }
}

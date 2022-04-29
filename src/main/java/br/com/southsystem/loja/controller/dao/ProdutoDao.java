package br.com.southsystem.loja.controller.dao;
import br.com.southsystem.loja.excecoes.ProdutoException;
import br.com.southsystem.loja.model.Produto;
import br.com.southsystem.loja.model.ProdutoMostruario;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

//essa classe é responsável por acessar os dados dos produtos
public class ProdutoDao implements Dao {
    //implementando os métodos a partir da interface Dao
    public String FILE_PATH;
    private static final ArrayList<Produto> bd = new ArrayList<>();
    private BufferedReader reader;
    private BufferedWriter writer;

    public ProdutoDao() throws IOException {
        this.reader = null;
        this.writer = null;
        FILE_PATH = "produtos.csv";
        recuperarEstado();
    }

    public File getArquivodoBancoDeDados() throws IOException {
        //verificar se o arquivo existe
        //se não existir, criar ele
        File file = new File(FILE_PATH);
        if(!file.exists()) {
           file.createNewFile();
        }
        return file;
    }

    @Override
    public void importar(String arquivo) throws IOException {
            BufferedReader mostruarioReader = new BufferedReader(new FileReader(arquivo));
            String linha = mostruarioReader.readLine();
            while (((linha = mostruarioReader.readLine()) != null)) {
                ProdutoMostruario newProduto = new ProdutoMostruario(linha.split(",(?=([^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)"));
                Produto produto = new Produto();
                produto.setCodigo(newProduto.getCodigo());
                produto.setNome(newProduto.getNome());
                produto.setCategoria(newProduto.getCategoria());
                produto.setPreco(newProduto.calcularValorFinal());
                produto.setQuantidade(1);

                inserir(produto);
            }
            mostruarioReader.close();
    }

    @Override
    public void inserir(Produto produto) throws IOException {
         try {
             pesquisarPorCodigo(produto.getCodigo());
         } catch (ProdutoException produtoException) {
             bd.add(produto);
             gravarEstado();
         }
    }

    private void gravarEstado() throws IOException {
        this.writer = new BufferedWriter(new FileWriter(getArquivodoBancoDeDados(), false));

        StringBuilder conteudoArquivo = new StringBuilder();

        for (Produto produto : bd) {
            conteudoArquivo.append(produto.toString()).append("\n");
        }

        this.writer.write(conteudoArquivo.toString());
        this.writer.close();
    }

    @Override
    public List<Produto> listar() {
        return bd;
    }

    private void recuperarEstado() throws IOException {
        this.reader = new BufferedReader(new FileReader(getArquivodoBancoDeDados()));
        String linha;

        while ((linha = this.reader.readLine()) != null) {
            String[] array = linha.split(",");
            Produto produto = new Produto(array);
            bd.add(produto);
        }
        this.reader.close();
    }


    @Override
    public Produto pesquisarPorCodigo(String codigo) throws ProdutoException {
        Produto resultado = null;
        for(Produto atual : bd) {
                if(atual.getCodigo().equals(codigo)) {
                    resultado = atual;
                    break;
                }
        }
        if (resultado == null) throw new ProdutoException();

        return resultado;
    }

    @Override
    public void atualizar(Produto produto) throws IOException {
        Produto pesquisado = pesquisarPorCodigo(produto.getCodigo());
        pesquisado.setNome(produto.getNome());
        pesquisado.setCategoria(produto.getCategoria());
        pesquisado.setPreco(produto.getPreco());
        pesquisado.setQuantidade(produto.getQuantidade());
        gravarEstado();
    }

    @Override
    public void excluir(Produto produto) throws IOException {
        bd.remove(pesquisarPorCodigo(produto.getCodigo()));
        gravarEstado();
    }
}
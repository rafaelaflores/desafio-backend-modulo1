package br.com.southsystem.loja.dao;
import br.com.southsystem.loja.model.Produto;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

//essa classe é responsável por acessar os dados dos produtos
public class ProdutosDao implements Dao { //implementando os métodos a partir da interface Dao
    private static final ArrayList<Produto> bd = new ArrayList<>();

    @Override
    public void inserir(Produto produto) {
        bd.add(produto); //recebe os dados da classe InserirProduto e adiciona na lista
    }

    @Override
    public ArrayList<Produto> listar() {
        return bd;
    }

    @Override
    public Produto pesquisar(String codigo) {
        Produto resultado = null;
        for (Produto atual : bd) {
            if (atual.getCodigo().equals(codigo)) {
                resultado = atual;
                break;
            }
        }
        return resultado;
    }

    @Override
    public void atualizar(Produto produto) {
        Produto pesquisado = pesquisar(produto.getCodigo());
        pesquisado.setNome(produto.getNome());
        pesquisado.setCategoria(produto.getCategoria());
        pesquisado.setPreco(produto.getPreco());

    }

    @Override
    public void remover(Produto produto) {
        bd.remove(produto);
    }
}
package br.com.southsystem.loja.dao;
import br.com.southsystem.loja.model.Produto;

import java.util.ArrayList;

//essa classe define um conjunto de operações padrões que vão ser implementadas pelo projeto (contrato)
public interface Dao {
    void inserir(Produto produto);
    ArrayList<Produto> listar();
    Produto pesquisar(String codigo);
    void atualizar(Produto produto);
    void remover(Produto produto);
}

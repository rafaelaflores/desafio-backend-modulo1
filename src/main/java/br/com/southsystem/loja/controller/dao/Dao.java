package br.com.southsystem.loja.controller.dao;
import br.com.southsystem.loja.excecoes.ProdutoException;
import br.com.southsystem.loja.model.Produto;
import org.javatuples.KeyValue;

import java.io.IOException;
import java.util.List;

//essa classe define um conjunto de operações padrões que vão ser implementadas pelo projeto (contrato)
public interface Dao {
    void inserir(Produto produto) throws IOException;
    List<Produto> listar() throws IOException;
    void atualizar(Produto produto) throws IOException;
    void importar(String arquivo) throws IOException;
    Produto pesquisarPorCodigo(String codigo) throws IOException, ProdutoException;
    void excluir(Produto produto) throws IOException;
}


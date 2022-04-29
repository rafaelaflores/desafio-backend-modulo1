package br.com.southsystem.loja.view;

import br.com.southsystem.loja.controller.dao.Dao;
import br.com.southsystem.loja.controller.dao.ProdutoDao;
import br.com.southsystem.loja.excecoes.NegativoException;
import br.com.southsystem.loja.model.Produto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Scanner;

public class ProdutoView {
    public String listarProdutos(List<Produto> produtos) {
        StringBuilder telaProduto = new StringBuilder();
        telaProduto.append("\nLISTA DE PRODUTOS\n");
        for (Produto produto : produtos) {
            telaProduto.append("\n===== Produto " + produto.getNome() + " =====\n")
                    .append("- Código do produto: " + produto.getCodigo() + "\n")
                    .append("- Categoria do produto: " + produto.getCategoria() + "\n")
                    .append("- Preço do produto: R$ " + produto.getPreco().setScale(2, RoundingMode.HALF_EVEN) + "\n")
                    .append("- Quantidade em estoque: " + produto.getQuantidade() + "\n");
        }
        return telaProduto.toString();
    }
}

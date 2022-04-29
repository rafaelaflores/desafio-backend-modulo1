package br.com.southsystem.loja.view;

import br.com.southsystem.loja.model.Produto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProdutoViewTest {
    @Test
    void listarProdutos() {
        ProdutoView produtoView = new ProdutoView();
        List<Produto> produtos = Arrays.asList(new Produto("io4s7d14","Panetone South System","ALIMENTOS", new BigDecimal(45.88),256));
        StringBuilder telaProduto = new StringBuilder();
        telaProduto.append("\nLISTA DE PRODUTOS\n")
                    .append("\n===== Produto Panetone South System =====\n")
                    .append("- Código do produto: io4s7d14\n")
                    .append("- Categoria do produto: ALIMENTOS\n")
                    .append("- Preço do produto: R$ 45.88\n")
                    .append("- Quantidade em estoque: 256\n");

        Assertions.assertThat(produtoView.listarProdutos(produtos)).isEqualTo(telaProduto.toString());
    }
}
package br.com.southsystem.loja.model;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;

public class ProdutoTest {
    @Test
    void toStringTest() {
        Produto produto = new Produto();
        String resultadoEsperado = "io4s7d14,Panetone South System,ALIMENTOS,45.88,256";

        produto.setCodigo("io4s7d14");
        produto.setNome("Panetone South System");
        produto.setCategoria("ALIMENTOS");
        produto.setPreco(new BigDecimal("45.88"));
        produto.setQuantidade(Integer.parseInt("256"));

        Assertions.assertThat(produto.toString()).isEqualTo(resultadoEsperado);
    }
}

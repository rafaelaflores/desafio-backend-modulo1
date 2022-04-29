package br.com.southsystem.loja.model;
import java.math.BigDecimal;
import java.math.RoundingMode;

//essa classe é um objeto de valor
public class Produto {
    private String codigo;
    private String nome;
    private String categoria;
    private BigDecimal preco;
    private Integer quantidade;

    public Produto() {
    }

    public Produto(String[] parameters) {
        this.codigo = parameters[0];
        this.nome = parameters[1];
        this.categoria = parameters[2];
        this.preco = new BigDecimal(parameters[3].replace("\"", ""));
        this.quantidade = Integer.parseInt(parameters[4]);
    }

    public Produto(String codigo, String nome, String categoria, BigDecimal preco, Integer qntEstoque) {
        super();
        this.codigo = codigo;
        this.nome = nome;
        this.categoria = categoria;
        this.preco = preco;
        this.quantidade = qntEstoque;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }
    //mudar categoria para toUpperCase
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return codigo + "," + nome + "," + categoria.toUpperCase() + "," + preco.setScale(2, RoundingMode.HALF_EVEN) + "," + quantidade;
    }
}

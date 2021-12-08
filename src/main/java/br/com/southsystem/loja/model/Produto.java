package br.com.southsystem.loja.model;
//essa classe é um objeto de valor
public class Produto {
    private String codigo;
    private String nome;
    private String categoria;
    private Double preco;
    private Integer qntEstoque;

    public Produto() {

    }

    public Produto(String codigo, String nome, String categoria, Double preco, Integer qntEstoque) {
        super();
        this.codigo = codigo;
        this.nome = nome;
        this.categoria = categoria;
        this.preco = preco;
        this.qntEstoque = qntEstoque;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
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

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Integer getQntEstoque() {
        return qntEstoque;
    }

    public void setQntEstoque(Integer qntEstoque) {
        this.qntEstoque = qntEstoque;
    }

    @Override
    public String toString() {
        return "\nCódigo do Produto: " + codigo + "\nProduto: " + nome + "\nCategoria: " + categoria + "\nPreço: " + preco + "\nQuantidade em estoque: " + qntEstoque;
    }
}

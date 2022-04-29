package br.com.southsystem.loja.model;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ProdutoMostruario {
    private String codigo;
    private String codigoBarras;
    private String serie;
    private String nome;
    private String descricao;
    private String categoria;
    private BigDecimal valorBruto;
    private BigDecimal impostos;
    private LocalDate dataFabricacao;
    private LocalDate dataValidade;
    private String cor;
    private String material;

    public ProdutoMostruario() {
    }

    public ProdutoMostruario(String[] parameters) {
        this.codigo = parameters[0];
        this.codigoBarras = parameters[1];
        this.serie = parameters[2];
        this.nome = parameters[3];
        this.descricao = parameters[4];
        this.categoria = parameters[5];
        this.valorBruto = new BigDecimal(parameters[6].replace("\"", ""));
        this.impostos = new BigDecimal(parameters[7].replace("\"", ""));

        try {
            this.dataFabricacao = LocalDate.parse(parameters[8], DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        }
        catch (Exception e)
        {
            this.dataFabricacao = LocalDate.parse("01/01/1001", DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        }

        try {
            this.dataValidade = LocalDate.parse(parameters[9], DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        }
        catch (Exception e)
        {
            this.dataValidade = LocalDate.parse("01/01/1001", DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        }
        this.cor = parameters[10];
        this.material = parameters[11];
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public BigDecimal getValorBruto() {
        return valorBruto;
    }

    public void setValorBruto(BigDecimal valorBruto) {
        this.valorBruto = valorBruto;
    }

    public BigDecimal getImpostos() {
        return impostos;
    }

    public void setImpostos(BigDecimal impostos) {
        this.impostos = impostos;
    }

    public LocalDate getDataFabricacao() {
        return dataFabricacao;
    }

    public void setDataFabricacao(LocalDate dataFabricacao) {
        this.dataFabricacao = dataFabricacao;
    }

    public LocalDate getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(LocalDate dataValidade) {
        this.dataValidade = dataValidade;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public BigDecimal calcularValorFinal() {
        return this.impostos.multiply(new BigDecimal(0.01))
                .add(new BigDecimal(1.00))
                .multiply(new BigDecimal(1.45))
                .multiply(this.valorBruto).setScale(2, RoundingMode.HALF_EVEN);
    }

    @Override
    public String toString() { //margem de lucro de 45% * imposto * valor bruto  EX: 1.45 * 1.25 * 101.11 = valor
        return this.codigo + "," +
                this.nome + "," +
                this.categoria + "," + calcularValorFinal() + "," + 1;
    }
}

package br.com.southsystem.loja.controller;

import br.com.southsystem.loja.controller.dao.ProdutoDao;
import br.com.southsystem.loja.excecoes.NegativoException;
import br.com.southsystem.loja.excecoes.ProdutoException;
import br.com.southsystem.loja.model.Produto;
import br.com.southsystem.loja.view.MainMenuView;
import br.com.southsystem.loja.view.ProdutoView;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class ProdutoController {
    private ProdutoDao dao;
    private MainMenuView view;
    private  ProdutoView produtoView;
    Scanner entrada = new Scanner(System.in);

    public ProdutoController(ProdutoDao dao, MainMenuView view, ProdutoView produtoView) {
        this.dao = dao;
        this.view = view;
        this.produtoView = produtoView;
    }

    public void adicionarProduto() {
        System.out.println("\nADICIONAR PRODUTO");
        //Captura o código do produto
        System.out.print("Digite o código do produto: ");
        String codigo = entrada.nextLine();

        try {
            Produto produtoEncontrado = dao.pesquisarPorCodigo(codigo);
            System.out.println("\nProduto já cadastrado! Use a opção editar produto.");
            //voltar pro menu

        } catch (ProdutoException e) {
            System.out.print("\nDigite o nome do produto: ");
            String nome = entrada.nextLine();

            System.out.print("\nDigite a categoria do produto: ");
            String categoria = entrada.nextLine();

            System.out.print("\nDigite o preço do produto: ");
            String stringPreco = entrada.nextLine();
            BigDecimal preco = new BigDecimal(stringPreco.replace(",", "."));

            if (preco.compareTo(BigDecimal.ZERO) < 0) {
                throw new NegativoException();
            }
            System.out.print("\nDigite a quantidade do produto em estoque: ");
            Integer qntEstoque = Integer.parseInt(entrada.nextLine());
            if (qntEstoque < 0) {
                throw new NegativoException();
            }

            Produto produto = new Produto(codigo, nome, categoria, preco, qntEstoque); //cria o objeto produto com os dados acima

            try {
                dao.inserir(produto);
            } catch (IOException exception) {
                System.out.println(exception.getMessage());
            }

            System.out.println("\nProduto cadastrado!\n");
        }
    }
    public void editarProduto() {
        listarProduto();
        System.out.println("EDITAR PRODUTO");
        System.out.print("Digite o código do produto que você deseja alterar: ");
        String codigo = entrada.nextLine();

        try {
            Produto produtoEncontrado = dao.pesquisarPorCodigo(codigo);

            System.out.println("\nProduto selecionado: " + produtoEncontrado);

            System.out.println("\nATUALIZAR OS DADOS\n");
            System.out.print("Digite o novo nome do produto: ");
            String novoNome = entrada.nextLine();
            System.out.print("\nDigite a nova categoria do produto: ");
            String novaCategoria = entrada.nextLine();
            System.out.print("\nDigite o novo preço do produto: ");
            String stringNovoPreco = entrada.nextLine();
            BigDecimal novoPreco = new BigDecimal(stringNovoPreco.replace(",", "."));

            if (novoPreco.compareTo(BigDecimal.ZERO) < 0) {
                throw new NegativoException();
            }

            System.out.print("\nDigite a nova quantidade do produto em estoque: ");
            Integer novaQntEstoque = Integer.parseInt(entrada.nextLine());
            if (novaQntEstoque < 0) {
                throw new NegativoException();
            }

            produtoEncontrado.setNome(novoNome);
            produtoEncontrado.setCategoria(novaCategoria);
            produtoEncontrado.setPreco(novoPreco);
            produtoEncontrado.setQuantidade(novaQntEstoque);
            dao.atualizar(produtoEncontrado); //aqui foram atualizados os dados

            System.out.println("\nProduto editado!");
        } catch (ProdutoException e) {
            System.out.println("\nNenhum produto com o código " + codigo + " foi encontrado!\n");
            //voltar pro menu inicial
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void removerProduto() {
        listarProduto();
        System.out.println("REMOVER PRODUTO");
        System.out.print("Digite o código do produto que você deseja alterar: ");
        String codigo = entrada.nextLine();
        try {
            Produto produtoEncontrado = dao.pesquisarPorCodigo(codigo);
            dao.excluir(produtoEncontrado);
            System.out.println("\nProduto Removido!");
        } catch (ProdutoException e) {
            System.out.println("\nNenhum produto com o código " + codigo + " foi encontrado!");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void listarProduto() {
        List<Produto> produtoList = dao.listar();
        System.out.println(produtoView.listarProdutos(produtoList));
    }

    public void importarProduto() {
        listarProduto();
        System.out.println("\nIMPORTAR MOSTRUÁRIO");
        System.out.print("Informe o nome do arquivo a ser importado: ");
        String path = entrada.nextLine();

        try {
            this.dao.importar(path);
            System.out.println("\nDados importados com sucesso!\n");
        } catch (IOException e) {
            System.out.println("\nOcorreu um erro ao importar os dados! Tente novamente.\nErro: " + e.getMessage());
            System.out.println();
        }
    }
}

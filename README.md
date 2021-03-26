# DESAFIO DO MÓDULO 1 #

## Módulo 1 ##
Programação Orientada a Objetos com Java, Testes unitários e JUnit.

## Desafio ##

Nesta etapa, o Impulsionando continuará o desenvolvimento da Loja Virtual (desafio do módulo 1), agora trabalhando nas funcionalidades de back-end.

### Descrição ###
Em uma loja virtual, deve ser possível gerenciar os produtos disponiveis e os seus dados, ou seja, o sistema da loja deve permitir de forma simples e rápida a inclusão, exclusão e edição de produtos. Nesta etapa do desafio, devemos desenvolver as funcionalidades que executem essa importante tarefa de negócio.

### Requisitos ###
- [ ] Construir uma aplicação Java *Standalone* que execute por linha de comando.
- [ ] As funcionalidades deveráo ter cobertura de testes unitários.
- [ ] Manipulação dos dados da Loja Virtual no arquivo JSON do Desafio do Módulo 1.
### Funcionalidades Esperadas ###
- [ ] Ao iniciar a aplicação, exibir um menu numerado com as seguintes opções:
    - [ ] 1. Adicionar Novo Produto: Permitir incluir um novo item na lista de produtos da loja. Ao selecionar essa opção solicitar os seguintes dados para o usuário: nome, preço, quantidade em estoque e categoria.
    - [ ] 2. Editar Produto: Permitir editar os dados de um produto. Ao selecionar essa opção, deverá listar todos os produtos cadastrados e o usuário poderá selecionar um para edição dos dados previamente cadastrados.
    - [ ] 3. Excluir Produto: Listar todos os produtos cadastrados e permitir selecionar um para apagar. Deverá sempre haver pelo menos um produto na lista.
    - [ ] 4. Importar Mostruário da Fábrica: Muitas vezes, lojas virtuais recebem das fábricas arquivos com os dados dos produtos. Ao selecionar essa opção, a aplicação deverá ser um arquivo .csv (ver exemplo no repositório) que deve ser indicado pelo usuário, tratar os dados e gravar na lista de produtos.


### Bônus ###
* Utilização de Design Patterns. Ex.: Builder (não pode ser usado Lombok), Singleton, etc.
* Utilização de Maven ou Gradle
* Utilização de String Boot Standalone
### Material de Apoio ###
* [Java4Noobs](https://github.com/paulorievrs/java4noobs)

### Instruções para Realização do Desafio ###
1. Faça um *fork* desse repositório para a sua conta
2. Implemente a sua solução conforme solicitado
3. Compartilhe o link do projeto com o seu mentor 

***
## Critérios de Avaliação ##
* A aplicação está funcionando?
* A aplicação atende os requisitos solicitados?
    * A página principal está listando os produtos, conforme solicitado?
    * Existe um link para a própria página?
    * Os produtos estão sendo carregados de um arquivo JSON?
    * É possível ordenar os produtos por nome?
    * É possível ordenar os produtos por categoria?
    * É possível ordenar os produtos pelo seu valor?
* A aplicação apresenta bugs?
* O código da aplicação está legível?
* Existe uma breve ocumentação da aplicação e/ou do código?
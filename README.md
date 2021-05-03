# DESAFIO DO MÓDULO 2 #

## Módulo 2 ##
Programação Orientada a Objetos com Java, Testes unitários e JUnit.

## Desafio ##

Nesta etapa, o Impulsionando continuará o desenvolvimento da Loja Virtual (desafio do módulo 1), agora trabalhando nas funcionalidades de back-end.

### Descrição ###
Em uma loja virtual, deve ser possível gerenciar os produtos disponiveis e os seus dados, ou seja, o sistema da loja deve permitir de forma simples e rápida a inclusão, exclusão e edição de produtos. Nesta etapa do desafio, devemos desenvolver as funcionalidades que executem essa importante tarefa de negócio.

### Requisitos e Funcionalidades Esperadas ###
- [ ] Construir uma aplicação Java *Standalone* que execute por linha de comando.
- [ ] As funcionalidades deveráo ter cobertura de testes unitários.
- [ ] Manipulação dos dados da Loja Virtual no arquivo JSON do Desafio do Módulo 1.
- [ ] Ao iniciar a aplicação, exibir um menu numerado com as seguintes opções:
    - [ ] 1. Adicionar Novo Produto: Permitir incluir um novo item na lista de produtos da loja. Ao selecionar essa opção solicitar os seguintes dados para o usuário: nome, preço, quantidade em estoque e categoria.
    - [ ] 2. Editar Produto: Permitir editar os dados de um produto. Ao selecionar essa opção, deverá listar todos os produtos cadastrados e o usuário poderá selecionar um para edição dos dados previamente cadastrados.
    - [ ] 3. Excluir Produto: Listar todos os produtos cadastrados e permitir selecionar um para apagar. Deverá sempre haver pelo menos um produto na lista.
    - [ ] 4. Importar Mostruário da Fábrica: Muitas vezes, lojas virtuais recebem das fábricas arquivos com os dados dos produtos. Ao selecionar essa opção, a aplicação deverá ser um arquivo .csv (ver exemplo no repositório) que deve ser indicado pelo usuário, tratar os dados e gravar na lista de produtos.
        - [ ] Cálculo do valor final do produto: valor bruto + imposto + margem de lucro de 45%
    - [ ] 5. Sair: opção para o usuário encerrar o sistema. 
- [ ] Após o usuário efetuar alguma das operações acima (das opções de 1-4), a aplicação deverá voltar para o menu inicial.
- [ ] Cada opção do menu, deve ter uma opção de "Cancelar" a operação e voltar para o menu inicial, sem promover alteração dos dados.


### Bônus ###
* Utilização de Design Patterns. Ex.: Builder, Singleton, etc.
* Utilização de Maven ou Gradle
* Utilização de String Boot Standalone
* Não pode ser usado Lombok
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
    * O menu é apresentado corretamente?
    * É possível incluir um novo produto?
    * É possível editar os dados de um produto?
    * É possível excluir um produto?
    * A importação de arquivo .csv funciona corretamente?
    * Existe a opção de "Cancelar" uma operação? Ex.: Após selecionar editar um produto, é possível "Cancelar"
    * Após realizar alguma operaçào, a aplicação volta para o menu inicial?
* As classes e pacotes estão segregados por responsabilidade ou funcionalidade?
* Os métodos ou contrutores estão recebendo muitos argumentos por parâmetros?
* O código da aplicação está com nomes intuitivos de funções, variáveis ou classes?
* O escopo das variáveis de classes estão sendo utilizados de forma adequada?
* Existe cobertura de teste unitários de cenário feliz e cenário de erros para as funcionalidades desenvolvidas?
* A aplicação apresenta bugs?
* Existe um correto tratamento de erros e exceções?
* A aplicação possui logs úteis?
* Existe um readme contendo instruções de como rodar a aplicação?
# DESAFIO DO MÓDULO 1 #
Essa aplicação é um sistema de Loja Online Simples para gerenciar produtos disponiveis e os seus dados.
Nessa aplicação é possível de forma simples e rápida a inclusão, exclusão e edição de produtos. Além de permitir a importação de um mostruário de fábrica para dentro do sistema. 
Os dados manipulados nesse sistema ficam salvos em um arquivo csv, denominado produtos.csv!

### 🔧 Utilização
O usuário poderá rodar o sistema em uma IDE através da classe Program.java localizada no pacote application!
Ou, é possível executar no terminal do Windows o comando ```java -jar loja.jar```, na pasta do projeto.

## 🚀 Funções
Ao executar a aplicação, será mostrado um menu de opções, das quais o usuário poderá escolher qual deseja executar.
```
+------------------------------------------+
|          Sistema de Loja +PraTI          |
+------------------------------------------+
[0] Sair do programa
[1] Adicionar produto
[2] Editar produto
[3] Remover produto
[4] Importar mostruário
+------------------------------------------+
Escolha uma opção: 
```
### [0] Sair do programa
Essa opção encerra o programa!

### [1] Adicionar produto
Nessa opção é possível cadastrar um novo produto, entrando com os seguintes dados:
Código, Nome, Categoria, Preço e Quantidade em Estoque!
```
ADICIONAR PRODUTO
Digite o código do produto: hrcilce1

Digite o nome do produto: Cerveja Foguete South

Digite a categoria do produto: ALIMENTAÇÃO E BEBIDAS

Digite o preço do produto: 12.60

Digite a quantidade do produto em estoque: 45
```

Caso o código digitado já exista na lista, o sistema sugere que o usuário utlize a função Editar e retorna ao menu inicial.
````
ADICIONAR PRODUTO
Digite o código do produto: hrcilce1

Produto já cadastrado! Use a opção editar produto.
````
Para cadastrar um novo produto basta entrar com as informações descritas acima.

### [2] Editar produto
Aqui inicialmente será mostrado a lista dos produtos: 
````
LISTA DE PRODUTOS

===== Produto Teclado Gamer =====
- Código do produto: t0n75ytr
- Categoria do produto: ESCRITÓRIO
- Preço do produto: R$ 236.84
- Quantidade em estoque: 1

===== Produto Livro Design Patterns =====
- Código do produto: 7t0do00n
- Categoria do produto: ESCRITÓRIO
- Preço do produto: R$ 183.26
- Quantidade em estoque: 1
````
Após isso será perguntado ao usuário o código do produto que ele deseja editar:
````
EDITAR PRODUTO
Digite o código do produto que você deseja alterar: t0n75ytr
````

Se o código digitado não for encontrado a mensagem ````Nenhum produto com o código xxxxxx foi encontrado!```` é mostrada!

Se o código digitado existir são mostrados os dados atuais do produto: ````Produto selecionado: heqti1q0,Máscara PFF2 South,HIGIENE E SAÚDE,15.26,15````

Com isso, basta digitar os novos dados!
```
ATUALIZAR OS DADOS
Digite o novo nome do produto:

Digite a nova categoria do produto:

Digite o novo preço do produto:

Digite a nova quantidade do produto em estoque: 
```
Caso a edição tenha sido concluída será mostrado: ```Produto editado!```
### [3] Remover produto
Após mostrar uma lista dos produtos atuais o sistema pergunta ao usuário qual o código do produto a ser removido e imprime na tela caso o código exista.
```
REMOVER PRODUTO
Digite o código do produto que você deseja remover: t0n75ytr

Produto selecionado: t0n75ytr,Teclado Gamer,ESCRITÓRIO,236.84,1
```

Assim como na opção editar produto, caso o sistema não encontre o produto, o usuário é redirecionado ao menu inicial.

Depois de mostrar os dados do produto escolhido, a mensagem ```Produto removido!``` é mostrada.

### [4] Importar mostruário
Quando essa opção é selecionada assim como nas outras, a lista dos produtos é exibida e logo em seguida é pedido para o usuário o nome do arquivo que ele deseja importar.
```
IMPORTAR MOSTRUÁRIO

Informe o nome do arquivo a ser importado: mostruario_fabrica.csv
```
Caso haja algum problema com o arquivo informado, é exibida a seguinte mensagem:```Ocorreu um erro ao importar os dados!
Tente novamente. 
Erro: xxxx (O sistema não pode encontrar o arquivo especificado)```

Caso contrário, o sistema importa os dados para dentro do banco de dados do sistema, vale ressaltar que se algum produto a ser importado já possui código na lista dos produtos, ele não será importado.
```
Dados importados com sucesso!
```

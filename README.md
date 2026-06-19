# Padrões de Projeto - Sistema de Hamburgueria

## Descrição do Projeto

Este projeto foi desenvolvido com o objetivo de aplicar, de forma prática e integrada, os principais padrões de projeto estudados na disciplina. O sistema simula o funcionamento de uma hamburgueria, envolvendo criação de pedidos, montagem de combos, preparo de hambúrgueres, controle de estados do pedido, pagamentos, entregas, comunicação entre setores, relatórios e testes automatizados.

A proposta principal do projeto é demonstrar que os padrões de projeto podem ser utilizados em conjunto dentro de um mesmo domínio, sem a necessidade de separar o código em pacotes por padrão. Dessa forma, as classes foram organizadas de acordo com o contexto da hamburgueria, deixando os padrões aplicados naturalmente na estrutura do sistema.

---

## Objetivo

O objetivo do sistema é representar uma hamburgueria capaz de:

* Cadastrar clientes e pedidos;
* Criar pedidos de balcão e delivery;
* Montar hambúrgueres personalizados;
* Criar combos tradicionais e premium;
* Controlar o estoque;
* Aplicar adicionais aos itens do pedido;
* Controlar o estado do pedido;
* Notificar setores e clientes;
* Processar diferentes formas de pagamento;
* Registrar e desfazer ações;
* Controlar acesso a relatórios financeiros;
* Gerenciar entregas;
* Interpretar fórmulas de cálculo de preço;
* Reaproveitar objetos e estruturas do cardápio.

---

## Tecnologias Utilizadas

* Java
* Maven
* JUnit 5
* IntelliJ IDEA
* Programação Orientada a Objetos
* Padrões de Projeto GoF

---

## Estrutura do Projeto

O projeto foi organizado por domínio, e não por nome de padrão. Essa decisão foi tomada para manter o sistema mais próximo de uma aplicação real.

```text
src
├── main
│   └── java
│       └── Hamburgueria
│           ├── interfaces
│           ├── Cliente.java
│           ├── Pedido.java
│           ├── Hamburguer.java
│           ├── Combo.java
│           ├── Estoque.java
│           ├── PedidoFacade.java
│           ├── ...
│
└── test
    └── java
        └── Hamburgueria
            ├── EstoqueTest.java
            ├── ComboTest.java
            ├── PedidoEstadoTest.java
            ├── PagamentoTest.java
            ├── ...
```

As interfaces ficam dentro do pacote:

```java
Hamburgueria.interfaces
```

As demais classes ficam no pacote principal:

```java
Hamburgueria
```

---

## Padrões de Projeto Implementados

O projeto implementa os 23 padrões de projeto GoF, divididos em padrões criacionais, estruturais e comportamentais.

---

# Padrões Criacionais

## Singleton

### Classe principal

* `Estoque`

### Aplicação no projeto

O padrão Singleton foi utilizado na classe `Estoque`, garantindo que exista apenas uma instância responsável pelo controle dos produtos disponíveis na hamburgueria.

### Justificativa

O estoque deve ser único no sistema, pois diferentes pedidos e operações precisam consultar e alterar a mesma fonte de dados. Caso existissem vários estoques independentes, haveria risco de inconsistência nas quantidades dos produtos.

---

## Factory Method

### Classes principais

* `PedidoFactory`
* `PedidoBalcaoFactory`
* `PedidoDeliveryFactory`

### Aplicação no projeto

O Factory Method foi utilizado para criar diferentes tipos de pedido, como pedido de balcão e pedido delivery.

### Justificativa

A criação de pedidos pode variar de acordo com o tipo de atendimento. Com o Factory Method, a lógica de criação fica centralizada em fábricas específicas, evitando que o restante do sistema precise saber diretamente como cada tipo de pedido é instanciado.

---

## Abstract Factory

### Classes principais

* `ComboFactoryInterface`
* `ComboTradicionalFactory`
* `ComboPremiumFactory`
* `ComboFactory`

### Aplicação no projeto

O Abstract Factory foi utilizado para criar famílias de produtos relacionadas a combos, como hambúrguer, acompanhamento e bebida.

### Justificativa

Um combo tradicional e um combo premium possuem itens diferentes, mas seguem a mesma estrutura. O Abstract Factory permite criar essas famílias de objetos de forma padronizada, mantendo a consistência entre os itens de cada combo.

---

## Builder

### Classe principal

* `HamburguerBuilder`

### Aplicação no projeto

O Builder foi utilizado para construir hambúrgueres personalizados, permitindo definir nome, preço e ingredientes de forma gradual.

### Justificativa

A criação de um hambúrguer pode envolver vários dados e ingredientes. O Builder facilita essa construção, evitando construtores muito grandes e deixando o código mais legível.

---

## Prototype

### Classes principais

* `Hamburguer`
* `Combo`
* `CardapioPrototypeFactory`

### Aplicação no projeto

O Prototype foi utilizado para clonar modelos de hambúrgueres e combos já existentes no cardápio.

### Justificativa

Em uma hamburgueria, alguns produtos podem servir como modelos prontos para novos pedidos. Com o Prototype, é possível clonar esses modelos sem reconstruí-los manualmente do zero.

---

# Padrões Estruturais

## Adapter

### Classes principais

* `SistemaPagamentoOnline`
* `PagamentoOnlineAdapter`

### Aplicação no projeto

O Adapter foi utilizado para adaptar um sistema externo de pagamento online à interface `FormaPagamento` utilizada pelo sistema.

### Justificativa

O sistema da hamburgueria possui uma interface própria para pagamentos. Porém, um serviço externo pode ter métodos diferentes. O Adapter permite integrar esse sistema externo sem alterar a estrutura principal do projeto.

---

## Bridge

### Classes principais

* `ServicoEntrega`
* `EntregaPadrao`
* `EntregaExpressa`
* `TipoEntrega`
* `EntregaMotoboy`
* `EntregaAplicativo`
* `RetiradaBalcao`

### Aplicação no projeto

O Bridge foi utilizado para separar o tipo de serviço de entrega da forma como a entrega será realizada.

### Justificativa

O sistema pode ter entregas padrão ou expressas, e cada uma pode ser feita por motoboy, aplicativo parceiro ou retirada no balcão. O Bridge evita a criação de muitas subclasses combinando todas as possibilidades.

---

## Composite

### Classes principais

* `ItemCardapio`
* `Hamburguer`
* `Combo`

### Aplicação no projeto

O Composite foi utilizado para permitir que um combo seja tratado como um item do cardápio, assim como um hambúrguer individual.

### Justificativa

Um combo é composto por vários itens, mas deve poder ser adicionado ao pedido como se fosse um único item. O Composite permite essa estrutura hierárquica de forma simples.

---

## Decorator

### Classes principais

* `ItemPedido`
* `AdicionalBacon`
* `AdicionalCheddar`
* `AdicionalOvo`

### Aplicação no projeto

O Decorator foi utilizado para adicionar ingredientes extras a um hambúrguer sem alterar a classe original.

### Justificativa

Um cliente pode personalizar o hambúrguer com bacon, cheddar ou ovo. O Decorator permite adicionar esses comportamentos dinamicamente, aumentando o preço e a descrição do produto.

---

## Facade

### Classe principal

* `PedidoFacade`

### Aplicação no projeto

O Facade foi utilizado para simplificar a criação de pedidos completos, como pedido de balcão tradicional e pedido delivery premium.

### Justificativa

Criar um pedido pode envolver cliente, fábrica de pedido, fábrica de combo e baixa de estoque. O Facade centraliza esse processo e oferece métodos mais simples para o uso externo.

---

## Flyweight

### Classes principais

* `Ingrediente`
* `IngredienteFactory`

### Aplicação no projeto

O Flyweight foi utilizado para reaproveitar objetos de ingredientes iguais, evitando criar várias instâncias repetidas.

### Justificativa

Ingredientes como pão, carne e queijo aparecem em vários hambúrgueres. O Flyweight reduz a repetição de objetos e melhora a organização dos ingredientes compartilhados.

---

## Proxy

### Classes principais

* `RelatorioFinanceiro`
* `RelatorioFinanceiroReal`
* `RelatorioFinanceiroProxy`

### Aplicação no projeto

O Proxy foi utilizado para controlar o acesso ao relatório financeiro da hamburgueria.

### Justificativa

Nem todos os funcionários devem ter acesso às informações financeiras. O Proxy verifica se o funcionário é um gerente antes de liberar o relatório.

---

# Padrões Comportamentais

## Chain of Responsibility

### Classes principais

* `Funcionario`
* `Atendente`
* `Cozinha`
* `Gerente`

### Aplicação no projeto

O Chain of Responsibility foi utilizado para encaminhar solicitações entre funcionários da hamburgueria.

### Justificativa

Algumas solicitações podem ser atendidas pelo atendente, outras pela cozinha e outras apenas pelo gerente. A cadeia permite que cada funcionário tente resolver a solicitação e, caso não consiga, encaminhe para o próximo responsável.

---

## Command

### Classes principais

* `Tarefa`
* `CriarPedidoTarefa`
* `CancelarPedidoTarefa`
* `FinalizarPedidoTarefa`
* `HistoricoPedido`

### Aplicação no projeto

O Command foi utilizado para representar ações realizadas sobre pedidos, como criar, cancelar e finalizar.

### Justificativa

Ao transformar ações em objetos, o sistema consegue executar tarefas e também desfazer a última ação realizada, mantendo um histórico simples das operações.

---

## Interpreter

### Classes principais

* `InterpretadorExpressao`
* `InterpretadorExpressoesAritmeticas`
* `Numero`
* `Adicao`
* `Subtracao`
* `Multiplicacao`
* `Divisao`
* `CalculadoraPrecoPedido`

### Aplicação no projeto

O Interpreter foi utilizado para interpretar fórmulas de cálculo do valor final do pedido.

### Justificativa

O preço final pode depender de uma fórmula, como:

```text
valorPedido + taxaEntrega - desconto
```

Com o Interpreter, o sistema consegue interpretar essa expressão e calcular o resultado de forma flexível.

---

## Iterator

### Classe principal

* `Cardapio`

### Aplicação no projeto

O Iterator foi utilizado para percorrer os itens do cardápio com `for-each`.

### Justificativa

O cardápio é uma coleção de itens. O Iterator permite percorrer esses itens sem expor diretamente a estrutura interna da lista.

---

## Mediator

### Classes principais

* `MediadorHamburgueria`
* `CentralHamburgueria`
* `SetorHamburgueria`
* `SetorAtendimento`
* `SetorCozinha`
* `SetorGerencia`

### Aplicação no projeto

O Mediator foi utilizado para centralizar a comunicação entre atendimento, cozinha e gerência.

### Justificativa

Sem o Mediator, os setores precisariam se comunicar diretamente entre si, aumentando o acoplamento. A central da hamburgueria reduz essa dependência e organiza melhor a troca de mensagens.

---

## Memento

### Classes principais

* `Pedido`
* `PedidoMemento`

### Aplicação no projeto

O Memento foi utilizado para salvar e restaurar estados anteriores de um pedido.

### Justificativa

Algumas ações, como adicionar item, cancelar ou finalizar pedido, podem precisar ser desfeitas. O Memento permite restaurar informações anteriores sem expor diretamente a estrutura interna do pedido.

---

## Observer

### Classes principais

* `ObservadorPedido`
* `ObservadorCliente`
* `ObservadorCozinha`
* `Pedido`

### Aplicação no projeto

O Observer foi utilizado para notificar interessados quando o estado do pedido muda.

### Justificativa

Quando um pedido entra em preparo, fica pronto ou é cancelado, cliente e cozinha precisam ser avisados automaticamente. O Observer permite adicionar novos interessados sem modificar a lógica principal do pedido.

---

## State

### Classes principais

* `EstadoPedido`
* `EstadoPedidoRecebido`
* `EstadoPedidoEmPreparo`
* `EstadoPedidoPronto`
* `EstadoPedidoFinalizado`
* `EstadoPedidoCancelado`
* `Pedido`

### Aplicação no projeto

O State foi utilizado para controlar as mudanças de situação do pedido.

### Justificativa

Um pedido pode estar recebido, em preparo, pronto, finalizado ou cancelado. Cada estado define quais transições são permitidas, evitando excesso de condicionais dentro da classe `Pedido`.

---

## Strategy

### Classes principais

* `FormaPagamento`
* `PagamentoPix`
* `PagamentoCartao`
* `PagamentoDinheiro`

### Aplicação no projeto

O Strategy foi utilizado para permitir diferentes formas de pagamento.

### Justificativa

O pedido pode ser pago por Pix, cartão ou dinheiro. Com Strategy, a forma de pagamento pode ser alterada sem modificar a classe `Pedido`.

---

## Template Method

### Classes principais

* `PreparoHamburguer`
* `PreparoHamburguerTradicional`
* `PreparoHamburguerPremium`
* `PreparoHamburguerVegano`

### Aplicação no projeto

O Template Method foi utilizado para padronizar o processo de preparo dos hambúrgueres.

### Justificativa

Todos os hambúrgueres seguem uma sequência parecida de preparo: definir pão, proteína, queijo, molho e possíveis extras. O Template Method define essa sequência fixa, permitindo que cada tipo de hambúrguer personalize apenas os detalhes.

---

## Visitor

### Classes principais

* `VisitorCardapio`
* `RelatorioCardapioVisitor`
* `Hamburguer`
* `Combo`
* `Ingrediente`

### Aplicação no projeto

O Visitor foi utilizado para gerar relatórios sobre itens do cardápio.

### Justificativa

O sistema pode precisar exibir informações específicas de hambúrgueres, combos e ingredientes. O Visitor permite criar novas operações sobre esses objetos sem alterar diretamente suas classes principais.

---

## Fluxo Geral do Sistema

O fluxo principal do sistema funciona da seguinte forma:

1. Um cliente realiza um pedido;
2. O pedido é criado como balcão ou delivery;
3. O sistema monta hambúrgueres e combos;
4. O estoque é atualizado;
5. O pedido muda de estado durante o atendimento;
6. Cliente e cozinha são notificados;
7. O pagamento é processado;
8. A entrega é calculada;
9. A ação pode ser registrada e desfeita;
10. Relatórios podem ser acessados apenas por funcionários autorizados.

---

## Testes Automatizados

O projeto possui testes automatizados com JUnit 5, seguindo o estilo dos exemplos trabalhados em aula.

Foram testados:

* Criação de pedidos;
* Criação de combos;
* Adicionais de hambúrguer;
* Controle de estoque;
* Estados do pedido;
* Observadores;
* Formas de pagamento;
* Histórico e cancelamento de tarefas;
* Relatórios financeiros;
* Cardápio;
* Ingredientes compartilhados;
* Preparo de hambúrgueres;
* Clonagem de itens;
* Visitor;
* Comunicação entre setores;
* Entregas;
* Cálculo de preço com expressão aritmética.

---

## Como Executar os Testes

Para executar os testes pelo Maven:

```bash
mvn test
```

Também é possível executar os testes diretamente pelo IntelliJ IDEA, clicando com o botão direito na pasta de testes e selecionando:

```text
Run All Tests
```

---

## Principais Benefícios da Arquitetura

A aplicação dos padrões de projeto trouxe os seguintes benefícios:

* Redução de acoplamento entre classes;
* Maior reutilização de código;
* Melhor separação de responsabilidades;
* Facilidade para adicionar novos tipos de pedido, pagamento, entrega e produto;
* Controle mais claro das regras de estado;
* Organização da comunicação entre setores;
* Possibilidade de desfazer ações;
* Melhor controle de acesso a informações sensíveis;
* Estrutura mais próxima de um sistema real.

---

## Conclusão

Este projeto demonstra como diferentes padrões de projeto podem ser aplicados de forma conjunta em um único sistema, sem que o código fique separado artificialmente por padrão. A hamburgueria foi utilizada como domínio para representar situações reais de criação, organização, comunicação, controle e execução de processos.

A utilização dos padrões tornou o sistema mais flexível, organizado e preparado para manutenção e evolução futura.

---

## Autor

Gustavo Zavon Pestana


# PCMania

Sistema de compras de computadores desenvolvido como exercício da disciplina de
Programação Orientada a Objetos (C206/C125) — Inatel.

## Identificação

- **Nome:** Isabela Moreira Mendes
- **Curso:** Engenharia da Computação
- **Matrícula:** 2268

## Sobre o projeto

A PC Mania é uma loja de computadores com três promoções. O sistema oferece ao cliente
uma interface de compra pelo terminal: ele escolhe os PCs digitando o código da promoção
(1, 2 ou 3), podendo levar opcionalmente uma memória USB com cada máquina, e encerra a
compra digitando 0. Ao final, são exibidas as informações do cliente, os PCs adquiridos
e o valor total da compra.

### Promoções

| | Promoção 1 | Promoção 2 | Promoção 3 |
|---|---|---|---|
| Marca | Apple | Samsung | Dell |
| Preço | R$ 2268 | R$ 2269 | R$ 2270 |
| Processador | Pentium Core i5 (2200 Mhz) | Pentium Core i7 (3370 Mhz) | Pentium Core i7 (4500 Mhz) |
| Memória RAM | 8 Gb | 16 Gb | 32 Gb |
| HD | 500 Gb | 1 Tb | 2 Tb |
| Sistema Operacional | macOS Sequoia (64 bits) | Windows 8 (64 bits) | Windows 10 (64 bits) |
| Acompanha | Pen-drive de 16 Gb | Pen-drive de 32 Gb | HD Externo de 1 Tb |

## Estrutura das classes

Todas as classes estão no pacote `br.inatel.poo`, dentro de `src`.

| Classe | Responsabilidade |
|---|---|
| `Cliente` | Guarda nome, CPF e os computadores comprados; calcula o total da compra |
| `Computador` | Marca, preço e configurações; mostra as próprias configurações |
| `HardwareBasico` | Peça do computador (processador, memória RAM, HD) |
| `SistemaOperacional` | Nome e tipo (bits) do sistema operacional |
| `MemoriaUSB` | Acessório opcional (pen-drive ou HD externo) |
| `ProcessarPedido` | Método utilitário que recebe o array de computadores e envia o pedido |
| `Main` | Interface de compra pelo terminal |

### Relações

- **Composição:** o `Computador` cria e é dono do seu `SistemaOperacional` e do array de
  `HardwareBasico` — eles nascem e morrem junto com o computador.
- **Agregação:** a `MemoriaUSB` existe independentemente e é entregue ao computador pelo
  método `addMemoriaUSB()`, sendo opcional (`0..1`).
- **Compra:** o `Cliente` compra no mínimo 2 computadores (`2..*`), regra validada pelo
  sistema antes de encerrar a compra.

Todos os atributos são `private`, e os getters foram criados apenas onde há uso real.

## Como executar

Abra o projeto no IntelliJ IDEA e execute a classe `Main` (`br.inatel.poo.Main`).

Pelo terminal:

```bash
javac -d out src/br/inatel/poo/*.java
java -cp out br.inatel.poo.Main
```

## Uso de Inteligência Artificial

Conforme solicitado no enunciado, declaro o uso de IA no desenvolvimento deste trabalho.

- **Modelo utilizado:** Claude Opus 5 (Claude Code)

### Prompts utilizados

- Criar o repositório no GitHub e o projeto no IntelliJ.
- Por que o atributo `hb` estava dando erro (diferença entre criar o array e criar cada objeto).
- Como apagar um pacote criado no lugar errado e como criar corretamente.
- Devo colocar `private` em atributos que são agregações?
- O que o `set` faz? É necessário usar `set` quando existe construtor?
- No construtor do `Computador` é necessário colocar os atributos de agregação?
- Quais getters e setters não estão sendo usados e em quais classes estão.
- O `calculaTotalCompra` é da classe `Cliente` e não do `Computador` — como o preço chega até ele?
- Como somar apenas as promoções que o usuário escolheu.
- O que é um método utilitário (helper)? A classe `ProcessarPedido` precisa de construtor?
- Onde chamar o método `mostraPCConfigs`.
- Conferir se todo o código está sendo utilizado (atributos, métodos e variáveis sem uso).
- Compilar e executar o projeto para verificar se o funcionamento está correto.
- Conferir se o projeto atende a todas as especificações do enunciado e do diagrama UML.

### O resultado foi satisfatório?

O resultado é considerado satisfatório por mim 

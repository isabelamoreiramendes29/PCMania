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

**Prompt 1: Criação do repositório e do projeto**

> "claude, crie um repositorio no github com o nome PC_Mania, e crie um arquivo no intelij
> com o mesmo nome"

Resposta aceita integralmente: a IA criou o repositório público no GitHub e montou a estrutura
inicial do projeto Java no IntelliJ (pasta `src`, arquivo `.iml` e configuração do JDK 17), com
uma classe `Main` vazia. Esta foi a única etapa em que a IA escreveu arquivos do projeto; a
partir daqui, pedi expressamente que ela não editasse mais o código, e todas as classes foram
digitadas por mim.

**Prompt 2: Erro no atributo `hb`**

> "claude, porque o atributo hb esta errado"

Resposta aceita integralmente: a IA identificou três problemas distintos. O atributo estava
declarado como array (`HardwareBasico[] hb`) mas sendo instanciado como objeto único
(`new HardwareBasico()`); no `Main` o índice estava na posição errada (`hb.nome[i]` em vez de
`hb[i].nome`); e os atributos `nome` e `capacidade` eram `private`, exigindo getters. A
discussão esclareceu a diferença entre **criar o array** (`new HardwareBasico[3]`) e **criar
cada objeto dentro dele** (`hb[i] = new HardwareBasico()`) — os dois são necessários, e foi
justamente essa distinção que eu não tinha entendido.

**Prompt 3: Encapsulamento em atributos de agregação**

> "devo colocar private em atributos que são agregações?"

Resposta aceita integralmente: a IA explicou que o encapsulamento não distingue tipo primitivo
de objeto, portanto todos os atributos devem ser `private`, inclusive os de agregação e
composição. A discussão também classificou minhas relações: `sop` e `hb` são **composição**
(criados dentro do construtor) e `memoriausb` é **agregação** (recebida de fora). Apliquei
`private` em todos os atributos das cinco classes de modelo.

**Prompt 4: Função do `set` e necessidade dele com construtor**

> "o set faz o que?" / "e necessario usar o set quando tem contrutor?"

Resposta aceita com ajustes: a IA explicou o funcionamento do setter, o papel do `this` quando
atributo e parâmetro têm o mesmo nome, e que construtor e setter agem em momentos diferentes —
o construtor no nascimento do objeto, o setter na alteração posterior. A partir disso decidi
migrar para construtores com parâmetros em todas as classes e **remover os setters**, já que
nenhum valor muda depois da criação. Isso também atendeu à regra do enunciado sobre não criar
getters e setters desnecessários.

**Prompt 5: Atributos de agregação nos parâmetros do construtor**

> "no construtor do computador é necessario colocar os atrobutos de agregação tbm?"

Resposta aceita integralmente: a IA respondeu que não. A regra apresentada foi que parâmetro
serve para aquilo que o construtor não tem como saber sozinho — como `sop` e `hb` são
composição, o próprio construtor os cria; e como `memoriausb` é agregação opcional (`0..1` no
diagrama), ela chega depois, pelo `addMemoriaUSB()`. Os parâmetros do construtor ficaram apenas
com marca, preço e os dados das peças.

**Prompt 6: Localização do método `calculaTotalCompra`**

> "no metodo calculatotalcompra como preciso somar os valores das promoções que foram
> escolhidas o parametro preço deve aparecer nesse metodo, certo?" / "mas esse metodo e da
> classe cliente e nao computador"

Resposta aceita com ajustes: a IA sugeriu receber objetos `Computador` em vez de valores `float`
soltos, para que o cliente possa pedir o preço a cada computador pelo `getPreco()`. Na discussão
seguinte ficou esclarecido que um método do `Cliente` pode, sim, usar objetos de outra classe —
isso é colaboração entre objetos, e o método fica na classe dona da responsabilidade. Optei por
guardar o array dentro do próprio `Cliente`, pelo método `comprar()`, deixando o
`calculaTotalCompra()` sem parâmetros, exatamente como aparece no diagrama UML.

**Prompt 7: Registro das promoções escolhidas pelo usuário**

> "beleza, mas ai é necessario fazer as alterações ja que a soma depende de quais promoçoes o
> usuario vai escolher"

Resposta aceita com ajustes: a IA propôs o padrão **array + contador**, com um método de
registro por compra e um laço percorrendo apenas até o contador (e não até `length`), para não
esbarrar nas posições `null`. Implementei o array `comprados` com o contador `qtdComprados` no
`Main`, entregando-o ao `Cliente` depois do laço, em vez de o cliente controlar o contador
internamente.

**Prompt 8: Método utilitário (helper) e a classe `ProcessarPedido`**

> "o que e um metodo utilitario helper" / "em processar pedido eu preciso criar um construtor?"

Resposta aceita integralmente: a IA explicou que método utilitário é declarado como `static`,
pertence à classe e não ao objeto (como `Math.sqrt()`), e que a `ProcessarPedido` não precisa de
construtor por não guardar estado. Recebi também o alerta de não transformar tudo em `static`,
o que descaracterizaria a orientação a objetos. Implementei o `enviarPedido` como
`public static void`, chamado por `ProcessarPedido.enviarPedido(...)`, sem instanciar a classe.

**Prompt 9: Onde chamar o `mostraPCConfigs`**

> "claude onde eu coloco o metodo mostrapccofig?" / "vou criar um mostrapcconfig antes do while
> um depois mostrando qual o cliente escolheu, esta certo?"

Resposta aceita com ajustes: a IA apontou que, chamado apenas dentro do `switch`, o método
mostrava as configurações só **depois** da escolha, deixando o usuário decidir às cegas. Decidi
chamá-lo antes do laço (como vitrine das três promoções) e depois do laço (como resumo da
compra), retirando-o das opções do `switch` para não repetir a mesma saída três vezes.

**Prompt 10: Memória USB como item opcional**

> "claude esta faltando o addicionar o memorua usb ja que é opcional"

Resposta aceita integralmente: neste caso fui eu quem identificou o problema — o código
adicionava a memória USB a todos os computadores automaticamente, contrariando a multiplicidade
`0..1` do diagrama. A IA confirmou o diagnóstico e mostrou como perguntar ao usuário dentro de
cada `case`, alertando para uma armadilha do Java: todos os `case` de um `switch` compartilham o
mesmo escopo, então a variável de resposta precisa ser declarada **fora** dele. Implementei a
pergunta nos três casos, com a variável `adicionar` declarada antes do laço.

**Prompt 11: Criação de pacotes no IntelliJ**

> "nao estou conseguindo criar um pacote, me mostre passo a passo" / "mas o src do projeto sumiu"

Resposta aceita integralmente: a IA explicou o passo a passo pelo `Refactor > Move` (`F6`),
alertando que todas as classes precisam ser movidas juntas, porque uma classe no *default
package* não pode ser importada por outra que esteja dentro de um pacote. O sumiço da pasta
`src` era apenas a janela do IntelliJ trocada da visualização "Project" para "Packages" — nada
havia sido apagado. Criei o pacote `br.inatel.poo` e movi as sete classes.

**Prompt 12: Verificação de código não utilizado**

> "veja os getter e setter que nao estou usando" / "pronto, agora confira se tudo o que esta na
> programação esta sendo utilizado"

Resposta aceita com ajustes: a IA levantou todos os métodos, atributos e variáveis sem uso.
Removi os desnecessários, mas **reintroduzi** o `getNome()` e o `getCpf()` do `Cliente`, que a
análise havia apontado como órfãos — eles são necessários para exibir as informações do cliente
ao final da compra, como o enunciado pede.

**Prompt 13: Compilação e execução do projeto**

> "pronto! claude rode o codigo e veja se esta funcionando"

Resposta aceita integralmente: a IA compilou o projeto, apontou os erros restantes (getters
ausentes no `SistemaOperacional`) e, depois de corrigidos, executou o programa com entradas de
teste. A execução confirmou o total correto da compra, a exibição do acessório apenas para quem
o aceitou e o funcionamento da validação de mínimo de dois computadores.

**Prompt 14: Conferência com o enunciado e o diagrama UML**

> "vou te mandar o arquivo inteiro e veja se esta tudo de acordo como que foi pedido pelo
> professor"

Resposta aceita com ressalva: a IA conferiu o projeto contra o enunciado e o diagrama, validando
os dados das promoções, os tipos dos atributos, as multiplicidades e as relações de composição e
agregação. Uma sugestão que a IA havia feito antes — fazer o `enviarPedido` listar os
computadores recebidos — foi **descartada** nesta etapa, porque o enunciado pede apenas a
mensagem na tela. Serviu como lembrete de que a análise genérica de boas práticas nem sempre
corresponde ao que foi pedido no exercício.

### O resultado foi satisfatório?

O resultado é considerado satisfatório por mim 

# Documentação do Projeto Labirinto


## Resumo
1. [Descrição do Projeto](#descrição-do-projeto)
2. [Estrutura do Projeto](#estrutura-do-projeto)
3. [Funcionalidades](#funcionalidades)
4. [Casos de Teste](#casos-de-teste)
5. [Como Executar](#como-executar)
6. [Formato do CSV](#formato-do-csv)

## Descrição do Projeto
Este projeto é um simulador de labirinto desenvolvido em Java. Utiliza uma técnica de backtracking para encontrar um caminho de entrada à saída em diferentes labirintos. Os labirintos são carregados de arquivos CSV, permitindo uma fácil modificação e criação de novos cenários de teste.

## Estrutura do Projeto
O projeto é composto por duas classes principais:
- **Labirinto**: Gerencia a lógica do labirinto, incluindo o carregamento do labirinto a partir de um arquivo CSV, a busca por um caminho, a verificação de validade das posições e a exibição do labirinto.
- **Application**: Contém o método main, que inicializa o labirinto, exibe o labirinto original, encontra a solução e a exibe.

## Funcionalidades
- Carregar labirintos a partir de arquivos CSV.
- Encontrar caminhos utilizando a técnica de backtracking.
- Exibir o labirinto original e o caminho encontrado.

## Casos de Teste
O projeto inclui os seguintes arquivos CSV de teste que representam diferentes labirintos:
1. `labirinto_30x30_voltas.csv`: Um labirinto de 30x30 com várias voltas, que exige uma navegação complexa para encontrar a saída.
2. `labirinto_dificil_50x50.csv`: Um labirinto mais complicado de 50x50, que apresenta vários caminhos e armadilhas.
3. `labirinto_sem_saida_50x50.csv`: Um labirinto de 50x50 que não possui saída, utilizado para testar a capacidade do algoritmo de identificar a impossibilidade de encontrar um caminho.
4. `labirinto_facil_100x100.csv`: Um labirinto fácil de 100x100, com caminhos mais diretos e menos obstruções.

## Comportamento Esperado
- Para labirintos com saída, o programa deve exibir o caminho encontrado com um marcador "X".
- Para labirintos sem saída, o programa deve indicar que nenhum caminho foi encontrado.

## Como Executar
### Pré-requisitos
- Java JDK instalado no seu sistema.
- Um editor de texto ou IDE para editar arquivos Java (como IntelliJ IDEA, Eclipse, ou VS Code).

### Passos para Execução
1. Clone o Repositório :
    ```bash
    git clone https://github.com/jhonbsi/TPAlabirinto.git
    cd TPAlabirinto
    ```
2. Coloque os arquivos CSV: Certifique-se de que os arquivos CSV de labirinto estão na mesma pasta do projeto ou ajuste o caminho no código na classe Labirinto.
3. Compile e Execute o Projeto: Utilize um ambiente de desenvolvimento Java ou compile e execute a partir da linha de comando:
    ```bash
    javac Application.java Labirinto.java
    java Application
    ```

## Formato do CSV
Os arquivos CSV devem ter a seguinte estrutura, onde cada linha representa uma linha da matriz do labirinto:
- Células:
    - "1": Representa um caminho livre.
    - "0": Representa uma parede.


## Notas
- O projeto é extensível. Novos labirintos podem ser facilmente ampliados criando novos arquivos CSV com diferentes configurações.
- O desempenho do algoritmo pode ser avaliado com labirintos maiores e mais complexos.



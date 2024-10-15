import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

public class Labirinto {
    private ArrayList<String[]> matriz;
    private int[] entrada;
    private int[] saida;
    private Stack<int[]> caminhoSolucao;
    private int[][] solution; // Matriz de solução

    public Labirinto() {
        matriz = new ArrayList<>();
        caminhoSolucao = new Stack<>();
        carregarLabirinto();
        entrada = acharEntrada();
        saida = acharSaida();
        solution = new int[matriz.size()][matriz.get(0).length]; // Inicializa a matriz de solução
    }

    public void mostrarCaminhoSolucao() {
        while (!caminhoSolucao.isEmpty()) {
            int[] coord = caminhoSolucao.pop();
            matriz.get(coord[0])[coord[1]] = "X";
        }
    }

    public void encontrarSolucao() {
        if (findPath(entrada[0], entrada[1])) {
            System.out.println("CAMINHO ENCONTRADO");
        } else {
            System.out.println("NÃO ENCONTRADO");
        }
    }


    private boolean findPath(int x, int y) {
        // Se atingiu a saída, o caminho foi encontrado
        if (x == saida[0] && y == saida[1]) {
            caminhoSolucao.push(new int[]{x, y});
            return true;
        }


        if (limiteMatriz(x, y)) {
            solution[x][y] = 1;


            int[] moveX = {1, 0, -1, 0, 1, -1, 1, -1};
            int[] moveY = {0, 1, 0, -1, 1, -1, -1, 1};

            for (int i = 0; i < 8; i++) {
                int newX = x + moveX[i];
                int newY = y + moveY[i];


                if (findPath(newX, newY)) {
                    caminhoSolucao.push(new int[]{x, y});
                    return true;
                }
            }


            solution[x][y] = 0;
        }
        return false;
    }

    // Verifica se a posição (x, y) é válida para prosseguir
    private boolean limiteMatriz(int x, int y) {
        return (x >= 0 && y >= 0 && x < matriz.size() && y < matriz.get(0).length &&
                matriz.get(x)[y].equals("1") && solution[x][y] == 0);
    }


    private int[] acharEntrada() {
        for (int i = 0; i < matriz.size(); i++) {
            for (int j = 0; j < matriz.get(0).length; j++) {
                if (matriz.get(i)[j].equals("1")) {
                    if (i == 0 || i == matriz.size() - 1 || j == 0 || j == matriz.get(0).length - 1) {
                        return new int[]{i, j};
                    }
                }
            }
        }
        return null;
    }

    private int[] acharSaida() {
        for (int i = 0; i < matriz.size(); i++) {
            for (int j = 0; j < matriz.get(0).length; j++) {
                if (matriz.get(i)[j].equals("1")) {
                    if (i == 0 || i == matriz.size() - 1 || j == 0 || j == matriz.get(0).length - 1) {
                        int[] coord = new int[]{i, j};
                        if (!((coord[0] == entrada[0]) && (coord[1] == entrada[1]))) {
                            return coord;
                        }
                    }
                }
            }
        }
        return null;
    }


    public void mostrarLabirinto() {
        for (String[] strings : matriz) {
            for (int j = 0; j < strings.length; j++) {
                System.out.print(strings[j] + " ");
            }
            System.out.print("\n");
        }
    }

    private void carregarLabirinto() {
        String arquivo = "labirinto_30x30_voltas.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String line = br.readLine();
            while (line != null) {
                String[] linha = line.split(",");
                matriz.add(linha);
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

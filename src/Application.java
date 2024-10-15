public class Application {
    public static void main(String[] args) {
        Labirinto labirinto = new Labirinto();
        System.out.println("Labirinto Original:");
        labirinto.mostrarLabirinto();
        labirinto.encontrarSolucao();
        System.out.println("---------------------");
        System.out.println("Caminho da Solução:");
        labirinto.mostrarCaminhoSolucao();
        labirinto.mostrarLabirinto();
    }
}
import java.util.ArrayList;
import java.util.Random;
import GeraMochila;

public class App {

    static ArrayList<ItemMochila> itens = new ArrayList<ItemMochila>();
    
    public static void main(String[] args) throws Exception {
        int max = 50;
        int itens = 5;
        Random capacidadeRand = new Random();
        int capacidade = capacidadeRand.nextInt(500);
        Mochila mochila = new Mochila();
        while(tempo<4000){
            long inicio = System.currentTimeMillis();
            mochila = GeraMochila.GerarItensMochila(itens, max);
            Collections.sort(mochila.getItemMochila());
            int peso = 0;
            mochila.getItemMochila().stream().mapToDouble(itens -> peso += itens.getPeso());
            for (int i= 1; i <=itens; i++){
                algoritmoForcaBruta(capacidade, i, itens);
            }
            long fim = System.currentTimeMillis();
            long tempo = fim - inicio;
            System.out.println(tempo);
        }
        int repeticao = 0;

        while(repeticao<500){
            mochila = GeraMochila.GerarItensMochila(itens, max);
            int peso = 0;
            mochila.getItemMochila().stream().mapToDouble(itens -> peso += itens.getPeso());
            for (int i= 1; i <=itens; i++) {
                algoritmoForcaBruta(itens, i, mochila);
            }
            algoritmoGuloso(itens, mochila);
        }
    }

    public static void algoritmoGuloso(int capacidade, Mochila mochila) {
        String leitor;

        AlgoritmoGuloso algGul = new AlgoritmoGuloso(mochila);
        algGul.preencherMochila(itens);
        
        leitor = algGul.toString();
        System.out.println(leitor);
    }

    public static void algoritmoForcaBruta(int capacidade, Mochila mochila) {
        String leitor;

        AlgoritmoForcaBruta algForca = new AlgoritmoForcaBruta(mochila);
        algForca.preencherMochila(itens);

        leitor = algForca.toString();
        System.out.println(leitor);
    }

    public void realizarMetodos() {
        Random capacidadeRand = new Random();
        int capacidade = capacidadeRand.nextInt(500);

        Mochila mochila = new Mochila(capacidade);
        itens = geradorItens(capacidade);

        algoritmoForcaBruta(capacidade, mochila);
        System.out.println("\n");
        algoritmoGuloso(capacidade, mochila);
    }
}

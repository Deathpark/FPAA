import java.util.Random;
public class GeraMochila {
    public Mochila GerarItensMochila(int capacidade, int max) {
        Radom gerador = new Random();
        Mochila mochila = new Mochila(capacidade, max);
        int pesoGerado = 3*(max/capacidade);
        int total = 0;
        for (int i = 0; i< capacidade; i++){
            int peso = gerador.nextInt(pesoGerado) + 1;
            int valor = gerador.nextInt(pesoGerado) + 1;
            mochila.adicionarItem(new ItemMochila(peso, valor));
            total += peso;
        }
        int peso = 3*max;
        peso = peso - total;
        peso = peso/capacidade;
        int Peso = peso;
        mochila.getItemMochila().stream().mapToDouble(itens -> itens.setPeso(itens.getPeso()+ Peso + gerador.nextInt(2)));
        return mochila;
    }
}

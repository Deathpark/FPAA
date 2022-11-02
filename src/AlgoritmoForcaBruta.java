import java.util.ArrayList;
import java.util.Iterator;

public class AlgoritmoForcaBruta {
    private Mochila mochila;

    public AlgoritmoForcaBruta(Mochila mochila) {
        this.mochila = mochila;
    }

    public void preencherMochila(int qtdItens, int i, ArrayList<ItemMochila> itens) {
        int aux=0;
        Iterator<ItemMochila> iterador = itens.iterator();

        ItemMochila[] vetorItens = new ItemMochila[qtdItens];

        while (iterador.hasNext()){
            vetorItens[aux] = iterador.next();
            aux++;
        }
        for (int q=0; q <= qtdItens;q++){
            Mochila mochilaCandidata = new Mochila((int) this.mochila.getCapacidade(), 50);
            for (int j = 0; j <= i; j++){
                mochilaCandidata.insertItem(vetorItens[j]);
                if (mochilaCandidata.getPeso() <= mochilaCandidata.getCapacidade()) {
                    if (mochilaCandidata.getValor() > this.mochila.getValor()){
                        this.mochila = mochilaCandidata;
                    }
                } else{
                    mochilaCandidata.zeraPesoValor();
                }
            }
        }
    }

    @Override
    public String toString(){
        String aux = "Algoritmo Força Bruta:"
                +"\nPeso da mochila: " + this.mochila.getPeso()
                +"\nValor na mochila: " + this.mochila.getValor()
                +"\nCapacidade da mochila: " + this.mochila.getCapacidade();
        return aux;
    }

    public Mochila getMochila() {
        return this.mochila;
    }
}

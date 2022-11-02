import java.util.ArrayList;

public class AlgoritmoGuloso {
    private Mochila mochila;

    public AlgoritmoGuloso(Mochila mochila) {
        this.mochila = mochila;
    }

    public void preencherMochila(ArrayList<ItemMochila> itens) {
        if(mochila.getPeso() >= mochila.getCapacidade()) {
            System.out.println("A mochila já está em capacidade máxima");
            return;
        }

        for (ItemMochila item : itens) {
            if(mochila.getPeso() + item.getPeso() > mochila.getCapacidade()) {
                this.mochila.adicionarItem(item);
            } else if(mochila.getPeso() == mochila.getCapacidade()) {
                break;
            }
        }

    }

    public Mochila getMochila() {
        return this.mochila;
    }

    @Override
    public String toString(){
        String aux = "Algoritmo Guloso:"
                     +"\nPeso da mochila: " + this.mochila.getPeso()
                     +"\nValor na mochila: " + this.mochila.getValor()
                     +"\nCapacidade da mochila: " + this.mochila.getCapacidade();
        return aux;
    }
}

import java.util.ArrayList;

public class Mochila {
    private ArrayList<ItemMochila> itens;
    private double capacidade;
    private double peso;
    private double valor;
    
    public Mochila(int capacidade, double peso) {
        this.itens = new ArrayList<ItemMochila>();
        this.capacidade = capacidade;
        this.peso = peso;
        this.valor = 0;
    }

    public Mochila(ArrayList<ItemMochila> itens, int capacidade, int peso) {
        this.itens = itens;
        this.capacidade = capacidade;
        this.peso = peso;
    }

    public void insertItem(ItemMochila item) {
        if(this.peso + item.getPeso() <= this.capacidade) {
            this.itens.add(item);
            this.peso += item.getPeso();
            this.valor += item.getValor();
        }
    }

    private void somarValor(){
        double valor = 0;
        for (ItemMochila item: itens){
            valor = valor + item.getValor();
        }
        this.valor = valor;
    }

    public double getPeso() {
        return this.peso;
    }

    public double getCapacidade() {
        return this.capacidade;
    }

    public void adicionarItem(ItemMochila item) {
        this.itens.add(item);
        this.peso += item.getPeso();
        this.valor = item.getValor();
    }
    public ArrayList<ItemMochila> getItemMochila() {
        return itens;
    }

    public double getValor(){
        return this.valor;
    }

    public void zeraPesoValor(){
        this.peso = 0;
        this.valor = 0;
    }

    public ArrayList<ItemMochila> getItens() {
        return this.itens;
    }

}
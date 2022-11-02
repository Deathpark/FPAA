public class ItemMochila {

    private double peso;
    private double valor;

    public ItemMochila(double peso, double valor) {
        this.peso = peso;
        this.valor = valor;
    }

    public double setPeso(double peso) {
        this.peso = peso;
    }
    public double getPeso() {
        return this.peso;
    }

    public double getValor() {
        return this.valor;
    }
}
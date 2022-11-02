import java.util.ArrayList;

public class ForcaBruta {
    //dado um conjunto C de números inteiros c1, c2, 
    //c3, c4... cn, existe um subconjunto de C cuja soma dos 
    //elementos atinge exatamente um valor V? 

    private int valor;
    private ArrayList<Integer> conjunto;

    public ForcaBruta() {
        this.valor = 0;
        this.conjunto = new ArrayList<Integer>();
    }

    public ForcaBruta(int valor, ArrayList<Integer> conjunto) {
        this.valor = valor;
        this.conjunto = conjunto;
    }

    public boolean verificaSubConjunto(ArrayList<Integer> subconjunto, int valor) {
        int soma = 0;

        for(int i = 0; i < subconjunto.size(); i++) {
            if (soma == valor) {
                return true;    
            }
            if(soma > valor) {
                return false;
            }
        }

        return false;
    }

    public void geradorDeConjuntos(ArrayList<Integer> conjunto, int valor) {
        if(conjunto.size() < 2) {
            System.out.println("Tamanho de conjunto inválido");
            return;
        }

        for(int i = 0; i < conjunto.size(); i++) {
            ArrayList<Integer> conjuntoAux = conjunto;
            ArrayList<Integer> subConjunto = new ArrayList<Integer>();
            for(int c = i; c < conjunto.size(); c++) {
                subConjunto.add(conjuntoAux.get(c));
                conjuntoAux.remove(conjuntoAux.get(c));
            }
            
            boolean valorIgual = this.verificaSubConjunto(subConjunto, valor);
            if(valorIgual) {
                System.out.println("O subconjunto abaixo possui a soma igual ao valor passado");
            }
        }
    }
}

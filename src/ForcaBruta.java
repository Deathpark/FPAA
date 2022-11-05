import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

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

    static public boolean verificaSubConjunto(ArrayList<Integer> subconjunto, int valor) {
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

    static private ArrayList<Integer> clonarSubConjunto(ArrayList<Integer> subConjunto) {
        ArrayList<Integer> clone = new ArrayList<Integer>();
        
        for(int i =0; i < subConjunto.size(); i++) {
            clone.add(subConjunto.get(i));
        }

        return clone;
    }

    static public void acharTodosSubConjuntos(ArrayList<ArrayList<Integer>> subConjuntos, ArrayList<Integer> conjunto, int index) {
        if(index == conjunto.size()) {
            return;
        }

        int qndSubConjunto = subConjuntos.size();
        ArrayList<Integer> novoConjunto;

        for(int i = 0; i < qndSubConjunto; i++) {
            novoConjunto = clonarSubConjunto(subConjuntos.get(i));
            novoConjunto.add(conjunto.get(index));
            subConjuntos.add(novoConjunto);
        }

        acharTodosSubConjuntos(subConjuntos, conjunto, index+1);
    }

    static public ArrayList<ArrayList<Integer>> acharTodosSubConjuntos(ArrayList<Integer> conjunto) {
        ArrayList<ArrayList<Integer>> subConjuntos = new ArrayList<ArrayList<Integer>>();

        subConjuntos.add(new ArrayList<Integer>());

        acharTodosSubConjuntos(subConjuntos, conjunto, 0);

        return subConjuntos;
    }

    static public ArrayList<Integer> geradorDeConjuntos(int tamanhoConjunto) {
        Random random = new Random();
        ArrayList<Integer> conjunto = new ArrayList<>();

        for(int i = 0; i < tamanhoConjunto; i++) {
            int num = random.nextInt(10);
            
            if(num < 0) {
                do {
                    num = random.nextInt(10);
                } while (num < 0);
            }
            conjunto.add(num);
        }

        return conjunto;
    }

    
    private static void compararResultados(ArrayList<ArrayList<Integer>> subConjuntos, int valor) {
        int soma = 0, i = 0;
        do {
            soma = 0;
            
            ArrayList<Integer> conjunto = subConjuntos.get(i);
            
            for(int j = 0; j < conjunto.size(); j++) {
                soma += conjunto.get(j);
            }

            i++;
        } while(i < subConjuntos.size() && valor != soma);

        if(valor == soma) {
            i--;
            System.out.println("O conjunto abaixo satisfaz a soma:");
            System.out.print("{");
            for (Integer num : subConjuntos.get(i)) {
                System.out.print(num + ", ");
            }
            System.out.println("}");
        } else {
            System.out.println("Nenhum subconjunto satisfaz a soma!");
        }
    }

    public long inicio(int tamanhoVetor, int valor) {
        ArrayList<Integer> conjunto = new ArrayList<>();
        conjunto = geradorDeConjuntos(tamanhoVetor);
        
        long tempoIncial = System.currentTimeMillis();
        ArrayList<ArrayList<Integer>> subConjuntos = acharTodosSubConjuntos(conjunto);
        compararResultados(subConjuntos, valor);
        long tempoTotal = System.currentTimeMillis() - tempoIncial;

        return tempoTotal;
    }

    public static void main(String[] args) {
        
    }
}

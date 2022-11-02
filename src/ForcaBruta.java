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

    public static void main(String[] args) {
        ForcaBruta solucao = new ForcaBruta();

        Scanner teclado = new Scanner(System.in);
        System.out.println("Digite o tamanho do vetor:");
        int tamanhoVetor = teclado.nextInt();
        
        if(tamanhoVetor < 2) {
            do {
                System.out.println("O tamanho do vetor deve ser maior que 2!");
                System.out.println("Digite novamente o tamanho do vetor!");
                tamanhoVetor = teclado.nextInt();
            } while(tamanhoVetor < 2);
        }

        ArrayList<Integer> conjunto = new ArrayList<>();
        conjunto = geradorDeConjuntos(tamanhoVetor);

        ArrayList<ArrayList<Integer>> subConjuntos = acharTodosSubConjuntos(conjunto);
        
        //Pegar valor a ser comparado do teclado
        //Criar função para comparar todos as somas

        System.out.println("****Total*****" + subConjuntos.size());
        for (int i = 0; i < subConjuntos.size(); ++i) {
          System.out.print("{");
          for (Integer it : subConjuntos.get(i)) {
            System.out.print(it + ", ");
          }
          System.out.println("}");
        }
        System.out.println("****Total*****" + subConjuntos.size());
      }
  
            //boolean valorIgual = this.verificaSubConjunto(subConjunto, valor);
            //if(valorIgual) {
            //    System.out.println("O subconjunto abaixo possui a soma igual ao valor passado");
            //}
}

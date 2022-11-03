import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ForcaBrutaTest {

    @Test
    public void  iniciarTeste() {
        ForcaBruta forcaBruta = new ForcaBruta();
        Scanner teclado = new Scanner(System.in);
        //System.out.println("Digite o tamanho do vetor:");
        //int tamanhoVetor = teclado.nextInt();
        //if(tamanhoVetor < 2) {
        //    do {
        //        System.out.println("O tamanho do vetor deve ser maior que 2!");
        //        System.out.println("Digite novamente o tamanho do vetor:");
        //        tamanhoVetor = teclado.nextInt();
        //    } while(tamanhoVetor < 2);
        //}
        //System.out.println("Digite o valor que deve ser comparado:");
        //int valor = teclado.nextInt();
        //if(valor < 0) {
        //    do {
        //        System.out.println("O valor deve ser positivo!");
        //        System.out.println("Digite novamente o valor:");
        //        valor = teclado.nextInt();
        //    } while(valor < 0);
        //}

        long tempoExecucao = 0;
        int i = 2;
        do {
            tempoExecucao = forcaBruta.inicio(i, 10);
            System.out.println("Tempo de execução: " + (tempoExecucao/1000) + "segundos");
        } while(i < 150 && tempoExecucao < 4000);
     }
}

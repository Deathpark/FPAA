import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ForcaBrutaTest {

    @Test
    public void  iniciarTeste() {
        ForcaBruta forcaBruta = new ForcaBruta();
        long tempoExecucao = 0;
        int i = 2;
        double media = 0, soma = 0;

        //Execução até 4000ms
        //do {
        //    tempoExecucao = forcaBruta.inicio(i, 10);
        //    System.out.println("Tempo de execução: " + tempoExecucao + "milisegundos");
        //    i++;
        //} while(i < 150 && tempoExecucao < 4000);
        
        //Execução até média das execuções < 4000
        do {
            tempoExecucao = forcaBruta.inicio(i, 10);
            System.out.println("Tempo de execução: " + tempoExecucao + "milisegundos");
            i++;
            soma += tempoExecucao;
            media = soma/i;
        } while(i < 150 && media < 4000);
        
        //Sem condição de parada
        //do {
        //    tempoExecucao = forcaBruta.inicio(i, 10);
        //    System.out.println("Tempo de execução: " + tempoExecucao + "milisegundos");
        //    i++;
        //    soma += tempoExecucao;
        //    media = soma/i;
        //} while(i < 150 && media < 4000);

        assertEquals(1, 1);
     }
}

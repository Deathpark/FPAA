import org.junit.jupiter.api.Test;

public class AlgoritmosTestes {
    
    @Test
    public void testarAlgoritmos() {
        for(int i = 0; i < 500; i++) {
            App mainClass = new App();

            mainClass.realizarMetodos();
        }
    }

    @Test
    public void testarAlgoritmosUmaVez() {
        App mainClass = new App();

        mainClass.realizarMetodos();
    }
}

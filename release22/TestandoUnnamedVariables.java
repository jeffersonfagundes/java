package release22;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedHashMap;

/**
 * Variais obrigatórias que não serão utilizadas no algoritmo pode ser substituidas por _
 * */
public class TestandoUnnamedVariables {

    public static void main(String[] args) {
        //Exemplo de um try catch
        try {
            new FileReader("exemplo.txt");
        } catch (FileNotFoundException _) {
            System.err.println("Arquivo não Encontrado");
        }
        //Exemplo no Lambda
        var map = new LinkedHashMap<>();
        map.putLast(1, "Um");
        map.put(2, "Dois");
        map.putLast(3, null);

        System.out.println("Inclui o valor faltante: " + map.computeIfAbsent(3, _ -> "três"));

        System.out.println("Resultado: " + map);
    }
}

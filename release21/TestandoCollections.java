package release21;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;

public class TestandoCollections {

    public static void main(String[] args) {
        var testList = List.of(3, 4, 5);

        System.out.println("Deve imprimir o primeiro item: " + testList.getFirst());
        System.out.println("Deve imprimir o ultimo item: " + testList.getLast());

        //Em List os objetos são imutaveis então addFirst, removeFirst, addLast e removeLast não funcionam

        var testArrayListe = new ArrayList<>(testList);
        testArrayListe.addFirst(2);
        System.out.println("Esse deve adicionar um novo primeiro item: " + testArrayListe.getFirst());
        ;
        System.out.println("Esse deve remover o primeiro item: " + testArrayListe.removeFirst());
        System.out.println("Deve imprimir o primeiro item: " + testList.getFirst());

        System.out.println("Retorno lista tradicional: " + testList);
        System.out.println("Retorno lista reversa: " + testList.reversed());

        testArrayListe.addFirst(6);
        System.out.println("Retorno sem sort: " + testArrayListe);
        testArrayListe.sort(Comparator.naturalOrder());
        System.out.println("Retorno sort: " + testArrayListe);

        testArrayListe.addFirst(8);
        testArrayListe.sort(Comparator.reverseOrder());
        System.out.println("Retorno reverse sort: " + testArrayListe);

        var testSequencedMap = new LinkedHashMap<Integer, String>();
        testSequencedMap.putFirst(1, "Um");
        testSequencedMap.putFirst(2, "Dois");
        testSequencedMap.putLast(3, "Três");

        System.out.println("Retorno Map tradicional: " + testSequencedMap);
        System.out.println("Retorno Map reversa: " + testSequencedMap.reversed());

        System.out.println("Retorno Map pool: " + testSequencedMap.pollFirstEntry());

    }
}

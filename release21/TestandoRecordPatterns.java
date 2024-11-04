package release21;

public class TestandoRecordPatterns {

    public static void main(String[] args) {
        var ex = new Exemplo(1, 3);

        var oj = (Object) ex;

        if(oj instanceof Exemplo2(int x, int y)) {
            System.out.println("Não deve entrar no if: " + ex);
        }

        if(oj instanceof Exemplo(int x, int y)) {
            System.out.println("Deve entrar no if: " + ex);
        }

        System.out.println(patternSwitch(1));
        System.out.println(patternSwitch(2L));
        System.out.println(patternSwitch("TEstString123"));
        System.out.println(patternSwitch(1.903));
        System.out.println(patternSwitch(oj));
    }

    static String patternSwitch(Object object) {
        return switch (object) {
            case Integer i -> "int %d".formatted(i);
            case Long l -> "long %d".formatted(l);
            case Double d -> "double %f".formatted(d);
            case String s -> "Sring %s".formatted(s);
            default -> object.toString();
        };
    }
}

record Exemplo(int x, int y) {

}

record Exemplo2(int x, int y) {

}


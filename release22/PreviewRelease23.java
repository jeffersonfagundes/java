package release22;

public class PreviewRelease23 {

    void main() {
        //Intellij ainda não esta pronto na versão 2024.2.4 para reconhecer automaticamento este main como run init
        System.out.println("Main mais simplificado");
    }

    public static void main(String[] args) {
        var angulo = new Angulo(1.8);
        System.out.println("Graus do angulo: " + angulo.getGraus());
    }
}

class Angulo extends Forma {

    public Angulo(double graus) {
        super(Math.toRadians(graus));
    }
}

class Forma {

    private double graus;

    public Forma(double graus) {
        this.graus = graus;
    }

    public double getGraus() {
        return graus;
    }
}

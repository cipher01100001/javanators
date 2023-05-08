import java.util.ArrayList;

public class Semestre {
    private int numero;
    private ArrayList<Materia> materias;

    public Semestre(int numero) {
        this.numero = numero;
        this.materias = new ArrayList<>();
    }

    public void addMateria(String nombre, int creditos) {
        materias.add(new Materia(nombre, creditos));
    }

    public int getNumero() {
        return numero;
    }

    public ArrayList<Materia> getMaterias() {
        return materias;
    }

    public double getPromedio() {
        double promNotasTotal = 0.0;
        double creditosTotal = 0.0;

        for (Materia materia : this.materias) {
            promNotasTotal += materia.getPromedio() * materia.getCreditos();
            creditosTotal += materia.getCreditos();
        }
        return promNotasTotal / creditosTotal;
    }
}

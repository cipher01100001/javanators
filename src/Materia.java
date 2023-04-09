import java.util.ArrayList;

public class Materia {
    private String nombre;
    private int creditos;
    private ArrayList<Nota> notas;

    public Materia(String nombre, int creditos) {
        this.nombre = nombre;
        this.creditos = creditos;
        this.notas = new ArrayList<>();
    }

    public void addNota(double valor, int porcentaje) {
        notas.add(new Nota(valor, porcentaje));
    }

    public String getNombre() {
        return nombre;
    }
    public int getCreditos() {
        return creditos;
    }

    public void getInfo() {
        System.out.println("Materia: " + this.nombre);
        System.out.println("Número de creditos: " + this.creditos);
        System.out.println("Notas: ");
        for (Nota nota : this.notas) {
            System.out.println(" | " + nota.getValor() + " con un porcentaje de: " + nota.getPorcentaje() + "% | ");
        }
    }

    public ArrayList<Nota> getNotas() {
        return this.notas;
    }

    public double getPromedio() {
        double notasTotal = 0.0;
        double porcentajeTotal = 0.0;

        for (Nota nota : this.notas) {
            notasTotal += nota.getValor() * nota.getPorcentaje();
            porcentajeTotal += nota.getPorcentaje();
        }
        return notasTotal / porcentajeTotal;

    }

}

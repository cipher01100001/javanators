import java.util.ArrayList;

public class Materia {
    private String nombre;
    private int creditos;
    private int semestre;
    private double notaAcumulada;
    private ArrayList<Nota> notas;

    public Materia(String nombre, int creditos, int semestre) {
        this.nombre = nombre;
        this.creditos = creditos;
        this.semestre = semestre;
        this.notaAcumulada = 0;
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

    public double getNotaAcumulada() {
        return notaAcumulada;
    }

    public int getSemestre() {
        return semestre;
    }
    public ArrayList<Nota> getNotas() {
        return this.notas;
    }
}

package Model;

import java.util.ArrayList;

public class Materia {

    private int id;
    private String nombre;
    private int creditos;
    private int semestre;
    private double notaAcumulada;
    private ArrayList<Nota> notas;

    public Materia(int id, String nombre, int creditos, int semestre) {
        this.id = id;
        this.nombre = nombre;
        this.creditos = creditos;
        this.semestre = semestre;
        this.notaAcumulada = 0;
        this.notas = new ArrayList<>();
    }

    public void addNota(int id, double valor, int porcentaje) {
        notas.add(new Nota(id, valor, porcentaje));
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

package Model;

import java.util.ArrayList;

public class Estudiante {
    private int id;
    private String nombre;
    private String usuario;
    private String contrasena;
    private ArrayList<Materia> materias;

    public Estudiante(int id, String nombre, String usuario, String contrasena) {
        this.id = id;
        this.nombre = nombre;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.materias = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public ArrayList<Materia> getMaterias() {
        return materias;
    }

    public void addMateria(int id, String nombre, int creditos, int semestre) {
        materias.add(new Materia(id, nombre, creditos, semestre));
    }

}

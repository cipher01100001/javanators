import java.util.ArrayList;

public class Estudiante {
    private String nombre;
    private String usuario;
    private String contrasena;
    private ArrayList<Materia> materias;

    public Estudiante(String nombre, String usuario, String contrasena) {
        this.nombre = nombre;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.materias = new ArrayList<>();
    }

    public void addMateria(String nombre, int creditos) {
        materias.add(new Materia(nombre, creditos));
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
        return this.materias;
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

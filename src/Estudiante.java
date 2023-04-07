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

    public void addMateria(Materia materia) {
        materias.add(materia);
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

    public void getInfo() {
        System.out.println("Estudiante: " + this.nombre);
        System.out.println("Usuario: " + this.usuario);
        System.out.println("Contraseña: " + this.contrasena);
        System.out.println("Materias: ");
        for (Materia materia : this.materias) {
            System.out.println(" | " + materia.getNombre() + " tiene un valor de " + materia.getCreditos() + " creditos | ");
        }
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

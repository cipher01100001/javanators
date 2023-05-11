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

    public void addMateria(String nombre, int creditos, int semestre) {
        materias.add(new Materia(nombre, creditos, semestre));
    }

}

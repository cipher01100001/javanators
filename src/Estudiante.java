import java.util.ArrayList;

public class Estudiante {
    private String nombre;
    private String usuario;
    private String contrasena;
    private ArrayList<Semestre> semestres;

    public Estudiante(String nombre, String usuario, String contrasena) {
        this.nombre = nombre;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.semestres = new ArrayList<>();
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

    public ArrayList<Semestre> getSemestres() {
        return semestres;
    }

    public void addSemestre(int numero) {
        semestres.add(new Semestre(numero));
    }

}

package Controller;

import Model.Estudiante;
import Model.Materia;
import Model.Nota;

import java.util.ArrayList;
import java.util.Scanner;

public class Controller {
    public static void addEstudiante(ArrayList<Estudiante> estudiantes, int id, String nombre, String usuario, String contrasena) {
        estudiantes.add(new Estudiante(id, nombre, usuario, contrasena));
    }

    private static void displayGrades(Estudiante estudiante) {
        System.out.println("Notas de \"" + estudiante.getNombre() + "\"");

        ArrayList<Materia> materias = estudiante.getMaterias();
        if (materias.isEmpty()) {
            System.out.println("No hay materias registradas");
        }

        for (Materia materia : materias) {
            System.out.println("Las notas de \"" + materia.getNombre() + "\" son:");
            ArrayList<Nota> notas = materia.getNotas();
            if (notas.isEmpty()) {
                System.out.println("No hay notas registradas en esta materia");
                continue;
            }
            for (Nota nota : materia.getNotas()) {
                System.out.println(nota.getValor() + " | " + nota.getPorcentaje() + "%");
            }
        }
    }

    private static void displayAccountInfo(Estudiante usuario) {
        System.out.println("Nombre: " + usuario.getNombre());
        System.out.println("Usuario: " + usuario.getUsuario());
        System.out.println("Contraseña: " + usuario.getContrasena());
    }

    private static void createAccount(ArrayList<Estudiante> estudiantes, Scanner scanner) {
        scanner.nextLine();
        System.out.println("| REGISTRARSE |");
        System.out.println("Digite su nombre completo:");
        String nombre = scanner.nextLine();
        System.out.println("Digite su nombre de usuario:");
        String usuario = scanner.nextLine();

        String contrasena, confirmcontrasena;

        do {
            System.out.println("Digite su contraseña");
            contrasena = scanner.nextLine();
            System.out.println("Digite nuevamente su contraseña para confirmar:");
            confirmcontrasena = scanner.nextLine();

            if (!contrasena.equals(confirmcontrasena)) {
                System.out.println("Error, las contraseñas no coinciden");
            }
        } while (!contrasena.equals(confirmcontrasena));


        Estudiante estudiante = new Estudiante(3, nombre, usuario, contrasena);
        estudiantes.add(estudiante);
        System.out.println("Se ha registrado correctamente");
    }

    public static void inputSubject(Estudiante estudiante, String nombre, int creditos, int semestre) {
        estudiante.addMateria(1, nombre, creditos, semestre);
        System.out.println("Se agrego correctamente la materia \"" + nombre + "\"");
    }

    public static void inputGrade(Estudiante estudiante, String opcionSeleccionada, double nota, int porcentaje) {
        Materia materiaSeleccionada = null;
        for (Materia materia : estudiante.getMaterias() ) {
            if (materia.getNombre().equals(opcionSeleccionada)) {
                materiaSeleccionada = materia;
            }
        }

        materiaSeleccionada.addNota(1, nota, porcentaje);
        System.out.println("La nota fue añadida correctamente en la materia \"" + materiaSeleccionada.getNombre() + "\"");
    }

    private static void login(ArrayList<Estudiante> estudiantes, Scanner scanner) {
        scanner.nextLine();
        boolean logged = false;
        Estudiante loginUsuario = null;

        System.out.println("| INICIO DE SESIÓN |");
        System.out.println("Digite el nombre de usuario:");
        String usuario = scanner.nextLine();
        System.out.println("Digite la contraseña:");
        String contrasena = scanner.nextLine();

        for (Estudiante estudiante : estudiantes) {
            if (usuario.equals(estudiante.getUsuario()) && contrasena.equals(estudiante.getContrasena())) {
                loginUsuario = estudiante;
                logged = true;
            }
        }
    }
}

import Model.Estudiante;
import View.Login;
import Controller.Controller;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller();

        ArrayList<Estudiante> estudiantes = new ArrayList<>();
        controller.addEstudiante(estudiantes,1, "Carlos", "ca123", "123");

        estudiantes.get(0).addMateria(1, "Lógica y representación", 3, 1);
        estudiantes.get(0).getMaterias().get(0).addNota(1, 3.7, 20);
        estudiantes.get(0).getMaterias().get(0).addNota(2, 4.1, 30);
        estudiantes.get(0).getMaterias().get(0).addNota(3, 2.7, 50);

        estudiantes.get(0).addMateria(2, "Matemáticas Discretas", 2, 1);
        estudiantes.get(0).getMaterias().get(1).addNota(4, 2.7, 20);
        estudiantes.get(0).getMaterias().get(1).addNota(5, 3.1, 30);
        estudiantes.get(0).getMaterias().get(1).addNota(6, 4.7, 50);

        controller.addEstudiante(estudiantes, 2, "nadie", "nadi123", "321");

        estudiantes.get(1).addMateria(3, "Lógica y representación", 2, 1);
        estudiantes.get(1).getMaterias().get(0).addNota(7, 2.7, 20);
        estudiantes.get(1).getMaterias().get(0).addNota(8, 3.1, 30);
        estudiantes.get(1).getMaterias().get(0).addNota(9, 1.7, 50);

        estudiantes.get(1).addMateria(4, "Matemáticas Discretas", 3, 1);
        estudiantes.get(1).getMaterias().get(1).addNota(10, 1.7, 20);
        estudiantes.get(1).getMaterias().get(1).addNota(11, 2.1, 30);
        estudiantes.get(1).getMaterias().get(1).addNota(12, 3.7, 50);

        estudiantes.get(1).addMateria(5, "English", 4, 2);
        estudiantes.get(1).getMaterias().get(2).addNota(13, 4.7, 20);
        estudiantes.get(1).getMaterias().get(2).addNota(14, 1.1, 30);
        estudiantes.get(1).getMaterias().get(2).addNota(15, 3.2, 25);
        estudiantes.get(1).getMaterias().get(2).addNota(16, 3.8, 25);

        //controller.startMenu(estudiantes);
        new Login(estudiantes);
    }

}
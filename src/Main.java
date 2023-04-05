import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Estudiante estudiante1 = new Estudiante("Carlos", "ca123", "123");

        Materia materia1 = new Materia("Lógica y representación", 3);
        estudiante1.addMateria(materia1);
        materia1.addNota(new Nota(3.7, 20));
        materia1.addNota(new Nota(4.1, 30));
        materia1.addNota(new Nota(2.7, 50));

        Materia materia2 = new Materia("Matemáticas Discretas", 2);
        estudiante1.addMateria(materia2);
        materia2.addNota(new Nota(2.7, 20));
        materia2.addNota(new Nota(3.1, 30));
        materia2.addNota(new Nota(4.7, 50));

        estudiante1.getInfo();

        materia1.getInfo();
        System.out.println("El promedio en el curso \"" + materia1.getNombre() + "\" es de: " + materia1.getPromedio());

        materia2.getInfo();
        System.out.println("El promedio en el curso \"" + materia2.getNombre() + "\" es de: " + materia2.getPromedio());

        System.out.println("El promedio de " + estudiante1.getNombre() + " es de: " + estudiante1.getPromedio());
    }
}
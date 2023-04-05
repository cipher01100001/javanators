import java.util.Scanner;

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

        addData(estudiante1);
    }
    public static void addData(Estudiante estudiante1) {
        String nombre;
        int creditos;
        double nota;
        int porcentaje;
        String continuar;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el nombre de la materia:");
        nombre = scanner.nextLine();
        System.out.println("Ingrese el número de creditos para la materia \"" + nombre + "\":");
        creditos = scanner.nextInt();

        Materia materia = new Materia(nombre, creditos);
        estudiante1.addMateria(materia);

        do {
            System.out.println("Ingrese una nota de la materia \"" + nombre + "\":");
            nota = scanner.nextDouble();
            System.out.println("Ingrese el porcentaje de la nota");
            porcentaje = scanner.nextInt();

            materia.addNota(new Nota(nota, porcentaje));

            System.out.println("¿Quiere agregar otra nota? Si/No");
            scanner.nextLine();
            continuar = scanner.nextLine().toLowerCase();

        } while (continuar.equals("si"));

        estudiante1.getInfo();
        materia.getInfo();
        System.out.println("El promedio en el curso \"" + materia.getNombre() + "\" es de: " + materia.getPromedio());
        System.out.println("El promedio de " + estudiante1.getNombre() + " es de: " + estudiante1.getPromedio());
    }
}
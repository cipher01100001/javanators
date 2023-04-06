import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Estudiante> estudiantes = new ArrayList<>();
        Estudiante estudiante1 = new Estudiante("Carlos", "ca123", "123");
        estudiantes.add(estudiante1);

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


        Estudiante estudiante2 = new Estudiante("nadie", "nadi123", "321");
        estudiantes.add(estudiante2);

        Materia materia3 = new Materia("Lógica y representación", 2);
        estudiante2.addMateria(materia3);
        materia3.addNota(new Nota(2.7, 20));
        materia3.addNota(new Nota(3.1, 30));
        materia3.addNota(new Nota(1.7, 50));

        Materia materia4 = new Materia("Matemáticas Discretas", 3);
        estudiante2.addMateria(materia4);
        materia4.addNota(new Nota(1.7, 20));
        materia4.addNota(new Nota(2.1, 30));
        materia4.addNota(new Nota(3.7, 50));

        for (Estudiante estudiante : estudiantes) {
            System.out.println(estudiantes);
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite 0 para registrar un usuario nuevo o 1 para iniciar sesión:");
        int respuesta = scanner.nextInt();

        if (respuesta == 0) {
            System.out.println("Para registrarse primero, digite su nombre completo:");
            String nombre = scanner.nextLine();
            System.out.println("Digite su nombre de usuario:");
            String usuario = scanner.nextLine();
            System.out.println("Digite su contraseña");
            String contrasena = scanner.nextLine();
            System.out.println("Digite nuevamente su contraseña para confirmar:");
            String confirmcontrasena = scanner.nextLine();

            while (!contrasena.equals(confirmcontrasena)) {
                System.out.println("Error, las contraseñas no coinciden");

                System.out.println("Digite su contraseña");
                contrasena = scanner.nextLine();
                System.out.println("Digite nuevamente su contraseña para confirmar:");
                confirmcontrasena = scanner.nextLine();
            }

            Estudiante estudiante = new Estudiante(nombre, usuario, contrasena);
            estudiantes.add(estudiante);
            System.out.println("Se ha registrado correctamente");
        } else if (respuesta == 1) {

            Estudiante loginUsuario = null;

            scanner.nextLine();
            System.out.println("Digite el nombre de usuario:");
            String usuario = scanner.nextLine();
            System.out.println("Digite la contraseña:");
            String contrasena = scanner.nextLine();

            boolean login = false;
            for (Estudiante estudiante : estudiantes) {
                if (usuario.equals(estudiante.getUsuario()) && contrasena.equals(estudiante.getContrasena())) {
                    System.out.println("Inicio sesión correctamente");
                    login = true;
                    loginUsuario = estudiante;
                }
            }

            if (!login) {
                System.out.println("El usuario y/o contraseña no coinciden, inténtelo de nuevo");
            } else {
                System.out.println("Bienvenid@ " + loginUsuario.getUsuario());
                loginUsuario.getInfo();
                System.out.println("Tienes un promedio de " + loginUsuario.getPromedio());
                if (loginUsuario.getPromedio() < 3.0) {
                    System.out.println("Actualmente estas perdiendo el semestre");
                }
                String desicion;
                System.out.println("¿Desea añadir alguna materia?");
                desicion = scanner.nextLine().toLowerCase();
                if (desicion.equals("si")) {
                    String continuar;
                    do {
                        System.out.println("Ingrese el nombre de la materia:");
                        String  nombre = scanner.nextLine();
                        System.out.println("Ingrese el número de creditos para la materia \"" + nombre + "\":");
                        int creditos = scanner.nextInt();

                        Materia materia = new Materia(nombre, creditos);
                        loginUsuario.addMateria(materia);

                        System.out.println("¿Quiere agregar otra materia? Si/No");
                        scanner.nextLine();
                        continuar = scanner.nextLine().toLowerCase();
                    } while (continuar.equals("si"));
                }

                System.out.println("¿Desea añadir notas a alguna de sus materias?");
                desicion = scanner.nextLine().toLowerCase();

                if (desicion.equals("si")) {
                    System.out.println("Seleccione la materia a la que desea añadir la nota, digitando el número que tiene cada una asociado");
                    loginUsuario.getMaterias();
                    int selectMateria = scanner.nextInt();


                    String continuar;
                    do {
                        System.out.println("Ingrese la nota de la materia \"" + materia3 + "\"");
                        String  nombre = scanner.nextLine();
                        System.out.println("Ingrese el número de creditos para la materia \"" + nombre + "\":");
                        int creditos = scanner.nextInt();

                        Materia materia = new Materia(nombre, creditos);
                        loginUsuario.addMateria(materia);

                        System.out.println("¿Quiere agregar otra materia? Si/No");
                        continuar = scanner.nextLine().toLowerCase();
                    } while (continuar.equals("si"));

                }

            }

        }
        //addData(estudiante1);
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

        scanner.close();

        estudiante1.getInfo();
        materia.getInfo();
        System.out.println("El promedio en el curso \"" + materia.getNombre() + "\" es de: " + materia.getPromedio());
        System.out.println("El promedio de " + estudiante1.getNombre() + " es de: " + estudiante1.getPromedio());
    }
}
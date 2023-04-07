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

        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite 0 para registrar un usuario nuevo o 1 para iniciar sesión:");
        int respuesta = scanner.nextInt();

        if (respuesta == 0) {
            System.out.println("Para registrarse primero, digite su nombre completo:");
            scanner.nextLine();
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


            Estudiante estudiante = new Estudiante(nombre, usuario, contrasena);
            estudiantes.add(estudiante);
            System.out.println("Se ha registrado correctamente");

            System.out.println(estudiantes);

            login(estudiantes);

        } else if (respuesta == 1) {
            login(estudiantes);
        }
    }

    public static void login(ArrayList<Estudiante> estudiantes) {
        Scanner scanner = new Scanner(System.in);
        boolean login = false;
        Estudiante loginUsuario = null;
        do {
            System.out.println("Inicio de sesión");
            System.out.println("Digite el nombre de usuario:");
            String usuario = scanner.nextLine();
            System.out.println("Digite la contraseña:");
            String contrasena = scanner.nextLine();

            for (Estudiante estudiante : estudiantes) {
                if (usuario.equals(estudiante.getUsuario()) && contrasena.equals(estudiante.getContrasena())) {
                    System.out.println("Inicio sesión correctamente");
                    login = true;
                    loginUsuario = estudiante;
                }
            }
            if (!login) {
                System.out.println("El usuario y/o contraseña no coinciden, inténtelo de nuevo");
            }
        } while (!login);

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
                String nombre = scanner.nextLine();
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

            int selectMateria;
            do {
                System.out.println("Seleccione la materia a la que desea añadir la nota, digitando el número que tiene cada una asociado");

                int contador = 1;
                for (Materia materia : loginUsuario.getMaterias()) {
                    System.out.println(contador + " | " + materia.getNombre() + " tiene un valor de " + materia.getCreditos() + " creditos | ");
                    contador++;
                }

                selectMateria = scanner.nextInt();

                if (selectMateria > loginUsuario.getMaterias().size() || selectMateria < 1) {
                    System.out.println("Digita un número valido para seleccionar materia");
                }
            } while (selectMateria > loginUsuario.getMaterias().size());

            Materia editMateria = loginUsuario.getMaterias().get(selectMateria - 1);
            String continuar;
            do {
                System.out.println("Ingrese la nota de la materia \"" + editMateria.getNombre() + "\":");
                double valor = scanner.nextDouble();
                System.out.println("Ingrese el porcentaje para la nota:");
                int porcentaje = scanner.nextInt();

                Nota nota = new Nota(valor, porcentaje);
                editMateria.addNota(nota);

                System.out.println("¿Quiere agregar otra nota a la materia \"" + editMateria.getNombre() + "\"? Si/No");
                scanner.nextLine();
                continuar = scanner.nextLine().toLowerCase();
            } while (continuar.equals("si"));

            editMateria.getInfo();
            System.out.println("El promedio en esta materia es de: " + editMateria.getPromedio());
            loginUsuario.getInfo();
            System.out.println("El promedio general es de: " + loginUsuario.getPromedio());

        }
        scanner.close();
    }
}
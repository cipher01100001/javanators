import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Estudiante> estudiantes = new ArrayList<>();
        addEstudiante(estudiantes, "Carlos", "ca123", "123");

        estudiantes.get(0).addSemestre(1);
        estudiantes.get(0).getSemestres().get(0).addMateria("Lógica y representación", 3);
        estudiantes.get(0).getSemestres().get(0).getMaterias().get(0).addNota(3.7, 20);
        estudiantes.get(0).getSemestres().get(0).getMaterias().get(0).addNota(4.1, 30);
        estudiantes.get(0).getSemestres().get(0).getMaterias().get(0).addNota(2.7, 50);

        estudiantes.get(0).getSemestres().get(0).addMateria("Matemáticas Discretas", 2);
        estudiantes.get(0).getSemestres().get(0).getMaterias().get(1).addNota(2.7, 20);
        estudiantes.get(0).getSemestres().get(0).getMaterias().get(1).addNota(3.1, 30);
        estudiantes.get(0).getSemestres().get(0).getMaterias().get(1).addNota(4.7, 50);

        addEstudiante(estudiantes, "nadie", "nadi123", "321");
        estudiantes.get(1).addSemestre(1);


        estudiantes.get(1).getSemestres().get(0).addMateria("Lógica y representación", 2);
        estudiantes.get(1).getSemestres().get(0).getMaterias().get(0).addNota(2.7, 20);
        estudiantes.get(1).getSemestres().get(0).getMaterias().get(0).addNota(3.1, 30);
        estudiantes.get(1).getSemestres().get(0).getMaterias().get(0).addNota(1.7, 50);

        estudiantes.get(1).getSemestres().get(0).addMateria("Matemáticas Discretas", 3);
        estudiantes.get(1).getSemestres().get(0).getMaterias().get(1).addNota(1.7, 20);
        estudiantes.get(1).getSemestres().get(0).getMaterias().get(1).addNota(2.1, 30);
        estudiantes.get(1).getSemestres().get(0).getMaterias().get(1).addNota(3.7, 50);

        estudiantes.get(1).getSemestres().get(0).addMateria("English", 4);
        estudiantes.get(1).getSemestres().get(0).getMaterias().get(2).addNota(4.7, 20);
        estudiantes.get(1).getSemestres().get(0).getMaterias().get(2).addNota(1.1, 30);
        estudiantes.get(1).getSemestres().get(0).getMaterias().get(2).addNota(3.2, 25);
        estudiantes.get(1).getSemestres().get(0).getMaterias().get(2).addNota(3.8, 25);

        startMenu(estudiantes);
    }

    private static void addEstudiante(ArrayList<Estudiante> estudiantes, String nombre, String usuario, String contrasena) {
        estudiantes.add(new Estudiante(nombre, usuario, contrasena));
    }

    private static void startMenu(ArrayList<Estudiante> estudiantes) {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;
        do {
            System.out.println("\n| Menu de inicio |");
            System.out.println("1. Iniciar sesión");
            System.out.println("2. Registrarse");
            System.out.println("3. Terminar");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    login(estudiantes, scanner);
                    break;
                case 2:
                    createAccount(estudiantes, scanner);
                    break;
                case 3:
                    salir = true;
                    break;
                default:
                    System.out.println("Error, seleccione una opción válida");
            }
        } while (!salir);

        System.exit(0);
    }

    private static void displaySubjects(Estudiante estudiante) {
        System.out.println("Materias de \"" + estudiante.getNombre() + "\":");

        for (Semestre semestre : estudiante.getSemestres()) {
            System.out.println("\nSemestre #" + semestre.getNumero());

            ArrayList<Materia> materias = semestre.getMaterias();
            if (materias.isEmpty()) {
                System.out.println("No hay materias registradas en este semestre");
            } else {
                for (Materia materia : materias) {
                    System.out.println("| " + materia.getNombre() + " tiene un valor de " + materia.getCreditos() + " creditos | Nota promedio: " + materia.getPromedio());
                }
            }
        }
    }

    private static void displayGrades(Estudiante estudiante) {
        System.out.println("Notas de \"" + estudiante.getNombre() + "\"");

        for (Semestre semestre : estudiante.getSemestres()) {
            System.out.println("\nSemestre #" + semestre.getNumero());
            ArrayList<Materia> materias = semestre.getMaterias();
            if (materias.isEmpty()) {
                System.out.println("No hay materias registradas en este semestre");
                continue;
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
    }

    private static void displayAccountInfo(Estudiante usuario) {
        System.out.println("Nombre: " + usuario.getNombre());
        System.out.println("Usuario: " + usuario.getUsuario());
        System.out.println("Contraseña: " + usuario.getContrasena());
    }


    private static void inputSemester(Estudiante usuario, Scanner scanner) {
        System.out.println("\n| Agregar nuevo semestre |");
        boolean duplicateSemester;
        int numero;
        do {
            duplicateSemester = false;
            System.out.println("Digite el número del semestre");
            numero = scanner.nextInt();

            for (Semestre semestre : usuario.getSemestres()) {
                if (numero == semestre.getNumero()) {
                    duplicateSemester = true;
                    break;
                }
            }
            if (!duplicateSemester) {
                usuario.addSemestre(numero);
                System.out.println("El semestre fue añadido correctamente");
            } else {
                System.out.println("El número de semestre ya existe");
            }
        } while (duplicateSemester);
    }

    private static void displaySemester(Estudiante usuario) {
        System.out.println("| Lista de semestres |");
        for (Semestre semestre : usuario.getSemestres()) {
            System.out.println("Semestre #" + semestre.getNumero());
        }
    }

    private static void principalMenu(Estudiante usuario, Scanner scanner) {
        boolean salir = false;

        do {
            System.out.println("\n| Menu Principal |");
            System.out.println("1- Ver Semestres");
            System.out.println("2- Agregar Semestre");
            System.out.println("3- Ver materias");
            System.out.println("4- Agregar materia");
            System.out.println("5- Ver notas");
            System.out.println("6- Agregar nota");
            System.out.println("7- Ver información de la cuenta");
            System.out.println("8- Cerrar sesión");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    displaySemester(usuario);
                    break;
                case 2:
                    inputSemester(usuario, scanner);
                    break;
                case 3:
                    displaySubjects(usuario);
                    break;
                case 4:
                    inputSubject(usuario, scanner);
                    break;
                case 5:
                    displayGrades(usuario);
                    break;
                case 6:
                    inputGrade(usuario, scanner);
                    break;
                case 7:
                    displayAccountInfo(usuario);
                    break;
                case 8:
                    salir = true;
                    break;
                default:
                    System.out.println("Error, seleccione una opción válida");
            }
        } while (!salir);

        System.out.println("Cerro sesión " + usuario.getNombre());
    }

    private static void loginMenu(ArrayList<Estudiante> estudiantes, Scanner scanner) {
        boolean invalidOption;
        do {
            invalidOption = false;

            System.out.println("\n|Menu inicio de sesión|");
            System.out.println("1- Reintentar");
            System.out.println("2- Salir al menu de inicio");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    login(estudiantes, scanner);
                    break;
                case 2:
                    startMenu(estudiantes);
                    break;
                default:
                    System.out.println("Error, seleccione una opción válida");
                    invalidOption = true;
                    break;
            }
        } while (invalidOption);
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


        Estudiante estudiante = new Estudiante(nombre, usuario, contrasena);
        estudiantes.add(estudiante);
        System.out.println("Se ha registrado correctamente");
    }

    private static void inputSubject(Estudiante estudiante, Scanner scanner) {
        scanner.nextLine();

        boolean invalidOptionSemester;
        int optionSemester;

        System.out.println("| Agregar nueva materia |");

        ArrayList<Semestre> semestres = estudiante.getSemestres();
        do {
            System.out.println("Selecciona el semestre en el que agregaras la materia");
            for (int i = 0; i < semestres.size(); i++) {
                System.out.println(i + 1 + "- Semestre #" + semestres.get(i).getNumero());
            }
            optionSemester = scanner.nextInt();
            if (optionSemester > semestres.size() || optionSemester <= 0) {
                System.out.println("\nError, seleccione una opción válida");
                invalidOptionSemester = true;
            } else {
                invalidOptionSemester = false;
            }
        } while (invalidOptionSemester);

        System.out.println("Digite el nombre de la materia");
        String nombre = scanner.nextLine();
        System.out.println("Digite el numero de creditos que vale \"" + nombre + "\"");
        int creditos = scanner.nextInt();

        semestres.get(optionSemester - 1).addMateria(nombre, creditos);

        System.out.println("Se agrego correctamente la materia \"" + nombre + "\"");
    }

    private static void inputGrade(Estudiante estudiante, Scanner scanner) {
        boolean invalidOptionSubject, invalidOptionSemester;
        int optionSubject, optionSemester;

        System.out.println("| Agregar notas |");

        ArrayList<Semestre> semestres = estudiante.getSemestres();
        do {
            System.out.println("Selecciona el semestre en el que agregaras la nota");
            for (int i = 0; i < semestres.size(); i++) {
                System.out.println(i + 1 + "- Semestre #" + semestres.get(i).getNumero());
            }
            optionSemester = scanner.nextInt();
            if (optionSemester > semestres.size() || optionSemester <= 0) {
                System.out.println("\nError, seleccione una opción válida");
                invalidOptionSemester = true;
            } else {
                invalidOptionSemester = false;
            }
        } while (invalidOptionSemester);


        ArrayList<Materia> materias = semestres.get(optionSemester - 1).getMaterias();
        do {
            System.out.println("Selecciona la materia en la que agregaras la nota");
            for (int i = 0; i < materias.size(); i++) {
                System.out.println(i + 1 + "- " + materias.get(i).getNombre());
            }
            optionSubject = scanner.nextInt();
            if (optionSubject > materias.size() || optionSubject <= 0) {
                System.out.println("\nError, seleccione una opción válida");
                invalidOptionSubject = true;
            } else {
                invalidOptionSubject = false;
            }
        } while (invalidOptionSubject);

        Materia materia = materias.get(optionSubject - 1);

        System.out.println("Digite la nota:");
        double nota = scanner.nextDouble();

        System.out.println("Digite el porcentaje de la nota:");
        int porcentaje = scanner.nextInt();

        materia.addNota(nota, porcentaje);
        System.out.println("La nota fue añadida correctamente en la materia \"" + materia.getNombre() + "\"");
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
        if (!logged) {
            System.out.println("El usuario y/o contraseña no coinciden");
            loginMenu(estudiantes, scanner);
        } else {
            System.out.println("Inicio sesión correctamente");
            System.out.println("Bienvenid@ " + loginUsuario.getUsuario());
            principalMenu(loginUsuario, scanner);
        }
    }
}
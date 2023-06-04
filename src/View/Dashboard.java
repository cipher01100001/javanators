package View;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

import Controller.Controller;
import Model.Estudiante;
import Model.Materia;
import Model.Nota;

public class Dashboard extends JFrame {
    private JPanel panelPrincipal;
    private JPanel panelInicio;
    private JPanel panelMateria;
    private JPanel panelNotas;
    private JTable tablaMateria;
    private JTable tablaNotas;
    private JButton cerrarSesionBtn;
    private JTextField campoTexto1;
    private JTextField campoTexto2;
    private JTextField campoTexto3;
    private JButton enviarBtn;
    private JButton agregarNotaBtn;
    private JComboBox<String> listaOpcionesMaterias;

    private String tituloActual;

    public Dashboard(ArrayList<Estudiante> estudiantes) {
        Controller controller = new Controller();

        setTitle("VANA");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel navbarPanel = new JPanel();
        navbarPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        JButton inicioBtn = new JButton("Inicio");
        JButton materiaBtn = new JButton("Materias");
        JButton notasBtn = new JButton("Notas");
        cerrarSesionBtn = new JButton("Cerrar Sesión");

        navbarPanel.add(inicioBtn);
        navbarPanel.add(materiaBtn);
        navbarPanel.add(notasBtn);
        navbarPanel.add(Box.createHorizontalGlue());
        navbarPanel.add(cerrarSesionBtn);

        panelInicio = new JPanel();
        panelInicio.setLayout(new BorderLayout());
        JLabel labelInicio = new JLabel("¡Bienvenido a la sección de Inicio!");
        labelInicio.setHorizontalAlignment(SwingConstants.CENTER);
        panelInicio.add(labelInicio, BorderLayout.CENTER);

        panelMateria = new JPanel();
        panelMateria.setLayout(new BorderLayout());

        JPanel formularioPanel = new JPanel(new GridLayout(4, 2));
        JLabel label1 = new JLabel("Materia:");
        JLabel label2 = new JLabel("Créditos:");
        JLabel label3 = new JLabel("Semestre:");
        campoTexto1 = new JTextField();
        campoTexto2 = new JTextField();
        campoTexto3 = new JTextField();
        enviarBtn = new JButton("Enviar");

        formularioPanel.add(label1);
        formularioPanel.add(campoTexto1);
        formularioPanel.add(label2);
        formularioPanel.add(campoTexto2);
        formularioPanel.add(label3);
        formularioPanel.add(campoTexto3);
        formularioPanel.add(new JLabel());
        formularioPanel.add(enviarBtn);

        panelMateria.add(formularioPanel, BorderLayout.NORTH);

        String[] columnasMateria = {"Materia", "Nro. Créditos", "Semestre"};
        String[][] datosMateria = {{"Dato 1", "Dato 2", "Dato 3"}};

        DefaultTableModel modelMateria = new DefaultTableModel(datosMateria, columnasMateria);
        tablaMateria = new JTable(modelMateria);
        tablaMateria.setEnabled(false);
        JScrollPane scrollPaneMateria = new JScrollPane(tablaMateria);
        panelMateria.add(scrollPaneMateria, BorderLayout.CENTER);

        panelNotas = new JPanel();
        panelNotas.setLayout(new BorderLayout());

        JPanel formularioNotasPanel = new JPanel(new GridLayout(4, 2));
        JLabel labelMateria = new JLabel("Materia:");
        String[] opciones = {"Opción 1", "Opción 2", "Opción 3"};
        listaOpcionesMaterias = new JComboBox<>(opciones);
        JLabel labelNota = new JLabel("Nota:");
        JLabel labelPorcentaje = new JLabel("Porcentaje:");
        JTextField campoNota = new JTextField();
        JTextField campoPorcentaje = new JTextField();
        agregarNotaBtn = new JButton("Agregar Nota");

        formularioNotasPanel.add(labelMateria);
        formularioNotasPanel.add(listaOpcionesMaterias);
        formularioNotasPanel.add(labelNota);
        formularioNotasPanel.add(campoNota);
        formularioNotasPanel.add(labelPorcentaje);
        formularioNotasPanel.add(campoPorcentaje);
        formularioNotasPanel.add(new JLabel());
        formularioNotasPanel.add(agregarNotaBtn);

        panelNotas.add(formularioNotasPanel, BorderLayout.NORTH);

        String[] columnasNotas = {"Materia", "Nota", "Porcentaje"};
        String[][] datosNotas = {{"Dato 1", "Dato 2", "Dato 3"}};

        DefaultTableModel modelNotas = new DefaultTableModel(datosNotas, columnasNotas);
        tablaNotas = new JTable(modelNotas);
        tablaNotas.setEnabled(false);
        JScrollPane scrollPaneNotas = new JScrollPane(tablaNotas);
        panelNotas.add(scrollPaneNotas, BorderLayout.CENTER);

        panelPrincipal = new JPanel(new BorderLayout());
        panelPrincipal.add(navbarPanel, BorderLayout.NORTH);
        panelPrincipal.add(panelInicio, BorderLayout.CENTER);

        add(panelPrincipal);

        inicioBtn.addActionListener(e -> {
            panelPrincipal.remove(panelMateria);
            panelPrincipal.remove(panelNotas);
            panelPrincipal.add(panelInicio, BorderLayout.CENTER);
            panelPrincipal.revalidate();
            panelPrincipal.repaint();
            tituloActual = "Inicio";
            setTitle("VANA - " + tituloActual);
            ajustarVentana();
        });

        materiaBtn.addActionListener(e -> {
            panelPrincipal.remove(panelInicio);
            panelPrincipal.remove(panelNotas);
            panelPrincipal.add(panelMateria, BorderLayout.CENTER);
            panelPrincipal.revalidate();
            panelPrincipal.repaint();
            tituloActual = "Materias";
            setTitle("VANA - " + tituloActual);
            ajustarVentana();
        });

        notasBtn.addActionListener(e -> {
            panelPrincipal.remove(panelInicio);
            panelPrincipal.remove(panelMateria);
            panelPrincipal.add(panelNotas, BorderLayout.CENTER);
            panelPrincipal.revalidate();
            panelPrincipal.repaint();
            tituloActual = "Notas";
            setTitle("VANA - " + tituloActual);
            ajustarVentana();
        });

        cerrarSesionBtn.addActionListener(e -> {
            Login login = new Login(estudiantes);
            login.setVisible(true);
            this.setVisible(false);
        });

        enviarBtn.addActionListener(e -> {
            String materia = campoTexto1.getText();
            int creditos = Integer.parseInt(campoTexto2.getText());
            int semestre = Integer.parseInt(campoTexto3.getText());

            Estudiante estudiante = estudiantes.get(1);

            controller.inputSubject(estudiante, materia, creditos, semestre);

            campoTexto1.setText("");
            campoTexto2.setText("");
            campoTexto3.setText("");

            actualizarTablaMaterias(estudiante);
            actualizarSelectMaterias(estudiantes.get(1));
        });

        agregarNotaBtn.addActionListener(e -> {
            String opcionSeleccionada = (String) listaOpcionesMaterias.getSelectedItem();
            double nota = Double.parseDouble(campoNota.getText());
            int porcentaje = Integer.parseInt(campoPorcentaje.getText());

            Estudiante estudiante = estudiantes.get(1);

            controller.inputGrade(estudiante, opcionSeleccionada, nota, porcentaje);

            actualizarTablaNotas(estudiante);

            listaOpcionesMaterias.setSelectedIndex(0);
            campoNota.setText("");
            campoPorcentaje.setText("");
        });

        tituloActual = "Inicio";
        setTitle("VANA - " + tituloActual);
        ajustarVentana();
        actualizarTablaMaterias(estudiantes.get(1));
        actualizarTablaNotas(estudiantes.get(1));
        actualizarSelectMaterias(estudiantes.get(1));
        setVisible(true);
    }

    private void ajustarVentana() {
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    private void actualizarTablaMaterias(Estudiante estudiante) {
        DefaultTableModel model = (DefaultTableModel) tablaMateria.getModel();
        model.setRowCount(0);

        for (Materia materia : estudiante.getMaterias()) {
            model.addRow(new Object[]{materia.getNombre(), materia.getCreditos(), materia.getSemestre()});
        }
    }

    private void actualizarTablaNotas(Estudiante estudiante) {
        DefaultTableModel model = (DefaultTableModel) tablaNotas.getModel();
        model.setRowCount(0);

        for (Materia materia : estudiante.getMaterias()) {
            for (Nota nota : materia.getNotas()) {
                model.addRow(new Object[]{materia.getNombre(), nota.getValor(), nota.getPorcentaje()});
            }
        }
    }

    private void actualizarSelectMaterias(Estudiante estudiante) {
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();

        for (Materia materia : estudiante.getMaterias()) {
            model.addElement(materia.getNombre());
        }

        listaOpcionesMaterias.setModel(model);
    }
}

package View;

import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;

public class Dashboard extends JFrame {
    private JPanel panelPrincipal;
    private JPanel panelInicio;
    private JPanel panelSemestre;
    private JPanel panelNotas;
    private JTable tabla;
    private JButton cerrarSesionBtn;
    private JTextField campoTexto1;
    private JTextField campoTexto2;
    private JTextField campoTexto3;
    private JButton enviarBtn;

    private String tituloActual;

    public Dashboard() {
        setTitle("Mi Interfaz");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JPanel navbarPanel = new JPanel();
        navbarPanel.setLayout(new FlowLayout(FlowLayout.LEFT));


        JButton inicioBtn = new JButton("Inicio");
        JButton semestreBtn = new JButton("Semestre");
        JButton notasBtn = new JButton("Notas");
        cerrarSesionBtn = new JButton("Cerrar Sesión");

        navbarPanel.add(inicioBtn);
        navbarPanel.add(semestreBtn);
        navbarPanel.add(notasBtn);
        navbarPanel.add(Box.createHorizontalGlue());
        navbarPanel.add(cerrarSesionBtn);


        panelInicio = new JPanel();
        panelInicio.setLayout(new BorderLayout());
        JLabel labelInicio = new JLabel("¡Bienvenido a la sección de Inicio!");
        labelInicio.setHorizontalAlignment(SwingConstants.CENTER);
        panelInicio.add(labelInicio, BorderLayout.CENTER);


        panelSemestre = new JPanel();
        panelSemestre.setLayout(new BorderLayout());


        JPanel formularioPanel = new JPanel(new GridLayout(4, 2));
        JLabel label1 = new JLabel("Campo 1:");
        JLabel label2 = new JLabel("Campo 2:");
        JLabel label3 = new JLabel("Campo 3:");
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

        panelSemestre.add(formularioPanel, BorderLayout.NORTH);


        String[] columnas = {"Columna 1", "Columna 2", "Columna 3"};
        String[][] datos = {{"Dato 1", "Dato 2", "Dato 3"}};

        DefaultTableModel model = new DefaultTableModel(datos, columnas);
        tabla = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(tabla);
        panelSemestre.add(scrollPane, BorderLayout.CENTER);


        panelNotas = new JPanel();
        panelNotas.setLayout(new BorderLayout());
        JLabel labelNotas = new JLabel("Aquí van las notas");
        labelNotas.setHorizontalAlignment(SwingConstants.CENTER);
        panelNotas.add(labelNotas, BorderLayout.CENTER);


        panelPrincipal = new JPanel(new BorderLayout());
        panelPrincipal.add(navbarPanel, BorderLayout.NORTH);
        panelPrincipal.add(panelInicio, BorderLayout.CENTER);

        add(panelPrincipal);

        inicioBtn.addActionListener(e -> {
            panelPrincipal.remove(panelSemestre);
            panelPrincipal.remove(panelNotas);
            panelPrincipal.add(panelInicio, BorderLayout.CENTER);
            panelPrincipal.revalidate();
            panelPrincipal.repaint();
            tituloActual = "Inicio";
            setTitle("Mi Interfaz - " + tituloActual);
            ajustarVentana();
        });

        semestreBtn.addActionListener(e -> {
            panelPrincipal.remove(panelInicio);
            panelPrincipal.remove(panelNotas);
            panelPrincipal.add(panelSemestre, BorderLayout.CENTER);
            panelPrincipal.revalidate();
            panelPrincipal.repaint();
            tituloActual = "Semestre";
            setTitle("Mi Interfaz - " + tituloActual);
            ajustarVentana();
        });

        notasBtn.addActionListener(e -> {
            panelPrincipal.remove(panelInicio);
            panelPrincipal.remove(panelSemestre);
            panelPrincipal.add(panelNotas, BorderLayout.CENTER);
            panelPrincipal.revalidate();
            panelPrincipal.repaint();
            tituloActual = "Notas";
            setTitle("Mi Interfaz - " + tituloActual);
            ajustarVentana();
        });

        cerrarSesionBtn.addActionListener(e -> {
            Login login = new Login();
            login.setVisible(true);
            this.setVisible(false);
        });

        tituloActual = "Inicio";
        setTitle("Mi Interfaz - " + tituloActual);
        ajustarVentana();
        setVisible(true);
    }

    private void ajustarVentana() {
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Dashboard();
        });
    }
}

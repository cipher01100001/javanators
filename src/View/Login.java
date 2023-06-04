package View;

import javax.swing.*;
import java.awt.*;

public class Login extends JFrame {
    private JButton iniciarSesionBtn;
    private JTextField texto1;
    private JTextField texto2;

    public Login() {

        setTitle("Iniciar sesión");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new FlowLayout());

        JPanel formularioIs = new JPanel(new GridLayout(6,1));
        JLabel usuario = new JLabel("Usuario:");
        texto1 = new JTextField();
        JLabel paswword = new JLabel("Constraseña:");
        texto2 = new JTextField();
        JLabel espacio = new JLabel("");
        iniciarSesionBtn = new JButton("Iniciar Sesión");

        formularioIs.add(usuario);
        formularioIs.add(texto1);
        formularioIs.add(paswword);
        formularioIs.add(texto2);
        formularioIs.add(espacio);
        formularioIs.add(iniciarSesionBtn);

        panel.add(formularioIs,BorderLayout.CENTER);

        add(panel);

        iniciarSesionBtn.addActionListener(e -> {
            Dashboard dashboard = new Dashboard();
            dashboard.setVisible(true);
            this.setVisible(false);
        });

        ajustarVentana();
        setVisible(true);
    }

    private void ajustarVentana() {
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
}
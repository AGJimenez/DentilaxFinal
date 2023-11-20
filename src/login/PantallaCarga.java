package login;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.Color;

public class PantallaCarga extends JDialog {
    private JProgressBar progressBar;
    private Timer timer;
    
    public PantallaCarga(JFrame parent) {
        super(parent, "Cargando...", true);
        setUndecorated(true);
        getContentPane().setBackground(new Color(255, 255, 255));
        setIconImage(Toolkit.getDefaultToolkit().getImage(PantallaCarga.class.getResource("/iconos_menus/dentilaxIcono.png")));
        getContentPane().setLayout(null);
        progressBar = new JProgressBar(0, 100);
        progressBar.setBounds(0, 61, 465, 41);
        progressBar.setFont(new Font("Barlow", Font.PLAIN, 20));
        progressBar.setStringPainted(true);
        
        getContentPane().add(progressBar);
        
        JLabel lblNewLabel = new JLabel("Dentilax está cargando");
        lblNewLabel.setBounds(10, 29, 150, 21);
        getContentPane().add(lblNewLabel);
        setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        setSize(465, 102);
        setLocationRelativeTo(parent);
        
        // Simula el proceso de carga
        cargar();
    }
    
    private void cargar() {
        timer = new Timer(50, new ActionListener() {
            int progress = 0;
            
            @Override
            public void actionPerformed(ActionEvent e) {
                if (progress >= 100) {
                    timer.stop();
                    setVisible(false);
                    dispose();
                } else {
                    // Actualiza la barra de progreso
                    progressBar.setValue(progress);
                    progress++;
                }
            }
        });
        timer.start();
    }
}

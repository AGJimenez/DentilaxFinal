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
        progressBar.setForeground(Color.WHITE);
        progressBar.setBackground(new Color(23, 74, 137));
        progressBar.setOpaque(true);
        progressBar.setBorderPainted(false);
        progressBar.setStringPainted(true);
        progressBar.setBounds(163, 384, 466, 16);
        progressBar.setFont(new Font("Barlow", Font.PLAIN, 12));
        
        getContentPane().add(progressBar);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(PantallaCarga.class.getResource("/iconos_submenus/gifCarga.gif")));
        lblNewLabel.setBounds(0, 0, 800, 450);
        getContentPane().add(lblNewLabel);
        setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        setSize(799, 445);
        setLocationRelativeTo(parent);
        
        // Simula el proceso de carga
        cargar();
    }
    
    private void cargar() {
        timer = new Timer(30, new ActionListener() {
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


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author alexg
 */
class Fondo extends JPanel{
    private Image imagenFondo;
    private Image imagenPass;
    private Image imagenUser;
    
    @Override
    public void paint(Graphics g){
        imagenUser = new ImageIcon(getClass().getResource("user.png")).getImage();
        imagenPass = new ImageIcon(getClass().getResource("pass.png")).getImage();
        imagenFondo = new ImageIcon(getClass().getResource("trasparencia.png")).getImage();
        g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
       // g.drawImage(imagenPass, 0, 0, getWidth(), getHeight(), this);
       // g.drawImage(imagenUser, 0, 0, getWidth(), getHeight(), this);
        setOpaque(false);
        super.paint(g);
    }
    
  
}
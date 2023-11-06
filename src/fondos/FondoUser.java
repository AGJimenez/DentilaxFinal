package fondos;

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
class FondoUser extends JPanel{
 
    private Image imagenUser;
    
    @Override
    public void paint(Graphics g){
        imagenUser = new ImageIcon(getClass().getResource("user.png")).getImage();

        g.drawImage(imagenUser, 0, 0, getWidth(), getHeight(), this);
       // g.drawImage(imagenPass, 0, 0, getWidth(), getHeight(), this);
       // g.drawImage(imagenUser, 0, 0, getWidth(), getHeight(), this);
        setOpaque(false);
        super.paint(g);
    }
    
  
}
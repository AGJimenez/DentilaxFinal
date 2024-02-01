
package menu_ppal;





import javax.swing.GroupLayout.Alignment;
import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.swing.GroupLayout;
import javax.swing.JMenu;
import javax.swing.JSeparator;
import javax.swing.Timer;

import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.Cursor;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

import login.jf_login;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.io.File;
import java.net.URL;
import java.awt.event.InputEvent;

/**
 *
 * @author alexg
 */
public class jf_menu_doctor extends javax.swing.JFrame {

    /**
     * Creates new form jf_menu_ppal
     */
	
    fondos.Fondo fondo = new fondos.Fondo();
    public jf_menu_doctor() {
    	setPreferredSize(new Dimension(1450, 750));
        this.setContentPane(fondo);      
        initComponents();
        this.setLocationRelativeTo(jp_menu);
        jp_menu.setLayout(null);
        jp_menu.add(btn_solicitar);
        jp_menu.add(btn_ajustes);
        
        JButton btn_buscar_paciente_dr = new JButton();
        btn_buscar_paciente_dr.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {  		
        		dialogos_pacientes.jd_buscar_paciente_menudr ventana = new dialogos_pacientes.jd_buscar_paciente_menudr();
				ventana.setVisible(true);      		
        	}
        });
        btn_buscar_paciente_dr.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btn_buscar_paciente_dr.setBorderPainted(false);
        btn_buscar_paciente_dr.setIcon(new ImageIcon(jf_menu_doctor.class.getResource("/iconos_menus/btn_buscarPaciente_dr.png")));
        btn_buscar_paciente_dr.setOpaque(false);
        btn_buscar_paciente_dr.setContentAreaFilled(false);
        btn_buscar_paciente_dr.setBounds(433, 218, 282, 98);
        jp_menu.add(btn_buscar_paciente_dr);
        
        fecha = new JLabel("");
        fecha.setBackground(Color.WHITE);
        fecha.setFont(new Font("Barlow", Font.PLAIN, 25));
        fecha.setBounds(1184, 642, 240, 23);
        jp_menu.add(fecha);
        
        btnNewButton = new JButton("SALIR");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        		jf_login ventana = new jf_login();
        		ventana.setVisible(true);       
        	}
        });
        btnNewButton.setIcon(new ImageIcon(jf_menu_doctor.class.getResource("/iconos_menus/image.png")));
        btnNewButton.setForeground(new Color(0, 161, 219));
        btnNewButton.setFont(new Font("Barlow", Font.BOLD, 20));
        btnNewButton.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
        btnNewButton.setBackground(new Color(255, 255, 255));
        btnNewButton.setBounds(33, 600, 148, 66);
        jp_menu.add(btnNewButton);
        
        panel = new JPanel();
        panel.setBackground(new Color(191, 231, 249));
        panel.setBounds(1079, 11, 345, 64);
        jp_menu.add(panel);
        panel.setLayout(null);
        
        lbl_dni_doctor = new JLabel("<dynamic>");
        lbl_dni_doctor.setBounds(188, 11, 137, 42);
        panel.add(lbl_dni_doctor);
        lbl_dni_doctor.setFont(new Font("Barlow", Font.BOLD, 20));
        
        JLabel lbl_bienvenido = new JLabel("BIENVENIDO");
        lbl_bienvenido.setFont(new Font("Barlow", Font.BOLD, 20));
        lbl_bienvenido.setBounds(28, 11, 125, 42);
        panel.add(lbl_bienvenido);
        
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	 Date fechaActual = new Date();
                 SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                 String fechaHoraFormateada = formato.format(fechaActual);
                 fecha.setText(fechaHoraFormateada);
            }
        });
        timer.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    /**
     * 
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jp_menu = new fondos.Fondo();
        jp_menu.setPreferredSize(new Dimension(1450, 750));
        btn_solicitar = new javax.swing.JButton();
        btn_solicitar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dialogos_materiales.jd_pedido_menudr ventana = new dialogos_materiales.jd_pedido_menudr();
        		ventana.setTxt_invisible(getLbl_dni_doctor().getText().toString());
        		ventana.setVisible(true);
        	}
        });
        btn_solicitar.setOpaque(false);
        btn_solicitar.setBorderPainted(false);
        btn_solicitar.setContentAreaFilled(false);
        btn_solicitar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btn_solicitar.setBounds(736, 218, 282, 98);
        btn_solicitar.setIcon(new ImageIcon(jf_menu_doctor.class.getResource("/iconos_menus/btn_pedidos_doctor.png")));
        btn_ajustes = new javax.swing.JButton();
        btn_ajustes.setOpaque(false);
        btn_ajustes.setBorderPainted(false);
        btn_ajustes.setContentAreaFilled(false);
        btn_ajustes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btn_ajustes.setIcon(new ImageIcon(jf_menu_doctor.class.getResource("/iconos_menus/btn_ajustes_admin.png")));
        btn_ajustes.setBounds(433, 333, 282, 93);
        menu_inicio = new javax.swing.JMenuBar();
        
        mn_paciente = new javax.swing.JMenu();
        mn_paciente.setFont(new Font("Arial", Font.PLAIN, 12));
        mn_pedidos = new javax.swing.JMenu();
        mn_pedidos.setFont(new Font("Arial", Font.PLAIN, 12));
        mn_ajustes = new javax.swing.JMenu();
        mn_ajustes.setFont(new Font("Arial", Font.PLAIN, 12));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        menu_inicio.setBackground(new java.awt.Color(32, 160, 216));
        menu_inicio.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        menu_inicio.setBorderPainted(false);

        mn_paciente.setBackground(new java.awt.Color(32, 160, 216));
        mn_paciente.setText("PACIENTE");
        menu_inicio.add(mn_paciente);
        
        jmenuitem_menu_paciente = new JMenuItem("Menu paciente");
        jmenuitem_menu_paciente.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dialogos_pacientes.jd_buscar_paciente_menudr ventana = new dialogos_pacientes.jd_buscar_paciente_menudr();
				ventana.setVisible(true);
        	}
        });
        jmenuitem_menu_paciente.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.ALT_DOWN_MASK));
        jmenuitem_menu_paciente.setFont(new Font("Arial", Font.PLAIN, 12));
        mn_paciente.add(jmenuitem_menu_paciente);

        mn_pedidos.setText("PEDIDOS");
        menu_inicio.add(mn_pedidos);
        
        jmenuitem_solicitar_material = new JMenuItem("Solicitar material");
        jmenuitem_solicitar_material.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dialogos_materiales.jd_pedido_menudr ventana = new dialogos_materiales.jd_pedido_menudr();
        		ventana.setTxt_invisible(getLbl_dni_doctor().getText().toString());
        		ventana.setVisible(true);
        	}
        });
        jmenuitem_solicitar_material.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, InputEvent.ALT_DOWN_MASK));
        jmenuitem_solicitar_material.setFont(new Font("Arial", Font.PLAIN, 12));
        mn_pedidos.add(jmenuitem_solicitar_material);

        mn_ajustes.setText("AJUSTES");
        menu_inicio.add(mn_ajustes);

        setJMenuBar(menu_inicio);
        
        btn_ayuda = new JButton("AYUDA");
        btn_ayuda.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	    try {
        	        // Ruta al archivo de ayuda
        	        File fichero = new File("src/help/help_set.hs");
        	        URL hsUrl = fichero.toURI().toURL();

        	        // Crear el conjunto de ayuda
        	        HelpSet helpset = new HelpSet(getClass().getClassLoader(), hsUrl);

        	        // Crear el broker de ayuda
        	        HelpBroker hb = helpset.createHelpBroker();

        	        // Habilitar la ayuda en el botón con el tema "Indice"
        	        hb.enableHelpOnButton(btn_ayuda, "Indice", helpset);

        	    } catch (Exception e1) {
        	        e1.printStackTrace();
        	    }
        	}
        });
        btn_ayuda.setOpaque(false);
        btn_ayuda.setFont(new Font("Arial", Font.PLAIN, 12));
        btn_ayuda.setFocusable(true);
        btn_ayuda.setFocusPainted(false);
        btn_ayuda.setContentAreaFilled(false);
        btn_ayuda.setBorderPainted(false);
        menu_inicio.add(btn_ayuda);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jp_menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jp_menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
       
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jf_menu_doctor().setVisible(true);
            }
        });
    }


	public JLabel getLbl_dni_doctor() {
		return lbl_dni_doctor;
	}

	public void setLbl_dni_doctor(String lbl_dni_doctor) {
		this.lbl_dni_doctor.setText(lbl_dni_doctor);;
	}


	// Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_ajustes;
    private javax.swing.JButton btn_solicitar;
    private javax.swing.JMenu mn_paciente;
    private javax.swing.JMenu mn_pedidos;
    private javax.swing.JMenu mn_ajustes;
    private javax.swing.JPanel jp_menu;
    private javax.swing.JMenuBar menu_inicio;
    private JLabel fecha;
    private JButton btnNewButton;
    private JPanel panel;
    private JLabel lbl_dni_doctor;
    private JMenuItem jmenuitem_menu_paciente;
    private JMenuItem jmenuitem_solicitar_material;
    private JButton btn_ayuda;
}


import java.awt.Color;
import java.awt.event.ActionListener;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import java.awt.Cursor;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Dimension;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.Font;
import javax.swing.border.LineBorder;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.Window.Type;
import javax.swing.JPasswordField;



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author alexg
 */
public class jf_login extends javax.swing.JFrame {

	//en las siguientes lineas de código usamos los get para que nos devuelva el "resultado" y el set para establecer el contenido de los textfield en otros campos	
    public javax.swing.JTextField getJtf_user() {
		return jtf_user;
	}

	public void setJtf_user(javax.swing.JTextField jtf_user) {
		this.jtf_user = jtf_user;
	}

	public javax.swing.JTextField getJtf_user1() {
		return jtf_user1;
	}

	public void setJtf_user1(javax.swing.JPasswordField jtf_user1) {
		this.jtf_user1 = jtf_user1;
	}

	/**
     * Creates new form jf_login
     */
    Fondo fondo = new Fondo();
    public jf_login() {
    	setUndecorated(true); //con setUndecorated true, no aparece la barra de título del JFrame
    	setTitle("Dentilax");
    	setIconImage(Toolkit.getDefaultToolkit().getImage(jf_login.class.getResource("/iconos_menus/dentilaxIcono.png")));
    	setPreferredSize(new Dimension(1450, 750));
        this.setContentPane(fondo);
        initComponents();
        panelFondo.setLayout(null);
        Panel p = new Panel("/Dentilax/imagenes/iconos_menus/panel_login.png");
        p.setBounds(0, 0, 0, 0);
        panelFondo.add(p);
        panelFondo.add(p);
        panelFondo.add(interior);
        interior.setLayout(null);
        interior.add(cb_recordar);
        interior.add(btn_recuperar_pass);
        interior.add(jPanel1);
        jPanel1.setLayout(null);
        
        lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setIcon(new ImageIcon(jf_login.class.getResource("/iconos_menus/password.png")));
        lblNewLabel_2.setBounds(8, 9, 48, 48);
        jPanel1.add(lblNewLabel_2);
        interior.add(jPanel2);
        jPanel2.setLayout(null);
        
        lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon(jf_login.class.getResource("/iconos_menus/user (Personalizado).png")));
        lblNewLabel_1.setBounds(10, 11, 43, 44);
        jPanel2.add(lblNewLabel_1);
        interior.add(jtf_user);
        
        jtf_user1 = new JPasswordField();
        jtf_user1.setBorder(null);
        jtf_user1.setHorizontalAlignment(SwingConstants.CENTER);
        jtf_user1.setFont(new Font("Barlow", Font.PLAIN, 25));
        jtf_user1.setToolTipText("Introduce contraseña");
        jtf_user1.setBackground(new Color(128, 208, 244));
        jtf_user1.setBounds(136, 199, 290, 65);
        interior.add(jtf_user1);
        panelFondo.add(btn_entrar);
        
        lbl_fecha = new JLabel("");
        lbl_fecha.setForeground(new Color(0, 203, 208));
        lbl_fecha.setBackground(Color.WHITE);
        lbl_fecha.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 25));
        lbl_fecha.setBounds(124, 165, 261, 35);
        panelFondo.add(lbl_fecha);
        
        panel = new JPanel();
        panel.setOpaque(false);
        panel.setBounds(150, 504, 164, 63);
        panelFondo.add(panel);
        panel.setLayout(null);
        
        btnNewButton = new JButton("");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        	}
        });
        btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnNewButton.setIcon(new ImageIcon(jf_login.class.getResource("/iconos_menus/icono_salir.png")));
        btnNewButton.setOpaque(false);
        btnNewButton.setContentAreaFilled(false);
        btnNewButton.setBorder(null);
        btnNewButton.setBorderPainted(false);
        btnNewButton.setBounds(0, 0, 65, 63);
        panel.add(btnNewButton);
        
        btnNewButton_1 = new JButton("");
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Ayuda_login ayuda = new Ayuda_login();
        		ayuda.setVisible(true);
        	}
        });
        btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnNewButton_1.setIcon(new ImageIcon(jf_login.class.getResource("/iconos_menus/icono_ayuda.png")));
        btnNewButton_1.setOpaque(false);
        btnNewButton_1.setContentAreaFilled(false);
        btnNewButton_1.setBorderPainted(false);
        btnNewButton_1.setBorder(null);
        btnNewButton_1.setBounds(99, 0, 65, 63);
        panel.add(btnNewButton_1);
        
        lblNewLabel = new JLabel("");
        lblNewLabel.setBounds(683, 87, 500, 450);
        panelFondo.add(lblNewLabel);
        lblNewLabel.setIcon(new ImageIcon(jf_login.class.getResource("/iconos_menus/panel_login.png")));
     
     //aqui empieza el Jlabel que será modificado por el hilo:
        JLabel lblNewLabel_3 = new JLabel(""); 
        lblNewLabel_3.setIcon(new ImageIcon(jf_login.class.getResource("/iconos_menus/dent.png")));
        lblNewLabel_3.setBounds(0, 84, 483, 545);
        panelFondo.add(lblNewLabel_3);
        
        //aqui empieza el hilo para poder colocar la fecha y hora en nuestro programa:
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	 Date fechaActual = new Date();
                 SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                 String fechaHoraFormateada = formato.format(fechaActual);
                 lbl_fecha.setText(fechaHoraFormateada);
            }
        });
        timer.start();
        this.setLocationRelativeTo(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
    	//comentario de prueba
    	 ConectorDB_mysql sentencias = new ConectorDB_mysql();
        panelFondo = new Fondo();
        panelFondo.setPreferredSize(new Dimension(1450, 750));
        panelFondo.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        panelFondo.setOpaque(false);
        panelFondo.setBorder(null);
        interior = new javax.swing.JPanel();
        interior.setBounds(694, 135, 483, 350);
        interior.setOpaque(false);
        jtf_user = new javax.swing.JTextField();
        jtf_user.setFont(new Font("Barlow", Font.PLAIN, 20));
        jtf_user.setForeground(new Color(0, 128, 192));
        
        //a partir de aqui conseguimos que el texto desaparezca cuando el textfield reciba el click:
        jtf_user.addFocusListener(new FocusAdapter() {
        	@Override
        	public void focusGained(FocusEvent e) {
        		if (jtf_user.getText().equals("Introduce usuario")) {
                    jtf_user.setText("");
                 //   jtf_user.setForeground(Color.WHITE);
                }
        	}
        	@Override
        	public void focusLost(FocusEvent e) {
        		 if (jtf_user.getText().isEmpty()) {
                     jtf_user.setForeground(new Color(0, 128, 192));
                     jtf_user.setText("Introduce usuario");
                 }
        	}
        });
        jtf_user.setHorizontalAlignment(SwingConstants.CENTER);
        jtf_user.setToolTipText("Introduce el DNI del usuario");
        
        jtf_user.setBorder(null);
        jtf_user.setCaretColor(new Color(255, 255, 255));
        jtf_user.setBounds(132, 83, 294, 65);
        jPanel1 = new javax.swing.JPanel();
        jPanel1.setBounds(63, 199, 63, 65);
        jPanel2 = new javax.swing.JPanel();
        jPanel2.setBounds(63, 83, 63, 65);
        cb_recordar = new javax.swing.JCheckBox();
        cb_recordar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        cb_recordar.setForeground(new Color(32, 160, 216));
        cb_recordar.setFont(new Font("Arial", Font.PLAIN, 12));
        cb_recordar.setContentAreaFilled(false);
        cb_recordar.setBorder(null);
        cb_recordar.setBounds(63, 291, 105, 37);
        btn_recuperar_pass = new javax.swing.JButton();
        btn_recuperar_pass.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btn_recuperar_pass.setOpaque(false);
        btn_recuperar_pass.setBorder(new LineBorder(new Color(32, 160, 216), 1, true));
        btn_recuperar_pass.setBackground(new Color(255, 255, 255));
        btn_recuperar_pass.setForeground(new Color(32, 160, 216));
        btn_recuperar_pass.setFont(new Font("Arial", Font.PLAIN, 12));
        btn_recuperar_pass.setBounds(269, 291, 157, 37);
        btn_entrar = new javax.swing.JButton();
        btn_entrar.setBorderPainted(false);
        btn_entrar.setBounds(748, 566, 375, 63);
        btn_entrar.setContentAreaFilled(false);
        btn_entrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btn_entrar.setBorder(null);
        btn_entrar.setOpaque(false);
        btn_entrar.setToolTipText("Pulsa para logearte");
        btn_entrar.setIcon(new ImageIcon(jf_login.class.getResource("/iconos_menus/btn_entrar_icon.png")));
        
        
       //Acceso a SQL: 
        btn_entrar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
               
               try {//Si esto es correcto entrarás como administrador
            	String user = jtf_user.getText().toString();
            	String pass = jtf_user1.getText().toString();
				String comprobar = sentencias.consulta_login(user, pass);
				if (comprobar.equals("Admin")) {
				
					System.out.println("Estoy accediendo como administrador");
				jf_menu_ppal menu_admin = new jf_menu_ppal();
				menu_admin.setVisible(true);
				dispose(); 
}
				else {
                           //si no es el admin, entrará como doctor 
					System.out.println("Estoy accediendo como doctor");
					jf_menu_doctor ventana = new jf_menu_doctor();
					ventana.setVisible(true);
					dispose();
}
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				JOptionPane error = new JOptionPane();
				error.showMessageDialog(error, "Error en el login");
				e1.printStackTrace();
				//si no consigue los datos va a dar error al logearte
			}
               catch(NullPointerException n) {
            	   JOptionPane error = new JOptionPane();
            	   error.showMessageDialog(error, "No hay datos, comprueba la conexión a la base de datos "
            	   		+ "o en su defecto, que no haya campos vacíos y vuelve a intentarlo");
               }
            }
                
                
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        interior.setBackground(new java.awt.Color(255, 255, 255));

        jtf_user.setBackground(new java.awt.Color(128, 208, 244));
        jtf_user.setText("Introduce usuario");

        jPanel1.setBackground(new java.awt.Color(32, 160, 216));

        jPanel2.setBackground(new java.awt.Color(32, 160, 216));

        cb_recordar.setText("Recuérdame");

        btn_recuperar_pass.setText("Recuperar contraseña");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                new jf_login().setVisible(true);
                
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_entrar;
    private javax.swing.JButton btn_recuperar_pass;
    private javax.swing.JCheckBox cb_recordar;
    private javax.swing.JPanel interior;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jtf_user;
    private javax.swing.JPanel panelFondo;
    private JLabel lblNewLabel;
    private JLabel lblNewLabel_1;
    private JLabel lblNewLabel_2;
    private JPanel panel;
    private JButton btnNewButton;
    private JButton btnNewButton_1;
    private JLabel lbl_fecha;
    private JPasswordField jtf_user1;
}




import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.Panel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import java.awt.Cursor;
import java.awt.Font;

public class jf_doctores extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 * 
	 */Fondo fondo = new Fondo();
	    public jf_doctores() {
	    	setResizable(false);
	    	setPreferredSize(new Dimension(1450, 750));
	        this.setContentPane(fondo);      
	        initComponents();
	        this.setLocationRelativeTo(jp_menu);
	        jp_menu.setLayout(null);
	        jp_menu.add(btn_buscar_doctor);
	        jp_menu.add(btn_especialidades);
	        jp_menu.add(btn_baja_doctores);
	        jp_menu.add(btn_alta_doctores);
	    }

	    /**
	     * This method is called from within the constructor to initialize the form.
	     * WARNING: Do NOT modify this code. The content of this method is always
	     * regenerated by the Form Editor.
	     */
	    @SuppressWarnings("unchecked")
	    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
	    private void initComponents() {

	        jp_menu = new Fondo();
	        jp_menu.setPreferredSize(new Dimension(1450, 750));
	        btn_buscar_doctor = new javax.swing.JButton();
	        btn_buscar_doctor.setBorderPainted(false);
	        btn_buscar_doctor.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	        btn_buscar_doctor.setBounds(68, 590, 188, 41);
	        btn_buscar_doctor.setIcon(new ImageIcon(jf_doctores.class.getResource("/iconos_submenus/btn_buscarDr_admin.png")));
	        btn_buscar_doctor.setContentAreaFilled(false);
	        btn_buscar_doctor.setOpaque(false);
	        btn_buscar_doctor.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		jd_buscar_dr ventana = new jd_buscar_dr();
	        		ventana.setVisible(true);
	        	}
	        });
	        btn_alta_doctores = new javax.swing.JButton();
	        btn_alta_doctores.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		
	        		jd_doctores_alta ventana = new jd_doctores_alta();
	        		ventana.setVisible(true);
	        		
	        		
	        	}
	        });
	        btn_alta_doctores.setBorderPainted(false);
	        btn_alta_doctores.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	        btn_alta_doctores.setIcon(new ImageIcon(jf_doctores.class.getResource("/iconos_submenus/btn_darAlta_admin.png")));
	        btn_alta_doctores.setContentAreaFilled(false);
	        btn_alta_doctores.setOpaque(false);
	        btn_alta_doctores.setSelected(true);
	        btn_alta_doctores.setBounds(1183, 590, 188, 41);
	        btn_especialidades = new javax.swing.JButton();
	        btn_especialidades.setBorderPainted(false);
	        btn_especialidades.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		jd_especialidades ventana = new jd_especialidades();
	        		ventana.setVisible(true);
	        		
	        	}
	        });
	        btn_especialidades.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	        btn_especialidades.setIcon(new ImageIcon(jf_doctores.class.getResource("/iconos_submenus/btn_especialidades_admin.png")));
	        btn_especialidades.setContentAreaFilled(false);
	        btn_especialidades.setOpaque(false);
	        btn_especialidades.setBounds(400, 590, 188, 41);
	        btn_baja_doctores = new javax.swing.JButton();
	        btn_baja_doctores.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		jd_buscar_doctor_baja ventana = new jd_buscar_doctor_baja();
	        		ventana.setVisible(true);
	        	}
	        });
	        btn_baja_doctores.setBorderPainted(false);
	        btn_baja_doctores.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	        btn_baja_doctores.setContentAreaFilled(false);
	        btn_baja_doctores.setOpaque(false);
	        btn_baja_doctores.setIcon(new ImageIcon(jf_doctores.class.getResource("/iconos_submenus/btn_darDeBaja_admin.png")));
	        btn_baja_doctores.setBounds(863, 590, 188, 41);
	        menu_inicio = new javax.swing.JMenuBar();
	        jMenu1 = new javax.swing.JMenu();
	        jMenu1.setFont(new Font("Arial", Font.PLAIN, 12));
	        jMenu2 = new javax.swing.JMenu();
	        jMenu2.setFont(new Font("Arial", Font.PLAIN, 12));
	        jMenu3 = new javax.swing.JMenu();
	        jMenu3.setFont(new Font("Arial", Font.PLAIN, 12));
	        jMenu4 = new javax.swing.JMenu();
	        jMenu4.setFont(new Font("Arial", Font.PLAIN, 12));
	        jMenu5 = new javax.swing.JMenu();
	        jMenu5.setFont(new Font("Arial", Font.PLAIN, 12));
	        jMenu6 = new javax.swing.JMenu();
	        jMenu6.setFont(new Font("Arial", Font.PLAIN, 12));
	        jMenu7 = new javax.swing.JMenu();
	        jMenu7.setFont(new Font("Arial", Font.PLAIN, 12));
	        jMenu8 = new javax.swing.JMenu();
	        jMenu8.setFont(new Font("Arial", Font.PLAIN, 12));

	        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

	        menu_inicio.setBackground(new java.awt.Color(32, 160, 216));
	        menu_inicio.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
	        menu_inicio.setBorderPainted(false);

	        jMenu1.setBackground(new java.awt.Color(32, 160, 216));
	        jMenu1.setText("INICIO");
	        menu_inicio.add(jMenu1);
	        
	        JMenuItem jmenuitem_volver = new JMenuItem("Volver");
	        jmenuitem_volver.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		dispose();
	        		jf_menu_ppal ventana = new jf_menu_ppal();
	        		ventana.setVisible(true);
	        	}
	        });
	        jmenuitem_volver.setFont(new Font("Arial", Font.PLAIN, 12));
	        jMenu1.add(jmenuitem_volver);

	        jMenu2.setText("PACIENTES");
	        menu_inicio.add(jMenu2);
	        
	        jmenuitem_menu_paciente = new JMenuItem("Menu paciente");
	        jmenuitem_menu_paciente.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		dispose();
	        		jf_pacientes ventana = new jf_pacientes();
	        		ventana.setVisible(true);
	        	}
	        });
	        jmenuitem_menu_paciente.setFont(new Font("Arial", Font.PLAIN, 12));
	        jMenu2.add(jmenuitem_menu_paciente);
	        
	        jmenuitem_buscar_paciente = new JMenuItem("Buscar paciente");
	        jmenuitem_buscar_paciente.setFont(new Font("Arial", Font.PLAIN, 12));
	        jMenu2.add(jmenuitem_buscar_paciente);
	        
	        jmenuitem_editar_paciente = new JMenuItem("Editar paciente");
	        jmenuitem_editar_paciente.setFont(new Font("Arial", Font.PLAIN, 12));
	        jMenu2.add(jmenuitem_editar_paciente);
	        
	        jmenuitem_baja_paciente = new JMenuItem("Dar de baja");
	        jmenuitem_baja_paciente.setFont(new Font("Arial", Font.PLAIN, 12));
	        jMenu2.add(jmenuitem_baja_paciente);
	        
	        jmenuitem_alta_paciente = new JMenuItem("Dar de alta");
	        jmenuitem_alta_paciente.setFont(new Font("Arial", Font.PLAIN, 12));
	        jMenu2.add(jmenuitem_alta_paciente);

	        jMenu3.setText("DOCTORES");
	        menu_inicio.add(jMenu3);
	        
	        jmenuitem_menu_doctor = new JMenuItem("Menu doctor");
	        jmenuitem_menu_doctor.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		dispose();
	        		jf_doctores ventana = new jf_doctores();
	        		ventana.setVisible(true);
	        	}
	        });
	        jmenuitem_menu_doctor.setFont(new Font("Arial", Font.PLAIN, 12));
	        jMenu3.add(jmenuitem_menu_doctor);
	        
	        jmenuitem_buscar_doctor = new JMenuItem("Buscar doctor");
	        jmenuitem_buscar_doctor.setFont(new Font("Arial", Font.PLAIN, 12));
	        jMenu3.add(jmenuitem_buscar_doctor);
	        
	        jmenuitem_especialidad_doctor = new JMenuItem("Especialidad");
	        jmenuitem_especialidad_doctor.setFont(new Font("Arial", Font.PLAIN, 12));
	        jMenu3.add(jmenuitem_especialidad_doctor);
	        
	        jmenuitem_baja_doctor = new JMenuItem("Dar de baja");
	        jmenuitem_baja_doctor.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		dispose();
	        		jf_doctores ventana = new jf_doctores();
	        		jd_buscar_doctor_baja ventana_alta = new jd_buscar_doctor_baja();
	        		ventana.setVisible(true);
	        		ventana_alta.setVisible(true);
	        	}
	        });
	        jmenuitem_baja_doctor.setFont(new Font("Arial", Font.PLAIN, 12));
	        jMenu3.add(jmenuitem_baja_doctor);
	        
	        jmenuitem_alta_doctor = new JMenuItem("Dar de alta");
	        jmenuitem_alta_doctor.setFont(new Font("Arial", Font.PLAIN, 12));
	        jMenu3.add(jmenuitem_alta_doctor);

	        jMenu4.setText("MATERIAL");
	        menu_inicio.add(jMenu4);
	        
	        jmenuitem_menu_material = new JMenuItem("Menu material");
	        jmenuitem_menu_material.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		dispose();
	        		jf_material ventana = new jf_material();
	        		ventana.setVisible(true);
	        	}
	        });
	        jmenuitem_menu_material.setFont(new Font("Arial", Font.PLAIN, 12));
	        jMenu4.add(jmenuitem_menu_material);
	        
	        jmenuitem_buscar_pedido = new JMenuItem("Buscar pedido");
	        jmenuitem_buscar_pedido.setFont(new Font("Arial", Font.PLAIN, 12));
	        jMenu4.add(jmenuitem_buscar_pedido);
	        
	        jmenuitem_proveedores = new JMenuItem("Proveedores");
	        jmenuitem_proveedores.setFont(new Font("Arial", Font.PLAIN, 12));
	        jMenu4.add(jmenuitem_proveedores);
	        
	        jmenuitem_cancelar_pedido = new JMenuItem("Cancelar pedido");
	        jmenuitem_cancelar_pedido.setFont(new Font("Arial", Font.PLAIN, 12));
	        jMenu4.add(jmenuitem_cancelar_pedido);
	        
	        jmenuitem_nuevo_pedido = new JMenuItem("Nuevo pedido");
	        jmenuitem_nuevo_pedido.setFont(new Font("Arial", Font.PLAIN, 12));
	        jMenu4.add(jmenuitem_nuevo_pedido);
	        
	        jmenuitem_inventario = new JMenuItem("Inventario");
	        jmenuitem_inventario.setFont(new Font("Arial", Font.PLAIN, 12));
	        jMenu4.add(jmenuitem_inventario);
	        
	        jmenuitem_solicitudes = new JMenuItem("Solicitudes");
	        jmenuitem_solicitudes.setFont(new Font("Arial", Font.PLAIN, 12));
	        jMenu4.add(jmenuitem_solicitudes);

	        jMenu5.setText("CONSULTAS");
	        menu_inicio.add(jMenu5);
	        
	        JMenuItem jmenuitem_menu_consulta = new JMenuItem("Menu consulta");
	        jmenuitem_menu_consulta.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		dispose();
	        		jf_consulta ventana = new jf_consulta();
	        		ventana.setVisible(true);
	        	}
	        });
	        jmenuitem_menu_consulta.setFont(new Font("Arial", Font.PLAIN, 12));
	        jMenu5.add(jmenuitem_menu_consulta);
	        
	        JMenuItem jmenuitem_buscar_cita = new JMenuItem("Buscar cita");
	        jmenuitem_buscar_cita.setFont(new Font("Arial", Font.PLAIN, 12));
	        jMenu5.add(jmenuitem_buscar_cita);
	        
	        JMenuItem jmenuitem_historial = new JMenuItem("Historial");
	        jmenuitem_historial.setFont(new Font("Arial", Font.PLAIN, 12));
	        jMenu5.add(jmenuitem_historial);
	        
	        JMenuItem jmenuitem_eliminar_cita = new JMenuItem("Eliminar cita");
	        jmenuitem_eliminar_cita.setFont(new Font("Arial", Font.PLAIN, 12));
	        jMenu5.add(jmenuitem_eliminar_cita);
	        
	        JMenuItem jmenuitem_nueva_cita = new JMenuItem("Nueva cita");
	        jmenuitem_nueva_cita.setFont(new Font("Arial", Font.PLAIN, 12));
	        jMenu5.add(jmenuitem_nueva_cita);

	        jMenu6.setText("FACTURACIÓN");
	        menu_inicio.add(jMenu6);
	        
	        jmenuitem_menu_facturacion = new JMenuItem("Menu facturacion");
	        jmenuitem_menu_facturacion.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		dispose();
	        		jf_facturacion ventana = new jf_facturacion();
	        		ventana.setVisible(true);
	        	}
	        });
	        jmenuitem_menu_facturacion.setFont(new Font("Arial", Font.PLAIN, 12));
	        jMenu6.add(jmenuitem_menu_facturacion);
	        
	        JMenuItem jmenuitem_buscar_factura = new JMenuItem("Buscar factura");
	        jmenuitem_buscar_factura.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		dispose();
	        		jf_facturacion ventana = new jf_facturacion();
	        		jd_buscar_factura ventana_buscar = new jd_buscar_factura();
	        		ventana.setVisible(true);
	        		ventana_buscar.setVisible(true);
	        	}
	        });
	        jmenuitem_buscar_factura.setFont(new Font("Arial", Font.PLAIN, 12));
	        jMenu6.add(jmenuitem_buscar_factura);
	        
	        jmenuitem_historial_pago = new JMenuItem("Historial pago");
	        jmenuitem_historial_pago.setFont(new Font("Arial", Font.PLAIN, 12));
	        jMenu6.add(jmenuitem_historial_pago);
	        
	        jmenuitem_balance_gastos = new JMenuItem("Balance gastos");
	        jmenuitem_balance_gastos.setFont(new Font("Arial", Font.PLAIN, 12));
	        jMenu6.add(jmenuitem_balance_gastos);
	        
	        jmenuitem_nueva_factura = new JMenuItem("Nueva factura");
	        jmenuitem_nueva_factura.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		dispose();
	        		jf_facturacion ventana = new jf_facturacion();
	        		jd_nueva_factura ventana_nueva = new jd_nueva_factura();
	        		ventana.setVisible(true);
	        		ventana_nueva.setVisible(true);
	        	}
	        });
	        jmenuitem_nueva_factura.setFont(new Font("Arial", Font.PLAIN, 12));
	        jMenu6.add(jmenuitem_nueva_factura);

	        jMenu7.setText("AJUSTES");
	        menu_inicio.add(jMenu7);

	        jMenu8.setText("AYUDA");
	        menu_inicio.add(jMenu8);

	        setJMenuBar(menu_inicio);

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
	                new jf_doctores().setVisible(true);
	            }
	        });
	    }
	    private javax.swing.JButton btn_especialidades;
	    private javax.swing.JButton btn_alta_doctores;
	    private javax.swing.JButton btn_buscar_doctor;
	    private javax.swing.JMenu jMenu1;
	    private javax.swing.JMenu jMenu2;
	    private javax.swing.JMenu jMenu3;
	    private javax.swing.JMenu jMenu4;
	    private javax.swing.JMenu jMenu5;
	    private javax.swing.JMenu jMenu6;
	    private javax.swing.JMenu jMenu7;
	    private javax.swing.JMenu jMenu8;
	    private javax.swing.JPanel jp_menu;
	    private javax.swing.JMenuBar menu_inicio;
	    private JButton btn_baja_doctores;
	    private JMenuItem jmenuitem_menu_paciente;
	    private JMenuItem jmenuitem_buscar_paciente;
	    private JMenuItem jmenuitem_editar_paciente;
	    private JMenuItem jmenuitem_alta_paciente;
	    private JMenuItem jmenuitem_baja_paciente;
	    private JMenuItem jmenuitem_menu_doctor;
	    private JMenuItem jmenuitem_buscar_doctor;
	    private JMenuItem jmenuitem_alta_doctor;
	    private JMenuItem jmenuitem_baja_doctor;
	    private JMenuItem jmenuitem_especialidad_doctor;
	    private JMenuItem jmenuitem_inventario;
	    private JMenuItem jmenuitem_menu_material;
	    private JMenuItem jmenuitem_solicitudes;
	    private JMenuItem jmenuitem_buscar_pedido;
	    private JMenuItem jmenuitem_cancelar_pedido;
	    private JMenuItem jmenuitem_nuevo_pedido;
	    private JMenuItem jmenuitem_proveedores;
	    private JMenuItem jmenuitem_menu_facturacion;
	    private JMenuItem jmenuitem_historial_pago;
	    private JMenuItem jmenuitem_nueva_factura;
	    private JMenuItem jmenuitem_balance_gastos;
	}
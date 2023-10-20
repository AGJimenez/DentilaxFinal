
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.Dimension;
import java.awt.Cursor;
import javax.swing.JMenuItem;
import java.awt.Font;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author alexg
 */
public class jf_menu_ppal extends javax.swing.JFrame {

    /**
     * Creates new form jf_menu_ppal
     */
    Fondo fondo = new Fondo();
    public jf_menu_ppal() {
    	setPreferredSize(new Dimension(1450, 750));
    	setSize(new Dimension(1450, 750));
    	setResizable(false);
        this.setContentPane(fondo);      
        initComponents();
        setLocationRelativeTo(this);
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
        jp_menu.setSize(new Dimension(1450, 750));
        btn_pacientes = new javax.swing.JButton();
        btn_pacientes.setBorderPainted(false);
        btn_pacientes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btn_pacientes.setOpaque(false);
        btn_pacientes.setContentAreaFilled(false);
        btn_pacientes.setIcon(new ImageIcon(jf_menu_ppal.class.getResource("/iconos_menus/btn_pacientes_admin.png")));
        btn_pacientes.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        		jf_pacientes jf_pacientes = new jf_pacientes();
        		jf_pacientes.setVisible(true);
        	}
        });
        btn_material = new javax.swing.JButton();
        btn_material.setBorderPainted(false);
        btn_material.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btn_material.setOpaque(false);
        btn_material.setIcon(new ImageIcon(jf_menu_ppal.class.getResource("/iconos_menus/btn_material_admin.png")));
        btn_material.setContentAreaFilled(false);
        btn_material.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		dispose();
        		jf_material jf_material = new jf_material();
        		jf_material.setVisible(true);
        		
        	}
        });
        btn_facturacion = new javax.swing.JButton();
        btn_facturacion.setBorderPainted(false);
        btn_facturacion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btn_facturacion.setIcon(new ImageIcon(jf_menu_ppal.class.getResource("/iconos_menus/btn_facturacion_admin.png")));
        btn_facturacion.setContentAreaFilled(false);
        btn_facturacion.setOpaque(false);
        btn_facturacion.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		dispose();
        		jf_facturacion jf_facturacion = new jf_facturacion();
        		jf_facturacion.setVisible(true);
        		
        	}
        });
        btn_ajustes = new javax.swing.JButton();
        btn_ajustes.setBorderPainted(false);
        btn_ajustes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btn_ajustes.setIcon(new ImageIcon(jf_menu_ppal.class.getResource("/iconos_menus/btn_ajustes_admin.png")));
        btn_ajustes.setContentAreaFilled(false);
        btn_ajustes.setOpaque(false);
        btn_ajustes.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btn_consultas = new javax.swing.JButton();
        btn_consultas.setBorderPainted(false);
        btn_consultas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btn_consultas.setIcon(new ImageIcon(jf_menu_ppal.class.getResource("/iconos_menus/btn_consultas_admin.png")));
        btn_consultas.setContentAreaFilled(false);
        btn_consultas.setOpaque(false);
        btn_consultas.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		dispose();
        		jf_consulta jf_consulta = new jf_consulta();
        		jf_consulta.setVisible(true);
        		
        	}
        });
        btn_doctores = new javax.swing.JButton();
        btn_doctores.setBorderPainted(false);
        btn_doctores.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btn_doctores.setIcon(new ImageIcon(jf_menu_ppal.class.getResource("/iconos_menus/btn_doctores_admin.png")));
        btn_doctores.setContentAreaFilled(false);
        btn_doctores.setOpaque(false);
        btn_doctores.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		dispose();
        		jf_doctores jf_doctores = new jf_doctores();
        		jf_doctores.setVisible(true);
        		
        	}
        });
        menu_inicio = new javax.swing.JMenuBar();
        jmenu_inicio = new javax.swing.JMenu();
        jmenu_inicio.setFont(new Font("Arial", Font.PLAIN, 12));
        jmenu_paciente = new javax.swing.JMenu();
        jmenu_paciente.setFont(new Font("Arial", Font.PLAIN, 12));
        jmenu_paciente.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        jmenu_doctor = new javax.swing.JMenu();
        jmenu_doctor.setFont(new Font("Arial", Font.PLAIN, 12));
        jmenu_material = new javax.swing.JMenu();
        jmenu_material.setFont(new Font("Arial", Font.PLAIN, 12));
        jmenu_consulta = new javax.swing.JMenu();
        jmenu_consulta.setFont(new Font("Arial", Font.PLAIN, 12));
        jmenu_facturacion = new javax.swing.JMenu();
        jmenu_facturacion.setFont(new Font("Arial", Font.PLAIN, 12));
        jmenu_ajustes = new javax.swing.JMenu();
        jmenu_ajustes.setFont(new Font("Arial", Font.PLAIN, 12));
        jmenu_ayuda = new javax.swing.JMenu();
        jmenu_ayuda.setFont(new Font("Arial", Font.PLAIN, 12));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jp_menuLayout = new javax.swing.GroupLayout(jp_menu);
        jp_menuLayout.setHorizontalGroup(
        	jp_menuLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jp_menuLayout.createSequentialGroup()
        			.addContainerGap(440, Short.MAX_VALUE)
        			.addGroup(jp_menuLayout.createParallelGroup(Alignment.TRAILING, false)
        				.addComponent(btn_facturacion, 0, 0, Short.MAX_VALUE)
        				.addComponent(btn_pacientes, GroupLayout.PREFERRED_SIZE, 277, Short.MAX_VALUE)
        				.addComponent(btn_material, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 281, Short.MAX_VALUE))
        			.addPreferredGap(ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
        			.addGroup(jp_menuLayout.createParallelGroup(Alignment.TRAILING)
        				.addGroup(jp_menuLayout.createParallelGroup(Alignment.LEADING, false)
        					.addComponent(btn_consultas, 0, 0, Short.MAX_VALUE)
        					.addComponent(btn_doctores, GroupLayout.PREFERRED_SIZE, 273, Short.MAX_VALUE))
        				.addComponent(btn_ajustes, GroupLayout.PREFERRED_SIZE, 273, GroupLayout.PREFERRED_SIZE))
        			.addContainerGap(441, Short.MAX_VALUE))
        );
        jp_menuLayout.setVerticalGroup(
        	jp_menuLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jp_menuLayout.createSequentialGroup()
        			.addGap(218)
        			.addGroup(jp_menuLayout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(btn_pacientes, GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
        				.addComponent(btn_doctores, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE))
        			.addGap(4)
        			.addGroup(jp_menuLayout.createParallelGroup(Alignment.LEADING)
        				.addComponent(btn_consultas, GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
        				.addComponent(btn_material, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(jp_menuLayout.createParallelGroup(Alignment.LEADING, false)
        				.addComponent(btn_facturacion, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addComponent(btn_ajustes, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        			.addGap(217))
        );
        jp_menu.setLayout(jp_menuLayout);

        menu_inicio.setBackground(new java.awt.Color(32, 160, 216));
        menu_inicio.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        menu_inicio.setBorderPainted(false);

        jmenu_inicio.setBackground(new java.awt.Color(32, 160, 216));
        jmenu_inicio.setText("INICIO");
        menu_inicio.add(jmenu_inicio);
        
        jmenuitem_volver = new JMenuItem("Volver");
        jmenuitem_volver.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        		jf_menu_ppal ventana = new jf_menu_ppal();
        		ventana.setVisible(true);
        	}
        });
        jmenuitem_volver.setFont(new Font("Arial", Font.PLAIN, 12));
        jmenu_inicio.add(jmenuitem_volver);

        jmenu_paciente.setText("PACIENTES");
        menu_inicio.add(jmenu_paciente);
        
        jmenuitem_menu_paciente = new JMenuItem("Menu paciente");
        jmenuitem_menu_paciente.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		jf_pacientes ventana = new jf_pacientes();
        		dispose();
        		ventana.setVisible(true);
        	}
        });
        jmenuitem_menu_paciente.setFont(new Font("Arial", Font.PLAIN, 12));
        jmenu_paciente.add(jmenuitem_menu_paciente);
        
        jmenuitem_buscar_paciente = new JMenuItem("Buscar paciente");
        jmenuitem_buscar_paciente.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        		jf_pacientes ventana = new jf_pacientes();
        		jd_buscar_paciente ventana_buscar = new jd_buscar_paciente();
        		ventana.setVisible(true);
        		ventana_buscar.setVisible(true);
        	}
        });
        jmenuitem_buscar_paciente.setFont(new Font("Arial", Font.PLAIN, 12));
        jmenu_paciente.add(jmenuitem_buscar_paciente);
        
        jmenuitem_editar_paciente = new JMenuItem("Editar paciente");
        jmenuitem_editar_paciente.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        		jf_pacientes ventana = new jf_pacientes();
        		jd_buscar_paciente_editar ventana_buscar = new jd_buscar_paciente_editar();
        		ventana.setVisible(true);
        		ventana_buscar.setVisible(true);
        	}
        });
        jmenuitem_editar_paciente.setFont(new Font("Arial", Font.PLAIN, 12));
        jmenu_paciente.add(jmenuitem_editar_paciente);
        
        jmenuitem_baja_paciente = new JMenuItem("Dar de baja");
        jmenuitem_baja_paciente.setFont(new Font("Arial", Font.PLAIN, 12));
        jmenu_paciente.add(jmenuitem_baja_paciente);
        
        jmenuitem_alta_paciente = new JMenuItem("Dar de alta");
        jmenuitem_alta_paciente.setFont(new Font("Arial", Font.PLAIN, 12));
        jmenu_paciente.add(jmenuitem_alta_paciente);

        jmenu_doctor.setText("DOCTORES");
        menu_inicio.add(jmenu_doctor);
        
        jmenuitem_menu_doctores = new JMenuItem("Menu doctor");
        jmenuitem_menu_doctores.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        		jf_doctores ventana = new jf_doctores();
        		ventana.setVisible(true);
        	}
        });
        jmenuitem_menu_doctores.setFont(new Font("Arial", Font.PLAIN, 12));
        jmenu_doctor.add(jmenuitem_menu_doctores);
        
        jmenuitem_buscar_doctores = new JMenuItem("Buscar doctor");
        jmenuitem_buscar_doctores.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        		jf_doctores ventana = new jf_doctores();
        		jd_buscar_dr ventana_buscar = new jd_buscar_dr();
        		ventana.setVisible(true);
        		ventana_buscar.setVisible(true);
        	}
        });
        jmenuitem_buscar_doctores.setFont(new Font("Arial", Font.PLAIN, 12));
        jmenu_doctor.add(jmenuitem_buscar_doctores);
        
        jmenuitem_especialidad_doctores = new JMenuItem("Especialidad");
        jmenuitem_especialidad_doctores.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        		jf_doctores ventana = new jf_doctores();
        		jd_especialidades ventana_especialidad = new jd_especialidades();
        		ventana.setVisible(true);
        		ventana_especialidad.setVisible(true);
        	}
        });
        jmenuitem_especialidad_doctores.setFont(new Font("Arial", Font.PLAIN, 12));
        jmenu_doctor.add(jmenuitem_especialidad_doctores);
        
        jmenuitem_baja_doctores = new JMenuItem("Dar de baja");
        jmenuitem_baja_doctores.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        		jf_doctores ventana = new jf_doctores();
        		jd_buscar_doctor_baja ventana_alta = new jd_buscar_doctor_baja();
        		ventana.setVisible(true);
        		ventana_alta.setVisible(true);
        	}
        });
        jmenuitem_baja_doctores.setFont(new Font("Arial", Font.PLAIN, 12));
        jmenu_doctor.add(jmenuitem_baja_doctores);
        
        jmenuitem_alta_doctores = new JMenuItem("Dar de alta");
        jmenuitem_alta_doctores.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        		jf_doctores ventana = new jf_doctores();
        		jd_doctores_alta ventana_alta = new jd_doctores_alta();
        		ventana.setVisible(true);
        		ventana_alta.setVisible(true);
        	}
        });
        jmenuitem_alta_doctores.setFont(new Font("Arial", Font.PLAIN, 12));
        jmenu_doctor.add(jmenuitem_alta_doctores);

        jmenu_material.setText("MATERIAL");
        menu_inicio.add(jmenu_material);
        
        jmenuitem_menu_material = new JMenuItem("Menu material");
        jmenuitem_menu_material.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        		jf_material ventana = new jf_material();
        		ventana.setVisible(true);
        	}
        });
        jmenuitem_menu_material.setFont(new Font("Arial", Font.PLAIN, 12));
        jmenu_material.add(jmenuitem_menu_material);
        
        jmenuitem_buscar_pedido = new JMenuItem("Buscar pedido");
        jmenuitem_buscar_pedido.setFont(new Font("Arial", Font.PLAIN, 12));
        jmenu_material.add(jmenuitem_buscar_pedido);
        
        jmenuitem_proveedores = new JMenuItem("Proveedores");
        jmenuitem_proveedores.setFont(new Font("Arial", Font.PLAIN, 12));
        jmenu_material.add(jmenuitem_proveedores);
        
        jmenuitem_cancelar = new JMenuItem("Cancelar pedido");
        jmenuitem_cancelar.setFont(new Font("Arial", Font.PLAIN, 12));
        jmenu_material.add(jmenuitem_cancelar);
        
        jmenuitem_nuevo_pedido = new JMenuItem("Nuevo pedido");
        jmenuitem_nuevo_pedido.setFont(new Font("Arial", Font.PLAIN, 12));
        jmenu_material.add(jmenuitem_nuevo_pedido);
        
        jmenuitem_inventario = new JMenuItem("Inventario");
        jmenuitem_inventario.setFont(new Font("Arial", Font.PLAIN, 12));
        jmenu_material.add(jmenuitem_inventario);
        
        jmenuitem_solicitudes = new JMenuItem("Solicitudes");
        jmenuitem_solicitudes.setFont(new Font("Arial", Font.PLAIN, 12));
        jmenu_material.add(jmenuitem_solicitudes);

        jmenu_consulta.setText("CONSULTAS");
        menu_inicio.add(jmenu_consulta);
        
        jmenuitem_menu_consulta = new JMenuItem("Menu consulta");
        jmenuitem_menu_consulta.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        		jf_consulta ventana = new jf_consulta();
        		ventana.setVisible(true);
        	}
        });
        jmenuitem_menu_consulta.setFont(new Font("Arial", Font.PLAIN, 12));
        jmenu_consulta.add(jmenuitem_menu_consulta);
        
        jmenuitem_buscar_cita = new JMenuItem("Buscar cita");
        jmenuitem_buscar_cita.setFont(new Font("Arial", Font.PLAIN, 12));
        jmenu_consulta.add(jmenuitem_buscar_cita);
        
        jmenuitem_historial = new JMenuItem("Historial");
        jmenuitem_historial.setFont(new Font("Arial", Font.PLAIN, 12));
        jmenu_consulta.add(jmenuitem_historial);
        
        jmenuitem_eliminar_cita = new JMenuItem("Eliminar cita");
        jmenuitem_eliminar_cita.setFont(new Font("Arial", Font.PLAIN, 12));
        jmenu_consulta.add(jmenuitem_eliminar_cita);
        
        jmenuitem_nueva_cita = new JMenuItem("Nueva cita");
        jmenuitem_nueva_cita.setFont(new Font("Arial", Font.PLAIN, 12));
        jmenu_consulta.add(jmenuitem_nueva_cita);

        jmenu_facturacion.setText("FACTURACIÓN");
        menu_inicio.add(jmenu_facturacion);
        
        jmenuitem_menu_facturacion = new JMenuItem("Menu facturacion");
        jmenuitem_menu_facturacion.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        		jf_facturacion ventana = new jf_facturacion();
        		ventana.setVisible(true);
        	}
        });
        jmenuitem_menu_facturacion.setFont(new Font("Arial", Font.PLAIN, 12));
        jmenu_facturacion.add(jmenuitem_menu_facturacion);
        
        jmenuitem_buscar_factura = new JMenuItem("Buscar factura");
        jmenuitem_buscar_factura.setFont(new Font("Arial", Font.PLAIN, 12));
        jmenu_facturacion.add(jmenuitem_buscar_factura);
        
        jmenuitem_historial_pago = new JMenuItem("Historial de pago");
        jmenuitem_historial_pago.setFont(new Font("Arial", Font.PLAIN, 12));
        jmenu_facturacion.add(jmenuitem_historial_pago);
        
        jmenuitem_balance_gastos = new JMenuItem("Balance de gastos");
        jmenuitem_balance_gastos.setFont(new Font("Arial", Font.PLAIN, 12));
        jmenu_facturacion.add(jmenuitem_balance_gastos);
        
        jmenuitem_nueva_factura = new JMenuItem("Nueva factura");
        jmenuitem_nueva_factura.setFont(new Font("Arial", Font.PLAIN, 12));
        jmenu_facturacion.add(jmenuitem_nueva_factura);

        jmenu_ajustes.setText("AJUSTES");
        menu_inicio.add(jmenu_ajustes);
        
        mntmNewMenuItem = new JMenuItem("New menu item");
        jmenu_ajustes.add(mntmNewMenuItem);

        jmenu_ayuda.setText("AYUDA");
        menu_inicio.add(jmenu_ayuda);

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
                new jf_menu_ppal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_ajustes;
    private javax.swing.JButton btn_consultas;
    private javax.swing.JButton btn_doctores;
    private javax.swing.JButton btn_facturacion;
    private javax.swing.JButton btn_material;
    private javax.swing.JButton btn_pacientes;
    private javax.swing.JMenu jmenu_inicio;
    private javax.swing.JMenu jmenu_paciente;
    private javax.swing.JMenu jmenu_doctor;
    private javax.swing.JMenu jmenu_material;
    private javax.swing.JMenu jmenu_consulta;
    private javax.swing.JMenu jmenu_facturacion;
    private javax.swing.JMenu jmenu_ajustes;
    private javax.swing.JMenu jmenu_ayuda;
    private javax.swing.JPanel jp_menu;
    private javax.swing.JMenuBar menu_inicio;
    private JMenuItem jmenuitem_menu_paciente;
    private JMenuItem jmenuitem_buscar_paciente;
    private JMenuItem jmenuitem_editar_paciente;
    private JMenuItem jmenuitem_baja_paciente;
    private JMenuItem jmenuitem_alta_paciente;
    private JMenuItem jmenuitem_menu_doctores;
    private JMenuItem jmenuitem_buscar_doctores;
    private JMenuItem jmenuitem_especialidad_doctores;
    private JMenuItem jmenuitem_baja_doctores;
    private JMenuItem jmenuitem_alta_doctores;
    private JMenuItem jmenuitem_volver;
    private JMenuItem jmenuitem_menu_material;
    private JMenuItem jmenuitem_proveedores;
    private JMenuItem jmenuitem_cancelar;
    private JMenuItem jmenuitem_nuevo_pedido;
    private JMenuItem jmenuitem_buscar_pedido;
    private JMenuItem jmenuitem_inventario;
    private JMenuItem jmenuitem_solicitudes;
    private JMenuItem jmenuitem_menu_consulta;
    private JMenuItem jmenuitem_buscar_cita;
    private JMenuItem jmenuitem_historial;
    private JMenuItem jmenuitem_eliminar_cita;
    private JMenuItem jmenuitem_nueva_cita;
    private JMenuItem jmenuitem_menu_facturacion;
    private JMenuItem jmenuitem_buscar_factura;
    private JMenuItem jmenuitem_historial_pago;
    private JMenuItem jmenuitem_balance_gastos;
    private JMenuItem jmenuitem_nueva_factura;
    private JMenuItem mntmNewMenuItem;
    // End of variables declaration//GEN-END:variables
}

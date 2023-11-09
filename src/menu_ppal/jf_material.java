package menu_ppal;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.JMenuItem;
import java.awt.Dimension;
import java.awt.Cursor;
import java.awt.Toolkit;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.awt.event.InputEvent;
import java.awt.event.KeyAdapter;

public class jf_material extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	fondos.Fondo fondo = new fondos.Fondo();
	ArrayList<Integer> combo;
    public jf_material() {
    	setTitle("Gestión de material");
    	setIconImage(Toolkit.getDefaultToolkit().getImage(jf_material.class.getResource("/iconos_menus/dentilaxIcono.png")));
    	setPreferredSize(new Dimension(1450, 750));
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

        jp_menu = new fondos.Fondo();
        btn_buscar_pedido = new javax.swing.JButton();
        btn_buscar_pedido.setBounds(68, 620, 146, 23);
        btn_buscar_pedido.setBorderPainted(false);
        btn_buscar_pedido.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btn_nuevo_pedido = new javax.swing.JButton();
        btn_nuevo_pedido.setBounds(879, 620, 146, 23);
        btn_nuevo_pedido.setBorderPainted(false);
        btn_proveedores = new javax.swing.JButton();
        btn_proveedores.setBounds(401, 620, 146, 23);
        btn_proveedores.setBorderPainted(false);
        menu_inicio = new javax.swing.JMenuBar();
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

        btn_buscar_pedido.setText("BUSCAR PEDIDO");

        btn_nuevo_pedido.setText("NUEVO PEDIDO");

        btn_proveedores.setText("PROVEEDORES");
        
        btn_inventario = new JButton();
        btn_inventario.setBounds(68, 561, 146, 15);
        btn_inventario.setContentAreaFilled(false);
        btn_inventario.setBorder(null);
        btn_inventario.setOpaque(false);
        btn_inventario.setBorderPainted(false);
        btn_inventario.setText("INVENTARIO");
        
        btn_solicitudes = new JButton();
        btn_solicitudes.setBounds(1210, 620, 146, 23);
        btn_solicitudes.setBorderPainted(false);
        btn_solicitudes.setText("SOLICITUDES");

        menu_inicio.setBackground(new java.awt.Color(32, 160, 216));
        menu_inicio.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        menu_inicio.setBorderPainted(false);
        
        btn_inicio = new JButton("INICIO");
        btn_inicio.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btn_inicio.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        		jf_menu_ppal ventana = new jf_menu_ppal();
        		ventana.setVisible(true);
        	}
        });
        btn_inicio.setOpaque(false);
        btn_inicio.setFont(new Font("Arial", Font.PLAIN, 12));
        btn_inicio.setFocusPainted(false);
        btn_inicio.setContentAreaFilled(false);
        btn_inicio.setBorderPainted(false);
        menu_inicio.add(btn_inicio);

        jMenu2.setText("PACIENTES");
        menu_inicio.add(jMenu2);
        
        jmenuitem_menu_paciente = new JMenuItem("Menu paciente");
        jmenuitem_menu_paciente.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.ALT_DOWN_MASK));
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

        jMenu4.setText("MATERIAL");
        menu_inicio.add(jMenu4);

        jMenu5.setText("CONSULTAS");
        menu_inicio.add(jMenu5);

        jMenu6.setText("FACTURACIÓN");
        menu_inicio.add(jMenu6);

        jMenu7.setText("AJUSTES");
        menu_inicio.add(jMenu7);

        jMenu8.setText("AYUDA");
        menu_inicio.add(jMenu8);

        setJMenuBar(menu_inicio);
        
        combo = new ArrayList<>();
        btn_inicio.setFocusable(true);
        btn_inicio.addKeyListener(new KeyAdapter() {
        	@Override
        	public void keyPressed(KeyEvent e) {
        		combo.add(e.getKeyCode());
        		if(combo.size()>1) {
        			
        			//---ShortCuts para pacientes---
        			if(combo.contains(KeyEvent.VK_1)&&combo.contains(KeyEvent.VK_P)&&combo.contains(16)) {
        				dispose();
        				jf_pacientes ventana = new jf_pacientes();
        				dialogos_pacientes.jd_buscar_paciente ventana_buscar = new dialogos_pacientes.jd_buscar_paciente();
        				ventana.setVisible(true);
        				ventana_buscar.setVisible(true);
        			}
        			if(combo.contains(KeyEvent.VK_2)&&combo.contains(KeyEvent.VK_P)&&combo.contains(16)) {
        				dispose();
        				jf_pacientes ventana = new jf_pacientes();
        				dialogos_pacientes.jd_buscar_paciente_editar ventana_buscar = new dialogos_pacientes.jd_buscar_paciente_editar();
        				ventana.setVisible(true);
        				ventana_buscar.setVisible(true);
        			}
        			if(combo.contains(KeyEvent.VK_3)&&combo.contains(KeyEvent.VK_P)&&combo.contains(16)) {
        				dispose();
        				jf_pacientes ventana = new jf_pacientes();
        				dialogos_pacientes.jd_buscar_paciente_baja ventana_buscar = new dialogos_pacientes.jd_buscar_paciente_baja();
        				ventana.setVisible(true);
        				ventana_buscar.setVisible(true);
        			}
        			if(combo.contains(KeyEvent.VK_4)&&combo.contains(KeyEvent.VK_P)&&combo.contains(16)) {
        				dispose();
        				jf_pacientes ventana = new jf_pacientes();
        				dialogos_pacientes.jd_pacientes_alta ventana_alta = new dialogos_pacientes.jd_pacientes_alta();
        				ventana.setVisible(true);
        				ventana_alta.setVisible(true);
        			}
        			
        			//---ShortCuts para doctores---
        			if(combo.contains(KeyEvent.VK_1)&&combo.contains(KeyEvent.VK_D)&&combo.contains(16)) {
        				dispose();
        				jf_doctores ventana = new jf_doctores();
        				dialogos_doctores.jd_buscar_dr ventana_buscar = new dialogos_doctores.jd_buscar_dr();
        				ventana.setVisible(true);
        				ventana_buscar.setVisible(true);
        			}
        			if(combo.contains(KeyEvent.VK_2)&&combo.contains(KeyEvent.VK_D)&&combo.contains(16)) {
        				dispose();
        				jf_doctores ventana = new jf_doctores();
        				dialogos_doctores.jd_especialidades ventana_buscar = new dialogos_doctores.jd_especialidades();
        				ventana.setVisible(true);
        				ventana_buscar.setVisible(true);
        			}
        			if(combo.contains(KeyEvent.VK_3)&&combo.contains(KeyEvent.VK_D)&&combo.contains(16)) {
        				dispose();
        				jf_doctores ventana = new jf_doctores();
        				dialogos_doctores.jd_buscar_doctor_editar ventana_buscar = new dialogos_doctores.jd_buscar_doctor_editar();
        				ventana.setVisible(true);
        				ventana_buscar.setVisible(true);
        			}
        			if(combo.contains(KeyEvent.VK_4)&&combo.contains(KeyEvent.VK_D)&&combo.contains(16)) {
        				dispose();
        				jf_doctores ventana = new jf_doctores();
        				dialogos_doctores.jd_buscar_doctor_baja ventana_buscar = new dialogos_doctores.jd_buscar_doctor_baja();
        				ventana.setVisible(true);
        				ventana_buscar.setVisible(true);
        			}
        			if(combo.contains(KeyEvent.VK_5)&&combo.contains(KeyEvent.VK_D)&&combo.contains(16)) {
        				dispose();
        				jf_doctores ventana = new jf_doctores();
        				dialogos_doctores.jd_doctores_alta ventana_alta = new dialogos_doctores.jd_doctores_alta();
        				ventana.setVisible(true);
        				ventana_alta.setVisible(true);
        			}
        			
        			//---ShortCuts para material---
        			if(combo.contains(KeyEvent.VK_1)&&combo.contains(KeyEvent.VK_M)&&combo.contains(16)) {
        				dispose();
        				jf_material ventana = new jf_material();
        				//dialogos_material.jd_ ventana_buscar = new dialogos_material.jd_();
        				ventana.setVisible(true);
        				//ventana_buscar.setVisible(true);
        			}
        			if(combo.contains(KeyEvent.VK_2)&&combo.contains(KeyEvent.VK_M)&&combo.contains(16)) {
        				dispose();
        				jf_material ventana = new jf_material();
        				//dialogos_material.jd_ ventana_buscar = new dialogos_material.jd_();
        				ventana.setVisible(true);
        				//ventana_buscar.setVisible(true);
        			}
        			if(combo.contains(KeyEvent.VK_3)&&combo.contains(KeyEvent.VK_M)&&combo.contains(16)) {
        				dispose();
        				jf_material ventana = new jf_material();
        				//dialogos_material.jd_buscar ventana_buscar = new dialogos_material.jd_buscar();
        				ventana.setVisible(true);
        				//ventana_buscar.setVisible(true);
        			}
        			if(combo.contains(KeyEvent.VK_4)&&combo.contains(KeyEvent.VK_M)&&combo.contains(16)) {
        				dispose();
        				jf_material ventana = new jf_material();
        				//dialogos_material.jd_buscar ventana_buscar = new dialogos_material.jd_buscar();
        				ventana.setVisible(true);
        				//ventana_buscar.setVisible(true);
        			}
        			if(combo.contains(KeyEvent.VK_5)&&combo.contains(KeyEvent.VK_M)&&combo.contains(16)) {
        				dispose();
        				jf_material ventana = new jf_material();
        				//dialogos_material.jd_ ventana_buscar = new dialogos_material.jd_();
        				ventana.setVisible(true);
        				//ventana_buscar.setVisible(true);
        			}
        			if(combo.contains(KeyEvent.VK_6)&&combo.contains(KeyEvent.VK_M)&&combo.contains(16)) {
        				dispose();
        				jf_material ventana = new jf_material();
        				//dialogos_material.jd_ ventana_buscar = new dialogos_material.jd_();
        				ventana.setVisible(true);
        				//ventana_buscar.setVisible(true);
        			}
        			
        			//---ShortCuts para consultas---
        			if(combo.contains(KeyEvent.VK_1)&&combo.contains(KeyEvent.VK_C)&&combo.contains(16)) {
        				dispose();
        				jf_consulta ventana = new jf_consulta();
        				//dialogos_consultas.jd_buscar ventana_buscar = new dialogos_consultas.jd_buscar();
        				ventana.setVisible(true);
        				//ventana_buscar.setVisible(true);
        			}
        			if(combo.contains(KeyEvent.VK_2)&&combo.contains(KeyEvent.VK_C)&&combo.contains(16)) {
        				dispose();
        				jf_consulta ventana = new jf_consulta();
        				//dialogos_consultas.jd_buscar ventana_buscar = new dialogos_consultas.jd_buscar_paciente_editar();
        				ventana.setVisible(true);
        				//ventana_buscar.setVisible(true);
        			}
        			if(combo.contains(KeyEvent.VK_3)&&combo.contains(KeyEvent.VK_C)&&combo.contains(16)) {
        				dispose();
        				jf_consulta ventana = new jf_consulta();
        				dialogos_consultas.jd_buscar_consulta_eliminar ventana_buscar = new dialogos_consultas.jd_buscar_consulta_eliminar();
        				ventana.setVisible(true);
        				ventana_buscar.setVisible(true);
        			}
        			if(combo.contains(KeyEvent.VK_4)&&combo.contains(KeyEvent.VK_C)&&combo.contains(16)) {
        				dispose();
        				jf_consulta ventana = new jf_consulta();
        				dialogos_consultas.jd_nueva_consulta ventana_nueva = new dialogos_consultas.jd_nueva_consulta();
        				ventana.setVisible(true);
        				ventana_nueva.setVisible(true);
        			}
        			
        			//---ShortCuts para facturacion---
        			if(combo.contains(KeyEvent.VK_1)&&combo.contains(KeyEvent.VK_F)&&combo.contains(16)) {
        				dispose();
        				jf_facturacion ventana = new jf_facturacion();
        				dialogos_facturas.jd_buscar_factura ventana_buscar = new dialogos_facturas.jd_buscar_factura();
        				ventana.setVisible(true);
        				ventana_buscar.setVisible(true);
        			}
        			if(combo.contains(KeyEvent.VK_2)&&combo.contains(KeyEvent.VK_F)&&combo.contains(16)) {
        				dispose();
        				jf_facturacion ventana = new jf_facturacion();
        				//dialogos_facturacion.jd_buscar ventana_buscar = new dialogos_facturacion.jd_buscar();
        				ventana.setVisible(true);
        				//ventana_buscar.setVisible(true);
        			}
        			if(combo.contains(KeyEvent.VK_3)&&combo.contains(KeyEvent.VK_F)&&combo.contains(16)) {
        				dispose();
        				jf_facturacion ventana = new jf_facturacion();
        				//dialogos_facturacion.jd_buscar ventana_buscar = new dialogos_facturacion.jd_buscar();
        				ventana.setVisible(true);
        				//ventana_buscar.setVisible(true);
        			}
        			if(combo.contains(KeyEvent.VK_4)&&combo.contains(KeyEvent.VK_F)&&combo.contains(16)) {
        				dispose();
        				jf_facturacion ventana = new jf_facturacion();
        				dialogos_facturas.jd_nueva_factura ventana_nueva = new dialogos_facturas.jd_nueva_factura();
        				ventana.setVisible(true);
        				ventana_nueva.setVisible(true);
        			}
        		}
        	}
        });

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
        jp_menu.setLayout(null);
        jp_menu.add(btn_inventario);
        jp_menu.add(btn_solicitudes);
        jp_menu.add(btn_buscar_pedido);
        jp_menu.add(btn_proveedores);
        jp_menu.add(btn_nuevo_pedido);
		
		//Alt + S para ir al inicio
        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.ALT_DOWN_MASK), "clickButton");

            getRootPane().getActionMap().put("clickButton", new AbstractAction() {
                public void actionPerformed(ActionEvent ae) {
                    btn_inicio.doClick(); // Simula el clic del botón
                }
            });

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
                new jf_material().setVisible(true);
            }
        });
    }
    private javax.swing.JButton btn_proveedores;
    private javax.swing.JButton btn_nuevo_pedido;
    private javax.swing.JButton btn_buscar_pedido;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JPanel jp_menu;
    private javax.swing.JMenuBar menu_inicio;
    private JButton btn_inventario;
    private JButton btn_solicitudes;
    private JMenuItem jmenuitem_buscar_paciente;
    private JMenuItem jmenuitem_menu_paciente;
    private JMenuItem jmenuitem_editar_paciente;
    private JMenuItem jmenuitem_alta_paciente;
    private JMenuItem jmenuitem_baja_paciente;
    private JButton btn_inicio;
    // End of variables declaration//GEN-END:variables

}

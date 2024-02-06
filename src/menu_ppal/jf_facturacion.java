package menu_ppal;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.swing.AbstractAction;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.Timer;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.JMenuItem;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Cursor;
import javax.swing.JLabel;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.net.URL;

public class jf_facturacion extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	fondos.Fondo fondo = new fondos.Fondo();
	ArrayList<Integer> combo;
    public jf_facturacion() {
    	setIconImage(Toolkit.getDefaultToolkit().getImage(jf_facturacion.class.getResource("/iconos_menus/dentilaxIcono.png")));
    	setTitle("Gestión de facturación");
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
        jp_menu.setPreferredSize(new Dimension(1450, 750));
        btn_buscar_factura = new javax.swing.JButton();
        btn_buscar_factura.setOpaque(false);
        btn_buscar_factura.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btn_buscar_factura.setContentAreaFilled(false);
        btn_buscar_factura.setIcon(new ImageIcon(jf_facturacion.class.getResource("/iconos_submenus/btn_buscarFactura_admin.png")));
        btn_buscar_factura.setBounds(68, 594, 188, 41);
        btn_buscar_factura.setBorderPainted(false);
        btn_buscar_factura.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dialogos_facturas.jd_buscar_factura ventana = new dialogos_facturas.jd_buscar_factura();
        		ventana.setVisible(true);
        	}
        });
        btn_nueva_factura = new javax.swing.JButton();
        btn_nueva_factura.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btn_nueva_factura.setContentAreaFilled(false);
        btn_nueva_factura.setIcon(new ImageIcon(jf_facturacion.class.getResource("/iconos_submenus/btn_nuevaFactura_admin.png")));
        btn_nueva_factura.setOpaque(false);
        btn_nueva_factura.setBounds(1209, 594, 188, 41);
        btn_nueva_factura.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dialogos_facturas.jd_nueva_factura ventana = new dialogos_facturas.jd_nueva_factura();
        		ventana.setVisible(true);
        	}
        });
        btn_nueva_factura.setBorderPainted(false);
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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
        
        JMenuItem jmenu_paciente = new JMenuItem("Menu paciente");
        jmenu_paciente.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		jf_pacientes ventana = new jf_pacientes();
        		dispose();
        		ventana.setVisible(true);
        	}
        });
        jmenu_paciente.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.ALT_DOWN_MASK));
        jmenu_paciente.setFont(new Font("Arial", Font.PLAIN, 12));
        jMenu2.add(jmenu_paciente);
        
        JMenuItem jmenuitem_buscar_paciente = new JMenuItem("Buscar paciente");
        jmenuitem_buscar_paciente.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        		jf_pacientes ventana = new jf_pacientes();
        		dialogos_pacientes.jd_buscar_paciente ventana_buscar = new dialogos_pacientes.jd_buscar_paciente();
        		ventana.setVisible(true);
        		ventana_buscar.setVisible(true);
        	}
        });
        jmenuitem_buscar_paciente.setFont(new Font("Arial", Font.PLAIN, 12));
        jMenu2.add(jmenuitem_buscar_paciente);
        
        JMenuItem jmenuitem_editar_paciente = new JMenuItem("Editar paciente");
        jmenuitem_editar_paciente.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        		jf_pacientes ventana = new jf_pacientes();
        		dialogos_pacientes.jd_buscar_paciente_editar ventana_buscar = new dialogos_pacientes.jd_buscar_paciente_editar();
        		ventana.setVisible(true);
        		ventana_buscar.setVisible(true);
        	}
        });
        jmenuitem_editar_paciente.setFont(new Font("Arial", Font.PLAIN, 12));
        jMenu2.add(jmenuitem_editar_paciente);
        
        JMenuItem jmenuitem_baja_paciente = new JMenuItem("Dar de baja");
        jmenuitem_baja_paciente.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
				jf_pacientes ventana = new jf_pacientes();
				dialogos_pacientes.jd_buscar_paciente_baja ventana_buscar = new dialogos_pacientes.jd_buscar_paciente_baja();
				ventana.setVisible(true);
				ventana_buscar.setVisible(true);
        	}
        });
        jmenuitem_baja_paciente.setFont(new Font("Arial", Font.PLAIN, 12));
        jMenu2.add(jmenuitem_baja_paciente);
        
        JMenuItem jmenuitem_alta_paciente = new JMenuItem("Dar de alta");
        jmenuitem_alta_paciente.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
				jf_pacientes ventana = new jf_pacientes();
				dialogos_pacientes.jd_pacientes_alta ventana_alta = new dialogos_pacientes.jd_pacientes_alta();
				ventana.setVisible(true);
				ventana_alta.setVisible(true);
        	}
        });
        jmenuitem_alta_paciente.setFont(new Font("Arial", Font.PLAIN, 12));
        jMenu2.add(jmenuitem_alta_paciente);

        jMenu3.setText("DOCTORES");
        menu_inicio.add(jMenu3);
        
        JMenuItem jmenuitem_menu_doctores = new JMenuItem("Menu doctor");
        jmenuitem_menu_doctores.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        		jf_doctores ventana = new jf_doctores();
        		ventana.setVisible(true);
        	}
        });
        jmenuitem_menu_doctores.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.ALT_DOWN_MASK));
        jmenuitem_menu_doctores.setFont(new Font("Arial", Font.PLAIN, 12));
        jMenu3.add(jmenuitem_menu_doctores);
        
        JMenuItem jmenuitem_buscar_doctores = new JMenuItem("Buscar doctor");
        jmenuitem_buscar_doctores.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        		jf_doctores ventana = new jf_doctores();
        		dialogos_doctores.jd_buscar_doctor ventana_buscar = new dialogos_doctores.jd_buscar_doctor();
        		ventana.setVisible(true);
        		ventana_buscar.setVisible(true);
        	}
        });
        jmenuitem_buscar_doctores.setFont(new Font("Arial", Font.PLAIN, 12));
        jMenu3.add(jmenuitem_buscar_doctores);
        
        JMenuItem jmenuitem_especialidad_doctores = new JMenuItem("Especialidad");
        jmenuitem_especialidad_doctores.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        		jf_doctores ventana = new jf_doctores();
        		dialogos_doctores.jd_especialidades ventana_especialidad = new dialogos_doctores.jd_especialidades();
        		ventana.setVisible(true);
        		ventana_especialidad.setVisible(true);
        	}
        });
        jmenuitem_especialidad_doctores.setFont(new Font("Arial", Font.PLAIN, 12));
        jMenu3.add(jmenuitem_especialidad_doctores);
        
        JMenuItem jmenuitem_editar_doctor = new JMenuItem("Editar doctor");
        jmenuitem_editar_doctor.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        		jf_doctores ventana = new jf_doctores();
        		dialogos_doctores.jd_buscar_doctor_editar ventana_buscar = new dialogos_doctores.jd_buscar_doctor_editar();
        		ventana.setVisible(true);
        		ventana_buscar.setVisible(true);
        	}
        });
        jmenuitem_editar_doctor.setFont(new Font("Arial", Font.PLAIN, 12));
        jMenu3.add(jmenuitem_editar_doctor);
        
        JMenuItem jmenuitem_baja_doctores = new JMenuItem("Dar de baja");
        jmenuitem_baja_doctores.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        		jf_doctores ventana = new jf_doctores();
        		dialogos_doctores.jd_buscar_doctor_baja ventana_alta = new dialogos_doctores.jd_buscar_doctor_baja();
        		ventana.setVisible(true);
        		ventana_alta.setVisible(true);
        	}
        });
        jmenuitem_baja_doctores.setFont(new Font("Arial", Font.PLAIN, 12));
        jMenu3.add(jmenuitem_baja_doctores);
        
        JMenuItem jmenuitem_alta_doctores = new JMenuItem("Dar de alta");
        jmenuitem_alta_doctores.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        		jf_doctores ventana = new jf_doctores();
        		dialogos_doctores.jd_doctores_alta ventana_alta = new dialogos_doctores.jd_doctores_alta();
        		ventana.setVisible(true);
        		ventana_alta.setVisible(true);
        	}
        });
        jmenuitem_alta_doctores.setFont(new Font("Arial", Font.PLAIN, 12));
        jMenu3.add(jmenuitem_alta_doctores);

        jMenu4.setText("MATERIAL");
        menu_inicio.add(jMenu4);
        
        JMenuItem jmenuitem_menu_material = new JMenuItem("Menu material");
        jmenuitem_menu_material.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        		jf_material ventana = new jf_material();
        		ventana.setVisible(true);
        	}
        });
        jmenuitem_menu_material.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, InputEvent.ALT_DOWN_MASK));
        jmenuitem_menu_material.setFont(new Font("Arial", Font.PLAIN, 12));
        jMenu4.add(jmenuitem_menu_material);
        
        JMenuItem jmenuitem_buscar_pedido = new JMenuItem("Buscar pedido");
        jmenuitem_buscar_pedido.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        		jf_material ventana_p = new jf_material();
        		dialogos_materiales.jd_buscar_pedidos ventana = new dialogos_materiales.jd_buscar_pedidos();
        		ventana_p.setVisible(true);
        		ventana.setVisible(true);
        	}
        });
        jmenuitem_buscar_pedido.setFont(new Font("Arial", Font.PLAIN, 12));
        jMenu4.add(jmenuitem_buscar_pedido);
        
        JMenuItem jmenuitem_proveedores = new JMenuItem("Proveedores");
        jmenuitem_proveedores.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        		jf_material ventana_p = new jf_material();
        		dialogos_materiales.jd_proveedores ventana = new dialogos_materiales.jd_proveedores();
        		ventana_p.setVisible(true);
        		ventana.setVisible(true);
        	}
        });
        jmenuitem_proveedores.setFont(new Font("Arial", Font.PLAIN, 12));
        jMenu4.add(jmenuitem_proveedores);
        
        JMenuItem jmenuitem_inventario = new JMenuItem("Inventario");
        jmenuitem_inventario.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        		menu_ppal.jf_material ventana_p = new menu_ppal.jf_material();
        		dialogos_materiales.jd_inventario ventana = new dialogos_materiales.jd_inventario();
        		ventana_p.setVisible(true);
        		ventana.setVisible(true);
        	}
        });
        jmenuitem_inventario.setFont(new Font("Arial", Font.PLAIN, 12));
        jMenu4.add(jmenuitem_inventario);
        
        JMenuItem jmenuitem_nuevo_pedido = new JMenuItem("Nuevo pedido");
        jmenuitem_nuevo_pedido.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        		jf_material ventana_p = new jf_material();
        		dialogos_materiales.jd_hacer_pedido pedido = new dialogos_materiales.jd_hacer_pedido();
        		ventana_p.setVisible(true);
        		pedido.setVisible(true);
        	}
        });
        jmenuitem_nuevo_pedido.setFont(new Font("Arial", Font.PLAIN, 12));
        jMenu4.add(jmenuitem_nuevo_pedido);
        
        JMenuItem jmenuitem_solicitudes = new JMenuItem("Solicitudes");
        jmenuitem_solicitudes.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        		jf_material ventana_p = new jf_material();
        		dialogos_materiales.jd_revisar_solicitud ventana = new dialogos_materiales.jd_revisar_solicitud();
        		ventana_p.setVisible(true);
        		ventana.setVisible(true);
        	}
        });
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
        jmenuitem_menu_consulta.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.ALT_DOWN_MASK));
        jMenu5.add(jmenuitem_menu_consulta);
        
        JMenuItem jmenuitem_buscar_cita = new JMenuItem("Buscar cita");
        jmenuitem_buscar_cita.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        		jf_consulta ventana = new jf_consulta();
        		dialogos_consultas.jd_buscar_cita ventana_buscar = new dialogos_consultas.jd_buscar_cita();
        		ventana.setVisible(true);
        		ventana_buscar.setVisible(true);
        	}
        });
        jmenuitem_buscar_cita.setFont(new Font("Arial", Font.PLAIN, 12));
        jMenu5.add(jmenuitem_buscar_cita);
        
        JMenuItem jmenuitem_historial = new JMenuItem("Historial");
        jmenuitem_historial.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        		jf_consulta ventana = new jf_consulta();
        		dialogos_consultas.jd_historial_cita ventana_historial = new dialogos_consultas.jd_historial_cita();
        		ventana.setVisible(true);
        		ventana_historial.setVisible(true);
        	}
        });
        jmenuitem_historial.setFont(new Font("Arial", Font.PLAIN, 12));
        jMenu5.add(jmenuitem_historial);
        
        JMenuItem jmenuitem_eliminar_cita = new JMenuItem("Eliminar cita");
        jmenuitem_eliminar_cita.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        		jf_consulta ventana = new jf_consulta();
        		dialogos_consultas.jd_buscar_consulta_eliminar ventana_historial = new dialogos_consultas.jd_buscar_consulta_eliminar();
        		ventana.setVisible(true);
        		ventana_historial.setVisible(true);
        	}
        });
        jmenuitem_eliminar_cita.setFont(new Font("Arial", Font.PLAIN, 12));
        jMenu5.add(jmenuitem_eliminar_cita);
        
        JMenuItem jmenuitem_nueva_cita = new JMenuItem("Nueva cita");
        jmenuitem_nueva_cita.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        		jf_consulta ventana = new jf_consulta();
        		dialogos_consultas.jd_nueva_consulta ventana_historial = new dialogos_consultas.jd_nueva_consulta();
        		ventana.setVisible(true);
        		ventana_historial.setVisible(true);
        	}
        });
        
        JMenuItem jmenuitem_modificar_cita = new JMenuItem("Modificar cita");
        jmenuitem_modificar_cita.setFont(new Font("Arial", Font.PLAIN, 12));
        jMenu5.add(jmenuitem_modificar_cita);
        jmenuitem_modificar_cita.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        		jf_consulta ventana = new jf_consulta();
        		dialogos_consultas.jd_buscar_consulta_editar ventana_historial = new dialogos_consultas.jd_buscar_consulta_editar();
        		ventana.setVisible(true);
        		ventana_historial.setVisible(true);
        	}
        });
        jmenuitem_nueva_cita.setFont(new Font("Arial", Font.PLAIN, 12));
        jMenu5.add(jmenuitem_nueva_cita);

        jMenu6.setText("FACTURACIÓN");
        menu_inicio.add(jMenu6);
        
        JMenuItem jmenuitem_menu_facturacion = new JMenuItem("Menu facturacion");
        jmenuitem_menu_facturacion.setFont(new Font("Arial", Font.PLAIN, 12));
        jmenuitem_menu_facturacion.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, InputEvent.ALT_DOWN_MASK));
        jMenu6.add(jmenuitem_menu_facturacion);
        
        JMenuItem jmenuitem_buscar_factura = new JMenuItem("Buscar factura");
        jmenuitem_buscar_factura.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        		jf_facturacion ventana = new jf_facturacion();
        		dialogos_facturas.jd_buscar_factura ventana_buscar = new dialogos_facturas.jd_buscar_factura();
        		ventana.setVisible(true);
        		ventana_buscar.setVisible(true);
        	}
        });
        jmenuitem_buscar_factura.setFont(new Font("Arial", Font.PLAIN, 12));
        jMenu6.add(jmenuitem_buscar_factura);
        
        JMenuItem jmenuitem_nueva_factura = new JMenuItem("Nueva factura");
        jmenuitem_nueva_factura.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        		jf_facturacion ventana = new jf_facturacion();
        		dialogos_facturas.jd_nueva_factura ventana_nueva = new dialogos_facturas.jd_nueva_factura();
        		ventana.setVisible(true);
        		ventana_nueva.setVisible(true);
        	}
        });
        jmenuitem_nueva_factura.setFont(new Font("Arial", Font.PLAIN, 12));
        jMenu6.add(jmenuitem_nueva_factura);

        jMenu7.setText("AJUSTES");
        menu_inicio.add(jMenu7);
        

        setJMenuBar(menu_inicio);
        
        combo = new ArrayList<>();
        btn_inicio.setFocusable(true);
        
        JButton btn_ayuda = new JButton("AYUDA");
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
        				dialogos_doctores.jd_buscar_doctor ventana_buscar = new dialogos_doctores.jd_buscar_doctor();
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
        				jf_material ventana_p = new jf_material();
        				dialogos_materiales.jd_buscar_pedidos ventana = new dialogos_materiales.jd_buscar_pedidos();
        				ventana_p.setVisible(true);
        				ventana.setVisible(true);
        			}
        			if(combo.contains(KeyEvent.VK_2)&&combo.contains(KeyEvent.VK_M)&&combo.contains(16)) {
        				dispose();
        				jf_material ventana_p = new jf_material();
        				dialogos_materiales.jd_proveedores ventana = new dialogos_materiales.jd_proveedores();
        				ventana_p.setVisible(true);
        				ventana.setVisible(true);
        			}
        			if(combo.contains(KeyEvent.VK_3)&&combo.contains(KeyEvent.VK_M)&&combo.contains(16)) {
        				dispose();
        				jf_material ventana_p = new jf_material();
        				dialogos_materiales.jd_inventario ventana = new dialogos_materiales.jd_inventario();
        				ventana_p.setVisible(true);
        				ventana.setVisible(true);
        			}
        			if(combo.contains(KeyEvent.VK_4)&&combo.contains(KeyEvent.VK_M)&&combo.contains(16)) {
        				dispose();
        				jf_material ventana_p = new jf_material();
                		dialogos_materiales.jd_hacer_pedido ventana = new dialogos_materiales.jd_hacer_pedido();
        				ventana_p.setVisible(true);
        				ventana.setVisible(true);
        			}
        			if(combo.contains(KeyEvent.VK_5)&&combo.contains(KeyEvent.VK_M)&&combo.contains(16)) {
        				dispose();
        				jf_material ventana_p = new jf_material();
                		dialogos_materiales.jd_revisar_solicitud ventana = new dialogos_materiales.jd_revisar_solicitud();
        				ventana_p.setVisible(true);
        				ventana.setVisible(true);
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
        				ventana.setVisible(true);
        			}
        			if(combo.contains(KeyEvent.VK_2)&&combo.contains(KeyEvent.VK_F)&&combo.contains(16)) {
        				dispose();
                		jf_facturacion ventana = new jf_facturacion();
                		dialogos_facturas.jd_buscar_factura ventana_buscar = new dialogos_facturas.jd_buscar_factura();
                		ventana.setVisible(true);
                		ventana_buscar.setVisible(true);
        			}
        			if(combo.contains(KeyEvent.VK_3)&&combo.contains(KeyEvent.VK_F)&&combo.contains(16)) {
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
        
        popupMenu = new JPopupMenu();
        addPopup(jp_menu, popupMenu);
        
        mntmNewMenuItem = new JMenuItem("Menu facturacion");
        mntmNewMenuItem.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        		jf_facturacion ventana = new jf_facturacion();
        		ventana.setVisible(true);
        	}
        });
        popupMenu.add(mntmNewMenuItem);
        
        mntmNewMenuItem_1 = new JMenuItem("Buscar factura");
        mntmNewMenuItem_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        		jf_facturacion ventana = new jf_facturacion();
        		dialogos_facturas.jd_buscar_factura ventana_buscar = new dialogos_facturas.jd_buscar_factura();
        		ventana.setVisible(true);
        		ventana_buscar.setVisible(true);
        	}
        });
        popupMenu.add(mntmNewMenuItem_1);
        
        mntmNewMenuItem_4 = new JMenuItem("Nueva factura");
        mntmNewMenuItem_4.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        		jf_facturacion ventana = new jf_facturacion();
        		dialogos_facturas.jd_nueva_factura ventana_nueva = new dialogos_facturas.jd_nueva_factura();
        		ventana.setVisible(true);
        		ventana_nueva.setVisible(true);
        	}
        });
        popupMenu.add(mntmNewMenuItem_4);
        jp_menu.add(btn_buscar_factura);
        jp_menu.add(btn_nueva_factura);
        
        fecha = new JLabel("");
        fecha.setBackground(Color.WHITE);
        fecha.setFont(new Font("Barlow", Font.PLAIN, 25));
        fecha.setBounds(1184, 642, 240, 23);
        jp_menu.add(fecha);
        
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
                new jf_facturacion().setVisible(true);
            }
        });
    }
    private javax.swing.JButton btn_nueva_factura;
    private javax.swing.JButton btn_buscar_factura;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JPanel jp_menu;
    private javax.swing.JMenuBar menu_inicio;
    private JButton btn_inicio;
    private JLabel fecha;
    private JPopupMenu popupMenu;
    private JMenuItem mntmNewMenuItem;
    private JMenuItem mntmNewMenuItem_1;
    private JMenuItem mntmNewMenuItem_4;
    // End of variables declaration//GEN-END:variables

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}

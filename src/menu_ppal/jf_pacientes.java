package menu_ppal;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.AbstractAction;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.Toolkit;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyAdapter;

import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class jf_pacientes extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenu mn_doctores;

	/**
	 * Launch the application.
	 */
	fondos.Fondo fondo = new fondos.Fondo();
	ArrayList<Integer> combo;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					jf_pacientes frame = new jf_pacientes();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public jf_pacientes() {
		setTitle("Gestión de pacientes");
		setIconImage(Toolkit.getDefaultToolkit().getImage(jf_pacientes.class.getResource("/iconos_menus/dentilaxIcono.png")));
		setPreferredSize(new Dimension(1450, 750));
		setSize(new Dimension(1450, 750));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1450, 750);
		setLocationRelativeTo(this);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorderPainted(false);
		menuBar.setBackground(new Color(32, 160, 216));
		setJMenuBar(menuBar);
		
		JButton btn_inicio = new JButton("INICIO");
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
		menuBar.add(btn_inicio);
		
		JMenu mn_pacientes = new JMenu("PACIENTES");
		mn_pacientes.setFont(new Font("Arial", Font.PLAIN, 12));
		menuBar.add(mn_pacientes);
		
		JMenuItem jmenuitem_menu_paciente = new JMenuItem("Menu paciente");
		jmenuitem_menu_paciente.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.ALT_DOWN_MASK));
		jmenuitem_menu_paciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				jf_pacientes ventana = new jf_pacientes();
				ventana.setVisible(true);
			}
		});
		jmenuitem_menu_paciente.setFont(new Font("Arial", Font.PLAIN, 12));
		mn_pacientes.add(jmenuitem_menu_paciente);
		
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
		mn_pacientes.add(jmenuitem_buscar_paciente);
		
		JMenuItem jmenuitem_editar_paciente = new JMenuItem("Editar paciente");
		jmenuitem_editar_paciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				jf_pacientes ventana = new jf_pacientes();
				dialogos_pacientes.jd_buscar_paciente_editar ventana_editar = new dialogos_pacientes.jd_buscar_paciente_editar();
				ventana.setVisible(true);
				ventana_editar.setVisible(true);
			}
		});
		jmenuitem_editar_paciente.setFont(new Font("Arial", Font.PLAIN, 12));
		mn_pacientes.add(jmenuitem_editar_paciente);
		
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
		mn_pacientes.add(jmenuitem_baja_paciente);
		
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
		mn_pacientes.add(jmenuitem_alta_paciente);
		
		mn_doctores = new JMenu("DOCTORES");
		mn_doctores.setFont(new Font("Arial", Font.PLAIN, 12));
		menuBar.add(mn_doctores);
		
		JMenuItem jmenuitem_menu_doctor = new JMenuItem("Menu doctor");
		jmenuitem_menu_doctor.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.ALT_DOWN_MASK));
		jmenuitem_menu_doctor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				jf_doctores ventana = new jf_doctores();
				ventana.setVisible(true);
			}
		});
		jmenuitem_menu_doctor.setFont(new Font("Arial", Font.PLAIN, 12));
		mn_doctores.add(jmenuitem_menu_doctor);
		
		JMenuItem jmenuitem_buscar_doctor = new JMenuItem("Buscar doctor");
		jmenuitem_buscar_doctor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				jf_doctores ventana = new jf_doctores();
				dialogos_doctores.jd_buscar_doctor ventana_buscar = new dialogos_doctores.jd_buscar_doctor();
				ventana.setVisible(true);
				ventana_buscar.setVisible(true);
			}
		});
		jmenuitem_buscar_doctor.setFont(new Font("Arial", Font.PLAIN, 12));
		mn_doctores.add(jmenuitem_buscar_doctor);
		
		JMenuItem jmenuitem_especialidad_doctor = new JMenuItem("Especialidad");
		jmenuitem_especialidad_doctor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
        		jf_doctores ventana = new jf_doctores();
        		dialogos_doctores.jd_especialidades ventana_especialidad = new dialogos_doctores.jd_especialidades();
        		ventana.setVisible(true);
        		ventana_especialidad.setVisible(true);
			}
		});
		jmenuitem_especialidad_doctor.setFont(new Font("Arial", Font.PLAIN, 12));
		mn_doctores.add(jmenuitem_especialidad_doctor);
		
		JMenuItem jmenuitem_baja_doctor = new JMenuItem("Dar de baja");
		jmenuitem_baja_doctor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
        		jf_doctores ventana = new jf_doctores();
        		dialogos_doctores.jd_buscar_doctor_baja ventana_baja = new dialogos_doctores.jd_buscar_doctor_baja();
        		ventana.setVisible(true);
        		ventana_baja.setVisible(true);
			}
		});
		
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
		mn_doctores.add(jmenuitem_editar_doctor);
		jmenuitem_baja_doctor.setFont(new Font("Arial", Font.PLAIN, 12));
		mn_doctores.add(jmenuitem_baja_doctor);
		
		JMenuItem jmenuitem_alta_doctor = new JMenuItem("Dar de alta");
		jmenuitem_alta_doctor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
        		jf_doctores ventana = new jf_doctores();
        		dialogos_doctores.jd_doctores_alta ventana_alta = new dialogos_doctores.jd_doctores_alta();
        		ventana.setVisible(true);
        		ventana_alta.setVisible(true);
			}
		});
		jmenuitem_alta_doctor.setFont(new Font("Arial", Font.PLAIN, 12));
		mn_doctores.add(jmenuitem_alta_doctor);
		
		JMenu mn_material = new JMenu("MATERIAL");
		mn_material.setFont(new Font("Arial", Font.PLAIN, 12));
		menuBar.add(mn_material);
		
		JMenuItem jmenuitem_menu_material = new JMenuItem("Menu material");
		jmenuitem_menu_material.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, InputEvent.ALT_DOWN_MASK));
		jmenuitem_menu_material.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
        		jf_material ventana = new jf_material();
        		ventana.setVisible(true);
			}
		});
		jmenuitem_menu_material.setFont(new Font("Arial", Font.PLAIN, 12));
		mn_material.add(jmenuitem_menu_material);
		
		JMenuItem jmenuitem_buscar_pedido = new JMenuItem("Buscar pedido");
		jmenuitem_buscar_pedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
        		dispose();
        		jf_material ventana_p = new jf_material();
        		dialogos_materiales.jd_buscar_pedido ventana = new dialogos_materiales.jd_buscar_pedido();
        		ventana_p.setVisible(true);
        		ventana.setVisible(true);
			}
		});
		jmenuitem_buscar_pedido.setFont(new Font("Arial", Font.PLAIN, 12));
		mn_material.add(jmenuitem_buscar_pedido);
		
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
		mn_material.add(jmenuitem_proveedores);
		
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
		mn_material.add(jmenuitem_inventario);
		
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
		mn_material.add(jmenuitem_nuevo_pedido);
		
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
		mn_material.add(jmenuitem_solicitudes);
		
		JMenu mn_consultas = new JMenu("CONSULTAS");
		mn_consultas.setFont(new Font("Arial", Font.PLAIN, 12));
		menuBar.add(mn_consultas);
		
		JMenuItem jmenuitem_menu_consulta = new JMenuItem("Menu consulta");
		jmenuitem_menu_consulta.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.ALT_DOWN_MASK));
		jmenuitem_menu_consulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
        		jf_consulta ventana = new jf_consulta();
        		ventana.setVisible(true);
			}
		});
		jmenuitem_menu_consulta.setFont(new Font("Arial", Font.PLAIN, 12));
		mn_consultas.add(jmenuitem_menu_consulta);
		
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
		mn_consultas.add(jmenuitem_buscar_cita);
		
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
		mn_consultas.add(jmenuitem_historial);
		
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
		mn_consultas.add(jmenuitem_eliminar_cita);
		
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
		jmenuitem_nueva_cita.setFont(new Font("Arial", Font.PLAIN, 12));
		mn_consultas.add(jmenuitem_nueva_cita);
		
		JMenu mn_facturacion = new JMenu("FACTURACIÓN");
		mn_facturacion.setFont(new Font("Arial", Font.PLAIN, 12));
		menuBar.add(mn_facturacion);
		
		JMenuItem jmenuitem_menu_facturacion = new JMenuItem("Menu facturacion");
		jmenuitem_menu_facturacion.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, InputEvent.ALT_DOWN_MASK));
		jmenuitem_menu_facturacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
        		jf_facturacion ventana = new jf_facturacion();
        		ventana.setVisible(true);
			}
		});
		jmenuitem_menu_facturacion.setFont(new Font("Arial", Font.PLAIN, 12));
		mn_facturacion.add(jmenuitem_menu_facturacion);
		
		JMenuItem jmenuitem_buscar_factura = new JMenuItem("Buscar factura");
		jmenuitem_buscar_factura.setFont(new Font("Arial", Font.PLAIN, 12));
		mn_facturacion.add(jmenuitem_buscar_factura);
		
		JMenuItem jmenuitem_historial_pago = new JMenuItem("Historial de pago");
		jmenuitem_historial_pago.setFont(new Font("Arial", Font.PLAIN, 12));
		mn_facturacion.add(jmenuitem_historial_pago);
		
		JMenuItem jmenuitem_balance_gastos = new JMenuItem("Balance de gastos");
		jmenuitem_balance_gastos.setFont(new Font("Arial", Font.PLAIN, 12));
		mn_facturacion.add(jmenuitem_balance_gastos);
		
		JMenuItem jmenuitem_nueva_factura = new JMenuItem("Nueva factura");
		jmenuitem_nueva_factura.setFont(new Font("Arial", Font.PLAIN, 12));
		mn_facturacion.add(jmenuitem_nueva_factura);
		
		JMenu mn_ajustes = new JMenu("AJUSTES");
		mn_ajustes.setFont(new Font("Arial", Font.PLAIN, 12));
		menuBar.add(mn_ajustes);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btn_buscar_paciente = new JButton("");
		btn_buscar_paciente.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_buscar_paciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dialogos_pacientes.jd_buscar_paciente ventana = new dialogos_pacientes.jd_buscar_paciente();
				ventana.setVisible(true);
			}
		});
		btn_buscar_paciente.setBorder(null);
		btn_buscar_paciente.setBorderPainted(false);
		btn_buscar_paciente.setContentAreaFilled(false);
		btn_buscar_paciente.setOpaque(false);
		btn_buscar_paciente.setIcon(new ImageIcon(jf_pacientes.class.getResource("/iconos_submenus/btn_buscarPaciente_admin.png")));
		btn_buscar_paciente.setBounds(68, 590, 188, 41);
		contentPane.add(btn_buscar_paciente);
		
		JButton btn_baja_paciente = new JButton("");
		btn_baja_paciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dialogos_pacientes.jd_buscar_paciente_baja ventana = new dialogos_pacientes.jd_buscar_paciente_baja();
				ventana.setVisible(true);
			}
		});
		btn_baja_paciente.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_baja_paciente.setOpaque(false);
		btn_baja_paciente.setIcon(new ImageIcon(jf_pacientes.class.getResource("/iconos_submenus/btn_darDeBaja_admin.png")));
		btn_baja_paciente.setBorder(null);
		btn_baja_paciente.setContentAreaFilled(false);
		btn_baja_paciente.setBorderPainted(false);
		btn_baja_paciente.setBounds(863, 590, 188, 41);
		contentPane.add(btn_baja_paciente);
		
		JButton btn_alta_paciente = new JButton("");
		btn_alta_paciente.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_alta_paciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dialogos_pacientes.jd_pacientes_alta ventana = new dialogos_pacientes.jd_pacientes_alta();
				ventana.setVisible(true);
			}
		});
		btn_alta_paciente.setOpaque(false);
		btn_alta_paciente.setIcon(new ImageIcon(jf_pacientes.class.getResource("/iconos_submenus/btn_darAlta_admin.png")));
		btn_alta_paciente.setBorder(null);
		btn_alta_paciente.setBorderPainted(false);
		btn_alta_paciente.setContentAreaFilled(false);
		btn_alta_paciente.setBounds(1183, 590, 188, 41);
		contentPane.add(btn_alta_paciente);
		
		JButton btn_editar_paciente = new JButton("");
		btn_editar_paciente.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_editar_paciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dialogos_pacientes.jd_buscar_paciente_editar ventana = new dialogos_pacientes.jd_buscar_paciente_editar();
				ventana.setVisible(true);
			}
		});
		btn_editar_paciente.setIcon(new ImageIcon(jf_pacientes.class.getResource("/iconos_submenus/btn_editarPaciente_admin.png")));
		btn_editar_paciente.setContentAreaFilled(false);
		btn_editar_paciente.setBorder(null);
		btn_editar_paciente.setBorderPainted(false);
		btn_editar_paciente.setOpaque(false);
		btn_editar_paciente.setBounds(400, 590, 188, 41);
		contentPane.add(btn_editar_paciente);
		
		
		fondos.Fondo jp_menu = new fondos.Fondo();
		jp_menu.setPreferredSize(new Dimension(1450, 750));
		jp_menu.setBounds(0, 0, 1450, 726);
		contentPane.add(jp_menu);
		
		JLabel fecha = new JLabel("");
		
        fecha.setBackground(Color.WHITE);
        fecha.setFont(new Font("Barlow", Font.PLAIN, 25));
        fecha.setBounds(1184, 642, 240, 23);
        jp_menu.add(fecha);
        
        combo = new ArrayList<>();
        btn_inicio.setFocusable(true);
        
        JButton btn_ayuda = new JButton("AYUDA");
        btn_ayuda.setOpaque(false);
        btn_ayuda.setFont(new Font("Arial", Font.PLAIN, 12));
        btn_ayuda.setFocusable(true);
        btn_ayuda.setFocusPainted(false);
        btn_ayuda.setContentAreaFilled(false);
        btn_ayuda.setBorderPainted(false);
        menuBar.add(btn_ayuda);
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
        				dialogos_materiales.jd_buscar_pedido ventana = new dialogos_materiales.jd_buscar_pedido();
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
                		dialogos_consultas.jd_buscar_cita ventana_buscar = new dialogos_consultas.jd_buscar_cita();
                		ventana.setVisible(true);
                		ventana_buscar.setVisible(true);
        			}
        			if(combo.contains(KeyEvent.VK_2)&&combo.contains(KeyEvent.VK_C)&&combo.contains(16)) {
        				dispose();
                		jf_consulta ventana = new jf_consulta();
                		dialogos_consultas.jd_historial_cita ventana_historial = new dialogos_consultas.jd_historial_cita();
                		ventana.setVisible(true);
                		ventana_historial.setVisible(true);
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
		GroupLayout gl_jp_menu = new GroupLayout(jp_menu);
		
		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(jp_menu, popupMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Menu paciente");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				jf_pacientes ventana = new jf_pacientes();
				ventana.setVisible(true);
			}
		});
		popupMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Buscar paciente");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
        		jf_pacientes ventana = new jf_pacientes();
        		dialogos_pacientes.jd_buscar_paciente ventana_buscar = new dialogos_pacientes.jd_buscar_paciente();
        		ventana.setVisible(true);
        		ventana_buscar.setVisible(true);
        	}
        });
		popupMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Editar paciente");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
        		jf_pacientes ventana = new jf_pacientes();
        		dialogos_pacientes.jd_buscar_paciente_editar ventana_buscar = new dialogos_pacientes.jd_buscar_paciente_editar();
        		ventana.setVisible(true);
        		ventana_buscar.setVisible(true);
        	}
        });
		popupMenu.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Dar de baja");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				jf_pacientes ventana = new jf_pacientes();
				dialogos_pacientes.jd_buscar_paciente_baja ventana_buscar = new dialogos_pacientes.jd_buscar_paciente_baja();
				ventana.setVisible(true);
				ventana_buscar.setVisible(true);
			}
		});
		popupMenu.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Dar de alta");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				jf_pacientes ventana = new jf_pacientes();
				dialogos_pacientes.jd_pacientes_alta ventana_alta = new dialogos_pacientes.jd_pacientes_alta();
				ventana.setVisible(true);
				ventana_alta.setVisible(true);
			}
		});
		popupMenu.add(mntmNewMenuItem_4);
		gl_jp_menu.setHorizontalGroup(
			gl_jp_menu.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_jp_menu.createSequentialGroup()
					.addContainerGap(1373, Short.MAX_VALUE)
					.addComponent(fecha)
					.addGap(31))
		);
		gl_jp_menu.setVerticalGroup(
			gl_jp_menu.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_jp_menu.createSequentialGroup()
					.addContainerGap(666, Short.MAX_VALUE)
					.addComponent(fecha)
					.addGap(46))
		);
		jp_menu.setLayout(gl_jp_menu);
		
		//Alt + S para ir al inicio
        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.ALT_DOWN_MASK), "clickButton");

            getRootPane().getActionMap().put("clickButton", new AbstractAction() {
                public void actionPerformed(ActionEvent ae) {
                    btn_inicio.doClick(); // Simula el clic del botón
                }
            });
	}
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

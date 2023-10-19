import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import java.awt.Font;

public class jf_pacientes extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenu mn_doctores;

	/**
	 * Launch the application.
	 */
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
	Fondo fondo = new Fondo();
	public jf_pacientes() {
		setPreferredSize(new Dimension(1450, 750));
		setSize(new Dimension(1450, 750));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1450, 750);
		setLocationRelativeTo(this);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorderPainted(false);
		menuBar.setBackground(new Color(32, 160, 216));
		setJMenuBar(menuBar);
		
		JMenu mn_inicio = new JMenu("INICIO");
		mn_inicio.setFont(new Font("Arial", Font.PLAIN, 12));
		menuBar.add(mn_inicio);
		
		JMenuItem jmenuitem_volver = new JMenuItem("Volver");
		jmenuitem_volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
        		jf_menu_ppal ventana = new jf_menu_ppal();
        		ventana.setVisible(true);
			}
		});
		jmenuitem_volver.setFont(new Font("Arial", Font.PLAIN, 12));
		mn_inicio.add(jmenuitem_volver);
		
		JMenu mn_pacientes = new JMenu("PACIENTES");
		mn_pacientes.setFont(new Font("Arial", Font.PLAIN, 12));
		menuBar.add(mn_pacientes);
		
		JMenuItem jmenuitem_menu_paciente = new JMenuItem("Menu paciente");
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
		jmenuitem_buscar_paciente.setFont(new Font("Arial", Font.PLAIN, 12));
		mn_pacientes.add(jmenuitem_buscar_paciente);
		
		JMenuItem jmenuitem_editar_paciente = new JMenuItem("Editar paciente");
		jmenuitem_editar_paciente.setFont(new Font("Arial", Font.PLAIN, 12));
		mn_pacientes.add(jmenuitem_editar_paciente);
		
		JMenuItem jmenuitem_baja_paciente = new JMenuItem("Dar de baja");
		jmenuitem_baja_paciente.setFont(new Font("Arial", Font.PLAIN, 12));
		mn_pacientes.add(jmenuitem_baja_paciente);
		
		JMenuItem jmenuitem_alta_paciente = new JMenuItem("Dar de alta");
		jmenuitem_alta_paciente.setFont(new Font("Arial", Font.PLAIN, 12));
		mn_pacientes.add(jmenuitem_alta_paciente);
		
		mn_doctores = new JMenu("DOCTORES");
		mn_doctores.setFont(new Font("Arial", Font.PLAIN, 12));
		menuBar.add(mn_doctores);
		
		JMenuItem jmenuitem_menu_doctor = new JMenuItem("Menu doctor");
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
				jd_buscar_dr ventana_buscar = new jd_buscar_dr();
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
        		jd_especialidades ventana_especialidad = new jd_especialidades();
        		ventana.setVisible(true);
        		ventana_especialidad.setVisible(true);
			}
		});
		jmenuitem_especialidad_doctor.setFont(new Font("Arial", Font.PLAIN, 12));
		mn_doctores.add(jmenuitem_especialidad_doctor);
		
		JMenuItem jmenuitem_baja_doctor = new JMenuItem("Dar de baja");
		jmenuitem_baja_doctor.setFont(new Font("Arial", Font.PLAIN, 12));
		mn_doctores.add(jmenuitem_baja_doctor);
		
		JMenuItem jmenuitem_alta_doctor = new JMenuItem("Dar de alta");
		jmenuitem_alta_doctor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
        		jf_doctores ventana = new jf_doctores();
        		jd_doctores_alta ventana_alta = new jd_doctores_alta();
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
		jmenuitem_buscar_pedido.setFont(new Font("Arial", Font.PLAIN, 12));
		mn_material.add(jmenuitem_buscar_pedido);
		
		JMenuItem jmenuitem_proveedores = new JMenuItem("Proveedores");
		jmenuitem_proveedores.setFont(new Font("Arial", Font.PLAIN, 12));
		mn_material.add(jmenuitem_proveedores);
		
		JMenuItem jmenuitem_cancelar_pedido = new JMenuItem("Cancelar pedido");
		jmenuitem_cancelar_pedido.setFont(new Font("Arial", Font.PLAIN, 12));
		mn_material.add(jmenuitem_cancelar_pedido);
		
		JMenuItem jmenuitem_nuevo_pedido = new JMenuItem("Nuevo pedido");
		jmenuitem_nuevo_pedido.setFont(new Font("Arial", Font.PLAIN, 12));
		mn_material.add(jmenuitem_nuevo_pedido);
		
		JMenuItem jmenuitem_inventario = new JMenuItem("Inventario");
		jmenuitem_inventario.setFont(new Font("Arial", Font.PLAIN, 12));
		mn_material.add(jmenuitem_inventario);
		
		JMenuItem jmenuitem_solicitudes = new JMenuItem("Solicitudes");
		jmenuitem_solicitudes.setFont(new Font("Arial", Font.PLAIN, 12));
		mn_material.add(jmenuitem_solicitudes);
		
		JMenu mn_consultas = new JMenu("CONSULTAS");
		mn_consultas.setFont(new Font("Arial", Font.PLAIN, 12));
		menuBar.add(mn_consultas);
		
		JMenuItem jmenuitem_menu_consulta = new JMenuItem("Menu consulta");
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
		jmenuitem_buscar_cita.setFont(new Font("Arial", Font.PLAIN, 12));
		mn_consultas.add(jmenuitem_buscar_cita);
		
		JMenuItem jmenuitem_historial = new JMenuItem("Historial");
		jmenuitem_historial.setFont(new Font("Arial", Font.PLAIN, 12));
		mn_consultas.add(jmenuitem_historial);
		
		JMenuItem jmenuitem_eliminar_cita = new JMenuItem("Eliminar cita");
		jmenuitem_eliminar_cita.setFont(new Font("Arial", Font.PLAIN, 12));
		mn_consultas.add(jmenuitem_eliminar_cita);
		
		JMenuItem jmenuitem_nueva_cita = new JMenuItem("Nueva cita");
		jmenuitem_nueva_cita.setFont(new Font("Arial", Font.PLAIN, 12));
		mn_consultas.add(jmenuitem_nueva_cita);
		
		JMenu mn_facturacion = new JMenu("FACTURACIÓN");
		mn_facturacion.setFont(new Font("Arial", Font.PLAIN, 12));
		menuBar.add(mn_facturacion);
		
		JMenuItem jmenuitem_menu_facturacion = new JMenuItem("Menu facturacion");
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
		
		JMenu mn_ayuda = new JMenu("AYUDA");
		mn_ayuda.setFont(new Font("Arial", Font.PLAIN, 12));
		menuBar.add(mn_ayuda);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btn_buscar_paciente = new JButton("");
		btn_buscar_paciente.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_buscar_paciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jd_buscar_paciente ventana = new jd_buscar_paciente();
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
		btn_baja_paciente.setOpaque(false);
		btn_baja_paciente.setIcon(new ImageIcon(jf_pacientes.class.getResource("/iconos_submenus/btn_darDeBaja_admin.png")));
		btn_baja_paciente.setBorder(null);
		btn_baja_paciente.setContentAreaFilled(false);
		btn_baja_paciente.setBorderPainted(false);
		btn_baja_paciente.setBounds(863, 590, 188, 41);
		contentPane.add(btn_baja_paciente);
		
		JButton btn_alta_paciente = new JButton("");
		btn_alta_paciente.setOpaque(false);
		btn_alta_paciente.setIcon(new ImageIcon(jf_pacientes.class.getResource("/iconos_submenus/btn_darAlta_admin.png")));
		btn_alta_paciente.setBorder(null);
		btn_alta_paciente.setBorderPainted(false);
		btn_alta_paciente.setContentAreaFilled(false);
		btn_alta_paciente.setBounds(1183, 590, 188, 41);
		contentPane.add(btn_alta_paciente);
		
		JButton btn_editar_paciente = new JButton("");
		btn_editar_paciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_editar_paciente.setIcon(new ImageIcon(jf_pacientes.class.getResource("/iconos_submenus/btn_editarPaciente_admin.png")));
		btn_editar_paciente.setContentAreaFilled(false);
		btn_editar_paciente.setBorder(null);
		btn_editar_paciente.setBorderPainted(false);
		btn_editar_paciente.setOpaque(false);
		btn_editar_paciente.setBounds(400, 590, 188, 41);
		contentPane.add(btn_editar_paciente);
		
		Fondo jp_menu = new Fondo();
		jp_menu.setPreferredSize(new Dimension(1450, 750));
		jp_menu.setBounds(0, 0, 1450, 726);
		contentPane.add(jp_menu);
		GroupLayout gl_jp_menu = new GroupLayout(jp_menu);
		gl_jp_menu.setHorizontalGroup(
			gl_jp_menu.createParallelGroup(Alignment.LEADING)
				.addGap(0, 1450, Short.MAX_VALUE)
		);
		gl_jp_menu.setVerticalGroup(
			gl_jp_menu.createParallelGroup(Alignment.LEADING)
				.addGap(0, 726, Short.MAX_VALUE)
		);
		jp_menu.setLayout(gl_jp_menu);
	}
}

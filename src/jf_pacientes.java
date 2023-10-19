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
		setSize(new Dimension(1450, 750));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1450, 750);
		setLocationRelativeTo(fondo);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorderPainted(false);
		menuBar.setBackground(new Color(32, 160, 216));
		setJMenuBar(menuBar);
		
		JMenu mn_inicio = new JMenu("INICIO");
		menuBar.add(mn_inicio);
		
		JMenu mn_pacientes = new JMenu("PACIENTES");
		menuBar.add(mn_pacientes);
		
		mn_doctores = new JMenu("DOCTORES");
		menuBar.add(mn_doctores);
		
		JMenu mn_material = new JMenu("MATERIAL");
		menuBar.add(mn_material);
		
		JMenu mn_consultas = new JMenu("CONSULTAS");
		menuBar.add(mn_consultas);
		
		JMenu mn_facturacion = new JMenu("FACTURACIÓN");
		menuBar.add(mn_facturacion);
		
		JMenu mn_ajustes = new JMenu("AJUSTES");
		menuBar.add(mn_ajustes);
		
		JMenu mn_ayuda = new JMenu("AYUDA");
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
		btn_editar_paciente.setIcon(new ImageIcon(jf_pacientes.class.getResource("/iconos_submenus/btn_editarPaciente_admin.png")));
		btn_editar_paciente.setContentAreaFilled(false);
		btn_editar_paciente.setBorder(null);
		btn_editar_paciente.setBorderPainted(false);
		btn_editar_paciente.setOpaque(false);
		btn_editar_paciente.setBounds(400, 590, 188, 41);
		contentPane.add(btn_editar_paciente);
		
		Fondo jp_menu = new Fondo();
		jp_menu.setBounds(10, 0, 1450, 726);
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

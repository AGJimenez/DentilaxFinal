package dialogos_pacientes;



import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dentilax_bdd.ConectorDB_mysql;

import java.awt.Dimension;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class jd_buscar_paciente_encontrado_menudr extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txt_dni;
	private JTextField txt_nombre;
	private JTextField txt_apellidos;
	private String dni;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			jd_buscar_paciente_encontrado_menudr dialog = new jd_buscar_paciente_encontrado_menudr();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public jd_buscar_paciente_encontrado_menudr() {
		setTitle("Paciente encontrado");
		setIconImage(Toolkit.getDefaultToolkit().getImage(jd_buscar_paciente_encontrado_menudr.class.getResource("/iconos_menus/dentilaxIcono.png")));
		setPreferredSize(new Dimension(554, 343));
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 554, 343);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(contentPanel);
		{
			JLabel lbl_coincidencia = new JLabel("COINCIDENCIA:");
			lbl_coincidencia.setFont(new Font("Barlow", Font.BOLD, 20));
			lbl_coincidencia.setBounds(35, 35, 167, 42);
			contentPanel.add(lbl_coincidencia);
		}
		{
			JLabel lbl_dni = new JLabel("DNI");
			lbl_dni.setForeground(new Color(0, 128, 192));
			lbl_dni.setFont(new Font("Barlow", Font.BOLD, 22));
			lbl_dni.setBounds(21, 106, 38, 44);
			contentPanel.add(lbl_dni);
		}
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(191, 231, 249));
			panel.setBounds(0, 24, 217, 64);
			contentPanel.add(panel);
		}
		{
			JSeparator separator = new JSeparator();
			separator.setForeground(new Color(0, 128, 192));
			separator.setBackground(new Color(0, 128, 192));
			separator.setBounds(21, 142, 495, 8);
			contentPanel.add(separator);
		}
		{
			JLabel lbl_nombre = new JLabel("Nombre");
			lbl_nombre.setForeground(new Color(0, 128, 192));
			lbl_nombre.setFont(new Font("Barlow", Font.BOLD, 22));
			lbl_nombre.setBounds(124, 106, 78, 44);
			contentPanel.add(lbl_nombre);
		}
		{
			JLabel lbl_apellidos = new JLabel("Apellidos");
			lbl_apellidos.setForeground(new Color(0, 128, 192));
			lbl_apellidos.setFont(new Font("Barlow", Font.BOLD, 22));
			lbl_apellidos.setBounds(290, 106, 100, 44);
			contentPanel.add(lbl_apellidos);
		}
		{
			txt_dni = new JTextField();
			txt_dni.setEditable(false);
			txt_dni.setBorder(null);
			txt_dni.setBackground(new Color(191, 231, 249));
			txt_dni.setFont(new Font("Arial", Font.PLAIN, 14));
			txt_dni.setHorizontalAlignment(SwingConstants.CENTER);
			txt_dni.setBounds(21, 177, 83, 34);
			contentPanel.add(txt_dni);
			txt_dni.setColumns(10);
		}
		{
			txt_nombre = new JTextField();
			txt_nombre.setEditable(false);
			txt_nombre.setBorder(null);
			txt_nombre.setBackground(new Color(191, 231, 249));
			txt_nombre.setFont(new Font("Arial", Font.PLAIN, 14));
			txt_nombre.setHorizontalAlignment(SwingConstants.CENTER);
			txt_nombre.setBounds(124, 177, 146, 34);
			contentPanel.add(txt_nombre);
			txt_nombre.setColumns(10);
		}
		{
			txt_apellidos = new JTextField();
			txt_apellidos.setEditable(false);
			txt_apellidos.setHorizontalAlignment(SwingConstants.CENTER);
			txt_apellidos.setBorder(null);
			txt_apellidos.setBackground(new Color(191, 231, 249));
			txt_apellidos.setFont(new Font("Arial", Font.PLAIN, 14));
			txt_apellidos.setBounds(291, 177, 225, 34);
			contentPanel.add(txt_apellidos);
			txt_apellidos.setColumns(10);
		}
		
		JButton btn_abrirOdontograma = new JButton("");
		btn_abrirOdontograma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Abrimos odontrograma aqui
				jd_odontograma ventana = new jd_odontograma();
				ventana.setVisible(true);
				dispose();
			}
		});
		btn_abrirOdontograma.setFocusPainted(false);
		btn_abrirOdontograma.setBorder(null);
		btn_abrirOdontograma.setToolTipText("Pulsa para abrir el odontograma del paciente");
		btn_abrirOdontograma.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_abrirOdontograma.setContentAreaFilled(false);
		btn_abrirOdontograma.setBorderPainted(false);
		btn_abrirOdontograma.setIcon(new ImageIcon(jd_buscar_paciente_encontrado_menudr.class.getResource("/iconos_submenus/icono_odontograma.png")));
		btn_abrirOdontograma.setBounds(400, 27, 116, 73);
		contentPanel.add(btn_abrirOdontograma);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.WHITE);
			buttonPane.setPreferredSize(new Dimension(10, 60));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(null);
			{
				JButton btn_ficha = new JButton("FICHA");
				btn_ficha.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//SQL consulta para sacar la ficha
						ConectorDB_mysql conector = new ConectorDB_mysql();
						dispose();
						try {
							conector.consulta_paciente_ficha(getTxt_dni().getText().toString());
							jd_buscar_paciente_ficha ventana = new jd_buscar_paciente_ficha();
							
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
				btn_ficha.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				btn_ficha.setBorderPainted(false);
				btn_ficha.setFont(new Font("Barlow", Font.BOLD, 20));
				btn_ficha.setForeground(new Color(255, 255, 255));
				btn_ficha.setBackground(new Color(32, 160, 216));
				btn_ficha.setBounds(20, 0, 153, 43);
				btn_ficha.setActionCommand("OK");
				buttonPane.add(btn_ficha);
				
			}
			{
				JButton btn_salir = new JButton("SALIR");
				btn_salir.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btn_salir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				btn_salir.setBorderPainted(false);
				btn_salir.setFont(new Font("Barlow", Font.BOLD, 20));
				btn_salir.setForeground(new Color(255, 255, 255));
				btn_salir.setBackground(new Color(32, 160, 216));
				btn_salir.setBounds(364, 0, 153, 43);
				btn_salir.setActionCommand("Cancel");
				buttonPane.add(btn_salir);
			}
			
			JButton btn_historial = new JButton("HISTORIAL");
			btn_historial.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btn_historial.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dni = getTxt_dni().getText().toString();
					
					dispose();
					String dniPaciente = dni; // Aquí debes colocar el DNI del paciente que desees buscar
					jd_buscar_paciente_historial ventana = new jd_buscar_paciente_historial(dniPaciente);
					ventana.setVisible(true);
					
				}
			});
			btn_historial.setForeground(Color.WHITE);
			btn_historial.setFont(new Font("Barlow", Font.BOLD, 20));
			btn_historial.setBorderPainted(false);
			btn_historial.setBackground(new Color(32, 160, 216));
			btn_historial.setActionCommand("OK");
			btn_historial.setBounds(194, 0, 153, 43);
			buttonPane.add(btn_historial);
		}
	}

	public JTextField getTxt_dni() {
		return txt_dni;
	}

	public void setTxt_dni(String txt_dni) {
		this.txt_dni.setText(txt_dni);
	}

	public JTextField getTxt_nombre() {
		return txt_nombre;
	}

	public void setTxt_nombre(String txt_nombre) {
		this.txt_nombre.setText(txt_nombre);
	}

	public JTextField getTxt_apellidos() {
		return txt_apellidos;
	}

	public void setTxt_apellidos(String txt_apellidos) {
		this.txt_apellidos.setText(txt_apellidos);
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}
}

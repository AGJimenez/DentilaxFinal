package dialogos_consultas;



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

public class jd_buscar_consulta_encontrada extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txt_dni;
	private JTextField txt_nombre;
	private JTextField txt_apellidos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			jd_buscar_consulta_encontrada dialog = new jd_buscar_consulta_encontrada();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public jd_buscar_consulta_encontrada() {
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
			JLabel lbl_coincidencia = new JLabel("COINCIDENCIA ENCONTRADA:");
			lbl_coincidencia.setFont(new Font("Barlow", Font.BOLD, 20));
			lbl_coincidencia.setBounds(35, 35, 274, 42);
			contentPanel.add(lbl_coincidencia);
		}
		{
			JLabel lbl_fecha = new JLabel("Fecha");
			lbl_fecha.setForeground(new Color(0, 128, 192));
			lbl_fecha.setFont(new Font("Barlow", Font.BOLD, 22));
			lbl_fecha.setBounds(21, 106, 67, 44);
			contentPanel.add(lbl_fecha);
		}
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(191, 231, 249));
			panel.setBounds(0, 24, 340, 64);
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
			JLabel lbl_doctor = new JLabel("Doctor");
			lbl_doctor.setForeground(new Color(0, 128, 192));
			lbl_doctor.setFont(new Font("Barlow", Font.BOLD, 22));
			lbl_doctor.setBounds(124, 106, 78, 44);
			contentPanel.add(lbl_doctor);
		}
		{
			JLabel lbl_paciente = new JLabel("Paciente");
			lbl_paciente.setForeground(new Color(0, 128, 192));
			lbl_paciente.setFont(new Font("Barlow", Font.BOLD, 22));
			lbl_paciente.setBounds(290, 106, 100, 44);
			contentPanel.add(lbl_paciente);
		}
		{
			txt_dni = new JTextField();
			txt_dni.setEditable(false);
			txt_dni.setBorder(null);
			txt_dni.setBackground(new Color(191, 231, 249));
			txt_dni.setFont(new Font("Arial", Font.PLAIN, 14));
			txt_dni.setHorizontalAlignment(SwingConstants.CENTER);
			txt_dni.setText("77981983t");
			
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
			txt_nombre.setText("Alejandro Alfredo");
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
			txt_apellidos.setText("Fernandez de la Rosa Ximenez");
			txt_apellidos.setBounds(291, 177, 225, 34);
			contentPanel.add(txt_apellidos);
			txt_apellidos.setColumns(10);
		}
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.WHITE);
			buttonPane.setPreferredSize(new Dimension(10, 60));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(null);
			{
				JButton btn_ver_cita = new JButton("VER CITA");
				btn_ver_cita.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//SQL consulta para sacar la ficha
						
						/*ConectorDB_mysql conector = new ConectorDB_mysql();
						
						try {
							conector.consulta_doctor_ficha(getTxt_dni().getText().toString());
							dispose();
							jd_buscar_consulta_ver_cita ventana = new jd_buscar_consulta_ver_cita();
							
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}*/
						dispose();
						jd_buscar_consulta_ver_cita ventana = new jd_buscar_consulta_ver_cita();
						ventana.setVisible(true);
					}
				});
				btn_ver_cita.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				btn_ver_cita.setBorderPainted(false);
				btn_ver_cita.setFont(new Font("Barlow", Font.BOLD, 20));
				btn_ver_cita.setForeground(new Color(255, 255, 255));
				btn_ver_cita.setBackground(new Color(32, 160, 216));
				btn_ver_cita.setBounds(20, 0, 153, 43);
				btn_ver_cita.setActionCommand("OK");
				buttonPane.add(btn_ver_cita);
				
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
			
			JButton btn_eliminar = new JButton("ELIMINAR");
			btn_eliminar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btn_eliminar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					jd_buscar_consulta_ver_cita ventana = new jd_buscar_consulta_ver_cita();
					ventana.setVisible(true);
					
					
					
					
				}
			});
			btn_eliminar.setForeground(Color.WHITE);
			btn_eliminar.setFont(new Font("Barlow", Font.BOLD, 20));
			btn_eliminar.setBorderPainted(false);
			btn_eliminar.setBackground(new Color(32, 160, 216));
			btn_eliminar.setActionCommand("OK");
			btn_eliminar.setBounds(194, 0, 153, 43);
			buttonPane.add(btn_eliminar);
		}
	}

	public JTextField getTxt_dni() {
		return txt_dni;
	}

	public void setTxt_dni(String dniSql) {
	    this.txt_dni.setText(dniSql);
	}


	public JTextField getTxt_nombre() {
		return txt_nombre;
	}

	public void setTxt_nombre(String nombreSql) {
		this.txt_nombre.setText(nombreSql);;
	}

	public JTextField getTxt_apellidos() {
		return txt_apellidos;
	}

	public void setTxt_apellidos(String apellidosSql) {
		this.txt_apellidos.setText(apellidosSql);
	}

	
}
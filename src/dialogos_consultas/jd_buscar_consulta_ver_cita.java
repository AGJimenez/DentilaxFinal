package dialogos_consultas;



import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class jd_buscar_consulta_ver_cita extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txt_dni;
	private JTextField txt_nombre;
	private JTextField txt_apellidos;
	private JTextField txt_salario;
	private JTextField txt_especialidad;
	private JTextArea txt_telefono;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			jd_buscar_consulta_ver_cita dialog = new jd_buscar_consulta_ver_cita();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public jd_buscar_consulta_ver_cita() {
		setModal(true);
		setPreferredSize(new Dimension(545, 554));
		setResizable(false);
		setBounds(100, 100, 661, 560);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(contentPanel);
		{
			JLabel lbl_cita = new JLabel("CITA:");
			lbl_cita.setFont(new Font("Barlow", Font.BOLD, 20));
			lbl_cita.setBounds(35, 35, 78, 42);
			contentPanel.add(lbl_cita);
		}
		{
			JLabel lbl_nombre = new JLabel("NOMBRE");
			lbl_nombre.setForeground(new Color(0, 128, 192));
			lbl_nombre.setFont(new Font("Barlow", Font.BOLD, 22));
			lbl_nombre.setBounds(21, 99, 92, 34);
			contentPanel.add(lbl_nombre);
		}
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(191, 231, 249));
			panel.setBounds(0, 24, 134, 64);
			contentPanel.add(panel);
		}
		{
			JLabel lbl_apellidos = new JLabel("APELLIDOS");
			lbl_apellidos.setForeground(new Color(0, 128, 192));
			lbl_apellidos.setFont(new Font("Barlow", Font.BOLD, 22));
			lbl_apellidos.setBounds(21, 154, 124, 34);
			contentPanel.add(lbl_apellidos);
		}
		{
			JLabel lbl_doctor = new JLabel("DOCTOR");
			lbl_doctor.setForeground(new Color(0, 128, 192));
			lbl_doctor.setFont(new Font("Barlow", Font.BOLD, 22));
			lbl_doctor.setBounds(21, 209, 100, 34);
			contentPanel.add(lbl_doctor);
		}
		{
			txt_dni = new JTextField();
			txt_dni.setEditable(false);
			txt_dni.setBorder(null);
			txt_dni.setBackground(new Color(191, 231, 249));
			txt_dni.setFont(new Font("Arial", Font.PLAIN, 14));
			txt_dni.setHorizontalAlignment(SwingConstants.CENTER);
			txt_dni.setText("Alejandro");
			txt_dni.setBounds(223, 99, 226, 34);
			contentPanel.add(txt_dni);
			txt_dni.setColumns(10);
		}
		{
			txt_nombre = new JTextField();
			txt_nombre.setEditable(false);
			txt_nombre.setBorder(null);
			txt_nombre.setBackground(new Color(191, 231, 249));
			txt_nombre.setFont(new Font("Arial", Font.PLAIN, 14));
			txt_nombre.setText("Apellido Apellido");
			txt_nombre.setHorizontalAlignment(SwingConstants.CENTER);
			txt_nombre.setBounds(223, 154, 226, 34);
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
			txt_apellidos.setText("Sergio");
			txt_apellidos.setBounds(224, 209, 225, 34);
			contentPanel.add(txt_apellidos);
			txt_apellidos.setColumns(10);
		}
		{
			JLabel lbl_especialidad = new JLabel("ESPECIALIDAD");
			lbl_especialidad.setForeground(new Color(0, 128, 192));
			lbl_especialidad.setFont(new Font("Barlow", Font.BOLD, 22));
			lbl_especialidad.setBounds(21, 263, 155, 34);
			contentPanel.add(lbl_especialidad);
		}
		{
			txt_salario = new JTextField();
			txt_salario.setText("Odontologia");
			txt_salario.setHorizontalAlignment(SwingConstants.CENTER);
			txt_salario.setFont(new Font("Arial", Font.PLAIN, 14));
			txt_salario.setEditable(false);
			txt_salario.setColumns(10);
			txt_salario.setBorder(null);
			txt_salario.setBackground(new Color(191, 231, 249));
			txt_salario.setBounds(223, 263, 225, 34);
			contentPanel.add(txt_salario);
		}
		{
			JLabel lbl_fecha_hora = new JLabel("FECHA/HORA");
			lbl_fecha_hora.setForeground(new Color(0, 128, 192));
			lbl_fecha_hora.setFont(new Font("Barlow", Font.BOLD, 22));
			lbl_fecha_hora.setBounds(21, 317, 155, 34);
			contentPanel.add(lbl_fecha_hora);
		}
		{
			txt_especialidad = new JTextField();
			txt_especialidad.setText("2004-01-15");
			txt_especialidad.setHorizontalAlignment(SwingConstants.CENTER);
			txt_especialidad.setFont(new Font("Arial", Font.PLAIN, 14));
			txt_especialidad.setEditable(false);
			txt_especialidad.setColumns(10);
			txt_especialidad.setBorder(null);
			txt_especialidad.setBackground(new Color(191, 231, 249));
			txt_especialidad.setBounds(223, 317, 225, 34);
			contentPanel.add(txt_especialidad);
		}
		{
			JLabel lbl_observaciones = new JLabel("OBSERVACIONES");
			lbl_observaciones.setForeground(new Color(0, 128, 192));
			lbl_observaciones.setFont(new Font("Barlow", Font.BOLD, 22));
			lbl_observaciones.setBounds(21, 375, 178, 34);
			contentPanel.add(lbl_observaciones);
		}
		{
			txt_telefono = new JTextArea();
			txt_telefono.setText("2 meses de tratamiento");
			txt_telefono.setFont(new Font("Arial", Font.PLAIN, 14));
			txt_telefono.setEditable(false);
			txt_telefono.setColumns(10);
			txt_telefono.setBorder(null);
			txt_telefono.setBackground(new Color(191, 231, 249));
			txt_telefono.setBounds(223, 374, 375, 76);
			contentPanel.add(txt_telefono);
		}
		
		textField = new JTextField();
		textField.setText("16:04");
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Arial", Font.PLAIN, 14));
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBorder(null);
		textField.setBackground(new Color(191, 231, 249));
		textField.setBounds(473, 317, 85, 34);
		contentPanel.add(textField);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.WHITE);
			buttonPane.setPreferredSize(new Dimension(10, 60));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(null);
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
		}
	}

	public JTextField getTxt_dni() {
		return txt_dni;
	}

	public void setTxt_dni(String txt_dni) {
		this.txt_dni.setText(txt_dni);;
	}

	public JTextField getTxt_nombre() {
		return txt_nombre;
	}

	public void setTxt_nombre(String txt_nombre) {
		this.txt_nombre.setText(txt_nombre);;
	}

	public JTextField getTxt_apellidos() {
		return txt_apellidos;
	}

	public void setTxt_apellidos(String txt_apellidos) {
		this.txt_apellidos.setText(txt_apellidos);;
	}

	public JTextField getTxt_salario() {
		return txt_salario;
	}

	public void setTxt_salario(String txt_salario) {
		this.txt_salario.setText(txt_salario);;
	}

	public JTextField getTxt_especialidad() {
		return txt_especialidad;
	}

	public void setTxt_especialidad(String txt_especialidad) {
		this.txt_especialidad.setText(txt_especialidad);;
	}

	public JTextField getTxt_telefono() {
		return txt_telefono;
	}

	public void setTxt_telefono(String txt_telefono) {
		this.txt_telefono.setText(txt_telefono);;
	}
}

package dialogos_doctores;



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

public class jd_buscar_dr_ficha extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txt_dni;
	private JTextField txt_nombre;
	private JTextField txt_apellidos;
	private JTextField txt_salario;
	private JTextField txt_especialidad;
	private JTextField txt_telefono;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			jd_buscar_dr_ficha dialog = new jd_buscar_dr_ficha();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public jd_buscar_dr_ficha() {
		setModal(true);
		setPreferredSize(new Dimension(545, 554));
		setResizable(false);
		setBounds(100, 100, 545, 554);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(contentPanel);
		{
			JLabel lbl_doctor = new JLabel("DOCTOR:");
			lbl_doctor.setFont(new Font("Barlow", Font.BOLD, 20));
			lbl_doctor.setBounds(35, 35, 167, 42);
			contentPanel.add(lbl_doctor);
		}
		{
			JLabel lbl_Dni = new JLabel("DNI");
			lbl_Dni.setForeground(new Color(0, 128, 192));
			lbl_Dni.setFont(new Font("Barlow", Font.BOLD, 22));
			lbl_Dni.setBounds(69, 130, 38, 44);
			contentPanel.add(lbl_Dni);
		}
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(191, 231, 249));
			panel.setBounds(0, 24, 217, 64);
			contentPanel.add(panel);
		}
		{
			JLabel lbl_nombre = new JLabel("Nombre");
			lbl_nombre.setForeground(new Color(0, 128, 192));
			lbl_nombre.setFont(new Font("Barlow", Font.BOLD, 22));
			lbl_nombre.setBounds(69, 177, 78, 44);
			contentPanel.add(lbl_nombre);
		}
		{
			JLabel lbl_Apellidos = new JLabel("Apellidos");
			lbl_Apellidos.setForeground(new Color(0, 128, 192));
			lbl_Apellidos.setFont(new Font("Barlow", Font.BOLD, 22));
			lbl_Apellidos.setBounds(69, 225, 100, 44);
			contentPanel.add(lbl_Apellidos);
		}
		{
			txt_dni = new JTextField();
			txt_dni.setEditable(false);
			txt_dni.setBorder(null);
			txt_dni.setBackground(new Color(191, 231, 249));
			txt_dni.setFont(new Font("Arial", Font.PLAIN, 14));
			txt_dni.setHorizontalAlignment(SwingConstants.CENTER);
			txt_dni.setText("77981983t");
			txt_dni.setBounds(223, 130, 226, 34);
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
			txt_nombre.setBounds(223, 177, 226, 34);
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
			txt_apellidos.setBounds(224, 225, 225, 34);
			contentPanel.add(txt_apellidos);
			txt_apellidos.setColumns(10);
		}
		{
			JLabel lbl_salario = new JLabel("Salario");
			lbl_salario.setForeground(new Color(0, 128, 192));
			lbl_salario.setFont(new Font("Barlow", Font.BOLD, 22));
			lbl_salario.setBounds(69, 274, 100, 44);
			contentPanel.add(lbl_salario);
		}
		{
			txt_salario = new JTextField();
			txt_salario.setText("24.000/año");
			txt_salario.setHorizontalAlignment(SwingConstants.CENTER);
			txt_salario.setFont(new Font("Arial", Font.PLAIN, 14));
			txt_salario.setEditable(false);
			txt_salario.setColumns(10);
			txt_salario.setBorder(null);
			txt_salario.setBackground(new Color(191, 231, 249));
			txt_salario.setBounds(224, 274, 225, 34);
			contentPanel.add(txt_salario);
		}
		{
			JLabel lbl_especialidad = new JLabel("Especialidad");
			lbl_especialidad.setForeground(new Color(0, 128, 192));
			lbl_especialidad.setFont(new Font("Barlow", Font.BOLD, 22));
			lbl_especialidad.setBounds(69, 319, 126, 44);
			contentPanel.add(lbl_especialidad);
		}
		{
			txt_especialidad = new JTextField();
			txt_especialidad.setText("Odontopediatría");
			txt_especialidad.setHorizontalAlignment(SwingConstants.CENTER);
			txt_especialidad.setFont(new Font("Arial", Font.PLAIN, 14));
			txt_especialidad.setEditable(false);
			txt_especialidad.setColumns(10);
			txt_especialidad.setBorder(null);
			txt_especialidad.setBackground(new Color(191, 231, 249));
			txt_especialidad.setBounds(224, 319, 225, 34);
			contentPanel.add(txt_especialidad);
		}
		{
			JLabel lbl_especialidad = new JLabel("Teléfono");
			lbl_especialidad.setForeground(new Color(0, 128, 192));
			lbl_especialidad.setFont(new Font("Barlow", Font.BOLD, 22));
			lbl_especialidad.setBounds(69, 364, 126, 44);
			contentPanel.add(lbl_especialidad);
		}
		{
			txt_telefono = new JTextField();
			txt_telefono.setText("662 59 25 50");
			txt_telefono.setHorizontalAlignment(SwingConstants.CENTER);
			txt_telefono.setFont(new Font("Arial", Font.PLAIN, 14));
			txt_telefono.setEditable(false);
			txt_telefono.setColumns(10);
			txt_telefono.setBorder(null);
			txt_telefono.setBackground(new Color(191, 231, 249));
			txt_telefono.setBounds(224, 364, 225, 34);
			contentPanel.add(txt_telefono);
		}
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

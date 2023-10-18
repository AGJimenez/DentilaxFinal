


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
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class jd_doctores_alta extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private final ButtonGroup btn_group_genero = new ButtonGroup();
	private JTextField txt_nombre;
	private JTextField txt_dni;
	private JTextField txt_telefono;
	private JTextField txt_especialidad;
	private JTextField txt_salario;
	private JTextField txt_apellidos;
	private JTextField txtIntroduceFechaDe;
	private JTextField txt_correo;
	private JTextField txtLineaDeDireccin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			jd_doctores_alta dialog = new jd_doctores_alta();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public jd_doctores_alta() {
		setModal(true);
		setResizable(false);
		setPreferredSize(new Dimension(1192, 452));
		setBounds(100, 100, 1192, 452);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(contentPanel);
		{
			JLabel lbl_genero = new JLabel("GÉNERO");
			lbl_genero.setFont(new Font("Barlow", Font.BOLD, 20));
			lbl_genero.setBounds(54, 58, 83, 40);
			contentPanel.add(lbl_genero);
		}
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(191, 231, 249));
			panel.setBounds(54, 105, 116, 147);
			contentPanel.add(panel);
			panel.setLayout(null);
			
			JRadioButton rdbtnNewRadioButton = new JRadioButton("Varón");
			btn_group_genero.add(rdbtnNewRadioButton);
			rdbtnNewRadioButton.setOpaque(false);
			rdbtnNewRadioButton.setFont(new Font("Arial", Font.PLAIN, 14));
			rdbtnNewRadioButton.setBounds(24, 24, 71, 23);
			panel.add(rdbtnNewRadioButton);
			
			JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Mujer");
			btn_group_genero.add(rdbtnNewRadioButton_1);
			rdbtnNewRadioButton_1.setOpaque(false);
			rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
			rdbtnNewRadioButton_1.setBounds(24, 60, 71, 23);
			panel.add(rdbtnNewRadioButton_1);
			
			JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Otro");
			btn_group_genero.add(rdbtnNewRadioButton_2);
			rdbtnNewRadioButton_2.setOpaque(false);
			rdbtnNewRadioButton_2.setFont(new Font("Arial", Font.PLAIN, 14));
			rdbtnNewRadioButton_2.setBounds(24, 100, 71, 23);
			panel.add(rdbtnNewRadioButton_2);
		}
		{
			JLabel lbl_nombre_dr = new JLabel("NOMBRE");
			lbl_nombre_dr.setFont(new Font("Barlow", Font.BOLD, 20));
			lbl_nombre_dr.setBounds(233, 58, 83, 40);
			contentPanel.add(lbl_nombre_dr);
		}
		{
			txt_nombre = new JTextField();
			txt_nombre.setHorizontalAlignment(SwingConstants.CENTER);
			txt_nombre.setFont(new Font("Arial", Font.PLAIN, 14));
			txt_nombre.setText("Introduce el nombre del doctor.");
			txt_nombre.setBorder(null);
			txt_nombre.setBackground(new Color(191, 231, 249));
			txt_nombre.setBounds(387, 58, 218, 40);
			contentPanel.add(txt_nombre);
			txt_nombre.setColumns(10);
		}
		{
			txt_dni = new JTextField();
			txt_dni.setText("Introduce el DNI.");
			txt_dni.setHorizontalAlignment(SwingConstants.CENTER);
			txt_dni.setFont(new Font("Arial", Font.PLAIN, 14));
			txt_dni.setColumns(10);
			txt_dni.setBorder(null);
			txt_dni.setBackground(new Color(191, 231, 249));
			txt_dni.setBounds(387, 120, 218, 40);
			contentPanel.add(txt_dni);
		}
		{
			JLabel lbl_dni = new JLabel("DNI");
			lbl_dni.setFont(new Font("Barlow", Font.BOLD, 20));
			lbl_dni.setBounds(233, 120, 83, 40);
			contentPanel.add(lbl_dni);
		}
		{
			JLabel lbl_telefono = new JLabel("TELÉFONO");
			lbl_telefono.setFont(new Font("Barlow", Font.BOLD, 20));
			lbl_telefono.setBounds(233, 184, 103, 40);
			contentPanel.add(lbl_telefono);
		}
		{
			txt_telefono = new JTextField();
			txt_telefono.setText("Introduce el teléfono.");
			txt_telefono.setHorizontalAlignment(SwingConstants.CENTER);
			txt_telefono.setFont(new Font("Arial", Font.PLAIN, 14));
			txt_telefono.setColumns(10);
			txt_telefono.setBorder(null);
			txt_telefono.setBackground(new Color(191, 231, 249));
			txt_telefono.setBounds(387, 184, 218, 40);
			contentPanel.add(txt_telefono);
		}
		{
			JLabel lbl_especialidad = new JLabel("ESPECIALIDAD");
			lbl_especialidad.setFont(new Font("Barlow", Font.BOLD, 20));
			lbl_especialidad.setBounds(233, 245, 131, 40);
			contentPanel.add(lbl_especialidad);
		}
		{
			txt_especialidad = new JTextField();
			txt_especialidad.setText("Introduce la especialidad.");
			txt_especialidad.setHorizontalAlignment(SwingConstants.CENTER);
			txt_especialidad.setFont(new Font("Arial", Font.PLAIN, 14));
			txt_especialidad.setColumns(10);
			txt_especialidad.setBorder(null);
			txt_especialidad.setBackground(new Color(191, 231, 249));
			txt_especialidad.setBounds(387, 249, 218, 40);
			contentPanel.add(txt_especialidad);
		}
		{
			JLabel lbl_salario = new JLabel("SALARIO");
			lbl_salario.setFont(new Font("Barlow", Font.BOLD, 20));
			lbl_salario.setBounds(233, 313, 103, 40);
			contentPanel.add(lbl_salario);
		}
		{
			txt_salario = new JTextField();
			txt_salario.setText("Introduce el salario");
			txt_salario.setHorizontalAlignment(SwingConstants.CENTER);
			txt_salario.setFont(new Font("Arial", Font.PLAIN, 14));
			txt_salario.setColumns(10);
			txt_salario.setBorder(null);
			txt_salario.setBackground(new Color(191, 231, 249));
			txt_salario.setBounds(387, 313, 218, 40);
			contentPanel.add(txt_salario);
		}
		{
			JLabel lbl_apellidos = new JLabel("APELLIDOS");
			lbl_apellidos.setFont(new Font("Barlow", Font.BOLD, 20));
			lbl_apellidos.setBounds(665, 58, 100, 40);
			contentPanel.add(lbl_apellidos);
		}
		{
			txt_apellidos = new JTextField();
			txt_apellidos.setText("Introduce el nombre del doctor.");
			txt_apellidos.setHorizontalAlignment(SwingConstants.CENTER);
			txt_apellidos.setFont(new Font("Arial", Font.PLAIN, 14));
			txt_apellidos.setColumns(10);
			txt_apellidos.setBorder(null);
			txt_apellidos.setBackground(new Color(191, 231, 249));
			txt_apellidos.setBounds(834, 58, 218, 40);
			contentPanel.add(txt_apellidos);
		}
		{
			JLabel lbl_nacimiento = new JLabel("NACIMIENTO");
			lbl_nacimiento.setFont(new Font("Barlow", Font.BOLD, 20));
			lbl_nacimiento.setBounds(665, 120, 111, 40);
			contentPanel.add(lbl_nacimiento);
		}
		{
			txtIntroduceFechaDe = new JTextField();
			txtIntroduceFechaDe.setText("Introduce fecha de nacimiento.");
			txtIntroduceFechaDe.setHorizontalAlignment(SwingConstants.CENTER);
			txtIntroduceFechaDe.setFont(new Font("Arial", Font.PLAIN, 14));
			txtIntroduceFechaDe.setColumns(10);
			txtIntroduceFechaDe.setBorder(null);
			txtIntroduceFechaDe.setBackground(new Color(191, 231, 249));
			txtIntroduceFechaDe.setBounds(834, 120, 218, 40);
			contentPanel.add(txtIntroduceFechaDe);
		}
		{
			txt_correo = new JTextField();
			txt_correo.setText("Introduce correo.");
			txt_correo.setHorizontalAlignment(SwingConstants.CENTER);
			txt_correo.setFont(new Font("Arial", Font.PLAIN, 14));
			txt_correo.setColumns(10);
			txt_correo.setBorder(null);
			txt_correo.setBackground(new Color(191, 231, 249));
			txt_correo.setBounds(834, 184, 218, 40);
			contentPanel.add(txt_correo);
		}
		{
			JLabel lbl_correo = new JLabel("CORREO");
			lbl_correo.setFont(new Font("Barlow", Font.BOLD, 20));
			lbl_correo.setBounds(665, 184, 111, 40);
			contentPanel.add(lbl_correo);
		}
		{
			txtLineaDeDireccin = new JTextField();
			txtLineaDeDireccin.setText("Linea de dirección.");
			txtLineaDeDireccin.setHorizontalAlignment(SwingConstants.CENTER);
			txtLineaDeDireccin.setFont(new Font("Arial", Font.PLAIN, 14));
			txtLineaDeDireccin.setColumns(10);
			txtLineaDeDireccin.setBorder(null);
			txtLineaDeDireccin.setBackground(new Color(191, 231, 249));
			txtLineaDeDireccin.setBounds(834, 249, 218, 40);
			contentPanel.add(txtLineaDeDireccin);
		}
		{
			JLabel lbl_nacimiento = new JLabel("DIRECCIÓN");
			lbl_nacimiento.setFont(new Font("Barlow", Font.BOLD, 20));
			lbl_nacimiento.setBounds(665, 249, 111, 40);
			contentPanel.add(lbl_nacimiento);
		}
		{
			JPanel panel = new JPanel();
			panel.setBounds(54, 263, 116, 116);
			contentPanel.add(panel);
		}
		{
			JButton btn_anadir = new JButton("AÑADIR");
			btn_anadir.setBounds(665, 336, 153, 43);
			contentPanel.add(btn_anadir);
			btn_anadir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//sql
				}
			});
			btn_anadir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btn_anadir.setBorderPainted(false);
			btn_anadir.setFont(new Font("Barlow", Font.BOLD, 20));
			btn_anadir.setForeground(new Color(255, 255, 255));
			btn_anadir.setBackground(new Color(32, 160, 216));
			btn_anadir.setActionCommand("OK");
			
		}
		{
			JButton cancelButton = new JButton("CANCELAR");
			cancelButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			cancelButton.setBounds(899, 336, 153, 43);
			cancelButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			cancelButton.setBorderPainted(false);
			cancelButton.setFont(new Font("Barlow", Font.BOLD, 20));
			cancelButton.setForeground(new Color(255, 255, 255));
			cancelButton.setBackground(new Color(32, 160, 216));
			contentPanel.add(cancelButton);
			cancelButton.setActionCommand("Cancel");
		}
	}
}

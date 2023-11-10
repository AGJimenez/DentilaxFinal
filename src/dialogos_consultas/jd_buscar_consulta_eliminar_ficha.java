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

public class jd_buscar_consulta_eliminar_ficha extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txt_nombre;
	private JTextField txt_apellidos;
	private JTextField txt_doctor;
	private JTextField txt_especialidad;
	private JTextField txt_fecha;
	private JTextArea txt_observaciones;
	private JTextField txt_hora;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			jd_buscar_consulta_eliminar_ficha dialog = new jd_buscar_consulta_eliminar_ficha();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public jd_buscar_consulta_eliminar_ficha() {
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
			txt_nombre = new JTextField();
			txt_nombre.setEditable(false);
			txt_nombre.setBorder(null);
			txt_nombre.setBackground(new Color(191, 231, 249));
			txt_nombre.setFont(new Font("Arial", Font.PLAIN, 14));
			txt_nombre.setHorizontalAlignment(SwingConstants.CENTER);
			txt_nombre.setBounds(223, 99, 226, 34);
			contentPanel.add(txt_nombre);
			txt_nombre.setColumns(10);
		}
		{
			txt_apellidos = new JTextField();
			txt_apellidos.setEditable(false);
			txt_apellidos.setBorder(null);
			txt_apellidos.setBackground(new Color(191, 231, 249));
			txt_apellidos.setFont(new Font("Arial", Font.PLAIN, 14));
			txt_apellidos.setHorizontalAlignment(SwingConstants.CENTER);
			txt_apellidos.setBounds(223, 154, 226, 34);
			contentPanel.add(txt_apellidos);
			txt_apellidos.setColumns(10);
		}
		{
			txt_doctor = new JTextField();
			txt_doctor.setEditable(false);
			txt_doctor.setHorizontalAlignment(SwingConstants.CENTER);
			txt_doctor.setBorder(null);
			txt_doctor.setBackground(new Color(191, 231, 249));
			txt_doctor.setFont(new Font("Arial", Font.PLAIN, 14));
			txt_doctor.setBounds(224, 209, 225, 34);
			contentPanel.add(txt_doctor);
			txt_doctor.setColumns(10);
		}
		{
			JLabel lbl_especialidad = new JLabel("ESPECIALIDAD");
			lbl_especialidad.setForeground(new Color(0, 128, 192));
			lbl_especialidad.setFont(new Font("Barlow", Font.BOLD, 22));
			lbl_especialidad.setBounds(21, 263, 155, 34);
			contentPanel.add(lbl_especialidad);
		}
		{
			txt_especialidad = new JTextField();
			txt_especialidad.setHorizontalAlignment(SwingConstants.CENTER);
			txt_especialidad.setFont(new Font("Arial", Font.PLAIN, 14));
			txt_especialidad.setEditable(false);
			txt_especialidad.setColumns(10);
			txt_especialidad.setBorder(null);
			txt_especialidad.setBackground(new Color(191, 231, 249));
			txt_especialidad.setBounds(223, 263, 225, 34);
			contentPanel.add(txt_especialidad);
		}
		{
			JLabel lbl_fecha_hora = new JLabel("FECHA/HORA");
			lbl_fecha_hora.setForeground(new Color(0, 128, 192));
			lbl_fecha_hora.setFont(new Font("Barlow", Font.BOLD, 22));
			lbl_fecha_hora.setBounds(21, 317, 155, 34);
			contentPanel.add(lbl_fecha_hora);
		}
		{
			txt_fecha = new JTextField();
			txt_fecha.setHorizontalAlignment(SwingConstants.CENTER);
			txt_fecha.setFont(new Font("Arial", Font.PLAIN, 14));
			txt_fecha.setEditable(false);
			txt_fecha.setColumns(10);
			txt_fecha.setBorder(null);
			txt_fecha.setBackground(new Color(191, 231, 249));
			txt_fecha.setBounds(223, 317, 225, 34);
			contentPanel.add(txt_fecha);
		}
		{
			JLabel lbl_observaciones = new JLabel("OBSERVACIONES");
			lbl_observaciones.setForeground(new Color(0, 128, 192));
			lbl_observaciones.setFont(new Font("Barlow", Font.BOLD, 22));
			lbl_observaciones.setBounds(21, 375, 178, 34);
			contentPanel.add(lbl_observaciones);
		}
		{
			txt_observaciones = new JTextArea();
			txt_observaciones.setFont(new Font("Arial", Font.PLAIN, 14));
			txt_observaciones.setEditable(false);
			txt_observaciones.setColumns(10);
			txt_observaciones.setBorder(null);
			txt_observaciones.setBackground(new Color(191, 231, 249));
			txt_observaciones.setBounds(223, 374, 375, 76);
			contentPanel.add(txt_observaciones);
		}
		
		txt_hora = new JTextField();
		txt_hora.setHorizontalAlignment(SwingConstants.CENTER);
		txt_hora.setFont(new Font("Arial", Font.PLAIN, 14));
		txt_hora.setEditable(false);
		txt_hora.setColumns(10);
		txt_hora.setBorder(null);
		txt_hora.setBackground(new Color(191, 231, 249));
		txt_hora.setBounds(473, 317, 85, 34);
		contentPanel.add(txt_hora);
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

	public JTextField getTxt_nombre() {
		return txt_nombre;
	}

	public void setTxt_nombre(String NombreSql) {
		this.txt_nombre.setText(NombreSql);;
	}

	public JTextField getTxt_apellidos() {
		return txt_apellidos;
	}

	public void setTxt_apellidos(String ApellidosSql) {
		this.txt_apellidos.setText(ApellidosSql);;
	}

	public JTextField getTxt_doctor() {
		return txt_doctor;
	}

	public void setTxt_doctor(String DoctorSql) {
		this.txt_doctor.setText(DoctorSql);;
	}

	public JTextField getTxt_especialidad() {
		return txt_especialidad;
	}

	public void setTxt_especialidad(String EspecialidadSql) {
		this.txt_especialidad.setText(EspecialidadSql);;
	}

	public JTextField getTxt_fecha() {
		return txt_fecha;
	}

	public void setTxt_fecha(String FechaSql) {
		this.txt_fecha.setText(FechaSql);;
	}

	public JTextArea getTxt_observaciones() {
		return txt_observaciones;
	}

	public void setTxt_observaciones(String ObservacionesSql) {
		this.txt_observaciones.setText(ObservacionesSql);
	}

	public JTextField getTxt_hora() {
		return txt_hora;
	}

	public void setTxt_hora(String HoraSql) {
		this.txt_hora.setText(HoraSql);;
	}
}

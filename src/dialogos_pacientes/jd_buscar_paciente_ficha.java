package dialogos_pacientes;



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
import java.awt.Toolkit;

public class jd_buscar_paciente_ficha extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txt_dni;
	private JTextField txt_nombre;
	private JTextField txt_apellidos;
	private JTextField txt_genero;
	private JTextField txt_estado;
	private JTextField txt_seguro;
	private JTextField txt_telefono;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			jd_buscar_paciente_ficha dialog = new jd_buscar_paciente_ficha();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public jd_buscar_paciente_ficha() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(jd_buscar_paciente_ficha.class.getResource("/iconos_menus/dentilaxIcono.png")));
		setTitle("Ficha de paciente");
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
			JLabel lbl_paciente = new JLabel("PACIENTE:");
			lbl_paciente.setFont(new Font("Barlow", Font.BOLD, 20));
			lbl_paciente.setBounds(35, 35, 167, 42);
			contentPanel.add(lbl_paciente);
		}
		{
			JLabel lbl_Dni = new JLabel("DNI");
			lbl_Dni.setForeground(new Color(0, 128, 192));
			lbl_Dni.setFont(new Font("Barlow", Font.BOLD, 22));
			lbl_Dni.setBounds(69, 99, 38, 44);
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
			lbl_nombre.setBounds(69, 146, 78, 44);
			contentPanel.add(lbl_nombre);
		}
		{
			JLabel lbl_Apellidos = new JLabel("Apellidos");
			lbl_Apellidos.setForeground(new Color(0, 128, 192));
			lbl_Apellidos.setFont(new Font("Barlow", Font.BOLD, 22));
			lbl_Apellidos.setBounds(69, 194, 100, 44);
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
			txt_nombre.setText("Alejandro Alfredo");
			txt_nombre.setHorizontalAlignment(SwingConstants.CENTER);
			txt_nombre.setBounds(223, 146, 226, 34);
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
			txt_apellidos.setBounds(224, 194, 225, 34);
			contentPanel.add(txt_apellidos);
			txt_apellidos.setColumns(10);
		}
		{
			JLabel lbl_genero = new JLabel("Género");
			lbl_genero.setForeground(new Color(0, 128, 192));
			lbl_genero.setFont(new Font("Barlow", Font.BOLD, 22));
			lbl_genero.setBounds(69, 243, 100, 44);
			contentPanel.add(lbl_genero);
		}
		{
			txt_genero = new JTextField();
			txt_genero.setText("Varón");
			txt_genero.setHorizontalAlignment(SwingConstants.CENTER);
			txt_genero.setFont(new Font("Arial", Font.PLAIN, 14));
			txt_genero.setEditable(false);
			txt_genero.setColumns(10);
			txt_genero.setBorder(null);
			txt_genero.setBackground(new Color(191, 231, 249));
			txt_genero.setBounds(224, 243, 225, 34);
			contentPanel.add(txt_genero);
		}
		{
			JLabel lbl_estado = new JLabel("Estado");
			lbl_estado.setForeground(new Color(0, 128, 192));
			lbl_estado.setFont(new Font("Barlow", Font.BOLD, 22));
			lbl_estado.setBounds(69, 288, 126, 44);
			contentPanel.add(lbl_estado);
		}
		{
			txt_estado = new JTextField();
			txt_estado.setText("De alta");
			txt_estado.setHorizontalAlignment(SwingConstants.CENTER);
			txt_estado.setFont(new Font("Arial", Font.PLAIN, 14));
			txt_estado.setEditable(false);
			txt_estado.setColumns(10);
			txt_estado.setBorder(null);
			txt_estado.setBackground(new Color(191, 231, 249));
			txt_estado.setBounds(224, 288, 225, 34);
			contentPanel.add(txt_estado);
		}
		{
			JLabel lbl_seguro = new JLabel("Seguro");
			lbl_seguro.setForeground(new Color(0, 128, 192));
			lbl_seguro.setFont(new Font("Barlow", Font.BOLD, 22));
			lbl_seguro.setBounds(69, 333, 126, 44);
			contentPanel.add(lbl_seguro);
		}
		{
			txt_seguro = new JTextField();
			txt_seguro.setText("Privado");
			txt_seguro.setHorizontalAlignment(SwingConstants.CENTER);
			txt_seguro.setFont(new Font("Arial", Font.PLAIN, 14));
			txt_seguro.setEditable(false);
			txt_seguro.setColumns(10);
			txt_seguro.setBorder(null);
			txt_seguro.setBackground(new Color(191, 231, 249));
			txt_seguro.setBounds(224, 333, 225, 34);
			contentPanel.add(txt_seguro);
		}
		
		JLabel lbl_telefono = new JLabel("Teléfono");
		lbl_telefono.setForeground(new Color(0, 128, 192));
		lbl_telefono.setFont(new Font("Barlow", Font.BOLD, 22));
		lbl_telefono.setBounds(69, 380, 126, 44);
		contentPanel.add(lbl_telefono);
		
		txt_telefono = new JTextField();
		txt_telefono.setText("662 59 25 50");
		txt_telefono.setHorizontalAlignment(SwingConstants.CENTER);
		txt_telefono.setFont(new Font("Arial", Font.PLAIN, 14));
		txt_telefono.setEditable(false);
		txt_telefono.setColumns(10);
		txt_telefono.setBorder(null);
		txt_telefono.setBackground(new Color(191, 231, 249));
		txt_telefono.setBounds(224, 378, 225, 34);
		contentPanel.add(txt_telefono);
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

	public JTextField getTxt_genero() {
		return txt_genero;
	}

	public void setTxt_genero(String txt_genero) {
		this.txt_genero.setText(txt_genero);;
	}

	public JTextField getTxt_estado() {
		return txt_estado;
	}

	public void setTxt_estado(String txt_estado) {
		this.txt_estado.setText(txt_estado);;
	}

	public JTextField getTxt_seguro() {
		return txt_seguro;
	}

	public void setTxt_seguro(String txt_seguro) {
		this.txt_seguro.setText(txt_seguro);;
	}

	public JTextField getTxt_telefono() {
		return txt_telefono;
	}

	public void setTxt_telefono(String txt_telefono) {
		this.txt_telefono.setText(txt_telefono);;
	}
	
}

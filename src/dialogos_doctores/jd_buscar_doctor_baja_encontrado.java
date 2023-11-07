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
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class jd_buscar_doctor_baja_encontrado extends JDialog {

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
			jd_buscar_doctor_baja_encontrado dialog = new jd_buscar_doctor_baja_encontrado();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public jd_buscar_doctor_baja_encontrado() {
		setTitle("Doctor encontrado");
		setIconImage(Toolkit.getDefaultToolkit().getImage(jd_buscar_doctor_baja_encontrado.class.getResource("/iconos_menus/dentilaxIcono.png")));
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
			JLabel lbl_coincidencia_encontrada = new JLabel("COINCIDENCIA ENCONTRADA:");
			lbl_coincidencia_encontrada.setFont(new Font("Barlow", Font.BOLD, 20));
			lbl_coincidencia_encontrada.setBounds(35, 35, 261, 42);
			contentPanel.add(lbl_coincidencia_encontrada);
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
			panel.setBounds(0, 24, 359, 64);
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
				JButton btn_baja = new JButton("DAR DE BAJA");
				btn_baja.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				btn_baja.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				btn_baja.setBorderPainted(false);
				btn_baja.setFont(new Font("Barlow", Font.BOLD, 20));
				btn_baja.setForeground(new Color(255, 255, 255));
				btn_baja.setBackground(new Color(32, 160, 216));
				btn_baja.setBounds(20, 0, 153, 43);
				btn_baja.setActionCommand("OK");
				buttonPane.add(btn_baja);
				
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
			
			JButton btn_ficha = new JButton("FICHA");
			btn_ficha.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btn_ficha.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					jd_buscar_dr_ficha ventana = new jd_buscar_dr_ficha();
					ventana.setVisible(true);
				}
			});
			btn_ficha.setForeground(Color.WHITE);
			btn_ficha.setFont(new Font("Barlow", Font.BOLD, 20));
			btn_ficha.setBorderPainted(false);
			btn_ficha.setBackground(new Color(32, 160, 216));
			btn_ficha.setActionCommand("OK");
			btn_ficha.setBounds(194, 0, 153, 43);
			buttonPane.add(btn_ficha);
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

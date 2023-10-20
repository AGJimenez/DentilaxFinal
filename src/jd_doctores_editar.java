


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
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Enumeration;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class jd_doctores_editar extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private final ButtonGroup btn_group_genero = new ButtonGroup();
	private JTextField txt_nombre;
	private JTextField txt_dni;
	private JTextField txt_telefono;
	private JTextField txt_especialidad;
	private JTextField txt_salario;
	private JTextField txt_apellidos;
	private JTextField txt_nacimiento;
	private JTextField txt_correo;
	private JTextField txt_direccion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			jd_doctores_editar dialog = new jd_doctores_editar();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public jd_doctores_editar() {
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
			
			JRadioButton rbtn_varon = new JRadioButton("Varón");
			btn_group_genero.add(rbtn_varon);
			rbtn_varon.setOpaque(false);
			rbtn_varon.setFont(new Font("Arial", Font.PLAIN, 14));
			rbtn_varon.setBounds(24, 24, 71, 23);
			panel.add(rbtn_varon);
			
			JRadioButton rbtn_mujer = new JRadioButton("Mujer");
			btn_group_genero.add(rbtn_mujer);
			rbtn_mujer.setOpaque(false);
			rbtn_mujer.setFont(new Font("Tahoma", Font.PLAIN, 14));
			rbtn_mujer.setBounds(24, 60, 71, 23);
			panel.add(rbtn_mujer);
			
			JRadioButton rbtn_otro = new JRadioButton("Otro");
			btn_group_genero.add(rbtn_otro);
			rbtn_otro.setOpaque(false);
			rbtn_otro.setFont(new Font("Arial", Font.PLAIN, 14));
			rbtn_otro.setBounds(24, 100, 71, 23);
			panel.add(rbtn_otro);
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
			txt_nombre.setText("Edita el nombre del doctor");
			txt_nombre.setBorder(null);
			txt_nombre.setBackground(new Color(191, 231, 249));
			txt_nombre.setBounds(387, 58, 218, 40);
			contentPanel.add(txt_nombre);
			txt_nombre.setColumns(10);
		}
		{
			txt_dni = new JTextField();
			txt_dni.setText("Edita el dni");
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
			txt_telefono.setText("Edita el telefono");
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
			txt_especialidad.setText("Edita la especialidad");
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
			txt_salario.setText("Edita el salario");
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
			txt_apellidos.setText("Edita los apellidos del doctor");
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
			txt_nacimiento = new JTextField();
			txt_nacimiento.setText("Edita la fecha de nacimiento");
			txt_nacimiento.setHorizontalAlignment(SwingConstants.CENTER);
			txt_nacimiento.setFont(new Font("Arial", Font.PLAIN, 14));
			txt_nacimiento.setColumns(10);
			txt_nacimiento.setBorder(null);
			txt_nacimiento.setBackground(new Color(191, 231, 249));
			txt_nacimiento.setBounds(834, 120, 218, 40);
			contentPanel.add(txt_nacimiento);
		}
		{
			txt_correo = new JTextField();
			txt_correo.setText("Edita el correo");
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
			txt_direccion = new JTextField();
			txt_direccion.setText("Edita la direccion");
			txt_direccion.setHorizontalAlignment(SwingConstants.CENTER);
			txt_direccion.setFont(new Font("Arial", Font.PLAIN, 14));
			txt_direccion.setColumns(10);
			txt_direccion.setBorder(null);
			txt_direccion.setBackground(new Color(191, 231, 249));
			txt_direccion.setBounds(834, 249, 218, 40);
			contentPanel.add(txt_direccion);
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
			JButton btn_anadir = new JButton("MODIFICAR");
			btn_anadir.setBounds(665, 336, 153, 43);
			contentPanel.add(btn_anadir);
			btn_anadir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//sql
					String nombre = txt_nombre.getText().toString();
					String apellidos = txt_apellidos.getText().toString();
					String dni = txt_dni.getText().toString();
					String nacimiento = txt_nacimiento.getText().toString();
					String telefono = txt_telefono.getText().toString();
					String correo = txt_correo.getText().toString();
					String especialidad = txt_especialidad.getText().toString();
					String estado = "alta";
					String direccion = txt_direccion.getText().toString();
					String salario = txt_salario.getText().toString();
					String genero="";
					String btn_seleccionado = getSelectedButton(btn_group_genero);
					String contrasena = JOptionPane.showInputDialog("Introduce contraseña para el login");
		            if (btn_seleccionado != null) {
		                if (btn_seleccionado.equals("Varón")) {
		                    // Realizar alguna acción si se selecciona "Varón"
		                    System.out.println("Varón seleccionado");
		                    genero = "Varón";
		                } else if (btn_seleccionado.equals("Mujer")) {
		                    // Realizar alguna acción si se selecciona "Mujer"
		                    System.out.println("Mujer seleccionada");
		                    genero = "Mujer";
		                } else if (btn_seleccionado.equals("Otro")) {
		                    // Realizar alguna acción si se selecciona "Otro"
		                    System.out.println("Otro seleccionado");
		                    genero = "Otro";
		                }
		            }//acaba el primer if

		            ConectorDB_mysql bdd = new ConectorDB_mysql();
		            try {
						bdd.editar_doctor(dni, apellidos, nombre, nacimiento, telefono, correo, especialidad, direccion, salario, genero);
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		            
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

	public JTextField getTxt_nombre() {
		return txt_nombre;
	}

	public void setTxt_nombre(String txt_nombre) {
		this.txt_nombre.setText(txt_nombre);
	}

	public JTextField getTxt_dni() {
		return txt_dni;
	}

	public void setTxt_dni(String txt_dni) {
		this.txt_dni.setText(txt_dni);
	}

	public JTextField getTxt_telefono() {
		return txt_telefono;
	}

	public void setTxt_telefono(String txt_telefono) {
		this.txt_telefono.setText(txt_telefono);
	}

	public JTextField getTxt_especialidad() {
		return txt_especialidad;
	}

	public void setTxt_especialidad(String txt_especialidad) {
		this.txt_especialidad.setText(txt_especialidad);
	}

	public JTextField getTxt_salario() {
		return txt_salario;
	}

	public void setTxt_salario(String txt_salario) {
		this.txt_salario.setText(txt_salario);
	}

	public JTextField getTxt_apellidos() {
		return txt_apellidos;
	}

	public void setTxt_apellidos(String txt_apellidos) {
		this.txt_apellidos.setText(txt_apellidos);
	}

	public JTextField getTxt_nacimiento() {
		return txt_nacimiento;
	}

	public void setTxt_nacimiento(String txtIntroduceFechaDe) {
		this.txt_nacimiento.setText(txtIntroduceFechaDe);
	}

	public JTextField getTxt_correo() {
		return txt_correo;
	}

	public void setTxt_correo(String txt_correo) {
		this.txt_correo.setText(txt_correo);;
	}

	public JTextField getTxt_direccion() {
		return txt_direccion;
	}

	public void setTxt_direccion(String txtLineaDeDireccin) {
		this.txt_direccion.setText(txtLineaDeDireccin);;
	}
	
	
	

	public String getSelectedButton(ButtonGroup buttonGroup) {
	    for (Enumeration<AbstractButton> botones = buttonGroup.getElements(); botones.hasMoreElements();) {
	        AbstractButton button = botones.nextElement();

	        if (button.isSelected()) {
	            return button.getText(); // O devuelve cualquier otra propiedad que necesites
	        }
	    }
	    return null; // O devuelve un valor predeterminado si no hay ningún botón seleccionado
	}
	
}

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
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.SQLException;
import java.util.Enumeration;
import java.awt.Toolkit;
import javax.swing.JTextArea;

public class jd_pacientes_alta extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private final ButtonGroup btn_group_genero = new ButtonGroup();
	private JTextField txt_nombre;
	private JTextField txt_dni;
	private JTextField txt_telefono;
	private JTextField txt_seguro;
	private JTextArea txt_observaciones;
	private JTextField txt_apellidos;
	private JTextField txt_nacimiento;
	private JTextField txt_correo;
	private JTextField txt_direccion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			jd_pacientes_alta dialog = new jd_pacientes_alta();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public jd_pacientes_alta() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(jd_pacientes_alta.class.getResource("/iconos_menus/dentilaxIcono.png")));
		setTitle("Alta de paciente");
		setModal(true);
		setResizable(false);
		setPreferredSize(new Dimension(1192, 529));
		setBounds(100, 100, 1192, 560);
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
			
			JRadioButton btn_genero_varon = new JRadioButton("Varón");
			btn_group_genero.add(btn_genero_varon);
			btn_genero_varon.setOpaque(false);
			btn_genero_varon.setFont(new Font("Arial", Font.PLAIN, 14));
			btn_genero_varon.setBounds(24, 24, 71, 23);
			panel.add(btn_genero_varon);
			
			JRadioButton btn_genero_mujer = new JRadioButton("Mujer");
			btn_group_genero.add(btn_genero_mujer);
			btn_genero_mujer.setOpaque(false);
			btn_genero_mujer.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btn_genero_mujer.setBounds(24, 60, 71, 23);
			panel.add(btn_genero_mujer);
			
			JRadioButton btn_genero_otro = new JRadioButton("Otro");
			btn_group_genero.add(btn_genero_otro);
			btn_genero_otro.setOpaque(false);
			btn_genero_otro.setFont(new Font("Arial", Font.PLAIN, 14));
			btn_genero_otro.setBounds(24, 100, 71, 23);
			panel.add(btn_genero_otro);
		}
		{
			JLabel lbl_nombre_dr = new JLabel("NOMBRE");
			lbl_nombre_dr.setFont(new Font("Barlow", Font.BOLD, 20));
			lbl_nombre_dr.setBounds(233, 58, 83, 40);
			contentPanel.add(lbl_nombre_dr);
		}
		{
			txt_nombre = new JTextField();
			txt_nombre.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent e) {
					if(txt_nombre.getText().equals("Introduce el nombre del paciente")) {
						txt_nombre.setText("");
					}
				}
				@Override
				public void focusLost(FocusEvent e) {
					if (txt_nombre.getText().isEmpty()) {
						txt_nombre.setText("Introduce el nombre del paciente");
					}
					
				}
			});
			txt_nombre.setHorizontalAlignment(SwingConstants.CENTER);
			txt_nombre.setFont(new Font("Arial", Font.PLAIN, 14));
			txt_nombre.setText("Introduce el nombre del paciente");
			txt_nombre.setBorder(null);
			txt_nombre.setBackground(new Color(191, 231, 249));
			txt_nombre.setBounds(387, 58, 218, 40);
			contentPanel.add(txt_nombre);
			txt_nombre.setColumns(10);
		}
		{
			txt_dni = new JTextField();
			txt_dni.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent e) {
					if(txt_dni.getText().equals("Introduce el DNI")) {
						txt_dni.setText("");
					}
					
				}
				@Override
				public void focusLost(FocusEvent e) {
					if (txt_dni.getText().isEmpty()) {
						txt_dni.setText("Introduce el DNI");
					}
				}
			});
			txt_dni.setText("Introduce el DNI");
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
			txt_telefono.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent e) {
					if(txt_telefono.getText().equals("Introduce el telefono")) {
						txt_telefono.setText("");
					}
					
				}
				@Override
				public void focusLost(FocusEvent e) {
					if (txt_telefono.getText().isEmpty()) {
						txt_telefono.setText("Introduce el telefono");
					}
				}
			});
			txt_telefono.setText("Introduce el telefono");
			txt_telefono.setHorizontalAlignment(SwingConstants.CENTER);
			txt_telefono.setFont(new Font("Arial", Font.PLAIN, 14));
			txt_telefono.setColumns(10);
			txt_telefono.setBorder(null);
			txt_telefono.setBackground(new Color(191, 231, 249));
			txt_telefono.setBounds(387, 184, 218, 40);
			contentPanel.add(txt_telefono);
		}
		{
			JLabel lbl_seguro = new JLabel("SEGURO");
			lbl_seguro.setFont(new Font("Barlow", Font.BOLD, 20));
			lbl_seguro.setBounds(233, 245, 83, 40);
			contentPanel.add(lbl_seguro);
		}
		{
			txt_seguro = new JTextField();
			txt_seguro.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent e) {
					if(txt_seguro.getText().equals("Introduce el seguro")) {
						txt_seguro.setText("");
					}
				}
				@Override
				public void focusLost(FocusEvent e) {
					if (txt_seguro.getText().isEmpty()) {
						txt_seguro.setText("Introduce el seguro");
					}
					
				}
			});
			txt_seguro.setText("Introduce el seguro");
			txt_seguro.setHorizontalAlignment(SwingConstants.CENTER);
			txt_seguro.setFont(new Font("Arial", Font.PLAIN, 14));
			txt_seguro.setColumns(10);
			txt_seguro.setBorder(null);
			txt_seguro.setBackground(new Color(191, 231, 249));
			txt_seguro.setBounds(387, 249, 218, 40);
			contentPanel.add(txt_seguro);
		}
		{
			txt_observaciones = new JTextArea();
			txt_observaciones.setText("Introduce la observacion");
			txt_observaciones.setFont(new Font("Arial", Font.PLAIN, 14));
			txt_observaciones.setColumns(10);
			txt_observaciones.setBorder(null);
			txt_observaciones.setBackground(new Color(191, 231, 249));
			txt_observaciones.setBounds(233, 339, 819, 96);
			contentPanel.add(txt_observaciones);
		}
		{
			JLabel lbl_apellidos = new JLabel("APELLIDOS");
			lbl_apellidos.setFont(new Font("Barlow", Font.BOLD, 20));
			lbl_apellidos.setBounds(665, 58, 100, 40);
			contentPanel.add(lbl_apellidos);
		}
		{
			txt_apellidos = new JTextField();
			txt_apellidos.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent e) {
					if(txt_apellidos.getText().equals("Introduce los apellidos del paciente")) {
						txt_apellidos.setText("");
					}
				}
				@Override
				public void focusLost(FocusEvent e) {
					if (txt_apellidos.getText().isEmpty()) {
						txt_apellidos.setText("Introduce los apellidos del paciente");
					}
				}
			});
			txt_apellidos.setText("Introduce los apellidos del paciente");
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
			txt_nacimiento.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent e) {
					if(txt_nacimiento.getText().equals("Introduce la fecha de nacimiento")) {
						txt_nacimiento.setText("");
					}
					
				}
				@Override
				public void focusLost(FocusEvent e) {
					if (txt_nacimiento.getText().isEmpty()) {
						txt_nacimiento.setText("Introduce la fecha de nacimiento");
					}
				}
			});
			txt_nacimiento.setText("Introduce la fecha de nacimiento");
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
			txt_correo.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent e) {
					if(txt_correo.getText().equals("Introduce el correo")) {
						txt_correo.setText("");
					}
				}
				@Override
				public void focusLost(FocusEvent e) {
					if (txt_correo.getText().isEmpty()) {
						txt_correo.setText("Introduce el correo");
					}
					
				}
			});
			txt_correo.setText("Introduce el correo");
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
			txt_direccion.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent e) {
					if(txt_direccion.getText().equals("Introduce la direccion")) {
						txt_direccion.setText("");
					}
				}
				@Override
				public void focusLost(FocusEvent e) {
	        		 if (txt_direccion.getText().isEmpty()) {
	        			 txt_direccion.setText("Introduce la direccion");
	        		 }
					
				}
			});
			txt_direccion.setText("Introduce la direccion");
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
			JPanel panel_foto = new JPanel();
			panel_foto.setBounds(54, 263, 116, 116);
			contentPanel.add(panel_foto);
		}
		{
			JButton btn_anadir = new JButton("AÑADIR");
			btn_anadir.setBounds(708, 455, 153, 43);
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
					String seguro = txt_seguro.getText().toString();
					String estado = "alta";
					String direccion = txt_direccion.getText().toString();
					String observacion = txt_observaciones.getText().toString();
					String genero="";
					String btn_seleccionado = getSelectedButton(btn_group_genero);
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
						bdd.insertar_paciente(dni, nombre, apellidos, nacimiento, genero, estado, telefono, correo, direccion, seguro, observacion);				
						dispose();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						
					}
					dispose();
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
			JButton btn_cancelar = new JButton("CANCELAR");
			btn_cancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btn_cancelar.setBounds(899, 455, 153, 43);
			btn_cancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btn_cancelar.setBorderPainted(false);
			btn_cancelar.setFont(new Font("Barlow", Font.BOLD, 20));
			btn_cancelar.setForeground(new Color(255, 255, 255));
			btn_cancelar.setBackground(new Color(32, 160, 216));
			contentPanel.add(btn_cancelar);
			btn_cancelar.setActionCommand("Cancel");
		}
		
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

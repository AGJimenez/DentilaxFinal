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
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class jd_buscar_consulta_eliminar_encontrada extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txt_fecha;
	private JTextField txt_doctor;
	private JTextField txt_paciente;
	private JTextField lbl_id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			jd_buscar_consulta_eliminar_encontrada dialog = new jd_buscar_consulta_eliminar_encontrada();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public jd_buscar_consulta_eliminar_encontrada() {
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
			txt_fecha = new JTextField();
			txt_fecha.setEditable(false);
			txt_fecha.setBorder(null);
			txt_fecha.setBackground(new Color(191, 231, 249));
			txt_fecha.setFont(new Font("Arial", Font.PLAIN, 14));
			txt_fecha.setHorizontalAlignment(SwingConstants.CENTER);
			
			txt_fecha.setBounds(21, 177, 83, 34);
			contentPanel.add(txt_fecha);
			txt_fecha.setColumns(10);
		}
		{
			txt_doctor = new JTextField();
			txt_doctor.setEditable(false);
			txt_doctor.setBorder(null);
			txt_doctor.setBackground(new Color(191, 231, 249));
			txt_doctor.setFont(new Font("Arial", Font.PLAIN, 14));
			txt_doctor.setHorizontalAlignment(SwingConstants.CENTER);
			txt_doctor.setBounds(124, 177, 146, 34);
			contentPanel.add(txt_doctor);
			txt_doctor.setColumns(10);
		}
		{
			txt_paciente = new JTextField();
			txt_paciente.setEditable(false);
			txt_paciente.setHorizontalAlignment(SwingConstants.CENTER);
			txt_paciente.setBorder(null);
			txt_paciente.setBackground(new Color(191, 231, 249));
			txt_paciente.setFont(new Font("Arial", Font.PLAIN, 14));
			txt_paciente.setBounds(291, 177, 225, 34);
			contentPanel.add(txt_paciente);
			txt_paciente.setColumns(10);
		}
		
		lbl_id = new JTextField();
		lbl_id.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_id.setFont(new Font("Arial", Font.PLAIN, 14));
		lbl_id.setEditable(false);
		lbl_id.setColumns(10);
		lbl_id.setBorder(null);
		lbl_id.setBackground(new Color(191, 231, 249));
		lbl_id.setBounds(408, 35, 40, 34);
		contentPanel.add(lbl_id);
		
		JLabel lbl_paciente = new JLabel("ID");
		lbl_paciente.setForeground(new Color(0, 128, 192));
		lbl_paciente.setFont(new Font("Barlow", Font.BOLD, 22));
		lbl_paciente.setBounds(350, 24, 48, 44);
		contentPanel.add(lbl_paciente);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 128, 192));
		separator.setBackground(new Color(0, 128, 192));
		separator.setBounds(350, 59, 40, 8);
		contentPanel.add(separator);
		
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
						dentilax_bdd.ConectorDB_mysql consulta_ficha = new dentilax_bdd.ConectorDB_mysql();
						String datos = getLbl_id().getText().toString();
						System.out.println(datos);
						try {
							consulta_ficha.consulta_eliminar_ficha(datos);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}		
						dispose();
						
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
					dentilax_bdd.ConectorDB_mysql consulta_baja = new dentilax_bdd.ConectorDB_mysql();
					jd_buscar_consulta_eliminar ventana = new jd_buscar_consulta_eliminar();
					String datos = getLbl_id().getText().toString();
					System.out.println(datos);
					try {
						int eliminar = JOptionPane.showOptionDialog(
								   getContentPane(),
								   "¿Desea eliminar la cita?", 
								   "Eliminar cita",
								   JOptionPane.YES_NO_OPTION,
								   JOptionPane.QUESTION_MESSAGE,
								   null,
								   new Object[] { "Eliminar", "Cancelar"},
								   "opcion 1"); 	
						if(eliminar==0) {
							consulta_baja.consulta_eliminar_cita(datos);
							JOptionPane.showMessageDialog(null, "Cita eliminada");
						}else {
							System.out.println("Cita no eliminada");
						}
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
										
					dispose();
				
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

	public JTextField getTxt_fecha() {
		return txt_fecha;
	}

	public void setTxt_fecha(String FechaSql) {
		this.txt_fecha.setText(FechaSql);
	}

	public JTextField getTxt_doctor() {
		return txt_doctor;
	}

	public void setTxt_doctor(String DoctorSql) {
		this.txt_doctor.setText(DoctorSql);
	}

	public JTextField getTxt_paciente() {
		return txt_paciente;
	}

	public void setTxt_paciente(String PacienteSql) {
		this.txt_paciente.setText(PacienteSql);
	}

	public JTextField getLbl_id() {
		return lbl_id;
	}

	public void setLbl_id(String ID) {
		this.lbl_id.setText(ID);;
	}
}

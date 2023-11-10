package dialogos_consultas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.Cursor;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JCalendar;
import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class jd_nueva_consulta extends JDialog {
	JButton okButton;
	JButton btn_hora9;
	JButton btn_hora10;
	JButton btn_hora11;
	JButton btn_hora12;
	JButton btn_hora13;
	JButton btn_hora14;
	JButton btn_hora15;
	JButton btn_hora16;
	JButton btn_hora17;
	JButton btn_hora18;
	JButton btn_hora19;
	JButton btn_hora20;
	JButton btn_hora21;
	
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txt_fecha;
	dentilax_bdd.ConectorDB_mysql consultasDB = new dentilax_bdd.ConectorDB_mysql();
	private JTextField txt_hora;
	JComboBox cb_paciente = new JComboBox();
	JComboBox cb_doctor = new JComboBox();
	JComboBox cb_especialidad = new JComboBox();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			jd_nueva_consulta dialog = new jd_nueva_consulta();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public jd_nueva_consulta() {
		try {
			//CON ESTO MOSTRAMOS LOS COMBO BOX
			consultasDB.mostarCbCitasPac(this);
			consultasDB.mostarCbCitasDr(this);
			consultasDB.mostarCbCitasEsp(this);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setUndecorated(true);
		setBounds(100, 100, 1100, 600);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(this);
		
		txt_hora = new JTextField();
		txt_hora.setHorizontalAlignment(SwingConstants.CENTER);
		txt_hora.setFont(new Font("Arial", Font.BOLD, 14));
		txt_hora.setEditable(false);
		txt_hora.setBorder(null);
		txt_hora.setBackground(new Color(191, 231, 249));
		txt_hora.setColumns(10);
		txt_hora.setBounds(925, 416, 120, 37);
		contentPanel.add(txt_hora);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.WHITE);
			buttonPane.setBounds(0, 519, 1100, 57);
			contentPanel.add(buttonPane);
			buttonPane.setLayout(null);
			{
				okButton = new JButton("CONFIRMAR");
				
				
				okButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				okButton.setForeground(Color.WHITE);
				okButton.setFont(new Font("Barlow", Font.BOLD, 20));
				okButton.setBorder(null);
				okButton.setBorderPainted(false);
				okButton.setBackground(new Color(32, 160, 216));
				okButton.setBounds(712, 0, 153, 43);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("CANCELAR");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setFont(new Font("Barlow", Font.BOLD, 20));
				cancelButton.setForeground(Color.WHITE);
				cancelButton.setBorder(null);
				cancelButton.setBorderPainted(false);
				cancelButton.setBackground(new Color(32, 160, 216));
				cancelButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				cancelButton.setBounds(893, 0, 153, 43);
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		
		cb_paciente.setFont(new Font("Arial", Font.PLAIN, 14));
		cb_paciente.setBackground(new Color(191, 231, 249));
		cb_paciente.setBounds(248, 91, 248, 37);
		contentPanel.add(cb_paciente);
		
	
		cb_doctor.setFont(new Font("Arial", Font.PLAIN, 14));
		cb_doctor.setBackground(new Color(191, 231, 249));
		cb_doctor.setBounds(248, 153, 248, 37);
		contentPanel.add(cb_doctor);
		
	
		cb_especialidad.setFont(new Font("Arial", Font.PLAIN, 14));
		cb_especialidad.setBackground(new Color(191, 231, 249));
		cb_especialidad.setBounds(248, 214, 248, 37);
		contentPanel.add(cb_especialidad);
		
		JLabel lbl_paciente = new JLabel("PACIENTE");
		lbl_paciente.setForeground(new Color(32, 160, 216));
		lbl_paciente.setFont(new Font("Barlow", Font.BOLD, 20));
		lbl_paciente.setBounds(61, 88, 142, 40);
		contentPanel.add(lbl_paciente);
		
		JLabel lbl_doctor = new JLabel("DOCTOR");
		lbl_doctor.setForeground(new Color(32, 160, 216));
		lbl_doctor.setFont(new Font("Barlow", Font.BOLD, 20));
		lbl_doctor.setBounds(61, 150, 79, 40);
		contentPanel.add(lbl_doctor);
		
		JLabel lbl_especialidad = new JLabel("ESPECIALIDAD");
		lbl_especialidad.setForeground(new Color(32, 160, 216));
		lbl_especialidad.setFont(new Font("Barlow", Font.BOLD, 20));
		lbl_especialidad.setBounds(61, 211, 142, 40);
		contentPanel.add(lbl_especialidad);
		
		btn_hora9 = new JButton("10:00");
		btn_hora9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txt_hora.setText("10:00");
			}
		});
		btn_hora9.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_hora9.setBorderPainted(false);
		btn_hora9.setBorder(null);
		btn_hora9.setFont(new Font("Barlow", Font.BOLD, 20));
		btn_hora9.setForeground(Color.WHITE);
		btn_hora9.setBackground(new Color(32, 160, 216));
		btn_hora9.setBounds(559, 136, 120, 37);
		contentPanel.add(btn_hora9);
		
		JCalendar calendar = new JCalendar();
		calendar.getYearChooser().setBackground(new Color(32, 160, 216));
		calendar.getYearChooser().setFont(new Font("Arial", Font.PLAIN, 14));
		calendar.getYearChooser().getSpinner().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		calendar.getMonthChooser().getComboBox().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		calendar.getMonthChooser().getComboBox().setBackground(Color.WHITE);
		calendar.getMonthChooser().getSpinner().setFont(new Font("Arial", Font.PLAIN, 14));
		calendar.getDayChooser().setBorder(null);
		calendar.getDayChooser().setWeekdayForeground(Color.WHITE);
		calendar.getDayChooser().setDecorationBackgroundColor(new Color(32, 160, 216));
		calendar.getDayChooser().setForeground(Color.BLACK);
		calendar.getDayChooser().setFont(new Font("Arial", Font.BOLD, 14));
		calendar.getDayChooser().getDayPanel().setFont(new Font("Arial", Font.PLAIN, 14));
		calendar.getMonthChooser().getComboBox().setFont(new Font("Arial", Font.PLAIN, 14));
		calendar.getYearChooser().getSpinner().setFont(new Font("Arial", Font.PLAIN, 14));
		calendar.getYearChooser().getSpinner().setBackground(Color.WHITE);
		calendar.getDayChooser().getDayPanel().setBackground(new Color(255, 255, 255));
		calendar.setBounds(61, 297, 438, 211);
		contentPanel.add(calendar);
		
		
		
		
		btn_hora10 = new JButton("11:00");
		btn_hora10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txt_hora.setText("11:00");
			}
		});
		btn_hora10.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_hora10.setBorderPainted(false);
		btn_hora10.setBorder(null);
		btn_hora10.setFont(new Font("Barlow", Font.BOLD, 20));
		btn_hora10.setForeground(Color.WHITE);
		btn_hora10.setBackground(new Color(32, 160, 216));
		btn_hora10.setBounds(742, 137, 120, 37);
		contentPanel.add(btn_hora10);
		
		btn_hora11 = new JButton("12:00");
		btn_hora11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txt_hora.setText("12:00");
			}
		});
		btn_hora11.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_hora11.setBorderPainted(false);
		btn_hora11.setBorder(null);
		btn_hora11.setFont(new Font("Barlow", Font.BOLD, 20));
		btn_hora11.setForeground(Color.WHITE);
		btn_hora11.setBackground(new Color(32, 160, 216));
		btn_hora11.setBounds(925, 137, 120, 37);
		contentPanel.add(btn_hora11);
		
		btn_hora12 = new JButton("13:00");
		btn_hora12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txt_hora.setText("13:00");
			}
		});
		btn_hora12.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_hora12.setBorderPainted(false);
		btn_hora12.setBorder(null);
		btn_hora12.setFont(new Font("Barlow", Font.BOLD, 20));
		btn_hora12.setForeground(Color.WHITE);
		btn_hora12.setBackground(new Color(32, 160, 216));
		btn_hora12.setBounds(559, 199, 120, 37);
		contentPanel.add(btn_hora12);
		
		btn_hora13 = new JButton("14:00");
		btn_hora13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txt_hora.setText("14:00");
			}
		});
		btn_hora13.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_hora13.setBorderPainted(false);
		btn_hora13.setBorder(null);
		btn_hora13.setFont(new Font("Barlow", Font.BOLD, 20));
		btn_hora13.setForeground(Color.WHITE);
		btn_hora13.setBackground(new Color(32, 160, 216));
		btn_hora13.setBounds(742, 200, 120, 37);
		contentPanel.add(btn_hora13);
		
		btn_hora14 = new JButton("15:00");
		btn_hora14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txt_hora.setText("15:00");
			}
		});
		btn_hora14.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_hora14.setBorderPainted(false);
		btn_hora14.setBorder(null);
		btn_hora14.setFont(new Font("Barlow", Font.BOLD, 20));
		btn_hora14.setForeground(Color.WHITE);
		btn_hora14.setBackground(new Color(32, 160, 216));
		btn_hora14.setBounds(925, 200, 120, 37);
		contentPanel.add(btn_hora14);
		
		btn_hora15 = new JButton("16:00");
		btn_hora15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txt_hora.setText("16:00");
			}
		});
		btn_hora15.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_hora15.setBorderPainted(false);
		btn_hora15.setBorder(null);
		btn_hora15.setFont(new Font("Barlow", Font.BOLD, 20));
		btn_hora15.setForeground(Color.WHITE);
		btn_hora15.setBackground(new Color(32, 160, 216));
		btn_hora15.setBounds(559, 261, 120, 37);
		contentPanel.add(btn_hora15);
		
		btn_hora16 = new JButton("17:00");
		btn_hora16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txt_hora.setText("17:00");
			}
		});
		btn_hora16.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_hora16.setBorderPainted(false);
		btn_hora16.setBorder(null);
		btn_hora16.setFont(new Font("Barlow", Font.BOLD, 20));
		btn_hora16.setForeground(Color.WHITE);
		btn_hora16.setBackground(new Color(32, 160, 216));
		btn_hora16.setBounds(742, 262, 120, 37);
		contentPanel.add(btn_hora16);
		
		btn_hora17 = new JButton("18:00");
		btn_hora17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txt_hora.setText("18:00");
			}
		});
		btn_hora17.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_hora17.setBorderPainted(false);
		btn_hora17.setBorder(null);
		btn_hora17.setFont(new Font("Barlow", Font.BOLD, 20));
		btn_hora17.setForeground(Color.WHITE);
		btn_hora17.setBackground(new Color(32, 160, 216));
		btn_hora17.setBounds(925, 262, 120, 37);
		contentPanel.add(btn_hora17);
		
		btn_hora18 = new JButton("19:00");
		btn_hora18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txt_hora.setText("19:00");
			}
		});
		btn_hora18.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_hora18.setBorderPainted(false);
		btn_hora18.setBorder(null);
		btn_hora18.setFont(new Font("Barlow", Font.BOLD, 20));
		btn_hora18.setForeground(Color.WHITE);
		btn_hora18.setBackground(new Color(32, 160, 216));
		btn_hora18.setBounds(559, 322, 120, 37);
		contentPanel.add(btn_hora18);
		
		btn_hora19 = new JButton("20:00");
		btn_hora19.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txt_hora.setText("20:00");
			}
		});
		btn_hora19.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_hora19.setBorderPainted(false);
		btn_hora19.setBorder(null);
		btn_hora19.setFont(new Font("Barlow", Font.BOLD, 20));
		btn_hora19.setForeground(Color.WHITE);
		btn_hora19.setBackground(new Color(32, 160, 216));
		btn_hora19.setBounds(742, 323, 120, 37);
		contentPanel.add(btn_hora19);
		
		btn_hora20 = new JButton("21:00");
		btn_hora20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txt_hora.setText("21:00");
			}
		});
		btn_hora20.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_hora20.setBorderPainted(false);
		btn_hora20.setBorder(null);
		btn_hora20.setFont(new Font("Barlow", Font.BOLD, 20));
		btn_hora20.setForeground(Color.WHITE);
		btn_hora20.setBackground(new Color(32, 160, 216));
		btn_hora20.setBounds(925, 323, 120, 37);
		contentPanel.add(btn_hora20);
		
		JLabel lbl_hora = new JLabel("HORA");
		lbl_hora.setForeground(new Color(32, 160, 216));
		lbl_hora.setFont(new Font("Barlow", Font.BOLD, 20));
		lbl_hora.setBounds(773, 63, 142, 40);
		contentPanel.add(lbl_hora);
		
		JLabel lbl_seleccion = new JLabel("FECHA Y HORA:");
		lbl_seleccion.setForeground(new Color(32, 160, 216));
		lbl_seleccion.setFont(new Font("Barlow", Font.BOLD, 20));
		lbl_seleccion.setBounds(559, 413, 142, 40);
		contentPanel.add(lbl_seleccion);
		
		txt_fecha = new JTextField();
		txt_fecha.setEditable(false);
		txt_fecha.setFont(new Font("Arial", Font.BOLD, 14));
		txt_fecha.setBorder(null);
		txt_fecha.setBackground(new Color(191, 231, 249));
		txt_fecha.setBounds(742, 416, 120, 37);
		contentPanel.add(txt_fecha);
		txt_fecha.setColumns(10);
		
	/*	String dia = calendar.getDayChooser().toString();
		String mes = calendar.getMonthChooser().toString();
		String anio = calendar.getYearChooser().toString();
		
		String fecha = dia+mes+anio;
		txt_fecha.setText(fecha);
		*/
		
	/*	calendar.getDayChooser().addPropertyChangeListener(new PropertyChangeListener() {
		    @Override
		  
			public void propertyChange(PropertyChangeEvent evt) {
				// TODO Auto-generated method stub
				if (evt.getPropertyName().equals("selectedDate")) {
		            Date selectedDate = (Date) evt.getNewValue();
		            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		            txt_fecha.setText(sdf.format(selectedDate));
		        }
			}
		});*/
		
		// Obtener la fecha seleccionada
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(jd_nueva_consulta.class.getResource("/iconos_menus/fondo (1).png")));
		lblNewLabel.setBounds(0, 0, 1100, 600);
		contentPanel.add(lblNewLabel);
		
		String pacienteSeleccionado = cb_paciente.getSelectedItem().toString();
		String doctorSeleccionado = cb_doctor.getSelectedItem().toString();
		String especialidadteSeleccionado = cb_especialidad.getSelectedItem().toString();
		
		selecionarFecha(calendar);
	        
	    }//llave clase

	private void selecionarFecha(JCalendar calendar) {
		Date fechaSeleccionada = calendar.getDate();
		// Crear un objeto SimpleDateFormat con el formato dd-mm-yyyy
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		// Formatear la fecha seleccionada
		String fechaFormateada = sdf.format(fechaSeleccionada);
		
		txt_fecha.setText(fechaFormateada);

		
	        calendar.getDayChooser().addPropertyChangeListener(
	                new java.beans.PropertyChangeListener() {

	                    @Override
	                    public void propertyChange(java.beans.PropertyChangeEvent evt) {
	                        if (evt.getPropertyName().compareTo("day") == 0) {
	                            SimpleDateFormat formatoDeFecha = new SimpleDateFormat("dd/MM/yyyy");
	                            txt_fecha.setText(formatoDeFecha.format(calendar.getDate()));
	                        }
	                    }
	                });
	        
	        okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					dentilax_bdd.ConectorDB_mysql conect = new dentilax_bdd.ConectorDB_mysql();
					conect.agendar_cita(cb_doctor.getSelectedItem().toString(), txt_fecha.getText().toString(), 
							cb_especialidad.getSelectedItem().toString(), " ",cb_paciente.getSelectedItem().toString(), txt_hora.getText().toString());
							
					
					
				}
			});
	        
	        
	}
	
	public JTextField getTxt_fecha() {
		return txt_fecha;
	}

	public void setTxt_fecha(JTextField txt_fecha) {
		this.txt_fecha = txt_fecha;
	}

	public JTextField getTxt_hora() {
		return txt_hora;
	}

	public void setTxt_hora(JTextField txt_hora) {
		this.txt_hora = txt_hora;
	}

	public JComboBox<String> getCb_paciente() {
        return cb_paciente;
    }

	 public void setCb_paciente(String items) {
		 cb_paciente.addItem(items); 
	    }
	 
	 public JComboBox<String> getCb_especialidad() {
	        return cb_especialidad;
	    }

		 public void setCb_especialidad(String items) {
			 cb_especialidad.addItem(items); 
		    }
		 
		 public JComboBox<String> getCb_doctor() {
		        return cb_doctor;
		    }

			 public void setCb_doctor(String items) {
				 cb_doctor.addItem(items); 
			    }
			 
}

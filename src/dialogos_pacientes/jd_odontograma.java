package dialogos_pacientes;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;
import javax.swing.DropMode;
import javax.swing.JTextField;

public class jd_odontograma extends JDialog {

	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					jd_odontograma dialog = new jd_odontograma();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	private void cargarDatosDiente(int idDiente, JCheckBox chbEmpaste, JCheckBox chbCorona, JCheckBox chbExtraccion, JCheckBox chbAusencia, JCheckBox chbCaries, JCheckBox chbImplante, JCheckBox chbEndo, JCheckBox chbOrtodoncia, JTextArea taObservaciones) {
	    dentilax_bdd.ConectorDB_mysql consulta = new dentilax_bdd.ConectorDB_mysql();
	    ResultSet datosDiente = consulta.obtenerDatosDiente(idDiente);
	    
	    try {
	    	if (datosDiente != null) {
	            while (datosDiente.next()) {
	                chbEmpaste.setSelected("si".equalsIgnoreCase(datosDiente.getString("Empaste")));
	                chbCorona.setSelected("si".equalsIgnoreCase(datosDiente.getString("Corona")));
	                chbExtraccion.setSelected("si".equalsIgnoreCase(datosDiente.getString("Extraccion")));
	                chbAusencia.setSelected("si".equalsIgnoreCase(datosDiente.getString("Ausencia_dental")));
	                chbCaries.setSelected("si".equalsIgnoreCase(datosDiente.getString("Caries")));
	                chbImplante.setSelected("si".equalsIgnoreCase(datosDiente.getString("Implante")));
	                chbEndo.setSelected("si".equalsIgnoreCase(datosDiente.getString("Endodoncia")));
	                chbOrtodoncia.setSelected("si".equalsIgnoreCase(datosDiente.getString("Ortodoncia")));
	                taObservaciones.setText(datosDiente.getString("Observaciones"));
	            }
	        }
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    } finally {
	        // Asegúrate de cerrar el ResultSet en un bloque finally
	        if (datosDiente != null) {
	            try {
	                datosDiente.close();
	            } catch (SQLException ex) {
	                ex.printStackTrace();
	            }
	        }
	    }
	    // Cierra la conexión después de haber terminado de trabajar con el ResultSet
	  
	}

	/**
	 * Create the dialog.
	 */
	public jd_odontograma() {
		
		
		getContentPane().setBackground(new Color(255, 255, 255));
		setTitle("Odontograma");
		setModal(true);
		setBounds(100, 100, 1200, 801);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel.setBackground(Color.WHITE);
		panel.setBounds(529, 41, 582, 653);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lb_diente = new JLabel("Diente");
		lb_diente.setForeground(new Color(0, 128, 192));
		lb_diente.setFont(new Font("Barlow", Font.PLAIN, 24));
		lb_diente.setBounds(250, 35, 149, 23);
		panel.add(lb_diente);
		
		JLabel lblNewLabel_2_1 = new JLabel("Observaciones");
		lblNewLabel_2_1.setFont(new Font("Barlow Light", Font.PLAIN, 20));
		lblNewLabel_2_1.setBounds(218, 79, 149, 23);
		panel.add(lblNewLabel_2_1);
		
		JTextArea ta_observaciones = new JTextArea();
		ta_observaciones.setBorder(new LineBorder(new Color(0, 0, 0)));
		ta_observaciones.setFont(new Font("Arial", Font.PLAIN, 16));
		ta_observaciones.setLineWrap(true);
		ta_observaciones.setBounds(35, 113, 517, 198);
		panel.add(ta_observaciones);
		
		JButton btn_salir = new JButton("SALIR");
		btn_salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btn_salir.setForeground(Color.WHITE);
		btn_salir.setFont(new Font("Barlow", Font.BOLD, 20));
		btn_salir.setBorderPainted(false);
		btn_salir.setBackground(new Color(32, 160, 216));
		btn_salir.setActionCommand("Cancel");
		btn_salir.setBounds(399, 579, 153, 43);
		panel.add(btn_salir);
		
		jd_buscar_paciente_encontrado_menudr prueba = new jd_buscar_paciente_encontrado_menudr();
		String pasado = prueba.getDniPasar().toString();
       // int dniPaciente = Integer.parseInt(pasado);
        System.out.println(pasado);
		
		JButton btn_salir_1 = new JButton("CONFIRMAR");
		btn_salir_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String diente = lb_diente.getText().toString();
				String[]id_spliteado = diente.split(" ");
				String id_dienteString = id_spliteado[1];
				int id_diente = Integer.parseInt(id_dienteString);
				System.out.print(id_diente);
				String observaciones = ta_observaciones.getText().toString();
				
			dentilax_bdd.ConectorDB_mysql consulta = new dentilax_bdd.ConectorDB_mysql();
			//consulta.insertarOdontograma(id_diente, observaciones, dniPaciente);//le paso el dni para buscar la id
				
			}
		});
		btn_salir_1.setForeground(Color.WHITE);
		btn_salir_1.setFont(new Font("Barlow", Font.BOLD, 20));
		btn_salir_1.setBorderPainted(false);
		btn_salir_1.setBackground(new Color(32, 160, 216));
		btn_salir_1.setActionCommand("Cancel");
		btn_salir_1.setBounds(35, 579, 153, 43);
		panel.add(btn_salir_1);
		
		JButton btn_45 = new JButton("45");
		btn_45.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_45.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lb_diente.setText("Diente 45");
				
			}
		});
		btn_45.setFocusPainted(false);
		btn_45.setContentAreaFilled(false);
		btn_45.setBorderPainted(false);
		btn_45.setBounds(67, 449, 54, 29);
		getContentPane().add(btn_45);
		
		JButton btn_34 = new JButton("34");
		btn_34.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_34.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lb_diente.setText("Diente 34");
			}
		});
		btn_34.setFocusPainted(false);
		btn_34.setContentAreaFilled(false);
		btn_34.setBorderPainted(false);
		btn_34.setBounds(325, 550, 54, 50);
		getContentPane().add(btn_34);
		
		JButton btn_31 = new JButton("31");
		btn_31.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_31.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lb_diente.setText("Diente 31");
			}
		});
		btn_31.setFocusPainted(false);
		btn_31.setContentAreaFilled(false);
		btn_31.setBorderPainted(false);
		btn_31.setBounds(166, 571, 54, 50);
		getContentPane().add(btn_31);
		
		JButton btn_42 = new JButton("42");
		btn_42.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_42.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lb_diente.setText("Diente 42");
			}
		});
		btn_42.setHorizontalAlignment(SwingConstants.LEFT);
		btn_42.setFocusPainted(false);
		btn_42.setContentAreaFilled(false);
		btn_42.setBorderPainted(false);
		btn_42.setBounds(67, 555, 54, 40);
		getContentPane().add(btn_42);
		
		JButton btn_47 = new JButton("47");
		btn_47.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_47.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lb_diente.setText("Diente 47");
			}
		});
		btn_47.setFocusPainted(false);
		btn_47.setContentAreaFilled(false);
		btn_47.setBorderPainted(false);
		btn_47.setBounds(110, 407, 52, 29);
		getContentPane().add(btn_47);
		
		JButton btn_38 = new JButton("38");
		btn_38.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_38.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lb_diente.setText("Diente 38");
			}
		});
		btn_38.setFocusPainted(false);
		btn_38.setContentAreaFilled(false);
		btn_38.setBorderPainted(false);
		btn_38.setBounds(395, 433, 54, 29);
		getContentPane().add(btn_38);
		
		JButton btn_37 = new JButton("37");
		btn_37.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_37.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lb_diente.setText("Diente 37");
			}
		});
		btn_37.setFocusPainted(false);
		btn_37.setContentAreaFilled(false);
		btn_37.setBorderPainted(false);
		btn_37.setBounds(385, 458, 54, 29);
		getContentPane().add(btn_37);
		
		JButton btn_33 = new JButton("33");
		btn_33.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_33.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lb_diente.setText("Diente 33");
			}
		});
		btn_33.setFocusPainted(false);
		btn_33.setContentAreaFilled(false);
		btn_33.setBorderPainted(false);
		btn_33.setBounds(275, 576, 54, 50);
		getContentPane().add(btn_33);
		
		JButton btn_41 = new JButton("41");
		btn_41.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_41.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lb_diente.setText("Diente 41");
			}
		});
		btn_41.setFocusPainted(false);
		btn_41.setContentAreaFilled(false);
		btn_41.setBorderPainted(false);
		btn_41.setBounds(110, 571, 54, 29);
		getContentPane().add(btn_41);
		
		JButton btn_43 = new JButton("43");
		btn_43.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_43.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lb_diente.setText("Diente 43");
			}
		});
		btn_43.setFocusPainted(false);
		btn_43.setContentAreaFilled(false);
		btn_43.setBorderPainted(false);
		btn_43.setBounds(21, 517, 54, 50);
		getContentPane().add(btn_43);
		
		JButton btn_46 = new JButton("46");
		btn_46.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_46.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lb_diente.setText("Diente 46");
			}
		});
		btn_46.setFocusPainted(false);
		btn_46.setContentAreaFilled(false);
		btn_46.setBorderPainted(false);
		btn_46.setBounds(87, 435, 54, 22);
		getContentPane().add(btn_46);
		
		JButton btn_48 = new JButton("48");
		btn_48.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_48.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lb_diente.setText("Diente 48");
			}
		});
		btn_48.setFocusPainted(false);
		btn_48.setContentAreaFilled(false);
		btn_48.setBorderPainted(false);
		btn_48.setBounds(140, 379, 54, 29);
		getContentPane().add(btn_48);
		
		JButton btn_36 = new JButton("36");
		btn_36.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_36.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lb_diente.setText("Diente 36");
			}
		});
		btn_36.setFocusPainted(false);
		btn_36.setContentAreaFilled(false);
		btn_36.setBorderPainted(false);
		btn_36.setBounds(379, 498, 52, 34);
		getContentPane().add(btn_36);
		
		JButton btn_35 = new JButton("35");
		btn_35.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_35.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lb_diente.setText("Diente 35");
			}
		});
		btn_35.setFocusPainted(false);
		btn_35.setContentAreaFilled(false);
		btn_35.setBorderPainted(false);
		btn_35.setBounds(348, 521, 62, 42);
		getContentPane().add(btn_35);
		
		JButton btn_44 = new JButton("44");
		btn_44.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_44.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lb_diente.setText("Diente 44");
			}
		});
		btn_44.setFocusPainted(false);
		btn_44.setContentAreaFilled(false);
		btn_44.setBorderPainted(false);
		btn_44.setBounds(57, 475, 54, 29);
		getContentPane().add(btn_44);
		
		JButton btn_32 = new JButton("32");
		btn_32.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_32.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lb_diente.setText("Diente 32");
			}
		});
		btn_32.setFocusPainted(false);
		btn_32.setContentAreaFilled(false);
		btn_32.setBorderPainted(false);
		btn_32.setBounds(220, 571, 54, 50);
		getContentPane().add(btn_32);
		
		JButton btn_18 = new JButton("18");
		btn_18.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lb_diente.setText("Diente 18");
			}
		});
		btn_18.setFocusPainted(false);
		btn_18.setContentAreaFilled(false);
		btn_18.setBorderPainted(false);
		btn_18.setBounds(130, 319, 54, 29);
		getContentPane().add(btn_18);
		
		JButton btn_13 = new JButton("13");
		btn_13.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lb_diente.setText("Diente 13");
			}
		});
		btn_13.setFocusPainted(false);
		btn_13.setContentAreaFilled(false);
		btn_13.setBorderPainted(false);
		btn_13.setBounds(67, 135, 54, 40);
		getContentPane().add(btn_13);
		
		JButton btn_15 = new JButton("15");
		btn_15.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lb_diente.setText("Diente 15");
			}
		});
		btn_15.setFocusPainted(false);
		btn_15.setContentAreaFilled(false);
		btn_15.setBorderPainted(false);
		btn_15.setBounds(77, 223, 54, 29);
		getContentPane().add(btn_15);
		
		JButton btn_16 = new JButton("16");
		btn_16.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lb_diente.setText("Diente 16");
			}
		});
		btn_16.setFocusPainted(false);
		btn_16.setContentAreaFilled(false);
		btn_16.setBorderPainted(false);
		btn_16.setBounds(97, 254, 54, 29);
		getContentPane().add(btn_16);
		
		JButton btn_11 = new JButton("11");
		btn_11.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lb_diente.setText("Diente 11");
			}
		});
		btn_11.setFocusPainted(false);
		btn_11.setContentAreaFilled(false);
		btn_11.setBorderPainted(false);
		btn_11.setBounds(156, 130, 54, 50);
		getContentPane().add(btn_11);
		
		JButton btn_14 = new JButton("14");
		btn_14.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lb_diente.setText("Diente 14");
			}
		});
		btn_14.setFocusPainted(false);
		btn_14.setContentAreaFilled(false);
		btn_14.setBorderPainted(false);
		btn_14.setBounds(87, 186, 54, 40);
		getContentPane().add(btn_14);
		
		JButton btn_17 = new JButton("17");
		btn_17.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lb_diente.setText("Diente 17");
			}
		});
		btn_17.setFocusPainted(false);
		btn_17.setContentAreaFilled(false);
		btn_17.setBorderPainted(false);
		btn_17.setBounds(108, 286, 54, 34);
		getContentPane().add(btn_17);
		
		JButton btn_12 = new JButton("12");
		btn_12.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lb_diente.setText("Diente 12");
			}
		});
		btn_12.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btn_12.setHorizontalAlignment(SwingConstants.LEFT);
		btn_12.setFocusPainted(false);
		btn_12.setContentAreaFilled(false);
		btn_12.setBorderPainted(false);
		btn_12.setBounds(118, 116, 44, 50);
		getContentPane().add(btn_12);
		
		JButton btn_22 = new JButton("22");
		btn_22.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_22.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lb_diente.setText("Diente 22");
			}
		});
		btn_22.setFocusPainted(false);
		btn_22.setContentAreaFilled(false);
		btn_22.setBorderPainted(false);
		btn_22.setBounds(285, 144, 54, 50);
		getContentPane().add(btn_22);
		
		JButton btn_28 = new JButton("28");
		btn_28.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_28.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lb_diente.setText("Diente 28");
			}
		});
		btn_28.setFocusPainted(false);
		btn_28.setContentAreaFilled(false);
		btn_28.setBorderPainted(false);
		btn_28.setBounds(415, 368, 54, 29);
		getContentPane().add(btn_28);
		
		JButton btn_23 = new JButton("23");
		btn_23.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_23.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lb_diente.setText("Diente 23");
			}
		});
		btn_23.setFocusPainted(false);
		btn_23.setContentAreaFilled(false);
		btn_23.setBorderPainted(false);
		btn_23.setBounds(337, 170, 54, 50);
		getContentPane().add(btn_23);
		
		JButton btn_24 = new JButton("24");
		btn_24.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_24.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lb_diente.setText("Diente 24");
			}
		});
		btn_24.setFocusPainted(false);
		btn_24.setContentAreaFilled(false);
		btn_24.setBorderPainted(false);
		btn_24.setBounds(375, 202, 54, 50);
		getContentPane().add(btn_24);
		
		JButton btn_27 = new JButton("27");
		btn_27.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_27.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lb_diente.setText("Diente 27");
			}
		});
		btn_27.setFocusPainted(false);
		btn_27.setContentAreaFilled(false);
		btn_27.setBorderPainted(false);
		btn_27.setBounds(405, 336, 54, 29);
		getContentPane().add(btn_27);
		
		JButton btn_25 = new JButton("25");
		btn_25.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_25.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lb_diente.setText("Diente 25");
			}
		});
		btn_25.setFocusPainted(false);
		btn_25.setContentAreaFilled(false);
		btn_25.setBorderPainted(false);
		btn_25.setBounds(385, 244, 54, 50);
		getContentPane().add(btn_25);
		
		JButton btn_26 = new JButton("26");
		btn_26.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_26.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lb_diente.setText("Diente 26");
			}
		});
		btn_26.setFocusPainted(false);
		btn_26.setContentAreaFilled(false);
		btn_26.setBorderPainted(false);
		btn_26.setBounds(395, 286, 54, 50);
		getContentPane().add(btn_26);
		
		JButton btn_21 = new JButton("21");
		btn_21.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_21.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lb_diente.setText("Diente 21");
			}
		});
		btn_21.setFocusPainted(false);
		btn_21.setBorderPainted(false);
		btn_21.setContentAreaFilled(false);
		btn_21.setBounds(220, 130, 54, 50);
		getContentPane().add(btn_21);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setIcon(new ImageIcon(jd_odontograma.class.getResource("/imagenesOdontograma/bocaBaseOdontograma.png")));
		lblNewLabel.setBounds(0, 11, 519, 700);
		getContentPane().add(lblNewLabel);
		
		
		JLabel lb = new JLabel("");
		lb.setIcon(new ImageIcon(jd_odontograma.class.getResource("/imagenesOdontograma/fondoDental.png")));
		lb.setBounds(0, 0, 1184, 762);
		getContentPane().add(lb);

		
		
	}
	
}

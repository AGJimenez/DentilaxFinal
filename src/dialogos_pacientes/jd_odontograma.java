package dialogos_pacientes;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import Modelo.Inventario;
import Modelo.Odontograma;
import dentilax_bdd.ConectorDB_mysql;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;
import javax.swing.DropMode;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class jd_odontograma extends JDialog {

	private static final long serialVersionUID = 1L;
    private static JTable table;
    private static DefaultTableModel model;
    
    ConectorDB_mysql consulta = new ConectorDB_mysql();
	/**
	 * Launch the application.
	 */
	
	jd_buscar_paciente_encontrado_menudr carga = new jd_buscar_paciente_encontrado_menudr();

   private String cargar;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					jd_odontograma dialog = new jd_odontograma(null);
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	/**
	 * Create the dialog.
	 */
	 public jd_odontograma(String dniPasar) {

	        this.cargar = dniPasar;
	    	int idPacientePorDni = consulta.obtenerIdPacientePorDni(dniPasar);
	    	
	    	System.out.println("consulta de mostrar dientes "+consulta.mostrarDientes(idPacientePorDni));
	    

	    	
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
		
		JTextArea ta_observaciones = new JTextArea();
		ta_observaciones.setBorder(new LineBorder(new Color(0, 0, 0)));
		ta_observaciones.setFont(new Font("Arial", Font.PLAIN, 16));
		ta_observaciones.setLineWrap(true);
		ta_observaciones.setBounds(35, 113, 517, 198);
		panel.add(ta_observaciones);
		
		JLabel lb_diente = new JLabel("Diente");
		lb_diente.setForeground(new Color(0, 128, 192));
		lb_diente.setFont(new Font("Barlow", Font.PLAIN, 24));
		lb_diente.setBounds(250, 35, 149, 23);
		
		JButton btn_34 = new JButton("34");
		btn_34.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_34.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lb_diente.setText("Diente 34");
				List<Odontograma> odontogramasParaDiente = consulta.obtenerOdontogramaPorDiente(34, idPacientePorDni);
				
				llenarTabla(odontogramasParaDiente);
			}
		});
		btn_34.setFocusPainted(false);
		btn_34.setContentAreaFilled(false);
		btn_34.setBorderPainted(false);
		btn_34.setBounds(325, 550, 54, 50);
		getContentPane().add(btn_34);
		
		JButton btn_44 = new JButton("44");
		btn_44.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_44.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lb_diente.setText("Diente 44");
				List<Odontograma> odontogramasParaDiente = consulta.obtenerOdontogramaPorDiente(44,idPacientePorDni);
				llenarTabla(odontogramasParaDiente);
			}
		});
		btn_44.setFocusPainted(false);
		btn_44.setContentAreaFilled(false);
		btn_44.setBorderPainted(false);
		btn_44.setBounds(57, 475, 54, 29);
		getContentPane().add(btn_44);
		
		JButton btn_31 = new JButton("31");
		btn_31.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_31.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lb_diente.setText("Diente 31");
				List<Odontograma> odontogramasParaDiente = consulta.obtenerOdontogramaPorDiente(31,idPacientePorDni);
				llenarTabla(odontogramasParaDiente);
			}
		});
		btn_31.setFocusPainted(false);
		btn_31.setContentAreaFilled(false);
		btn_31.setBorderPainted(false);
		btn_31.setBounds(166, 571, 54, 50);
		getContentPane().add(btn_31);
		
		JButton btn_36 = new JButton("36");
		btn_36.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_36.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lb_diente.setText("Diente 36");
				List<Odontograma> odontogramasParaDiente = consulta.obtenerOdontogramaPorDiente(36,idPacientePorDni);
				llenarTabla(odontogramasParaDiente);
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
				List<Odontograma> odontogramasParaDiente = consulta.obtenerOdontogramaPorDiente(35,idPacientePorDni);
				llenarTabla(odontogramasParaDiente);
			}
		});
		btn_35.setFocusPainted(false);
		btn_35.setContentAreaFilled(false);
		btn_35.setBorderPainted(false);
		btn_35.setBounds(348, 521, 62, 42);
		getContentPane().add(btn_35);
		
		JButton btn_38 = new JButton("38");
		btn_38.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_38.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lb_diente.setText("Diente 38");
				List<Odontograma> odontogramasParaDiente = consulta.obtenerOdontogramaPorDiente(38,idPacientePorDni);
				llenarTabla(odontogramasParaDiente);
			}
		});
		btn_38.setFocusPainted(false);
		btn_38.setContentAreaFilled(false);
		btn_38.setBorderPainted(false);
		btn_38.setBounds(395, 433, 54, 29);
		getContentPane().add(btn_38);
		
		JButton btn_12 = new JButton("12");
		btn_12.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lb_diente.setText("Diente 12");
				List<Odontograma> odontogramasParaDiente = consulta.obtenerOdontogramaPorDiente(12,idPacientePorDni);
				llenarTabla(odontogramasParaDiente);
			}
		});
		btn_12.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btn_12.setHorizontalAlignment(SwingConstants.LEFT);
		btn_12.setFocusPainted(false);
		btn_12.setContentAreaFilled(false);
		btn_12.setBorderPainted(false);
		btn_12.setBounds(118, 116, 44, 50);
		getContentPane().add(btn_12);
		
		JButton btn_33 = new JButton("33");
		btn_33.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_33.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lb_diente.setText("Diente 33");
				List<Odontograma> odontogramasParaDiente = consulta.obtenerOdontogramaPorDiente(33,idPacientePorDni);
				llenarTabla(odontogramasParaDiente);
			}
		});
		btn_33.setFocusPainted(false);
		btn_33.setContentAreaFilled(false);
		btn_33.setBorderPainted(false);
		btn_33.setBounds(275, 576, 54, 50);
		getContentPane().add(btn_33);
		
		JButton btn_13 = new JButton("13");
		btn_13.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lb_diente.setText("Diente 13");
				List<Odontograma> odontogramasParaDiente = consulta.obtenerOdontogramaPorDiente(13,idPacientePorDni);
				llenarTabla(odontogramasParaDiente);
			}
		});
		btn_13.setFocusPainted(false);
		btn_13.setContentAreaFilled(false);
		btn_13.setBorderPainted(false);
		btn_13.setBounds(67, 135, 54, 40);
		getContentPane().add(btn_13);
		
		JButton btn_17 = new JButton("17");
		btn_17.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lb_diente.setText("Diente 17");
				List<Odontograma> odontogramasParaDiente = consulta.obtenerOdontogramaPorDiente(17,idPacientePorDni);
				llenarTabla(odontogramasParaDiente);
			}
		});
		btn_17.setFocusPainted(false);
		btn_17.setContentAreaFilled(false);
		btn_17.setBorderPainted(false);
		btn_17.setBounds(108, 286, 54, 34);
		getContentPane().add(btn_17);
		
		JButton btn_48 = new JButton("48");
		btn_48.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_48.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lb_diente.setText("Diente 48");
				List<Odontograma> odontogramasParaDiente = consulta.obtenerOdontogramaPorDiente(48,idPacientePorDni);
				llenarTabla(odontogramasParaDiente);
			}
		});
		btn_48.setFocusPainted(false);
		btn_48.setContentAreaFilled(false);
		btn_48.setBorderPainted(false);
		btn_48.setBounds(140, 379, 54, 29);
		getContentPane().add(btn_48);
		
		JButton btn_24 = new JButton("24");
		btn_24.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_24.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lb_diente.setText("Diente 24");
				List<Odontograma> odontogramasParaDiente = consulta.obtenerOdontogramaPorDiente(24,idPacientePorDni);
				llenarTabla(odontogramasParaDiente);
			}
		});
		btn_24.setFocusPainted(false);
		btn_24.setContentAreaFilled(false);
		btn_24.setBorderPainted(false);
		btn_24.setBounds(375, 202, 54, 50);
		getContentPane().add(btn_24);
		
		JButton btn_43 = new JButton("43");
		btn_43.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_43.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lb_diente.setText("Diente 43");
				List<Odontograma> odontogramasParaDiente = consulta.obtenerOdontogramaPorDiente(43,idPacientePorDni);
				llenarTabla(odontogramasParaDiente);
			}
		});
		btn_43.setFocusPainted(false);
		btn_43.setContentAreaFilled(false);
		btn_43.setBorderPainted(false);
		btn_43.setBounds(21, 517, 54, 50);
		getContentPane().add(btn_43);
		
		JButton btn_45 = new JButton("45");
		btn_45.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_45.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lb_diente.setText("Diente 45");
				List<Odontograma> odontogramasParaDiente = consulta.obtenerOdontogramaPorDiente(45, idPacientePorDni);
				llenarTabla(odontogramasParaDiente);
				
			}
		});
		btn_45.setFocusPainted(false);
		btn_45.setContentAreaFilled(false);
		btn_45.setBorderPainted(false);
		btn_45.setBounds(67, 449, 54, 29);
		getContentPane().add(btn_45);
		
		JButton btn_18 = new JButton("18");
		btn_18.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lb_diente.setText("Diente 18");
				List<Odontograma> odontogramasParaDiente = consulta.obtenerOdontogramaPorDiente(18,idPacientePorDni);
				llenarTabla(odontogramasParaDiente);
			}
		});
		btn_18.setFocusPainted(false);
		btn_18.setContentAreaFilled(false);
		btn_18.setBorderPainted(false);
		btn_18.setBounds(130, 319, 54, 29);
		getContentPane().add(btn_18);
		
		JButton btn_22 = new JButton("22");
		btn_22.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_22.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lb_diente.setText("Diente 22");
				List<Odontograma> odontogramasParaDiente = consulta.obtenerOdontogramaPorDiente(22,idPacientePorDni);
				llenarTabla(odontogramasParaDiente);
			}
		});
		btn_22.setFocusPainted(false);
		btn_22.setContentAreaFilled(false);
		btn_22.setBorderPainted(false);
		btn_22.setBounds(285, 144, 54, 50);
		getContentPane().add(btn_22);
		
		JButton btn_37 = new JButton("37");
		btn_37.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_37.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lb_diente.setText("Diente 37");
				List<Odontograma> odontogramasParaDiente = consulta.obtenerOdontogramaPorDiente(37,idPacientePorDni);
				llenarTabla(odontogramasParaDiente);
			}
		});
		btn_37.setFocusPainted(false);
		btn_37.setContentAreaFilled(false);
		btn_37.setBorderPainted(false);
		btn_37.setBounds(385, 458, 54, 29);
		getContentPane().add(btn_37);
		
		JButton btn_25 = new JButton("25");
		btn_25.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_25.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lb_diente.setText("Diente 25");
				List<Odontograma> odontogramasParaDiente = consulta.obtenerOdontogramaPorDiente(25,idPacientePorDni);
				llenarTabla(odontogramasParaDiente);
			}
		});
		btn_25.setFocusPainted(false);
		btn_25.setContentAreaFilled(false);
		btn_25.setBorderPainted(false);
		btn_25.setBounds(385, 244, 54, 50);
		getContentPane().add(btn_25);
		
		JButton btn_11 = new JButton("11");
		btn_11.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lb_diente.setText("Diente 11");
				List<Odontograma> odontogramasParaDiente = consulta.obtenerOdontogramaPorDiente(11,idPacientePorDni);
				llenarTabla(odontogramasParaDiente);
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
				List<Odontograma> odontogramasParaDiente = consulta.obtenerOdontogramaPorDiente(14,idPacientePorDni);
				llenarTabla(odontogramasParaDiente);
			}
		});
		btn_14.setFocusPainted(false);
		btn_14.setContentAreaFilled(false);
		btn_14.setBorderPainted(false);
		btn_14.setBounds(87, 186, 54, 40);
		getContentPane().add(btn_14);
		
		JButton btn_27 = new JButton("27");
		btn_27.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_27.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lb_diente.setText("Diente 27");
				List<Odontograma> odontogramasParaDiente = consulta.obtenerOdontogramaPorDiente(27,idPacientePorDni);
				llenarTabla(odontogramasParaDiente);
			}
		});
		btn_27.setFocusPainted(false);
		btn_27.setContentAreaFilled(false);
		btn_27.setBorderPainted(false);
		btn_27.setBounds(405, 336, 54, 29);
		getContentPane().add(btn_27);
		
		JButton btn_28 = new JButton("28");
		btn_28.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_28.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lb_diente.setText("Diente 28");
				List<Odontograma> odontogramasParaDiente = consulta.obtenerOdontogramaPorDiente(28,idPacientePorDni);
				llenarTabla(odontogramasParaDiente);
			}
		});
		btn_28.setFocusPainted(false);
		btn_28.setContentAreaFilled(false);
		btn_28.setBorderPainted(false);
		btn_28.setBounds(415, 368, 54, 29);
		getContentPane().add(btn_28);
		
		JButton btn_47 = new JButton("47");
		btn_47.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_47.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lb_diente.setText("Diente 47");
				List<Odontograma> odontogramasParaDiente = consulta.obtenerOdontogramaPorDiente(47,idPacientePorDni);
				llenarTabla(odontogramasParaDiente);
			}
		});
		btn_47.setFocusPainted(false);
		btn_47.setContentAreaFilled(false);
		btn_47.setBorderPainted(false);
		btn_47.setBounds(110, 407, 52, 29);
		getContentPane().add(btn_47);
		
		JButton btn_32 = new JButton("32");
		btn_32.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_32.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lb_diente.setText("Diente 32");
				List<Odontograma> odontogramasParaDiente = consulta.obtenerOdontogramaPorDiente(32,idPacientePorDni);
				llenarTabla(odontogramasParaDiente);
			}
		});
		btn_32.setFocusPainted(false);
		btn_32.setContentAreaFilled(false);
		btn_32.setBorderPainted(false);
		btn_32.setBounds(220, 571, 54, 50);
		getContentPane().add(btn_32);
		
		JButton btn_46 = new JButton("46");
		btn_46.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_46.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lb_diente.setText("Diente 46");
				List<Odontograma> odontogramasParaDiente = consulta.obtenerOdontogramaPorDiente(46,idPacientePorDni);
				llenarTabla(odontogramasParaDiente);
			}
		});
		btn_46.setFocusPainted(false);
		btn_46.setContentAreaFilled(false);
		btn_46.setBorderPainted(false);
		btn_46.setBounds(87, 435, 54, 22);
		getContentPane().add(btn_46);
		
		JButton btn_21 = new JButton("21");
		btn_21.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_21.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lb_diente.setText("Diente 21");
				List<Odontograma> odontogramasParaDiente = consulta.obtenerOdontogramaPorDiente(21,idPacientePorDni);
				llenarTabla(odontogramasParaDiente);
			}
		});
		btn_21.setFocusPainted(false);
		btn_21.setBorderPainted(false);
		btn_21.setContentAreaFilled(false);
		btn_21.setBounds(220, 130, 54, 50);
		getContentPane().add(btn_21);
		
		JButton btn_26 = new JButton("26");
		btn_26.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_26.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lb_diente.setText("Diente 26");
				List<Odontograma> odontogramasParaDiente = consulta.obtenerOdontogramaPorDiente(26,idPacientePorDni);
				llenarTabla(odontogramasParaDiente);
			}
		});
		btn_26.setFocusPainted(false);
		btn_26.setContentAreaFilled(false);
		btn_26.setBorderPainted(false);
		btn_26.setBounds(395, 286, 54, 50);
		getContentPane().add(btn_26);
		
		JButton btn_23 = new JButton("23");
		btn_23.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_23.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lb_diente.setText("Diente 23");
				List<Odontograma> odontogramasParaDiente = consulta.obtenerOdontogramaPorDiente(23,idPacientePorDni);
				llenarTabla(odontogramasParaDiente);
			}
		});
		btn_23.setFocusPainted(false);
		btn_23.setContentAreaFilled(false);
		btn_23.setBorderPainted(false);
		btn_23.setBounds(337, 170, 54, 50);
		getContentPane().add(btn_23);
		
		JButton btn_15 = new JButton("15");
		btn_15.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lb_diente.setText("Diente 15");
				List<Odontograma> odontogramasParaDiente = consulta.obtenerOdontogramaPorDiente(15,idPacientePorDni);
				llenarTabla(odontogramasParaDiente);
			}
		});
		btn_15.setFocusPainted(false);
		btn_15.setContentAreaFilled(false);
		btn_15.setBorderPainted(false);
		btn_15.setBounds(77, 223, 54, 29);
		getContentPane().add(btn_15);
		
		JButton btn_41 = new JButton("41");
		btn_41.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_41.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lb_diente.setText("Diente 41");
				List<Odontograma> odontogramasParaDiente = consulta.obtenerOdontogramaPorDiente(41,idPacientePorDni);
				llenarTabla(odontogramasParaDiente);
			}
		});
		btn_41.setFocusPainted(false);
		btn_41.setContentAreaFilled(false);
		btn_41.setBorderPainted(false);
		btn_41.setBounds(110, 571, 54, 29);
		getContentPane().add(btn_41);
		
		JButton btn_16 = new JButton("16");
		btn_16.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lb_diente.setText("Diente 16");
				List<Odontograma> odontogramasParaDiente = consulta.obtenerOdontogramaPorDiente(16,idPacientePorDni);
				llenarTabla(odontogramasParaDiente);
			}
		});
		btn_16.setFocusPainted(false);
		btn_16.setContentAreaFilled(false);
		btn_16.setBorderPainted(false);
		btn_16.setBounds(97, 254, 54, 29);
		getContentPane().add(btn_16);
		
		JButton btn_42 = new JButton("42");
		btn_42.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_42.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lb_diente.setText("Diente 42");
				List<Odontograma> odontogramasParaDiente = consulta.obtenerOdontogramaPorDiente(42,idPacientePorDni);
				llenarTabla(odontogramasParaDiente);
			}
		});
		btn_42.setHorizontalAlignment(SwingConstants.LEFT);
		btn_42.setFocusPainted(false);
		btn_42.setContentAreaFilled(false);
		btn_42.setBorderPainted(false);
		btn_42.setBounds(67, 555, 54, 40);
		getContentPane().add(btn_42);
		
		JLabel lb_diente11 = new JLabel("");
		lb_diente11.setIcon(new ImageIcon(jd_odontograma.class.getResource("/imagenesOdontograma/11_blue.png")));
		lb_diente11.setBackground(Color.WHITE);
		lb_diente11.setBounds(0, 11, 519, 700);
		lb_diente11.setVisible(false);
		getContentPane().add(lb_diente11);
		
		JLabel lb_12 = new JLabel("");
		lb_12.setIcon(new ImageIcon(jd_odontograma.class.getResource("/imagenesOdontograma/12.png")));
		lb_12.setBackground(Color.WHITE);
		lb_12.setBounds(0, 11, 519, 700);
		lb_12.setVisible(false);
		getContentPane().add(lb_12);

		JLabel lb_13 = new JLabel("");
		lb_13.setIcon(new ImageIcon(jd_odontograma.class.getResource("/imagenesOdontograma/13_blue.png")));
		lb_13.setBackground(Color.WHITE);
		lb_13.setBounds(0, 11, 519, 700);
		lb_13.setVisible(false);
		getContentPane().add(lb_13);

		JLabel lb_14 = new JLabel("");
		lb_14.setIcon(new ImageIcon(jd_odontograma.class.getResource("/imagenesOdontograma/14_blue.png")));
		lb_14.setBackground(Color.WHITE);
		lb_14.setBounds(0, 11, 519, 700);
		lb_14.setVisible(false);
		getContentPane().add(lb_14);

		JLabel lb_15 = new JLabel("");
		lb_15.setIcon(new ImageIcon(jd_odontograma.class.getResource("/imagenesOdontograma/15_blue.png")));
		lb_15.setBackground(Color.WHITE);
		lb_15.setBounds(0, 11, 519, 700);
		lb_15.setVisible(false);
		getContentPane().add(lb_15);

		JLabel lb_16 = new JLabel("");
		lb_16.setIcon(new ImageIcon(jd_odontograma.class.getResource("/imagenesOdontograma/16_blue.png")));
		lb_16.setBackground(Color.WHITE);
		lb_16.setBounds(0, 11, 519, 700);
		lb_16.setVisible(false);
		getContentPane().add(lb_16);

		JLabel lb_17 = new JLabel("");
		lb_17.setIcon(new ImageIcon(jd_odontograma.class.getResource("/imagenesOdontograma/17_blue.png")));
		lb_17.setBackground(Color.WHITE);
		lb_17.setBounds(0, 11, 519, 700);
		lb_17.setVisible(false);
		getContentPane().add(lb_17);

		JLabel lb_18 = new JLabel("");
		lb_18.setIcon(new ImageIcon(jd_odontograma.class.getResource("/imagenesOdontograma/18_blue.png")));
		lb_18.setBackground(Color.WHITE);
		lb_18.setBounds(0, 11, 519, 700);
		lb_18.setVisible(false);
		getContentPane().add(lb_18);

		JLabel lb_31 = new JLabel("");
		lb_31.setIcon(new ImageIcon(jd_odontograma.class.getResource("/imagenesOdontograma/31_blue.png")));
		lb_31.setBackground(Color.WHITE);
		lb_31.setBounds(0, 11, 519, 700);
		lb_31.setVisible(false);
		getContentPane().add(lb_31);

		JLabel lb_32 = new JLabel("");
		lb_32.setIcon(new ImageIcon(jd_odontograma.class.getResource("/imagenesOdontograma/32_blue.png")));
		lb_32.setBackground(Color.WHITE);
		lb_32.setBounds(0, 11, 519, 700);
		lb_32.setVisible(false);
		getContentPane().add(lb_32);

		JLabel lb_33 = new JLabel("");
		lb_33.setIcon(new ImageIcon(jd_odontograma.class.getResource("/imagenesOdontograma/33_blue.png")));
		lb_33.setBackground(Color.WHITE);
		lb_33.setBounds(0, 11, 519, 700);
		lb_33.setVisible(false);
		getContentPane().add(lb_33);

		JLabel lb_34 = new JLabel("");
		lb_34.setIcon(new ImageIcon(jd_odontograma.class.getResource("/imagenesOdontograma/34_blue.png")));
		lb_34.setBackground(Color.WHITE);
		lb_34.setBounds(0, 11, 519, 700);
		lb_34.setVisible(false);
		getContentPane().add(lb_34);

		JLabel lb_35 = new JLabel("");
		lb_35.setIcon(new ImageIcon(jd_odontograma.class.getResource("/imagenesOdontograma/35_blue.png")));
		lb_35.setBackground(Color.WHITE);
		lb_35.setBounds(0, 11, 519, 700);
		lb_35.setVisible(false);
		getContentPane().add(lb_35);

		JLabel lb_36 = new JLabel("");
		lb_36.setIcon(new ImageIcon(jd_odontograma.class.getResource("/imagenesOdontograma/36_blue.png")));
		lb_36.setBackground(Color.WHITE);
		lb_36.setBounds(0, 11, 519, 700);
		lb_36.setVisible(false);
		getContentPane().add(lb_36);

		JLabel lb_37 = new JLabel("");
		lb_37.setIcon(new ImageIcon(jd_odontograma.class.getResource("/imagenesOdontograma/37_blue.png")));
		lb_37.setBackground(Color.WHITE);
		lb_37.setBounds(0, 11, 519, 700);
		lb_37.setVisible(false);
		getContentPane().add(lb_37);

		JLabel lb_38 = new JLabel("");
		lb_38.setIcon(new ImageIcon(jd_odontograma.class.getResource("/imagenesOdontograma/38_blue.png")));
		lb_38.setBackground(Color.WHITE);
		lb_38.setBounds(0, 11, 519, 700);
		lb_38.setVisible(false);
		getContentPane().add(lb_38);

		JLabel lb_41 = new JLabel("");
		lb_41.setIcon(new ImageIcon(jd_odontograma.class.getResource("/imagenesOdontograma/41_blue.png")));
		lb_41.setBackground(Color.WHITE);
		lb_41.setBounds(0, 11, 519, 700);
		lb_41.setVisible(false);
		getContentPane().add(lb_41);

		JLabel lb_42 = new JLabel("");
		lb_42.setIcon(new ImageIcon(jd_odontograma.class.getResource("/imagenesOdontograma/42_blue.png")));
		lb_42.setBackground(Color.WHITE);
		lb_42.setBounds(0, 11, 519, 700);
		lb_42.setVisible(false);
		getContentPane().add(lb_42);

		JLabel lb_43 = new JLabel("");
		lb_43.setIcon(new ImageIcon(jd_odontograma.class.getResource("/imagenesOdontograma/43_blue.png")));
		lb_43.setBackground(Color.WHITE);
		lb_43.setBounds(0, 11, 519, 700);
		lb_43.setVisible(false);
		getContentPane().add(lb_43);

		JLabel lb_44 = new JLabel("");
		lb_44.setIcon(new ImageIcon(jd_odontograma.class.getResource("/imagenesOdontograma/44_blue.png")));
		lb_44.setBackground(Color.WHITE);
		lb_44.setBounds(0, 11, 519, 700);
		lb_44.setVisible(false);
		getContentPane().add(lb_44);

		JLabel lb_45 = new JLabel("");
		lb_45.setIcon(new ImageIcon(jd_odontograma.class.getResource("/imagenesOdontograma/45_blue.png")));
		lb_45.setBackground(Color.WHITE);
		lb_45.setBounds(0, 11, 519, 700);
		lb_45.setVisible(false);
		getContentPane().add(lb_45);

		JLabel lb_46 = new JLabel("");
		lb_46.setIcon(new ImageIcon(jd_odontograma.class.getResource("/imagenesOdontograma/46_blue.png")));
		lb_46.setBackground(Color.WHITE);
		lb_46.setBounds(0, 11, 519, 700);
		lb_46.setVisible(false);
		getContentPane().add(lb_46);

		JLabel lb_47 = new JLabel("");
		lb_47.setIcon(new ImageIcon(jd_odontograma.class.getResource("/imagenesOdontograma/47_blue.png")));
		lb_47.setBackground(Color.WHITE);
		lb_47.setBounds(0, 11, 519, 700);
		lb_47.setVisible(false);
		getContentPane().add(lb_47);

		JLabel lb_48 = new JLabel("");
		lb_48.setIcon(new ImageIcon(jd_odontograma.class.getResource("/imagenesOdontograma/48_blue.png")));
		lb_48.setBackground(Color.WHITE);
		lb_48.setBounds(0, 11, 519, 700);
		lb_48.setVisible(false);
		getContentPane().add(lb_48);

		JLabel lb_21 = new JLabel("");
		lb_21.setIcon(new ImageIcon(jd_odontograma.class.getResource("/imagenesOdontograma/21_blue.png")));
		lb_21.setBackground(Color.WHITE);
		lb_21.setBounds(0, 11, 519, 700);
		lb_21.setVisible(false);
		getContentPane().add(lb_21);

		JLabel lb_22 = new JLabel("");
		lb_22.setIcon(new ImageIcon(jd_odontograma.class.getResource("/imagenesOdontograma/22_blue.png")));
		lb_22.setBackground(Color.WHITE);
		lb_22.setBounds(0, 11, 519, 700);
		lb_22.setVisible(false);
		getContentPane().add(lb_22);

		JLabel lb_23 = new JLabel("");
		lb_23.setIcon(new ImageIcon(jd_odontograma.class.getResource("/imagenesOdontograma/23_blue.png")));
		lb_23.setBackground(Color.WHITE);
		lb_23.setBounds(0, 11, 519, 700);
		lb_23.setVisible(false);
		getContentPane().add(lb_23);

		JLabel lb_24 = new JLabel("");
		lb_24.setIcon(new ImageIcon(jd_odontograma.class.getResource("/imagenesOdontograma/24_blue.png")));
		lb_24.setBackground(Color.WHITE);
		lb_24.setBounds(0, 11, 519, 700);
		lb_24.setVisible(false);
		getContentPane().add(lb_24);

		JLabel lb_25 = new JLabel("");
		lb_25.setIcon(new ImageIcon(jd_odontograma.class.getResource("/imagenesOdontograma/25_blue.png")));
		lb_25.setBackground(Color.WHITE);
		lb_25.setBounds(0, 11, 519, 700);
		lb_25.setVisible(false);
		getContentPane().add(lb_25);

		JLabel lb_26 = new JLabel("");
		lb_26.setIcon(new ImageIcon(jd_odontograma.class.getResource("/imagenesOdontograma/26_blue.png")));
		lb_26.setBackground(Color.WHITE);
		lb_26.setBounds(0, 11, 519, 700);
		lb_26.setVisible(false);
		getContentPane().add(lb_26);

		JLabel lb_27 = new JLabel("");
		lb_27.setIcon(new ImageIcon(jd_odontograma.class.getResource("/imagenesOdontograma/27_blue.png")));
		lb_27.setBackground(Color.WHITE);
		lb_27.setBounds(0, 11, 519, 700);
		lb_27.setVisible(false);
		getContentPane().add(lb_27);

		JLabel lb_28 = new JLabel("");
		lb_28.setIcon(new ImageIcon(jd_odontograma.class.getResource("/imagenesOdontograma/28_blue.png")));
		lb_28.setBackground(Color.WHITE);
		lb_28.setBounds(0, 11, 519, 700);
		lb_28.setVisible(false);
		getContentPane().add(lb_28);
		
		List<Integer> id_diente_lista = consulta.mostrarDientes(idPacientePorDni);

		for (Integer opcion : id_diente_lista) {
		    switch (opcion) {
		        case 11:
		            lb_diente11.setVisible(true);
		            break;
		        case 12:
		            lb_12.setVisible(true);
		            break;
		        case 13:
		            lb_13.setVisible(true);
		            break;
		        case 14:
		            lb_14.setVisible(true);
		            break;
		        case 15:
		            lb_15.setVisible(true);
		            break;
		        case 16:
		            lb_16.setVisible(true);
		            break;
		        case 17:
		            lb_17.setVisible(true);
		            break;
		        case 18:
		            lb_18.setVisible(true);
		            break;
		        case 21:
		            lb_21.setVisible(true);
		            break;
		        case 22:
		            lb_22.setVisible(true);
		            break;
		        case 23:
		            lb_23.setVisible(true);
		            break;
		        case 24:
		            lb_24.setVisible(true);
		            break;
		        case 25:
		            lb_25.setVisible(true);
		            break;
		        case 26:
		            lb_26.setVisible(true);
		            break;
		        case 27:
		            lb_27.setVisible(true);
		            break;
		        case 28:
		            lb_28.setVisible(true);
		            break;
		        case 31:
		            lb_31.setVisible(true);
		            break;
		        case 32:
		            lb_32.setVisible(true);
		            break;
		        case 33:
		            lb_33.setVisible(true);
		            break;
		        case 34:
		            lb_34.setVisible(true);
		            break;
		        case 35:
		            lb_35.setVisible(true);
		            break;
		        case 36:
		            lb_36.setVisible(true);
		            break;
		        case 37:
		            lb_37.setVisible(true);
		            break;
		        case 38:
		            lb_38.setVisible(true);
		            break;
		        case 41:
		            lb_41.setVisible(true);
		            break;
		        case 42:
		            lb_42.setVisible(true);
		            break;
		        case 43:
		            lb_43.setVisible(true);
		            break;
		        case 44:
		            lb_44.setVisible(true);
		            break;
		        case 45:
		            lb_45.setVisible(true);
		            break;
		        case 46:
		            lb_46.setVisible(true);
		            break;
		        case 47:
		            lb_47.setVisible(true);
		            break;
		        case 48:
		            lb_48.setVisible(true);
		            break;
		        default:
		            System.out.println("Opción por defecto");
		    }
		
		}

		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(null);
        scrollPane.setBounds(35, 389, 517, 158);
        panel.add(scrollPane);
        
                table = new JTable();

                table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                table.setColumnSelectionAllowed(true);
                table.setShowGrid(false);
                table.setOpaque(false);
                table.setBorder(null);
                table.setGridColor(new Color(30, 160, 216));
                table.setFont(new Font("Arial", Font.PLAIN, 12));
                scrollPane.setViewportView(table);
                table.setModel(new DefaultTableModel(
                	new Object[][] {
                		{null, null, null},
                		{null, null, null},
                		{null, null, null},
                		{null, null, null},
                		{null, null, null},
                		{null, null, null},
                		{null, null, null},
                		{null, null, null},
                		{null, null, null},
                		{null, null, null},
                		{null, null, null},
                		{null, null, null},
                		{null, null, null},
                		{null, null, null},
                		{null, null, null},
                	},
                	new String[] {
                		"", "", ""
                	}
                ));
               
                for (int i = 0; i < table.getColumnCount(); i++) {
                	Class<?> col_class = table.getColumnClass(i);
                	table.setDefaultEditor(col_class,  null);
                	}
		 model=new DefaultTableModel();
			model.addColumn("Diente");
			model.addColumn("Observaciones");
			model.addColumn("Fecha");
		
			 table.addMouseListener(new MouseAdapter() {
		            @Override
		            public void mouseClicked(MouseEvent e) {
		                int selectedRow = table.getSelectedRow();
		                int selectedColumn = table.getSelectedColumn();

		                if (selectedRow != -1 && selectedColumn != -1) {
		                	Object selectedValue = table.getValueAt(selectedRow, selectedColumn);
		                    ta_observaciones.setText(selectedValue.toString());
		                    
		                	ta_observaciones.addFocusListener(new FocusAdapter() {
		            			@Override
		            			public void focusGained(FocusEvent e) {
		            				ta_observaciones.setText("");
		            			}
		            			@Override
		            			public void focusLost(FocusEvent e) {
		            				ta_observaciones.setText(selectedValue.toString());
		            			}
		            		});
		                    
		                }
		            }
		        });

			 
			 
		panel.add(lb_diente);
		
		JLabel lblNewLabel_2_1 = new JLabel("Observaciones");
		lblNewLabel_2_1.setFont(new Font("Barlow Light", Font.PLAIN, 20));
		lblNewLabel_2_1.setBounds(218, 79, 149, 23);
		panel.add(lblNewLabel_2_1);
		
	
		
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
		
		
		
		JButton btn_salir_1 = new JButton("CONFIRMAR");
		btn_salir_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String diente = lb_diente.getText().toString();
				String[]id_spliteado = diente.split(" ");
				String id_dienteString = id_spliteado[1];
				int id_diente = Integer.parseInt(id_dienteString);
				System.out.print(id_diente);
				String observaciones = ta_observaciones.getText().toString();
				String dniPaciente = dniPasar;
				
			dentilax_bdd.ConectorDB_mysql consulta = new dentilax_bdd.ConectorDB_mysql();
			
			int idPaciente = consulta.obtenerIdPacientePorDni(dniPaciente);
			consulta.insertarOdontograma(id_diente, observaciones, idPaciente);//le paso el dni para buscar la id
			dispose();
			jd_odontograma recarga = new jd_odontograma(dniPasar);
			recarga.setVisible(true);
			}
		});
		btn_salir_1.setForeground(Color.WHITE);
		btn_salir_1.setFont(new Font("Barlow", Font.BOLD, 20));
		btn_salir_1.setBorderPainted(false);
		btn_salir_1.setBackground(new Color(32, 160, 216));
		btn_salir_1.setActionCommand("Cancel");
		btn_salir_1.setBounds(35, 579, 153, 43);
		panel.add(btn_salir_1);
		
		JLabel lb_dni = new JLabel(dniPasar);
		lb_dni.setFont(new Font("Barlow Light", Font.PLAIN, 16));
		lb_dni.setBounds(125, 39, 104, 23);
		panel.add(lb_dni);
		
		JLabel lblNewLabel_1 = new JLabel("Paciente:");
		lblNewLabel_1.setFont(new Font("Barlow Light", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(35, 38, 80, 24);
		panel.add(lblNewLabel_1);
		
		JPanel panel_contened = new JPanel();
		panel_contened.setLayout(null);
		panel_contened.setBackground(new Color(32, 160, 216));
		panel_contened.setBounds(35, 339, 517, 43);
		panel.add(panel_contened);
		
		JLabel lbl_ID = new JLabel("DIENTE");
		lbl_ID.setForeground(Color.WHITE);
		lbl_ID.setFont(new Font("Barlow", Font.BOLD, 17));
		lbl_ID.setBounds(57, 11, 96, 21);
		panel_contened.add(lbl_ID);
		
		JLabel lbl_producto = new JLabel("OBSERVACIONES");
		lbl_producto.setForeground(Color.WHITE);
		lbl_producto.setFont(new Font("Barlow", Font.BOLD, 17));
		lbl_producto.setBounds(191, 11, 139, 21);
		panel_contened.add(lbl_producto);
		
		JLabel lbl_cantidad = new JLabel("FECHA");
		lbl_cantidad.setForeground(Color.WHITE);
		lbl_cantidad.setFont(new Font("Barlow", Font.BOLD, 17));
		lbl_cantidad.setBounds(397, 11, 110, 21);
		panel_contened.add(lbl_cantidad);
		System.out.println("cargarndo "+cargar);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setIcon(new ImageIcon(jd_odontograma.class.getResource("/imagenesOdontograma/bocaBaseOdontograma.png")));
		lblNewLabel.setBounds(0, 11, 519, 700);
		getContentPane().add(lblNewLabel);
		
		
		JLabel lb = new JLabel("");
		lb.setIcon(new ImageIcon(jd_odontograma.class.getResource("/imagenesOdontograma/fondoDental.png")));
		lb.setBounds(0, 0, 1184, 762);
		getContentPane().add(lb);

		ConectorDB_mysql conection = new ConectorDB_mysql();
		conection.conectar();
		
		//System.out.println(conection.obtenerInfoCitas().toString());
		
		
	}

		public static DefaultTableModel llenarTabla(List<Odontograma> odontograma) {
		       // Nos aseguramos de que la lista no sea Null
				
				// System.out.println(historialCitas.toString());
		       if (odontograma != null) {
		           // Limpiamos el modelo de la tabla antes de agregar nuevos datos
		           DefaultTableModel model = (DefaultTableModel) table.getModel();
		           model.setRowCount(0);

		           for (Odontograma dientes : odontograma) {
		               Object[] fila = new Object[3];
		               fila[0] = dientes.getId_diente();
		               fila[1] = dientes.getObservaciones();
		               fila[2] = dientes.getFecha();

		            //   model.setRowCount(model.getRowCount()+1);
		               model.addRow(fila);
		           }


		       }

		       return model;
		    }
}

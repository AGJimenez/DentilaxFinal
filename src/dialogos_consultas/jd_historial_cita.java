package dialogos_consultas;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Cursor;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import Modelo.Cita;
import dentilax_bdd.ConectorDB_mysql;


import dialogos_pacientes.jd_buscar_paciente;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JToggleButton;

public class jd_historial_cita extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtIntroduceTexto;
	private static JTable table ;
	private static DefaultTableModel model;
	private ConectorDB_mysql db = new ConectorDB_mysql();
	protected JTextField txt_filtrar;
    dentilax_bdd.ConectorDB_mysql consultasDB = new dentilax_bdd.ConectorDB_mysql();
    JComboBox cb_filtrar = new JComboBox();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			jd_historial_cita dialog = new jd_historial_cita();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			
				
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public jd_historial_cita() {
		try {
			//CON ESTO MOSTRAMOS LOS COMBO BOX
			consultasDB.mostrar_filtro_historial_cita(this);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setTitle("Historial");
		setIconImage(Toolkit.getDefaultToolkit().getImage(jd_historial_cita.class.getResource("/iconos_menus/dentilaxIcono.png")));
		setResizable(false);
		setBounds(100, 100, 815, 540);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 255, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setLocationRelativeTo(this);
		contentPanel.setLayout(null);
		
		JLabel lblDni = new JLabel("PACIENTES");
		lblDni.setBounds(592, 118, 103, 18);
		lblDni.setForeground(new Color(0, 128, 192));
		lblDni.setFont(new Font("Barlow", Font.BOLD, 20));
		contentPanel.add(lblDni);
		
		JLabel lblApellidos = new JLabel("ESPECIALIDAD");
		lblApellidos.setBounds(328, 115, 141, 24);
		lblApellidos.setForeground(new Color(0, 128, 192));
		lblApellidos.setFont(new Font("Barlow", Font.BOLD, 20));
		contentPanel.add(lblApellidos);
		JLabel lblNombre = new JLabel("FECHA");
		lblNombre.setBounds(75, 112, 114, 31);
		lblNombre.setForeground(new Color(0, 128, 192));
		lblNombre.setFont(new Font("Barlow", Font.BOLD, 20));
		contentPanel.add(lblNombre);
		
		txtIntroduceTexto = new JTextField();
		txtIntroduceTexto.setEnabled(false);
		txtIntroduceTexto.setBounds(12, 104, 752, 40);
		txtIntroduceTexto.setEditable(false);
		txtIntroduceTexto.setBackground(new Color(191, 231, 249));
		txtIntroduceTexto.setFont(new Font("Arial", Font.PLAIN, 14));
		txtIntroduceTexto.setText(" ");
		contentPanel.add(txtIntroduceTexto);
		txtIntroduceTexto.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 35, 279, 50);
		panel.setBackground(new Color(191, 231, 249));
		panel.setForeground(new Color(191, 231, 249));
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblDentilax = new JLabel("HISTORIAL GLOBAL DE CITAS");
		lblDentilax.setBounds(10, 11, 264, 24);
		panel.add(lblDentilax);
		lblDentilax.setFont(new Font("Barlow", Font.BOLD, 20));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 147, 752, 268);
		contentPanel.add(scrollPane);
		
		table = new JTable();
		 model=new DefaultTableModel();
	
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
			model.addColumn("Fecha");
			model.addColumn("Especialidad");
			model.addColumn("Paciente");
			
			ConectorDB_mysql conection = new ConectorDB_mysql();
			conection.conectar();
			llenarTabla(conection.obtenerInfoCitas());
		    
		 
		scrollPane.setColumnHeaderView(table);
		
		JPanel panel_contened_1 = new JPanel();
		panel_contened_1.setLayout(null);
		panel_contened_1.setBackground(new Color(32, 160, 216));
		panel_contened_1.setBounds(301, 35, 417, 53);
		contentPanel.add(panel_contened_1);
		
		txt_filtrar = new JTextField();
		txt_filtrar.setHorizontalAlignment(SwingConstants.CENTER);
		txt_filtrar.setFont(new Font("Arial", Font.PLAIN, 14));
		txt_filtrar.setColumns(10);
		txt_filtrar.setBorder(null);
		txt_filtrar.setBackground(new Color(191, 231, 249));
		txt_filtrar.setBounds(219, 11, 188, 31);
		panel_contened_1.add(txt_filtrar);
		
		cb_filtrar.setSelectedIndex(0);
		cb_filtrar.setFont(new Font("Arial", Font.PLAIN, 14));
		cb_filtrar.setBackground(new Color(191, 231, 249));
		cb_filtrar.setBounds(10, 8, 188, 37);
		panel_contened_1.add(cb_filtrar);
		
		JToggleButton btn_filtrar_toggle = new JToggleButton("");
		btn_filtrar_toggle.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_filtrar_toggle.setSelectedIcon(new ImageIcon(jd_buscar_paciente.class.getResource("/iconos_submenus/nofiltrar.png")));
		btn_filtrar_toggle.setIcon(new ImageIcon(jd_buscar_paciente.class.getResource("/iconos_submenus/iconoFiltrar.png")));
		btn_filtrar_toggle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btn_filtrar_toggle.isSelected()) {
					String field_filtrado = cb_filtrar.getSelectedItem().toString();
					try {
						llenarTabla(conection.filtrar_tabla_historial_citas(field_filtrado,txt_filtrar.getText().toString()));
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else {
					txt_filtrar.setText("");
					llenarTabla(conection.obtenerInfoCitas());
				}
			}
		});
		btn_filtrar_toggle.setOpaque(true);
		btn_filtrar_toggle.setBorderPainted(false);
		btn_filtrar_toggle.setBackground(new Color(32, 160, 216));
		btn_filtrar_toggle.setBounds(729, 40, 47, 43);
		contentPanel.add(btn_filtrar_toggle);
		
		JButton btn_salir_1 = new JButton("IMPRIMIR");
		btn_salir_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
			try {
				Map parametros = new HashMap();
				parametros.put("DNI_paciente", txt_filtrar.getText().toString());
				parametros.put("Especialidad", txt_filtrar.getText().toString());
				parametros.put("Fecha", txt_filtrar.getText().toString());
			JasperReport reporte = JasperCompileManager.compileReport("Informes/Historial_cita.jrxml");
			JasperPrint jp;
				jp = JasperFillManager.fillReport(reporte, parametros, conection.conectar());
				JasperViewer.viewReport(jp,false);
			} catch (JRException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
			}
			
		});
		btn_salir_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_salir_1.setForeground(Color.WHITE);
		btn_salir_1.setFont(new Font("Barlow", Font.BOLD, 20));
		btn_salir_1.setBorderPainted(false);
		btn_salir_1.setBorder(null);
		btn_salir_1.setBackground(new Color(32, 160, 216));
		btn_salir_1.setActionCommand("Cancel");
		btn_salir_1.setBounds(37, 436, 153, 43);
		contentPanel.add(btn_salir_1);
		
		JButton btn_salir = new JButton("SALIR");
		btn_salir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btn_salir.setForeground(Color.WHITE);
		btn_salir.setFont(new Font("Barlow", Font.BOLD, 20));
		btn_salir.setBorderPainted(false);
		btn_salir.setBorder(null);
		btn_salir.setBackground(new Color(32, 160, 216));
		btn_salir.setActionCommand("Cancel");
		btn_salir.setBounds(592, 436, 153, 43);
		contentPanel.add(btn_salir);
		txt_filtrar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER) {
					txt_filtrar.requestFocus();
				}
			}
		});
		txt_filtrar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER) {
					if(btn_filtrar_toggle.isSelected()) {
						txt_filtrar.setText("");
						llenarTabla(conection.obtenerInfoCitas());
						btn_filtrar_toggle.setSelected(false);
					}
					
					else {
						String field_filtrado = cb_filtrar.getSelectedItem().toString();
						try {
							llenarTabla(conection.filtrar_tabla_historial_citas(field_filtrado,txt_filtrar.getText().toString()));
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						btn_filtrar_toggle.setSelected(true);
					}
				}
			}
		});
	}
	

		
	public static DefaultTableModel llenarTabla(List<Cita> historialCitas) {
        // Nos aseguramos de que la lista no sea Null
		
		// System.out.println(historialCitas.toString());
        if (historialCitas != null) {
            // Limpiamos el modelo de la tabla antes de agregar nuevos datos
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0);

            for (Cita historial : historialCitas) {
                Object[] fila = new Object[3];
                fila[0] = historial.getFecha();
                fila[1] = historial.getEspecialidad();
                fila[2] = historial.getDniPaciente();

             //   model.setRowCount(model.getRowCount()+1);
                model.addRow(fila);
            }


        }
  


        return model;
    }
	
		private Object getEspecialidad() {
		// TODO Auto-generated method stub
		return null;
	}

		private Object getDNI_paciente() {
		// TODO Auto-generated method stub
		return null;
	}

		private Object getFecha() {
		// TODO Auto-generated method stub
		return null;
	}
		public void setCb_filtrar(String items) {
			cb_filtrar.addItem(items);
		}

		public JTextField getTxt_filtrar() {
			return txt_filtrar;
		}

		public void setTxt_filtrar(JTextField txt_filtrar) {
			this.txt_filtrar = txt_filtrar;
		}
}


package dialogos_pacientes;



import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import javax.swing.ListSelectionModel;
import java.awt.Toolkit;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Modelo.Doctor;
import Modelo.Paciente;
import dentilax_bdd.ConectorDB_mysql;

public class jd_buscar_paciente_historial extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txt_nombre_dr;
	private static JTable table;
	private static DefaultTableModel model;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			jd_buscar_paciente_historial dialog = new jd_buscar_paciente_historial();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public jd_buscar_paciente_historial() {
		setTitle("Historial de paciente");
		setIconImage(Toolkit.getDefaultToolkit().getImage(jd_buscar_paciente_historial.class.getResource("/iconos_menus/dentilaxIcono.png")));
		setModal(true);
		setPreferredSize(new Dimension(1198, 531));
		setResizable(false);
		setBounds(100, 100, 848, 531);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setPreferredSize(new Dimension(1198, 531));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setLocationRelativeTo(contentPanel);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBounds(0, 32, 497, 54);
			panel.setBackground(new Color(191, 231, 249));
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JLabel lbl_paciente = new JLabel("PACIENTE:");
				lbl_paciente.setFont(new Font("Barlow", Font.BOLD, 20));
				lbl_paciente.setBounds(10, 0, 105, 54);
				panel.add(lbl_paciente);
			}
			{
				txt_nombre_dr = new JTextField();
				txt_nombre_dr.setEditable(false);
				txt_nombre_dr.setFont(new Font("Barlow", Font.PLAIN, 20));
				txt_nombre_dr.setText("FELIPE DEL CERRO HERNANDEZ GOMEZ");
				txt_nombre_dr.setBorder(null);
				txt_nombre_dr.setOpaque(false);
				txt_nombre_dr.setBounds(125, 0, 355, 54);
				panel.add(txt_nombre_dr);
				txt_nombre_dr.setColumns(10);
			}
		}
		
	
		
	
		}
		{
			JPanel panel_contened = new JPanel();
			panel_contened.setBounds(51, 97, 733, 43);
			panel_contened.setBackground(new Color(32, 160, 216));
			contentPanel.add(panel_contened);
			panel_contened.setLayout(null);
			{
				JLabel lbl_fecha = new JLabel("FECHA");
				lbl_fecha.setForeground(Color.WHITE);
				lbl_fecha.setFont(new Font("Barlow", Font.BOLD, 17));
				lbl_fecha.setBounds(10, 11, 96, 21);
				panel_contened.add(lbl_fecha);
			}
			{
				JLabel lbl_tipo = new JLabel("TIPO");
				lbl_tipo.setForeground(Color.WHITE);
				lbl_tipo.setFont(new Font("Barlow", Font.BOLD, 17));
				lbl_tipo.setBounds(203, 11, 96, 21);
				panel_contened.add(lbl_tipo);
			}
			{
				JLabel lbl_tratamiento = new JLabel("TRATAMIENTO");
				lbl_tratamiento.setForeground(Color.WHITE);
				lbl_tratamiento.setFont(new Font("Barlow", Font.BOLD, 17));
				lbl_tratamiento.setBounds(462, 11, 110, 21);
				panel_contened.add(lbl_tratamiento);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.WHITE);
			buttonPane.setPreferredSize(new Dimension(10, 60));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(null);
			{
				JButton btn_salir = new JButton("SALIR");
				btn_salir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				btn_salir.setBorder(null);
				btn_salir.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btn_salir.setBorderPainted(false);
				btn_salir.setFont(new Font("Barlow", Font.BOLD, 20));
				btn_salir.setForeground(new Color(255, 255, 255));
				btn_salir.setBackground(new Color(32, 160, 216));
				btn_salir.setBounds(633, 0, 153, 43);
				btn_salir.setActionCommand("Cancel");
				buttonPane.add(btn_salir);
			}
			
			JScrollPane scrollPane = new JScrollPane();
	        scrollPane.setBounds(12, 147, 674, 265);
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
	                    "Nombre", "Seguro", "DNI"
	                }
	            ));
	            model.addColumn("Nombre");
	            model.addColumn("Seguro");
	            model.addColumn("DNI");


	        scrollPane.setColumnHeaderView(table);
			
			
			
			ConectorDB_mysql conection = new ConectorDB_mysql();
			conection.conectar();
			
			//System.out.println(conection.obtenerInfoPaciente().toString());
			llenarTabla(conection.obtenerInfoPaciente() );
			
			
		}
		public static DefaultTableModel llenarTabla(List<Paciente> historialPaciente) {
	        // Nos aseguramos de que la lista no sea Null
			
			// System.out.println(historialCitas.toString());
	        if (historialPaciente != null) {
	            // Limpiamos el modelo de la tabla antes de agregar nuevos datos
	            DefaultTableModel model = (DefaultTableModel) table.getModel();
	            model.setRowCount(0);

	            for (Paciente historial : historialPaciente) {
	                Object[] fila = new Object[3];
	                fila[0] = historial.getNombre();
	                fila[1] = historial.getSeguro();
	                fila[2] = historial.getDNI_paciente();

	             //   model.setRowCount(model.getRowCount()+1);
	                model.addRow(fila);
	            }


	        }
	  

	        return model;
	    }	
	}


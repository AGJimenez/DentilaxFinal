package dialogos_doctores;



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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Modelo.Cita;
import Modelo.Doctor;
import Modelo.Paciente;
import dentilax_bdd.ConectorDB_mysql;

public class jd_buscar_dr_historial extends JDialog {

	private static final long serialVersionUID = 1L;
	private static final String DNI_doctor="";
	private final JPanel contentPanel = new JPanel();
	private JTextField txt_nombre_dr;
	private static JTable table ;
	private static DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			jd_buscar_dr_historial dialog = new jd_buscar_dr_historial(DNI_doctor);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public jd_buscar_dr_historial(String DNI_doctor) {
		setModal(true);
		setPreferredSize(new Dimension(1198, 531));
		setResizable(false);
		setBounds(100, 100, 715, 531);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setPreferredSize(new Dimension(1198, 531));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setLocationRelativeTo(contentPanel);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBounds(0, 32, 473, 54);
			panel.setBackground(new Color(191, 231, 249));
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JLabel lbl_dr = new JLabel("DOCTOR: ");
				lbl_dr.setFont(new Font("Barlow", Font.BOLD, 20));
				lbl_dr.setBounds(10, 0, 88, 54);
				panel.add(lbl_dr);
			}
			{
				txt_nombre_dr = new JTextField();
				txt_nombre_dr.setEditable(false);
				txt_nombre_dr.setFont(new Font("Barlow", Font.PLAIN, 20));
				txt_nombre_dr.setText("FELIPE DEL CERRO HERNANDEZ GOMEZ");
				txt_nombre_dr.setBorder(null);
				txt_nombre_dr.setOpaque(false);
				txt_nombre_dr.setBounds(108, 0, 355, 54);
				panel.add(txt_nombre_dr);
				txt_nombre_dr.setColumns(10);
			}
		}
		
		JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(12, 147, 674, 265);
        contentPanel.add(scrollPane);

        table = new JTable();
         model=new DefaultTableModel();

            table.setModel(model);
            model.addColumn("Nombre");
            model.addColumn("Tratamiento");
            model.addColumn("DNI_paciente");


        scrollPane.setColumnHeaderView(table);
		{
			JPanel panel_contened = new JPanel();
			panel_contened.setBounds(10, 97, 674, 43);
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
				JLabel lbl_tipo = new JLabel("TRATAMIENTO");
				lbl_tipo.setForeground(Color.WHITE);
				lbl_tipo.setFont(new Font("Barlow", Font.BOLD, 17));
				lbl_tipo.setBounds(265, 11, 135, 21);
				panel_contened.add(lbl_tipo);
			}
			{
				JLabel lbl_paciente = new JLabel("PACIENTE");
				lbl_paciente.setForeground(Color.WHITE);
				lbl_paciente.setFont(new Font("Barlow", Font.BOLD, 17));
				lbl_paciente.setBounds(514, 11, 96, 21);
				panel_contened.add(lbl_paciente);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.WHITE);
			buttonPane.setPreferredSize(new Dimension(10, 60));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btn_salir = new JButton("SALIR");
				btn_salir.setBounds(534, 0, 153, 43);
				btn_salir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				btn_salir.setBorder(null);
				btn_salir.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				buttonPane.setLayout(null);
				btn_salir.setBorderPainted(false);
				btn_salir.setFont(new Font("Barlow", Font.BOLD, 20));
				btn_salir.setForeground(new Color(255, 255, 255));
				btn_salir.setBackground(new Color(32, 160, 216));
				btn_salir.setActionCommand("Cancel");
				buttonPane.add(btn_salir);
			}
		}
		
		ConectorDB_mysql conection = new ConectorDB_mysql();
		conection.conectar();
		
		//System.out.println(conection.obtenerInfoCitas().toString());

		List<Doctor> historialDr = conection.obtenerInfoDoctor(DNI_doctor);
		System.out.println(DNI_doctor);
		llenarTabla(historialDr);
		
		
	}
	

	public void llenarTabla(List<Doctor> historialDr) {
	    if (historialDr != null && !historialDr.isEmpty()) {
	    	 model.setColumnCount(0); // Limpiar columnas existentes
	            Object[] columnNames = {"Fecha", "Tratamiento", "DNI_paciente"};
	            model.setColumnIdentifiers(columnNames); // Establecer nuevas columnas

	        for (Doctor historial : historialDr) {
	            Object[] fila = new Object[3];
	            fila[0] = historial.getFecha();
	            fila[1] = historial.getEspecialidad();
	            fila[2] = historial.getDniPaciente();
	            model.addRow(fila);
	        }
	    }
	}
	
}

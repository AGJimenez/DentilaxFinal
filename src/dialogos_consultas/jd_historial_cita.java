package dialogos_consultas;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

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
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Cursor;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import Modelo.Cita;
import dentilax_bdd.ConectorDB_mysql;

public class jd_historial_cita extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtIntroduceTexto;
	private static JTable table ;
	private static DefaultTableModel model;
	private ConectorDB_mysql db = new ConectorDB_mysql();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			jd_historial_cita dialog = new jd_historial_cita();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
	
			//aqui tienes que obtener la lista
			//lista que viene de conectorDB

				
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public jd_historial_cita() {

			
		setTitle("Historial");
		setIconImage(Toolkit.getDefaultToolkit().getImage(jd_historial_cita.class.getResource("/iconos_menus/dentilaxIcono.png")));
		setResizable(false);
		setBounds(100, 100, 711, 462);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 255, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setLocationRelativeTo(this);
		contentPanel.setLayout(null);
		
		JLabel lblDni = new JLabel("PACIENTES");
		lblDni.setBounds(569, 118, 103, 18);
		lblDni.setForeground(new Color(0, 128, 192));
		lblDni.setFont(new Font("Barlow", Font.BOLD, 20));
		contentPanel.add(lblDni);
		
		JLabel lblApellidos = new JLabel("TIPO");
		lblApellidos.setBounds(236, 115, 114, 24);
		lblApellidos.setForeground(new Color(0, 128, 192));
		lblApellidos.setFont(new Font("Barlow", Font.BOLD, 20));
		contentPanel.add(lblApellidos);
		JLabel lblNombre = new JLabel("FECHA");
		lblNombre.setBounds(25, 112, 114, 31);
		lblNombre.setForeground(new Color(0, 128, 192));
		lblNombre.setFont(new Font("Barlow", Font.BOLD, 20));
		contentPanel.add(lblNombre);
		
		txtIntroduceTexto = new JTextField();
		txtIntroduceTexto.setBounds(12, 104, 674, 40);
		txtIntroduceTexto.setEditable(false);
		txtIntroduceTexto.setBackground(new Color(191, 231, 249));
		txtIntroduceTexto.setFont(new Font("Arial", Font.PLAIN, 14));
		txtIntroduceTexto.setText(" ");
		contentPanel.add(txtIntroduceTexto);
		txtIntroduceTexto.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 37, 652, 50);
		panel.setBackground(new Color(191, 231, 249));
		panel.setForeground(new Color(191, 231, 249));
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblDentilax = new JLabel("HISTORIAL GLOBAL DE CITAS");
		lblDentilax.setBounds(37, 11, 308, 24);
		panel.add(lblDentilax);
		lblDentilax.setFont(new Font("Barlow", Font.BOLD, 20));
		
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
					"Fecha", "Tipo", "Paciente"
				}
			));
			model.addColumn("Fecha");
			model.addColumn("Tipo");
			model.addColumn("Paciente");
		    
		 
		scrollPane.setColumnHeaderView(table);

	
		
			ConectorDB_mysql conection = new ConectorDB_mysql();
			conection.conectar();
			
			//System.out.println(conection.obtenerInfoCitas().toString());
			llenarTabla(conection.obtenerInfoCitas() );
			
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

		{
		}
	}


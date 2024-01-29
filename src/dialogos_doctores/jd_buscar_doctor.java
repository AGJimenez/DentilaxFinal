package dialogos_doctores;



import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import Modelo.Doctor;
import Modelo.Solicitud;
import dentilax_bdd.ConectorDB_mysql;

import java.awt.Dimension;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.SQLException;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTable;

public class jd_buscar_doctor extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
    private static DefaultTableModel model;
    private static JTable table;
    private int indiceFilaSeleccionada;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			jd_buscar_doctor dialog = new jd_buscar_doctor();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public jd_buscar_doctor() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(jd_buscar_doctor.class.getResource("/iconos_menus/dentilaxIcono.png")));
		setTitle("Buscar doctor");
		setPreferredSize(new Dimension(554, 343));
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 769, 517);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(contentPanel);
		{
			JLabel lbl_doctores = new JLabel("DOCTORES");
			lbl_doctores.setFont(new Font("Barlow", Font.BOLD, 20));
			lbl_doctores.setBounds(26, 35, 176, 42);
			contentPanel.add(lbl_doctores);
		}
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(191, 231, 249));
			panel.setBounds(0, 24, 217, 64);
			contentPanel.add(panel);
		}
		
		JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(30, 150, 683, 244);
        contentPanel.add(scrollPane);
        
                table = new JTable();
                table.setAutoCreateRowSorter(true);
                scrollPane.setViewportView(table);
                table.setModel(new DefaultTableModel(
                	new Object[][] {
                		{null, null, null, null, null},
                		{null, null, null, null, null},
                		{null, null, null, null, null},
                		{null, null, null, null, null},
                		{null, null, null, null, null},
                		{null, null, null, null, null},
                		{null, null, null, null, null},
                		{null, null, null, null, null},
                		{null, null, null, null, null},
                		{null, null, null, null, null},
                		{null, null, null, null, null},
                		{null, null, null, null, null},
                		{null, null, null, null, null},
                		{null, null, null, null, null},
                		{null, null, null, null, null},
                	},
                	new String[] {
                		"", "", "", "", ""
                	}
                ));
                for (int i = 0; i < table.getColumnCount(); i++) {
                	Class<?> col_class = table.getColumnClass(i);
                	table.setDefaultEditor(col_class,  null);
                	}
                table.getColumnModel().getColumn(0).setPreferredWidth(15);
                model = new DefaultTableModel();
                model.addColumn("Nombre");
                model.addColumn("Apellidos");
                model.addColumn("Especialidad");
                model.addColumn("Telefono");
                model.addColumn("Correo");

                ConectorDB_mysql conection = new ConectorDB_mysql();
                conection.conectar();
                llenarTabla(conection.obtener_doctores());
		
		JPanel panel_contened = new JPanel();
		panel_contened.setLayout(null);
		panel_contened.setBackground(new Color(32, 160, 216));
		panel_contened.setBounds(26, 99, 715, 43);
		contentPanel.add(panel_contened);
		
		JLabel lbl_nombre = new JLabel("NOMBRE");
		lbl_nombre.setForeground(Color.WHITE);
		lbl_nombre.setFont(new Font("Dialog", Font.BOLD, 17));
		lbl_nombre.setBounds(10, 11, 96, 21);
		panel_contened.add(lbl_nombre);
		
		JLabel lbl_apellidos = new JLabel("APELLIDOS");
		lbl_apellidos.setForeground(Color.WHITE);
		lbl_apellidos.setFont(new Font("Dialog", Font.BOLD, 17));
		lbl_apellidos.setBounds(116, 11, 96, 21);
		panel_contened.add(lbl_apellidos);
		
		JLabel lbl_especialidad = new JLabel("ESPECIALIDAD");
		lbl_especialidad.setForeground(Color.WHITE);
		lbl_especialidad.setFont(new Font("Dialog", Font.BOLD, 17));
		lbl_especialidad.setBounds(250, 11, 120, 21);
		panel_contened.add(lbl_especialidad);
		
		JLabel lbl_telefono = new JLabel("TELEFONO");
		lbl_telefono.setForeground(Color.WHITE);
		lbl_telefono.setFont(new Font("Dialog", Font.BOLD, 17));
		lbl_telefono.setBounds(398, 11, 96, 21);
		panel_contened.add(lbl_telefono);
		
		JLabel lbl_correo = new JLabel("CORREO");
		lbl_correo.setForeground(Color.WHITE);
		lbl_correo.setFont(new Font("Dialog", Font.BOLD, 17));
		lbl_correo.setBounds(554, 11, 96, 21);
		panel_contened.add(lbl_correo);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.WHITE);
			buttonPane.setPreferredSize(new Dimension(10, 60));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(null);
			{
				JButton btn_buscar = new JButton("BUSCAR");
				btn_buscar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (indiceFilaSeleccionada != -1) {
	                    String nombre = (String) table.getValueAt(indiceFilaSeleccionada, 0);
	                    String apellidos = (String) table.getValueAt(indiceFilaSeleccionada, 1);
	                    try {
	                    	dispose();
	                    	conection.consulta_doctor(nombre, apellidos);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} 
	                }
					}
				});
				btn_buscar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				btn_buscar.setBorderPainted(false);
				btn_buscar.setFont(new Font("Barlow", Font.BOLD, 20));
				btn_buscar.setForeground(new Color(255, 255, 255));
				btn_buscar.setBackground(new Color(32, 160, 216));
				btn_buscar.setBounds(56, 0, 153, 43);
				btn_buscar.setActionCommand("OK");
				buttonPane.add(btn_buscar);
				
			}
			{
				JButton btn_cancelar = new JButton("CANCELAR");
				btn_cancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btn_cancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				btn_cancelar.setBorderPainted(false);
				btn_cancelar.setFont(new Font("Barlow", Font.BOLD, 20));
				btn_cancelar.setForeground(new Color(255, 255, 255));
				btn_cancelar.setBackground(new Color(32, 160, 216));
				btn_cancelar.setBounds(583, 0, 153, 43);
				btn_cancelar.setActionCommand("Cancel");
				buttonPane.add(btn_cancelar);
			}
			ListSelectionModel selectionModel = table.getSelectionModel();
	        selectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Permite seleccionar solo una fila

	        selectionModel.addListSelectionListener(new ListSelectionListener() {
	            @Override
	            public void valueChanged(ListSelectionEvent e) {
	                if (!e.getValueIsAdjusting()) {
	                    int selectedRow = table.getSelectedRow();
	                    // Almacena el índice de la fila seleccionada
	                   
	                    indiceFilaSeleccionada = selectedRow;
	                }
	            }
	        });
		}
		
	} 
	public static DefaultTableModel llenarTabla(List<Doctor> doctores) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);

        for (Doctor doctor : doctores) {
            Object[] fila = new Object[5];
            fila[0] = doctor.getNombre();
            fila[1] = doctor.getApellidos();
            fila[2] = doctor.getEspecialidad();
            fila[3] = doctor.getTelefono();
            fila[4] = doctor.getCorreo();

            model.addRow(fila);
        }

        return model;
    }
}

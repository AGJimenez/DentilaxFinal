package dialogos_pacientes;



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

import Modelo.Paciente;
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
import javax.swing.JComboBox;
import javax.swing.JToggleButton;
import javax.swing.ImageIcon;

public class jd_buscar_paciente_baja extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
    private static DefaultTableModel model;
    private static JTable table;
    private int indiceFilaSeleccionada;
    protected JTextField txt_filtrar;
    dentilax_bdd.ConectorDB_mysql consultasDB = new dentilax_bdd.ConectorDB_mysql();
    JComboBox cb_filtrar = new JComboBox();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			jd_buscar_paciente_baja dialog = new jd_buscar_paciente_baja();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public jd_buscar_paciente_baja() {
		try {
			//CON ESTO MOSTRAMOS LOS COMBO BOX
			consultasDB.mostrar_filtro_paciente_baja(this);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setIconImage(Toolkit.getDefaultToolkit().getImage(jd_buscar_paciente_baja.class.getResource("/iconos_menus/dentilaxIcono.png")));
		setTitle("Dar baja");
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
			JLabel lbl_pacientes = new JLabel("PACIENTES");
			lbl_pacientes.setFont(new Font("Barlow", Font.BOLD, 20));
			lbl_pacientes.setBounds(26, 35, 176, 42);
			contentPanel.add(lbl_pacientes);
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
                		"", "", "", ""
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
                model.addColumn("Observaciones");
                model.addColumn("Seguro");

                ConectorDB_mysql conection = new ConectorDB_mysql();
                conection.conectar();
                llenarTabla(conection.obtener_pacientes());
		
		JPanel panel_contened = new JPanel();
		panel_contened.setLayout(null);
		panel_contened.setBackground(new Color(32, 160, 216));
		panel_contened.setBounds(26, 99, 715, 43);
		contentPanel.add(panel_contened);
		
		JLabel lbl_nombre = new JLabel("NOMBRE");
		lbl_nombre.setForeground(Color.WHITE);
		lbl_nombre.setFont(new Font("Barlow", Font.BOLD, 17));
		lbl_nombre.setBounds(34, 11, 96, 21);
		panel_contened.add(lbl_nombre);
		
		JLabel lbl_apellidos = new JLabel("APELLIDOS");
		lbl_apellidos.setForeground(Color.WHITE);
		lbl_apellidos.setFont(new Font("Barlow", Font.BOLD, 17));
		lbl_apellidos.setBounds(140, 11, 110, 21);
		panel_contened.add(lbl_apellidos);
		
		JLabel lbl_observaciones = new JLabel("OBSERVACIONES");
		lbl_observaciones.setForeground(Color.WHITE);
		lbl_observaciones.setFont(new Font("Barlow", Font.BOLD, 17));
		lbl_observaciones.setBounds(337, 11, 140, 21);
		panel_contened.add(lbl_observaciones);
		
		JLabel lbl_seguro = new JLabel("SEGURO");
		lbl_seguro.setForeground(Color.WHITE);
		lbl_seguro.setFont(new Font("Barlow", Font.BOLD, 17));
		lbl_seguro.setBounds(529, 11, 71, 21);
		panel_contened.add(lbl_seguro);
		
		JPanel panel_contened_1 = new JPanel();
		panel_contened_1.setLayout(null);
		panel_contened_1.setBackground(new Color(32, 160, 216));
		panel_contened_1.setBounds(241, 35, 417, 53);
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
		btn_filtrar_toggle.setSelectedIcon(new ImageIcon(jd_buscar_paciente_baja.class.getResource("/iconos_submenus/nofiltrar.png")));
		btn_filtrar_toggle.setIcon(new ImageIcon(jd_buscar_paciente_baja.class.getResource("/iconos_submenus/iconoFiltrar.png")));
		btn_filtrar_toggle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btn_filtrar_toggle.isSelected()) {
					String field_filtrado = cb_filtrar.getSelectedItem().toString();
					try {
						llenarTabla(conection.filtrar_tabla_paciente(field_filtrado,txt_filtrar.getText().toString()));
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else {
					txt_filtrar.setText("");
					llenarTabla(conection.obtener_pacientes());
				}
			}
		});
		btn_filtrar_toggle.setOpaque(true);
		btn_filtrar_toggle.setBorderPainted(false);
		btn_filtrar_toggle.setBackground(new Color(32, 160, 216));
		btn_filtrar_toggle.setBounds(676, 40, 47, 43);
		contentPanel.add(btn_filtrar_toggle);
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
	                    dentilax_bdd.ConectorDB_mysql consulta = new dentilax_bdd.ConectorDB_mysql();
	                    try {
	                    	dispose();
	                    	consulta.consulta_paciente_eliminar(nombre, apellidos);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} 
	                }
					}
				});
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
								llenarTabla(conection.obtener_pacientes());
								btn_filtrar_toggle.setSelected(false);
							}
							
							else {
								String field_filtrado = cb_filtrar.getSelectedItem().toString();
								try {
									llenarTabla(conection.filtrar_tabla_paciente(field_filtrado,txt_filtrar.getText().toString()));
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								btn_filtrar_toggle.setSelected(true);
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
	public static DefaultTableModel llenarTabla(List<Paciente> pacientes) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);

        for (Paciente paciente : pacientes) {
            Object[] fila = new Object[4];
            fila[0] = paciente.getNombre();
            fila[1] = paciente.getApellidos();
            fila[2] = paciente.getObservaciones();
            fila[3] = paciente.getSeguro();

            model.addRow(fila);
        }

        return model;
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

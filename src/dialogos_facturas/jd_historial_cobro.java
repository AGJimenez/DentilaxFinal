package dialogos_facturas;



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

import Modelo.Cita;
import Modelo.Factura;
import Modelo.Paciente;
import Modelo.Solicitud;
import dentilax_bdd.ConectorDB_mysql;

import java.awt.Dimension;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JToggleButton;
import javax.swing.ImageIcon;

public class jd_historial_cobro extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
    private static DefaultTableModel model;
    private static JTable table;
    private int indiceFilaSeleccionada;
    private String dniPaciente;
    protected JTextField txt_filtrar;
	private JLabel lbl_invisible = new JLabel("");
    dentilax_bdd.ConectorDB_mysql consultasDB = new dentilax_bdd.ConectorDB_mysql();
    JComboBox cb_filtrar = new JComboBox();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			jd_historial_cobro dialog = new jd_historial_cobro(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public jd_historial_cobro(String dniPaciente) {
		
		this.dniPaciente = dniPaciente;
		try {
			//CON ESTO MOSTRAMOS LOS COMBO BOX
			consultasDB.mostrar_filtro_historial_cobro(this);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setIconImage(Toolkit.getDefaultToolkit().getImage(jd_historial_cobro.class.getResource("/iconos_menus/dentilaxIcono.png")));
		setTitle("Historial cobro");
		setPreferredSize(new Dimension(554, 343));
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 770, 518);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(contentPanel);
		{
			JLabel lbl_pagos = new JLabel("PAGOS");
			lbl_pagos.setFont(new Font("Barlow", Font.BOLD, 20));
			lbl_pagos.setBounds(26, 35, 176, 42);
			contentPanel.add(lbl_pagos);
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
                model.addColumn("Fecha");
                model.addColumn("DNI_paciente");
                model.addColumn("Pagado");
                model.addColumn("Por pagar");

                ConectorDB_mysql conection = new ConectorDB_mysql();
                conection.conectar();
                llenarTabla(conection.obtener_facturas_cobro());
		
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
		btn_filtrar_toggle.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_filtrar_toggle.setSelectedIcon(new ImageIcon(jd_historial_cobro.class.getResource("/iconos_submenus/nofiltrar.png")));
		btn_filtrar_toggle.setIcon(new ImageIcon(jd_historial_cobro.class.getResource("/iconos_submenus/iconoFiltrar.png")));
		btn_filtrar_toggle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btn_filtrar_toggle.isSelected()) {
					String field_filtrado = cb_filtrar.getSelectedItem().toString();
					try {
						llenarTabla(conection.filtrar_tabla_cobros_facturas(field_filtrado,txt_filtrar.getText().toString()));
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else {
					txt_filtrar.setText("");
					llenarTabla(conection.obtener_facturas_cobro());
				}
			}
		});
		btn_filtrar_toggle.setOpaque(true);
		btn_filtrar_toggle.setBorderPainted(false);
		btn_filtrar_toggle.setBackground(new Color(32, 160, 216));
		btn_filtrar_toggle.setBounds(676, 40, 47, 43);
		contentPanel.add(btn_filtrar_toggle);
		
		JPanel panel_contened_2 = new JPanel();
		panel_contened_2.setLayout(null);
		panel_contened_2.setBackground(new Color(32, 160, 216));
		panel_contened_2.setBounds(26, 99, 715, 43);
		contentPanel.add(panel_contened_2);
		
		JLabel lbl_fecha_1 = new JLabel("FECHA");
		lbl_fecha_1.setForeground(Color.WHITE);
		lbl_fecha_1.setFont(new Font("Barlow", Font.BOLD, 17));
		lbl_fecha_1.setBounds(26, 11, 96, 21);
		panel_contened_2.add(lbl_fecha_1);
		
		JLabel lbl_nombre = new JLabel("DNI");
		lbl_nombre.setForeground(Color.WHITE);
		lbl_nombre.setFont(new Font("Barlow", Font.BOLD, 17));
		lbl_nombre.setBounds(171, 11, 88, 21);
		panel_contened_2.add(lbl_nombre);
		
		JLabel lbl_por_pagar = new JLabel("POR PAGAR");
		lbl_por_pagar.setForeground(Color.WHITE);
		lbl_por_pagar.setFont(new Font("Barlow", Font.BOLD, 17));
		lbl_por_pagar.setBounds(523, 11, 140, 21);
		panel_contened_2.add(lbl_por_pagar);
		
		JLabel lbl_apellidos = new JLabel("PAGADO");
		lbl_apellidos.setForeground(Color.WHITE);
		lbl_apellidos.setFont(new Font("Barlow", Font.BOLD, 17));
		lbl_apellidos.setBounds(335, 11, 140, 21);
		panel_contened_2.add(lbl_apellidos);
		
		lbl_invisible.setBounds(741, 11, 0, 0);
		contentPanel.add(lbl_invisible);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.WHITE);
			buttonPane.setPreferredSize(new Dimension(10, 60));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(null);
			{
				
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
								llenarTabla(conection.obtener_facturas_cobro());
								btn_filtrar_toggle.setSelected(false);
							}
							
							else {
								String field_filtrado = cb_filtrar.getSelectedItem().toString();
								try {
									llenarTabla(conection.filtrar_tabla_cobros_facturas(field_filtrado,txt_filtrar.getText().toString()));
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
			
			JButton btn_imprimir = new JButton("IMPRIMIR");
			btn_imprimir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btn_imprimir.setForeground(Color.WHITE);
			btn_imprimir.setFont(new Font("Barlow", Font.BOLD, 20));
			btn_imprimir.setBorderPainted(false);
			btn_imprimir.setBackground(new Color(32, 160, 216));
			btn_imprimir.setActionCommand("Cancel");
			btn_imprimir.setBounds(30, 0, 153, 43);
			buttonPane.add(btn_imprimir);
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
	public DefaultTableModel llenarTabla(List<Factura> historialFactura, String dniPaciente) {
	    // Filtrar las facturas por el DNI del paciente
	    List<Factura> facturasPaciente = historialFactura.stream()
	            .filter(factura -> factura.getDNI_paciente().equals(dniPaciente))
	            .collect(Collectors.toList());

	    if (facturasPaciente != null) {
	        DefaultTableModel model = (DefaultTableModel) table.getModel();
	        model.setRowCount(0);

	        for (Factura historial : facturasPaciente) {
	            Object[] fila = new Object[4];
	            fila[0] = historial.getFecha();
	            fila[1] = historial.getDNI_paciente();
	            fila[2] = historial.getPagado();
	            fila[3] = historial.getPor_pagar();
	            model.addRow(fila);
	        }
	    }
	    return model;
	}



    public void setDniPaciente(String dniPaciente) {
        this.dniPaciente = dniPaciente;
    }
	
	public JLabel getLbl_invisible() {
		return lbl_invisible;
	}

	public void setLbl_invisible(String text) {
		this.lbl_invisible.setText(text);
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

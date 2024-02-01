package dialogos_materiales;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Modelo.Cita;
import Modelo.Inventario;
import Modelo.Paciente;
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

public class jd_inventario extends JDialog {

    private static final long serialVersionUID = 1L;
    private final JPanel contentPanel = new JPanel();
    private static JTable table;
    private static DefaultTableModel model;
    private JTextField txt_invisible;
    protected JTextField txt_filtrar;
    dentilax_bdd.ConectorDB_mysql consultasDB = new dentilax_bdd.ConectorDB_mysql();
    JComboBox cb_filtrar = new JComboBox();

    public jd_inventario() {
    	try {
			//CON ESTO MOSTRAMOS LOS COMBO BOX
			consultasDB.mostrar_filtro_inventario(this);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	setResizable(false);
        setTitle("Inventario");
        setIconImage(Toolkit.getDefaultToolkit().getImage(jd_inventario.class.getResource("/iconos_menus/dentilaxIcono.png")));
        setModal(true);
        setPreferredSize(new Dimension(762, 531));
        setBounds(100, 100, 771, 531);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBackground(Color.WHITE);
        contentPanel.setPreferredSize(new Dimension(1198, 531));
        contentPanel.setBorder(null);
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        setLocationRelativeTo(contentPanel);
        contentPanel.setLayout(null);

        JPanel panel_contened = new JPanel();
        panel_contened.setBounds(41, 96, 674, 43);
        panel_contened.setBackground(new Color(32, 160, 216));
        contentPanel.add(panel_contened);
        panel_contened.setLayout(null);

        JLabel lbl_ID = new JLabel("ID");
        lbl_ID.setForeground(Color.WHITE);
        lbl_ID.setFont(new Font("Barlow", Font.BOLD, 17));
        lbl_ID.setBounds(10, 11, 96, 21);
        panel_contened.add(lbl_ID);

        JLabel lbl_producto = new JLabel("PRODUCTO");
        lbl_producto.setForeground(Color.WHITE);
        lbl_producto.setFont(new Font("Barlow", Font.BOLD, 17));
        lbl_producto.setBounds(257, 11, 110, 21);
        panel_contened.add(lbl_producto);

        JLabel lbl_cantidad = new JLabel("CANTIDAD");
        lbl_cantidad.setForeground(Color.WHITE);
        lbl_cantidad.setFont(new Font("Barlow", Font.BOLD, 17));
        lbl_cantidad.setBounds(480, 11, 110, 21);
        panel_contened.add(lbl_cantidad);

        JPanel buttonPane = new JPanel();
        buttonPane.setBackground(Color.WHITE);
        buttonPane.setPreferredSize(new Dimension(10, 60));
        getContentPane().add(buttonPane, BorderLayout.SOUTH);
        buttonPane.setLayout(null);
        
                JButton btn_salir = new JButton("SALIR");
                btn_salir.setBounds(565, 0, 153, 43);
                buttonPane.add(btn_salir);
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
                btn_salir.setActionCommand("Cancel");
                
                JButton btn_salir_1 = new JButton("IMPRIMIR");
                btn_salir_1.addActionListener(new ActionListener() {
                	public void actionPerformed(ActionEvent e) {
                		try {
            				Map parametros = new HashMap();
            				JasperReport reporte = JasperCompileManager.compileReport("Informes/Inventario.jrxml");
            				JasperPrint jp;
            				ConectorDB_mysql c = new ConectorDB_mysql();
            					jp = JasperFillManager.fillReport(reporte, parametros, c.conectar() );
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
                btn_salir_1.setBounds(34, 0, 153, 43);
                buttonPane.add(btn_salir_1);
                
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(44, 150, 671, 247);
        contentPanel.add(scrollPane);
        
                table = new JTable();
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
			model.addColumn("ID");
			model.addColumn("Producto");
			model.addColumn("Cantidad");
			
			ConectorDB_mysql conection = new ConectorDB_mysql();
			conection.conectar();
            llenarTabla(conection.obtenerInventario());
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(191, 231, 249));
		panel.setBounds(10, 31, 242, 54);
		contentPanel.add(panel);
		
		JLabel lbl_inventario_disponible = new JLabel("INVENTARIO DISPONIBLE");
		lbl_inventario_disponible.setFont(new Font("Barlow", Font.BOLD, 20));
		lbl_inventario_disponible.setBounds(10, 0, 233, 54);
		panel.add(lbl_inventario_disponible);
		
		txt_invisible = new JTextField();
		txt_invisible.setVisible(false);
		txt_invisible.setText("Invisible");
		txt_invisible.setEditable(false);
		txt_invisible.setColumns(10);
		txt_invisible.setBounds(545, 48, 0, 0);
		contentPanel.add(txt_invisible);
		
		JPanel panel_contened_1 = new JPanel();
		panel_contened_1.setLayout(null);
		panel_contened_1.setBackground(new Color(32, 160, 216));
		panel_contened_1.setBounds(262, 31, 417, 53);
		contentPanel.add(panel_contened_1);
		
		txt_filtrar = new JTextField();
		txt_filtrar.setHorizontalAlignment(SwingConstants.CENTER);
		txt_filtrar.setFont(new Font("Arial", Font.PLAIN, 14));
		txt_filtrar.setColumns(10);
		txt_filtrar.setBorder(null);
		txt_filtrar.setBackground(new Color(191, 231, 249));
		txt_filtrar.setBounds(219, 11, 188, 31);
		panel_contened_1.add(txt_filtrar);
		
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
						llenarTabla(conection.filtrar_tabla_inventario(field_filtrado,txt_filtrar.getText().toString()));
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else {
					txt_filtrar.setText("");
					llenarTabla(conection.obtenerInventario());
				}
			}
		});
		btn_filtrar_toggle.setOpaque(true);
		btn_filtrar_toggle.setBorderPainted(false);
		btn_filtrar_toggle.setBackground(new Color(32, 160, 216));
		btn_filtrar_toggle.setBounds(689, 38, 47, 43);
		contentPanel.add(btn_filtrar_toggle);
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
						llenarTabla(conection.obtenerInventario());
						btn_filtrar_toggle.setSelected(false);
					}
					
					else {
						String field_filtrado = cb_filtrar.getSelectedItem().toString();
						try {
							llenarTabla(conection.filtrar_tabla_inventario(field_filtrado,txt_filtrar.getText().toString()));
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
	

		
	public static DefaultTableModel llenarTabla(List<Inventario> inventario) {
       // Nos aseguramos de que la lista no sea Null
		
		// System.out.println(historialCitas.toString());
       if (inventario != null) {
           // Limpiamos el modelo de la tabla antes de agregar nuevos datos
           DefaultTableModel model = (DefaultTableModel) table.getModel();
           model.setRowCount(0);

           for (Inventario productos : inventario) {
               Object[] fila = new Object[3];
               fila[0] = productos.getId();
               fila[1] = productos.getNombre();
               fila[2] = productos.getCantidad();

            //   model.setRowCount(model.getRowCount()+1);
               model.addRow(fila);
           }


       }
 


       return model;
    }



	public JTextField getTxt_invisible() {
		return txt_invisible;
	}



	public void setTxt_invisible(String txt_invisible) {
		this.txt_invisible.setText(txt_invisible);
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



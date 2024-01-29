package dialogos_materiales;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import Modelo.Cita;
import Modelo.Inventario;
import Modelo.Paciente;
import Modelo.Pedido;
import Modelo.Solicitud;
import dentilax_bdd.ConectorDB_mysql;

public class jd_buscar_pedidos_encontrados extends JDialog {

    private static final long serialVersionUID = 1L;
    private final JPanel contentPanel = new JPanel();
    private static JTable table;
    private static DefaultTableModel model;
    private JTextField txt_invisible;
    private int indiceFilaSeleccionada;

    public jd_buscar_pedidos_encontrados() {
        setTitle("Pedidos");
        setIconImage(Toolkit.getDefaultToolkit().getImage(jd_buscar_pedidos_encontrados.class.getResource("/iconos_menus/dentilaxIcono.png")));
        setModal(true);
        setPreferredSize(new Dimension(723, 470));
        setResizable(false);
        setBounds(100, 100, 723, 471);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBackground(Color.WHITE);
        contentPanel.setPreferredSize(new Dimension(1198, 531));
        contentPanel.setBorder(null);
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        setLocationRelativeTo(contentPanel);
        contentPanel.setLayout(null);
        
        JPanel panel_contened = new JPanel();
        panel_contened.setBounds(30, 96, 638, 43);
        panel_contened.setBackground(new Color(32, 160, 216));
        contentPanel.add(panel_contened);
        panel_contened.setLayout(null);

        JLabel lbl_ID = new JLabel("ID");
        lbl_ID.setForeground(Color.WHITE);
        lbl_ID.setFont(new Font("Barlow", Font.BOLD, 17));
        lbl_ID.setBounds(34, 11, 96, 21);
        panel_contened.add(lbl_ID);

        JLabel lbl_producto = new JLabel("PRODUCTO");
        lbl_producto.setForeground(Color.WHITE);
        lbl_producto.setFont(new Font("Barlow", Font.BOLD, 17));
        lbl_producto.setBounds(256, 11, 110, 21);
        panel_contened.add(lbl_producto);
        
        JLabel lbl_cantidad_2 = new JLabel("FECHA");
        lbl_cantidad_2.setForeground(Color.WHITE);
        lbl_cantidad_2.setFont(new Font("Barlow", Font.BOLD, 17));
        lbl_cantidad_2.setBounds(528, 11, 110, 21);
        panel_contened.add(lbl_cantidad_2);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(30, 150, 638, 177);
        contentPanel.add(scrollPane);
        
                table = new JTable();
                table.setAutoCreateRowSorter(true);
                scrollPane.setViewportView(table);
                table.setModel(new DefaultTableModel(
                	new Object[][] {
                	},
                	new String[] {
                		"", "", ""
                	}
                ));
                for (int i = 0; i < table.getColumnCount(); i++) {
                	Class<?> col_class = table.getColumnClass(i);
                	table.setDefaultEditor(col_class,  null);
                	}
                table.getColumnModel().getColumn(0).setPreferredWidth(15);
                model = new DefaultTableModel();
                model.addColumn("ID");
                model.addColumn("Producto");
                model.addColumn("Fecha");
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(191, 231, 249));
		panel.setBounds(30, 31, 256, 54);
		contentPanel.add(panel);
		
		JLabel lbl_pedidos = new JLabel("PEDIDOS");
		lbl_pedidos.setFont(new Font("Barlow", Font.BOLD, 20));
		lbl_pedidos.setBounds(24, 0, 374, 54);
		panel.add(lbl_pedidos);
		
		txt_invisible = new JTextField();
		txt_invisible.setVisible(false);
		txt_invisible.setText("Invisible");
		txt_invisible.setEditable(false);
		txt_invisible.setColumns(10);
		txt_invisible.setBounds(545, 48, 0, 0);
		contentPanel.add(txt_invisible);
		
		        JButton btn_salir = new JButton("SALIR");
		        btn_salir.setBounds(515, 357, 153, 43);
		        contentPanel.add(btn_salir);
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
		        
		        JButton btn_ficha = new JButton("FICHA");
		        btn_ficha.setBounds(95, 357, 153, 43);
		        contentPanel.add(btn_ficha);
		        btn_ficha.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		        btn_ficha.addActionListener(new ActionListener() {
		        	public void actionPerformed(ActionEvent e) {
		        		if (indiceFilaSeleccionada != -1) {
		        			 int id_pedido = (int) table.getValueAt(indiceFilaSeleccionada, 0);
		        			 	String producto = (String) table.getValueAt(indiceFilaSeleccionada, 1);
		        			    Date fecha = (Date) table.getValueAt(indiceFilaSeleccionada, 2);
		        			    fecha.toString();
		                    // Actualizar la base de datos
		                    ConectorDB_mysql conection = new ConectorDB_mysql();
		                    conection.conectar();
		                    try {
			                    dispose();
		                    conection.consulta_pedido(id_pedido);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
		                }
		        	}
		        });
		        btn_ficha.setForeground(Color.WHITE);
		        btn_ficha.setFont(new Font("Barlow", Font.BOLD, 20));
		        btn_ficha.setBorderPainted(false);
		        btn_ficha.setBorder(null);
		        btn_ficha.setBackground(new Color(32, 160, 216));
		        btn_ficha.setActionCommand("Cancel");
		        
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

	public static DefaultTableModel llenarTabla(List<Pedido> pedidos) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);

        for (Pedido pedido : pedidos) {
            Object[] fila = new Object[5];
            fila[0] = pedido.getId_pedido();
            fila[1] = pedido.getNombre_producto();
            fila[2] = pedido.getFecha();

            model.addRow(fila);
        }

        return model;
    }
	
	public JTextField getTxt_invisible() {
		return txt_invisible;
	}



	public void setTxt_invisible(String txt_invisible) {
		this.txt_invisible.setText(txt_invisible);
	}
}


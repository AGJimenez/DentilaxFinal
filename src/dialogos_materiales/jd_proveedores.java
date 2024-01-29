package dialogos_materiales;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

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
import Modelo.Proveedores;
import dentilax_bdd.ConectorDB_mysql;

public class jd_proveedores extends JDialog {

    private static final long serialVersionUID = 1L;
    private final JPanel contentPanel = new JPanel();
    private static JTable table;
    private static DefaultTableModel model;
    private JTextField txt_invisible;

    public jd_proveedores() {
        setTitle("Proveedores");
        setIconImage(Toolkit.getDefaultToolkit().getImage(jd_proveedores.class.getResource("/iconos_menus/dentilaxIcono.png")));
        setModal(true);
        setPreferredSize(new Dimension(762, 531));
        setResizable(false);
        setBounds(100, 100, 730, 531);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBackground(Color.WHITE);
        contentPanel.setPreferredSize(new Dimension(1198, 531));
        contentPanel.setBorder(null);
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        setLocationRelativeTo(contentPanel);
        contentPanel.setLayout(null);

        JPanel panel_contened = new JPanel();
        panel_contened.setBounds(35, 96, 674, 43);
        panel_contened.setBackground(new Color(32, 160, 216));
        contentPanel.add(panel_contened);
        panel_contened.setLayout(null);

        JLabel lbl_ID = new JLabel("ID");
        lbl_ID.setForeground(Color.WHITE);
        lbl_ID.setFont(new Font("Barlow", Font.BOLD, 17));
        lbl_ID.setBounds(71, 11, 55, 21);
        panel_contened.add(lbl_ID);

        JLabel lbl_proveedor = new JLabel("PROVEEDOR");
        lbl_proveedor.setForeground(Color.WHITE);
        lbl_proveedor.setFont(new Font("Barlow", Font.BOLD, 17));
        lbl_proveedor.setBounds(201, 11, 110, 21);
        panel_contened.add(lbl_proveedor);

        JLabel lbl_producto = new JLabel("PRODUCTO");
        lbl_producto.setForeground(Color.WHITE);
        lbl_producto.setFont(new Font("Barlow", Font.BOLD, 17));
        lbl_producto.setBounds(366, 11, 127, 21);
        panel_contened.add(lbl_producto);
        
        JLabel lbl_precio = new JLabel("PRECIO");
        lbl_precio.setForeground(Color.WHITE);
        lbl_precio.setFont(new Font("Dialog", Font.BOLD, 17));
        lbl_precio.setBounds(537, 11, 127, 21);
        panel_contened.add(lbl_precio);

        JPanel buttonPane = new JPanel();
        buttonPane.setBackground(Color.WHITE);
        buttonPane.setPreferredSize(new Dimension(10, 60));
        getContentPane().add(buttonPane, BorderLayout.SOUTH);
        buttonPane.setLayout(null);
        
                JButton btn_salir = new JButton("SALIR");
                btn_salir.setBounds(555, 0, 153, 43);
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
                
                JButton btn_insertar = new JButton("NUEVO");
                btn_insertar.addActionListener(new ActionListener() {
                	public void actionPerformed(ActionEvent e) {
                		dispose();
                		jd_nuevo_proveedor nuevo = new jd_nuevo_proveedor();
                		nuevo.setVisible(true);
                		
                	}
                });
                btn_insertar.setForeground(Color.WHITE);
                btn_insertar.setFont(new Font("Barlow", Font.BOLD, 20));
                btn_insertar.setBorderPainted(false);
                btn_insertar.setBorder(null);
                btn_insertar.setBackground(new Color(32, 160, 216));
                btn_insertar.setActionCommand("Cancel");
                btn_insertar.setBounds(35, 0, 153, 43);
                buttonPane.add(btn_insertar);
                
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(38, 150, 671, 247);
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
                		"", "", "",""
                	}
                ));
                for (int i = 0; i < table.getColumnCount(); i++) {
                	Class<?> col_class = table.getColumnClass(i);
                	table.setDefaultEditor(col_class,  null);
                	}
		 model=new DefaultTableModel();
			model.addColumn("Id_proveedor");
			model.addColumn("Proveedor");
			model.addColumn("Producto");
			model.addColumn("Precio");
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(191, 231, 249));
		panel.setBounds(38, 29, 497, 54);
		contentPanel.add(panel);
		
		JLabel lbl_proveedores_disponible = new JLabel("PROVEEDORES DISPONIBLE");
		lbl_proveedores_disponible.setFont(new Font("Barlow", Font.BOLD, 20));
		lbl_proveedores_disponible.setBounds(24, 0, 307, 54);
		panel.add(lbl_proveedores_disponible);
		
		txt_invisible = new JTextField();
		txt_invisible.setVisible(false);
		txt_invisible.setText("Invisible");
		txt_invisible.setEditable(false);
		txt_invisible.setColumns(10);
		txt_invisible.setBounds(545, 48, 0, 0);
		contentPanel.add(txt_invisible);

	
		
			ConectorDB_mysql conection = new ConectorDB_mysql();
			conection.conectar();
			
			//System.out.println(conection.obtenerInfoProveedores().toString());
			llenarTabla(conection.obtenerProveedores() );
			
	}
	

		
	public static DefaultTableModel llenarTabla(List<Proveedores> proveedores) {
       // Nos aseguramos de que la lista no sea Null
		
		// System.out.println(historialCitas.toString());
       if (proveedores != null) {
           // Limpiamos el modelo de la tabla antes de agregar nuevos datos
           DefaultTableModel model = (DefaultTableModel) table.getModel();
           model.setRowCount(0);

           for (Proveedores info : proveedores) {
               Object[] fila = new Object[4];
               fila[0] = info.getId_proveedor();
               fila[1] = info.getProveedor();
               fila[2] = info.getProducto();
               fila[3] = info.getPrecio();

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
}


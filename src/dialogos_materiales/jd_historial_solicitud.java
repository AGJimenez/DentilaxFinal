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
import Modelo.Solicitud;
import dentilax_bdd.ConectorDB_mysql;

public class jd_historial_solicitud extends JDialog {

    private static final long serialVersionUID = 1L;
    private final JPanel contentPanel = new JPanel();
    private static JTable table;
    private static DefaultTableModel model;
    private JTextField txt_invisible;

    public jd_historial_solicitud() {
        setTitle("Pedido");
        setIconImage(Toolkit.getDefaultToolkit().getImage(jd_historial_solicitud.class.getResource("/iconos_menus/dentilaxIcono.png")));
        setModal(true);
        setPreferredSize(new Dimension(1198, 531));
        setResizable(false);
        setBounds(100, 100, 714, 466);
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
        lbl_ID.setBounds(21, 11, 26, 21);
        panel_contened.add(lbl_ID);

        JLabel lbl_producto = new JLabel("PRODUCTO");
        lbl_producto.setForeground(Color.WHITE);
        lbl_producto.setFont(new Font("Barlow", Font.BOLD, 17));
        lbl_producto.setBounds(73, 11, 90, 21);
        panel_contened.add(lbl_producto);

        JLabel lbl_cantidad = new JLabel("DOCTOR");
        lbl_cantidad.setForeground(Color.WHITE);
        lbl_cantidad.setFont(new Font("Barlow", Font.BOLD, 17));
        lbl_cantidad.setBounds(197, 11, 71, 21);
        panel_contened.add(lbl_cantidad);
        
        JLabel lbl_cantidad_1 = new JLabel("CANTIDAD");
        lbl_cantidad_1.setForeground(Color.WHITE);
        lbl_cantidad_1.setFont(new Font("Barlow", Font.BOLD, 17));
        lbl_cantidad_1.setBounds(306, 11, 85, 21);
        panel_contened.add(lbl_cantidad_1);
        
        JLabel lbl_cantidad_2 = new JLabel("FECHA");
        lbl_cantidad_2.setForeground(Color.WHITE);
        lbl_cantidad_2.setFont(new Font("Barlow", Font.BOLD, 17));
        lbl_cantidad_2.setBounds(424, 11, 71, 21);
        panel_contened.add(lbl_cantidad_2);
        
        JLabel lbl_cantidad_2_1 = new JLabel("ESTADO");
        lbl_cantidad_2_1.setForeground(Color.WHITE);
        lbl_cantidad_2_1.setFont(new Font("Barlow", Font.BOLD, 17));
        lbl_cantidad_2_1.setBounds(546, 11, 71, 21);
        panel_contened.add(lbl_cantidad_2_1);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBackground(new Color(255, 255, 255));
        scrollPane.setViewportBorder(null);
        scrollPane.setBounds(30, 150, 638, 177);
        contentPanel.add(scrollPane);
        
                table = new JTable();
                table.setAutoCreateRowSorter(true);
                scrollPane.setViewportView(table);
                
                table.setModel(new DefaultTableModel(
                	new Object[][] {
                		{null, null, null, null, null, null},
                		{null, null, null, null, null, null},
                		{null, null, null, null, null, null},
                		{null, null, null, null, null, null},
                		{null, null, null, null, null, null},
                		{null, null, null, null, null, null},
                		{null, null, null, null, null, null},
                		{null, null, null, null, null, null},
                		{null, null, null, null, null, null},
                		{null, null, null, null, null, null},
                		{null, null, null, null, null, null},
                		{null, null, null, null, null, null},
                		{null, null, null, null, null, null},
                		{null, null, null, null, null, null},
                		{null, null, null, null, null, null},
                	},
                	new String[] {
                		"", "", "", "", "", ""
                	}
                ));
                for (int i = 0; i < table.getColumnCount(); i++) {
                	Class<?> col_class = table.getColumnClass(i);
                	table.setDefaultEditor(col_class,  null);
                	}
                table.getColumnModel().getColumn(0).setResizable(false);
                table.getColumnModel().getColumn(0).setPreferredWidth(15);
                table.getColumnModel().getColumn(1).setResizable(false);
                table.getColumnModel().getColumn(2).setResizable(false);
                table.getColumnModel().getColumn(3).setResizable(false);
                table.getColumnModel().getColumn(4).setResizable(false);
                table.getColumnModel().getColumn(5).setResizable(false);
                model = new DefaultTableModel();
                model.addColumn("ID");
                model.addColumn("Producto");
                model.addColumn("Doctor");
                model.addColumn("Cantidad");
                model.addColumn("Fecha");
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(191, 231, 249));
		panel.setBounds(20, 31, 487, 54);
		contentPanel.add(panel);
		
		JLabel lbl_inventario_disponible = new JLabel("SOLICITUDES GLOBALES");
		lbl_inventario_disponible.setFont(new Font("Barlow", Font.BOLD, 20));
		lbl_inventario_disponible.setBounds(24, 0, 374, 54);
		panel.add(lbl_inventario_disponible);
		
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

	
		
			ConectorDB_mysql conection = new ConectorDB_mysql();
			conection.conectar();
			
			//System.out.println(conection.obtenerInfoCitas().toString());
			llenarTabla(conection.obtenerSolicitudes() );
			
	}
	

		
    public static DefaultTableModel llenarTabla(List<Solicitud> solicitudes) {
        if (solicitudes != null) {
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0);

            for (Solicitud solicitud : solicitudes) {
                Object[] fila = new Object[6];
                fila[0] = solicitud.getId_solicitud();
                fila[1] = solicitud.getNombre_producto();
                fila[2] = solicitud.getDni_doctor();
                fila[3] = solicitud.getCantidad();
                fila[4] = solicitud.getFecha(); // Utilizamos directamente el objeto Date
                fila[5] = solicitud.getEstado();

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


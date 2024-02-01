package dialogos_pacientes;

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

import com.mysql.jdbc.Connection;

import Modelo.Cita;
import Modelo.Paciente;
import dentilax_bdd.ConectorDB_mysql;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JToggleButton;

public class jd_buscar_paciente_historial extends JDialog {

    private static final long serialVersionUID = 1L;
    private final JPanel contentPanel = new JPanel();
    private JTextField txt_nombre_paciente;
    private static JTable table;
    private static DefaultTableModel model;
    protected JTextField txt_filtrar;
    dentilax_bdd.ConectorDB_mysql consultasDB = new dentilax_bdd.ConectorDB_mysql();
    private ConectorDB_mysql conection;
    JComboBox cb_filtrar = new JComboBox();

    public jd_buscar_paciente_historial(String DNI_paciente) {
    	try {
			//CON ESTO MOSTRAMOS LOS COMBO BOX
			consultasDB.mostrar_filtro_paciente_historial(this);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        setTitle("Historial de paciente");
        setIconImage(Toolkit.getDefaultToolkit().getImage(jd_buscar_paciente_historial.class.getResource("/iconos_menus/dentilaxIcono.png")));
        setModal(true);
        setPreferredSize(new Dimension(723, 531));
        setResizable(false);
        setBounds(100, 100, 709, 531);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBackground(Color.WHITE);
        contentPanel.setPreferredSize(new Dimension(1198, 531));
        contentPanel.setBorder(null);
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        setLocationRelativeTo(contentPanel);
        contentPanel.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(0, 32, 180, 54);
        panel.setBackground(new Color(191, 231, 249));
        contentPanel.add(panel);
        panel.setLayout(null);

        txt_nombre_paciente = new JTextField();
        txt_nombre_paciente.setEditable(false);
        txt_nombre_paciente.setFont(new Font("Barlow", Font.PLAIN, 20));
        txt_nombre_paciente.setText(DNI_paciente);
        txt_nombre_paciente.setBorder(null);
        txt_nombre_paciente.setOpaque(false);
        txt_nombre_paciente.setBounds(10, 0, 103, 54);
        panel.add(txt_nombre_paciente);
        txt_nombre_paciente.setColumns(10);

        JPanel panel_contened = new JPanel();
        panel_contened.setBounds(10, 97, 674, 43);
        panel_contened.setBackground(new Color(32, 160, 216));
        contentPanel.add(panel_contened);
        panel_contened.setLayout(null);

        JLabel lbl_fecha = new JLabel("FECHA");
        lbl_fecha.setForeground(Color.WHITE);
        lbl_fecha.setFont(new Font("Barlow", Font.BOLD, 17));
        lbl_fecha.setBounds(10, 11, 96, 21);
        panel_contened.add(lbl_fecha);

        JLabel lbl_tipo = new JLabel("TRATAMIENTO");
        lbl_tipo.setForeground(Color.WHITE);
        lbl_tipo.setFont(new Font("Barlow", Font.BOLD, 17));
        lbl_tipo.setBounds(203, 11, 149, 21);
        panel_contened.add(lbl_tipo);

        JLabel lbl_tratamiento = new JLabel("DOCTOR");
        lbl_tratamiento.setForeground(Color.WHITE);
        lbl_tratamiento.setFont(new Font("Barlow", Font.BOLD, 17));
        lbl_tratamiento.setBounds(462, 11, 110, 21);
        panel_contened.add(lbl_tratamiento);

        JPanel buttonPane = new JPanel();
        buttonPane.setBackground(Color.WHITE);
        buttonPane.setPreferredSize(new Dimension(10, 60));
        getContentPane().add(buttonPane, BorderLayout.SOUTH);
        buttonPane.setLayout(null);

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
        btn_salir.setBounds(530, 0, 153, 43);
        btn_salir.setActionCommand("Cancel");
        buttonPane.add(btn_salir);
        
        JButton btn_salir_1 = new JButton("IMPRIMIR");
        btn_salir_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btn_salir_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try {
    				Map parametros = new HashMap();
    				parametros.put("DNI_paciente", DNI_paciente);
    				JasperReport reporte = JasperCompileManager.compileReport("Informes/Historial_paciente.jrxml");
    				JasperPrint jp;
    				ConectorDB_mysql c = new ConectorDB_mysql();
    					jp = JasperFillManager.fillReport(reporte, parametros, c.conectar() );
    					JasperViewer.viewReport(jp,false);
    				} catch (JRException e1) {
    					// TODO Auto-generated catch block
    					e1.printStackTrace();
    				}
        	}
        }
        	
        );
        btn_salir_1.setForeground(Color.WHITE);
        btn_salir_1.setFont(new Font("Barlow", Font.BOLD, 20));
        btn_salir_1.setBorderPainted(false);
        btn_salir_1.setBorder(null);
        btn_salir_1.setBackground(new Color(32, 160, 216));
        btn_salir_1.setActionCommand("Cancel");
        btn_salir_1.setBounds(65, 0, 153, 43);
        buttonPane.add(btn_salir_1);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(12, 147, 671, 265);
        contentPanel.add(scrollPane);

        ConectorDB_mysql conection = new ConectorDB_mysql();
        List<Cita> historialPaciente = conection.obtenerInfoPaciente(DNI_paciente);

        table = new JTable();
        model = new DefaultTableModel();
        
        model.addColumn("");
        model.addColumn("");
        model.addColumn("");
        table.setModel(model);
        scrollPane.setViewportView(table);
        
        JPanel panel_contened_1 = new JPanel();
        panel_contened_1.setLayout(null);
        panel_contened_1.setBackground(new Color(32, 160, 216));
        panel_contened_1.setBounds(193, 35, 417, 53);
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
		btn_filtrar_toggle.setSelectedIcon(new ImageIcon(jd_buscar_paciente_historial.class.getResource("/iconos_submenus/nofiltrar.png")));
		btn_filtrar_toggle.setIcon(new ImageIcon(jd_buscar_paciente_historial.class.getResource("/iconos_submenus/iconoFiltrar.png")));
		btn_filtrar_toggle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btn_filtrar_toggle.isSelected()) {
					String field_filtrado = cb_filtrar.getSelectedItem().toString();
					try {
						llenarTabla(conection.filtrar_tabla_paciente_historial(field_filtrado,txt_filtrar.getText().toString(), getTxt_nombre_paciente().getText().toString()));
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else {
					txt_filtrar.setText("");
					llenarTabla(historialPaciente);
				}
			}
		});
        btn_filtrar_toggle.setOpaque(true);
        btn_filtrar_toggle.setBorderPainted(false);
        btn_filtrar_toggle.setBackground(new Color(32, 160, 216));
        btn_filtrar_toggle.setBounds(635, 40, 47, 43);
        contentPanel.add(btn_filtrar_toggle);
        for (int i = 0; i < table.getColumnCount(); i++) {
        	Class<?> col_class = table.getColumnClass(i);
        	table.setDefaultEditor(col_class,  null);
        	}
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
						llenarTabla(historialPaciente);
						btn_filtrar_toggle.setSelected(false);
					}
					
					else {
						String field_filtrado = cb_filtrar.getSelectedItem().toString();
						try {
							llenarTabla(conection.filtrar_tabla_paciente_historial(field_filtrado,txt_filtrar.getText().toString(), getTxt_nombre_paciente().getText().toString()));
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						btn_filtrar_toggle.setSelected(true);
					}
				}
			}
		});
        

        conection.conectar();

        llenarTabla(historialPaciente);
    }

    public void llenarTabla(List<Cita> historialPaciente) {
    	DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
            for (Cita historial : historialPaciente) {
                Object[] fila = new Object[3];
                fila[0] = historial.getFecha();
                fila[1] = historial.getEspecialidad();
                fila[2] = historial.getDniDoctor();
                model.addRow(fila);
            }
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

	public JTextField getTxt_nombre_paciente() {
		return txt_nombre_paciente;
	}

	public void setTxt_nombre_paciente(JTextField txt_nombre_paciente) {
		this.txt_nombre_paciente = txt_nombre_paciente;
	}
}


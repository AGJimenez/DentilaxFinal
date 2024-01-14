package dialogos_materiales;



import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dentilax_bdd.ConectorDB_mysql;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.awt.Toolkit;
import javax.swing.JComboBox;

public class jd_hacer_pedido extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txt_cantidad;
	private JTextField txt_invisible_2;
	dentilax_bdd.ConectorDB_mysql consultasDB = new dentilax_bdd.ConectorDB_mysql();
	private List<String> inventario = new ArrayList<>();
	JComboBox cb_productos = new JComboBox();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			jd_hacer_pedido dialog = new jd_hacer_pedido();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public jd_hacer_pedido() {
		try {
			consultasDB.mostarCbProductosProv(this);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setTitle("Nuevo pedido");
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(jd_hacer_pedido.class.getResource("/iconos_menus/dentilaxIcono.png")));
		setModal(true);
		setBounds(100, 100, 590, 322);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(contentPanel);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(0, 128, 192));
		separator.setForeground(new Color(0, 128, 192));
		separator.setBounds(12, 162, 252, 8);
		contentPanel.add(separator);
		
		JPanel panel_contened = new JPanel();
		panel_contened.setLayout(null);
		panel_contened.setBackground(new Color(32, 160, 216));
		panel_contened.setBounds(10, 43, 557, 43);
		contentPanel.add(panel_contened);
		
		JLabel lbl_cantidad = new JLabel("CANTIDAD");
		lbl_cantidad.setForeground(Color.WHITE);
		lbl_cantidad.setFont(new Font("Barlow", Font.BOLD, 17));
		lbl_cantidad.setBounds(338, 11, 96, 21);
		panel_contened.add(lbl_cantidad);
		
		JLabel lbl_producto = new JLabel("PRODUCTO");
		lbl_producto.setForeground(Color.WHITE);
		lbl_producto.setFont(new Font("Barlow", Font.BOLD, 17));
		lbl_producto.setBounds(63, 11, 110, 21);
		panel_contened.add(lbl_producto);
		
		txt_cantidad = new JTextField();
		txt_cantidad.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txt_cantidad.getText().equals("Introduce cantidad")) {
					txt_cantidad.setText("");
				}
				txt_cantidad.setForeground(Color.BLACK);
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (txt_cantidad.getText().isEmpty()) {
					txt_cantidad.setText("Introduce cantidad");
				}
			}
		});
		
		
		txt_cantidad.setText("Introduce cantidad");
		txt_cantidad.setOpaque(false);
		txt_cantidad.setHorizontalAlignment(SwingConstants.CENTER);
		txt_cantidad.setFont(new Font("Arial", Font.PLAIN, 17));
		txt_cantidad.setColumns(10);
		txt_cantidad.setBorder(null);
		txt_cantidad.setBackground((Color) null);
		txt_cantidad.setBounds(321, 126, 164, 44);
		contentPanel.add(txt_cantidad);
		
		txt_cantidad.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER) {
				dentilax_bdd.ConectorDB_mysql consulta = new dentilax_bdd.ConectorDB_mysql();

		        String splitted[] =  cb_productos.getSelectedItem().toString().split(": ");
		        String producto = splitted[1];
				consulta.insertar_solicitud(producto, getTxt_invisible_2().getText().toString(), txt_cantidad.getText().toString());
				JOptionPane.showMessageDialog(null, "Producto "+producto+" solicitado con éxito");
				//SQL 
				dispose();
				}
			}
		});
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(new Color(0, 128, 192));
		separator_1.setBackground(new Color(0, 128, 192));
		separator_1.setBounds(321, 162, 164, 8);
		contentPanel.add(separator_1);
		
		txt_invisible_2 = new JTextField();
		txt_invisible_2.setVisible(false);
		txt_invisible_2.setEditable(false);
		txt_invisible_2.setText("Invisible");
		txt_invisible_2.setBounds(25, 11, 0, 0);
		contentPanel.add(txt_invisible_2);
		txt_invisible_2.setColumns(10);
		
		cb_productos.setFont(new Font("Arial", Font.PLAIN, 14));
		cb_productos.setBackground(new Color(191, 231, 249));
		cb_productos.setBounds(14, 120, 248, 37);
		contentPanel.add(cb_productos);
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setPreferredSize(new Dimension(10, 60));
			buttonPane.setBackground(Color.WHITE);
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(null);
			{
				JButton btn_anadir = new JButton("PEDIR");
				btn_anadir.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dentilax_bdd.ConectorDB_mysql consulta = new dentilax_bdd.ConectorDB_mysql();

				        String producto =  cb_productos.getSelectedItem().toString();
						int cantidad = Integer.parseInt(txt_cantidad.getText().toString());
						try {
							consulta.insertar_pedido(producto,  cantidad);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						//SQL 
						dispose();
					}
				});
				btn_anadir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				btn_anadir.setBorderPainted(false);
				btn_anadir.setFont(new Font("Barlow", Font.BOLD, 20));
				btn_anadir.setForeground(new Color(255, 255, 255));
				btn_anadir.setBackground(new Color(32, 160, 216));
				btn_anadir.setBounds(41, 0, 153, 43);
				btn_anadir.setActionCommand("OK");
				buttonPane.add(btn_anadir);
				
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
				btn_cancelar.setBounds(355, 0, 153, 43);
				btn_cancelar.setActionCommand("Cancel");
				buttonPane.add(btn_cancelar);
				
			}
			
		}
		
		
	}

	public JTextField getTxt_invisible_2() {
		return txt_invisible_2;
	}

	public void setTxt_invisible_2(String txt_invisible) {
		this.txt_invisible_2.setText(txt_invisible);
	}
	
	public JComboBox<String> getCb_productos() {
        return cb_productos;
    }

	 public void setCb_productos(String items) {
		 cb_productos.addItem(items); 
	    }
}

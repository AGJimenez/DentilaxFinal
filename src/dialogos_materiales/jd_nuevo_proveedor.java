package dialogos_materiales;



import java.awt.BorderLayout;
import java.awt.FlowLayout;

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
import java.awt.Toolkit;

public class jd_nuevo_proveedor extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txt_proveedor;
	private JTextField txt_producto;
	private JTextField txt_invisible_2;
	private JTextField txt_precio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			jd_nuevo_proveedor dialog = new jd_nuevo_proveedor();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public jd_nuevo_proveedor() {
		setTitle("Nuevo proveedor");
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(jd_nuevo_proveedor.class.getResource("/iconos_menus/dentilaxIcono.png")));
		setModal(true);
		setBounds(100, 100, 453, 322);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(contentPanel);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(0, 128, 192));
		separator.setForeground(new Color(0, 128, 192));
		separator.setBounds(98, 66, 237, 8);
		contentPanel.add(separator);
		
		
		txt_proveedor = new JTextField();
		txt_proveedor.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txt_proveedor.getText().equals("Introduce producto")) {
					txt_proveedor.setText("");
				}
				txt_proveedor.setForeground(Color.BLACK);
                
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (txt_proveedor.getText().isEmpty()) {
					txt_proveedor.setText("Introduce producto");
				}
			}
		});
		txt_proveedor.setOpaque(false);
		txt_proveedor.setHorizontalAlignment(SwingConstants.CENTER);
		txt_proveedor.setText("Introduce proveedor");
		txt_proveedor.setBorder(null);
		txt_proveedor.setFont(new Font("Arial", Font.PLAIN, 17));
		txt_proveedor.setBounds(96, 22, 164, 44);
		txt_proveedor.setBackground(null);
		contentPanel.add(txt_proveedor);
		txt_proveedor.setColumns(10);
		
		txt_producto = new JTextField();
		txt_producto.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txt_producto.getText().equals("Introduce cantidad")) {
					txt_producto.setText("");
				}
				txt_producto.setForeground(Color.BLACK);
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (txt_producto.getText().isEmpty()) {
					txt_producto.setText("Introduce cantidad");
				}
			}
		});
		
		
		txt_producto.setText("Introduce producto");
		txt_producto.setOpaque(false);
		txt_producto.setHorizontalAlignment(SwingConstants.CENTER);
		txt_producto.setFont(new Font("Arial", Font.PLAIN, 17));
		txt_producto.setColumns(10);
		txt_producto.setBorder(null);
		txt_producto.setBackground((Color) null);
		txt_producto.setBounds(98, 85, 164, 44);
		contentPanel.add(txt_producto);
		
		txt_producto.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER) {
				dentilax_bdd.ConectorDB_mysql consulta = new dentilax_bdd.ConectorDB_mysql();
				consulta.insertar_solicitud(txt_proveedor.getText().toString(), getTxt_invisible_2().getText().toString(), txt_producto.getText().toString());
				JOptionPane.showMessageDialog(null, "Producto "+txt_proveedor.getText().toString()+" solicitado con éxito");
				//SQL 
				dispose();
				}
			}
		});
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(new Color(0, 128, 192));
		separator_1.setBackground(new Color(0, 128, 192));
		separator_1.setBounds(98, 121, 237, 8);
		contentPanel.add(separator_1);
		
		txt_invisible_2 = new JTextField();
		txt_invisible_2.setVisible(false);
		txt_invisible_2.setEditable(false);
		txt_invisible_2.setText("Invisible");
		txt_invisible_2.setBounds(70, 11, 0, 0);
		contentPanel.add(txt_invisible_2);
		txt_invisible_2.setColumns(10);
		
		txt_precio = new JTextField();
		txt_precio.setText("Introduce precio");
		txt_precio.setOpaque(false);
		txt_precio.setHorizontalAlignment(SwingConstants.CENTER);
		txt_precio.setFont(new Font("Arial", Font.PLAIN, 17));
		txt_precio.setColumns(10);
		txt_precio.setBorder(null);
		txt_precio.setBackground((Color) null);
		txt_precio.setBounds(98, 156, 164, 44);
		contentPanel.add(txt_precio);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setForeground(new Color(0, 128, 192));
		separator_1_1.setBackground(new Color(0, 128, 192));
		separator_1_1.setBounds(98, 192, 237, 8);
		contentPanel.add(separator_1_1);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setPreferredSize(new Dimension(10, 60));
			buttonPane.setBackground(Color.WHITE);
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(null);
			{
				JButton btn_anadir = new JButton("AÑADIR");
				btn_anadir.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dentilax_bdd.ConectorDB_mysql consulta = new dentilax_bdd.ConectorDB_mysql();
						try {
							consulta.insertar_proveedor(txt_proveedor.getText().toString(), txt_precio.getText().toString(), txt_producto.getText().toString());
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
	                    JOptionPane.showMessageDialog(null,
	                            "Proveedor " + txt_proveedor.getText().toString() + " añadido con éxito");
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
				btn_cancelar.setBounds(240, 0, 153, 43);
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
}

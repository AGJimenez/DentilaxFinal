package dialogos_materiales;



import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class jd_buscar_pedido_ficha extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txt_id;
	private JTextField txt_producto;
	private JTextField txt_cantidad;
	private JTextField txt_precio;
	private JTextField txt_fecha;
	private JTextField txt_proveedor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			jd_buscar_pedido_ficha dialog = new jd_buscar_pedido_ficha();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public jd_buscar_pedido_ficha() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(jd_buscar_pedido_ficha.class.getResource("/iconos_menus/dentilaxIcono.png")));
		setTitle("Ficha pedido");
		setModal(true);
		setPreferredSize(new Dimension(545, 554));
		setResizable(false);
		setBounds(100, 100, 545, 554);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(contentPanel);
		{
			JLabel lbl_pedido = new JLabel("PEDIDO:");
			lbl_pedido.setFont(new Font("Barlow", Font.BOLD, 20));
			lbl_pedido.setBounds(35, 35, 167, 42);
			contentPanel.add(lbl_pedido);
		}
		{
			JLabel lbl_id = new JLabel("ID");
			lbl_id.setForeground(new Color(0, 128, 192));
			lbl_id.setFont(new Font("Barlow", Font.BOLD, 22));
			lbl_id.setBounds(69, 99, 38, 44);
			contentPanel.add(lbl_id);
		}
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(191, 231, 249));
			panel.setBounds(0, 24, 217, 64);
			contentPanel.add(panel);
		}
		{
			JLabel lbl_producto = new JLabel("Producto");
			lbl_producto.setForeground(new Color(0, 128, 192));
			lbl_producto.setFont(new Font("Barlow", Font.BOLD, 22));
			lbl_producto.setBounds(69, 146, 100, 44);
			contentPanel.add(lbl_producto);
		}
		{
			JLabel lbl_cantidad = new JLabel("Cantidad");
			lbl_cantidad.setForeground(new Color(0, 128, 192));
			lbl_cantidad.setFont(new Font("Barlow", Font.BOLD, 22));
			lbl_cantidad.setBounds(69, 194, 100, 44);
			contentPanel.add(lbl_cantidad);
		}
		{
			txt_id = new JTextField();
			txt_id.setEditable(false);
			txt_id.setBorder(null);
			txt_id.setBackground(new Color(191, 231, 249));
			txt_id.setFont(new Font("Arial", Font.PLAIN, 14));
			txt_id.setHorizontalAlignment(SwingConstants.CENTER);
			txt_id.setBounds(223, 99, 226, 34);
			contentPanel.add(txt_id);
			txt_id.setColumns(10);
		}
		{
			txt_producto = new JTextField();
			txt_producto.setEditable(false);
			txt_producto.setBorder(null);
			txt_producto.setBackground(new Color(191, 231, 249));
			txt_producto.setFont(new Font("Arial", Font.PLAIN, 14));
			txt_producto.setHorizontalAlignment(SwingConstants.CENTER);
			txt_producto.setBounds(223, 146, 226, 34);
			contentPanel.add(txt_producto);
			txt_producto.setColumns(10);
		}
		{
			txt_cantidad = new JTextField();
			txt_cantidad.setEditable(false);
			txt_cantidad.setHorizontalAlignment(SwingConstants.CENTER);
			txt_cantidad.setBorder(null);
			txt_cantidad.setBackground(new Color(191, 231, 249));
			txt_cantidad.setFont(new Font("Arial", Font.PLAIN, 14));
			txt_cantidad.setBounds(224, 194, 225, 34);
			contentPanel.add(txt_cantidad);
			txt_cantidad.setColumns(10);
		}
		{
			JLabel lbl_Precio = new JLabel("Precio");
			lbl_Precio.setForeground(new Color(0, 128, 192));
			lbl_Precio.setFont(new Font("Barlow", Font.BOLD, 22));
			lbl_Precio.setBounds(69, 243, 100, 44);
			contentPanel.add(lbl_Precio);
		}
		{
			txt_precio = new JTextField();
			txt_precio.setHorizontalAlignment(SwingConstants.CENTER);
			txt_precio.setFont(new Font("Arial", Font.PLAIN, 14));
			txt_precio.setEditable(false);
			txt_precio.setColumns(10);
			txt_precio.setBorder(null);
			txt_precio.setBackground(new Color(191, 231, 249));
			txt_precio.setBounds(224, 243, 225, 34);
			contentPanel.add(txt_precio);
		}
		{
			JLabel lbl_fecha = new JLabel("Fecha");
			lbl_fecha.setForeground(new Color(0, 128, 192));
			lbl_fecha.setFont(new Font("Barlow", Font.BOLD, 22));
			lbl_fecha.setBounds(69, 288, 126, 44);
			contentPanel.add(lbl_fecha);
		}
		{
			txt_fecha = new JTextField();
			txt_fecha.setHorizontalAlignment(SwingConstants.CENTER);
			txt_fecha.setFont(new Font("Arial", Font.PLAIN, 14));
			txt_fecha.setEditable(false);
			txt_fecha.setColumns(10);
			txt_fecha.setBorder(null);
			txt_fecha.setBackground(new Color(191, 231, 249));
			txt_fecha.setBounds(224, 288, 225, 34);
			contentPanel.add(txt_fecha);
		}
		{
			JLabel lbl_proveedor = new JLabel("Proveedor");
			lbl_proveedor.setForeground(new Color(0, 128, 192));
			lbl_proveedor.setFont(new Font("Barlow", Font.BOLD, 22));
			lbl_proveedor.setBounds(69, 333, 126, 44);
			contentPanel.add(lbl_proveedor);
		}
		{
			txt_proveedor = new JTextField();
			txt_proveedor.setHorizontalAlignment(SwingConstants.CENTER);
			txt_proveedor.setFont(new Font("Arial", Font.PLAIN, 14));
			txt_proveedor.setEditable(false);
			txt_proveedor.setColumns(10);
			txt_proveedor.setBorder(null);
			txt_proveedor.setBackground(new Color(191, 231, 249));
			txt_proveedor.setBounds(224, 333, 225, 34);
			contentPanel.add(txt_proveedor);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.WHITE);
			buttonPane.setPreferredSize(new Dimension(10, 60));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(null);
			{
				JButton btn_salir = new JButton("SALIR");
				btn_salir.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btn_salir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				btn_salir.setBorderPainted(false);
				btn_salir.setFont(new Font("Barlow", Font.BOLD, 20));
				btn_salir.setForeground(new Color(255, 255, 255));
				btn_salir.setBackground(new Color(32, 160, 216));
				btn_salir.setBounds(364, 0, 153, 43);
				btn_salir.setActionCommand("Cancel");
				buttonPane.add(btn_salir);
			}
		}
	}

	public JTextField getTxt_id() {
		return txt_id;
	}

	public void setTxt_id(String txt_id) {
		this.txt_id.setText(txt_id);
	}

	public JTextField getTxt_producto() {
		return txt_producto;
	}

	public void setTxt_producto(String txt_producto) {
		this.txt_producto.setText(txt_producto);
	}

	public JTextField getTxt_cantidad() {
		return txt_cantidad;
	}

	public void setTxt_cantidad(String txt_cantidad) {
		this.txt_cantidad.setText(txt_cantidad);
	}

	public JTextField getTxt_precio() {
		return txt_precio;
	}

	public void setTxt_precio(String txt_precio) {
		this.txt_precio.setText(txt_precio);
	}

	public JTextField getTxt_fecha() {
		return txt_fecha;
	}

	public void setTxt_fecha(String txt_fecha) {
		this.txt_fecha.setText(txt_fecha);
	}

	public JTextField getTxt_proveedor() {
		return txt_proveedor;
	}

	public void setTxt_proveedor(String txt_proveedor) {
		this.txt_proveedor.setText(txt_proveedor);
	}
}

package dialogos_facturas;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Cursor;

public class jd_ver_factura extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtIntroduceTexto;
	private JTextField txtIntroduceApellidos;
	private JTextField txtIntroduceDni;
	private JTextField txtIntroduceDireccion;
	private JTextField txtIntroduceTelefono;
	private JTextField txtIntroduceFecha;
	private JTextField txtIntroducePagado;
	private JTextField txtIntroducePorPagar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			jd_ver_factura dialog = new jd_ver_factura();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public jd_ver_factura() {
		setTitle("Ver factura");
		setIconImage(Toolkit.getDefaultToolkit().getImage(jd_ver_factura.class.getResource("/iconos_menus/dentilaxIcono.png")));
		setResizable(false);
		setBounds(100, 100, 614, 770);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 255, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(this);
		JLabel lblNombre = new JLabel("NOMBRE");
		lblNombre.setForeground(new Color(0, 128, 192));
		lblNombre.setFont(new Font("Barlow", Font.BOLD, 20));
		lblNombre.setBounds(80, 120, 114, 31);
		contentPanel.add(lblNombre);
		
		JLabel lblApellidos = new JLabel("APELLIDOS");
		lblApellidos.setForeground(new Color(0, 128, 192));
		lblApellidos.setFont(new Font("Barlow", Font.BOLD, 20));
		lblApellidos.setBounds(80, 188, 114, 24);
		contentPanel.add(lblApellidos);
		
		JLabel lblDni = new JLabel("DNI");
		lblDni.setForeground(new Color(0, 128, 192));
		lblDni.setFont(new Font("Barlow", Font.BOLD, 20));
		lblDni.setBounds(80, 256, 60, 18);
		contentPanel.add(lblDni);
		
		JLabel lblDireccion = new JLabel("DIRECCION");
		lblDireccion.setForeground(new Color(0, 128, 192));
		lblDireccion.setFont(new Font("Barlow", Font.BOLD, 20));
		lblDireccion.setBounds(80, 304, 114, 37);
		contentPanel.add(lblDireccion);
		
		JLabel lblTelefono = new JLabel("TELEFONO");
		lblTelefono.setForeground(new Color(0, 128, 192));
		lblTelefono.setFont(new Font("Barlow", Font.BOLD, 20));
		lblTelefono.setBounds(80, 384, 114, 24);
		contentPanel.add(lblTelefono);
		
		JLabel lblFecha = new JLabel("FECHA");
		lblFecha.setForeground(new Color(0, 128, 192));
		lblFecha.setFont(new Font("Barlow", Font.BOLD, 20));
		lblFecha.setBounds(80, 432, 114, 37);
		contentPanel.add(lblFecha);
		
		JLabel lblPagado = new JLabel("PAGADO");
		lblPagado.setForeground(new Color(0, 128, 192));
		lblPagado.setFont(new Font("Barlow", Font.BOLD, 20));
		lblPagado.setBounds(80, 511, 114, 24);
		contentPanel.add(lblPagado);
		
		JLabel lblPorPagar = new JLabel("POR PAGAR");
		lblPorPagar.setForeground(new Color(0, 128, 192));
		lblPorPagar.setFont(new Font("Barlow", Font.BOLD, 20));
		lblPorPagar.setBounds(80, 567, 114, 31);
		contentPanel.add(lblPorPagar);
		
		txtIntroduceTexto = new JTextField();
		txtIntroduceTexto.setEditable(false);
		txtIntroduceTexto.setBackground(new Color(191, 231, 249));
		txtIntroduceTexto.setFont(new Font("Arial", Font.PLAIN, 14));
		txtIntroduceTexto.setText(" ");
		txtIntroduceTexto.setBounds(236, 111, 264, 40);
		contentPanel.add(txtIntroduceTexto);
		txtIntroduceTexto.setColumns(10);
		
		txtIntroduceApellidos = new JTextField();
		txtIntroduceApellidos.setEditable(false);
		txtIntroduceApellidos.setBackground(new Color(191, 231, 249));
		txtIntroduceApellidos.setFont(new Font("Arial", Font.PLAIN, 14));
		txtIntroduceApellidos.setText(" ");
		txtIntroduceApellidos.setBounds(236, 174, 264, 40);
		contentPanel.add(txtIntroduceApellidos);
		txtIntroduceApellidos.setColumns(10);
		
		txtIntroduceDni = new JTextField();
		txtIntroduceDni.setEditable(false);
		txtIntroduceDni.setBackground(new Color(191, 231, 249));
		txtIntroduceDni.setText(" ");
		txtIntroduceDni.setFont(new Font("Arial", Font.PLAIN, 14));
		txtIntroduceDni.setBounds(234, 239, 264, 40);
		contentPanel.add(txtIntroduceDni);
		txtIntroduceDni.setColumns(10);
		
		txtIntroduceDireccion = new JTextField();
		txtIntroduceDireccion.setEditable(false);
		txtIntroduceDireccion.setBackground(new Color(191, 231, 249));
		txtIntroduceDireccion.setText(" ");
		txtIntroduceDireccion.setFont(new Font("Arial", Font.PLAIN, 14));
		txtIntroduceDireccion.setBounds(236, 301, 264, 40);
		contentPanel.add(txtIntroduceDireccion);
		txtIntroduceDireccion.setColumns(10);
		
		txtIntroduceTelefono = new JTextField();
		txtIntroduceTelefono.setEditable(false);
		txtIntroduceTelefono.setBackground(new Color(191, 231, 249));
		txtIntroduceTelefono.setText(" ");
		txtIntroduceTelefono.setFont(new Font("Arial", Font.PLAIN, 14));
		txtIntroduceTelefono.setBounds(236, 368, 264, 40);
		contentPanel.add(txtIntroduceTelefono);
		txtIntroduceTelefono.setColumns(10);
		
		txtIntroduceFecha = new JTextField();
		txtIntroduceFecha.setEditable(false);
		txtIntroduceFecha.setBackground(new Color(191, 231, 249));
		txtIntroduceFecha.setText(" ");
		txtIntroduceFecha.setFont(new Font("Arial", Font.PLAIN, 14));
		txtIntroduceFecha.setBounds(236, 429, 264, 40);
		contentPanel.add(txtIntroduceFecha);
		txtIntroduceFecha.setColumns(10);
		
		txtIntroducePagado = new JTextField();
		txtIntroducePagado.setEditable(false);
		txtIntroducePagado.setBackground(new Color(191, 231, 249));
		txtIntroducePagado.setText(" ");
		txtIntroducePagado.setFont(new Font("Arial", Font.PLAIN, 14));
		txtIntroducePagado.setBounds(236, 495, 264, 40);
		contentPanel.add(txtIntroducePagado);
		txtIntroducePagado.setColumns(10);
		
		txtIntroducePorPagar = new JTextField();
		txtIntroducePorPagar.setEditable(false);
		txtIntroducePorPagar.setBackground(new Color(191, 231, 249));
		txtIntroducePorPagar.setText(" ");
		txtIntroducePorPagar.setFont(new Font("Arial", Font.PLAIN, 14));
		txtIntroducePorPagar.setBounds(236, 558, 264, 40);
		contentPanel.add(txtIntroducePorPagar);
		txtIntroducePorPagar.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(191, 231, 249));
		panel.setForeground(new Color(191, 231, 249));
		panel.setBounds(0, 37, 397, 50);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblDentilax = new JLabel("DENTILAX CLINICA ODONTOLOGICA");
		lblDentilax.setBounds(37, 11, 308, 24);
		panel.add(lblDentilax);
		lblDentilax.setFont(new Font("Barlow", Font.BOLD, 20));
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setPreferredSize(new Dimension(30, 80));
			buttonPane.setSize(new Dimension(20, 20));
			buttonPane.setBackground(new Color(255, 255, 255));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(null);
			{
				JButton btn_imprimir = new JButton("IMPRIMIR");
				btn_imprimir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				btn_imprimir.setForeground(Color.WHITE);
				btn_imprimir.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				btn_imprimir.setBorderPainted(false);
				btn_imprimir.setBorder(null);
				btn_imprimir.setBackground(new Color(32, 160, 216));
				btn_imprimir.setBounds(43, 5, 153, 43);
				btn_imprimir.setFont(new Font("Barlow", Font.BOLD, 20));
				btn_imprimir.setActionCommand("OK");
				buttonPane.add(btn_imprimir);
				getRootPane().setDefaultButton(btn_imprimir);
			}
			{
				JButton btn_salir = new JButton("SALIR");
				btn_salir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				btn_salir.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btn_salir.setForeground(Color.WHITE);
				btn_salir.setBorderPainted(false);
				btn_salir.setBorder(null);
				btn_salir.setBackground(new Color(32, 160, 216));
				btn_salir.setBounds(407, 5, 153, 43);
				btn_salir.setFont(new Font("Barlow", Font.BOLD, 20));
				btn_salir.setActionCommand("Cancel");
				buttonPane.add(btn_salir);
			}
		}
	}
}

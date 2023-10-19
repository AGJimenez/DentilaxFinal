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

public class jd_buscar_factura extends JDialog {

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
			jd_buscar_factura dialog = new jd_buscar_factura();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public jd_buscar_factura() {
		setResizable(false);
		setBounds(100, 100, 545, 564);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 255, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblDentilax = new JLabel("DENTILAX CLINICA ODONTOLOGICA");
		lblDentilax.setFont(new Font("Barlow", Font.BOLD, 20));
		lblDentilax.setBounds(201, 26, 317, 31);
		contentPanel.add(lblDentilax);
		
		JLabel lblNombre = new JLabel("NOMBRE");
		lblNombre.setFont(new Font("Barlow", Font.BOLD, 20));
		lblNombre.setBounds(45, 89, 114, 31);
		contentPanel.add(lblNombre);
		
		JLabel lblApellidos = new JLabel("APELLIDOS");
		lblApellidos.setFont(new Font("Barlow", Font.BOLD, 20));
		lblApellidos.setBounds(45, 131, 114, 24);
		contentPanel.add(lblApellidos);
		
		JLabel lblDni = new JLabel("DNI");
		lblDni.setFont(new Font("Barlow", Font.BOLD, 20));
		lblDni.setBounds(45, 169, 60, 18);
		contentPanel.add(lblDni);
		
		JLabel lblDireccion = new JLabel("DIRECCION");
		lblDireccion.setFont(new Font("Barlow", Font.BOLD, 20));
		lblDireccion.setBounds(45, 196, 114, 37);
		contentPanel.add(lblDireccion);
		
		JLabel lblTelefono = new JLabel("TELEFONO");
		lblTelefono.setFont(new Font("Barlow", Font.BOLD, 20));
		lblTelefono.setBounds(45, 240, 114, 24);
		contentPanel.add(lblTelefono);
		
		JLabel lblFecha = new JLabel("FECHA");
		lblFecha.setFont(new Font("Barlow", Font.BOLD, 20));
		lblFecha.setBounds(45, 275, 114, 37);
		contentPanel.add(lblFecha);
		
		JLabel lblPagado = new JLabel("PAGADO");
		lblPagado.setFont(new Font("Barlow", Font.BOLD, 20));
		lblPagado.setBounds(45, 317, 114, 24);
		contentPanel.add(lblPagado);
		
		JLabel lblPorPagar = new JLabel("POR PAGAR");
		lblPorPagar.setFont(new Font("Barlow", Font.BOLD, 20));
		lblPorPagar.setBounds(45, 352, 114, 31);
		contentPanel.add(lblPorPagar);
		
		txtIntroduceTexto = new JTextField();
		txtIntroduceTexto.setFont(new Font("Barlow", Font.BOLD, 20));
		txtIntroduceTexto.setText("Introduce texto");
		txtIntroduceTexto.setBounds(201, 94, 264, 20);
		contentPanel.add(txtIntroduceTexto);
		txtIntroduceTexto.setColumns(10);
		
		txtIntroduceApellidos = new JTextField();
		txtIntroduceApellidos.setFont(new Font("Barlow", Font.BOLD, 20));
		txtIntroduceApellidos.setText("Introduce Apellidos");
		txtIntroduceApellidos.setBounds(201, 131, 264, 20);
		contentPanel.add(txtIntroduceApellidos);
		txtIntroduceApellidos.setColumns(10);
		
		txtIntroduceDni = new JTextField();
		txtIntroduceDni.setText("Introduce DNI");
		txtIntroduceDni.setFont(new Font("Barlow", Font.BOLD, 20));
		txtIntroduceDni.setBounds(201, 167, 264, 20);
		contentPanel.add(txtIntroduceDni);
		txtIntroduceDni.setColumns(10);
		
		txtIntroduceDireccion = new JTextField();
		txtIntroduceDireccion.setText("Introduce Direccion");
		txtIntroduceDireccion.setFont(new Font("Barlow", Font.BOLD, 20));
		txtIntroduceDireccion.setBounds(201, 204, 264, 20);
		contentPanel.add(txtIntroduceDireccion);
		txtIntroduceDireccion.setColumns(10);
		
		txtIntroduceTelefono = new JTextField();
		txtIntroduceTelefono.setText("Introduce Telefono");
		txtIntroduceTelefono.setFont(new Font("Barlow", Font.BOLD, 20));
		txtIntroduceTelefono.setBounds(201, 244, 264, 20);
		contentPanel.add(txtIntroduceTelefono);
		txtIntroduceTelefono.setColumns(10);
		
		txtIntroduceFecha = new JTextField();
		txtIntroduceFecha.setText("Introduce Fecha");
		txtIntroduceFecha.setFont(new Font("Barlow", Font.BOLD, 20));
		txtIntroduceFecha.setBounds(201, 287, 264, 20);
		contentPanel.add(txtIntroduceFecha);
		txtIntroduceFecha.setColumns(10);
		
		txtIntroducePagado = new JTextField();
		txtIntroducePagado.setText("Introduce Pagado");
		txtIntroducePagado.setFont(new Font("Barlow", Font.BOLD, 20));
		txtIntroducePagado.setBounds(201, 321, 264, 20);
		contentPanel.add(txtIntroducePagado);
		txtIntroducePagado.setColumns(10);
		
		txtIntroducePorPagar = new JTextField();
		txtIntroducePorPagar.setText("Introduce Por Pagar");
		txtIntroducePorPagar.setFont(new Font("Barlow", Font.BOLD, 20));
		txtIntroducePorPagar.setBounds(201, 361, 264, 20);
		contentPanel.add(txtIntroducePorPagar);
		txtIntroducePorPagar.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(255, 255, 255));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setFont(new Font("Barlow", Font.BOLD, 20));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setFont(new Font("Barlow", Font.BOLD, 20));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}

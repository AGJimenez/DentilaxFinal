package dialogos_consultas;
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
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class jd_historial_cita extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtIntroduceTexto;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			jd_historial_cita dialog = new jd_historial_cita();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public jd_historial_cita() {
		setTitle("Historial");
		setIconImage(Toolkit.getDefaultToolkit().getImage(jd_historial_cita.class.getResource("/iconos_menus/dentilaxIcono.png")));
		setResizable(false);
		setBounds(100, 100, 1198, 531);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 255, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(this);
		
		JLabel lblDni = new JLabel("PACIENTES");
		lblDni.setForeground(new Color(0, 128, 192));
		lblDni.setFont(new Font("Barlow", Font.BOLD, 20));
		lblDni.setBounds(569, 118, 103, 18);
		contentPanel.add(lblDni);
		
		JLabel lblApellidos = new JLabel("TIPO");
		lblApellidos.setForeground(new Color(0, 128, 192));
		lblApellidos.setFont(new Font("Barlow", Font.BOLD, 20));
		lblApellidos.setBounds(236, 115, 114, 24);
		contentPanel.add(lblApellidos);
		JLabel lblNombre = new JLabel("FECHA");
		lblNombre.setForeground(new Color(0, 128, 192));
		lblNombre.setFont(new Font("Barlow", Font.BOLD, 20));
		lblNombre.setBounds(25, 112, 114, 31);
		contentPanel.add(lblNombre);
		
		txtIntroduceTexto = new JTextField();
		txtIntroduceTexto.setEditable(false);
		txtIntroduceTexto.setBackground(new Color(191, 231, 249));
		txtIntroduceTexto.setFont(new Font("Arial", Font.PLAIN, 14));
		txtIntroduceTexto.setText(" ");
		txtIntroduceTexto.setBounds(12, 104, 1142, 40);
		contentPanel.add(txtIntroduceTexto);
		txtIntroduceTexto.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(191, 231, 249));
		panel.setForeground(new Color(191, 231, 249));
		panel.setBounds(0, 37, 652, 50);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblDentilax = new JLabel("HISTORIAL GLOBAL DE CITAS");
		lblDentilax.setBounds(37, 11, 308, 24);
		panel.add(lblDentilax);
		lblDentilax.setFont(new Font("Barlow", Font.BOLD, 20));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 147, 674, 265);
		contentPanel.add(scrollPane);
		
		table = new JTable();
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
				{null, null, null},
			},
			new String[] {
				"New column", "New column", "New column"
			}
		));
		scrollPane.setColumnHeaderView(table);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setPreferredSize(new Dimension(30, 80));
			buttonPane.setSize(new Dimension(20, 20));
			buttonPane.setBackground(new Color(255, 255, 255));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(null);
			{
				JButton btn_imprimir = new JButton("CONFIRMAR");
				btn_imprimir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				btn_imprimir.setForeground(Color.WHITE);
				btn_imprimir.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				btn_imprimir.setBorderPainted(false);
				btn_imprimir.setBorder(null);
				btn_imprimir.setBackground(new Color(32, 160, 216));
				btn_imprimir.setBounds(673, 11, 153, 43);
				btn_imprimir.setFont(new Font("Barlow", Font.BOLD, 20));
				btn_imprimir.setActionCommand("OK");
				buttonPane.add(btn_imprimir);
				getRootPane().setDefaultButton(btn_imprimir);
			}
			{
				JButton btn_salir = new JButton("CANCELAR");
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
				btn_salir.setBounds(990, 11, 153, 43);
				btn_salir.setFont(new Font("Barlow", Font.BOLD, 20));
				btn_salir.setActionCommand("Cancel");
				buttonPane.add(btn_salir);
			}
		}
	}
}

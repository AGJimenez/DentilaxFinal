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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Cursor;
import javax.swing.SwingConstants;

public class jd_cobrar_factura extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtIntroducePagado;
	private JLabel lbl_invisible = new JLabel("");
	private JLabel lbl_invisible_2 = new JLabel("");
	private JLabel lbl_invisible_3 = new JLabel("");
	private JLabel lbl_invisible_4 = new JLabel("");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			jd_cobrar_factura dialog = new jd_cobrar_factura();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public jd_cobrar_factura() {
		setTitle("Cobrar");
		setIconImage(Toolkit.getDefaultToolkit().getImage(jd_cobrar_factura.class.getResource("/iconos_menus/dentilaxIcono.png")));
		setResizable(false);
		setBounds(100, 100, 513, 312);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 255, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(this);
		
		JLabel lblPagar = new JLabel("PAGADO");
		lblPagar.setForeground(new Color(0, 128, 192));
		lblPagar.setFont(new Font("Barlow", Font.BOLD, 20));
		lblPagar.setBounds(66, 111, 114, 39);
		contentPanel.add(lblPagar);
		
		txtIntroducePagado = new JTextField();
		txtIntroducePagado.setHorizontalAlignment(SwingConstants.CENTER);
		txtIntroducePagado.setBackground(new Color(191, 231, 249));
		txtIntroducePagado.setText("");
		txtIntroducePagado.setFont(new Font("Arial", Font.PLAIN, 14));
		txtIntroducePagado.setBounds(190, 114, 264, 40);
		contentPanel.add(txtIntroducePagado);
		txtIntroducePagado.setColumns(10);
		txtIntroducePagado.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER) {
					 dentilax_bdd.ConectorDB_mysql consultasDB = new dentilax_bdd.ConectorDB_mysql();
					    String pagado = txtIntroducePagado.getText();
					    int cobro = Integer.valueOf(pagado);
					    int invisible_num = Integer.valueOf(lbl_invisible_2.getText().toString());
					    int invisible_pagado = Integer.valueOf(lbl_invisible_3.getText().toString());
					    try {
							consultasDB.consulta_cobrar_factura(lbl_invisible.getText().toString(),invisible_num, invisible_pagado, cobro, lbl_invisible_4.getText().toString());
							dispose();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
			});
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(191, 231, 249));
		panel.setForeground(new Color(191, 231, 249));
		panel.setBounds(0, 37, 397, 50);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lbl_cobrar_pago = new JLabel("COBRAR PAGO");
		lbl_cobrar_pago.setBounds(37, 11, 308, 24);
		panel.add(lbl_cobrar_pago);
		lbl_cobrar_pago.setFont(new Font("Barlow", Font.BOLD, 20));
		
		lbl_invisible.setBounds(408, 69, 0, 0);
		contentPanel.add(lbl_invisible);
		
		lbl_invisible_2.setBounds(434, 69, 0, 0);
		contentPanel.add(lbl_invisible_2);
		
		lbl_invisible_3.setBounds(463, 69, 0, 0);
		contentPanel.add(lbl_invisible_3);
		
		lbl_invisible_4.setBounds(67, 12, 0, 0);
		contentPanel.add(lbl_invisible_4);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setPreferredSize(new Dimension(30, 80));
			buttonPane.setSize(new Dimension(20, 20));
			buttonPane.setBackground(new Color(255, 255, 255));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(null);
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
				btn_salir.setBounds(327, 11, 153, 43);
				btn_salir.setFont(new Font("Barlow", Font.BOLD, 20));
				btn_salir.setActionCommand("Cancel");
				buttonPane.add(btn_salir);
			}
			
			JButton btn_confirmar = new JButton("CONFIRMAR");
			btn_confirmar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				    dentilax_bdd.ConectorDB_mysql consultasDB = new dentilax_bdd.ConectorDB_mysql();
				    String pagado = txtIntroducePagado.getText();
				    int cobro = Integer.valueOf(pagado);
				    int invisible_num = Integer.valueOf(lbl_invisible_2.getText().toString());
				    int invisible_pagado = Integer.valueOf(lbl_invisible_3.getText().toString());
				    try {
						consultasDB.consulta_cobrar_factura(lbl_invisible.getText().toString(),invisible_num, invisible_pagado, cobro, lbl_invisible_4.getText().toString());
						dispose();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			btn_confirmar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btn_confirmar.setForeground(Color.WHITE);
			btn_confirmar.setFont(new Font("Barlow", Font.BOLD, 20));
			btn_confirmar.setBorderPainted(false);
			btn_confirmar.setBorder(null);
			btn_confirmar.setBackground(new Color(32, 160, 216));
			btn_confirmar.setActionCommand("Cancel");
			btn_confirmar.setBounds(31, 11, 153, 43);
			buttonPane.add(btn_confirmar);
		}
	}
	public JLabel getLbl_invisible() {
		return lbl_invisible;
	}

	public void setLbl_invisible(String ID) {
		this.lbl_invisible.setText(ID);
	}

	public JLabel getLbl_invisible_2() {
		return lbl_invisible_2;
	}

	public void setLbl_invisible_2(String cobro) {
		this.lbl_invisible_2.setText(cobro);
	}

	public JLabel getLbl_invisible_3() {
		return lbl_invisible_3;
	}

	public void setLbl_invisible_3(String pagado) {
		this.lbl_invisible_3.setText(pagado);
	}

	public JLabel getLbl_invisible_4() {
		return lbl_invisible_4;
	}

	public void setLbl_invisible_4(String DNI_paciente) {
		this.lbl_invisible_4.setText(DNI_paciente);
	}
}

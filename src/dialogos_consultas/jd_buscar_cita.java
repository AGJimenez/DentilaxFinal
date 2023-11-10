package dialogos_consultas;



import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dentilax_bdd.ConectorDB_mysql;

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
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class jd_buscar_cita extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txt_IntroduceDni;
	private JTextField txtIntroduceFecha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			jd_buscar_cita dialog = new jd_buscar_cita();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public jd_buscar_cita() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(jd_buscar_cita.class.getResource("/iconos_menus/dentilaxIcono.png")));
		setTitle("Buscar cita");
		setPreferredSize(new Dimension(554, 343));
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 554, 343);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(contentPanel);
		{
			JLabel lbl_buscar_paciente = new JLabel("BUSCAR CITA");
			lbl_buscar_paciente.setFont(new Font("Barlow", Font.BOLD, 20));
			lbl_buscar_paciente.setBounds(26, 35, 176, 42);
			contentPanel.add(lbl_buscar_paciente);
		}
		{
			txt_IntroduceDni = new JTextField();
			txt_IntroduceDni.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent e) {
					if (txt_IntroduceDni.getText().equals("Introduce DNI")) {
						txt_IntroduceDni.setText("");
	                }
				}
				@Override
				public void focusLost(FocusEvent e) {
					if (txt_IntroduceDni.getText().isEmpty()) {
						txt_IntroduceDni.setText("Introduce DNI");
	                }
				}
			});
			txt_IntroduceDni.setOpaque(false);
			txt_IntroduceDni.setText("Introduce DNI");
			txt_IntroduceDni.setHorizontalAlignment(SwingConstants.LEFT);
			txt_IntroduceDni.setFont(new Font("Arial", Font.PLAIN, 17));
			txt_IntroduceDni.setColumns(10);
			txt_IntroduceDni.setBorder(null);
			txt_IntroduceDni.setBackground(new Color(0, 128, 192));
			txt_IntroduceDni.setBounds(100, 114, 382, 44);
			contentPanel.add(txt_IntroduceDni);
		}
		{
			JLabel lbl_dni = new JLabel("DNI");
			lbl_dni.setForeground(new Color(0, 128, 192));
			lbl_dni.setFont(new Font("Barlow", Font.BOLD, 22));
			lbl_dni.setBounds(36, 110, 38, 44);
			contentPanel.add(lbl_dni);
		}
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(191, 231, 249));
			panel.setBounds(0, 24, 217, 64);
			contentPanel.add(panel);
		}
		{
			JSeparator separator = new JSeparator();
			separator.setForeground(new Color(0, 128, 192));
			separator.setBackground(new Color(0, 128, 192));
			separator.setBounds(100, 153, 237, 8);
			contentPanel.add(separator);
		}
		
		JLabel lbl_dni = new JLabel("Fecha");
		lbl_dni.setForeground(new Color(0, 128, 192));
		lbl_dni.setFont(new Font("Barlow", Font.BOLD, 22));
		lbl_dni.setBounds(26, 172, 82, 44);
		contentPanel.add(lbl_dni);
		
		txtIntroduceFecha = new JTextField();
		txtIntroduceFecha.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtIntroduceFecha.getText().equals("Introduce Fecha")) {
					txtIntroduceFecha.setText("");
                }
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (txtIntroduceFecha.getText().isEmpty()) {
					txtIntroduceFecha.setText("Introduce Fecha");
                }
			}
		});
		txtIntroduceFecha.setText("Introduce Fecha");
		txtIntroduceFecha.setOpaque(false);
		txtIntroduceFecha.setHorizontalAlignment(SwingConstants.LEFT);
		txtIntroduceFecha.setFont(new Font("Arial", Font.PLAIN, 17));
		txtIntroduceFecha.setColumns(10);
		txtIntroduceFecha.setBorder(null);
		txtIntroduceFecha.setBackground(new Color(0, 128, 192));
		txtIntroduceFecha.setBounds(100, 176, 382, 44);
		contentPanel.add(txtIntroduceFecha);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 128, 192));
		separator.setBackground(new Color(0, 128, 192));
		separator.setBounds(100, 212, 237, 8);
		contentPanel.add(separator);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.WHITE);
			buttonPane.setPreferredSize(new Dimension(10, 60));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(null);
			{
				JButton btn_buscar = new JButton("BUSCAR");
				btn_buscar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dentilax_bdd.ConectorDB_mysql consulta= new dentilax_bdd.ConectorDB_mysql();
						dispose();
						try {
							consulta.consulta_buscar_cita(txt_IntroduceDni.getText().toString(), txtIntroduceFecha.getText().toString());
							
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						
						//si no if no encontrado
					}
				});
				btn_buscar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				btn_buscar.setBorderPainted(false);
				btn_buscar.setFont(new Font("Barlow", Font.BOLD, 20));
				btn_buscar.setForeground(new Color(255, 255, 255));
				btn_buscar.setBackground(new Color(32, 160, 216));
				btn_buscar.setBounds(56, 0, 153, 43);
				btn_buscar.setActionCommand("OK");
				buttonPane.add(btn_buscar);
				
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
				btn_cancelar.setBounds(333, 0, 153, 43);
				btn_cancelar.setActionCommand("Cancel");
				buttonPane.add(btn_cancelar);
			}
		}
	}

	public JTextField getTxt_IntroduceDni() {
		return txt_IntroduceDni;
	}

	public void setTxt_IntroduceDni(String txt_IntroduceDni) {
		this.txt_IntroduceDni.setText(txt_IntroduceDni);
	}

	public JTextField getTxtIntroduceFecha() {
		return txtIntroduceFecha;
	}

	public void setTxtIntroduceFecha(String txtIntroduceFecha) {
		this.txtIntroduceFecha.setText(txtIntroduceFecha);
	}
	
}

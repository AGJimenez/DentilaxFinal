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

public class jd_buscar_dr_encontrado extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtt;
	private JTextField txtAlejandro;
	private JTextField txtFernandezDeLa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			jd_buscar_dr_encontrado dialog = new jd_buscar_dr_encontrado();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public jd_buscar_dr_encontrado() {
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
			JLabel lblNewLabel = new JLabel("COINCIDENCIA:");
			lblNewLabel.setFont(new Font("Barlow", Font.BOLD, 20));
			lblNewLabel.setBounds(35, 35, 167, 42);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblDni = new JLabel("DNI");
			lblDni.setForeground(new Color(0, 128, 192));
			lblDni.setFont(new Font("Barlow", Font.BOLD, 22));
			lblDni.setBounds(21, 106, 38, 44);
			contentPanel.add(lblDni);
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
			separator.setBounds(21, 142, 495, 8);
			contentPanel.add(separator);
		}
		{
			JLabel lblNombre = new JLabel("Nombre");
			lblNombre.setForeground(new Color(0, 128, 192));
			lblNombre.setFont(new Font("Barlow", Font.BOLD, 22));
			lblNombre.setBounds(124, 106, 78, 44);
			contentPanel.add(lblNombre);
		}
		{
			JLabel lblApellidos = new JLabel("Apellidos");
			lblApellidos.setForeground(new Color(0, 128, 192));
			lblApellidos.setFont(new Font("Barlow", Font.BOLD, 22));
			lblApellidos.setBounds(290, 106, 100, 44);
			contentPanel.add(lblApellidos);
		}
		{
			txtt = new JTextField();
			txtt.setEditable(false);
			txtt.setBorder(null);
			txtt.setBackground(new Color(191, 231, 249));
			txtt.setFont(new Font("Arial", Font.PLAIN, 14));
			txtt.setHorizontalAlignment(SwingConstants.CENTER);
			txtt.setText("77981983t");
			txtt.setBounds(21, 177, 83, 34);
			contentPanel.add(txtt);
			txtt.setColumns(10);
		}
		{
			txtAlejandro = new JTextField();
			txtAlejandro.setEditable(false);
			txtAlejandro.setBorder(null);
			txtAlejandro.setBackground(new Color(191, 231, 249));
			txtAlejandro.setFont(new Font("Arial", Font.PLAIN, 14));
			txtAlejandro.setText("Alejandro Alfredo");
			txtAlejandro.setHorizontalAlignment(SwingConstants.CENTER);
			txtAlejandro.setBounds(124, 177, 146, 34);
			contentPanel.add(txtAlejandro);
			txtAlejandro.setColumns(10);
		}
		{
			txtFernandezDeLa = new JTextField();
			txtFernandezDeLa.setEditable(false);
			txtFernandezDeLa.setHorizontalAlignment(SwingConstants.CENTER);
			txtFernandezDeLa.setBorder(null);
			txtFernandezDeLa.setBackground(new Color(191, 231, 249));
			txtFernandezDeLa.setFont(new Font("Arial", Font.PLAIN, 14));
			txtFernandezDeLa.setText("Fernandez de la Rosa Ximenez");
			txtFernandezDeLa.setBounds(291, 177, 225, 34);
			contentPanel.add(txtFernandezDeLa);
			txtFernandezDeLa.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.WHITE);
			buttonPane.setPreferredSize(new Dimension(10, 60));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(null);
			{
				JButton btn_ficha = new JButton("FICHA");
				btn_ficha.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//SQL
					}
				});
				btn_ficha.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				btn_ficha.setBorderPainted(false);
				btn_ficha.setFont(new Font("Barlow", Font.BOLD, 20));
				btn_ficha.setForeground(new Color(255, 255, 255));
				btn_ficha.setBackground(new Color(32, 160, 216));
				btn_ficha.setBounds(20, 0, 153, 43);
				btn_ficha.setActionCommand("OK");
				buttonPane.add(btn_ficha);
				
			}
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
			
			JButton btn_historial = new JButton("HISTORIAL");
			btn_historial.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btn_historial.setForeground(Color.WHITE);
			btn_historial.setFont(new Font("Barlow", Font.BOLD, 20));
			btn_historial.setBorderPainted(false);
			btn_historial.setBackground(new Color(32, 160, 216));
			btn_historial.setActionCommand("OK");
			btn_historial.setBounds(194, 0, 153, 43);
			buttonPane.add(btn_historial);
		}
	}
}

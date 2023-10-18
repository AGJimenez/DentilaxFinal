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

public class jd_buscar_dr extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtIntroduceDni;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			jd_buscar_dr dialog = new jd_buscar_dr();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public jd_buscar_dr() {
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
			JLabel lblNewLabel = new JLabel("BUSCAR DOCTOR");
			lblNewLabel.setFont(new Font("Barlow", Font.BOLD, 20));
			lblNewLabel.setBounds(35, 35, 167, 42);
			contentPanel.add(lblNewLabel);
		}
		{
			txtIntroduceDni = new JTextField();
			txtIntroduceDni.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent e) {
					if (txtIntroduceDni.getText().equals("Introduce DNI")) {
						txtIntroduceDni.setText("");
						txtIntroduceDni.setForeground(Color.BLACK);
	                }
				}
				@Override
				public void focusLost(FocusEvent e) {
					if (txtIntroduceDni.getText().isEmpty()) {
						txtIntroduceDni.setForeground(new Color(0, 128, 192));
						txtIntroduceDni.setText("Introduce DNI");
	                }
				}
			});
			txtIntroduceDni.setOpaque(false);
			txtIntroduceDni.setText("Introduce DNI");
			txtIntroduceDni.setHorizontalAlignment(SwingConstants.LEFT);
			txtIntroduceDni.setFont(new Font("Arial", Font.PLAIN, 17));
			txtIntroduceDni.setColumns(10);
			txtIntroduceDni.setBorder(null);
			txtIntroduceDni.setBackground(new Color(0, 128, 192));
			txtIntroduceDni.setBounds(110, 140, 382, 44);
			contentPanel.add(txtIntroduceDni);
		}
		{
			JLabel lblDni = new JLabel("DNI");
			lblDni.setForeground(new Color(0, 128, 192));
			lblDni.setFont(new Font("Barlow", Font.BOLD, 22));
			lblDni.setBounds(59, 140, 38, 44);
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
			separator.setBounds(100, 175, 237, 8);
			contentPanel.add(separator);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.WHITE);
			buttonPane.setPreferredSize(new Dimension(10, 60));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(null);
			{
				JButton okButton = new JButton("BUSCAR");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//SQL
					}
				});
				okButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				okButton.setBorderPainted(false);
				okButton.setFont(new Font("Barlow", Font.BOLD, 20));
				okButton.setForeground(new Color(255, 255, 255));
				okButton.setBackground(new Color(32, 160, 216));
				okButton.setBounds(56, 0, 153, 43);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				
			}
			{
				JButton cancelButton = new JButton("CANCELAR");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				cancelButton.setBorderPainted(false);
				cancelButton.setFont(new Font("Barlow", Font.BOLD, 20));
				cancelButton.setForeground(new Color(255, 255, 255));
				cancelButton.setBackground(new Color(32, 160, 216));
				cancelButton.setBounds(333, 0, 153, 43);
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class jd_anadir_especialidad extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtIntroduceEspecialidad;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			jd_anadir_especialidad dialog = new jd_anadir_especialidad();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public jd_anadir_especialidad() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(contentPanel);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(0, 128, 192));
		separator.setForeground(new Color(0, 128, 192));
		separator.setBounds(96, 148, 237, 8);
		contentPanel.add(separator);
		
		
		txtIntroduceEspecialidad = new JTextField();
		txtIntroduceEspecialidad.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtIntroduceEspecialidad.getText().equals("Introduce especialidad")) {
					txtIntroduceEspecialidad.setText("");
					txtIntroduceEspecialidad.setForeground(Color.BLACK);
                }
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (txtIntroduceEspecialidad.getText().isEmpty()) {
					txtIntroduceEspecialidad.setForeground(new Color(0, 128, 192));
					txtIntroduceEspecialidad.setText("Introduce especialidad");
                }
			}
		});
		txtIntroduceEspecialidad.setOpaque(false);
		txtIntroduceEspecialidad.setHorizontalAlignment(SwingConstants.CENTER);
		txtIntroduceEspecialidad.setText("Introduce especialidad");
		txtIntroduceEspecialidad.setBorder(null);
		txtIntroduceEspecialidad.setFont(new Font("Arial", Font.PLAIN, 17));
		txtIntroduceEspecialidad.setBounds(18, 108, 407, 44);
		txtIntroduceEspecialidad.setBackground(null);
		contentPanel.add(txtIntroduceEspecialidad);
		txtIntroduceEspecialidad.setColumns(10);
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(191, 231, 249));
			panel.setBounds(0, 11, 242, 57);
			contentPanel.add(panel);
			panel.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("TÍTULO DE ESPECIALIDAD");
			lblNewLabel.setFont(new Font("Barlow", Font.BOLD, 19));
			lblNewLabel.setBounds(10, 11, 222, 35);
			panel.add(lblNewLabel);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setPreferredSize(new Dimension(10, 60));
			buttonPane.setBackground(Color.WHITE);
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(null);
			{
				JButton okButton = new JButton("OK");
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
				okButton.setBounds(10, 0, 153, 43);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				
			}
			{
				JButton cancelButton = new JButton("Cancel");
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
				cancelButton.setBounds(271, 0, 153, 43);
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}

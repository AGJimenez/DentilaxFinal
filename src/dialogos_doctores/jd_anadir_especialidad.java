package dialogos_doctores;



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
import java.awt.Toolkit;

public class jd_anadir_especialidad extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txt_especialidad;

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
		setTitle("Añadir especialidad");
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(jd_anadir_especialidad.class.getResource("/iconos_menus/dentilaxIcono.png")));
		setModal(true);
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
		
		
		txt_especialidad = new JTextField();
		txt_especialidad.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txt_especialidad.getText().equals("Introduce especialidad")) {
					txt_especialidad.setText("");
					txt_especialidad.setForeground(Color.BLACK);
                }
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (txt_especialidad.getText().isEmpty()) {
					txt_especialidad.setForeground(new Color(0, 128, 192));
					txt_especialidad.setText("Introduce especialidad");
                }
			}
		});
		txt_especialidad.setOpaque(false);
		txt_especialidad.setHorizontalAlignment(SwingConstants.CENTER);
		txt_especialidad.setText("Introduce especialidad");
		txt_especialidad.setBorder(null);
		txt_especialidad.setFont(new Font("Arial", Font.PLAIN, 17));
		txt_especialidad.setBounds(18, 108, 407, 44);
		txt_especialidad.setBackground(null);
		contentPanel.add(txt_especialidad);
		txt_especialidad.setColumns(10);
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(191, 231, 249));
			panel.setBounds(0, 11, 262, 57);
			contentPanel.add(panel);
			panel.setLayout(null);
			
			JLabel lbl_especialidad = new JLabel("TÍTULO DE ESPECIALIDAD");
			lbl_especialidad.setFont(new Font("Barlow", Font.BOLD, 19));
			lbl_especialidad.setBounds(30, 11, 222, 35);
			panel.add(lbl_especialidad);
		}
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
						
						
						//SQL 
						
					}
				});
				btn_anadir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				btn_anadir.setBorderPainted(false);
				btn_anadir.setFont(new Font("Barlow", Font.BOLD, 20));
				btn_anadir.setForeground(new Color(255, 255, 255));
				btn_anadir.setBackground(new Color(32, 160, 216));
				btn_anadir.setBounds(10, 0, 153, 43);
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
				btn_cancelar.setBounds(271, 0, 153, 43);
				btn_cancelar.setActionCommand("Cancel");
				buttonPane.add(btn_cancelar);
			}
		}
	}
}

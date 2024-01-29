package login;
import java.awt.EventQueue;

import javax.swing.JDialog;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class Ayuda_login extends JDialog {

	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ayuda_login dialog = new Ayuda_login();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public Ayuda_login() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Ayuda_login.class.getResource("/iconos_menus/dentalMascot (1).png")));
		setTitle("Ayuda en el login");
		getContentPane().setBackground(new Color(255, 255, 255));
		getContentPane().setLayout(null);
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(29, 23, 379, 154);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("¡Veo que tienes problemas de acceso!");
		lblNewLabel.setFont(new Font("Barlow", Font.PLAIN, 15));
		lblNewLabel.setBounds(74, 11, 261, 45);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Prueba a recuperar la contraseña, y si ya lo has hecho y");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(0, 80, 379, 25);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("aún así no consigues acceder, ponte en contacto con el ");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(0, 105, 379, 25);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("administrador.");
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(0, 129, 148, 25);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBounds(0, 6, 95, 62);
		panel.add(lblNewLabel_4);
		lblNewLabel_4.setIcon(new ImageIcon(Ayuda_login.class.getResource("/iconos_menus/dentalMascot (1).png")));
		
		JButton btn_salir = new JButton("SALIR");
		btn_salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btn_salir.setForeground(Color.WHITE);
		btn_salir.setFont(new Font("Barlow", Font.BOLD, 20));
		btn_salir.setBorderPainted(false);
		btn_salir.setBorder(null);
		btn_salir.setBackground(new Color(32, 160, 216));
		btn_salir.setActionCommand("Cancel");
		btn_salir.setBounds(255, 207, 153, 43);
		getContentPane().add(btn_salir);
		setBounds(100, 100, 450, 301);
		setLocationRelativeTo(panel);
	}
}


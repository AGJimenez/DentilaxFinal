package dialogos_materiales;



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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class jd_buscar_pedido extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txt_IntroduceId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			jd_buscar_pedido dialog = new jd_buscar_pedido();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public jd_buscar_pedido() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(jd_buscar_pedido.class.getResource("/iconos_menus/dentilaxIcono.png")));
		setTitle("Buscar pedido");
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
			JLabel lbl_buscar_pedido = new JLabel("BUSCAR PEDIDO");
			lbl_buscar_pedido.setFont(new Font("Barlow", Font.BOLD, 20));
			lbl_buscar_pedido.setBounds(26, 35, 176, 42);
			contentPanel.add(lbl_buscar_pedido);
		}
		{
			txt_IntroduceId = new JTextField();
			
			txt_IntroduceId.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent e) {
					if (txt_IntroduceId.getText().equals("Introduce ID del pedido")) {
						txt_IntroduceId.setText("");
						txt_IntroduceId.setForeground(Color.BLACK);
	                }
				}
				@Override
				public void focusLost(FocusEvent e) {
					if (txt_IntroduceId.getText().isEmpty()) {
						txt_IntroduceId.setForeground(new Color(0, 128, 192));
						txt_IntroduceId.setText("Introduce ID del pedido");
	                }
				}
			});
			txt_IntroduceId.setOpaque(false);
			txt_IntroduceId.setText("Introduce ID del pedido");
			txt_IntroduceId.setHorizontalAlignment(SwingConstants.LEFT);
			txt_IntroduceId.setFont(new Font("Arial", Font.PLAIN, 17));
			txt_IntroduceId.setColumns(10);
			txt_IntroduceId.setBorder(null);
			txt_IntroduceId.setBackground(new Color(0, 128, 192));
			txt_IntroduceId.setBounds(110, 140, 382, 44);
			txt_IntroduceId.setFocusable(true);
			contentPanel.add(txt_IntroduceId);
		}
		{
			JLabel lbl_id = new JLabel("ID");
			lbl_id.setForeground(new Color(0, 128, 192));
			lbl_id.setFont(new Font("Barlow", Font.BOLD, 22));
			lbl_id.setBounds(59, 140, 38, 44);
			contentPanel.add(lbl_id);
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
				JButton btn_buscar = new JButton("BUSCAR");
				btn_buscar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//SQL si lo encuentra, abre ventana:
						ConectorDB_mysql consulta= new ConectorDB_mysql();
						String dni = txt_IntroduceId.getText().toString();	
						dispose();
						try {
							consulta.consulta_paciente(dni);
							
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						//si no if no encontrado
					}
				});
				txt_IntroduceId.addKeyListener(new KeyAdapter() {
					@Override
					public void keyPressed(KeyEvent e) {
						if(e.getKeyCode()==KeyEvent.VK_ENTER) {
							ConectorDB_mysql consulta= new ConectorDB_mysql();
							String dni = txt_IntroduceId.getText().toString();	
							dispose();
							try {
								consulta.consulta_paciente(dni);
								
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
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

}

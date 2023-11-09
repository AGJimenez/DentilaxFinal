package dialogos_consultas;



import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dialogos_pacientes.jd_buscar_paciente_baja_encontrado;

import java.awt.Dimension;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

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

public class jd_buscar_consulta_eliminar extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txt_IntroduceID;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			jd_buscar_consulta_eliminar dialog = new jd_buscar_consulta_eliminar();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public jd_buscar_consulta_eliminar() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(jd_buscar_consulta_eliminar.class.getResource("/iconos_menus/dentilaxIcono.png")));
		setTitle("Eliminar cita");
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
			JLabel lbl_buscar_consulta_eliminar = new JLabel("INTRODUCE UN ID PARA ELIMINAR CITA");
			lbl_buscar_consulta_eliminar.setFont(new Font("Barlow", Font.BOLD, 20));
			lbl_buscar_consulta_eliminar.setBounds(35, 35, 349, 42);
			contentPanel.add(lbl_buscar_consulta_eliminar);
		}
		{
			txt_IntroduceID = new JTextField();
			txt_IntroduceID.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent e) {
					if (txt_IntroduceID.getText().equals("Introduce ID cita")) {
						txt_IntroduceID.setText("");
	                }
				}
				@Override
				public void focusLost(FocusEvent e) {
					if (txt_IntroduceID.getText().isEmpty()) {
						txt_IntroduceID.setText("Introduce ID cita");
	                }
				}
			});
			txt_IntroduceID.setOpaque(false);
			txt_IntroduceID.setText("Introduce ID cita");
			txt_IntroduceID.setHorizontalAlignment(SwingConstants.LEFT);
			txt_IntroduceID.setFont(new Font("Arial", Font.PLAIN, 17));
			txt_IntroduceID.setColumns(10);
			txt_IntroduceID.setBorder(null);
			txt_IntroduceID.setBackground(new Color(0, 128, 192));
			txt_IntroduceID.setBounds(110, 140, 382, 44);
			contentPanel.add(txt_IntroduceID);
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
			panel.setBounds(0, 24, 426, 64);
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
						dentilax_bdd.ConectorDB_mysql consulta = new dentilax_bdd.ConectorDB_mysql();
						dispose();
						try {
							consulta.consulta_cita_eliminar(txt_IntroduceID.getText().toString());
							dialogos_consultas.jd_buscar_consulta_eliminar_encontrada ventana = new dialogos_consultas.jd_buscar_consulta_eliminar_encontrada();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
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

	public JTextField getTxt_IntroduceID() {
		return txt_IntroduceID;
	}

}

package dialogos_materiales;



import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Modelo.Pedido;
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
import java.time.LocalDate;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class jd_buscar_pedido extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txt_IntroduceFecha;

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
			txt_IntroduceFecha = new JTextField();
			
			txt_IntroduceFecha.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent e) {
					if (txt_IntroduceFecha.getText().equals("Introduce fecha del pedido")) {
						txt_IntroduceFecha.setText("");
						txt_IntroduceFecha.setForeground(Color.BLACK);
	                }
				}
				@Override
				public void focusLost(FocusEvent e) {
					if (txt_IntroduceFecha.getText().isEmpty()) {
						txt_IntroduceFecha.setForeground(new Color(0, 128, 192));
						txt_IntroduceFecha.setText("Introduce fecha del pedido");
	                }
				}
			});
			txt_IntroduceFecha.setOpaque(false);
			txt_IntroduceFecha.setText("Introduce fecha del pedido");
			txt_IntroduceFecha.setHorizontalAlignment(SwingConstants.LEFT);
			txt_IntroduceFecha.setFont(new Font("Arial", Font.PLAIN, 17));
			txt_IntroduceFecha.setColumns(10);
			txt_IntroduceFecha.setBorder(null);
			txt_IntroduceFecha.setBackground(new Color(0, 128, 192));
			txt_IntroduceFecha.setBounds(110, 140, 382, 44);
			txt_IntroduceFecha.setFocusable(true);
			contentPanel.add(txt_IntroduceFecha);
		}
		{
			JLabel lbl_fecha = new JLabel("Fecha");
			lbl_fecha.setForeground(new Color(0, 128, 192));
			lbl_fecha.setFont(new Font("Barlow", Font.BOLD, 22));
			lbl_fecha.setBounds(26, 140, 71, 44);
			contentPanel.add(lbl_fecha);
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
						String fecha = txt_IntroduceFecha.getText().toString();
						LocalDate date = LocalDate.parse(fecha);
						consulta.conectar();
						dispose();
						jd_buscar_pedidos_encontrados ventana = new jd_buscar_pedidos_encontrados();
						ventana.llenarTabla(consulta.obtener_pedidos(date));
						ventana.setVisible(true);
						
						//si no if no encontrado
					}
				});
				txt_IntroduceFecha.addKeyListener(new KeyAdapter() {
					@Override
					public void keyPressed(KeyEvent e) {
						if(e.getKeyCode()==KeyEvent.VK_ENTER) {
							ConectorDB_mysql consulta= new ConectorDB_mysql();
							String fecha = txt_IntroduceFecha.getText().toString();
							LocalDate date = LocalDate.parse(fecha);
							consulta.conectar();
							jd_buscar_pedidos_encontrados ventana = new jd_buscar_pedidos_encontrados();
							ventana.llenarTabla(consulta.obtener_pedidos(date));
							ventana.setVisible(true);
							dispose();
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

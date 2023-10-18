import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import javax.swing.ListSelectionModel;

public class jf_buscar_dr_historial extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txt_nombre_dr;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			jf_buscar_dr_historial dialog = new jf_buscar_dr_historial();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public jf_buscar_dr_historial() {
		setModal(true);
		setPreferredSize(new Dimension(1198, 531));
		setResizable(false);
		setBounds(100, 100, 848, 531);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setPreferredSize(new Dimension(1198, 531));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(contentPanel);
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(191, 231, 249));
			panel.setBounds(0, 32, 473, 54);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JLabel lbl_dr = new JLabel("DOCTOR: ");
				lbl_dr.setFont(new Font("Barlow", Font.BOLD, 20));
				lbl_dr.setBounds(10, 0, 88, 54);
				panel.add(lbl_dr);
			}
			{
				txt_nombre_dr = new JTextField();
				txt_nombre_dr.setEditable(false);
				txt_nombre_dr.setFont(new Font("Barlow", Font.PLAIN, 20));
				txt_nombre_dr.setText("FELIPE DEL CERRO HERNANDEZ GOMEZ");
				txt_nombre_dr.setBorder(null);
				txt_nombre_dr.setOpaque(false);
				txt_nombre_dr.setBounds(108, 0, 355, 54);
				panel.add(txt_nombre_dr);
				txt_nombre_dr.setColumns(10);
			}
		}
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(51, 150, 733, 251);
		contentPanel.add(scrollPane);
		
		JList jl_historial_dr = new JList();
		jl_historial_dr.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jl_historial_dr.setSelectionBackground(new Color(191, 231, 249));
		jl_historial_dr.setFont(new Font("Arial", Font.BOLD, 16));
		jl_historial_dr.setBackground(new Color(255, 255, 255));
		jl_historial_dr.setModel(new AbstractListModel() {
			String[] values = new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		scrollPane.setViewportView(jl_historial_dr);
		{
			JPanel panel_contened = new JPanel();
			panel_contened.setBackground(new Color(32, 160, 216));
			panel_contened.setBounds(51, 97, 733, 43);
			contentPanel.add(panel_contened);
			panel_contened.setLayout(null);
			{
				JLabel lbl_fecha = new JLabel("FECHA");
				lbl_fecha.setForeground(Color.WHITE);
				lbl_fecha.setFont(new Font("Barlow", Font.BOLD, 17));
				lbl_fecha.setBounds(10, 11, 96, 21);
				panel_contened.add(lbl_fecha);
			}
			{
				JLabel lbl_tipo = new JLabel("TIPO");
				lbl_tipo.setForeground(Color.WHITE);
				lbl_tipo.setFont(new Font("Barlow", Font.BOLD, 17));
				lbl_tipo.setBounds(203, 11, 96, 21);
				panel_contened.add(lbl_tipo);
			}
			{
				JLabel lbl_paciente = new JLabel("PACIENTE");
				lbl_paciente.setForeground(Color.WHITE);
				lbl_paciente.setFont(new Font("Barlow", Font.BOLD, 17));
				lbl_paciente.setBounds(462, 11, 96, 21);
				panel_contened.add(lbl_paciente);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.WHITE);
			buttonPane.setPreferredSize(new Dimension(10, 60));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(null);
			{
				JButton btn_salir = new JButton("SALIR");
				btn_salir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				btn_salir.setBorder(null);
				btn_salir.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btn_salir.setBorderPainted(false);
				btn_salir.setFont(new Font("Barlow", Font.BOLD, 20));
				btn_salir.setForeground(new Color(255, 255, 255));
				btn_salir.setBackground(new Color(32, 160, 216));
				btn_salir.setBounds(633, 0, 153, 43);
				btn_salir.setActionCommand("Cancel");
				buttonPane.add(btn_salir);
			}
		}
	}
}

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;

public class jd_especialidades extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			jd_especialidades dialog = new jd_especialidades();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public jd_especialidades() {
		this.getRootPane().setDefaultButton(null);
		setModal(true);
		setPreferredSize(new Dimension(439, 490));
		setBounds(100, 100, 539, 590);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setPreferredSize(new Dimension(439, 490));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(contentPanel);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(191, 231, 249));
		panel.setBounds(0, 11, 366, 57);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lbl_especialidades = new JLabel("ESPECIALIDADES ENCONTRADAS");
		lbl_especialidades.setFont(new Font("Barlow", Font.BOLD, 20));
		lbl_especialidades.setBounds(10, 11, 334, 35);
		panel.add(lbl_especialidades);
		
		JScrollPane sp_panelScroll = new JScrollPane();
		sp_panelScroll.setBorder(null);
		sp_panelScroll.setBackground(Color.WHITE);
		sp_panelScroll.setBounds(10, 79, 503, 411);
		contentPanel.add(sp_panelScroll);
		
		JList jl_listaEspecialidades = new JList();
		jl_listaEspecialidades.setFont(new Font("Arial", Font.BOLD, 16));
		jl_listaEspecialidades.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jl_listaEspecialidades.setSelectionForeground(Color.BLACK);
		jl_listaEspecialidades.setSelectionBackground(new Color(191, 231, 249));
		sp_panelScroll.setViewportView(jl_listaEspecialidades);
		
		DefaultListModel dml = new DefaultListModel();
		dml.addElement("Hola");
		dml.addElement("Hola");
		dml.addElement("Hola");
		dml.addElement("Hola");
		dml.addElement("Hola");
		dml.addElement("Hola");
		dml.addElement("Hola");
		jl_listaEspecialidades.setModel(new AbstractListModel() {
			String[] values = new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.WHITE);
			buttonPane.setPreferredSize(new Dimension(439, 70));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(null);
			{
				JButton btn_anadir = new JButton("AÑADIR");
				btn_anadir.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						jd_anadir_especialidad ventana = new jd_anadir_especialidad();
						ventana.setVisible(true);
						
					}
				});
				btn_anadir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				btn_anadir.setBorderPainted(false);
				btn_anadir.setFont(new Font("Barlow", Font.BOLD, 20));
				btn_anadir.setForeground(new Color(255, 255, 255));
				btn_anadir.setBackground(new Color(32, 160, 216));
				btn_anadir.setBounds(38, 11, 153, 43);
				btn_anadir.setActionCommand("OK");
				buttonPane.add(btn_anadir);
				
			}
			{
				JButton btn_salir = new JButton("SALIR");
				btn_salir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				btn_salir.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btn_salir.setBorderPainted(false);
				btn_salir.setFont(new Font("Barlow", Font.BOLD, 20));
				btn_salir.setForeground(new Color(255, 255, 255));
				btn_salir.setBackground(new Color(32, 160, 216));
				btn_salir.setBounds(339, 11, 153, 43);
				btn_salir.setActionCommand("Cancel");
				buttonPane.add(btn_salir);
			}
		}
	}
}

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
		
		JLabel lblNewLabel = new JLabel("ESPECIALIDADES ENCONTRADAS");
		lblNewLabel.setFont(new Font("Barlow", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 11, 334, 35);
		panel.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(null);
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBounds(10, 79, 503, 411);
		contentPanel.add(scrollPane);
		
		JList list = new JList();
		list.setFont(new Font("Arial", Font.BOLD, 16));
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setSelectionForeground(Color.BLACK);
		list.setSelectionBackground(new Color(191, 231, 249));
		scrollPane.setViewportView(list);
		
		DefaultListModel dml = new DefaultListModel();
		dml.addElement("Hola");
		dml.addElement("Hola");
		dml.addElement("Hola");
		dml.addElement("Hola");
		dml.addElement("Hola");
		dml.addElement("Hola");
		dml.addElement("Hola");
		list.setModel(new AbstractListModel() {
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
				JButton okButton = new JButton("AÑADIR");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						jd_anadir_especialidad ventana = new jd_anadir_especialidad();
						ventana.setVisible(true);
						
					}
				});
				okButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				okButton.setBorderPainted(false);
				okButton.setFont(new Font("Barlow", Font.BOLD, 20));
				okButton.setForeground(new Color(255, 255, 255));
				okButton.setBackground(new Color(32, 160, 216));
				okButton.setBounds(38, 11, 153, 43);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				
			}
			{
				JButton cancelButton = new JButton("SALIR");
				cancelButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setBorderPainted(false);
				cancelButton.setFont(new Font("Barlow", Font.BOLD, 20));
				cancelButton.setForeground(new Color(255, 255, 255));
				cancelButton.setBackground(new Color(32, 160, 216));
				cancelButton.setBounds(339, 11, 153, 43);
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}

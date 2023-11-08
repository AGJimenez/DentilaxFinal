package dialogos_consultas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.Cursor;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JCalendar;
import javax.swing.border.BevelBorder;
import javax.swing.JTextField;

public class jd_nueva_consulta extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txt_fecha;
	private JTextField txt_hora;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			jd_nueva_consulta dialog = new jd_nueva_consulta();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public jd_nueva_consulta() {
		setUndecorated(true);
		setBounds(100, 100, 1100, 600);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(this);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.WHITE);
			buttonPane.setBounds(0, 519, 1100, 57);
			contentPanel.add(buttonPane);
			buttonPane.setLayout(null);
			{
				JButton okButton = new JButton("CONFIRMAR");
				okButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				okButton.setForeground(Color.WHITE);
				okButton.setFont(new Font("Barlow", Font.BOLD, 20));
				okButton.setBorder(null);
				okButton.setBorderPainted(false);
				okButton.setBackground(new Color(32, 160, 216));
				okButton.setBounds(712, 0, 153, 43);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("CANCELAR");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setFont(new Font("Barlow", Font.BOLD, 20));
				cancelButton.setForeground(Color.WHITE);
				cancelButton.setBorder(null);
				cancelButton.setBorderPainted(false);
				cancelButton.setBackground(new Color(32, 160, 216));
				cancelButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				cancelButton.setBounds(893, 0, 153, 43);
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		JComboBox cb_paciente = new JComboBox();
		cb_paciente.setFont(new Font("Arial", Font.PLAIN, 14));
		cb_paciente.setBackground(new Color(191, 231, 249));
		cb_paciente.setBounds(247, 63, 248, 37);
		contentPanel.add(cb_paciente);
		
		JComboBox cb_doctor = new JComboBox();
		cb_doctor.setFont(new Font("Arial", Font.PLAIN, 14));
		cb_doctor.setBackground(new Color(191, 231, 249));
		cb_doctor.setBounds(247, 125, 248, 37);
		contentPanel.add(cb_doctor);
		
		JComboBox cb_especialidad = new JComboBox();
		cb_especialidad.setFont(new Font("Arial", Font.PLAIN, 14));
		cb_especialidad.setBackground(new Color(191, 231, 249));
		cb_especialidad.setBounds(247, 186, 248, 37);
		contentPanel.add(cb_especialidad);
		
		JLabel lbl_paciente = new JLabel("PACIENTE");
		lbl_paciente.setFont(new Font("Barlow", Font.BOLD, 20));
		lbl_paciente.setBounds(60, 60, 142, 40);
		contentPanel.add(lbl_paciente);
		
		JLabel lbl_doctor = new JLabel("DOCTOR");
		lbl_doctor.setFont(new Font("Barlow", Font.BOLD, 20));
		lbl_doctor.setBounds(60, 122, 79, 40);
		contentPanel.add(lbl_doctor);
		
		JLabel lbl_especialidad = new JLabel("ESPECIALIDAD");
		lbl_especialidad.setFont(new Font("Barlow", Font.BOLD, 20));
		lbl_especialidad.setBounds(60, 183, 142, 40);
		contentPanel.add(lbl_especialidad);
		
		JButton btn_hora9 = new JButton("10:00");
		btn_hora9.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_hora9.setBorderPainted(false);
		btn_hora9.setBorder(null);
		btn_hora9.setFont(new Font("Barlow", Font.BOLD, 20));
		btn_hora9.setForeground(Color.WHITE);
		btn_hora9.setBackground(new Color(32, 160, 216));
		btn_hora9.setBounds(559, 136, 120, 37);
		contentPanel.add(btn_hora9);
		
		JCalendar calendar = new JCalendar();
		calendar.getYearChooser().setBackground(new Color(32, 160, 216));
		calendar.getYearChooser().setFont(new Font("Arial", Font.PLAIN, 14));
		calendar.getYearChooser().getSpinner().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		calendar.getMonthChooser().getComboBox().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		calendar.getMonthChooser().getComboBox().setBackground(Color.WHITE);
		calendar.getMonthChooser().getSpinner().setFont(new Font("Arial", Font.PLAIN, 14));
		calendar.getDayChooser().setBorder(null);
		calendar.getDayChooser().setWeekdayForeground(Color.WHITE);
		calendar.getDayChooser().setDecorationBackgroundColor(new Color(32, 160, 216));
		calendar.getDayChooser().setForeground(Color.BLACK);
		calendar.getDayChooser().setFont(new Font("Arial", Font.BOLD, 14));
		calendar.getDayChooser().getDayPanel().setFont(new Font("Arial", Font.PLAIN, 14));
		calendar.getMonthChooser().getComboBox().setFont(new Font("Arial", Font.PLAIN, 14));
		calendar.getYearChooser().getSpinner().setFont(new Font("Arial", Font.PLAIN, 14));
		calendar.getYearChooser().getSpinner().setBackground(Color.WHITE);
		calendar.getDayChooser().getDayPanel().setBackground(new Color(255, 255, 255));
		calendar.setBounds(60, 269, 438, 211);
		contentPanel.add(calendar);
		
		JButton btn_hora10 = new JButton("11:00");
		btn_hora10.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_hora10.setBorderPainted(false);
		btn_hora10.setBorder(null);
		btn_hora10.setFont(new Font("Barlow", Font.BOLD, 20));
		btn_hora10.setForeground(Color.WHITE);
		btn_hora10.setBackground(new Color(32, 160, 216));
		btn_hora10.setBounds(742, 137, 120, 37);
		contentPanel.add(btn_hora10);
		
		JButton btn_hora11 = new JButton("12:00");
		btn_hora11.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_hora11.setBorderPainted(false);
		btn_hora11.setBorder(null);
		btn_hora11.setFont(new Font("Barlow", Font.BOLD, 20));
		btn_hora11.setForeground(Color.WHITE);
		btn_hora11.setBackground(new Color(32, 160, 216));
		btn_hora11.setBounds(925, 137, 120, 37);
		contentPanel.add(btn_hora11);
		
		JButton btn_hora12 = new JButton("13:00");
		btn_hora12.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_hora12.setBorderPainted(false);
		btn_hora12.setBorder(null);
		btn_hora12.setFont(new Font("Barlow", Font.BOLD, 20));
		btn_hora12.setForeground(Color.WHITE);
		btn_hora12.setBackground(new Color(32, 160, 216));
		btn_hora12.setBounds(559, 219, 120, 37);
		contentPanel.add(btn_hora12);
		
		JButton btn_hora13 = new JButton("14:00");
		btn_hora13.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_hora13.setBorderPainted(false);
		btn_hora13.setBorder(null);
		btn_hora13.setFont(new Font("Barlow", Font.BOLD, 20));
		btn_hora13.setForeground(Color.WHITE);
		btn_hora13.setBackground(new Color(32, 160, 216));
		btn_hora13.setBounds(742, 220, 120, 37);
		contentPanel.add(btn_hora13);
		
		JButton btn_hora14 = new JButton("15:00");
		btn_hora14.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_hora14.setBorderPainted(false);
		btn_hora14.setBorder(null);
		btn_hora14.setFont(new Font("Barlow", Font.BOLD, 20));
		btn_hora14.setForeground(Color.WHITE);
		btn_hora14.setBackground(new Color(32, 160, 216));
		btn_hora14.setBounds(925, 220, 120, 37);
		contentPanel.add(btn_hora14);
		
		JButton btn_hora15 = new JButton("16:00");
		btn_hora15.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_hora15.setBorderPainted(false);
		btn_hora15.setBorder(null);
		btn_hora15.setFont(new Font("Barlow", Font.BOLD, 20));
		btn_hora15.setForeground(Color.WHITE);
		btn_hora15.setBackground(new Color(32, 160, 216));
		btn_hora15.setBounds(559, 301, 120, 37);
		contentPanel.add(btn_hora15);
		
		JButton btn_hora16 = new JButton("17:00");
		btn_hora16.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_hora16.setBorderPainted(false);
		btn_hora16.setBorder(null);
		btn_hora16.setFont(new Font("Barlow", Font.BOLD, 20));
		btn_hora16.setForeground(Color.WHITE);
		btn_hora16.setBackground(new Color(32, 160, 216));
		btn_hora16.setBounds(742, 302, 120, 37);
		contentPanel.add(btn_hora16);
		
		JButton btn_hora17 = new JButton("18:00");
		btn_hora17.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_hora17.setBorderPainted(false);
		btn_hora17.setBorder(null);
		btn_hora17.setFont(new Font("Barlow", Font.BOLD, 20));
		btn_hora17.setForeground(Color.WHITE);
		btn_hora17.setBackground(new Color(32, 160, 216));
		btn_hora17.setBounds(925, 302, 120, 37);
		contentPanel.add(btn_hora17);
		
		JButton btn_hora18 = new JButton("19:00");
		btn_hora18.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_hora18.setBorderPainted(false);
		btn_hora18.setBorder(null);
		btn_hora18.setFont(new Font("Barlow", Font.BOLD, 20));
		btn_hora18.setForeground(Color.WHITE);
		btn_hora18.setBackground(new Color(32, 160, 216));
		btn_hora18.setBounds(559, 385, 120, 37);
		contentPanel.add(btn_hora18);
		
		JButton btn_hora19 = new JButton("20:00");
		btn_hora19.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_hora19.setBorderPainted(false);
		btn_hora19.setBorder(null);
		btn_hora19.setFont(new Font("Barlow", Font.BOLD, 20));
		btn_hora19.setForeground(Color.WHITE);
		btn_hora19.setBackground(new Color(32, 160, 216));
		btn_hora19.setBounds(742, 386, 120, 37);
		contentPanel.add(btn_hora19);
		
		JButton btn_hora20 = new JButton("HORA");
		btn_hora20.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_hora20.setBorderPainted(false);
		btn_hora20.setBorder(null);
		btn_hora20.setFont(new Font("Barlow", Font.BOLD, 20));
		btn_hora20.setForeground(Color.WHITE);
		btn_hora20.setBackground(new Color(32, 160, 216));
		btn_hora20.setBounds(925, 386, 120, 37);
		contentPanel.add(btn_hora20);
		
		JLabel lbl_hora = new JLabel("HORA");
		lbl_hora.setFont(new Font("Barlow", Font.BOLD, 20));
		lbl_hora.setBounds(773, 63, 142, 40);
		contentPanel.add(lbl_hora);
		
		JLabel lbl_seleccion = new JLabel("FECHA Y HORA:");
		lbl_seleccion.setFont(new Font("Barlow", Font.BOLD, 20));
		lbl_seleccion.setBounds(559, 440, 142, 40);
		contentPanel.add(lbl_seleccion);
		
		txt_fecha = new JTextField();
		txt_fecha.setFont(new Font("Arial", Font.BOLD, 14));
		txt_fecha.setEditable(false);
		txt_fecha.setBorder(null);
		txt_fecha.setBackground(new Color(191, 231, 249));
		txt_fecha.setBounds(742, 443, 120, 37);
		contentPanel.add(txt_fecha);
		txt_fecha.setColumns(10);
		
		txt_hora = new JTextField();
		txt_hora.setFont(new Font("Arial", Font.BOLD, 14));
		txt_hora.setEditable(false);
		txt_hora.setBorder(null);
		txt_hora.setBackground(new Color(191, 231, 249));
		txt_hora.setColumns(10);
		txt_hora.setBounds(925, 443, 120, 37);
		contentPanel.add(txt_hora);
	}
}

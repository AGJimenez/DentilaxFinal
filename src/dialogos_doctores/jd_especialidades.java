package dialogos_doctores;



import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dialogos_consultas.jd_buscar_consulta_eliminar;

import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import java.awt.Toolkit;

public class jd_especialidades extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JList<String> jl_listaEspecialidades;
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
		setTitle("Especialidades");
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(jd_especialidades.class.getResource("/iconos_menus/dentilaxIcono.png")));
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
		
		jl_listaEspecialidades = new JList<String>();
		cargarDatosEspecialidades();
		
		jl_listaEspecialidades.setFont(new Font("Arial", Font.BOLD, 16));
		jl_listaEspecialidades.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jl_listaEspecialidades.setSelectionForeground(Color.BLACK);
		jl_listaEspecialidades.setSelectionBackground(new Color(191, 231, 249));
		sp_panelScroll.setViewportView(jl_listaEspecialidades);
		
		
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
				btn_anadir.setBounds(10, 11, 153, 43);
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
				btn_salir.setBounds(360, 11, 153, 43);
				btn_salir.setActionCommand("Cancel");
				buttonPane.add(btn_salir);
			}
			
			JButton btn_eliminar = new JButton("ELIMINAR");
			btn_eliminar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dentilax_bdd.ConectorDB_mysql consulta_baja = new dentilax_bdd.ConectorDB_mysql();
					try {
						int eliminar = JOptionPane.showOptionDialog(
								   getContentPane(),
								   "¿Desea eliminar la especialidad?", 
								   "Eliminar especialidad",
								   JOptionPane.YES_NO_OPTION,
								   JOptionPane.QUESTION_MESSAGE,
								   null,
								   new Object[] { "Eliminar", "Cancelar"},
								   "opcion 1"); 	
						if(eliminar==0) {
							consulta_baja.eliminar_especialidad(jl_listaEspecialidades.getSelectedValue());
							JOptionPane.showMessageDialog(null, "Especialidad eliminada");
						}else {
							System.out.println("Especialidad no eliminada");
						}
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
										
					dispose();
				
				}
			});
			btn_eliminar.setForeground(Color.WHITE);
			btn_eliminar.setFont(new Font("Barlow", Font.BOLD, 20));
			btn_eliminar.setBorderPainted(false);
			btn_eliminar.setBackground(new Color(32, 160, 216));
			btn_eliminar.setActionCommand("OK");
			btn_eliminar.setBounds(185, 11, 153, 43);
			buttonPane.add(btn_eliminar);
		}
		
	}
	
	private void cargarDatosEspecialidades() {
        dentilax_bdd.ConectorDB_mysql conectorDB = new dentilax_bdd.ConectorDB_mysql();
        List<String> especialidades = conectorDB.cargarEspecialidades();

        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (String especialidad : especialidades) {
            listModel.addElement(especialidad);
        }

        jl_listaEspecialidades.setModel(listModel);
    }
	
	public JList<String> getJlist() {
		return jl_listaEspecialidades;
		
	}
}

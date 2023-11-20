package dialogos_pacientes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Modelo.Paciente;
import dentilax_bdd.ConectorDB_mysql;

public class jd_buscar_paciente_historial extends JDialog {

    private static final long serialVersionUID = 1L;
    private final JPanel contentPanel = new JPanel();
    private JTextField txt_nombre_dr;
    private static JTable table;
    private static DefaultTableModel model;

    public jd_buscar_paciente_historial(String DNI_paciente) {
        setTitle("Historial de paciente");
        setIconImage(Toolkit.getDefaultToolkit().getImage(jd_buscar_paciente_historial.class.getResource("/iconos_menus/dentilaxIcono.png")));
        setModal(true);
        setPreferredSize(new Dimension(1198, 531));
        setResizable(false);
        setBounds(100, 100, 848, 531);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBackground(Color.WHITE);
        contentPanel.setPreferredSize(new Dimension(1198, 531));
        contentPanel.setBorder(null);
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        setLocationRelativeTo(contentPanel);
        contentPanel.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(0, 32, 497, 54);
        panel.setBackground(new Color(191, 231, 249));
        contentPanel.add(panel);
        panel.setLayout(null);

        JLabel lbl_paciente = new JLabel("PACIENTE:");
        lbl_paciente.setFont(new Font("Barlow", Font.BOLD, 20));
        lbl_paciente.setBounds(10, 0, 105, 54);
        panel.add(lbl_paciente);

        txt_nombre_dr = new JTextField();
        txt_nombre_dr.setEditable(false);
        txt_nombre_dr.setFont(new Font("Barlow", Font.PLAIN, 20));
        txt_nombre_dr.setText("FELIPE DEL CERRO HERNANDEZ GOMEZ");
        txt_nombre_dr.setBorder(null);
        txt_nombre_dr.setOpaque(false);
        txt_nombre_dr.setBounds(125, 0, 355, 54);
        panel.add(txt_nombre_dr);
        txt_nombre_dr.setColumns(10);

        JPanel panel_contened = new JPanel();
        panel_contened.setBounds(51, 97, 733, 43);
        panel_contened.setBackground(new Color(32, 160, 216));
        contentPanel.add(panel_contened);
        panel_contened.setLayout(null);

        JLabel lbl_fecha = new JLabel("FECHA");
        lbl_fecha.setForeground(Color.WHITE);
        lbl_fecha.setFont(new Font("Barlow", Font.BOLD, 17));
        lbl_fecha.setBounds(10, 11, 96, 21);
        panel_contened.add(lbl_fecha);

        JLabel lbl_tipo = new JLabel("TIPO");
        lbl_tipo.setForeground(Color.WHITE);
        lbl_tipo.setFont(new Font("Barlow", Font.BOLD, 17));
        lbl_tipo.setBounds(203, 11, 96, 21);
        panel_contened.add(lbl_tipo);

        JLabel lbl_tratamiento = new JLabel("TRATAMIENTO");
        lbl_tratamiento.setForeground(Color.WHITE);
        lbl_tratamiento.setFont(new Font("Barlow", Font.BOLD, 17));
        lbl_tratamiento.setBounds(462, 11, 110, 21);
        panel_contened.add(lbl_tratamiento);

        JPanel buttonPane = new JPanel();
        buttonPane.setBackground(Color.WHITE);
        buttonPane.setPreferredSize(new Dimension(10, 60));
        getContentPane().add(buttonPane, BorderLayout.SOUTH);
        buttonPane.setLayout(null);

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

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(12, 147, 674, 265);
        contentPanel.add(scrollPane);

        table = new JTable();
        model = new DefaultTableModel();
        model.addColumn("Fecha");
        model.addColumn("Tratamiento");
        model.addColumn("DNI_doctor");
        table.setModel(model);
        scrollPane.setViewportView(table);

        ConectorDB_mysql conection = new ConectorDB_mysql();
        conection.conectar();

        List<Paciente> historialPaciente = conection.obtenerInfoPaciente(DNI_paciente);
        System.out.println(DNI_paciente);
        llenarTabla(historialPaciente);
    }

    public void llenarTabla(List<Paciente> historialPaciente) {
        if (historialPaciente != null) {
            for (Paciente historial : historialPaciente) {
                Object[] fila = new Object[3];
                fila[0] = historial.getFecha();
                fila[1] = historial.getTratamiento();
                fila[2] = historial.getDni_dr();
                model.addRow(fila);
            }
        }
    }
}


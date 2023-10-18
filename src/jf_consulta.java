import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;

public class jf_consulta extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	Fondo fondo = new Fondo();
    public jf_consulta() {
    	setPreferredSize(new Dimension(1450, 750));
    	setResizable(false);
        this.setContentPane(fondo);      
        initComponents();
        this.setLocationRelativeTo(jp_menu);
        jp_menu.setLayout(null);
        jp_menu.add(btn_buscar_cita);
        jp_menu.add(btn_historial);
        jp_menu.add(btn_eliminar_cita);
        jp_menu.add(btn_nueva_cita);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jp_menu = new Fondo();
        jp_menu.setPreferredSize(new Dimension(1450, 750));
        btn_buscar_cita = new javax.swing.JButton();
        btn_buscar_cita.setBounds(68, 622, 146, 23);
        btn_buscar_cita.setBorderPainted(false);
        btn_buscar_cita.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btn_nueva_cita = new javax.swing.JButton();
        btn_nueva_cita.setBounds(1209, 622, 146, 23);
        btn_nueva_cita.setBorderPainted(false);
        btn_historial = new javax.swing.JButton();
        btn_historial.setBounds(401, 622, 146, 23);
        btn_historial.setBorderPainted(false);
        btn_eliminar_cita = new javax.swing.JButton();
        btn_eliminar_cita.setBounds(891, 622, 146, 23);
        btn_eliminar_cita.setBorderPainted(false);
        btn_eliminar_cita.setText("ELIMINAR CITA");
        menu_inicio = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jMenu7 = new javax.swing.JMenu();
        jMenu8 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btn_buscar_cita.setText("BUSCAR CITA");

        btn_nueva_cita.setText("NUEVA CITA");

        btn_historial.setText("HISTORIAL");

        menu_inicio.setBackground(new java.awt.Color(32, 160, 216));
        menu_inicio.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        menu_inicio.setBorderPainted(false);

        jMenu1.setBackground(new java.awt.Color(32, 160, 216));
        jMenu1.setText("INICIO");
        menu_inicio.add(jMenu1);

        jMenu2.setText("PACIENTES");
        menu_inicio.add(jMenu2);

        jMenu3.setText("DOCTORES");
        menu_inicio.add(jMenu3);

        jMenu4.setText("MATERIAL");
        menu_inicio.add(jMenu4);

        jMenu5.setText("CONSULTAS");
        menu_inicio.add(jMenu5);

        jMenu6.setText("FACTURACIÓN");
        menu_inicio.add(jMenu6);

        jMenu7.setText("AJUSTES");
        menu_inicio.add(jMenu7);

        jMenu8.setText("AYUDA");
        menu_inicio.add(jMenu8);

        setJMenuBar(menu_inicio);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jp_menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jp_menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jf_consulta().setVisible(true);
            }
        });
    }
    private javax.swing.JButton btn_historial;
    private javax.swing.JButton btn_nueva_cita;
    private javax.swing.JButton btn_buscar_cita;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JPanel jp_menu;
    private javax.swing.JMenuBar menu_inicio;
    private JButton btn_eliminar_cita;
    // End of variables declaration//GEN-END:variables

}

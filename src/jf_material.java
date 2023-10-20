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
import java.awt.Font;
import javax.swing.JMenuItem;
import java.awt.Dimension;
import java.awt.Cursor;

public class jf_material extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	Fondo fondo = new Fondo();
    public jf_material() {
    	setPreferredSize(new Dimension(1450, 750));
        this.setContentPane(fondo);      
        initComponents();
        setLocationRelativeTo(this);
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
        btn_buscar_pedido = new javax.swing.JButton();
        btn_buscar_pedido.setBounds(68, 620, 146, 23);
        btn_buscar_pedido.setBorderPainted(false);
        btn_buscar_pedido.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btn_nuevo_pedido = new javax.swing.JButton();
        btn_nuevo_pedido.setBounds(879, 620, 146, 23);
        btn_nuevo_pedido.setBorderPainted(false);
        btn_proveedores = new javax.swing.JButton();
        btn_proveedores.setBounds(401, 620, 146, 23);
        btn_proveedores.setBorderPainted(false);
        menu_inicio = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenu2.setFont(new Font("Arial", Font.PLAIN, 12));
        jMenu3 = new javax.swing.JMenu();
        jMenu3.setFont(new Font("Arial", Font.PLAIN, 12));
        jMenu4 = new javax.swing.JMenu();
        jMenu4.setFont(new Font("Arial", Font.PLAIN, 12));
        jMenu5 = new javax.swing.JMenu();
        jMenu5.setFont(new Font("Arial", Font.PLAIN, 12));
        jMenu6 = new javax.swing.JMenu();
        jMenu6.setFont(new Font("Arial", Font.PLAIN, 12));
        jMenu7 = new javax.swing.JMenu();
        jMenu7.setFont(new Font("Arial", Font.PLAIN, 12));
        jMenu8 = new javax.swing.JMenu();
        jMenu8.setFont(new Font("Arial", Font.PLAIN, 12));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btn_buscar_pedido.setText("BUSCAR PEDIDO");

        btn_nuevo_pedido.setText("NUEVO PEDIDO");

        btn_proveedores.setText("PROVEEDORES");
        
        btn_inventario = new JButton();
        btn_inventario.setBounds(68, 561, 146, 15);
        btn_inventario.setContentAreaFilled(false);
        btn_inventario.setBorder(null);
        btn_inventario.setOpaque(false);
        btn_inventario.setBorderPainted(false);
        btn_inventario.setText("INVENTARIO");
        
        btn_solicitudes = new JButton();
        btn_solicitudes.setBounds(1210, 620, 146, 23);
        btn_solicitudes.setBorderPainted(false);
        btn_solicitudes.setText("SOLICITUDES");

        menu_inicio.setBackground(new java.awt.Color(32, 160, 216));
        menu_inicio.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        menu_inicio.setBorderPainted(false);
        
        btnNewButton = new JButton("INICIO");
        btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        		jf_menu_ppal ventana = new jf_menu_ppal();
        		ventana.setVisible(true);
        	}
        });
        btnNewButton.setOpaque(false);
        btnNewButton.setFont(new Font("Arial", Font.PLAIN, 12));
        btnNewButton.setFocusPainted(false);
        btnNewButton.setContentAreaFilled(false);
        btnNewButton.setBorderPainted(false);
        menu_inicio.add(btnNewButton);

        jMenu2.setText("PACIENTES");
        menu_inicio.add(jMenu2);
        
        jmenuitem_menu_paciente = new JMenuItem("Menu paciente");
        jmenuitem_menu_paciente.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        		jf_pacientes ventana = new jf_pacientes();
        		ventana.setVisible(true);
        	}
        });
        jmenuitem_menu_paciente.setFont(new Font("Arial", Font.PLAIN, 12));
        jMenu2.add(jmenuitem_menu_paciente);
        
        jmenuitem_buscar_paciente = new JMenuItem("Buscar paciente");
        jmenuitem_buscar_paciente.setFont(new Font("Arial", Font.PLAIN, 12));
        jMenu2.add(jmenuitem_buscar_paciente);
        
        jmenuitem_editar_paciente = new JMenuItem("Editar paciente");
        jmenuitem_editar_paciente.setFont(new Font("Arial", Font.PLAIN, 12));
        jMenu2.add(jmenuitem_editar_paciente);
        
        jmenuitem_baja_paciente = new JMenuItem("Dar de baja");
        jmenuitem_baja_paciente.setFont(new Font("Arial", Font.PLAIN, 12));
        jMenu2.add(jmenuitem_baja_paciente);
        
        jmenuitem_alta_paciente = new JMenuItem("Dar de alta");
        jmenuitem_alta_paciente.setFont(new Font("Arial", Font.PLAIN, 12));
        jMenu2.add(jmenuitem_alta_paciente);

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
        jp_menu.setLayout(null);
        jp_menu.add(btn_inventario);
        jp_menu.add(btn_solicitudes);
        jp_menu.add(btn_buscar_pedido);
        jp_menu.add(btn_proveedores);
        jp_menu.add(btn_nuevo_pedido);

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
                new jf_material().setVisible(true);
            }
        });
    }
    private javax.swing.JButton btn_proveedores;
    private javax.swing.JButton btn_nuevo_pedido;
    private javax.swing.JButton btn_buscar_pedido;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JPanel jp_menu;
    private javax.swing.JMenuBar menu_inicio;
    private JButton btn_inventario;
    private JButton btn_solicitudes;
    private JMenuItem jmenuitem_buscar_paciente;
    private JMenuItem jmenuitem_menu_paciente;
    private JMenuItem jmenuitem_editar_paciente;
    private JMenuItem jmenuitem_alta_paciente;
    private JMenuItem jmenuitem_baja_paciente;
    private JButton btnNewButton;
    // End of variables declaration//GEN-END:variables

}

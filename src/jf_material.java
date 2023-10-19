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
        btn_buscar_pedido.setBorderPainted(false);
        btn_buscar_pedido.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btn_nuevo_pedido = new javax.swing.JButton();
        btn_nuevo_pedido.setBorderPainted(false);
        btn_proveedores = new javax.swing.JButton();
        btn_proveedores.setBorderPainted(false);
        btn_cancelar_pedido = new javax.swing.JButton();
        btn_cancelar_pedido.setBorderPainted(false);
        btn_cancelar_pedido.setText("CANCELAR PEDIDO");
        menu_inicio = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu1.setFont(new Font("Arial", Font.PLAIN, 12));
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
        btn_inventario.setContentAreaFilled(false);
        btn_inventario.setBorder(null);
        btn_inventario.setOpaque(false);
        btn_inventario.setBorderPainted(false);
        btn_inventario.setText("INVENTARIO");
        
        btn_solicitudes = new JButton();
        btn_solicitudes.setBorderPainted(false);
        btn_solicitudes.setText("SOLICITUDES");

        javax.swing.GroupLayout jp_menuLayout = new javax.swing.GroupLayout(jp_menu);
        jp_menuLayout.setHorizontalGroup(
        	jp_menuLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jp_menuLayout.createSequentialGroup()
        			.addGap(68)
        			.addGroup(jp_menuLayout.createParallelGroup(Alignment.LEADING)
        				.addGroup(Alignment.TRAILING, jp_menuLayout.createSequentialGroup()
        					.addComponent(btn_inventario, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED, 890, Short.MAX_VALUE)
        					.addComponent(btn_solicitudes, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE))
        				.addGroup(jp_menuLayout.createSequentialGroup()
        					.addComponent(btn_buscar_pedido, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
        					.addGap(187)
        					.addComponent(btn_proveedores, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED, 239, Short.MAX_VALUE)
        					.addComponent(btn_cancelar_pedido, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
        					.addGap(172)
        					.addComponent(btn_nuevo_pedido, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)))
        			.addGap(79))
        );
        jp_menuLayout.setVerticalGroup(
        	jp_menuLayout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(jp_menuLayout.createSequentialGroup()
        			.addContainerGap(533, Short.MAX_VALUE)
        			.addGroup(jp_menuLayout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(btn_solicitudes)
        				.addComponent(btn_inventario))
        			.addGap(40)
        			.addGroup(jp_menuLayout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(btn_buscar_pedido, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
        				.addComponent(btn_nuevo_pedido, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
        				.addComponent(btn_cancelar_pedido, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
        				.addComponent(btn_proveedores, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
        			.addGap(44))
        );
        jp_menu.setLayout(jp_menuLayout);

        menu_inicio.setBackground(new java.awt.Color(32, 160, 216));
        menu_inicio.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        menu_inicio.setBorderPainted(false);

        jMenu1.setBackground(new java.awt.Color(32, 160, 216));
        jMenu1.setText("INICIO");
        menu_inicio.add(jMenu1);
        
        jmenuitem_volver = new JMenuItem("Volver");
        jmenuitem_volver.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        		jf_menu_ppal ventana = new jf_menu_ppal();
        		ventana.setVisible(true);
        	}
        });
        jmenuitem_volver.setFont(new Font("Arial", Font.PLAIN, 12));
        jMenu1.add(jmenuitem_volver);

        jMenu2.setText("PACIENTES");
        menu_inicio.add(jMenu2);
        
        mntmNewMenuItem = new JMenuItem("New menu item");
        jMenu2.add(mntmNewMenuItem);

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
                new jf_material().setVisible(true);
            }
        });
    }
    private javax.swing.JButton btn_proveedores;
    private javax.swing.JButton btn_nuevo_pedido;
    private javax.swing.JButton btn_buscar_pedido;
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
    private JButton btn_cancelar_pedido;
    private JButton btn_inventario;
    private JButton btn_solicitudes;
    private JMenuItem jmenuitem_volver;
    private JMenuItem mntmNewMenuItem;
    // End of variables declaration//GEN-END:variables

}

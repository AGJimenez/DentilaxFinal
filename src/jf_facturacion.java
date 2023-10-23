import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.JMenuItem;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Cursor;
import javax.swing.JLabel;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class jf_facturacion extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	Fondo fondo = new Fondo();
    public jf_facturacion() {
    	setIconImage(Toolkit.getDefaultToolkit().getImage(jf_facturacion.class.getResource("/iconos_menus/dentilaxIcono.png")));
    	setTitle("Gestión de facturación");
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
        jp_menu.setPreferredSize(new Dimension(1450, 750));
        btn_buscar_factura = new javax.swing.JButton();
        btn_buscar_factura.setOpaque(false);
        btn_buscar_factura.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btn_buscar_factura.setContentAreaFilled(false);
        btn_buscar_factura.setIcon(new ImageIcon(jf_facturacion.class.getResource("/iconos_submenus/btn_buscarFactura_admin.png")));
        btn_buscar_factura.setBounds(68, 594, 188, 41);
        btn_buscar_factura.setBorderPainted(false);
        btn_buscar_factura.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		jd_buscar_factura ventana = new jd_buscar_factura();
        		ventana.setVisible(true);
        	}
        });
        btn_nueva_factura = new javax.swing.JButton();
        btn_nueva_factura.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btn_nueva_factura.setContentAreaFilled(false);
        btn_nueva_factura.setIcon(new ImageIcon(jf_facturacion.class.getResource("/iconos_submenus/btn_nuevaFactura_admin.png")));
        btn_nueva_factura.setOpaque(false);
        btn_nueva_factura.setBounds(1209, 594, 188, 41);
        btn_nueva_factura.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	jd_nueva_factura ventana = new jd_nueva_factura();
        	ventana.setVisible(true);
        	}
        });
        btn_nueva_factura.setBorderPainted(false);
        btn_historial_pago = new javax.swing.JButton();
        btn_historial_pago.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btn_historial_pago.setContentAreaFilled(false);
        btn_historial_pago.setOpaque(false);
        btn_historial_pago.setIcon(new ImageIcon(jf_facturacion.class.getResource("/iconos_submenus/btn_historialpago_admin.png")));
        btn_historial_pago.setBounds(401, 594, 188, 41);
        btn_historial_pago.setBorderPainted(false);
        btn_balance_gastos = new javax.swing.JButton();
        btn_balance_gastos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btn_balance_gastos.setContentAreaFilled(false);
        btn_balance_gastos.setIcon(new ImageIcon(jf_facturacion.class.getResource("/iconos_submenus/btn_balanceGastos_admin.png")));
        btn_balance_gastos.setOpaque(false);
        btn_balance_gastos.setBounds(891, 594, 188, 41);
        btn_balance_gastos.setBorderPainted(false);
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
        jp_menu.add(btn_buscar_factura);
        jp_menu.add(btn_historial_pago);
        jp_menu.add(btn_balance_gastos);
        jp_menu.add(btn_nueva_factura);
        
        lbl_fecha = new JLabel("");
        lbl_fecha.setBackground(Color.WHITE);
        lbl_fecha.setFont(new Font("Barlow", Font.PLAIN, 25));
        lbl_fecha.setBounds(1184, 642, 240, 23);
        jp_menu.add(lbl_fecha);
        
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	 Date fechaActual = new Date();
                 SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                 String fechaHoraFormateada = formato.format(fechaActual);
                 lbl_fecha.setText(fechaHoraFormateada);
            }
        });
        timer.start();

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
                new jf_facturacion().setVisible(true);
            }
        });
    }
    private javax.swing.JButton btn_historial_pago;
    private javax.swing.JButton btn_nueva_factura;
    private javax.swing.JButton btn_buscar_factura;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JPanel jp_menu;
    private javax.swing.JMenuBar menu_inicio;
    private JButton btn_balance_gastos;
    private JButton btnNewButton;
    private JLabel lbl_fecha;
    // End of variables declaration//GEN-END:variables

}

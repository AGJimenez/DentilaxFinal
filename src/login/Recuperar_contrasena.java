package login;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.Cursor;

public class Recuperar_contrasena extends JDialog {

	private static final String CONTROLADOR = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/dentilax?useSSL=false";
	private static final String USUARIO = "root";
	String tablaNombre;
	private static final String CLAVE = "1234";
	ResultSet resultado = null;
	Connection conect = null;
	Statement statement;
	String contraseña="";


	static {
		try {
			Class.forName(CONTROLADOR);
		} catch (ClassNotFoundException e) {
			System.out.println("Error al cargar el controlador");
			e.printStackTrace();
		}
	}
	
	
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txt_correo;
	 private static String emailFrom = "dentilax.recuperacion@gmail.com";
	   private static String passwordFrom = "bjeu whaa vyue hyej";
	   private String emailTo = "";
	   private String content = "";
	   private String subject = "Recuperación de contraseña";
	   private Properties mProperties;
	    private Session mSession;
	    private MimeMessage mCorreo;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Recuperar_contrasena dialog = new Recuperar_contrasena();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Recuperar_contrasena() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Recuperar_contrasena.class.getResource("/iconos_submenus/resetIcon.png")));
		setTitle("Recuperar contraseña");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 255, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(this);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(0, 128, 192));
		separator.setBounds(71, 125, 294, 8);
		contentPanel.add(separator);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.WHITE);
			buttonPane.setBounds(0, 197, 434, 65);
			contentPanel.add(buttonPane);
			buttonPane.setLayout(null);
			{
				JButton okButton = new JButton("ENVIAR CORREO");
				okButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				okButton.setForeground(new Color(255, 255, 255));
				okButton.setFont(new Font("Barlow", Font.BOLD, 17));
				okButton.setBorder(null);
				okButton.setBackground(new Color(32, 160, 216));
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						createEmail();
						sendEmail();
					}
				});
				okButton.setBounds(30, 1, 153, 43);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("CANCELAR");
				cancelButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				cancelButton.setForeground(new Color(255, 255, 255));
				cancelButton.setFont(new Font("Barlow", Font.BOLD, 17));
				cancelButton.setBorder(null);
				cancelButton.setBackground(new Color(32, 160, 216));
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setBounds(251, 1, 153, 43);
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		txt_correo = new JTextField();
		txt_correo.setOpaque(false);
		txt_correo.setBorder(null);
		txt_correo.setFont(new Font("Arial", Font.PLAIN, 14));
		txt_correo.setHorizontalAlignment(SwingConstants.CENTER);
		txt_correo.setBounds(32, 98, 370, 35);
		contentPanel.add(txt_correo);
		txt_correo.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Introduce correo de recuperación");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel.setBounds(98, 73, 370, 14);
		contentPanel.add(lblNewLabel);
	}
	
	 private void createEmail() {
		 
		 try {
	 		 
			 conect = DriverManager.getConnection(URL, USUARIO, CLAVE);
             statement = conect.createStatement();
             String query = "SELECT * FROM usuario WHERE Correo = '" + txt_correo.getText().toString() + "'";
             ResultSet resultSet = statement.executeQuery(query);
             mProperties = new Properties();

             if (resultSet.next()) {
                 // Acceso concedido
                 System.out.println("Contraseña encontrada");
                 contraseña = resultSet.getString("Contraseña");
                 
             } else {
                 // Acceso denegado
                 System.out.println("Acceso denegado");
             }
             
             //connection.close();
         } catch (SQLException ex) {
             ex.printStackTrace();
         }
		 
	        emailTo = txt_correo.getText().trim();
	        subject = subject.trim();
	        content = contraseña.trim();
	        
	         // Simple mail transfer protocol
	        mProperties.put("mail.smtp.host", "smtp.gmail.com");
	        mProperties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
	        mProperties.setProperty("mail.smtp.starttls.enable", "true");
	        mProperties.setProperty("mail.smtp.port", "587");
	        mProperties.setProperty("mail.smtp.user",emailFrom);
	        mProperties.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
	        mProperties.setProperty("mail.smtp.auth", "true");
	        
	        mSession = Session.getDefaultInstance(mProperties);
	        
	        
	        try {
	            mCorreo = new MimeMessage(mSession);
	            mCorreo.setFrom(new InternetAddress(emailFrom));
	            mCorreo.setRecipient(Message.RecipientType.TO, new InternetAddress(emailTo));
	            mCorreo.setSubject(subject);
	            mCorreo.setText(content, "ISO-8859-1", "html");
	                     
	            
	        } catch (AddressException ex) {
	            Logger.getLogger(Recuperar_contrasena.class.getName()).log(Level.SEVERE, null, ex);
	        } catch (MessagingException ex) {
	            Logger.getLogger(Recuperar_contrasena.class.getName()).log(Level.SEVERE, null, ex);
	        }
	    }
	 
	 private void sendEmail() {
	        try {
	            Transport mTransport = mSession.getTransport("smtp");
	            mTransport.connect(emailFrom, passwordFrom);
	            mTransport.sendMessage(mCorreo, mCorreo.getRecipients(Message.RecipientType.TO));
	            mTransport.close();
	            
	            JOptionPane.showMessageDialog(null, "Contraseña enviada");
	        } catch (NoSuchProviderException ex) {
	            Logger.getLogger(Recuperar_contrasena.class.getName()).log(Level.SEVERE, null, ex);
	        } catch (MessagingException ex) {
	            Logger.getLogger(Recuperar_contrasena.class.getName()).log(Level.SEVERE, null, ex);
	        }
	    }
}

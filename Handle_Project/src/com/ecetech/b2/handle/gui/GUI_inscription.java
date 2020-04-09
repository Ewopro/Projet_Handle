package com.ecetech.b2.handle.gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import com.ecetech.b2.handle.beans.Session;
import com.ecetech.b2.handle.utils.XMLProcessing;

public class GUI_inscription extends JFrame {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	///déclarations des variables
	private JPanel contentPane;
	private JTextField passwordField;
	private JTextField usernameField;
	int xx,xy;
	public JFrame frame;
	private JPasswordField confirmPasswordField;
	private JTextField emailField;
	/**
	 * Launch the application.
	 */
	
	///main Function
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_inscription frame = new GUI_inscription();
					frame.setUndecorated(true);
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	/// Constructor
	public GUI_inscription() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 505, 625);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//----------------------------------------------------------------------------------------------------------------\\
		
		
		
		/// déclaration panel du haut qui permet de bouger, réduire et fermer la fenêtre.
		JPanel north = new JPanel();
		
			///fonction qui permet de déplacer la fenêtre quand on désactives les bordures windows
			north.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					xx = e.getX();
					xy = e.getY();
				}
			});
			north.addMouseMotionListener(new MouseMotionAdapter() {
				@Override
				public void mouseDragged(MouseEvent f) {
					int x = f.getXOnScreen();
					int y = f.getYOnScreen();
					GUI_inscription.this.setLocation(x - xx,y -  xy);
				}
			});
			//Configuration panel principal
			north.setBackground(new Color(0, 128, 128));
			north.setBounds(0, 0, 515, 65);
			contentPane.add(north);
			north.setLayout(null);
		
				JLabel texteInscription = new JLabel("Inscription");
				texteInscription.setForeground(new Color(240, 248, 255));
				texteInscription.setFont(new Font("Tahoma", Font.PLAIN, 30));
				texteInscription.setBounds(27, 0, 191, 65);
				north.add(texteInscription);
				
				JButton fermer = new JButton("");//
				fermer.setBackground(new Color(255, 165, 0));
				fermer.setIcon(new ImageIcon(GUI_inscription.class.getResource("/img/close.png")));
				fermer.setBounds(441, 10, 40, 45);
				fermer.setContentAreaFilled(false);
				fermer.setOpaque(false);
				fermer.setBorderPainted(false);
				north.add(fermer);
				
				JButton Reduire = new JButton("");
				Reduire.setIcon(new ImageIcon(GUI_inscription.class.getResource("/img/icons8-fl\u00E8che-r\u00E9duire-48.png")));
				Reduire.setBounds(378, 10, 40, 45);
				Reduire.setContentAreaFilled(false);
				Reduire.setOpaque(false);
				Reduire.setBorderPainted(false);
				north.add(Reduire);
		
				//----------------------------------------------------------------------------------------------------------------\\
				
				
				
		//// Déclaration du Panel du formulaire
				
		JPanel panelFormulaire = new JPanel();
		panelFormulaire.setBackground(new Color(60, 179, 113));
		panelFormulaire.setBounds(0, 61, 515, 578);
		contentPane.add(panelFormulaire);
		panelFormulaire.setLayout(null);
		
			JLabel logoHandle = new JLabel("");
			logoHandle.setIcon(new ImageIcon(GUI_connexion.class.getResource("/img/logo handle.PNG")));
			logoHandle.setBounds(184, 10, 122, 150);
			panelFormulaire.add(logoHandle);
			
			
			/// champ username
			JLabel lblUsername = new JLabel("Username:");
			lblUsername.setForeground(new Color(240, 255, 240));
			lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 25));
			lblUsername.setBounds(60, 179, 129, 35);
			panelFormulaire.add(lblUsername);
			
				usernameField = new JTextField();
				usernameField.setFont(new Font("Tahoma", Font.PLAIN, 20));
				usernameField.setColumns(10);
				usernameField.setBackground(new Color(144, 238, 144));
				usernameField.setBounds(202, 179, 244, 35);
				panelFormulaire.add(usernameField);
			
				
			/// champ password	
			JLabel lblPassword = new JLabel("Password:");
			lblPassword.setForeground(new Color(240, 255, 240));
			lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 25));
			lblPassword.setBounds(60, 243, 129, 35);
			panelFormulaire.add(lblPassword);
			
				passwordField = new JPasswordField();
				passwordField.setFont(new Font("Tahoma", Font.PLAIN, 20));
				passwordField.setColumns(10);
				passwordField.setBackground(new Color(144, 238, 144));
				passwordField.setBounds(202, 243, 244, 35);
				panelFormulaire.add(passwordField);
			
				
			/// champ pour confirmer le password
			JLabel lblConfirmPwd = new JLabel("Confirm:");
			lblConfirmPwd.setForeground(new Color(240, 255, 240));
			lblConfirmPwd.setFont(new Font("Tahoma", Font.PLAIN, 25));
			lblConfirmPwd.setBounds(60, 306, 129, 35);
			panelFormulaire.add(lblConfirmPwd);
			
				confirmPasswordField = new JPasswordField();
				confirmPasswordField.setFont(new Font("Tahoma", Font.PLAIN, 20));
				confirmPasswordField.setColumns(10);
				confirmPasswordField.setBackground(new Color(144, 238, 144));
				confirmPasswordField.setBounds(202, 306, 244, 35);
				panelFormulaire.add(confirmPasswordField);
			
				
			/// champ email
			JLabel lblEmail = new JLabel("Email:");
			lblEmail.setForeground(new Color(240, 255, 240));
			lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 25));
			lblEmail.setBounds(60, 376, 129, 35);
			panelFormulaire.add(lblEmail);
			
				emailField = new JTextField();
				emailField.setFont(new Font("Tahoma", Font.PLAIN, 20));
				emailField.setColumns(10);
				emailField.setBackground(new Color(144, 238, 144));
				emailField.setBounds(202, 376, 244, 35);
				panelFormulaire.add(emailField);
			
				
			///// Déclaration des boutons pour annuler, confirmer l'inscription et retourner au login
			JButton btnCancel = new JButton("Cancel");
			btnCancel.setForeground(new Color(245, 245, 245));
			btnCancel.setBackground(new Color(255, 0, 0));
			btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btnCancel.setBounds(71, 432, 163, 35);
			panelFormulaire.add(btnCancel);
			
			JButton btnLogin = new JButton("S'inscrire");
			btnLogin.setBackground(new Color(30, 144, 255));
			btnLogin.setForeground(new Color(245, 255, 250));
			btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btnLogin.setBounds(275, 432, 163, 35);
			panelFormulaire.add(btnLogin);
			
			JButton btnInscription = new JButton("Retour Login");
			btnInscription.setForeground(new Color(245, 245, 245));
			btnInscription.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btnInscription.setBackground(new Color(0, 139, 139));
			btnInscription.setBounds(173, 477, 163, 35);
			panelFormulaire.add(btnInscription);
			
			//----------------------------------------------------------------------------------------------------------------\\
			
			
		///fonction pour fermer la fenêtre avec bouton croix
		fermer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUI_inscription.this.dispose();
			}
		});
		
		///fonction pour fermer la fenêtre avec cancel
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUI_inscription.this.dispose();
			}
		});
		
		///fonction pour réduire la fenêtre dans la barre de tâche
		Reduire.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setState(GUI_inscription.ICONIFIED);
			}
		});
		
		
		////Fonction pour ouvrir la fenêtre de connexion
		btnInscription.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUI_inscription.this.dispose();
				GUI_connexion f = new GUI_connexion();
				f.setUndecorated(true);
				f.setVisible(true);
			}
		});
		
		
		////fonction qui va ajouter un utilisateur au fichier xml
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				if(e.getSource()== btnLogin) {
					String a = usernameField.getText().trim();
					String b = passwordField.getText().trim();
					String c = emailField.getText().trim();
					Session newS = new Session(a,b,c);
					try {
						XMLProcessing.createNodeAndNewXMLFile("file_sessions.xml",newS);
						//XMLProcessing.createNodeInExistingXMLFile("file_sessions.xml",newS);
					} catch (ParserConfigurationException e1) {
						e1.printStackTrace();
					} catch (TransformerException e1) {
						e1.printStackTrace();
					}					
				}
			}


		});
	}
}

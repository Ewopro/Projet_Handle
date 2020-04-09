package com.ecetech.b2.handle.gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import com.ecetech.b2.handle.utils.XMLProcessing;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

public class GUI_connexion extends JFrame {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	///Déclarations des variables et des panels
	private JPanel contentPane;
	public JButton close;
	int xx,xy;
	private JTextField passwordField;
	private JTextField usernameField;

	/**
	 * Launch the application.
	 */
	///main Function
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_connexion frame1 = new GUI_connexion();
					frame1.setUndecorated(true);
					frame1.setVisible(true);
					frame1.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	///Constructor
	public GUI_connexion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 505, 489);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel north = new JPanel();
		
			//// Fonctions qui permettent de déplacer la fenêtre lorsqu'on désactive les bordures windows
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
					GUI_connexion.this.setLocation(x - xx,y -  xy);
				}
			});
			///déclarations du panel de haut
			north.setBackground(new Color(0, 128, 128));
			north.setBounds(0, 0, 515, 65);
			contentPane.add(north);
			north.setLayout(null);
				
				JLabel textlLoginForm = new JLabel("Login Form");
				textlLoginForm.setForeground(new Color(240, 248, 255));
				textlLoginForm.setFont(new Font("Tahoma", Font.PLAIN, 30));
				textlLoginForm.setBounds(27, 0, 191, 65);
				north.add(textlLoginForm);
				
				JButton fermer = new JButton("");//
				fermer.setBackground(new Color(255, 165, 0));
				fermer.setIcon(new ImageIcon(GUI_connexion.class.getResource("/img/close.png")));
				fermer.setBounds(441, 10, 40, 45);
				fermer.setContentAreaFilled(false);
				fermer.setOpaque(false);
				fermer.setBorderPainted(false);
				north.add(fermer);
				
				JButton Reduire = new JButton("");
				Reduire.setIcon(new ImageIcon(GUI_connexion.class.getResource("/img/icons8-fl\u00E8che-r\u00E9duire-48.png")));
				Reduire.setBounds(378, 10, 40, 45);
				Reduire.setContentAreaFilled(false);
				Reduire.setOpaque(false);
		Reduire.setBorderPainted(false);
		north.add(Reduire);
		
		
		//----------------------------------------------------------------------------------------------------------------\\
		
		
		//// déclaration du panel formulaire de connexion
		JPanel panelFormConnexion = new JPanel();
		panelFormConnexion.setBackground(new Color(60, 179, 113));
		panelFormConnexion.setBounds(0, 64, 515, 457);
		contentPane.add(panelFormConnexion);
		panelFormConnexion.setLayout(null);
			
		
			////déclarations des labels du formulaire
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(GUI_connexion.class.getResource("/img/logo handle.PNG")));
			lblNewLabel.setBounds(184, 10, 122, 150);
			panelFormConnexion.add(lblNewLabel);
			
			JLabel usernameLabel = new JLabel("Username:");
			usernameLabel.setForeground(new Color(240, 255, 240));
			usernameLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
			usernameLabel.setBounds(60, 179, 129, 35);
			panelFormConnexion.add(usernameLabel);
			
			usernameField = new JTextField();
			usernameField.setColumns(10);
			usernameField.setBackground(new Color(144, 238, 144));
			usernameField.setBounds(202, 179, 244, 35);
			panelFormConnexion.add(usernameField);
			
			JLabel passwordLabel = new JLabel("Password:");
			passwordLabel.setForeground(new Color(240, 255, 240));
			passwordLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
			passwordLabel.setBounds(60, 249, 129, 35);
			panelFormConnexion.add(passwordLabel);
			
			passwordField = new JPasswordField();
			passwordField.setColumns(10);
			passwordField.setBackground(new Color(144, 238, 144));
			passwordField.setBounds(202, 249, 244, 35);
			panelFormConnexion.add(passwordField);
			
			JButton btnCancel = new JButton("Cancel");
			btnCancel.setForeground(new Color(245, 245, 245));
			btnCancel.setBackground(new Color(255, 0, 0));
			btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btnCancel.setBounds(67, 313, 163, 35);
			panelFormConnexion.add(btnCancel);
			
			JButton btnLogin = new JButton("Login");
			btnLogin.setBackground(new Color(30, 144, 255));
			btnLogin.setForeground(new Color(245, 255, 250));
			btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btnLogin.setBounds(271, 313, 163, 35);
			panelFormConnexion.add(btnLogin);
			
			
			/// ce bouton va envoyer l'utilisateur sur la page d'inscription.
			JButton btnInscription = new JButton("Inscription");
			btnInscription.setForeground(new Color(245, 245, 245));
			btnInscription.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btnInscription.setBackground(new Color(0, 139, 139));
			btnInscription.setBounds(169, 358, 163, 35);
			panelFormConnexion.add(btnInscription);
		
			
			
			//----------------------------------------------------------------------------------------------------------------\\
			
			//// Fonction de connexion à la séssion
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					String username = usernameField.getText();
					String psw = passwordField.getText();
					if(XMLProcessing.verifUserInXmlFile(username,psw)) {
						try {	
							GUI_connexion.this.dispose();
							GUI_home window = new GUI_home();
							window.framebis.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
						
					}
					else {
						JOptionPane.showMessageDialog(null, "Connection error", "Error", JOptionPane.ERROR_MESSAGE);
					}
				
			}
		});
		
		
		///fonction de fermeture de la fenêtre
		fermer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUI_connexion.this.dispose();
			}
		});
		
		///fonction pour réduire la fenêtre
		Reduire.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setState(GUI_connexion.ICONIFIED);
			}
		});
		
		
		//// fonction de fermerture de la fenêtre par bouton cancel
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUI_connexion.this.dispose();
			}
		});
		
		
		///fonction qui renvoie vers la page d'inscription
		btnInscription.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUI_connexion.this.dispose();
				GUI_inscription f = new GUI_inscription();
				f.setUndecorated(true);
				f.setVisible(true);
			}
		});
	}
}

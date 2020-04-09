package com.ecetech.b2.handle.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import java.awt.Toolkit;
import javax.swing.JTextArea;
import javax.swing.JTextPane;



public class GUI_home {

	public JFrame framebis;
	public JTextArea textArea;
	public JLabel resultat;
	public JPanel diagnostic;
	
	int xx,xy;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_home window = new GUI_home();
					window.framebis.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI_home() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		
		//creation et paramettrage de la fenetre principal
		
		
		framebis = new JFrame();
		framebis.setResizable(false);
		framebis.setIconImage(Toolkit.getDefaultToolkit().getImage(GUI_home.class.getResource("/img/logo handle.PNG")));
		framebis.setBounds(100, 100, 1277, 682);
		framebis.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		framebis.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		// panel permettant d'avoir plusieurs panel sur une application (multi fenetre dans une meme fenetre)
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(258, 99, 1005, 546);
		panel.add(layeredPane);
		
		// declaration panel qui ne bouge pas gauche menu et en haut barre de recherche
		JPanel barre_top = new JPanel();
		barre_top.setBackground(new Color(102, 205, 170));
		barre_top.setForeground(new Color(250, 240, 230));
		barre_top.setBounds(258, 0, 1005, 103);
		panel.add(barre_top);
		barre_top.setLayout(null);
		
		JPanel barre_Menu = new JPanel();
		barre_Menu.setForeground(new Color(0, 0, 0));
		barre_Menu.setBackground(new Color(32, 178, 170));
		barre_Menu.setBounds(0, 0, 259, 645);
		panel.add(barre_Menu);
		barre_Menu.setLayout(null);
		
		JLabel affichageBienvenue = new JLabel("Bienvenue");
		affichageBienvenue.setForeground(new Color(250, 240, 230));
		affichageBienvenue.setFont(new Font("Tahoma", Font.BOLD, 25));
		affichageBienvenue.setBounds(24, 40, 232, 31);
		barre_top.add(affichageBienvenue);
		
		
		//Logo Handle
		JLabel logoHandle = new JLabel("");
		logoHandle.setIcon(new ImageIcon(GUI_home.class.getResource("/img/logo handle.PNG")));
		logoHandle.setBounds(58, 0, 122, 155);
		barre_Menu.add(logoHandle);
		
		//label (zone de texte) Accueil
		JLabel lblAccueil = new JLabel("Accueil");
		lblAccueil.setIcon(new ImageIcon(GUI_home.class.getResource("/img/icons8_home_50px.png")));
		lblAccueil.setForeground(Color.WHITE);
		lblAccueil.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblAccueil.setBounds(42, 206, 167, 48);
		barre_Menu.add(lblAccueil);
		
		//label (zone de texte) Profil
		JLabel lblProfil = new JLabel("Profil");
		lblProfil.setIcon(new ImageIcon(GUI_home.class.getResource("/img/icons8_gender_neutral_user_50px.png")));
		lblProfil.setVerticalAlignment(SwingConstants.BOTTOM);
		lblProfil.setForeground(Color.WHITE);
		lblProfil.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblProfil.setBounds(42, 282, 167, 48);
		barre_Menu.add(lblProfil);
		
		//label (zone de texte) Examen
		JLabel lblExamen = new JLabel("Examen");
		lblExamen.setIcon(new ImageIcon(GUI_home.class.getResource("/img/icons8_medical_doctor_50px.png")));
		lblExamen.setVerticalAlignment(SwingConstants.BOTTOM);
		lblExamen.setForeground(Color.WHITE);
		lblExamen.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblExamen.setBounds(42, 356, 178, 48);
		barre_Menu.add(lblExamen);
		
		//label (zone de texte) Diagnostique
		JLabel lblDiagnostique = new JLabel("Diagnostique");
		lblDiagnostique.setIcon(new ImageIcon(GUI_home.class.getResource("/img/icons8_combo_chart_50px.png")));
		lblDiagnostique.setVerticalAlignment(SwingConstants.BOTTOM);
		lblDiagnostique.setForeground(Color.WHITE);
		lblDiagnostique.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblDiagnostique.setBounds(10, 432, 268, 48);
		barre_Menu.add(lblDiagnostique);
		
		//label (zone de texte) Aide
		JLabel lblAide = new JLabel("Aide");
		lblAide.setIcon(new ImageIcon(GUI_home.class.getResource("/img/icons8_help_50px.png")));
		lblAide.setVerticalAlignment(SwingConstants.BOTTOM);
		lblAide.setForeground(Color.WHITE);
		lblAide.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblAide.setBounds(42, 511, 178, 48);
		barre_Menu.add(lblAide);
		
		//boutton present en permanance panel 2 (panel sur le coté gauche)
		
		//bouton accueil
		JButton accueilbutton = new JButton("");
		accueilbutton.setForeground(SystemColor.desktop);
		accueilbutton.setBackground(new Color(255, 255, 255));
		accueilbutton.setBounds(42, 210, 167, 44);
		accueilbutton.setOpaque(false);
		accueilbutton.setContentAreaFilled(false);
		accueilbutton.setBorderPainted(false);
		barre_Menu.add(accueilbutton);
		
		//bouton profil
		JButton profilbutton = new JButton("");
		profilbutton.setOpaque(false);
		profilbutton.setForeground(Color.BLACK);
		profilbutton.setContentAreaFilled(false);
		profilbutton.setBorderPainted(false);
		profilbutton.setBackground(Color.WHITE);
		profilbutton.setBounds(42, 282, 167, 44);
		barre_Menu.add(profilbutton);
		
		//bouton examen
		JButton examenbutton = new JButton("");
		examenbutton.setOpaque(false);
		examenbutton.setForeground(Color.BLACK);
		examenbutton.setContentAreaFilled(false);
		examenbutton.setBorderPainted(false);
		examenbutton.setBackground(Color.WHITE);
		examenbutton.setBounds(42, 356, 167, 44);
		barre_Menu.add(examenbutton);
		
		//bouton diagnostique
		JButton diagnostiquebutton = new JButton("");
		diagnostiquebutton.setOpaque(false);
		diagnostiquebutton.setForeground(Color.BLACK);
		diagnostiquebutton.setContentAreaFilled(false);
		diagnostiquebutton.setBorderPainted(false);
		diagnostiquebutton.setBackground(Color.WHITE);
		diagnostiquebutton.setBounds(13, 432, 236, 44);
		barre_Menu.add(diagnostiquebutton);
		
		//bouton aide
		JButton aidebutton = new JButton("");
		aidebutton.setOpaque(false);
		aidebutton.setForeground(Color.BLACK);
		aidebutton.setContentAreaFilled(false);
		aidebutton.setBorderPainted(false);
		aidebutton.setBackground(Color.WHITE);
		aidebutton.setBounds(42, 515, 136, 44);
		barre_Menu.add(aidebutton);
		
		///
		// declaration des différents panels. Indentation pour préciser quels label est dans quel panel
		///
		
		
		

		//panel accueil
		JPanel accueil = new JPanel();
		accueil.setForeground(new Color(224, 255, 255));
		accueil.setBackground(new Color(102, 255, 153));
		accueil.setBounds(0, 0, 1005, 546);
		layeredPane.add(accueil);
		accueil.setLayout(null);
		
			JLabel lblBienvenue = new JLabel("BIENVENUE");
			lblBienvenue.setForeground(new Color(0, 0, 128));
			lblBienvenue.setFont(new Font("Tahoma", Font.BOLD, 40));
			lblBienvenue.setBounds(64, 36, 252, 47);
			accueil.add(lblBienvenue);
			
			JLabel imageAccueil = new JLabel("");
			imageAccueil.setIcon(new ImageIcon(GUI_home.class.getResource("/img/corpsbioflash.png")));
			imageAccueil.setBounds(113, 114, 160, 362);
			accueil.add(imageAccueil);
			
			JLabel lblDernierDiagnostique = new JLabel("DERNIER DIAGNOSTIQUE");
			lblDernierDiagnostique.setForeground(new Color(0, 128, 128));
			lblDernierDiagnostique.setFont(new Font("Tahoma", Font.BOLD, 34));
			lblDernierDiagnostique.setBounds(460, 106, 448, 47);
			accueil.add(lblDernierDiagnostique);
			
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(GUI_home.class.getResource("/img/health_checkup_100px.png")));
			lblNewLabel.setBounds(356, 226, 114, 95);
			accueil.add(lblNewLabel);
			
			JLabel lblRaliserLe = new JLabel("R\u00E9aliser le 25/03/2020");
			lblRaliserLe.setForeground(new Color(0, 128, 128));
			lblRaliserLe.setFont(new Font("Tahoma", Font.BOLD, 30));
			lblRaliserLe.setBounds(488, 248, 364, 47);
			accueil.add(lblRaliserLe);
			
			JButton btnNewButton = new JButton("Voir");
			btnNewButton.setForeground(new Color(245, 255, 250));
			btnNewButton.setBackground(new Color(0, 128, 128));
			btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
			btnNewButton.setBounds(876, 254, 81, 39);
			accueil.add(btnNewButton);
			
			JLabel lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setIcon(new ImageIcon(GUI_home.class.getResource("/img/icons8_copyright_32px_2.png")));
			lblNewLabel_1.setBounds(957, 504, 38, 32);
			accueil.add(lblNewLabel_1);
			
			//----------------------------------------------------------------------------------------------------------------\\
			
			
		// label panel profil
		JPanel profil = new JPanel();
		profil.setBackground(new Color(102, 255, 153));
		profil.setForeground(new Color(153, 255, 153));
		profil.setBounds(0, 0, 1005, 546);
		layeredPane.add(profil);
		profil.setLayout(null);
		
			JLabel lblTitre = new JLabel("PROFIL");
			lblTitre.setForeground(new Color(0, 51, 51));
			lblTitre.setFont(new Font("Tahoma", Font.BOLD, 40));
			lblTitre.setBounds(429, 28, 185, 47);
			profil.add(lblTitre);
		
			JLabel lblIdentifiant = new JLabel("IDENTIFIANT");
			lblIdentifiant.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
			lblIdentifiant.setBounds(157, 111, 141, 47);
			profil.add(lblIdentifiant);
			
			JTextField textField_ID;
			textField_ID = new JTextField();
			textField_ID.setVisible(false);
			textField_ID.setBounds(157, 157, 194, 19);
			profil.add(textField_ID);
			textField_ID.setColumns(10);
			
			JLabel lblMotDePasse = new JLabel("MOT DE PASSE");
			lblMotDePasse.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
			lblMotDePasse.setBounds(157, 186, 162, 47);
			profil.add(lblMotDePasse);
			
			JTextField textField_mdp;
			textField_mdp = new JTextField();
			textField_mdp.setVisible(false);
			textField_mdp.setColumns(10);
			textField_mdp.setBounds(157, 232, 194, 19);
			profil.add(textField_mdp);
			
			JLabel lblEmail = new JLabel("EMAIL");
			lblEmail.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
			lblEmail.setBounds(157, 261, 141, 47);
			profil.add(lblEmail);
			
			JTextField textField_email;
			textField_email = new JTextField();
			textField_email.setVisible(false);
			textField_email.setColumns(10);
			textField_email.setBounds(157, 307, 194, 19);
			profil.add(textField_email);
			
			JLabel lblPrenom = new JLabel("PRENOM");
			lblPrenom.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
			lblPrenom.setBounds(587, 111, 141, 47);
			profil.add(lblPrenom);
			
			JTextField textField_prenom;
			textField_prenom = new JTextField();
			textField_prenom.setVisible(false);
			textField_prenom.setColumns(10);
			textField_prenom.setBounds(587, 157, 194, 19);
			profil.add(textField_prenom);
			
			JLabel lblNom = new JLabel("NOM");
			lblNom.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
			lblNom.setBounds(587, 186, 162, 47);
			profil.add(lblNom);
			
			JTextField textField_nom;
			textField_nom = new JTextField();
			textField_nom.setVisible(false);
			textField_nom.setColumns(10);
			textField_nom.setBounds(587, 232, 194, 19);
			profil.add(textField_nom);
			
			JLabel lblAge = new JLabel("AGE");
			lblAge.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
			lblAge.setBounds(587, 261, 141, 47);
			profil.add(lblAge);
			
			JTextField textField_age;
			textField_age = new JTextField();
			textField_age.setVisible(false);
			textField_age.setColumns(10);
			textField_age.setBounds(587, 307, 194, 19);
			profil.add(textField_age);
			
			JLabel lblProfession = new JLabel("PROFESSION");
			lblProfession.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
			lblProfession.setBounds(587, 336, 141, 47);
			profil.add(lblProfession);
			
			JTextField textField_profession;
			textField_profession = new JTextField();
			textField_profession.setVisible(false);
			textField_profession.setColumns(10);
			textField_profession.setBounds(587, 382, 194, 19);
			profil.add(textField_profession);
			
			JLabel iconeId = new JLabel("");
			iconeId.setIcon(new ImageIcon(GUI_home.class.getResource("/img/icons8_male_user_50px.png")));
			iconeId.setBounds(94, 137, 50, 60);
			profil.add(iconeId);
			
			JLabel iconeMdp = new JLabel("");
			iconeMdp.setIcon(new ImageIcon(GUI_home.class.getResource("/img/icons8_password_50px.png")));
			iconeMdp.setBounds(94, 207, 53, 60);
			profil.add(iconeMdp);
			
			JLabel iconeMail = new JLabel("");
			iconeMail.setIcon(new ImageIcon(GUI_home.class.getResource("/img/icons8_secured_letter_50px.png")));
			iconeMail.setBounds(94, 291, 50, 50);
			profil.add(iconeMail);
			
			JLabel copyright = new JLabel("");
			copyright.setIcon(new ImageIcon(GUI_home.class.getResource("/img/icons8_copyright_32px_2.png")));
			copyright.setBounds(957, 504, 38, 32);
			profil.add(copyright);
			
		
			
		//----------------------------------------------------------------------------------------------------------------\\	
		
			
		// panel examen	
		JPanel examen = new JPanel();
		examen.setBackground(new Color(102, 255, 153));
		examen.setBounds(0, 0, 1005, 546);
		layeredPane.add(examen);
		examen.setLayout(null);
		
			JLabel titreLblExam = new JLabel("EXAMEN");
			titreLblExam.setForeground(new Color(0, 51, 51));
			titreLblExam.setFont(new Font("Tahoma", Font.BOLD, 40));
			titreLblExam.setBounds(440, 36, 185, 47);
			examen.add(titreLblExam);
					
			JLabel iconeDesc1 = new JLabel("AFIN D'ETABLIR AU MIEUX VOTRE PROFIL ET UN DIAGNOSTIQUE PLUSIEURS QUESTION ");
			iconeDesc1.setForeground(new Color(0, 128, 128));
			iconeDesc1.setFont(new Font("Tahoma", Font.BOLD, 20));
			iconeDesc1.setBounds(60, 93, 985, 47);
			examen.add(iconeDesc1);
			
			JLabel iconeDesc2 = new JLabel("VONT VOUS ETRE POSER EN FONCTION DE VOS REPONSE AU PRECEDENTE QUESTION");
			iconeDesc2.setForeground(new Color(0, 128, 128));
			iconeDesc2.setFont(new Font("Tahoma", Font.BOLD, 20));
			iconeDesc2.setBounds(84, 123, 867, 47);
			examen.add(iconeDesc2);
			
			JLabel iconeAttention = new JLabel("");
			iconeAttention.setIcon(new ImageIcon(GUI_home.class.getResource("/img/icons8_high_priority_80px.png")));
			iconeAttention.setBounds(20, 174, 80, 80);
			examen.add(iconeAttention);
			
			JLabel iconeDesc3 = new JLabel("ATTENTION VOS REPONSES AU QUESTION SONT DETERMINANTE AFIN DE REALISER UN DIAGNOSTIQUE CORRECT !");
			iconeDesc3.setForeground(new Color(255, 0, 0));
			iconeDesc3.setFont(new Font("Tahoma", Font.BOLD, 15));
			iconeDesc3.setBounds(110, 190, 921, 47);
			examen.add(iconeDesc3);
			
			JButton btnDemarrerExamen = new JButton("D\u00E9marer l'\u00E9xamen");
			btnDemarrerExamen.setForeground(Color.WHITE);
			btnDemarrerExamen.setBackground(SystemColor.textHighlight);
			btnDemarrerExamen.setFont(new Font("Tahoma", Font.PLAIN, 30));
			btnDemarrerExamen.setBounds(378, 363, 295, 92);
			examen.add(btnDemarrerExamen);
			
			JLabel copyright_2 = new JLabel("");
			copyright_2.setIcon(new ImageIcon(GUI_home.class.getResource("/img/icons8_copyright_32px_2.png")));
			copyright_2.setBounds(957, 504, 38, 32);
			examen.add(copyright_2);
				
				
				
				
				//----------------------------------------------------------------------------------------------------------------\\
				
				
				
				
				
				//Panel diagnostique
				diagnostic = new JPanel();
				diagnostic.setBackground(new Color(102, 255, 153));
				diagnostic.setBounds(0, 0, 1005, 546);
				layeredPane.add(diagnostic);
				diagnostic.setLayout(null);
				
				
				
					JLabel label_2 = new JLabel("");
					label_2.setIcon(new ImageIcon(GUI_home.class.getResource("/img/icons8_copyright_32px_2.png")));
					label_2.setBounds(957, 504, 38, 32);
					diagnostic.add(label_2);
					
					JLabel lblDiagnostique_1 = new JLabel("DIAGNOSTIQUE");
					lblDiagnostique_1.setForeground(new Color(0, 51, 51));
					lblDiagnostique_1.setFont(new Font("Tahoma", Font.BOLD, 40));
					lblDiagnostique_1.setBounds(363, 10, 330, 47);
					diagnostic.add(lblDiagnostique_1);
					
					JLabel textSousTitre = new JLabel("Vous retrouverez ici vos derniers Examen !");
					textSousTitre.setForeground(Color.BLUE);
					textSousTitre.setFont(new Font("Tahoma", Font.BOLD, 30));
					textSousTitre.setBounds(201, 68, 679, 47);
					diagnostic.add(textSousTitre);
					
					JLabel lblVotreDernierExamen = new JLabel("Votre dernier examen en date :");
					lblVotreDernierExamen.setForeground(SystemColor.textHighlight);
					lblVotreDernierExamen.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
					lblVotreDernierExamen.setBounds(26, 143, 578, 47);
					diagnostic.add(lblVotreDernierExamen);
					
					
					JLabel resultat_1 = new JLabel("");
					resultat_1.setHorizontalAlignment(SwingConstants.CENTER);
					resultat_1.setForeground(new Color(220, 20, 60));
					resultat_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
					resultat_1.setBounds(55, 455, 906, 47);
					diagnostic.add(resultat_1);
					
					JTextArea textArea_1 = new JTextArea();
					textArea_1.setEditable(false);
					textArea_1.setForeground(new Color(0, 0, 128));
					textArea_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
					textArea_1.setBackground(Color.WHITE);
					textArea_1.setBounds(55, 212, 906, 233);
					diagnostic.add(textArea_1);
					
					
					
					
	
					//----------------------------------------------------------------------------------------------------------------\\	
						
					
						
					JPanel aide = new JPanel();
					aide.setBackground(new Color(102, 255, 153));
					aide.setBounds(0, 0, 1005, 546);
					layeredPane.add(aide);
					aide.setLayout(null);
					
						JLabel label_3 = new JLabel("");
						label_3.setIcon(new ImageIcon(GUI_home.class.getResource("/img/icons8_copyright_32px_2.png")));
						label_3.setBounds(957, 504, 38, 32);
						aide.add(label_3);
						
						JLabel lblAide_1 = new JLabel("AIDE");
						lblAide_1.setForeground(new Color(0, 51, 51));
						lblAide_1.setFont(new Font("Tahoma", Font.BOLD, 40));
						lblAide_1.setBounds(467, 10, 102, 47);
						aide.add(lblAide_1);
						
						JLabel aProposTitre = new JLabel("A Propos :");
						aProposTitre.setForeground(Color.RED);
						aProposTitre.setFont(new Font("Tahoma", Font.BOLD, 30));
						aProposTitre.setBounds(50, 181, 159, 37);
						aide.add(aProposTitre);
						
						JTextPane aProposTextContent = new JTextPane();
						aProposTextContent.setEditable(false);
						aProposTextContent.setForeground(Color.BLUE);
						aProposTextContent.setBackground(new Color(102, 255, 153));
						aProposTextContent.setFont(new Font("Sylfaen", Font.PLAIN, 20));
						aProposTextContent.setText("Handle est une application qui va r\u00E9aliser un diagnostique si vous rencontrer des probl\u00E8mes de sant\u00E9 type blessure ou maux en g\u00E9n\u00E9ral.\r\n\r\nPour r\u00E9aliser un diagnostique rendez-vous dans l'onglet examen puis cliquer sur d\u00E9marrer l'examen.\r\n\r\nUne nouvelle fen\u00EAtre va s'ouvrir et nous allons vous posez quelques question. \r\n\r\nPour plus d'information ou pour signaler quelconques probl\u00E8mes de fonctionnement contacter : handle_support@gmail.com");
						aProposTextContent.setBounds(49, 264, 934, 249);
						aide.add(aProposTextContent);
						
						JLabel lblNewLabel_2 = new JLabel("");
						lblNewLabel_2.setIcon(new ImageIcon(GUI_home.class.getResource("/img/logo handle.PNG")));
						lblNewLabel_2.setBounds(463, 92, 127, 141);
						aide.add(lblNewLabel_2);
						
				
				
				
				
			//----------------------------------------------------------------------------------------------------------------\\
			
				
			
				
				//Bouton pour démarrer l'examen. Ouvre la fenêtre du chatbot
						btnDemarrerExamen.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								Chatbot frame = new Chatbot(textArea_1,resultat_1);
								frame.setUndecorated(true);
								frame.setVisible(true);
								frame.setLocationRelativeTo(null);
							}
						});
		
		
		//action des bouttons present dans le panel 2 permettant la redirection vers les autres panels

		/// Envoie vers accueil				
		accueilbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(accueil);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		
		/// Envoie vers Profil
		profilbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(profil);
				layeredPane.repaint();
				layeredPane.revalidate();
				textField_prenom.setVisible(true);
				textField_ID.setVisible(true);
				textField_nom.setVisible(true);
				textField_email.setVisible(true);
				textField_age.setVisible(true);
				textField_profession.setVisible(true);
				textField_mdp.setVisible(true);
			}
		});
		
		
		/// Envoie vers Examen
		examenbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(examen);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		
		/// Envoie vers diagnostique
		diagnostiquebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(diagnostic);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(diagnostic);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		
		/// Envoie vers aide
		aidebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(aide);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
	}
}



 

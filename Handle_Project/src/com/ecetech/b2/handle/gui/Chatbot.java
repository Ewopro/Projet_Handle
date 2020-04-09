package com.ecetech.b2.handle.gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JScrollPane;

import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JTextArea;

public class Chatbot extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	int xx, xy;
	private JTextField field;
	private static int level = 1;
	private static Chatbot frame;
	private static JTextArea textAreaA;
	private static JLabel resultat;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Chatbot(textAreaA,resultat);
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
	public Chatbot(JTextArea textA, JLabel resultat) {
		textAreaA = textA;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 617, 502);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel north = new JPanel();
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
				Chatbot.this.setLocation(x - xx, y - xy);
			}
		});
		north.setBackground(new Color(0, 128, 128));
		north.setBounds(0, 0, 640, 65);
		contentPane.add(north);
		north.setLayout(null);

		JButton fermer = new JButton("");//
		fermer.setBackground(new Color(255, 165, 0));
		fermer.setIcon(new ImageIcon(Chatbot.class.getResource("/img/close.png")));
		fermer.setBounds(527, 10, 40, 45);
		fermer.setContentAreaFilled(false);
		fermer.setOpaque(false);
		fermer.setBorderPainted(false);
		north.add(fermer);

		JButton Reduire = new JButton("");
		Reduire.setIcon(new ImageIcon(Chatbot.class.getResource("/img/icons8-fl\u00E8che-r\u00E9duire-48.png")));
		Reduire.setBounds(477, 10, 40, 45);
		Reduire.setContentAreaFilled(false);
		Reduire.setOpaque(false);
		Reduire.setBorderPainted(false);
		north.add(Reduire);

		JLabel lblNewLabel = new JLabel("ChatBot");
		lblNewLabel.setForeground(SystemColor.text);
		lblNewLabel.setBounds(10, 0, 123, 65);
		north.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		JLabel lblQuestion = new JLabel("Question");
		lblQuestion.setForeground(SystemColor.textHighlight);
		lblQuestion.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblQuestion.setBounds(28, 64, 411, 52);
		contentPane.add(lblQuestion);

		JLabel lblVotreRponse = new JLabel("Votre R\u00E9ponse");
		lblVotreRponse.setForeground(SystemColor.textHighlight);
		lblVotreRponse.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblVotreRponse.setBounds(27, 346, 411, 52);
		contentPane.add(lblVotreRponse);
		
		JLabel image1 = new JLabel("");
		image1.setBounds(449, 75, 144, 116);
		contentPane.add(image1);
		
		JLabel image2 = new JLabel("");
		image2.setBounds(449, 220, 144, 116);
		contentPane.add(image2);
		
		JLabel image3 = new JLabel("");
		image3.setBounds(449, 346, 144, 116);
		contentPane.add(image3);

		field = new JTextField();
		field.setBounds(28, 400, 411, 36);
		contentPane.add(field);
		field.setColumns(10);

		JLabel image = new JLabel("");
		image.setIcon(new ImageIcon(Chatbot.class.getResource("/img/poignet.png")));
		image.setBounds(449, 75, 154, 361);
		contentPane.add(image);

		JTextArea txt = new JTextArea();
		txt.setEditable(false);
		txt.setBounds(10, 0, 411, 210);
		contentPane.add(txt);
		txt.append("Alvi= Pouvez vous réaliser ce mouvement ? (oui/non)\n");

		JScrollPane pane = new JScrollPane(txt, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
		JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		pane.setBounds(28, 126, 411, 210);
		getContentPane().add(pane);

		
		/// Chatbot pour le diagnostic
		
		field.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String reponse = field.getText();
				txt.append("You = " + reponse + "\n");
				field.setText("");
				
				// utilisation de la methode Switch case afin de poser les questions
				
				switch (level) {
				case 1:
					if (reponse.toLowerCase().equals("oui")) {
						txt.append("Alvi = Observez-vous la présence d'un Œdème de ce type ? (oui/non)\n");
						image.setIcon(new ImageIcon(GUI_home.class.getResource("/img/douleur-poignet-200x300.jpg")));
						level = 2;
					} else if (reponse.toLowerCase().equals("non")) {
						txt.append("Alvi = Observez-vous la présence d'un Œdème de ce type ?\n");
						image.setIcon(new ImageIcon(GUI_home.class.getResource("/img/douleur-poignet-200x300.jpg")));
						level = 2;
					}
					else {
						txt.append("Alvi = Mince ! Mauvaise saisie veuillez recommencer !\n");
						txt.append("Alvi= Pouvez vous réaliser ce mouvement ? (oui/non)\n");
					}
					break;
				case 2:
					if (reponse.toLowerCase().equals("oui")) {
						txt.append("Alvi = Observez-vous la présence d'un de ces Symptômes ?\n");
						txt.append("Alvi = Entrez : /1/ pour Difformité \n");
						txt.append("Alvi = Entrez : /2/ pour Bosse/Nodule \n");
						txt.append("Alvi = Entrez : /3/ pour Zone Rouge/Chaude \n");
						txt.append("Alvi = Entrez : 'non' pour présence d'aucuns de ces Symptômes\n");
						image1.setVisible(true);
						image2.setVisible(true);
						image3.setVisible(true);
						image1.setIcon(new ImageIcon(GUI_home.class.getResource("/img/difformite.png")));
						image2.setIcon(new ImageIcon(GUI_home.class.getResource("/img/nodule.png")));
						image3.setIcon(new ImageIcon(GUI_home.class.getResource("/img/rouge.png")));
						image.setVisible(false);
						level = 3;
					} else if (reponse.toLowerCase().equals("non")) {
						txt.append("Alvi = Ressentez-vous des craquements ? (oui/non)\n");
						image.setIcon(new ImageIcon(GUI_home.class.getResource("/img/craque.jpg")));
						level = 8;
					}
					else {
						txt.append("Alvi = Mince ! Mauvaise saisie veuillez recommencer !\n");
						txt.append("Alvi = Observez-vous la présence d'un Œdème de ce type ? (oui/non)\n");
						level = 2;
					}
					break;
				case 3:
					if (reponse.toLowerCase().equals("1")) {
						txt.append("Alvi = Avez-vous réalisé une chute récemment ? (oui/non)\n");
						level = 4;
					}
					else if (reponse.toLowerCase().equals("2")) {
						txt.append("Alvi = Ressentez-vous une sensation de chaleur ? (oui/non)\n");
						level = 5;
					}
					else if (reponse.toLowerCase().equals("3")) {
						txt.append("Alvi = Ressentez-vous une certaine fatigue ? (oui/non)\n");
						level = 7;
					}
					else if (reponse.toLowerCase().equals("non")) {
						txt.append("Alvi = Mince ! Recommençons notre test !\n");
						txt.append("Alvi= Pouvez vous réaliser ce mouvement ? (oui/non)\n");
						image.setIcon(new ImageIcon(GUI_home.class.getResource("/img/poignet.png")));
						image1.setVisible(false);
						image2.setVisible(false);
						image3.setVisible(false);
						image.setVisible(true);
						level = 1;
					}
					else{
						txt.append("Alvi = Mince ! Mauvaise saisie veuillez recommencer !\n");
						txt.append("Alvi = Observez-vous la présence d'un de ces Symptômes ?\n");
						txt.append("Alvi = Entrez : /1/ pour Difformité \n");
						txt.append("Alvi = Entrez : /2/ pour Bosse/Nodule \n");
						txt.append("Alvi = Entrez : /3/ pour Zone Rouge/Chaude \n");
						txt.append("Alvi = Entrez : 'non' pour présence d'aucuns de ces Symptômes\n");
						level = 3;
					}
					break;
				case 4:
					if (reponse.toLowerCase().equals("oui")) {
						txt.append("Alvi = Il s'agit certainement d'une fracture du poignet !\n");
						txt.append("Alvi = Je vous invite maintenant à vous rendre dans l'onglet diagnostique pour plus de détails concernant votre diagnostique !\n");
						textAreaA.append("Suite à vos reponse :\n\n- Présence d'un œdème.\n- Présence d'une difformité au niveau du poignet.\n- Chute récente.\n\n Nous en concluons qu'il s'agit certainement d'une fracture.\n");
						resultat.setText("Nous vous conseillons de vous rendre dans un hôpital au plus vite !");
						txt.append("Alvi= Pouvez vous réaliser ce mouvement ? (oui/non)\n");
						image.setIcon(new ImageIcon(GUI_home.class.getResource("/img/poignet.png")));
						image1.setVisible(false);
						image2.setVisible(false);
						image3.setVisible(false);
						image.setVisible(true);
						level = 1;
					} else if (reponse.toLowerCase().equals("non")) {
						txt.append("Alvi = Mince ! Recommencons notre test ! \n");
						txt.append("Alvi= Pouvez vous réaliser ce mouvement ?\n");
						image.setIcon(new ImageIcon(GUI_home.class.getResource("/img/poignet.png")));
						image1.setVisible(false);
						image2.setVisible(false);
						image3.setVisible(false);
						image.setVisible(true);
						level = 1;
					}
					else {
						txt.append("Alvi = Mince ! mauvaise saisie veuillez recommencer !\n");
						txt.append("Alvi = Avez-vous réalisé une chute récemment ? (oui/non)\n");
						level = 4;
					}
					break;
				case 5:
					if (reponse.toLowerCase().equals("oui")) {
						txt.append("Alvi = Il s'agit certainement d'une tendinite ! \n");
						txt.append("Alvi = Je vous invite maintenant à vous rendre dans l'onglet diagnostique pour plus de détails concernant votre diagnostique !\n");
						textAreaA.append("Suite à vos réponses :\n\n- Présence d'un œdème.\n- Présence d'une Bosse/Nodule au niveau du poignet.\n- Sensation de Chaleur.\n\n Nous en concluons qu'il s'agit certainement d'une Tendinite.\n");
						resultat.setText("Nous vous conseillons de contacter un Rhumatologue ou un medecin du sport !");
						txt.append("Alvi= Pouvez vous réaliser ce mouvement ? (oui/non)\n");
						image.setIcon(new ImageIcon(GUI_home.class.getResource("/img/poignet.png")));
						image1.setVisible(false);
						image2.setVisible(false);
						image3.setVisible(false);
						image.setVisible(true);
						level = 1;
					} else if (reponse.toLowerCase().equals("non")) {
						txt.append("Alvi = Êtes-vous amené à réaliser le même mouvement au cours d'une journée ? (sportif ou professionnel)\n");
						level = 6;
					}
					else {
						txt.append("Alvi = Mince ! mauvaise saisie veuillez recommencer !\n");
						txt.append("Alvi = Ressentez-vous une sensation de chaleur ? (oui/non)\n");
						level = 5;
					}
					break;
				case 6:
					if (reponse.toLowerCase().equals("oui")) {
						txt.append("Alvi = Il s'agit certainement d'une entorse !\n");
						txt.append("Alvi = Je vous invite maintenant à vous rendre dans l'onglet diagnostique pour plus de détails concernant votre diagnostique !\n");
						textAreaA.append("Suite à vos réponses :\n\n- Présence d'un œdème.\n- Présence d'une Bosse/Nodule au niveau du poignet.\n- Pas de sensation de Chaleur.\n- Actvité répetez au cours d'un meme journée.\n\n Nous en concluons qu'il s'agit certainement d'une entorse.\n");
						resultat.setText("Nous vous conseillons de contacter un Rhumatologue ou un medecin du sport !");
						txt.append("Alvi= Pouvez vous réaliser ce mouvement ? (oui/non)\n");
						image.setIcon(new ImageIcon(GUI_home.class.getResource("/img/poignet.png")));
						image1.setVisible(false);
						image2.setVisible(false);
						image3.setVisible(false);
						image.setVisible(true);
						level = 1;
					} else if (reponse.toLowerCase().equals("non")) {
						txt.append("Alvi = Mince ! Recommencons notre test !\n");
						txt.append("Alvi= Pouvez vous réaliser ce mouvement ? (oui/non)\n");
						image.setIcon(new ImageIcon(GUI_home.class.getResource("/img/poignet.png")));
						image1.setVisible(false);
						image2.setVisible(false);
						image3.setVisible(false);
						image.setVisible(true);
						level = 1;
					}
					else {
						txt.append("Alvi = Mince ! mauvaise saisie veuillez recommencer !\n");
						txt.append("Alvi = Êtes-vous amené à réaliser le même mouvement au cours d'une journée ? (sportif ou professionnel) (oui/non)\n");
						level = 6;
					}
					break;
				case 7:
					if (reponse.toLowerCase().equals("oui")) {
						txt.append("Alvi = Il s'agit certainement d'une polyarthrite ! \n");
						txt.append("Alvi = Je vous invite maintenant à vous rendre dans l'onglet diagnostique pour plus de détails concernant votre diagnostique !\n");
						textAreaA.append("Suite à vos réponses :\n\n- Présence d'un œdème.\n\\n- Présence d'une Zone Rouge/Chaude au niveau du poignet.\n- Présence d'une certaine Fatigue.\n\n Nous en concluons qu'il s'agit certainement d'une polyarthrite.\n");
						resultat.setText("Nous vous conseillons de contacter un Rhumatologue !");
						txt.append("Alvi= Pouvez vous réaliser ce mouvement ? (oui/non)\n");
						image.setIcon(new ImageIcon(GUI_home.class.getResource("/img/poignet.png")));
						image1.setVisible(false);
						image2.setVisible(false);
						image3.setVisible(false);
						image.setVisible(true);
						level = 1;
					} else if (reponse.toLowerCase().equals("non")) {
						txt.append("Alvi = Il s'agit certainement d'une tendinite ! \n");
						txt.append("Alvi = Je vous invite maintenant à vous rendre dans l'onglet diagnostique pour plus de détails concernant votre diagnostique !\n");
						textAreaA.append("Suite à vos réponses :\n\n- Présence d'un œdème.\n- Présence d'une Bosse/Nodule au niveau du poignet.\n- Sensation de Chaleur.\n\n Nous en concluons qu'il s'agit certainement d'une Tendinite.\n");
						resultat.setText("Nous vous conseillons de contacter un Rhumatologue ou un medecin du sport !");
						txt.append("Alvi= Pouvez vous réaliser ce mouvement ? (oui/non)\n");
						image.setIcon(new ImageIcon(GUI_home.class.getResource("/img/poignet.png")));
						image1.setVisible(false);
						image2.setVisible(false);
						image3.setVisible(false);
						image.setVisible(true);
						level = 1;
					}
					else {
						txt.append("Alvi = Mince ! mauvaise saisie veuillez recommencer !\n");
						txt.append("Alvi = Ressentez-vous une certaine fatigue ? (oui/non)\n");
					}
					break;
				case 8:
					if (reponse.toLowerCase().equals("oui")) {
						txt.append("Alvi = Votre âge est-il supérieur à 50 ans ? (oui/non)\n");
						level = 9;
					} else if (reponse.toLowerCase().equals("non")) {
						txt.append("Alvi = Avez-vous du mal à saisir des objets ? (oui/non)\n");
						level = 11;
					}
					else {
						txt.append("Alvi = Mince ! Mauvaise saisie veuillez recommencer !\n");
						txt.append("Alvi = Ressentez-vous des craquements ? (oui/non)\n");
						level = 8;
					}
					break;
				case 9:
					if (reponse.toLowerCase().equals("oui")) {
						txt.append("Alvi = Il s'agit certainement d'arthrose ! \n");
						txt.append("Alvi = Je vous invite maintenant à vous rendre dans l'onglet diagnostique pour plus de détails concernant votre diagnostique !\n");
						textAreaA.append("Suite à vos réponses :\n\n- Présence de craquement.\n- Age superieur a 50 ans .\n\n Nous en concluons qu'il s'agit certainement d'arthrose.\n");
						resultat.setText("Nous vous conseillons de contacter votre medecin géneraliste ou un Rhumatologue !");
						txt.append("Alvi= Pouvez vous réaliser ce mouvement ? (oui/non)\n");
						image.setIcon(new ImageIcon(GUI_home.class.getResource("/img/poignet.png")));
						image1.setVisible(false);
						image2.setVisible(false);
						image3.setVisible(false);
						image.setVisible(true);
						level = 1;
						
					} else if (reponse.toLowerCase().equals("non")) {
						txt.append("Alvi = Avez-vous déjà eu des problèmes de poids ? (oui/non)\n");
						level = 10;
					}
					else {
						txt.append("Alvi = Mince ! Mauvaise saisie veuillez recommencer !\n");
						txt.append("Alvi = Votre âge est-il supérieur à 50 ans ? (oui/non)\n");
						level = 9;
					}
					break;
				case 10:
					if (reponse.toLowerCase().equals("oui")) {
						txt.append("Alvi = Il s'agit certainement d'arthrose ! \n");
						txt.append("Alvi = Je vous invite maintenant à vous rendre dans l'onglet diagnostique pour plus de détails concernant votre diagnostique !\n");
						textAreaA.append("Suite à vos réponses :\n\n- Présence de craquement.\n- Problème de poids.\n\n Nous en concluons qu'il s'agit certainement d'arthrose.\n");
						resultat.setText("Nous vous conseillons de contacter votre medecin géneraliste ou un Rhumatologue !");
						txt.append("Alvi= Pouvez vous réaliser ce mouvement ? (oui/non)\n");
						image.setIcon(new ImageIcon(GUI_home.class.getResource("/img/poignet.png")));
						image1.setVisible(false);
						image2.setVisible(false);
						image3.setVisible(false);
						image.setVisible(true);
						level = 1;
						
					} else if (reponse.toLowerCase().equals("non")) {
						txt.append("Alvi = Mince ! Recommençons notre test !\n");
						txt.append("Alvi= Pouvez vous réaliser ce mouvement ? (oui/non)\n");
						image.setIcon(new ImageIcon(GUI_home.class.getResource("/img/poignet.png")));
						image1.setVisible(false);
						image2.setVisible(false);
						image3.setVisible(false);
						image.setVisible(true);
						level = 1;
					}
					else {
						txt.append("Alvi = Mince ! Mauvaise saisie veuillez recommencer !\n");
						txt.append("Alvi = Avez-vous déjà eu des problèmes de poids ? (oui/non)\n");
						level = 10;
					}
					break;
				case 11:
					if (reponse.toLowerCase().equals("oui")) {
						txt.append("Alvi = il s'agit certainement du Syndrome du canal carpien !\n");
						txt.append("Alvi = Je vous invite maintenant à vous rendre dans l'onglet diagnostique pour plus de détails concernant votre diagnostique !\n");
						textAreaA.append("Suite à vos réponses :\n\n- Saisie des objets difficile.\n\n Nous en concluons qu'il s'agit certainement du Syndrome du canal carpien.\n");
						resultat.setText("Nous vous conseillons de contacter votre médecin généraliste ou un Rhumatologue !");
						txt.append("Alvi= Pouvez vous réaliser ce mouvement ? (oui/non)\n");
						image.setIcon(new ImageIcon(GUI_home.class.getResource("/img/poignet.png")));
						image1.setVisible(false);
						image2.setVisible(false);
						image3.setVisible(false);
						image.setVisible(true);
						level = 1;
					} else if (reponse.toLowerCase().equals("non")) {
						txt.append("Alvi = Mince ! Recommençons notre test !\n");
						txt.append("Alvi= Pouvez vous réaliser ce mouvement ? (oui/non)\n");
						image.setIcon(new ImageIcon(GUI_home.class.getResource("/img/poignet.png")));
						image1.setVisible(false);
						image2.setVisible(false);
						image3.setVisible(false);
						image.setVisible(true);
						level = 1;
					}
					else {
						txt.append("Alvi = Mince ! Mauvaise saisie veuillez recommencer !\n");
						txt.append("Alvi = Avez-vous du mal à saisir des objets ? (oui/non)\n");
						level = 11;
					}
					break;
				}
			}
		});

		fermer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Chatbot.this.dispose();
			}
		});

		Reduire.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setState(Chatbot.ICONIFIED);
			}
		});
	}
}

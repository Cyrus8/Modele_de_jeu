package jeu;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.*;
import javax.swing.border.LineBorder;

import devintAPI.FenetreAbstraite;
import devintAPI.Preferences;

import java.awt.*;
import java.awt.event.*;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import devintAPI.*;

import java.awt.GridLayout;

/** Cette classe est un test pour cr�er une nouvelle fen�tre
 * 
 */
public class FenetreTest extends FenetreAbstraite implements ActionListener{
   
	// le bouton pour la question
	// est une variable d'instance car il doit être accessible 
	// dans la méthode actionPerformed 
	private JButton bouton;
	
	public FenetreTest(String title) {
    	super(title);
    	this.setLayout(new GridLayout(2,2));
    }

    // un label
	// est une variable d'instance car il doit �tre accessible 
	// dans la m�thode changeColor, qui g�re les pr�rences
	private JTextArea lb1;
	private JTextArea lb2;
    
	// renvoie le fichier wave contenant le message d'accueil
	protected  String wavAccueil() {
		return "../ressources/sons/accueilSimple1.wav";
	}
	
	// renvoie le fichier wave contenant la r�gle du jeu
	protected  String wavRegleJeu() {
		return "../ressources/sons/aideF1.wav";
	}
	
	// renvoie le fichier wave contenant l'aide du jeu
	protected  String wavAide() {
		return "../ressources/sons/aide.wav";
	}

    public void init() {
    	
    	setLayout(new BorderLayout());
    	
    	
    	String text = "'L'Aurore s'allume' - Victor Hugo\n\n";
    	text+= "L'aurore s'allume ;\n";
    	text+="L'ombre �paisse fuit ;\n";
    	text+="Le r�ve et la brume \n";
    	text += "Vont o� va la nuit ;\n";
    	text+= "Paupi�res et roses\n";
    	text+="S'ouvrent demi-closes ;\n";
    	text+="Du r�veil des choses\n";
    	text += "On entend le bruit.\n";
     	lb1 = new JTextArea (text); 
    	lb1.setLineWrap(true);
    	lb1.setEditable(false);
    	lb1.setFont(new Font("Georgia",1,30));
    	// on récupère les couleurs de base dans la classe Preferences 
		Preferences pref = Preferences.getData();
		Color foregroundColor = pref.getCurrentForegroundColor();
		Color backgroundColor = pref.getCurrentBackgroundColor();
		lb1.setBackground(backgroundColor);
		lb1.setForeground(foregroundColor);
    	
    	// on place le premier composant en haut
    	this.getContentPane().add(lb1);
    	
    	
	// bouton pour poser une question
    	bouton = new JButton();
    	bouton.setText("Cliquez sur ce bouton");
    	bouton.setBackground(new Color(50,50,255));
    	bouton.setBorder(new LineBorder(Color.BLACK,10));
     	bouton.setFont(new Font("Georgia",1,40));
     	// c'est l'objet Jeu lui-même qui réagit au clic souris
       	bouton.addActionListener(this);
    	// on met le bouton à droite
     	this.getContentPane().add(bouton);
     	
     // insertion image	
     
     	ImageIcon icon = new ImageIcon("../ressources/images/test.jpg");
		String texte = "Test image";
		JLabel jl2 = new JLabel(texte,icon,JLabel.CENTER);
		// fond jaune
		jl2.setBackground(Color.YELLOW);
		//composant opaque pour voir le fond bleu
		jl2.setOpaque(true); 
    	this.getContentPane().add(jl2);
    	
    	
    	String text1 = "'L'Aurore s'allume' - Victor Hugo\n\n";
    	text1+= "Tout chante et murmure,\n";
    	text1+="Tout parle � la fois,\n";
    	text1+="Fum�e et verdure,\n";
    	text1 += "Les nids et les toits ;\n";
    	text1+= "Le vent parle aux ch�nes,\n";
    	text1+="L'eau parle aux fontaines ;\n";
    	text1+="Toutes les haleines\n";
    	text1 += "Deviennent des voix !\n";
     	lb2 = new JTextArea (text1); 
    	lb2.setLineWrap(true);
    	lb2.setEditable(false);
    	lb2.setFont(new Font("Georgia",1,30));
    	
		
    	this.getContentPane().add(lb2);
}

// lire la question si clic sur le bouton 
public void actionPerformed(ActionEvent ae){
   	// toujours stopper la voix avant de parler
	voix.stop();
	// on récupère la source de l'évènement
 	Object source = ae.getSource();
 	// si c'est le bouton "question" on lit la question
 	// le contenu des questions est variable donc on les lit avec SI_VOX
	if (source.equals(bouton)) {
		String text = "Bonjour � tous";
		voix.playText(text);
	}	
	// on redonne le focus au JFrame principal 
	// (après un clic, le focus est sur le bouton)
	this.requestFocus();
    }
    
	/**
	 * Pour modifier les couleurs de fond et de premier plan
	 * Cette fonction est appel�e par la fonction "changeColor" de la classe "devintAPI.Preferences"
	 * A�chaque fois que l'on presse F3 
	 * 
	 * ici on d�cide que le changement des couleurs s'applique sur le label lbl1
	 **/
	public  void changeColor() {
    	// on r�cup�re les couleurs de base dans la classe Preferences 
		Preferences pref = Preferences.getData();
		lb1.setBackground(pref.getCurrentBackgroundColor());
		lb1.setForeground(pref.getCurrentForegroundColor());
		lb2.setBackground(pref.getCurrentBackgroundColor());
		lb2.setForeground(pref.getCurrentForegroundColor());
	}
	
	/**
	 * Pour modifier la police des textes � chaque fois que l'on presse F4 
	 */
	public void changeSize(){
		Font f = Preferences.getData().getCurrentFont();
		lb1.setFont(f);
		lb2.setFont(f);
	}

   
}

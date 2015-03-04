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

/** Cette classe est un test pour créer une nouvelle fenêtre
 * 
 */
public class FenetreTest extends FenetreAbstraite implements ActionListener{
   
	// le bouton pour la question
	// est une variable d'instance car il doit Ãªtre accessible 
	// dans la mÃ©thode actionPerformed 
	private JButton bouton;
	
	public FenetreTest(String title) {
    	super(title);
    	this.setLayout(new GridLayout(2,2));
    }

    // un label
	// est une variable d'instance car il doit être accessible 
	// dans la méthode changeColor, qui gère les prérences
	private JTextArea lb1;
	private JTextArea lb2;
    
	// renvoie le fichier wave contenant le message d'accueil
	protected  String wavAccueil() {
		return "../ressources/sons/accueilSimple1.wav";
	}
	
	// renvoie le fichier wave contenant la règle du jeu
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
    	text+="L'ombre épaisse fuit ;\n";
    	text+="Le rêve et la brume \n";
    	text += "Vont où va la nuit ;\n";
    	text+= "Paupières et roses\n";
    	text+="S'ouvrent demi-closes ;\n";
    	text+="Du réveil des choses\n";
    	text += "On entend le bruit.\n";
     	lb1 = new JTextArea (text); 
    	lb1.setLineWrap(true);
    	lb1.setEditable(false);
    	lb1.setFont(new Font("Georgia",1,30));
    	// on rÃ©cupÃ¨re les couleurs de base dans la classe Preferences 
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
     	// c'est l'objet Jeu lui-mÃªme qui rÃ©agit au clic souris
       	bouton.addActionListener(this);
    	// on met le bouton Ã  droite
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
    	text1+="Tout parle à la fois,\n";
    	text1+="Fumée et verdure,\n";
    	text1 += "Les nids et les toits ;\n";
    	text1+= "Le vent parle aux chênes,\n";
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
	// on rÃ©cupÃ¨re la source de l'Ã©vÃ¨nement
 	Object source = ae.getSource();
 	// si c'est le bouton "question" on lit la question
 	// le contenu des questions est variable donc on les lit avec SI_VOX
	if (source.equals(bouton)) {
		String text = "Bonjour à tous";
		voix.playText(text);
	}	
	// on redonne le focus au JFrame principal 
	// (aprÃ¨s un clic, le focus est sur le bouton)
	this.requestFocus();
    }
    
	/**
	 * Pour modifier les couleurs de fond et de premier plan
	 * Cette fonction est appelée par la fonction "changeColor" de la classe "devintAPI.Preferences"
	 * A chaque fois que l'on presse F3 
	 * 
	 * ici on décide que le changement des couleurs s'applique sur le label lbl1
	 **/
	public  void changeColor() {
    	// on récupère les couleurs de base dans la classe Preferences 
		Preferences pref = Preferences.getData();
		lb1.setBackground(pref.getCurrentBackgroundColor());
		lb1.setForeground(pref.getCurrentForegroundColor());
		lb2.setBackground(pref.getCurrentBackgroundColor());
		lb2.setForeground(pref.getCurrentForegroundColor());
	}
	
	/**
	 * Pour modifier la police des textes à chaque fois que l'on presse F4 
	 */
	public void changeSize(){
		Font f = Preferences.getData().getCurrentFont();
		lb1.setFont(f);
		lb2.setFont(f);
	}

   
}

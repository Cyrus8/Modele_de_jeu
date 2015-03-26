package jeu;


import javax.swing.*;
import javax.swing.border.LineBorder;

import portalQuest.Frame;
import portalQuest.TimerThread;
import devintAPI.FenetreAbstraite;
import devintAPI.Preferences;
import portalQuest.Panel;


import java.awt.*;
import java.awt.event.*;

public class Jeu extends FenetreAbstraite implements ActionListener{

	
	// un label
	// est une variable d'instance car il doit être accessible 
	// dans la méthode changeColor, qui gère les préférences
	private JTextArea lb1;
	
	// appel au constructeur de la classe m�re
    public Jeu(String title) {
    	super(title);
     }
    
	// renvoie le fichier wave contenant le message d'accueil
	protected  String wavAccueil() {
		return "../ressources/sons/accueil.wav";
	}
	
	// renvoie le fichier wave contenant la r�gle du jeu
	protected  String wavRegleJeu() {
		return "../ressources/sons/aideF1.wav";
	}
	
	// renvoie le fichier wave contenant la r�gle du jeu
	protected  String wavAide() {
		return "../ressources/sons/aide.wav";
	}

    // d�finition de la m�thode abstraite "init()"
    // initialise le frame 
	
    protected void init() {
        TimerThread timer = new TimerThread();
        timer.start();
        Frame frame = new Frame();
    	
    	
   }


	/**
	 * Pour modifier les couleurs de fond et de premier plan de la fenêtre
	 * Cette fonction est appelée par la fonction "changeColor" de la classe "Preferences"
	 * à chaque fois que l'on presse F3 
	 * 
	 * on change la couleur du texte principal
	 **/
	public  void changeColor() {
    	// on récupère les couleurs de base dans la classe Preferences 
		Preferences pref = Preferences.getData();
		lb1.setBackground(pref.getCurrentBackgroundColor());
		lb1.setForeground(pref.getCurrentForegroundColor());
	}
	
	
	/**
	 * Pour modifier la police des textes à chaque fois que l'on presse F4 
	 */
	public void changeSize(){
		Font f = Preferences.getData().getCurrentFont();
		lb1.setFont(f);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}



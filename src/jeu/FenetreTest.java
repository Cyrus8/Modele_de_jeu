package jeu;


import java.awt.Color;
import java.awt.Font;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import devintAPI.*;

/** Cette classe est un test pour cr�er une nouvelle fen�tre
 * 
 */
public class FenetreTest extends FenetreAbstraite {
   
	
	public FenetreTest(String title) {
    	super(title);
    }

    // un label
	// est une variable d'instance car il doit �tre accessible 
	// dans la m�thode changeColor, qui g�re les pr�rences
	private JTextArea lb1;
    
	// renvoie le fichier wave contenant le message d'accueil
	protected  String wavAccueil() {
		return "../ressources/sons/accueilSimple.wav";
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
    	// met la police par d�faut de DeViNT
    	lb1.setFont(Preferences.getData().getCurrentFont());
    	this.add(lb1);
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
	}
	
	/**
	 * Pour modifier la police des textes � chaque fois que l'on presse F4 
	 */
	public void changeSize(){
		Font f = Preferences.getData().getCurrentFont();
		lb1.setFont(f);
	}

    
}

/*  Classe de menu de lancement de l'exemple de jeu.
 *  Cette classe hÃ©rite de la classe abstraite MenuAbstrait en dÃ©finissant les mÃ©thodes :
 *     - nomOptions qui renvoie la liste des options possibles pour le menu 
 *     - lancerOption qui associe une action Ã  chaque option du menu
 *     - wavAccueil() qui renvoie le nom du fichier wav lu lors de l'accueil dans le menu
 *     - wavAide() qui renvoie le nom du fichier wav lu lors de l'activation de la touche F1
 */

package jeu; 

import devintAPI.MenuAbstrait;

public class MenuJeu extends MenuAbstrait {

	/** constructeur
	 * @param title : le nom du jeu 
	 */
	public MenuJeu(String title) {
		super(title);
	}

	/** renvoie le nom des options du menu
     * vous pouvez dÃ©finir autant d'options que vous voulez
     **/
	protected String[] nomOptions() {
		String[] noms = {"Fenêtre simple","Jeu","Gestion du son",
				"Fichier des scores","Gestion d'image","Fenêtre Poème", "Quitter"};
		return noms;
	}

	/** lance l'action associÃ©e au bouton
	 * la numÃ©rotation est celle du tableau renvoyÃ© par nomOption
	 */
	protected void lancerOption(int i) {
		switch (i){  
		case 0 : new FenetreSimple("Fenêtre simple");break;
		case 1 : new Jeu(nomJeu);break;
		case 2 : new GestionSon("Gestion du son");break;
		case 3 : new FichierScore("Ecriture dans un fichier");break;
		case 4 : new GestionImage("Exemple d'image");break;
		case 5 : new FenetreTest("Fenêtre poème");break;
		case 6 : System.exit(0);
		default: System.err.println("action non définie");
		}
	} 

	// renvoie le fichier wave contenant le message d'accueil
	// ces fichiers doivent Ãªtre placÃ©s dans ressources/sons/
	protected  String wavAccueil() {
		return "../ressources/sons/accueil.wav";
	}

	// renvoie le fichier wave contenant la rÃ¨gle du jeu
	protected  String wavRegleJeu() {
		return "../ressources/sons/accueil.wav";
	}
	
}

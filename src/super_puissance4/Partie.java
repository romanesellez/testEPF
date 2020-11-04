/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package super_puissance4;
import java.util.Scanner;

/**
 *
 * @author rsellez
 */
public class Partie {
    Joueur [] ListeJoueurs = new Joueur [2];
    Joueur joueurCourant;
    Grille GrilleJeu= new Grille(); 

public void initialiserPartie(){
 GrilleJeu.viderGrille();//on vide la grille grâce méthode créée dans Grille
 Scanner saisieUtilisateur = new Scanner(System.in);
 System.out.println("Veuillez saisir le nombre de trou noir :");
 int nb = saisieUtilisateur.nextInt();//ce sera le nombre de trou noir dans grille
 int compteur=0;//le compteur permet de mettre le bon nombre de trous noirs
 while (compteur!=nb){//tant que le compteur n'a pas atteint le chiffre souhaité
 System.out.println("Veuillez saisir un entier :");//on demande deux nombres
 //qui seront l'emplacement ligne et colonne des trou noir
 int i = saisieUtilisateur.nextInt();//ligne trou noir
 System.out.println("Veuillez saisir un entier :");
 int j = saisieUtilisateur.nextInt();//colonne trou noir
 GrilleJeu.placerTrouNoir(i,j);//on place le trou noir aux coordonnées données
 compteur=compteur++;}//le compteur s'incrémente d'un trou noir
 
}
public void debuterPartie(){
 while (GrilleJeu.etreRemplie()==false || GrilleJeu.etreGagnantePourJoueur(joueurCourant)==false){
 //tant que la grille n'est pas complètement remplie ou alors qu'un joueur a gagné
 GrilleJeu.afficherGrilleSurConsole();//on affiche la grille
 Scanner saisieUtilisateur = new Scanner(System.in);
 System.out.println("Veuillez saisir le numéro de la colonne entre 0 et 6:");
 int c = saisieUtilisateur.nextInt();//on demande à l'utilisateur de choisir la
 //colonne où il veut placer son jeton
 GrilleJeu.ajouterJetonDansColonne(jeton, c);//et on place son jeton dedans
 GrilleJeu.afficherGrilleSurConsole();//on réaffiche la grille 
 
         
}}

public void attribuerCouleursAuxJoueurs (){
 Scanner saisieUtilisateur = new Scanner(System.in);
 System.out.println("jaune ou rouge?");//on demande au joueur de saisir la couleur
 String couleur = saisieUtilisateur.nextLine();
 ListeJoueurs[0].affecterCouleur(couleur);//cette couleur est affectée au joueur 1
 if (couleur=="rouge"){//si la première couleur choisie est du rouge
     String couleur2="jaune";//alors l'autre est forcément du jaune
     ListeJoueurs[1].affecterCouleur(couleur2);}//donc le joueur 2 sera jaune
 else{//sinon c'est que c'était l'inverse le joueur 1 est jaune
     String couleur2="rouge";
     ListeJoueurs[1].affecterCouleur(couleur2);}//et donc le joueur 2 est rouge
 }
}


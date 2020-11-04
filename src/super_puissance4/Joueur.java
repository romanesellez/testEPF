/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package super_puissance4;

/**
 *
 * @author rsellez
 */
public class Joueur {
    String Nom;
    String Couleur;
    int nombreDesintegrateurs;
    int nombreJetons_restants;
    Jeton [] Listejetons = new Jeton [21];
    public Joueur(String Nomjoueur){//constructeur
       Nom = Nomjoueur;}


public void affecterCouleur (String Couleurjoueur){
    Couleur=Couleurjoueur;//on donne au joueur la couleur passée en paramètre
}
public boolean ajouterJeton (Jeton jeton){
 boolean ans=false;
 for (int i=0;i<21;i++)//boucle for pour parcourir la liste grace à i 
 if (Listejetons[i]==null) {// dès qu'on rencontre une case vide
     Listejetons[i]=jeton;//on ajoute le jeton dedans
     ans =true;//la valeur renvoyée sera donc true
     nombreJetons_restants=nombreJetons_restants++;//on incrémente le nb de jetons
     break;}//on sort de la boucle for
return ans;//on renvoie true
}
public void obtenirDesintegrateur (){
    nombreDesintegrateurs=nombreDesintegrateurs++;//on incrémente le nb
}
public boolean utiliserDesintegrateur (){
    if (nombreDesintegrateurs!=0){//si le joueur possède un désintégrateur
    nombreDesintegrateurs=nombreDesintegrateurs--;//alors il l'utilise donc il
    //en perd un 
    return true;}//on renvoie true puisque l'utilisation s'est bien passée
    else {
     return false;}//sinon on renvoie false 
}
}
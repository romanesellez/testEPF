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
public class Grille {
    Cellule [][] Cellules = new Cellule [6][7];
    
Grille(){
  for (int i=0;i<6;i++){
     for (int j=0;j<7;j++){
         Cellules[i][j]=new Cellule();
        }
    }
}
public boolean ajouterJetonDansColonne (Jeton jeton,int colonne){
 boolean ans = false;
 int i=5;
 while (i>=0){//tant qu'on n'a pas vérifié toute la colonne on continue
     if (Cellules[i][colonne].jetonCourant==null){//si on trouve une cellule vide
         Cellules[i][colonne].jetonCourant=jeton;//on met le jeton dedans
         ans=true;//la valeur renvoyée sera donc true
         break;}//on sort de la boucle while
     if (Cellules[i][colonne].jetonCourant!=null && i==0){//si on est arrivé en
         //haut de la colonne et que toutes les cases étaient pleines 
         ans = false;}//alors on renvoie faux la colonne est donc pleine 
     i=i--;}//i parcourt la colonne en passant d'une ligne à l'autre de bas en haut
  return ans;
}
public boolean etreRemplie(){
 boolean ans = false;
 int i=0;
 int j=0;
 while (i<6 && j<7){//tant quon n'aura pas parcouru toute la grille 
     if (Cellules[i][j].jetonCourant==null){//dès qu'une cellule sera vide de jeton
         ans=false;//alors la grille ne sera pas pleine et sera renvoyé faux
         break;}//on quitte la boucle while
     if (i==5 && j==6 && Cellules[i][j].jetonCourant!=null){//si on a parcouru
         //toute la grille et qu'elle est pleine de jetons
         ans= true;//alors on renverra vrai 
         break;}//on quitte la boucle
     if (i==5){//dès que i atteindra la dernière ligne d'une colonne
         j=j++;//on change de colonne
         i=-1;}//i prend la valeur -1 puisqu'il est incrémenté juste après et 
     //donc il reprendra sa valeur pour la première ligne soit 0
     i=i++;}//on incrémente i
 return ans;
}
public void viderGrille(){
 int i=0;//i va parcourir les lignes 
 int j=0;//j va parcourir les colonnes
 while (i<6 && j<7){//tant que l'on n'a pas parcouru toute la grille 
     Cellules[i][j].jetonCourant=null;//on vide les cases en donnant la valeur 
     //null au jeton présent dans les cellules
     if (i==5){//ici si on se trouve en toute dernière ligne de la grille
         i=-1;//on revient en haut de la grille et on met i=-1 même si la première 
         //ligne a comme indice 0 parce que le i est incrémenté juste après
         j=j++;}//on passe à une autre colonne
     i=i++;}// i est incrémenté
}
public void afficherGrilleSurConsole(){
 for (int i=0;i<6;i++){//i parcourt les lignes de la grille
   for (int j=0;j<7;j++){//j parcourt colonnes
     if (Cellules [i][j].jetonCourant==null){//si pas de jeton
         System.out.print("N");}//on affiche N pour null
     if (Cellules [i][j].jetonCourant!=null){//si jeton
         if (lireCouleurDuJeton(i,j)=="rouge"){//on regarde sa couleur
             System.out.print("R");}//si rouge alors R
         else{
             System.out.println("J");}}//sinon le jeton est jaune
     if (Cellules [i][j].presenceTrouNoir()==true){//si trou noir dans cellule
         System.out.print("TN");}//on écrit TN
     if (Cellules [i][j].presenceDesintegrateur()==true){//si désintégrateur
         System.out.print("D");}}}//on écrit D
}
public boolean celluleOccupee(int ligne,int colonne){
 boolean ans = false;
 if (Cellules[ligne][colonne].jetonCourant!=null)//on vérifie qu'il y a un jeton 
     //dans la cellule
     ans = true;//alors on donne la valeur true à la variable renvoyée
 return ans;//on retourne cette variable
}
public String lireCouleurDuJeton(int ligne,int colonne){
 String Couleur=null; //couleur du jeton qui sera renvoyé
 if (Cellules[ligne][colonne].jetonCourant!=null)// on vérifie qu'il a un jeton
     //dans la cellule
     Couleur=Cellules[ligne][colonne].lireCouleurDuJeton();//on utilise la 
     //méthode créée dans la classe cellule
return Couleur;}// couleur renvoyée
public boolean etreGagnantePourJoueur(Joueur joueur){
 boolean ans=false;
 String CouleurJ=joueur.Couleur;
 for (int i=0;i<6;i++){//si gagnante sur ligne
    for (int j=0;j<4;j++){
     if (Cellules[i][j].lireCouleurDuJeton()==CouleurJ && Cellules[i][j+1].lireCouleurDuJeton()==CouleurJ && Cellules[i][j+2].lireCouleurDuJeton()==CouleurJ && Cellules[i][j+3].lireCouleurDuJeton()==CouleurJ){
         ans=true;}}}
 for (int i=5;i>2;i--){//si gagnante sur colonne
    for (int j=0;j<7;j++){
     if (Cellules[i][j].lireCouleurDuJeton()==CouleurJ && Cellules[i-1][j].lireCouleurDuJeton()==CouleurJ && Cellules[i-2][j].lireCouleurDuJeton()==CouleurJ && Cellules[i-3][j].lireCouleurDuJeton()==CouleurJ){
         ans =true;}}}
 for (int i=5;i>2;i--){//si gagnant sur diago montante
    for (int j=0;j<4;j++){
     if (Cellules[i][j].lireCouleurDuJeton()==CouleurJ && Cellules[i-1][j+1].lireCouleurDuJeton()==CouleurJ && Cellules[i-2][j+2].lireCouleurDuJeton()==CouleurJ && Cellules[i-3][j+3].lireCouleurDuJeton()==CouleurJ){
         ans=true;}}}
 for (int i=0;i<3;i++){//si gagnant sur diago descendante
    for (int j=0;j<4;j++){
     if (Cellules[i][j].lireCouleurDuJeton()==CouleurJ && Cellules[i+1][j+1].lireCouleurDuJeton()==CouleurJ && Cellules[i+2][j+2].lireCouleurDuJeton()==CouleurJ && Cellules[i+3][j+3].lireCouleurDuJeton()==CouleurJ){
         ans=true;}}}
 return ans;
}
public void tasserGrille(int colonne){
 for (int i=5;i<0;i--){ //i va parcourir les lignes du bas vers le haut
     if (Cellules[i][colonne].jetonCourant==null && Cellules[i-1][colonne].jetonCourant!=null){
         //si j'ai rien dans la ligne i mais qu'au dessus il y a un jeton
     Cellules[i][colonne]=Cellules[i-1][colonne];}}   
}
public boolean colonneRemplie(int colonne){
 boolean ans=false; // valeur qui sera renvoyée
 for (int i=0;i<6;i++){ // i va parcourir les lignes
     if (Cellules[i][colonne].jetonCourant!=null){ //on regarde si les cellules
         //contiennent un jeton
         ans=true;} //alors on renvoie vrai
     else{
         ans=false; //sinon on renvoie faux
         break;}//dès qu'on a trouvé une cellule vide alors la colonne pas remplie
 }
 return ans;
}
public boolean placerDesintegrateur(int ligne,int colonne){
boolean ans = false;
 if (Cellules[ligne][colonne].presenceDesintegrateur()==false){// si pas de désinté
     //on utilise la méthode créée dans la classe cellule
     Cellules[ligne][colonne].placerDesintegrateur();//méthode créée dans cellule
     ans=true;}//l'ajout s'est bien passé on renverra vrai
 else{
     ans=false;}// il y avait déjà un désintégrateur
return ans;
}
public boolean placerTrouNoir (int ligne,int colonne){
 boolean ans = false;
 if (Cellules[ligne][colonne].presenceTrouNoir()==false){ //si pas de trou Noir
     // on utilise méthode créée dans cellule
     Cellules[ligne][colonne].placerTrouNoir();//on l'ajoute
     ans=true;}//ajout s'est bien passé on renvoie vrai
 else{
     ans=false;}//sinon faux
return ans;
}
public boolean supprimerJeton (int ligne,int colonne){
 boolean ans=false;
 if (Cellules[ligne][colonne].supprimerJeton()==true){//on utilise méthode créée
     //dans cellule pour supprimer le jeton
     ans=true;}//si on l'a bien supprimé alors on renvoie vrai
 else{
     ans=false;}//sinon on renvoie faux
return ans;
}
public Jeton recupererJeton (int ligne,int colonne){
 Jeton jeton;
 jeton=Cellules[ligne][colonne].recupererJeton();
 Cellules[ligne][colonne].jetonCourant=null;//ensuite on supprime le jeton
 tasserGrille(colonne);//on tasse la colonne
 return jeton;//on renvoie le jeton
}
}

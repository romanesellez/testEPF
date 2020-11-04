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
public class Cellule {
    Jeton jetonCourant;
    boolean trouNoir;
    boolean desintegrateur;
    public Cellule(boolean presencedetrouNoir,boolean presencededesintegrateur,Jeton jetonCourant){
        presencedetrouNoir=trouNoir;
        presencededesintegrateur=desintegrateur;
        jetonCourant=null;
}
public boolean affecterJeton (Jeton jeton){
    if (jetonCourant==null){//si il n'y a pas de jeton dans la cellule
       jetonCourant=jeton;//on ajoute le jeton en paramètre
       return true;}//on renvoie true
    else{
        return false;}//il y avait déjà un jeton on renvoie false
    }
public Jeton recupererJeton(){
 Jeton jeton=null;//on initialise le jeton qui sera renvoyé
 jeton=jetonCourant;
 return jeton;
}
public boolean supprimerJeton(){
 if (jetonCourant!=null){//on vérifie qu'il y a un jeton 
     jetonCourant=null;//on le supprime
     return true;}//tout s'est bien passé on renvoie true
 else {
     return false;}//il n'y avait pas de jeton on renvoie false
 }
public boolean placerTrouNoir(){
 if (trouNoir==false){//si pas de trou noir
    trouNoir=true;//alors on en met un 
    return true;}//on renvoie vrai tout s'est bien passé
 else{
     return false;}//il y a déjà un trou noir on renvoie faux
}
public boolean placerDesintegrateur(){
 if (desintegrateur==false){
     desintegrateur=true;//il manque d'enlever un désinté au joueur
     return true;}
 else{
     return false;}
}
public boolean presenceTrouNoir(){
 if (trouNoir==true){//si il y a un trou noir
     return true;}//on renvoie true
 else{
     return false;}//sinon il n'y en a pas on renvoie faux
}
public boolean presenceDesintegrateur(){
 if (desintegrateur==true){//si il y a un desintegrateur
     return true;}//on renvoie true
 else {
     return false;}//sinon il n'y en a pas on renvoie faux
}

public String lireCouleurDuJeton (){
 if (jetonCourant.Couleur=="rouge"){//si le jeton est rouge 
     return "rouge";}//on retourne rouge
 else{
     return "jaune";}}//sinon c'est qu'il est jaune et on retourne jaune

public boolean recupererDesintegrateur (){
 if (desintegrateur==true){
     desintegrateur=false;//il manque l'incrémentation d'un désinté au nb désint
     return true;}
 else{
     return false;}
}
public boolean activerTrouNoir (){
 if (trouNoir==true){//si il y a un trou noir 
     jetonCourant=null;//le jeton disparait
     trouNoir=false;//le trou noir disparait aussi
     return true;}// tout s'est bien déroulé on renvoie true
 else{
     return false;}//il n'y a pas de trou noir
}}
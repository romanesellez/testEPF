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
public class Jeton {
    String Couleur;
    public Jeton (String uneCouleur){ //constructeur
       Couleur=uneCouleur;
} 

public String lireCouleur(){
 if (Couleur=="rouge") {//si la couleur du jeton est rouge
     return("rouge");}//alors on renvoie rouge
 else {
     return("jaune");} //sinon on renvoie jaune  
}}

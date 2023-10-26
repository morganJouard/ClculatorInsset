/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.insset.server;



public class divisionEuclidienneServiceImpl {
    public modulo divisionEuclidienne(int dividende, int diviseur) {
        modulo modulo = new modulo();
        modulo.resultat = dividende / diviseur;
        modulo.reste = dividende % diviseur;
        return modulo;
    }
}

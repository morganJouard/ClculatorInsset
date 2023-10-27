/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.insset.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import org.insset.client.service.DecimalService;



public class DecimalServiceImpl extends RemoteServiceServlet implements DecimalService{
    public int[] divisionEuclidienne(int dividende, int diviseur) {
        int[] valeurs = new int[2];
        valeurs[0] = dividende / diviseur;
        valeurs[1] = dividende % diviseur;
        return valeurs;
    }
    
    public double getMontantDepart(double nb, double pourcentage){
        if (pourcentage < 0 || pourcentage > 100) {
            throw new IllegalArgumentException("Le pourcentage de réduction doit être compris entre 0 et 100");
        }
        
        double montantDeDepart = nb / (1 - (pourcentage / 100));
        
        return montantDeDepart;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.insset.server;

/**
 *
 * @author insset
 */
public class getMontantDepartServiceImpl {
    double getMontantDepart(double nb, double pourcentage){
        if (pourcentage < 0 || pourcentage > 100) {
            throw new IllegalArgumentException("Le pourcentage de réduction doit être compris entre 0 et 100");
        }
        
        double montantDeDepart = nb / (1 - (pourcentage / 100));
        
        return montantDeDepart;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.insset.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import org.insset.client.service.SoldeConverterService;

/**
 *
 * @author talend
 */
@SuppressWarnings("serial")
public class SoldeConverterServiceImpl extends RemoteServiceServlet implements
        SoldeConverterService {
    
    public boolean isNombreCorrect(float nbr) {
        if (nbr < 0 || nbr > 2000) 
            throw new IllegalArgumentException("Montant entre 0 et 2000 svp !");
        
        return true;
    }

    @Override
    public float CalculMontantFinal(float montantDepart, float pourcentage) throws IllegalArgumentException {
        if(isNombreCorrect(montantDepart))
            return montantDepart * (1 - (pourcentage / 100));
        return -1;
    }

    @Override
    public float CalculMontantDepart(float montantFinal, float pourcentage) throws IllegalArgumentException {
        if(isNombreCorrect(montantFinal))
            return montantFinal / (1 - (pourcentage / 100));
        return -1;
    }

    @Override
    public float CalculRemise(float montantDepart, float montantFinal) throws IllegalArgumentException {
        return montantFinal - montantDepart;
    }

}

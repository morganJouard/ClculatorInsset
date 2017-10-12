/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.insset.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import org.insset.client.service.SoldeConverterService;
import org.insset.shared.FieldVerifier;

/**
 *
 * @author talend
 */
@SuppressWarnings("serial")
public class SoldeConverterServiceImpl extends RemoteServiceServlet implements
        SoldeConverterService {

    @Override
    public float CalculMontantFinal(float montantDepart, float pourcentage) throws IllegalArgumentException {
        if(FieldVerifier.isNombreDecimalCorrect(montantDepart))
            return montantDepart * (1 - (pourcentage / 100));
        return -1;
    }

    @Override
    public float CalculMontantDepart(float montantFinal, float pourcentage) throws IllegalArgumentException {
        if(FieldVerifier.isNombreDecimalCorrect(montantFinal))
            return montantFinal / (1 - (pourcentage / 100));
        return -1;
    }

    @Override
    public float CalculRemise(float montantDepart, float montantFinal) throws IllegalArgumentException {
        return montantFinal - montantDepart;
    }

}

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

    @Override
    public float CalculMontantFinal(float montantDepart, int pourcentage) throws IllegalArgumentException {
        return montantDepart * (pourcentage / 100);
    }

    @Override
    public float CalculMontantDepart(float montantFinal, int pourcentage) throws IllegalArgumentException {
        return montantFinal * (1 + (pourcentage / 100));
    }

    @Override
    public float CalculRemise(float montantDepart, float montantFinal) throws IllegalArgumentException {
        return montantFinal - montantDepart;
    }

}

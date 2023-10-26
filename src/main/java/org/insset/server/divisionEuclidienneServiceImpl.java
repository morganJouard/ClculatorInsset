/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.insset.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import org.insset.client.service.divisionEuclidienneService;



public class divisionEuclidienneServiceImpl extends RemoteServiceServlet implements divisionEuclidienneService{
    public int[] divisionEuclidienne(int dividende, int diviseur) {
        int[] valeurs = new int[2];
        valeurs[0] = dividende / diviseur;
        valeurs[1] = dividende % diviseur;
        return valeurs;
    }
}

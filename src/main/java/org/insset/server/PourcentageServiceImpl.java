/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.insset.server;


import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import org.insset.client.service.PourcentageService;
import org.insset.client.service.PourcentageService;
/**
 *
 * @author insset
 */
@SuppressWarnings("serial")
public class PourcentageServiceImpl extends RemoteServiceServlet implements 
        PourcentageService {
    
        public String PourcentageSolde(String input) throws IllegalArgumentException {
        int longueur = input.length();
        StringBuffer envers = new StringBuffer();
        int i;

        for (i = 0; i < longueur; i++) {
            envers.append(input.charAt(longueur - i - 1));
        }
        return new String(envers);
    }
        
}

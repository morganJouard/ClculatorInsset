/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.insset.client.service;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 *
 * @author insset
 */
public interface DecimalServiceAsync {
    void divisionEuclidienne(int dividende, int diviseur, AsyncCallback<int[]> callback);
    
    void getMontantDepart(double nb, double pourcentage, AsyncCallback<Double> callback);
}

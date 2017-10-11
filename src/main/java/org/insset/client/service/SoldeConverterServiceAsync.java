/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.insset.client.service;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.RemoteService;

/**
 *
 * @author talend
 */
public interface SoldeConverterServiceAsync {
  float CalculMontantFinal(float montantDepart, int pourcentage, AsyncCallback<String> callback);
  float CalculRemise(float montantDepart, float montantFinal, AsyncCallback<String> callback);
  float CalculMontantDepart(float montantFinal, int pourcentage, AsyncCallback<String> callback);
}


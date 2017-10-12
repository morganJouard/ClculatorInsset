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
  void CalculMontantFinal(float montantDepart, float pourcentage, AsyncCallback<Float> callback);
  void CalculRemise(float montantDepart, float montantFinal, AsyncCallback<Float> callback);
  void CalculMontantDepart(float montantFinal, float pourcentage, AsyncCallback<Float> callback);
}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.insset.client.service;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 *
 * @author user
 */
public interface PercentagesConverterServiceAsync {

    void divide(int dividend, int divisor, AsyncCallback<Double> async);

    void calculateBasePrice(Double finalPrice, Double discountPercentage, AsyncCallback<Double[]> async);

    void calculateFinalPrice(Double basePrice, Double discountPercentage, AsyncCallback<Double[]> async);
}

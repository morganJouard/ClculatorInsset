/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.insset.client.service;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 *
 * @author user
 */
@RemoteServiceRelativePath("percentageConvert")
public interface PercentagesConverterService extends RemoteService {

    Double[] calculateFinalPrice(Double basePrice, Double discountPercentage);

    Double[] calculateBasePrice(Double finalPrice, Double discountPercentage);

    Double divide(int dividend, int divisor);
}

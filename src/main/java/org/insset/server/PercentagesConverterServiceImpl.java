/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.insset.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import org.insset.client.service.PercentagesConverterService;

/**
 * @author user
 */
@SuppressWarnings("serial")
public class PercentagesConverterServiceImpl extends RemoteServiceServlet implements PercentagesConverterService {

    /**
     * @param basePrice
     * @param discountPercentage
     * @return the final price and the discount amount.
     */
    @Override
    public Double[] calculateFinalPrice(Double basePrice, Double discountPercentage) {
        return new Double[]{3., 4.};
    }

    /**
     * @param finalPrice
     * @param discountPercentage
     * @return the base price and the discount amount.
     */
    @Override
    public Double[] calculateBasePrice(Double finalPrice, Double discountPercentage) {
        return new Double[]{4., 5.};
    }

    @Override
    public Double divide(int dividend, int divisor) {
        return 5.;
    }
}

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
    public Double[] calculateFinalPrice(int basePrice, int discountPercentage) {
        double discount = basePrice * divide(discountPercentage, 100.);

        return new Double[]{
                basePrice - discount,
                discount
        };
    }

    /**
     * @param finalPrice
     * @param discountPercentage
     * @return the base price and the discount amount.
     */
    @Override
    public Double[] calculateBasePrice(int finalPrice, int discountPercentage) {
        double price = finalPrice / (1. - divide((double) discountPercentage, 100.));

        return new Double[]{
                price,
                price - finalPrice
        };
    }

    @Override
    public Double divide(double dividend, double divisor) throws IllegalArgumentException {
        if (divisor == 0) {
            throw new IllegalArgumentException("Divisor can't be out of interval 1 to 10000");
        }

        return dividend / divisor;
    }
}

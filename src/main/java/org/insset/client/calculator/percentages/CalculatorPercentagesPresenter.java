package org.insset.client.calculator.percentages;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;
import org.insset.client.calculator.roman.CalculatorRomainPresenter;
import org.insset.client.message.dialogbox.DialogBoxInssetPresenter;
import org.insset.client.service.PercentagesConverterService;
import org.insset.client.service.PercentagesConverterServiceAsync;
import org.insset.client.service.RomanConverterService;
import org.insset.client.service.RomanConverterServiceAsync;
import org.insset.shared.FieldVerifier;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author talend
 */
public class CalculatorPercentagesPresenter extends Composite {

    @UiField
    public TextBox priceBeforeDiscount;
    @UiField
    public TextBox discountPercentage1;
    @UiField
    public SubmitButton boutonFinalPrice;
    @UiField
    public ResetButton boutonClearFinalPrice;
    @UiField
    public Label errorLabelFinalPrice;

    @UiField
    public TextBox finalPrice;
    @UiField
    public TextBox discountPercentage2;
    @UiField
    public SubmitButton boutonBasePrice;
    @UiField
    public ResetButton boutonClearBasePrice;
    @UiField
    public Label errorBasePrice;

    @UiField
    public TextBox dividend;
    @UiField
    public TextBox diviser;
    @UiField
    public SubmitButton boutonDivision;
    @UiField
    public ResetButton boutonClearDivision;
    @UiField
    public Label errorLabelDivision;

    interface MainUiBinder extends UiBinder<HTMLPanel, CalculatorPercentagesPresenter> { }

    private static CalculatorPercentagesPresenter.MainUiBinder ourUiBinder = GWT.create(CalculatorPercentagesPresenter.MainUiBinder.class);
    /**
     * Create a remote service proxy to talk to the server-side Greeting
     * service.
     */
    private final PercentagesConverterServiceAsync service = GWT.create(PercentagesConverterService.class);

    /**
     * Constructeur
     */
    public CalculatorPercentagesPresenter() {
        initWidget(ourUiBinder.createAndBindUi(this));
        initHandler();
    }

    /**
     * Init des handler
     */
    private void initHandler() {

    }
}

package org.insset.client.calculator;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ResetButton;
import com.google.gwt.user.client.ui.SubmitButton;
import com.google.gwt.user.client.ui.TextBox;
import org.insset.client.message.dialogbox.DialogBoxInssetPresenter;
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
public class CalculatorDecimalPresenter extends Composite {

    @UiField
    public ResetButton boutonClearR;
    @UiField
    public SubmitButton boutonConvertRToA;
    @UiField
    public ResetButton boutonClearA;
    @UiField
    public SubmitButton boutonConvertAToR;
    @UiField
    public ResetButton boutonClearD;
    @UiField
    public SubmitButton boutonConvertD;
    @UiField
    public TextBox valR;
    @UiField
    public TextBox valA;
    @UiField
    public TextBox valD;
    @UiField
    public Label errorLabelRToA;
    @UiField
    public Label errorLabelAToR;
    @UiField
    public Label errorLabelD;
    
    private static final String SERVER_ERROR = "An error occurred while "
            + "attempting to contact the server. Please check your network "
            + "connection and try again.";

    interface MainUiBinder extends UiBinder<HTMLPanel, CalculatorDecimalPresenter> {
    }

    private static MainUiBinder ourUiBinder = GWT.create(MainUiBinder.class);
    /**
     * Create a remote service proxy to talk to the server-side Greeting
     * service.
     */
    private final RomanConverterServiceAsync service = GWT.create(RomanConverterService.class);

    /**
     * Constructeur
     */
    public CalculatorDecimalPresenter() {
        initWidget(ourUiBinder.createAndBindUi(this));
        initHandler();
    }

    /**
     * Init des handler
     */
    private void initHandler() {
        boutonClearR.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                valR.setText("");
                errorLabelRToA.setText("");
            }
        });
        boutonConvertRToA.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                convertRomanToArabe();
            }

        });
        boutonClearA.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                valA.setText("");
                errorLabelAToR.setText("");
            }
        });
        boutonConvertAToR.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                convertArabeToRoman();
            }

        });
        boutonClearD.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                valD.setText("");
                errorLabelD.setText("");
            }
        });
        boutonConvertD.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                convertDate();
            }

        });
    }

    /**
     * call server
     */
    private void convertRomanToArabe() {
        if (!FieldVerifier.isValidRoman(valR.getText())) {
            errorLabelRToA.addStyleName("serverResponseLabelError");
            errorLabelRToA.setText("Format incorect");
            return;
        }
        service.convertRomanToArabe(valR.getText(), new AsyncCallback<Integer>() {
            public void onFailure(Throwable caught) {
                // Show the RPC error message to the user
                Window.alert(SERVER_ERROR);
            }

            public void onSuccess(Integer result) {
                new DialogBoxInssetPresenter("Convertion Roman to arabe", valR.getText(), String.valueOf(result));
            }
        });
    }

    /**
     * call server
     */
    private void convertArabeToRoman() {
        errorLabelAToR.setText("");
        if (!FieldVerifier.isValidDecimal(Integer.parseInt(valA.getText()))) {
            errorLabelAToR.addStyleName("serverResponseLabelError");
            errorLabelAToR.setText("Le nombre doit être entre 1 et 2000");
            return;
        }
        service.convertArabeToRoman(Integer.parseInt(valA.getText()), new AsyncCallback<String>() {
            public void onFailure(Throwable caught) {
                // Show the RPC error message to the user
                Window.alert(SERVER_ERROR);
            }

            public void onSuccess(String result) {
                new DialogBoxInssetPresenter("Convertion Arabe to Roman", valA.getText(), result);
            }
        });
    }

    /**
     * call server
     */
    private void convertDate() {
        //Verif
        errorLabelD.setText("");
        if (!FieldVerifier.isValidDate(valD.getText())) {
            errorLabelD.addStyleName("serverResponseLabelError");
            errorLabelD.setText("Le format doit être xx/xx/xxxx ou xx-xx-xxxx");
            return;
        }
        //call server
        service.convertDateYears(valD.getText(), new AsyncCallback<String>() {
            public void onFailure(Throwable caught) {
                // Show the RPC error message to the user
                Window.alert(SERVER_ERROR);
            }

            public void onSuccess(String result) {
                new DialogBoxInssetPresenter("Convertion Date", valD.getText(), result);
            }
        });
    }

}

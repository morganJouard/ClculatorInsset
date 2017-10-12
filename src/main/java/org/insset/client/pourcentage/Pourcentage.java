/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.insset.client.pourcentage;

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
import org.insset.client.exemple.ExemplePresenter;
import org.insset.client.message.Messages;
import org.insset.client.message.dialogbox.DialogBoxInssetPresenter;
import org.insset.client.service.ExempleService;
import org.insset.client.service.ExempleServiceAsync;
import org.insset.client.service.SoldeConverterService;
import org.insset.client.service.SoldeConverterServiceAsync;
import org.insset.shared.FieldVerifier;

/**
 *
 * @author talend
 */
public class Pourcentage extends Composite{
    
    @UiField
    public ResetButton boutonClearR;
    @UiField
    public ResetButton boutonClearR2;
    @UiField
    public SubmitButton boutonConvertFToD;
    @UiField
    public SubmitButton boutonConvertDToF;
    @UiField
    public TextBox montantDepart;
    @UiField
    public TextBox montantFinal;
    @UiField
    public TextBox pourcentage;
    @UiField
    public Label errorLabel;
    @UiField
    public Label errorLabel2;

    /**
     * The message displayed to the user when the server cannot be reached or
     * returns an error.
     */
    /*private static final String SERVER_ERROR = "An error occurred while "
            + "attempting to contact the server. Please check your network "
            + "connection and try again.";*/


    //private final Messages messages = GWT.create(Messages.class);

     /**
     * Create a remote service proxy to talk to the server-side Greeting
     * service.
     */
    interface AddUiBinder extends UiBinder<HTMLPanel, Pourcentage> {
    }
    
    /**
     * Create UiBinder for the view
     */
    private static AddUiBinder ourUiBinder = GWT.create(AddUiBinder.class);
    
    private final SoldeConverterServiceAsync service = GWT.create(SoldeConverterService.class);


    

    /**
     * Constructeur
     */
    public Pourcentage() {
        //bind de la page
        initWidget(ourUiBinder.createAndBindUi(this));
        initHandler();
    }

    /**
     * Methode qui innitialise les handler pour les cliques sur les boutons
     */
    private void initHandler() {
        boutonClearR.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                montantDepart.setText("");
                pourcentage.setText("");
                errorLabel.setText("");
            }
        });
        boutonClearR2.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                montantFinal.setText("");
                errorLabel2.setText("");
            }
        });
        boutonConvertDToF.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                CalculMontantFinal();
            }

        });
        boutonConvertFToD.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                CalculMontantDepart();
            }

        });
    }
    
    private void CheckVirgule(){
        if (montantFinal.getText().contains(",")){
            montantFinal.getText().replace(',', '.');
        }else if(montantDepart.getText().contains(",")){
            montantDepart.getText().replace(',', '.');
        }
    }
    
    private void CalculMontantFinal() {
        CheckVirgule();
        if (!FieldVerifier.isNombreDecimalCorrect(Float.parseFloat(montantDepart.getText()))) {
            errorLabel.addStyleName("serverResponseLabelError");
            errorLabel.setText("Montant entre 1 et 999 999 svp !");
            return;
        }
        service.CalculMontantFinal(Float.parseFloat(montantDepart.getText()), Float.parseFloat(pourcentage.getText()), new AsyncCallback<Float>() {
            public void onFailure(Throwable caught) {
                // Show the RPC error message to the user
//                Window.alert(SERVER_ERROR);
                //errorLabel2.setText(String.valueOf(caught));
            }
            @Override
            public void onSuccess(Float result) {
                errorLabel2.setText("");
                new DialogBoxInssetPresenter("Calcul du montant final", montantDepart.getText() + "€ avec " + pourcentage.getText() + "%", String.valueOf(result) + "€, remise de " + Math.abs((result - Float.parseFloat(montantDepart.getText()))) + "€");
            }
        });
    }
    
    /**
     * call server
     */
    private void CalculMontantDepart() {
        CheckVirgule();
        if (!FieldVerifier.isNombreDecimalCorrect(Float.parseFloat(montantFinal.getText()))) {
            errorLabel2.addStyleName("serverResponseLabelError");
            errorLabel2.setText("Montant entre 1 et 999 999 svp !");
            return;
        }
        service.CalculMontantDepart(Float.parseFloat(montantFinal.getText()), Float.parseFloat(pourcentage.getText()), new AsyncCallback<Float>() {
            public void onFailure(Throwable caught) {
                // Show the RPC error message to the user
            }

            @Override
            public void onSuccess(Float result) {
                errorLabel2.setText(" ");
                new DialogBoxInssetPresenter("Calcul du montant de départ", montantFinal.getText()+ "€ avec " + pourcentage.getText() + "%", String.valueOf(result) + "€");
            }
        });
    }

    private void contacterService() {
        
    }

}

package org.insset.client.decimal;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.rpc.AsyncCallback;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ResetButton;
import com.google.gwt.user.client.ui.SubmitButton;
import com.google.gwt.user.client.ui.TextBox;
import org.insset.client.message.dialogbox.DialogBoxInssetPresenter;

import org.insset.client.service.divisionEuclidienneService;
import org.insset.client.service.divisionEuclidienneServiceAsync;
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
public class DecimalPresenter extends Composite {
    


    @UiField
    public ResetButton boutonClear;
    @UiField
    public SubmitButton boutonEnregistrer;
    @UiField
    public TextBox diviseur;
    @UiField
    public TextBox dividende;
    @UiField
    public Label errorLabel;
    
    //private final ExempleServiceAsync service = GWT.create(ExempleService.class);
    private final divisionEuclidienneServiceAsync service = GWT.create(divisionEuclidienneService.class);

    interface MainUiBinder extends UiBinder<HTMLPanel, DecimalPresenter> {
    }

    private static MainUiBinder ourUiBinder = GWT.create(MainUiBinder.class);

    /**
     * Constructeur
     */
    public DecimalPresenter() {
        initWidget(ourUiBinder.createAndBindUi(this));
        initHandler();
    }

    /**
     * Init des handler
     */
    private void initHandler() {
        boutonClear.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                diviseur.setText("");
                dividende.setText("");
                errorLabel.setText("");
            }
        });
        boutonEnregistrer.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                makeDivision();
            }

        });
    }
    
    private void makeDivision() {
        errorLabel.setText("");
        final String Sdiviseur = diviseur.getText();        
        final String Sdividende = dividende.getText();
        
        int diviseurValue = 0;
        int dividendeValue = 0;
        
        try {
           diviseurValue = Integer.parseInt(Sdiviseur);
        } catch (NumberFormatException e) {
            errorLabel.addStyleName("serverResponseLabelError");
            errorLabel.setText("Le diviseur n'est pas un entier valide!!");
        }
        try {
           dividendeValue = Integer.parseInt(Sdividende);
        } catch (NumberFormatException e) {
            errorLabel.addStyleName("serverResponseLabelError");
            errorLabel.setText("Le dividende n'est pas un entier valide!!");
        }
        
        
        if (!FieldVerifier.isValidDiviseur(diviseurValue)) {
            errorLabel.addStyleName("serverResponseLabelError");
            errorLabel.setText("Le diviseur n'est pas un entier valide!!");
            return;
        }
        if (!FieldVerifier.isValidDividende(dividendeValue)) {
            errorLabel.addStyleName("serverResponseLabelError");
            errorLabel.setText("Le dividende n'est pas un entier valide!!");
            return;
        }
        
        
        service.divisionEuclidienne(Integer.parseInt(Sdividende), Integer.parseInt(Sdiviseur), new AsyncCallback<int[]>(){

            @Override
            public void onFailure(Throwable caught) {
                errorLabel.setText(caught.toString());
            }

            @Override
            public void onSuccess(int[] result) {
                String concatenated = "Resultat : " + result[0] + " | Reste :" + result[1];
                new DialogBoxInssetPresenter("Division euclidienne :", "Resultat", concatenated);
            }
            
        });
    }
    

}

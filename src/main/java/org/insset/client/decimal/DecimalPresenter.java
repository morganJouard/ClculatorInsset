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

import org.insset.client.service.DecimalService;
import org.insset.client.service.DecimalServiceAsync;
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
    public ResetButton boutonClearPourcent;
    @UiField
    public SubmitButton boutonEnregistrerPourcent;
    @UiField
    public TextBox montant;
    @UiField
    public TextBox pourcent;
    @UiField
    public Label errorLabelPourcent;


    @UiField
    public ResetButton boutonClearDivision;
    @UiField
    public SubmitButton boutonEnregistrerDivision;
    @UiField
    public TextBox diviseur;
    @UiField
    public TextBox dividende;
    @UiField
    public Label errorLabelDivision;
    
    //private final ExempleServiceAsync service = GWT.create(ExempleService.class);
    private final DecimalServiceAsync service = GWT.create(DecimalService.class);

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
        boutonClearDivision.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                diviseur.setText("");
                dividende.setText("");
                errorLabelDivision.setText("");
            }
        });
        boutonEnregistrerDivision.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                makeDivision();
            }

        });
        
        boutonClearPourcent.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                montant.setText("");
                pourcent.setText("");
                errorLabelPourcent.setText("");
            }
        });
        boutonEnregistrerPourcent.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                findMontant();
            }

        });
    }
    
    private void makeDivision() {
        errorLabelDivision.setText("");
        final String Sdiviseur = diviseur.getText();        
        final String Sdividende = dividende.getText();
        
        int diviseurValue = 0;
        int dividendeValue = 0;
        
        try {
           diviseurValue = Integer.parseInt(Sdiviseur);
        } catch (NumberFormatException e) {
            errorLabelDivision.addStyleName("serverResponseLabelError");
            errorLabelDivision.setText("Le diviseur n'est pas un entier valide!!");
        }
        try {
           dividendeValue = Integer.parseInt(Sdividende);
        } catch (NumberFormatException e) {
            errorLabelDivision.addStyleName("serverResponseLabelError");
            errorLabelDivision.setText("Le dividende n'est pas un entier valide!!");
        }
        
        
        if (!FieldVerifier.isValidDiviseur(diviseurValue)) {
            errorLabelDivision.addStyleName("serverResponseLabelError");
            errorLabelDivision.setText("Le diviseur n'est pas un entier valide!!");
            return;
        }
        if (!FieldVerifier.isValidDividende(dividendeValue)) {
            errorLabelDivision.addStyleName("serverResponseLabelError");
            errorLabelDivision.setText("Le dividende n'est pas un entier valide!!");
            return;
        }
        
        
        service.divisionEuclidienne(diviseurValue, dividendeValue, new AsyncCallback<int[]>(){

            @Override
            public void onFailure(Throwable caught) {
                errorLabelDivision.setText(caught.toString());
            }

            @Override
            public void onSuccess(int[] result) {
                String concatenated = "Resultat : " + result[0] + " | Reste :" + result[1];
                new DialogBoxInssetPresenter("Division euclidienne :", "Resultat", concatenated);
            }
            
        });
    }
    
    private void findMontant() {
        errorLabelPourcent.setText("");
        final String Smontant = montant.getText();        
        final String Spourcent = pourcent.getText();
        
        int montantValue = 0;
        int pourcentValue = 0;
        
        try {
           montantValue = Integer.parseInt(Smontant);
        } catch (NumberFormatException e) {
            errorLabelPourcent.addStyleName("serverResponseLabelError");
            errorLabelPourcent.setText("Le montant n'est pas un entier valide!!");
        }
        try {
           pourcentValue = Integer.parseInt(Spourcent);
        } catch (NumberFormatException e) {
            errorLabelPourcent.addStyleName("serverResponseLabelError");
            errorLabelPourcent.setText("Le pourcentage n'est pas un entier valide!!");
        }
        
        if (!FieldVerifier.isValidMontant(montantValue)) {
            errorLabelDivision.addStyleName("serverResponseLabelError");
            errorLabelDivision.setText("Le montant doit etre positif!!");
            return;
        }
        if (!FieldVerifier.isValidPourcent(pourcentValue)) {
            errorLabelDivision.addStyleName("serverResponseLabelError");
            errorLabelDivision.setText("Le pourcentage doit etre compris entre 0 et 100");
            return;
        }
        
        service.getMontantDepart(montantValue, pourcentValue, new AsyncCallback<Double>(){

            @Override
            public void onFailure(Throwable caught) {
                errorLabelPourcent.setText(caught.toString());
            }

            @Override
            public void onSuccess(Double result) {
                new DialogBoxInssetPresenter("Montant de depart :", "Resultat", result.toString());
            }
        });
    }
}

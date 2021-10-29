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
import org.insset.client.message.Messages;
import org.insset.client.message.dialogbox.DialogBoxInssetPresenter;
import org.insset.client.service.PourcentageService;
import org.insset.client.service.PourcentageServiceAsync;
import org.insset.shared.FieldVerifier;

/**
 *
 * @author insset
 */
public class PourcentagePresenter extends Composite{
    
    @UiField
    public ResetButton boutonClear;
    @UiField
    public SubmitButton boutonDiviser;
    @UiField
    public TextBox premierEntier;
    @UiField
    public TextBox deuxiemeEntier;
    @UiField
    public Label errorLabel;
    
    private static final String SERVER_ERROR = "An error occurred while "
            + "attempting to contact the server. Please check your network "
            + "connection and try again.";
    
    private final PourcentageServiceAsync service = GWT.create(PourcentageService.class);
    
    private final Messages messages = GWT.create(Messages.class);
    
    interface AddUiBinder extends UiBinder<HTMLPanel, PourcentagePresenter> {
    }
    
    private static AddUiBinder ourUiBinder = GWT.create(AddUiBinder.class);
    
    public PourcentagePresenter() {
        //bind de la page
        initWidget(ourUiBinder.createAndBindUi(this));
        initHandler();
    }
    
    protected void initHandler() {
        boutonClear.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                premierEntier.setText("");
                errorLabel.setText("");
            }
        });
        boutonDiviser.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                contacterService();
            }

        });
    }

    private void contacterService() {
        errorLabel.setText("");
        final String textToServer = premierEntier.getText();
        if (!FieldVerifier.isValidName(textToServer)) {
            errorLabel.addStyleName("serverResponseLabelError");
            errorLabel.setText("Aucun texte entré!!");
            return;
        }
        service.inverserChaine(textToServer, new AsyncCallback<String>() {
            public void onFailure(Throwable caught) {
                // Show the RPC error message to the user
                Window.alert(SERVER_ERROR);
            }

            public void onSuccess(String result) {
                new DialogBoxInssetPresenter("Votre nom inversé :", textToServer, result);
            }
        });
    }
}



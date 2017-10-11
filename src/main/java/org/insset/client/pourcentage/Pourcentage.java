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
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
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

    /**
     * The message displayed to the user when the server cannot be reached or
     * returns an error.
     */
    private static final String SERVER_ERROR = "An error occurred while "
            + "attempting to contact the server. Please check your network "
            + "connection and try again.";

    /**
     * Create a remote service proxy to talk to the server-side Greeting
     * service.
     */
    //private final SoldeConverterServiceAsync service = GWT.create(SoldeConverterService.class);

    private final Messages messages = GWT.create(Messages.class);

    interface AddUiBinder extends UiBinder<HTMLPanel, Pourcentage> {
    }

    /**
     * Create UiBinder for the view
     */
    private static AddUiBinder ourUiBinder = GWT.create(AddUiBinder.class);

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
    protected void initHandler() {
        
    }

    private void contacterService() {
        
    }

}

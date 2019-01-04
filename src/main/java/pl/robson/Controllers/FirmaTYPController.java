/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.robson.Controllers;

import ModeleFX.FirmaFX;
import ModeleFX.FirmaModel;
import ModeleFX.TypPojazduFX;
import ModeleFX.TypPojazduModel;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import org.omg.CORBA.portable.ApplicationException;

/**
 * FXML Controller class
 *
 * @author Mati
 */
public class FirmaTYPController{

    @FXML
    private TextField wpiszFirmeTextField;
    @FXML
    private Button DodajFirmeButton;
    @FXML
    private ComboBox<FirmaFX> wybierzFirmeComboBox;
    @FXML
    private Button UsunFirmezComboBoxButton;
    @FXML
    private TextField wpiszTypPojazduTextField;
    @FXML
    private Button DodajTypPojazduButton;
    @FXML
    private ComboBox<TypPojazduFX> WybierzTypPojazduComboBox;
    @FXML
    private Button UsunTypPojazduzComboBoxButton;
    
    private FirmaModel firmaModel;
    private TypPojazduModel typPojazdModel;

    
    @FXML
    public void initialize() throws ApplicationException {
        this.DodajFirmeButton.disableProperty().bind(this.wpiszFirmeTextField.textProperty().isEmpty());
        this.DodajTypPojazduButton.disableProperty().bind(this.wpiszTypPojazduTextField.textProperty().isEmpty());
        this.firmaModel = new FirmaModel();
        this.firmaModel.init();
        this.wybierzFirmeComboBox.setItems(this.firmaModel.getFirmaList());
        this.typPojazdModel = new TypPojazduModel();
        this.typPojazdModel.init();
        this.WybierzTypPojazduComboBox.setItems(this.typPojazdModel.getTypPojazduList());
    }
    
    @FXML
    private void addFirmetoDB() throws ApplicationException {
        firmaModel.saveFirmaInDB(wpiszFirmeTextField.getText());
        wpiszFirmeTextField.clear();
    }
    
    @FXML
    private void addTypPojazdutoDB() throws ApplicationException {
        typPojazdModel.saveTypPojazdutoDB(wpiszTypPojazduTextField.getText());
        wpiszTypPojazduTextField.clear();     
    }
    
    @FXML
    private void usunFirmeButton() throws ApplicationException{
        this.firmaModel.deleteFirmabyID();
    }
   
    @FXML
    private void usunTypPojazduButton() throws ApplicationException{
        this.typPojazdModel.deleteTypPojazdubyID();
    }
   
    @FXML
    private void onActionTypPojazduComboBox(){
        this.typPojazdModel.setTypPojazdu(this.WybierzTypPojazduComboBox.getSelectionModel().getSelectedItem());
    }
    
    @FXML
    private void onActionFirmaComboBox(){
        this.firmaModel.setFirma(this.wybierzFirmeComboBox.getSelectionModel().getSelectedItem());
    }
    
    
   
}


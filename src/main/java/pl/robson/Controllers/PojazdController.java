/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.robson.Controllers;

import ModeleFX.FirmaFX;
import ModeleFX.PojazdModel;
import ModeleFX.TypPojazduFX;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import org.omg.CORBA.portable.ApplicationException;

/**
 * FXML Controller class
 *
 * @author Mati
 */
public class PojazdController{

    @FXML
    private DatePicker UbezpieczenieDODate;
    @FXML
    private DatePicker UbezpieczenieODDate;
    @FXML
    private DatePicker LeasingODDate;
    @FXML
    private DatePicker LeasingDODate;
    @FXML
    private DatePicker AmortyzacjaODDate;
    @FXML
    private DatePicker AmortyzacjaDODate;
    @FXML
    private DatePicker PodatekOdSrODDate;
    @FXML
    private DatePicker PodatekOdSrDODate;
    @FXML
    private TextField NumerRejstracyjnyTextField;
    @FXML
    private TextField UbezpieczenieTextField;
    @FXML
    private TextField LeasingTextField;
    @FXML
    private TextField AmortyzacjaTextField;
    @FXML
    private TextField PodatekodSrTextField;
    @FXML
    private ComboBox<TypPojazduFX> TypePojazdComboBox;
    @FXML
    private ComboBox<FirmaFX> CompanyComboBox;
    @FXML
    private Button ZatwierdzPojazdButton;
    @FXML
    private Button ClaearDanePojazdButton;
    
    private PojazdModel pojazdModel ;

    @FXML
    public void initialize() {
       this.pojazdModel = new PojazdModel();
        try {
            this.pojazdModel.init();
        } catch (ApplicationException ex) {
            Logger.getLogger(PojazdController.class.getName()).log(Level.SEVERE, null, ex);
        }
       this.TypePojazdComboBox.setItems(this.pojazdModel.getTypPojazduList());
       this.CompanyComboBox.setItems(this.pojazdModel.getFirmaList());
       
       this.pojazdModel.getPojazdFXObjectPropoerty().getFirmaProperty().bind(this.CompanyComboBox.valueProperty());
       this.pojazdModel.getPojazdFXObjectPropoerty().getTypPojazduProperty().bind(this.TypePojazdComboBox.valueProperty());
       this.pojazdModel.getPojazdFXObjectPropoerty().getLeasingProperty().bind(this.LeasingTextField.textProperty());
       this.pojazdModel.getPojazdFXObjectPropoerty().getAmortyzacjaProperty().bind(this.AmortyzacjaTextField.textProperty());
       this.pojazdModel.getPojazdFXObjectPropoerty().getUbezpieczenieProperty().bind(this.UbezpieczenieTextField.textProperty());
       this.pojazdModel.getPojazdFXObjectPropoerty().getNumerRejestracyjnyProperty().bind(this.NumerRejstracyjnyTextField.textProperty());
       this.pojazdModel.getPojazdFXObjectPropoerty().getPodatekSrodkiProperty().bind(this.PodatekodSrTextField.textProperty());
       
      
   

    }    

    @FXML
    private void dodajPojazdDoDBB() throws ApplicationException {
        this.pojazdModel.savePojazdInDataBase();
    }
    
}

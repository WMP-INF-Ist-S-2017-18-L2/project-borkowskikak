/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.robson.Controllers;

import ModeleFX.FirmaFX;
import ModeleFX.PaliwoFX;
import ModeleFX.PaliwoModel;
import ModeleFX.PojazdModel;
import ModeleFX.TypPojazduFX;
import ModeleFX.UbezpieczenieModel;
import ModeleFX.UbezpieczenieFX;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.Property;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.util.StringConverter;
import javafx.util.converter.NumberStringConverter;
import org.omg.CORBA.portable.ApplicationException;

/**
 * FXML Controller class
 *
 * @author Mati
 */
public class PojazdController{
    @FXML
    private TableView dodajPaliwoTableView;
    @FXML
    private TableColumn<PaliwoFX,LocalDate> DodajPaliwoDataTableView; 
    @FXML
    private TableColumn<PaliwoFX,Number> DodajPaliwoIloscTableView; 
    @FXML
    private TableColumn<PaliwoFX,Number> DodajPalwioCenaTableView;
    @FXML
    private TableColumn<PaliwoFX,Number> DodajPaliwoPrzebiegTableView;
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
    @FXML
    private DatePicker DodajPaliwoDatePicker; 
    @FXML
    private TextField DodajPaliwoIlosc;
    @FXML
    private TextField DodajPaliwoCena;
    @FXML
    private TextField DodajPaliwoPrzebieg;
    
    private PojazdModel pojazdModel ;
    private UbezpieczenieModel ubezpieczenieModel;
    private PaliwoModel paliwoModel;
   
    
    
    
    
    
    
    @FXML
    public void initialize() throws ApplicationException {
       this.pojazdModel = new PojazdModel();
        try {
            this.pojazdModel.init();
        } catch (ApplicationException ex) {
            Logger.getLogger(PojazdController.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.paliwoModel = new PaliwoModel();
        this.paliwoModel.init();
        
       this.ubezpieczenieModel = new UbezpieczenieModel();
       this.ubezpieczenieModel.init();
       this.TypePojazdComboBox.setItems(this.pojazdModel.getTypPojazduList());
       this.CompanyComboBox.setItems(this.pojazdModel.getFirmaList());

       this.ubezpieczenieModel = new UbezpieczenieModel();
       this.ubezpieczenieModel.init(); 

       BindFields();
       paliwoTableView();
    }    

    public void BindFields() throws ApplicationException {
        this.TypePojazdComboBox.setItems(this.pojazdModel.getTypPojazduList());
        this.CompanyComboBox.setItems(this.pojazdModel.getFirmaList());
        this.paliwoModel = new PaliwoModel();
        this.paliwoModel.init();   
        this.ubezpieczenieModel = new UbezpieczenieModel();
        this.ubezpieczenieModel.init();      
        this.CompanyComboBox.valueProperty().bindBidirectional(this.pojazdModel.getPojazdFXObjectPropoerty().getFirmaProperty());
        this.TypePojazdComboBox.valueProperty().bindBidirectional(this.pojazdModel.getPojazdFXObjectPropoerty().getTypPojazduProperty());       
        this.LeasingTextField.textProperty().bindBidirectional(this.pojazdModel.getPojazdFXObjectPropoerty().getLeasingProperty());       
        this.AmortyzacjaTextField.textProperty().bind(this.pojazdModel.getPojazdFXObjectPropoerty().getAmortyzacjaProperty());        
        this.PodatekodSrTextField.textProperty().bindBidirectional(this.pojazdModel.getPojazdFXObjectPropoerty().getPodatekSrodkiProperty());
        this.NumerRejstracyjnyTextField.textProperty().bindBidirectional(this.pojazdModel.getPojazdFXObjectPropoerty().getNumerRejestracyjnyProperty());
        this.ZatwierdzPojazdButton.disableProperty().bind(this.NumerRejstracyjnyTextField.textProperty().isEmpty().or(this.CompanyComboBox.valueProperty().isNull().or(this.TypePojazdComboBox.valueProperty().isNull())));
        this.UbezpieczenieODDate.valueProperty().bindBidirectional(this.ubezpieczenieModel.ubezpieczenieObjectProperty().get().odDateProperty());       
        this.UbezpieczenieDODate.valueProperty().bindBidirectional(this.ubezpieczenieModel.ubezpieczenieObjectProperty().get().doDateProperty());
        this.DodajPaliwoCena.textProperty().bindBidirectional(this.paliwoModel.paliwoPropertyProperty().get().CenazaLitrProperty(), new NumberStringConverter());
        this.DodajPaliwoDatePicker.valueProperty().bindBidirectional( this.paliwoModel.paliwoPropertyProperty().get().dataDodaniaProperty());
        this.DodajPaliwoIlosc.textProperty().bindBidirectional(this.paliwoModel.paliwoPropertyProperty().get().iloscpaliwaProperty(), new NumberStringConverter());
        this.DodajPaliwoPrzebieg.textProperty().bindBidirectional(this.paliwoModel.paliwoPropertyProperty().get().przebiegProperty(), new NumberStringConverter());
        this.UbezpieczenieTextField.textProperty().bindBidirectional(this.ubezpieczenieModel.ubezpieczenieObjectProperty().get().ubezpieczenieProperty(), new NumberStringConverter());   
        this.pojazdModel.getPojazdFXObjectPropoerty().ubezpieczenieProperty().setValue(this.ubezpieczenieModel.getUbezpieczenieObject());
        this.pojazdModel.getPojazdFXObjectPropoerty().paliwoPojazduProperty().setValue(this.paliwoModel.getPaliwoProperty());
//        this.pojazdModel.getPojazdFXObjectPropoerty().getAmortyzacjaProperty().bind(this.AmortyzacjaTextField.textProperty());
//        this.paliwoModel.paliwoPropertyProperty().get().dataDodaniaProperty().bind(this.DodajPaliwoDatePicker.valueProperty());
//        this.ubezpieczenieModel.ubezpieczenieObjectProperty().get().odDateProperty().bind(this.UbezpieczenieODDate.valueProperty());
//        this.ubezpieczenieModel.ubezpieczenieObjectProperty().get().doDateProperty().bind(this.UbezpieczenieDODate.valueProperty());
//        this.pojazdModel.getPojazdFXObjectPropoerty().getNumerRejestracyjnyProperty().bind(this.NumerRejstracyjnyTextField.textProperty());
//        this.pojazdModel.getPojazdFXObjectPropoerty().getPodatekSrodkiProperty().bind(this.PodatekodSrTextField.textProperty());
//        this.pojazdModel.getPojazdFXObjectPropoerty().getTypPojazduProperty().bind(this.TypePojazdComboBox.valueProperty());
//        this.pojazdModel.getPojazdFXObjectPropoerty().getFirmaProperty().bind(this.CompanyComboBox.valueProperty());        
//        this.pojazdModel.getPojazdFXObjectPropoerty().getLeasingProperty().bind(this.LeasingTextField.textProperty());
          this.paliwoModel.init();
    }

    @FXML
    private void dodajPojazdDoDBB() throws ApplicationException {       
        this.pojazdModel.savePojazdInDataBase();
        clearFields();
    }
    @FXML
    private void clearFields() {
        this.AmortyzacjaTextField.clear();
        this.LeasingTextField.clear();
        this.NumerRejstracyjnyTextField.clear();
        this.UbezpieczenieTextField.clear();
        this.PodatekodSrTextField.clear();
    }
    
    @FXML
    private void wyczyscPola(){
        this.AmortyzacjaTextField.clear();
        this.LeasingTextField.clear();
        this.NumerRejstracyjnyTextField.clear();
        this.UbezpieczenieTextField.clear();
        this.PodatekodSrTextField.clear();
        this.NumerRejstracyjnyTextField.clear();       
    } 

    public PojazdModel getPojazdModel() {
        return pojazdModel;
    }

    public void setPojazdModel(PojazdModel pojazdModel) {
        this.pojazdModel = pojazdModel;
    }

    public UbezpieczenieModel getUbezpieczenieModel() {
        return ubezpieczenieModel;
    }

    public void setUbezpieczenieModel(UbezpieczenieModel ubezpieczenieModel) {
        this.ubezpieczenieModel = ubezpieczenieModel;
    }

    public PaliwoModel getPaliwoModel() {
        return paliwoModel;
    }

    public void setPaliwoModel(PaliwoModel paliwoModel) {
        this.paliwoModel = paliwoModel;
    }
    

    public void paliwoTableView() throws ApplicationException{
        this.dodajPaliwoTableView.setItems(this.paliwoModel.getPaliwoList());
        this.DodajPaliwoDataTableView.setCellValueFactory(cellData -> cellData.getValue().dataDodaniaProperty());
        this.DodajPaliwoIloscTableView.setCellValueFactory(cellData -> cellData.getValue().iloscpaliwaProperty());
        this.DodajPalwioCenaTableView.setCellValueFactory(cellData->cellData.getValue().CenazaLitrProperty());
        this.DodajPaliwoPrzebiegTableView.setCellValueFactory(cellData -> cellData.getValue().przebiegProperty());
        this.paliwoModel.init();
    }  

}


/* Do zrobienia




*/
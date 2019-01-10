/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.robson.Controllers;

import ModeleFX.paliwoInneFX;
import ModeleFX.paliwoInneModel;
import ModeleFX.pobierajacyInneFX;
import ModeleFX.pobierajacyInneModel;
import static com.itextpdf.kernel.pdf.PdfName.T;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ObservableValue;
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


public class PaliwoInneController{

    @FXML
    private TextField nowyPobierajacyFiled;
    @FXML
    private Button addNowyPobierajacy;
    @FXML
    private ComboBox<pobierajacyInneFX> pobierajacyComboBox;
    @FXML
    private Button deleteNowyPobierajacy;
    @FXML
    private Button addPaliwoInneButton;
    @FXML
    private DatePicker releaseDatePicker ;
    @FXML
    private TextField iloscLitrowPaliwoInneTextField;
    @FXML
    private TextField cenaNettoPaliwoInneTextField;
    @FXML
    private Button addPaliwoInneButtonToDB;
    @FXML
    private TableView<paliwoInneFX> paliwoInneTableView;
    @FXML
    private TableColumn<paliwoInneFX, LocalDate> dataPaliwoInneTabelView;
    @FXML
    private TableColumn<paliwoInneFX, Number> litryPaliwoInneTableView;
    @FXML
    private TableColumn<paliwoInneFX, Number> cenaNettoPaliwoInneTableView;
    @FXML
    private TableColumn<paliwoInneFX, pobierajacyInneFX> pobierajacyPaliwoInneTableView;
    @FXML
    private TableColumn<paliwoInneFX, Number> kosztPaliwoInneTableView;
    @FXML
    private pobierajacyInneModel pobierajacyInneModel;
    
    
    private paliwoInneModel paliwoInneModel;
    
   
    
   
    @FXML
    public void initialize() throws ApplicationException{
            this.addPaliwoInneButton.disableProperty().bind(this.iloscLitrowPaliwoInneTextField.textProperty().isEmpty().or(this.cenaNettoPaliwoInneTextField.textProperty().isEmpty()));   
            this.pobierajacyInneModel = new pobierajacyInneModel();
        try {
            this.pobierajacyInneModel.init();
        } catch (ApplicationException ex) {
            Logger.getLogger(PaliwoInneController.class.getName()).log(Level.SEVERE, null, ex);
        }
            this.pobierajacyComboBox.setItems(this.pobierajacyInneModel.getPobierajacyInneList());
            this.paliwoInneModel = new paliwoInneModel();
        try {
            this.paliwoInneModel.init();
        } catch (ApplicationException ex) {
            Logger.getLogger(PaliwoInneController.class.getName()).log(Level.SEVERE, null, ex);
        }

        
            this.paliwoInneModel.paliwoInneObjectProperty.get().pobierajacyComboBbobox().bind(this.pobierajacyComboBox.valueProperty());
            this.iloscLitrowPaliwoInneTextField.textProperty().bindBidirectional(this.paliwoInneModel.getPaliwoInneObjectProperty().get().getIloscLitrowPaliwoInneTextField(), new NumberStringConverter());
            this.cenaNettoPaliwoInneTextField.textProperty().bindBidirectional(this.paliwoInneModel.getPaliwoInneObjectProperty().get().getCenaNettoPaliwoInneTextField(), new NumberStringConverter());
            this.paliwoInneModel.paliwoInneObjectProperty.get().releaseDateProperty().bind(this.releaseDatePicker.valueProperty());
            
            
            
            this.paliwoInneTableView.setItems(this.paliwoInneModel.getPaliwoInneFXObservableList());
            this.litryPaliwoInneTableView.setCellValueFactory(cellData->cellData.getValue().getIloscLitrowPaliwoInneTextField());
            this.cenaNettoPaliwoInneTableView.setCellValueFactory(cellData->cellData.getValue().getCenaNettoPaliwoInneTextField());
            this.pobierajacyPaliwoInneTableView.setCellValueFactory(cellData -> cellData.getValue().pobierajacyComboBbobox());
            this.dataPaliwoInneTabelView.setCellValueFactory(cellData -> cellData.getValue().releaseDateProperty());
            this.kosztPaliwoInneTableView.setCellValueFactory(cellData -> cellData.getValue().getKoszt());
      
            
  
        try {
            this.paliwoInneModel.init();
        } catch (ApplicationException ex) {
            Logger.getLogger(PaliwoInneController.class.getName()).log(Level.SEVERE, null, ex);
        }
            initBindings();

    }    

    public void addPobierajacyOnAction() throws ApplicationException{
        
        pobierajacyInneModel.savePobierajacyInDB(nowyPobierajacyFiled.getText());
        nowyPobierajacyFiled.clear();
    }

    private void initBindings() {
        this.addNowyPobierajacy.disableProperty().bind(nowyPobierajacyFiled.textProperty().isEmpty());
        this.deleteNowyPobierajacy.disableProperty().bind((this.pobierajacyInneModel.pobierajacyInneProperty().isNull()));   
    }
    
    
    public void deleteNowyPobierajacyonAction() throws ApplicationException{
        this.pobierajacyInneModel.deletepobierajacyInneByID();
    }
    
    public void addPaliwoInneToDB() throws ApplicationException{
        this.paliwoInneModel.savePaliwoInneinDB1();
        this.iloscLitrowPaliwoInneTextField.clear();
        this.cenaNettoPaliwoInneTextField.clear();
        
    }
    
    public void onActionComboBoxPaliwoInne(){
       
       this.pobierajacyInneModel.setPobierajacyInne(this.pobierajacyComboBox.getSelectionModel().getSelectedItem());
       
    }
    
    
}

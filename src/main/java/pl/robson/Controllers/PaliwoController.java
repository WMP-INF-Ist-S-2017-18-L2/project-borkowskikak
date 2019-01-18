/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.robson.Controllers;

import ModeleFX.PaliwoFX;
import ModeleFX.PaliwoModel;
import ModeleFX.PojazdModel;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.util.converter.NumberStringConverter;
import org.omg.CORBA.portable.ApplicationException;

/**
 *
 * @author Mati
 */
public class PaliwoController {
    
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
    private DatePicker DodajPaliwoDatePicker; 
    @FXML
    private TextField DodajPaliwoIlosc;
    @FXML
    private TextField DodajPaliwoCena;
    @FXML
    private TextField DodajPaliwoPrzebieg;
    
     private PojazdModel pojazdModel ;
     private PaliwoModel paliwoModel;
   
     public void init() throws ApplicationException{  
     
     this.pojazdModel = new PojazdModel();
        try {
            this.pojazdModel.init();
        } catch (ApplicationException ex) {
            Logger.getLogger(PojazdController.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.paliwoModel = new PaliwoModel();
        this.paliwoModel.init();
     
        this.DodajPaliwoCena.textProperty().bindBidirectional(this.paliwoModel.paliwoPropertyProperty().get().CenazaLitrProperty(), new NumberStringConverter());
        this.DodajPaliwoDatePicker.valueProperty().bindBidirectional( this.paliwoModel.paliwoPropertyProperty().get().dataDodaniaProperty());
        this.DodajPaliwoIlosc.textProperty().bindBidirectional(this.paliwoModel.paliwoPropertyProperty().get().iloscpaliwaProperty(), new NumberStringConverter());
        this.DodajPaliwoPrzebieg.textProperty().bindBidirectional(this.paliwoModel.paliwoPropertyProperty().get().przebiegProperty(), new NumberStringConverter());
        this.dodajPaliwoTableView.setItems(this.paliwoModel.getPaliwoList());
        this.DodajPaliwoDataTableView.setCellValueFactory(cellData -> cellData.getValue().dataDodaniaProperty());
        this.DodajPaliwoIloscTableView.setCellValueFactory(cellData -> cellData.getValue().iloscpaliwaProperty());
        this.DodajPalwioCenaTableView.setCellValueFactory(cellData->cellData.getValue().CenazaLitrProperty());
        this.DodajPaliwoPrzebiegTableView.setCellValueFactory(cellData -> cellData.getValue().przebiegProperty());
        this.paliwoModel.init();
     
     }    
     
     

private void save(){
        
        
    }

    public PojazdModel getPojazdModel() {
        return pojazdModel;
    }

    public void setPojazdModel(PojazdModel pojazdModel) {
        this.pojazdModel = pojazdModel;
    }

    public PaliwoModel getPaliwoModel() {
        return paliwoModel;
    }

    public void setPaliwoModel(PaliwoModel paliwoModel) {
        this.paliwoModel = paliwoModel;
    }



}

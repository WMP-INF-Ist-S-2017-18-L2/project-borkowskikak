/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.robson.Controllers;

import ModeleFX.PojazdFX;
import ModeleFX.PojazdModel;
import ModeleFX.UbezpieczenieFX;
import ModeleFX.UbezpieczenieModel;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.omg.CORBA.portable.ApplicationException;


public class UbezpieczenieController{

    @FXML
    private TableView<UbezpieczenieFX> UbezpieczenieTableView;
    
    @FXML
    private TableColumn<UbezpieczenieFX,Number> wartoscTableColumn;
    
    @FXML
    private TableColumn<UbezpieczenieFX,LocalDate> DataODTableColumn;
    
    @FXML
    private TableColumn<UbezpieczenieFX,LocalDate> DataDoTableColumn;

    private UbezpieczenieModel ubezpieczenieModel;
    private PojazdModel pojazdModel;
    
    public void initialize() {
        try {
            this.ubezpieczenieModel = new UbezpieczenieModel();
            this.ubezpieczenieModel.init();
        } catch (ApplicationException ex) {
            Logger.getLogger(UbezpieczenieController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       // this.UbezpieczenieTableView.setItems(this.pojazdModel.getUbezpieczenieList());
//        this.wartoscTableColumn.setCellValueFactory(cellData -> cellData.getValue().ubezpieczenieProperty());
 //       this.DataODTableColumn.setCellValueFactory(cellData->cellData.getValue().odDateProperty());
 //       this.DataDoTableColumn.setCellValueFactory(cellData->cellData.getValue().doDateProperty());

        

        
    }    

    @FXML
    private void updateUbezpieczenie(ActionEvent event) {
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.robson.Controllers;

import ModeleFX.FirmaFX;
import ModeleFX.PaliwoFX;
import ModeleFX.PojazdFX;
import ModeleFX.PojazdModel;
import ModeleFX.PojazdyListModel;
import ModeleFX.PrzychodFX;
import ModeleFX.TypPojazduFX;
import ModeleFX.UbezpieczenieFX;
import ModeleFX.WyplataFX;
import com.itextpdf.layout.element.Paragraph;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.omg.CORBA.portable.ApplicationException;
import pl.robson.Utils.FxmlUtils;

/**
 *
 * @author Mati
 */
public class PojazdyListController {
    @FXML
    private TableView<PojazdFX> pojazdyTableView;
    
    @FXML
    private TableColumn<PojazdFX,FirmaFX> FirmaColumn;
    
    @FXML
    private TableColumn<PojazdFX,TypPojazduFX> TypPojazduColumn;
            
    @FXML
    private TableColumn<PojazdFX,String> RejestracjaColumn;
 
    @FXML
    private TableColumn<PojazdFX,UbezpieczenieFX> UbezpieczenieColumn;
            
    @FXML
    private TableColumn<PojazdFX,String> AmortyzacjaColumn;
            
    @FXML
    private TableColumn<PojazdFX,String>  LeasingColumn;     
    
    @FXML
    private TableColumn<PojazdFX,Number>  ZusColumn;
            
    @FXML
    private TableColumn<PojazdFX,Number> PDDOFColumn;
    
    @FXML
    private TableColumn<PojazdFX,String> PodatekodSRColumn;
            
    @FXML
    private TableColumn<WyplataFX,Number> WyplataColumn;
            
    @FXML
    private TableColumn<PrzychodFX,Number> PrzychodColumn;
    
    @FXML
    private TableColumn<PojazdFX,Number> BilansColumn;
   
    @FXML
    private TableColumn<PojazdFX,PojazdFX> DodajPaliwo;
    
    @FXML
    private TableColumn<PaliwoFX,Number> DodajOplatyDrogowe;
    
    @FXML
    private TableColumn<PaliwoFX,Number> DodajPrzychod;
    
    @FXML
    private TableColumn<PaliwoFX,Number> DadoajWyplaty;
    
            
    @FXML
    private ComboBox<TypPojazduFX> TypePojazdComboBox;
    @FXML
    private ComboBox<FirmaFX> CompanyComboBox; 
    
    private PojazdyListModel pojazdylistModel;
    private PojazdModel pojazdModel;
    
    @FXML
    public void initialize(){
        this.pojazdylistModel = new PojazdyListModel();
        try {
            this.pojazdylistModel.init();
        } catch (ApplicationException ex) {
            Logger.getLogger(PojazdyListController.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.TypePojazdComboBox.setItems(this.pojazdylistModel.getTypPojazduList());
        this.CompanyComboBox.setItems(this.pojazdylistModel.getFirmaList());
        
        
        this.pojazdyTableView.setItems(this.pojazdylistModel.getPojazdFXObservableList());
        this.FirmaColumn.setCellValueFactory(cellData -> cellData.getValue().getFirmaProperty());
        this.TypPojazduColumn.setCellValueFactory(cellData -> cellData.getValue().getTypPojazduProperty());
        this.RejestracjaColumn.setCellValueFactory(cellData -> cellData.getValue().getNumerRejestracyjnyProperty());
        this.UbezpieczenieColumn.setCellValueFactory(cellData -> cellData.getValue().ubezpieczenieProperty());
        this.AmortyzacjaColumn.setCellValueFactory(cellData -> cellData.getValue().getAmortyzacjaProperty());
        this.LeasingColumn.setCellValueFactory(cellData -> cellData.getValue().getLeasingProperty());
        this.PodatekodSRColumn.setCellValueFactory(cellData -> cellData.getValue().getPodatekSrodkiProperty());
        System.out.println();
        
        this.DodajPaliwo.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue()));
        this.DodajPaliwo.setCellFactory(param -> new TableCell<PojazdFX,PojazdFX>(){
            Button button = createButton();
            @Override
            protected void updateItem(PojazdFX item, boolean empty) {
                super.updateItem(item, empty);
                
                if(!empty){
                setGraphic(button);
                button.setOnAction(event -> {
                    FXMLLoader loader = FxmlUtils.getLoader("/FXML/AddCar.fxml");
                    Scene scena = null;
                try {
                    scena = new Scene(loader.load());
                } catch (IOException ex) {
                    Logger.getLogger(PojazdyListController.class.getName()).log(Level.SEVERE, null, ex);
                }        
                PojazdController controller = loader.getController();
                controller.getPojazdModel().setPojazdFXObjectProperty(item);
                    try {
                        controller.BindFields();
                    } catch (ApplicationException ex) {
                        Logger.getLogger(PojazdyListController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                Stage stage = new Stage();
                stage.setScene(scena);
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.showAndWait();

                });
                
                }}
            
            
        });
        
        
        
        
    }
    
    private Button createButton(){
        Button button = new Button();
        Image image = new Image(this.getClass().getResource("/icons/fuel12.png").toString());
        ImageView imageView = new ImageView(image);
        button.setGraphic(imageView);
        return button;
    }
    
    public void updateUbezpieczenie(){
        
        
    }
    
    public void goToUpdateUbezpieczenie(){
        FXMLLoader loader = FxmlUtils.getLoader("/FXML/Ubezpieczenie.fxml");
        Scene scena = null;
        try {
            scena = new Scene(loader.load());
        } catch (IOException ex) {
            Logger.getLogger(PojazdyListController.class.getName()).log(Level.SEVERE, null, ex);
        }        
        Stage stage = new Stage();
        stage.setScene(scena);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
        
        
        
         this.pojazdyTableView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> { //obs³uga edycji
         this.pojazdModel.setPojazdFXObjectProperty(newValue);
        });
         
         
    }

    public PojazdModel getPojazdModel() {
        return pojazdModel;
    }

    public void setPojazdModel(PojazdModel pojazdModel) {
        this.pojazdModel = pojazdModel;
    }
    
    
}

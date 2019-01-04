package pl.robson.Controllers;

import javafx.application.Platform;

import javafx.fxml.FXML;
import javafx.scene.control.ToggleGroup;

import java.io.IOException;

public class TopMenuButtonsController {

    public static final String FXML_OPEN_MAIN_FXML = "/FXML/openMain.fxml";
    public static final String FXML_POJAZD_FXML = "/FXML/Pojazd.fxml";
    public static final String FXML_PALIWO_INNE_FXML = "/FXML/PaliwoInne.fxml";
    public static final String FXML_PODSUMOWANIE_FXML = "/FXML/GenerujPodsumowanie.fxml";
    public static final String FXML_ADD_CAR_FXML = "/FXML/AddCar.fxml";
    public static final String FXML_ADD_FIRMATYP = "/FXML/FirmaTYP.fxml";
    private MainController mainController;
    @FXML
    ToggleGroup toggleButtons;

    public void toggleButtonSelected(){
        if(toggleButtons.getSelectedToggle()!=null){
            toggleButtons.getSelectedToggle().setSelected(false);
        }
    }

    public void openMain() {
        mainController.setCenter(FXML_OPEN_MAIN_FXML);

    }

    public void openPoajzd() {
        mainController.setCenter(FXML_POJAZD_FXML);
    }

    public void openPaliwoInne() {
        mainController.setCenter(FXML_PALIWO_INNE_FXML);
    }

    public void openPodusmowanie() {
        mainController.setCenter(FXML_PODSUMOWANIE_FXML);
    }

    public void openAddPojazd() throws IOException {
        if(toggleButtons.getSelectedToggle()!=null){
            toggleButtons.getSelectedToggle().setSelected(false);
        }
        mainController.setCenter(FXML_ADD_CAR_FXML);
    }

    public void openFirmaTYP(){
        mainController.setCenter(FXML_ADD_FIRMATYP);
    }
    
    public void Exit() {
        Platform.exit();
        System.exit(0);
    }

    public MainController getMainController() {
        return mainController;
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }
}

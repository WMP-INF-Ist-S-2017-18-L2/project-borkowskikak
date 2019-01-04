package pl.robson.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.util.ResourceBundle;
import pl.robson.Utils.DaneDoBazy;
import pl.robson.database.dbutils.DbManager;

public class MainController {


    @FXML
    private TopMenuButtonsController topMenuButtonsController;

    @FXML
    private BorderPane borderPane;

    @FXML
    private void initialize(){

    topMenuButtonsController.setMainController(this);
       

    }

    public void setCenter(String fxmlPath){
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource(fxmlPath));
        ResourceBundle bundle = ResourceBundle.getBundle("bundles.messages");
        loader.setResources(bundle);
        Parent parent = null;
        try {
            parent = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        borderPane.setCenter(parent);


    }

}

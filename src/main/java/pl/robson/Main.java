package pl.robson;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


import java.util.Locale;
import java.util.ResourceBundle;
import pl.robson.Utils.DaneDoBazy;
import static pl.robson.Utils.DaneDoBazy.uzupelnijDane;
import pl.robson.database.dbutils.DbManager;
import static pl.robson.database.dbutils.DbManager.initDatabase;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
        
    }


    public void start(Stage primaryStage) throws Exception {
        Locale.setDefault(new Locale("pl"));
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/FXML/BorderPaneMain.fxml"));
        ResourceBundle bundle = ResourceBundle.getBundle("bundles.messages");
        loader.setResources(bundle);
        BorderPane borderPane = loader.load();
        Scene scene = new Scene(borderPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle(bundle.getString("title.application"));
        primaryStage.show();
        
        DbManager.initDatabase();
       
        
      

    }
}

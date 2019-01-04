/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.robson.Controllers;
import emek.pdfgenerator.Pdf;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.application.HostServices;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author Emek
 */
public class GenerujPodsumowanieController implements Initializable {

    @FXML
    private TextField poleNazwaPliku;

    @FXML
    private CheckBox checkBoxRobson;

    @FXML
    private CheckBox checkBoxMakrosan;

    @FXML
    private ComboBox<String> comboBoxTyp;

    @FXML
    private DatePicker dataOd;

    @FXML
    private DatePicker dataDo;

    @FXML
    void przyciskGenerujOnActrion(ActionEvent event) throws FileNotFoundException, MalformedURLException, IOException {
        System.out.println(poleNazwaPliku.getText());

        char jakaFirma = 0;
        if (checkBoxRobson.isSelected()) {
            jakaFirma = 'r';

        } else if (checkBoxMakrosan.isSelected()) {
            jakaFirma = 'm';

        } else {

        }

        System.out.println(comboBoxTyp.getValue());

        LocalDate od = dataOd.getValue();
        List<String> listaPojazdow = new LinkedList<>();
        listaPojazdow.add("TSA 0087C");
        listaPojazdow.add("TSA 0087C");
        listaPojazdow.add("TSA 0087C");
        listaPojazdow.add("TSA 0087C");
        listaPojazdow.add("TSA 0087C");
        listaPojazdow.add("TSA 0087C");

        Pdf pdf = new Pdf("test/" + poleNazwaPliku.getText() + ".pdf", jakaFirma, listaPojazdow, dataOd.getValue(), dataDo.getValue(), comboBoxTyp.getValue());

    }

    @FXML
    void checkBoxMakrosanOnAction(ActionEvent event) {
        checkBoxRobson.setSelected(false);
    }

    @FXML
    void checkBoxRobsonOnActrion(ActionEvent event) {
        checkBoxMakrosan.setSelected(false);

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        dodajOpcjeDoComboBoxa();
    }

    private void dodajOpcjeDoComboBoxa() {
        ObservableList<String> options
                = FXCollections.observableArrayList(
                        "Wszystkie",
                        "Hakowce",
                        "4 Oœ"
                );
        options.add("test");

        comboBoxTyp.setItems(options);
        comboBoxTyp.setValue("Wszystkie");

    }
    
        @FXML
    void przyciskPrzegladajOnAction(ActionEvent event) throws IOException {
   Desktop desktop = Desktop.getDesktop();
        File dirToOpen = null;
        File currentDir = new File("").getAbsoluteFile();
            System.out.println(currentDir);
        try {
            dirToOpen = new File((currentDir.toString()));
          
            desktop.open(dirToOpen);
        } catch (IllegalArgumentException iae) {
            System.out.println("File Not Found");
        }


    }

}

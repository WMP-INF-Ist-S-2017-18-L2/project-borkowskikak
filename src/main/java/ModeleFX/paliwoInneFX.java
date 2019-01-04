/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeleFX;

import java.time.LocalDate;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import pl.robson.database.modele.paliwoInne;

/**
 *
 * @author Mati
 */
public class paliwoInneFX {
    private IntegerProperty id = new SimpleIntegerProperty();
    private ObjectProperty<LocalDate> dataPaliwoInneTabel = new SimpleObjectProperty<>();
    private ObjectProperty<pobierajacyInneFX> pobierajacyComboBox = new SimpleObjectProperty<>();
    private SimpleStringProperty iloscLitrowPaliwoInneTextField = new SimpleStringProperty();
    private SimpleStringProperty cenaNettoPaliwoInneTextField = new SimpleStringProperty();
    private ObjectProperty<LocalDate> releaseDate = new SimpleObjectProperty<>();
    private SimpleStringProperty kosztTextField = new SimpleStringProperty();

    
    public IntegerProperty getId() {
        return id;
    }

    public void setId(IntegerProperty id) {
        this.id = id;
    }

    public ObjectProperty<LocalDate> getDataPaliwoInneTabel() {
        return dataPaliwoInneTabel;
    }

    public void setDataPaliwoInneTabel(ObjectProperty<LocalDate> dataPaliwoInneTabel) {
        this.dataPaliwoInneTabel = dataPaliwoInneTabel;
    }

    

    public SimpleStringProperty getIloscLitrowPaliwoInneTextField() {
        return iloscLitrowPaliwoInneTextField;
    }

    public void setIloscLitrowPaliwoInneTextField(SimpleStringProperty iloscLitrowPaliwoInneTextField) {
        this.iloscLitrowPaliwoInneTextField = iloscLitrowPaliwoInneTextField;
    }

    public SimpleStringProperty getCenaNettoPaliwoInneTextField() {
        return cenaNettoPaliwoInneTextField;
    }

    public void setCenaNettoPaliwoInneTextField(SimpleStringProperty cenaNettoPaliwoInneTextField) {
        this.cenaNettoPaliwoInneTextField = cenaNettoPaliwoInneTextField;
    }

    public SimpleStringProperty getKoszt() {
        return kosztTextField;
    }

    public void setKoszt(IntegerProperty koszt) {
        this.kosztTextField = kosztTextField;
    }
    
    public IntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String iloscLitrowPaliwoInneTextField() {
        return iloscLitrowPaliwoInneTextField.get();
    }

    public SimpleStringProperty iloscLitrowPaliwoInneTextFieldProperty() {
        return iloscLitrowPaliwoInneTextField;
    }
    public ObjectProperty pobierajacyComboBbobox(){
        return pobierajacyComboBox;
    }

    public void setiloscLitrowPaliwoInneTextField(String iloscLitrowPaliwoInneTextField) {
        this.iloscLitrowPaliwoInneTextField.set(iloscLitrowPaliwoInneTextField);
    }

    public String getcenaNettoPaliwoInneTextField() {
        return cenaNettoPaliwoInneTextField.get();
    }
    public String getiloscLitrowPaliwoInneTextField() {
        return iloscLitrowPaliwoInneTextField.get();
    }

    public StringProperty cenaNettoPaliwoInneTextFieldProperty() {
        return cenaNettoPaliwoInneTextField;
    }

    public void setcenaNettoPaliwoInneTextField(String cenaNettoPaliwoInneTextField) {
        this.cenaNettoPaliwoInneTextField.set(cenaNettoPaliwoInneTextField);
    }

    public pobierajacyInneFX getPobierajacyInnneFX(){
        return pobierajacyComboBox.get();
    }
    public void setPobierajacyInnneFX(pobierajacyInneFX pobierajacyComboBox) {
        this.pobierajacyComboBox.set(pobierajacyComboBox);
    }
    public void setCategoryFx(pobierajacyInneFX pobierajacyComboBox) {
        this.pobierajacyComboBox.set(pobierajacyComboBox);
    }

    @Override
    public String toString() {
        return "paliwoInneFX{" + 
                "id=" + id + ", dataPaliwoInneTabel=" + dataPaliwoInneTabel + ", pobierajacyComboBox=" + pobierajacyComboBox + ", iloscLitrowPaliwoInneTextField=" + iloscLitrowPaliwoInneTextField + ", cenaNettoPaliwoInneTextField=" + cenaNettoPaliwoInneTextField + ", releaseDate=" + releaseDate + ", koszt=" + kosztTextField + '}';
    }
    
   public LocalDate getReleaseDate() {
        return releaseDate.get();
    }

    public ObjectProperty<LocalDate> releaseDateProperty() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate.set(releaseDate);
    }
    
    
}

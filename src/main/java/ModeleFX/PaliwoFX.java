/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeleFX;

import com.j256.ormlite.field.DatabaseField;
import java.time.LocalDate;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;

/**
 *
 * @author Mati
 */
public class PaliwoFX {
    private IntegerProperty id = new SimpleIntegerProperty();
    private DoubleProperty cenazaLitr = new SimpleDoubleProperty();
    private DoubleProperty iloscpaliwa = new SimpleDoubleProperty();
    private DoubleProperty przebieg = new SimpleDoubleProperty();
    private ObjectProperty<LocalDate> dataDodania = new SimpleObjectProperty();
    
    
     public int getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public double getIloscpaliwa() {
        return iloscpaliwa.get();
    }

    public DoubleProperty iloscpaliwaProperty() {
        return iloscpaliwa;
    }

    public void setIloscpaliwa(double iloscpaliwa) {
        this.iloscpaliwa.set(iloscpaliwa);
    }

    public double getPrzebieg() {
        return przebieg.get();
    }

    public DoubleProperty przebiegProperty() {
        return przebieg;
    }

    public void setPrzebieg(double przebieg) {
        this.przebieg.set(przebieg);
    }
    
    public LocalDate getDataDodania() {
        return dataDodania.get();
    }

    public ObjectProperty<LocalDate> dataDodaniaProperty() {
        return dataDodania;
    }

    public void setDataDodania(LocalDate dataDodania) {
        this.dataDodania.set(dataDodania);
    }
    
    public double getcenazaLitr() {
        return cenazaLitr.get();
    }

    public DoubleProperty CenazaLitrProperty() {
        return cenazaLitr;
    }

    public void setCenaZaLitr(double cenazaLitr) {
        this.cenazaLitr.set(cenazaLitr);
    
    }

    @Override
    public String toString() {
        return iloscpaliwa.getValue().toString();
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeleFX;

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
public class UbezpieczenieFX {
    private IntegerProperty id = new SimpleIntegerProperty();
    private DoubleProperty ubezpieczenie = new SimpleDoubleProperty();
    private ObjectProperty<LocalDate> odDate = new SimpleObjectProperty<>();
    private ObjectProperty<LocalDate> doDate = new SimpleObjectProperty<>();
    
    
    public int getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public double getUbezpieczenie() {
        return ubezpieczenie.get();
    }

    public DoubleProperty ubezpieczenieProperty() {
        return ubezpieczenie;
    }

    public void setUbezpieczenie(double ubezpieczenie) {
        this.ubezpieczenie.set(ubezpieczenie);
    }

    public LocalDate getOdDate() {
        return odDate.get();
    }

    public ObjectProperty<LocalDate> odDateProperty() {
        return odDate;
    }

    public void setOdDate(LocalDate odDate) {
        this.odDate.set(odDate);
    }

    public LocalDate getDoDate() {
        return doDate.get();
    }

    public ObjectProperty<LocalDate> doDateProperty() {
        return doDate;
    }

    public void setDoDate(LocalDate doDate) {
        this.doDate.set(doDate);
    }

    
}

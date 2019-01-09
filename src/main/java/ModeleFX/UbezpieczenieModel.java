/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeleFX;

import java.time.LocalDate;
import java.util.List;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import org.omg.CORBA.portable.ApplicationException;
import pl.robson.Utils.Converters.ConverterUbezpieczenie;
import pl.robson.Utils.Utils;
import pl.robson.database.dao.UbezpieczenieDao;
import pl.robson.database.dbutils.DbManager;
import pl.robson.database.modele.Ubezpieczenie;

/**
 *
 * @author Mati
 */
public class UbezpieczenieModel {
    private ObservableList<UbezpieczenieFX> ubezpieczenieObservableList = FXCollections.observableArrayList();
    private ObjectProperty<UbezpieczenieFX> ubezpieczenieObjectProperty = new SimpleObjectProperty<>(new UbezpieczenieFX());
    
    
    public  void init() throws ApplicationException{
        UbezpieczenieDao ubezpieczenieDao = new UbezpieczenieDao(DbManager.getConnectionSource());
        List<Ubezpieczenie> ubezpieczenieList = ubezpieczenieDao.queryForAll(Ubezpieczenie.class);
        this.ubezpieczenieObservableList.clear(); 
                ubezpieczenieList.forEach(ubezpieczenie->{
                    UbezpieczenieFX ubezpieczenieFX = ConverterUbezpieczenie.convertToubezpieczenieFX(ubezpieczenie);                  
                    this.ubezpieczenieObservableList.add(ubezpieczenieFX);
                    
                });
                DbManager.closeConnectionSource();
    }
    
    public void saveUbezpieczenietoDB() throws ApplicationException{
 
        UbezpieczenieDao ubezpieczenieDao = new UbezpieczenieDao(DbManager.getConnectionSource());
        Ubezpieczenie ubezpieczenie = ConverterUbezpieczenie.convertToubezpieczenie(this.getUbezpieczenieObject());
        try {
            ubezpieczenieDao.creatOrUpdate(ubezpieczenie);
        } catch (ApplicationException ex) {
            Logger.getLogger(UbezpieczenieModel.class.getName()).log(Level.SEVERE, null, ex);
        }
            DbManager.closeConnectionSource();    
    }
   
    
    
    public ObservableList<UbezpieczenieFX> getUbezpieczenieList() {
        return ubezpieczenieObservableList;
    }

    public void setUbezpieczenieList(ObservableList<UbezpieczenieFX> ubezpieczenieObservableList) {
        this.ubezpieczenieObservableList = ubezpieczenieObservableList;
    }

    public UbezpieczenieFX getUbezpieczenieObject() {
        return ubezpieczenieObjectProperty.get();
    }

    public ObjectProperty<UbezpieczenieFX> ubezpieczenieObjectProperty() {
        return ubezpieczenieObjectProperty;
    }

    public void setUbezpieczenieObject(UbezpieczenieFX ubezpieczenieObject) {
        this.ubezpieczenieObjectProperty.set(ubezpieczenieObject);
    }
    
}

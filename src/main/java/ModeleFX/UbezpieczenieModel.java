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
import org.omg.CORBA.portable.ApplicationException;
import pl.robson.Utils.Converters.ConverterUbezpieczenie;
import pl.robson.database.dao.FirmaDao;
import pl.robson.database.dao.UbezpieczenieDao;
import pl.robson.database.dbutils.DbManager;
import pl.robson.database.modele.Firma;
import pl.robson.database.modele.Ubezpieczenie;

/**
 *
 * @author Mati
 */
public class UbezpieczenieModel {
    private ObservableList<UbezpieczenieFX> ubezpieczenieList = FXCollections.observableArrayList();
    private ObjectProperty<UbezpieczenieFX> ubezpieczenieObject = new SimpleObjectProperty<>();
    
    public  void init() throws ApplicationException{
        UbezpieczenieDao ubezpieczenieDao = new UbezpieczenieDao(DbManager.getConnectionSource());
        List<Ubezpieczenie> ubezpieczenie = ubezpieczenieDao.queryForAll(Ubezpieczenie.class);
        this.ubezpieczenieList.clear(); 
                ubezpieczenie.forEach(c->{
                    UbezpieczenieFX ubezpieczenieFX = new UbezpieczenieFX();
                    ubezpieczenieFX.setId(c.getId());
                    ubezpieczenieFX.setUbezpieczenie(c.getName());
                    ubezpieczenieFX.setOdDate(LocalDate.MAX);
                    ubezpieczenieFX.setDoDate(LocalDate.MAX);
                    this.ubezpieczenieList.add(ubezpieczenieFX);
                    
                });
                DbManager.closeConnectionSource();
    }
    
    public void saveUbezpieczenietoDB(double name) throws ApplicationException{
 
        UbezpieczenieDao ubezpieczenieDao = new UbezpieczenieDao(DbManager.getConnectionSource());
        Ubezpieczenie ubezpieczenie = new Ubezpieczenie();
        
        ubezpieczenie.setName(name);
        try {
            ubezpieczenieDao.creatOrUpdate(ubezpieczenie);
        } catch (ApplicationException ex) {
            Logger.getLogger(UbezpieczenieModel.class.getName()).log(Level.SEVERE, null, ex);
        }

            DbManager.closeConnectionSource();
            init();
    }
   
    
    
    public ObservableList<UbezpieczenieFX> getUbezpieczenieList() {
        return ubezpieczenieList;
    }

    public void setUbezpieczenieList(ObservableList<UbezpieczenieFX> ubezpieczenieList) {
        this.ubezpieczenieList = ubezpieczenieList;
    }

    public UbezpieczenieFX getUbezpieczenieObject() {
        return ubezpieczenieObject.get();
    }

    public ObjectProperty<UbezpieczenieFX> ubezpieczenieObjectProperty() {
        return ubezpieczenieObject;
    }

    public void setUbezpieczenieObject(UbezpieczenieFX ubezpieczenieObject) {
        this.ubezpieczenieObject.set(ubezpieczenieObject);
    }
    
}

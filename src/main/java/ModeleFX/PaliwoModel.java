/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeleFX;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.omg.CORBA.portable.ApplicationException;
import pl.robson.Utils.Converters.ConverterPaliwo;
import pl.robson.Utils.Converters.ConverterUbezpieczenie;
import pl.robson.Utils.Utils;
import pl.robson.database.dao.PaliwoDao;
import pl.robson.database.dao.UbezpieczenieDao;
import pl.robson.database.dbutils.DbManager;
import pl.robson.database.modele.Paliwo;
import pl.robson.database.modele.Ubezpieczenie;

/**
 *
 * @author Mati
 */
public class PaliwoModel {
    private ObservableList paliwoList = FXCollections.observableArrayList();
    private ObjectProperty<PaliwoFX> paliwoProperty = new SimpleObjectProperty<>(new PaliwoFX());
    
    
    public void init() throws ApplicationException{
        PaliwoDao paliwoDao = new PaliwoDao(DbManager.getConnectionSource());
        List<Paliwo> listPaliwo = paliwoDao.queryForAll(Paliwo.class);
        paliwoList.clear();
        listPaliwo.forEach(c->{
        
            PaliwoFX paliwoFX = new PaliwoFX();
            paliwoFX.setId(c.getId());
            paliwoFX.setIloscpaliwa(c.getIloscPaliwa());
            paliwoFX.setPrzebieg(c.getPrzebieg());
            paliwoFX.setCenaZaLitr(c.getCenazaLitr());
            paliwoFX.setDataDodania(Utils.convertToLocalDate(c.getDataDodaniaPaliwa()));
        
            this.paliwoList.add(paliwoFX);
        
        });
        
        DbManager.closeConnectionSource();
    }
    
    
    private void savePaliwotoDB(){
        PaliwoDao paliwoDao = new PaliwoDao(DbManager.getConnectionSource());
        Paliwo paliwo = ConverterPaliwo.ConvertToPaliwo(this.getPaliwoProperty());
        try {
            paliwoDao.creatOrUpdate(paliwo);
        } catch (ApplicationException ex) {
            Logger.getLogger(PaliwoModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        DbManager.closeConnectionSource();
            
    }
    
    public ObservableList getPaliwoList() {
        return paliwoList;
    }

    public void setPaliwoList(ObservableList paliwoList) {
        this.paliwoList = paliwoList;
    }

    public PaliwoFX getPaliwoProperty() {
        return paliwoProperty.get();
    }

    public ObjectProperty<PaliwoFX> paliwoPropertyProperty() {
        return paliwoProperty;
    }

    public void setPaliwoProperty(PaliwoFX paliwoProperty) {
        this.paliwoProperty.set(paliwoProperty);
    }
    
}

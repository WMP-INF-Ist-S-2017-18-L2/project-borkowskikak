/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeleFX;

import java.util.List;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.omg.CORBA.portable.ApplicationException;
import pl.robson.Utils.Converters.ConverterPaliwoInne;
import pl.robson.Utils.Converters.ConverterPobierajacyInne;
import pl.robson.database.dao.PaliwoDao;
import pl.robson.database.dao.PobierajacyDao;
import pl.robson.database.dbutils.DbManager;
import pl.robson.database.modele.PobierajacyInne;
import pl.robson.database.modele.paliwoInne;

/**
 *
 * @author Mati
 */
public class paliwoInneModel {
    
    public ObjectProperty<paliwoInneFX> paliwoInneObjectProperty = new SimpleObjectProperty<>(new paliwoInneFX());
    private ObservableList<paliwoInneFX> paliwoInneFXObservableList = FXCollections.observableArrayList();
    private ObservableList<pobierajacyInneFX> pobierajacyInneFXObservableList = FXCollections.observableArrayList();

    
    public void init() throws ApplicationException{
        
        PaliwoDao paliwoDao = new PaliwoDao(DbManager.getConnectionSource());
        List<paliwoInne> paliwoInneList = paliwoDao.queryForAll(paliwoInne.class);
        this.paliwoInneFXObservableList.clear();
        paliwoInneList.forEach(paliwoInne ->{
            paliwoInneFX palioFX = ConverterPaliwoInne.ConvertToPaliwoInneFX(paliwoInne);
            paliwoInneFXObservableList.add(palioFX);
        });
        DbManager.closeConnectionSource();
    
    }

    public void savePaliwoInneinDB1() throws ApplicationException{
        
        paliwoInne paliwoInne1 = ConverterPaliwoInne.convertTopaliwoInne(this.getPaliwoFxObjectProperty());
        PobierajacyDao pobierajacyDao = new PobierajacyDao(DbManager.getConnectionSource());
        PobierajacyInne pobierajacyInne = pobierajacyDao.findById(PobierajacyInne.class,this.getPaliwoFxObjectProperty().getPobierajacyInnneFX().getId());
        paliwoInne1.setPobierajacy(pobierajacyInne);
        PaliwoDao paliwoDao = new PaliwoDao(DbManager.getConnectionSource());   
        paliwoDao.creatOrUpdate(paliwoInne1);
        DbManager.closeConnectionSource();
        init();
    }

     public ObservableList<pobierajacyInneFX> getPobierajacyInneFXObservableList() {
        return pobierajacyInneFXObservableList;
    }

    public void setPobierajacyInneFXObservableList(ObservableList<pobierajacyInneFX> pobierajacyInneFXObservableList) {
        this.pobierajacyInneFXObservableList = pobierajacyInneFXObservableList;
    }
    

    public ObjectProperty<paliwoInneFX> getPaliwoInneObjectProperty() {
        return paliwoInneObjectProperty;
    }

    public void setPaliwoInneObjectProperty(ObjectProperty<paliwoInneFX> paliwoInneObjectProperty) {
        this.paliwoInneObjectProperty = paliwoInneObjectProperty;
    }

    public ObservableList<paliwoInneFX> getPaliwoInneFXObservableList() {
        return paliwoInneFXObservableList;
    }

    public void setPaliwoInneFXObservableList(ObservableList<paliwoInneFX> paliwoInneFXObservableList) {
        this.paliwoInneFXObservableList = paliwoInneFXObservableList;
    }
     public paliwoInneFX getPaliwoFxObjectProperty() {
        return paliwoInneObjectProperty.get();
    }
    
    

   
    
}
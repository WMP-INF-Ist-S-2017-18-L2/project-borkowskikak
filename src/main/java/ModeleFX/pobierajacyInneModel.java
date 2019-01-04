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
import pl.robson.database.dao.PobierajacyDao;
import pl.robson.database.dbutils.DbManager;
import pl.robson.database.modele.PobierajacyInne;


/**
 *
 * @author Mati
 */
public class pobierajacyInneModel {
    
    private ObservableList<pobierajacyInneFX> pobierajacyInneList = FXCollections.observableArrayList();
    private ObjectProperty<pobierajacyInneFX> pobierajacyInne = new SimpleObjectProperty<>();
    
    
    public void init() throws ApplicationException{
        PobierajacyDao pobierajacyDao = new PobierajacyDao(DbManager.getConnectionSource());
        List<PobierajacyInne> pobierajacy = pobierajacyDao.queryForAll(PobierajacyInne.class);
        this.pobierajacyInneList.clear();
        pobierajacy.forEach(c->{
                pobierajacyInneFX pobierajacyFX = new pobierajacyInneFX();
                pobierajacyFX.setId(c.getId());
                pobierajacyFX.setName(c.getName());
                this.pobierajacyInneList.add(pobierajacyFX);            
                });
                DbManager.closeConnectionSource();

    }
    
    public void savePobierajacyInDB(String name) throws ApplicationException{
        PobierajacyDao pobierajacyDao = new PobierajacyDao(DbManager.getConnectionSource());
        PobierajacyInne pobierajacyInne = new PobierajacyInne();
        pobierajacyInne.setName(name);
        try {
            pobierajacyDao.creatOrUpdate(pobierajacyInne);
        } catch (ApplicationException ex) {
            Logger.getLogger(pobierajacyInneModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        DbManager.closeConnectionSource();
        init();

    }
    
    public void deletepobierajacyInneByID() throws ApplicationException{
        PobierajacyDao pobierajacyDao = new PobierajacyDao(DbManager.getConnectionSource());
        pobierajacyDao.deleteById(PobierajacyInne.class,pobierajacyInne.getValue().getId());
        DbManager.closeConnectionSource();
        init();

    }

    public ObservableList<pobierajacyInneFX> getPobierajacyInneList() {
        return pobierajacyInneList;
    }

    public void setPobierajacyInneList(ObservableList<pobierajacyInneFX> pobierajacyInneList) {
        this.pobierajacyInneList = pobierajacyInneList;
    }
   public pobierajacyInneFX getpobierajacyInneFX() {
        return pobierajacyInne.get();
    }

    public void setPobierajacyInne(ObjectProperty<pobierajacyInneFX> pobierajacyInne) {
        this.pobierajacyInne = pobierajacyInne;
    }
    
    public void setPobierajacyInne(pobierajacyInneFX pobierajacyInne) {
        this.pobierajacyInne.set(pobierajacyInne);
    }
    public ObjectProperty<pobierajacyInneFX> pobierajacyInneProperty() {
        return pobierajacyInne;
    }
    public void setCategory(pobierajacyInneFX pobierajacyInne) {
        this.pobierajacyInne.set(pobierajacyInne);
    }
}
    



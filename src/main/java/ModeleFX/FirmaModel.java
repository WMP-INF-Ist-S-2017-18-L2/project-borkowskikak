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
import pl.robson.database.dao.FirmaDao;
import pl.robson.database.dbutils.DbManager;
import pl.robson.database.modele.Firma;

/**
 *
 * @author Mati
 */
public class FirmaModel {
    private ObservableList<FirmaFX> firmaList = FXCollections.observableArrayList();
    private ObjectProperty<FirmaFX> firma = new SimpleObjectProperty<>();
    
    
    public  void init() throws ApplicationException{
        FirmaDao firmaDao = new FirmaDao(DbManager.getConnectionSource());
        List<Firma> firma = firmaDao.queryForAll(Firma.class);
        this.firmaList.clear(); 
                firma.forEach(c->{
                    FirmaFX firmaFX = new FirmaFX();
                    firmaFX.setId(c.getId());
                    firmaFX.setName(c.getFirma());
                    this.firmaList.add(firmaFX);
                    
                });
                DbManager.closeConnectionSource();
    }
    
    public void saveFirmaInDB(String name) throws ApplicationException{
        FirmaDao firmaDao = new FirmaDao(DbManager.getConnectionSource());
        Firma firma = new Firma();
        firma.setFirma(name);
        try {
            firmaDao.creatOrUpdate(firma);
        } catch (ApplicationException ex) {
            Logger.getLogger(FirmaModel.class.getName()).log(Level.SEVERE, null, ex);
        }
            DbManager.closeConnectionSource();
            init();
    }
    
    public void deleteFirmabyID() throws ApplicationException{
        FirmaDao firmaDao = new FirmaDao(DbManager.getConnectionSource());
        firmaDao.deleteById(Firma.class,firma.getValue().getId());
        DbManager.closeConnectionSource();
        init();
        
    }


    public ObservableList<FirmaFX> getFirmaList() {
        return firmaList;
    }

    public void setFirmaList(ObservableList<FirmaFX> firmaList) {
        this.firmaList = firmaList;
    }

    public ObjectProperty<FirmaFX> getFirma() {
        return firma;
    }

    public void setFirma(ObjectProperty<FirmaFX> firma) {
        this.firma = firma;
    }
    
   public FirmaFX getFirmaFX(){
       return firma.get();
   }
    public void setFirma(FirmaFX firma){
        this.firma.set(firma);
    }
    
}

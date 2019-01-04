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
import pl.robson.database.dao.TypPojazdDao;
import pl.robson.database.dbutils.DbManager;
import pl.robson.database.modele.TypPojazdu;

/**
 *
 * @author Mati
 */
public class TypPojazduModel {
    private ObservableList<TypPojazduFX> typPojazduList = FXCollections.observableArrayList();
    private ObjectProperty<TypPojazduFX> typPojazdu = new SimpleObjectProperty<>();

    public void init() throws ApplicationException{
        TypPojazdDao typPojazdDao = new  TypPojazdDao(DbManager.getConnectionSource());
        List<TypPojazdu> typPojazdu = typPojazdDao.queryForAll(TypPojazdu.class);
        this.typPojazduList.clear();
        
        typPojazdu.forEach(c->{
            TypPojazduFX typPojazduFX = new TypPojazduFX();
            typPojazduFX.setId(c.getId());
            typPojazduFX.setName(c.getTypPojazdu());
            this.typPojazduList.add(typPojazduFX);
            
        });
        DbManager.closeConnectionSource();        
    }
    
    public void saveTypPojazdutoDB(String name) throws ApplicationException{
        TypPojazdDao typPojazdDao = new TypPojazdDao(DbManager.getConnectionSource());
        TypPojazdu typPojazdu = new TypPojazdu();
        typPojazdu.setTypPojazdu(name);
        try {
            typPojazdDao.creatOrUpdate(typPojazdu);
        } catch (ApplicationException ex) {
            Logger.getLogger(TypPojazduModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        DbManager.closeConnectionSource();
        init();
    }
    public void deleteTypPojazdubyID() throws ApplicationException{
       TypPojazdDao typPojazdDao = new TypPojazdDao(DbManager.getConnectionSource());
       typPojazdDao.deleteById(TypPojazdu.class,typPojazdu.getValue().getId());
       DbManager.closeConnectionSource();
        init();
    }
    
    
    public ObservableList<TypPojazduFX> getTypPojazduList() {
        return typPojazduList;
    }

    public void setTypPojazduList(ObservableList<TypPojazduFX> typPojazduList) {
        this.typPojazduList = typPojazduList;
    }

    public ObjectProperty<TypPojazduFX> getTypPojazdu() {
        return typPojazdu;
    }

    public void setTypPojazdu(ObjectProperty<TypPojazduFX> typPojazdu) {
        this.typPojazdu = typPojazdu;
    }
    public TypPojazduFX getTypPojazduFX(){
        return typPojazdu.get();
    }
    public void setTypPojazdu(TypPojazduFX typPojazdu){
        this.typPojazdu.set(typPojazdu);
    }
    
    
    
    
}

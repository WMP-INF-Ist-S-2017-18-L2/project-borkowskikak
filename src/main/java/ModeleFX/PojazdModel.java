/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeleFX;

import java.time.LocalDate;
import java.util.List;
import java.util.Observable;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.omg.CORBA.portable.ApplicationException;
import pl.robson.Utils.Converters.ConverterPojazd;
import pl.robson.Utils.Utils;
import pl.robson.database.dao.FirmaDao;
import pl.robson.database.dao.PojazdDao;
import pl.robson.database.dao.TypPojazdDao;
import pl.robson.database.dao.UbezpieczenieDao;
import pl.robson.database.dbutils.DbManager;
import pl.robson.database.modele.Firma;
import pl.robson.database.modele.Pojazd;
import pl.robson.database.modele.TypPojazdu;
import pl.robson.database.modele.Ubezpieczenie;

/**
 *
 * @author Mati
 */
public class PojazdModel {
    
    private ObjectProperty<PojazdFX> pojazdFXObjectProperty = new SimpleObjectProperty<>(new PojazdFX());
    private ObservableList<TypPojazduFX> TypPojazduList = FXCollections.observableArrayList();
    private ObservableList<FirmaFX> FirmaList = FXCollections.observableArrayList();
    private ObservableList<UbezpieczenieFX> UbezpieczenieList = FXCollections.observableArrayList();
   

    public void init() throws ApplicationException{
        initTypPojazduList();
        initFirmaList();
        initUbezpieczenieList();
    }

    
    private void initTypPojazduList() throws ApplicationException {
        TypPojazdDao typPojazdDao = new TypPojazdDao(DbManager.getConnectionSource());
        List<TypPojazdu> typPojazduList = typPojazdDao.queryForAll(TypPojazdu.class);
        TypPojazduList.clear();
        typPojazduList.forEach(c-> {
            TypPojazduFX typPojazduFX = new TypPojazduFX();
            typPojazduFX.setId(c.getId());
            typPojazduFX.setName(c.getTypPojazdu());
            TypPojazduList.add(typPojazduFX);
            
        });
        
        
        DbManager.closeConnectionSource();
    }

    private void initFirmaList() throws ApplicationException {
    
        FirmaDao firmaDao = new FirmaDao(DbManager.getConnectionSource());
        List<Firma> firmaList = firmaDao.queryForAll(Firma.class);
        FirmaList.clear();
        firmaList.forEach(c-> {
            FirmaFX firmaFX = new FirmaFX();
            firmaFX.setId(c.getId());
            firmaFX.setName(c.getName());
            FirmaList.add(firmaFX);
            
        });
        
        
        DbManager.closeConnectionSource();
    
    }
    
     private void initUbezpieczenieList() throws ApplicationException{
        UbezpieczenieDao ubezpieczenieDao = new UbezpieczenieDao(DbManager.getConnectionSource());
        List<Ubezpieczenie> ubezpieczenieList = ubezpieczenieDao.queryForAll(Ubezpieczenie.class);
        UbezpieczenieList.clear();
        ubezpieczenieList.forEach(c->{
            UbezpieczenieFX ubezpieczenieFX = new UbezpieczenieFX();
            ubezpieczenieFX.setId(c.getId());
            ubezpieczenieFX.setUbezpieczenie(c.getName());
            ubezpieczenieFX.setOdDate(Utils.convertToLocalDate(c.getDataDO()));
            ubezpieczenieFX.setDoDate(Utils.convertToLocalDate(c.getDataOD()));
            
            UbezpieczenieList.add(ubezpieczenieFX);
            
        });
        DbManager.closeConnectionSource();
    }
    
    public void savePojazdInDataBase() throws ApplicationException{
//        System.out.println("TU kURWA JEST"+ this.getPojazdFXObjectPropoerty().getUbezpieczenie().getUbezpieczenie());
//        
        Pojazd pojazd = ConverterPojazd.convertToPojazd(this.getPojazdFXObjectPropoerty());
//        System.out.println("TU kURWA JEST2"+ this.getPojazdFXObjectPropoerty().getUbezpieczenie().getUbezpieczenie());
//        
//     
          FirmaDao firmaDao = new FirmaDao(DbManager.getConnectionSource());
          Firma firma = firmaDao.findById(Firma.class,this.getPojazdFXObjectPropoerty().getFirma().getId());
        
          TypPojazdDao typPojazdDao = new TypPojazdDao(DbManager.getConnectionSource());
          TypPojazdu typPojazdu = typPojazdDao.findById(TypPojazdu.class,this.getPojazdFXObjectPropoerty().getTypPojazdu().getId());
//        
//        UbezpieczenieDao ubezpieczenieDao = new UbezpieczenieDao(DbManager.getConnectionSource());
//        Ubezpieczenie ubezpieczenie = ubezpieczenieDao.findById(Ubezpieczenie.class, this.getPojazdFXObjectPropoerty().getUbezpieczenie().getId());
//        
        pojazd.setTypPojazdu(typPojazdu);
        pojazd.setFirma(firma);
        //pojazd.setUbezpieczenie(ubezpieczenie);
        
        PojazdDao pojazdDao = new PojazdDao(DbManager.getConnectionSource());
        pojazdDao.creatOrUpdate(pojazd);
        
        
        
    }

    public ObservableList<TypPojazduFX> getTypPojazduList() {
        return TypPojazduList;
    }

    public void setTypPojazduList(ObservableList<TypPojazduFX> TypPojazduList) {
        this.TypPojazduList = TypPojazduList;
    }

    public ObservableList<FirmaFX> getFirmaList() {
        return FirmaList;
    }

    public void setFirmaList(ObservableList<FirmaFX> FirmaList) {
        this.FirmaList = FirmaList;
    }
    
     public ObservableList<UbezpieczenieFX> getUbezpieczenieList() {
        return UbezpieczenieList;
    }

    public void setUbezpieczenieList(ObservableList<UbezpieczenieFX> ubezpieczenieList) {
        UbezpieczenieList = ubezpieczenieList;
    }
    public ObjectProperty<PojazdFX> getPojazdFXObjectProperty() {
        return pojazdFXObjectProperty;
    }

    public void setPojazdFXObjectProperty(ObjectProperty<PojazdFX> pojazdFXObjectProperty) {
        this.pojazdFXObjectProperty = pojazdFXObjectProperty;
    }
    
    public PojazdFX getPojazdFXObjectPropoerty(){
        return pojazdFXObjectProperty.get();
    }
    
    

    
    
    
    

    
    
}

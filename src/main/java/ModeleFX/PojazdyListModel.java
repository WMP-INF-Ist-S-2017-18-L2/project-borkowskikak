/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeleFX;

import java.util.ArrayList;
import java.util.List;
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
public class PojazdyListModel {
    
    private ObservableList<PojazdFX> pojazdFXObservableList = FXCollections.observableArrayList();
    private ObservableList<TypPojazduFX> TypPojazduList = FXCollections.observableArrayList();
    private ObservableList<FirmaFX> FirmaList = FXCollections.observableArrayList();
    private ObservableList<UbezpieczenieFX> UbezpieczenieList = FXCollections.observableArrayList();
    
    private List<PojazdFX> PojazdFxList = new ArrayList<>();
    
    
    public void init() throws ApplicationException{
        PojazdDao pojazdDao = new PojazdDao(DbManager.getConnectionSource());
        List<Pojazd> pojazdy = pojazdDao.queryForAll(Pojazd.class);
        pojazdy.forEach(pojazd ->{
            this.PojazdFxList.add(ConverterPojazd.convertToPojazdFX(pojazd));
            
        });
            this.pojazdFXObservableList.setAll(PojazdFxList);
            
            
        initFirmaList();
        initTypPojazduList();
        initUbezpieczenie();
       DbManager.closeConnectionSource();
        
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
     private void initUbezpieczenie() throws ApplicationException{
        UbezpieczenieDao ubezpieczenieDao = new UbezpieczenieDao(DbManager.getConnectionSource());
        List<Ubezpieczenie> ubezpieczenieList = ubezpieczenieDao.queryForAll(Ubezpieczenie.class);
        UbezpieczenieList.clear();
        ubezpieczenieList.forEach(ubezpieczenie->{
            UbezpieczenieFX ubezpieczenieFX = new UbezpieczenieFX();
            ubezpieczenieFX.setId(ubezpieczenie.getId());
            ubezpieczenieFX.setUbezpieczenie(ubezpieczenie.getName());
            ubezpieczenieFX.setOdDate(Utils.convertToLocalDate(ubezpieczenie.getDataDO()));
            ubezpieczenieFX.setDoDate(Utils.convertToLocalDate(ubezpieczenie.getDataOD()));
            
            UbezpieczenieList.add(ubezpieczenieFX);
            
        });
        DbManager.closeConnectionSource();
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
     public ObservableList<PojazdFX> getPojazdFXObservableList() {
        return pojazdFXObservableList;
    }

    public void setPojazdFXObservableList(ObservableList<PojazdFX> pojazdFXObservableList) {
        this.pojazdFXObservableList = pojazdFXObservableList;
    }
   
    
    
    
}

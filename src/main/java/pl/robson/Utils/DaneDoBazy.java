/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.robson.Utils;

import com.j256.ormlite.support.ConnectionSource;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.omg.CORBA.portable.ApplicationException;
import pl.robson.database.dao.PobierajacyDao;
import pl.robson.database.dao.PojazdDao;
import pl.robson.database.dbutils.DbManager;
import pl.robson.database.modele.Firma;
import pl.robson.database.modele.PobierajacyInne;
import pl.robson.database.modele.Pojazd;
import pl.robson.database.modele.TypPojazdu;

/**
 *
 * @author Mati
 */
public class DaneDoBazy {
    
    public static void uzupelnijDane(ConnectionSource connectionSource){
        System.out.println("eMMEK SSIE PALE");
        PobierajacyInne pob0 = new PobierajacyInne();
        pob0.setName("Mateusz Borkowski");
        PobierajacyDao pobierajacyDao = new PobierajacyDao(DbManager.getConnectionSource());
        try {
            pobierajacyDao.creatOrUpdate(pob0);
        } catch (ApplicationException ex) {
            Logger.getLogger(DaneDoBazy.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        Pojazd pojazd1 = new Pojazd();
        
        pojazd1.setId(10);
        pojazd1.setNumerRejestracyjny("sdasdasda");
            TypPojazdu typPojazdu = new TypPojazdu();
            typPojazdu.setId(19);
            typPojazdu.setTypPojazdu("gowno");
        pojazd1.setTypPojazdu(typPojazdu);
        Firma firma = new Firma();
            firma.setId(44);
            firma.setName("gowniana");
        pojazd1.setFirma(firma);
        
        
        PojazdDao pojazdDao = new PojazdDao(DbManager.getConnectionSource());
        try {
            pojazdDao.creatOrUpdate(pojazd1);
        } catch (ApplicationException ex) {
            Logger.getLogger(DaneDoBazy.class.getName()).log(Level.SEVERE, null, ex);
        }
        DbManager.closeConnectionSource();
    
    }
    
}

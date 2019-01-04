/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.robson.Utils.Converters;

import ModeleFX.PojazdFX;
import pl.robson.database.modele.Pojazd;

/**
 *
 * @author Mati
 */
public class ConverterPojazd {
    
    
    public static Pojazd convertToPojazd(PojazdFX pojazdFX){
    Pojazd pojazd = new Pojazd();
    pojazd.setNumerRejestracyjny(pojazdFX.getNumerRejestracyjny());
    pojazd.setUbezpieczenie(pojazdFX.getUbezpieczenie());
    pojazd.setLeasing(pojazdFX.getLeasing());
    pojazd.setAmortyzacja(pojazdFX.getAmortyzacja());
    pojazd.setPodatek(pojazdFX.getPodatekSrodki());
    return pojazd;
    }
    
    public static PojazdFX convertToPojazdFX(Pojazd pojazd){
    PojazdFX pojazdFX = new PojazdFX();
    pojazdFX.setFirmaFX(ConverterFirma.convertToFirmaFX(pojazd.getFirma()));
    pojazdFX.setTypPojazduFX(ConverterTypPojazdu.convertToTypPojazduFX(pojazd.getTypPojazdu()));
    pojazdFX.setNumerRejestracyjny(pojazd.getNumerRejestracyjny());
    pojazdFX.setAmortyzacja(pojazd.getAmortyzacja());
    pojazdFX.setLeasing(pojazd.getLeasing());
    pojazdFX.setUbezpieczenie(pojazd.getUbezpieczenie());
    pojazdFX.setPodatekSrodki(pojazd.getPodatek());
    
    return pojazdFX;    
    }
}
    


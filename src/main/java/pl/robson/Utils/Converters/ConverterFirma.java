/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.robson.Utils.Converters;

import ModeleFX.FirmaFX;
import pl.robson.database.modele.Firma;

/**
 *
 * @author Mati
 */
public class ConverterFirma {
    
    public static FirmaFX convertToFirmaFX(Firma firma){
        FirmaFX firmaFX = new FirmaFX();
        firmaFX.setId(firma.getId());
        firmaFX.setName(firma.getName());
    return firmaFX;
    }
    
}

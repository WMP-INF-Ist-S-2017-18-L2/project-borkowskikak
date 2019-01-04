/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.robson.Utils.Converters;

import ModeleFX.paliwoInneFX;
import pl.robson.Utils.Utils;
import pl.robson.database.modele.paliwoInne;

/**
 *
 * @author Mati
 */
public class ConverterPaliwoInne {
    
    public static paliwoInne convertTopaliwoInne(paliwoInneFX paliwoInneFX){
        paliwoInne paliwoInne1 = new paliwoInne();
        paliwoInne1.setCenaNettoPaliwoInne(paliwoInneFX.getcenaNettoPaliwoInneTextField());
        paliwoInne1.setIloscLitrowPaliwoInne(paliwoInneFX.getiloscLitrowPaliwoInneTextField());
        paliwoInne1.setReleaseDate(Utils.convertToDate(paliwoInneFX.getReleaseDate()));
        return paliwoInne1;
    }
    
    
   public static paliwoInneFX ConvertToPaliwoInneFX(paliwoInne paliwoInne){
        paliwoInneFX paliwoInne1FX = new paliwoInneFX();
        paliwoInne1FX.setId(paliwoInne.getId());
        paliwoInne1FX.setcenaNettoPaliwoInneTextField(paliwoInne.getCenaNettoPaliwoInne());
        paliwoInne1FX.setiloscLitrowPaliwoInneTextField(paliwoInne.getIloscLitrowPaliwoInne());
        paliwoInne1FX.setReleaseDate(Utils.convertToLocalDate(paliwoInne.getReleaseDate()));
        paliwoInne1FX.setPobierajacyInnneFX(ConverterPobierajacyInne.convertToPobierajacyFx(paliwoInne.getPobierajacy()));
        
        return paliwoInne1FX;
        
       
   }
}

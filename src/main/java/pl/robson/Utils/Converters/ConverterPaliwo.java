/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.robson.Utils.Converters;

import ModeleFX.PaliwoFX;
import ModeleFX.UbezpieczenieFX;
import pl.robson.Utils.Utils;
import pl.robson.database.modele.Paliwo;
import pl.robson.database.modele.Ubezpieczenie;

/**
 *
 * @author Mati
 */
public class ConverterPaliwo {
  

    public static PaliwoFX convertoToPaliwoFX(Paliwo paliwo){
        PaliwoFX paliwoFX = new PaliwoFX();
        paliwoFX.setId(paliwo.getId());
        paliwoFX.setDataDodania(Utils.convertToLocalDate(paliwo.getDataDodaniaPaliwa()));
        paliwoFX.setCenaZaLitr(paliwo.getCenazaLitr());
        paliwoFX.setIloscpaliwa(paliwo.getIloscPaliwa());
        paliwoFX.setPrzebieg(paliwo.getPrzebieg());
        return paliwoFX;   
    }

  public static Paliwo ConvertToPaliwo(PaliwoFX paliwoFX){
      Paliwo paliwo = new Paliwo();
      paliwo.setId(paliwoFX.getId());
      paliwo.setIloscPaliwa(paliwoFX.getIloscpaliwa());
      paliwo.setPrzebieg(paliwoFX.getPrzebieg());
      paliwo.setDataDodaniaPaliwa(Utils.convertToDate(paliwoFX.getDataDodania()));
      paliwo.setCenazaLitr(paliwoFX.getcenazaLitr());

      
      return paliwo;
  }
}


